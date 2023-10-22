package ioStream;

import java.io.*;

public class IOStream {

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int s = 0;
        int i = inputStream.read();
        while (i != -1) {
            s = Integer.rotateLeft(s, 1) ^ i;
            i = inputStream.read();
        }
        return s;
    }

}
