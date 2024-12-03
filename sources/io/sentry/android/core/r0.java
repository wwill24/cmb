package io.sentry.android.core;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.UUID;
import org.jivesoftware.smack.sm.packet.StreamManagement;

final class r0 {

    /* renamed from: a  reason: collision with root package name */
    static String f31100a;

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f31101b = Charset.forName("UTF-8");

    public static synchronized String a(Context context) throws RuntimeException {
        synchronized (r0.class) {
            if (f31100a == null) {
                File file = new File(context.getFilesDir(), "INSTALLATION");
                try {
                    if (!file.exists()) {
                        String c10 = c(file);
                        f31100a = c10;
                        return c10;
                    }
                    f31100a = b(file);
                } catch (Throwable th2) {
                    throw new RuntimeException(th2);
                }
            }
            String str = f31100a;
            return str;
        }
    }

    static String b(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, StreamManagement.AckRequest.ELEMENT);
        try {
            byte[] bArr = new byte[((int) randomAccessFile.length())];
            randomAccessFile.readFully(bArr);
            String str = new String(bArr, f31101b);
            randomAccessFile.close();
            return str;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    static String c(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            String uuid = UUID.randomUUID().toString();
            fileOutputStream.write(uuid.getBytes(f31101b));
            fileOutputStream.flush();
            fileOutputStream.close();
            return uuid;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }
}
