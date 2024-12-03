package fl;

import java.io.IOException;
import kotlin.Metadata;
import okhttp3.a0;
import okhttp3.internal.connection.RealConnection;
import okhttp3.y;
import okio.Sink;
import okio.Source;

@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\bH&J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0015\u001a\u00020\bH&R\u0014\u0010\u0019\u001a\u00020\u00168&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lfl/d;", "", "Lokhttp3/y;", "request", "", "contentLength", "Lokio/Sink;", "d", "", "e", "g", "a", "", "expectContinue", "Lokhttp3/a0$a;", "f", "Lokhttp3/a0;", "response", "c", "Lokio/Source;", "b", "cancel", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "connection", "okhttp"}, k = 1, mv = {1, 6, 0})
public interface d {
    void a() throws IOException;

    Source b(a0 a0Var) throws IOException;

    long c(a0 a0Var) throws IOException;

    void cancel();

    Sink d(y yVar, long j10) throws IOException;

    void e(y yVar) throws IOException;

    a0.a f(boolean z10) throws IOException;

    void g() throws IOException;

    RealConnection getConnection();
}
