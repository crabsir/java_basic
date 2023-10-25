package stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.*;
import java.util.function.BiConsumer;

public class Streams {

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> (n * n) % 10000 / 10);
    }

    public static void main(String[] args) {
        pseudoRandomStream(13)
                .limit(10)
                .forEach(System.out::println);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<? extends T> a = stream.sorted(order).collect(Collectors.toList());
        if (a.isEmpty()) minMaxConsumer.accept(null, null);
        else minMaxConsumer.accept(a.get(0), a.get(a.size() - 1));

    }
}
