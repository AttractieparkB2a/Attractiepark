package B2a.repository;

import B2a.domain.Attraction.Attraction;
import org.springframework.data.repository.CrudRepository;

public interface AttractionRepository extends CrudRepository<Attraction, Long> {
}
