package B2a.service;

import java.util.List;

public interface NewsMessageService {
    void sendNewsLetter(List<String> email, String subject, String content);
}
