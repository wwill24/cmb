package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lokio/SocketAsyncTimeout;", "Lokio/AsyncTimeout;", "Ljava/io/IOException;", "cause", "w", "", "A", "Ljava/net/Socket;", "m", "Ljava/net/Socket;", "socket", "<init>", "(Ljava/net/Socket;)V", "okio"}, k = 1, mv = {1, 6, 0})
final class SocketAsyncTimeout extends AsyncTimeout {

    /* renamed from: m  reason: collision with root package name */
    private final Socket f33422m;

    public SocketAsyncTimeout(Socket socket) {
        j.g(socket, "socket");
        this.f33422m = socket;
    }

    /* access modifiers changed from: protected */
    public void A() {
        try {
            this.f33422m.close();
        } catch (Exception e10) {
            Logger a10 = Okio__JvmOkioKt.f33373a;
            Level level = Level.WARNING;
            a10.log(level, "Failed to close timed out socket " + this.f33422m, e10);
        } catch (AssertionError e11) {
            if (Okio.d(e11)) {
                Logger a11 = Okio__JvmOkioKt.f33373a;
                Level level2 = Level.WARNING;
                a11.log(level2, "Failed to close timed out socket " + this.f33422m, e11);
                return;
            }
            throw e11;
        }
    }

    /* access modifiers changed from: protected */
    public IOException w(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
