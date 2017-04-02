package B2a.service;

import B2a.domain.NewsMessage.NewsMessage;

import java.util.List;

public interface NewsMessageService {
    void findEmails(NewsMessage messageForm);
    void sendNewsLetter(List<String> email, String subject, String content);
}
