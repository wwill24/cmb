package okhttp3;

import java.io.IOException;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0001\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0007"}, d2 = {"Lokhttp3/u;", "", "Lokhttp3/u$a;", "chain", "Lokhttp3/a0;", "intercept", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
public interface u {

    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\n\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lokhttp3/u$a;", "", "Lokhttp3/y;", "g", "request", "Lokhttp3/a0;", "a", "Lokhttp3/i;", "b", "Lokhttp3/e;", "call", "okhttp"}, k = 1, mv = {1, 6, 0})
    public interface a {
        a0 a(y yVar) throws IOException;

        i b();

        e call();

        y g();
    }

    a0 intercept(a aVar) throws IOException;
}
