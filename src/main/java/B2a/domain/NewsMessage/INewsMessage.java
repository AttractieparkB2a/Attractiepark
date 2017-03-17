package B2a.domain.NewsMessage;

import java.util.List;

public interface INewsMessage {
    void attach(IUser user);
    List<String> notifyUsers();
}
