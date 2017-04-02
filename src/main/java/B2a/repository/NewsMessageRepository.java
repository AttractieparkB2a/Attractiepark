package B2a.repository;

import B2a.domain.NewsMessage.NewsMessage;
import org.springframework.data.repository.CrudRepository;

public interface NewsMessageRepository extends CrudRepository<NewsMessage, Long> {
}
