package message;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MailService<T> implements Consumer<Sendable<T>> {

    private final Map<String, List<T>> mailBox = new HashMap<String, List<T>>() {
        @Override
        public List<T> get(Object key) {
            return super.getOrDefault(key, Collections.emptyList());
        }
    };

    public MailService() {}

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Sendable<T> t) {
        mailBox.merge(t.getTo(), Arrays.asList(t.getContent()),
                (x, y) -> Stream.concat(x.stream(), y.stream()).collect(Collectors.toList()));
    }
}
