package collection;

import java.io.*;
import java.util.*;

public class Collection {

    public static void main(String[] args) throws IOException {
        List<Integer> a = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Scanner scanner = new Scanner(reader.readLine());
            while (scanner.hasNext()) a.add(Integer.parseInt(scanner.next()));
        } catch (NullPointerException ignored) {}

        try (Writer writer = new OutputStreamWriter(System.out)) {
            for (int i = a.size() - 1; i > -1; i--)
                if (i % 2 == 1) writer.write(a.get(i).toString() + " ");
        }
    }
}
