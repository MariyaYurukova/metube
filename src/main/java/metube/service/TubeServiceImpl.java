package metube.service;

import metube.domain.entities.Tube;
import metube.domain.models.service.TubeServiceModel;
import metube.domain.models.view.TubeThumbnailViewModel;
import metube.repository.TubeRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;


public class TubeServiceImpl implements TubeService  {


    private final UserService userService;
    private final ModelMapper modelMapper;
    private final TubeRepository tubeRepository;
    private final EntityManager entityManager;



    @Inject
    public TubeServiceImpl(UserService userService, TubeRepository tubeRepository, ModelMapper modelMapper, EntityManager entityManager) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.tubeRepository = tubeRepository;
        this.entityManager = entityManager;
    }



    @Override
    public boolean uploadTube(TubeServiceModel tubeServiceModel) {
        tubeServiceModel
                .setUploader(this.userService.findUserByUsername(tubeServiceModel.getUploader().getUsername()));
        try {
            this.tubeRepository.update(this.modelMapper.map(tubeServiceModel, Tube.class));

        } catch (Exception e) {
            return false;
        }
        return true;
    }







    @Override
    public TubeServiceModel findTubeById(String id) {
        Tube tube = this.tubeRepository.findById(id);

        if (tube == null) {
            throw new IllegalArgumentException();
        }

        return this.modelMapper.map(tube, TubeServiceModel.class);
    }





          //      .map(t -> modelMapper.map(t, clazz))

    @Override
    public final  List<TubeThumbnailViewModel> findAllTubes(Class<TubeThumbnailViewModel> clazz) {
        return entityManager.createQuery("SELECT t FROM Tube t", Tube.class)
                .getResultList()
                .stream()
                .map(tube -> modelMapper.map(tube, TubeThumbnailViewModel.class))
                .collect(Collectors.toList());
    }



    }


