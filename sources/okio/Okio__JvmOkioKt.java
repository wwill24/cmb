package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0003\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0006\u001a\n\u0010\b\u001a\u00020\u0004*\u00020\u0006\u001a\u0016\u0010\f\u001a\u00020\u0001*\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007\u001a\n\u0010\r\u001a\u00020\u0004*\u00020\t\"\u001c\u0010\u0012\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011\"\u001c\u0010\u0017\u001a\u00020\n*\u00060\u0013j\u0002`\u00148@X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Ljava/io/OutputStream;", "Lokio/Sink;", "d", "Ljava/io/InputStream;", "Lokio/Source;", "h", "Ljava/net/Socket;", "e", "i", "Ljava/io/File;", "", "append", "c", "g", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "a", "Ljava/util/logging/Logger;", "logger", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "b", "(Ljava/lang/AssertionError;)Z", "isAndroidGetsocknameError", "okio"}, k = 5, mv = {1, 6, 0}, xs = "okio/Okio")
final /* synthetic */ class Okio__JvmOkioKt {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f33373a = Logger.getLogger("okio.Okio");

    public static final boolean b(AssertionError assertionError) {
        j.g(assertionError, "<this>");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? StringsKt__StringsKt.O(message, "getsockname failed", false, 2, (Object) null) : false;
    }

    public static final Sink c(File file, boolean z10) throws FileNotFoundException {
        j.g(file, "<this>");
        return Okio.f(new FileOutputStream(file, z10));
    }

    public static final Sink d(OutputStream outputStream) {
        j.g(outputStream, "<this>");
        return new OutputStreamSink(outputStream, new Timeout());
    }

    public static final Sink e(Socket socket) throws IOException {
        j.g(socket, "<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        j.f(outputStream, "getOutputStream()");
        return socketAsyncTimeout.y(new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    public static /* synthetic */ Sink f(File file, boolean z10, int i10, Object obj) throws FileNotFoundException {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return Okio.e(file, z10);
    }

    public static final Source g(File file) throws FileNotFoundException {
        j.g(file, "<this>");
        return new InputStreamSource(new FileInputStream(file), Timeout.f33430e);
    }

    public static final Source h(InputStream inputStream) {
        j.g(inputStream, "<this>");
        return new InputStreamSource(inputStream, new Timeout());
    }

    public static final Source i(Socket socket) throws IOException {
        j.g(socket, "<this>");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        j.f(inputStream, "getInputStream()");
        return socketAsyncTimeout.z(new InputStreamSource(inputStream, socketAsyncTimeout));
    }
}
