package collection;

import java.util.HashSet;
import java.util.Set;

public class Symmetry {

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> i = new HashSet<>(set1);
        i.retainAll(set2);

        Set<T> u = new HashSet<>(set2);
        u.addAll(set1);

        u.removeAll(i);

        return u;
    }

}
