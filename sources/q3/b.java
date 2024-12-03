package q3;

import android.net.Uri;
import androidx.annotation.NonNull;
import i3.e;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p3.g;
import p3.n;
import p3.o;
import p3.r;

public class b implements n<Uri, InputStream> {

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f17125b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));

    /* renamed from: a  reason: collision with root package name */
    private final n<g, InputStream> f17126a;

    public static class a implements o<Uri, InputStream> {
        public void a() {
        }

        @NonNull
        public n<Uri, InputStream> c(r rVar) {
            return new b(rVar.d(g.class, InputStream.class));
        }
    }

    public b(n<g, InputStream> nVar) {
        this.f17126a = nVar;
    }

    /* renamed from: c */
    public n.a<InputStream> b(@NonNull Uri uri, int i10, int i11, @NonNull e eVar) {
        return this.f17126a.b(new g(uri.toString()), i10, i11, eVar);
    }

    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return f17125b.contains(uri.getScheme());
    }
}
