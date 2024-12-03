package q3;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import i3.e;
import java.io.InputStream;
import k3.b;
import k3.c;
import p3.n;
import p3.o;
import p3.r;
import s3.w;

public class d implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17129a;

    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f17130a;

        public a(Context context) {
            this.f17130a = context;
        }

        public void a() {
        }

        @NonNull
        public n<Uri, InputStream> c(r rVar) {
            return new d(this.f17130a);
        }
    }

    public d(Context context) {
        this.f17129a = context.getApplicationContext();
    }

    private boolean e(e eVar) {
        Long l10 = (Long) eVar.a(w.f17470d);
        if (l10 == null || l10.longValue() != -1) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public n.a<InputStream> b(@NonNull Uri uri, int i10, int i11, @NonNull e eVar) {
        if (!b.d(i10, i11) || !e(eVar)) {
            return null;
        }
        return new n.a<>(new e4.d(uri), c.g(this.f17129a, uri));
    }

    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return b.c(uri);
    }
}
