package message;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Sendable<T>> {

    private Map<String, List<T>> mailBox = new HashMap<>();

    public MailService() {}

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    public void accept(Sendable<T> t) {
        mailBox.put(t.getTo(), Arrays.asList(t.getContent()));
    }
}
