package metube.service;

import metube.domain.entities.Tube;
import metube.domain.models.service.TubeServiceModel;
import metube.domain.models.view.TubeThumbnailViewModel;

import java.util.List;

public interface TubeService  {

    boolean uploadTube(TubeServiceModel tubeServiceModel);

    TubeServiceModel findTubeById(String id);

    List<TubeThumbnailViewModel> findAllTubes(Class<TubeThumbnailViewModel> clazz);

  
}
