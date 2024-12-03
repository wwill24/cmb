package ed;

import android.content.Context;
import java.io.Closeable;
import java.io.IOException;
import md.d;

abstract class v implements Closeable {

    interface a {
        a a(Context context);

        v build();
    }

    v() {
    }

    /* access modifiers changed from: package-private */
    public abstract d a();

    /* access modifiers changed from: package-private */
    public abstract u b();

    public void close() throws IOException {
        a().close();
    }
}
