package ioStream;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<Byte> a = new ArrayList<>();

        try (DataInputStream dis = new DataInputStream(System.in)) {
            int b = dis.read();
            while (b != -1) {
                int c = dis.read();
                if (b != 13 || c != 10) {
                    a.add((byte) b);
                }
                b = c;
            }
        }

        try (DataOutputStream dos = new DataOutputStream(System.out)) {
            for (Byte d: a) {
                dos.write(d);
            }
        }

    }
}
