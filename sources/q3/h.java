package q3;

import androidx.annotation.NonNull;
import i3.e;
import java.io.InputStream;
import java.net.URL;
import p3.g;
import p3.n;
import p3.o;
import p3.r;

public class h implements n<URL, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final n<g, InputStream> f17148a;

    public static class a implements o<URL, InputStream> {
        public void a() {
        }

        @NonNull
        public n<URL, InputStream> c(r rVar) {
            return new h(rVar.d(g.class, InputStream.class));
        }
    }

    public h(n<g, InputStream> nVar) {
        this.f17148a = nVar;
    }

    /* renamed from: c */
    public n.a<InputStream> b(@NonNull URL url, int i10, int i11, @NonNull e eVar) {
        return this.f17148a.b(new g(url), i10, i11, eVar);
    }

    /* renamed from: d */
    public boolean a(@NonNull URL url) {
        return true;
    }
}
