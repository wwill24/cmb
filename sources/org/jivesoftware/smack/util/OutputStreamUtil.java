package org.jivesoftware.smack.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamUtil {
    public static void writeByteSafe(OutputStream outputStream, int i10, String str) throws IOException {
        if (i10 < 0 || i10 > 255) {
            throw new IOException(str + ". The value " + i10 + " is not within the allowed range for bytes");
        }
        outputStream.write(i10);
    }

    public static void writeResetAndFlush(ByteArrayOutputStream byteArrayOutputStream, OutputStream outputStream) throws IOException {
        byteArrayOutputStream.writeTo(outputStream);
        byteArrayOutputStream.reset();
        outputStream.flush();
    }
}
