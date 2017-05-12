package B2a.service;

import B2a.domain.Subscriber;
import B2a.domain.User;
import B2a.domain.newsMessage.NewsMessage;
import B2a.repository.NewsMessageRepository;
import B2a.repository.SubscriberRepository;
import B2a.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsMessageServiceImpl implements NewsMessageService {

    private UserRepository userRepository;
    private SubscriberRepository subscriberRepository;
    private NewsMessageRepository newsMessageRepository;

    @Autowired
    private NewsMessageServiceImpl(UserRepository userRepository, SubscriberRepository subscriberRepository, NewsMessageRepository newsMessageRepository) {
        this.userRepository = userRepository;
        this.subscriberRepository = subscriberRepository;
        this.newsMessageRepository = newsMessageRepository;
    }

    @Override
    public void save(NewsMessage newsMessage) {
        newsMessageRepository.save(newsMessage);
    }

    @Override
    public void delete(Long id) {
        newsMessageRepository.delete(id);
    }

    @Override
    public NewsMessage findOne(Long id) {
        return newsMessageRepository.findOne(id);
    }

    @Override
    public Iterable<NewsMessage> findAll() {
        return newsMessageRepository.findAll();
    }

    @Override
    public void findEmails(NewsMessage messageForm) {

        List<User> users = userRepository.findByNewsletter(true);
        Iterable<Subscriber> subscribers = subscriberRepository.findAll();

        List<User> user = new ArrayList<>();
        List<Subscriber> subscriber = new ArrayList<>();

        String subject = messageForm.getSubject();
        String content = messageForm.getMessage();

        NewsMessage newsMessage = new NewsMessage(subject, content);

        for(User u : users) {
            if (u.isNewsletter()) {
                newsMessage.attach(u);
                user.add(u);
            }
        }

        for(Subscriber s : subscribers) {
            newsMessage.attach(s);
            subscriber.add(s);
        }

        if(newsMessage.notifyUsers()) {
            newsMessage.setUser(user);
            newsMessage.setSubscribers(subscriber);

            newsMessageRepository.save(newsMessage);
        }
    }
}
