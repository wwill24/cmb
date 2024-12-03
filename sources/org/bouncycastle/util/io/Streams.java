package org.bouncycastle.util.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class Streams {
    private static int BUFFER_SIZE = 4096;

    public static void drain(InputStream inputStream) throws IOException {
        int i10 = BUFFER_SIZE;
        do {
        } while (inputStream.read(new byte[i10], 0, i10) >= 0);
    }

    public static void pipeAll(InputStream inputStream, OutputStream outputStream) throws IOException {
        int i10 = BUFFER_SIZE;
        byte[] bArr = new byte[i10];
        while (true) {
            int read = inputStream.read(bArr, 0, i10);
            if (read >= 0) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static long pipeAllLimited(InputStream inputStream, long j10, OutputStream outputStream) throws IOException {
        int i10 = BUFFER_SIZE;
        byte[] bArr = new byte[i10];
        long j11 = 0;
        while (true) {
            int read = inputStream.read(bArr, 0, i10);
            if (read < 0) {
                return j11;
            }
            long j12 = (long) read;
            if (j10 - j11 >= j12) {
                j11 += j12;
                outputStream.write(bArr, 0, read);
            } else {
                throw new StreamOverflowException("Data Overflow");
            }
        }
    }

    public static byte[] readAll(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        pipeAll(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] readAllLimited(InputStream inputStream, int i10) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        pipeAllLimited(inputStream, (long) i10, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static int readFully(InputStream inputStream, byte[] bArr) throws IOException {
        return readFully(inputStream, bArr, 0, bArr.length);
    }

    public static int readFully(InputStream inputStream, byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        while (i12 < i11) {
            int read = inputStream.read(bArr, i10 + i12, i11 - i12);
            if (read < 0) {
                break;
            }
            i12 += read;
        }
        return i12;
    }

    public static void writeBufTo(ByteArrayOutputStream byteArrayOutputStream, OutputStream outputStream) throws IOException {
        byteArrayOutputStream.writeTo(outputStream);
    }
}
