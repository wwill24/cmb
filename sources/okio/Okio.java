package okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import kotlin.Metadata;

@Metadata(d1 = {"okio/Okio__JvmOkioKt", "okio/Okio__OkioKt"}, k = 4, mv = {1, 6, 0}, xi = 48)
public final class Okio {
    public static final Sink a() {
        return Okio__OkioKt.a();
    }

    public static final BufferedSink b(Sink sink) {
        return Okio__OkioKt.b(sink);
    }

    public static final BufferedSource c(Source source) {
        return Okio__OkioKt.c(source);
    }

    public static final boolean d(AssertionError assertionError) {
        return Okio__JvmOkioKt.b(assertionError);
    }

    public static final Sink e(File file, boolean z10) throws FileNotFoundException {
        return Okio__JvmOkioKt.c(file, z10);
    }

    public static final Sink f(OutputStream outputStream) {
        return Okio__JvmOkioKt.d(outputStream);
    }

    public static final Sink g(Socket socket) throws IOException {
        return Okio__JvmOkioKt.e(socket);
    }

    public static final Source i(File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.g(file);
    }

    public static final Source j(InputStream inputStream) {
        return Okio__JvmOkioKt.h(inputStream);
    }

    public static final Source k(Socket socket) throws IOException {
        return Okio__JvmOkioKt.i(socket);
    }
}
