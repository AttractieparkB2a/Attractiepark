package B2a.domain.NewsMessage;

import java.util.List;

public interface INewsMessage {
    void attach(IMember member);
    List<String> notifyMembers();
}
