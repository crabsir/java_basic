package message;

import java.util.List;
import java.util.Map;

public class MailService<T> {

    private Map<String, List<T>> mailBox;

    public MailService() {}

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

}
