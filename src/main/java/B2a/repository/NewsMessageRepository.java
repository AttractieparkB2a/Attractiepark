package B2a.repository;

import B2a.domain.newsMessage.NewsMessage;
import org.springframework.data.repository.CrudRepository;

public interface NewsMessageRepository extends CrudRepository<NewsMessage, Long> {
}
