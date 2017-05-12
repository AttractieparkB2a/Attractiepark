package B2a.domain.newsMessage;

public interface INewsMessage {
    void attach(IUser user);
    boolean notifyUsers();
}
