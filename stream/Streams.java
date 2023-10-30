package stream;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.*;
import java.util.function.BiConsumer;

public class Streams {

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> (n * n) % 10000 / 10);
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
            Arrays.stream(reader.readLine().toLowerCase().split("[^\\p{L}0-9]"))
                    .filter(x -> !x.isEmpty())
                    .collect(Collectors.toMap(x -> x, x -> 1L, Long::sum))
                    .entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .sorted(Collections.reverseOrder(Comparator.comparingLong(x -> x.getValue())))
                    .limit(10)
                    .forEach(x -> System.out.println(x.getKey()));
        }

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
