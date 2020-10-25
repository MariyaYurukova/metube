package metube.repository;

import metube.domain.entities.Tube;
import metube.domain.models.view.TubeThumbnailViewModel;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class TubeRepositoryImpl implements TubeRepository  {

    private final EntityManager entityManager;
    private final ModelMapper modelMapper;


    @Inject
    public TubeRepositoryImpl(EntityManager entityManager, ModelMapper modelMapper) {
        this.entityManager = entityManager;
        this.modelMapper = modelMapper;
    }

    @Override
    public Tube save(Tube entity) {
        this.entityManager.clear();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public List<Tube> findAll() {
        this.entityManager.getTransaction().begin();
        List<Tube> allTubes = this.entityManager
                .createQuery("SELECT t FROM Tube t", Tube.class)
                .getResultList();
        this.entityManager.getTransaction().commit();

        return allTubes;
    }

    @Override
    public Tube findById(String id) {
//        this.entityManager.getTransaction().begin();
        Tube tube = this.entityManager
                .createQuery("SELECT t FROM Tube t WHERE t.id = :id", Tube.class)
                .setParameter("id", id)
                .getSingleResult();
//        this.entityManager.getTransaction().commit();

        return tube;
    }

    @Override
    public long size() {
        this.entityManager.getTransaction().begin();
        long size = this.entityManager
                .createQuery("SELECT count(t) FROM Tube t", long.class)
                .getSingleResult();
        this.entityManager.getTransaction().commit();

        return size;
    }

    @Override
    public Tube update(Tube tube) {
        this.entityManager.getTransaction().begin();
        Tube mergedTube = this.entityManager.merge(tube);
        this.entityManager.getTransaction().commit();
        return mergedTube;
    }








}