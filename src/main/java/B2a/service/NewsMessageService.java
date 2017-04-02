package B2a.service;

import B2a.domain.newsMessage.NewsMessage;

import java.util.List;

public interface NewsMessageService {
    void findEmails(NewsMessage messageForm);
    void sendNewsLetter(List<String> email, String subject, String content);
}
