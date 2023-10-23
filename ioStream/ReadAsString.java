package ioStream;

import java.io.*;
import java.nio.charset.Charset;

public class ReadAsString {
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        byte[] buffer = new byte[4096];
        int l;

        try (BufferedInputStream bis = new BufferedInputStream(inputStream)) {
            l = bis.read(buffer);
        }

        return l != -1 ? new String(buffer, 0, l, charset) : "";
    }
}
