package metube.repository;


import metube.domain.entities.Identifiable;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<E extends Identifiable<I>, I> {



    List<E> all();

}