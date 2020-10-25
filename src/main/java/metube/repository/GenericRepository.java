package metube.repository;

import metube.domain.models.view.TubeThumbnailViewModel;

import java.util.List;

public interface GenericRepository<E, ID> {


    E save(E entity);



    List<E> findAll();



    E findById(ID id);

    long size();
}
