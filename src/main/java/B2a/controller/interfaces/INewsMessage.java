package B2a.controller.interfaces;

public interface INewsMessage {
    void attach(IMember member);
    void notifyMembers(String subject, String content);
}
