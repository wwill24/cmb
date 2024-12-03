package okhttp3;

import java.io.IOException;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\rJ\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\u000bH&¨\u0006\u000e"}, d2 = {"Lokhttp3/e;", "", "Lokhttp3/y;", "g", "Lokhttp3/a0;", "f", "Lokhttp3/f;", "responseCallback", "", "P", "cancel", "", "m", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
public interface e extends Cloneable {

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lokhttp3/e$a;", "", "Lokhttp3/y;", "request", "Lokhttp3/e;", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
    public interface a {
        e a(y yVar);
    }

    void P(f fVar);

    void cancel();

    a0 f() throws IOException;

    y g();

    boolean m();
}
