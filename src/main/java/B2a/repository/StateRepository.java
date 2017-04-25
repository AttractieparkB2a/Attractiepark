package B2a.repository;

import B2a.domain.attractionState.State;
import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State, Long> {
}
