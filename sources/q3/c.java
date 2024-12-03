package q3;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import e4.d;
import i3.e;
import java.io.InputStream;
import k3.b;
import p3.n;
import p3.o;
import p3.r;

public class c implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17127a;

    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f17128a;

        public a(Context context) {
            this.f17128a = context;
        }

        public void a() {
        }

        @NonNull
        public n<Uri, InputStream> c(r rVar) {
            return new c(this.f17128a);
        }
    }

    public c(Context context) {
        this.f17127a = context.getApplicationContext();
    }

    /* renamed from: c */
    public n.a<InputStream> b(@NonNull Uri uri, int i10, int i11, @NonNull e eVar) {
        if (b.d(i10, i11)) {
            return new n.a<>(new d(uri), k3.c.f(this.f17127a, uri));
        }
        return null;
    }

    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return b.a(uri);
    }
}
