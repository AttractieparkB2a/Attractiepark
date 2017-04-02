package B2a.domain.newsMessage;

import java.util.List;

public interface INewsMessage {
    void attach(IUser user);
    List<String> notifyUsers();
}
