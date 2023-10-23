package ioStream;

import java.io.*;
import java.util.Scanner;

public class Calculate {

    public static void main(String[] args) throws IOException {
        
        double d = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Scanner scanner = new Scanner(line);
                while (scanner.hasNext())
                    try {
                        d += Double.parseDouble(scanner.next());
                    } catch (NumberFormatException ignored) {}
            }
        }
        
        try (Writer writer = new OutputStreamWriter(System.out)) {
            writer.write(String.format("%.6f", d));
        }
    }

}
