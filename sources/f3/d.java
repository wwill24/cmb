package f3;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import org.jivesoftware.smack.util.StringUtils;

final class d {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f14701a = Charset.forName(StringUtils.USASCII);

    /* renamed from: b  reason: collision with root package name */
    static final Charset f14702b = Charset.forName("UTF-8");

    static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    static void b(File file) throws IOException {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            int i10 = 0;
            while (i10 < length) {
                File file2 = listFiles[i10];
                if (file2.isDirectory()) {
                    b(file2);
                }
                if (file2.delete()) {
                    i10++;
                } else {
                    throw new IOException("failed to delete file: " + file2);
                }
            }
            return;
        }
        throw new IOException("not a readable directory: " + file);
    }
}
