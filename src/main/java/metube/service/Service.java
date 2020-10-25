package metube.service;

import metube.domain.entities.Identifiable;
import metube.domain.models.view.TubeThumbnailViewModel;
import metube.domain.models.view.Viewable;

import java.util.List;

public interface Service<E extends Identifiable<I>, I> {

    List<TubeThumbnailViewModel> findAll(Class<TubeThumbnailViewModel> clazz);
}
