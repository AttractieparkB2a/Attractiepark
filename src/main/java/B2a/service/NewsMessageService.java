package B2a.service;

import B2a.domain.newsMessage.NewsMessage;

import java.util.List;

public interface NewsMessageService {
    void save(NewsMessage newsMessage);
    void delete(Long id);
    NewsMessage findOne(Long id);
    Iterable<NewsMessage> findAll();
    void findEmails(NewsMessage messageForm);
    void sendNewsLetter(List<String> email, String subject, String content);
}
