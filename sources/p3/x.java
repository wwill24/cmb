package p3;

import android.net.Uri;
import androidx.annotation.NonNull;
import i3.e;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p3.n;

public class x<Data> implements n<Uri, Data> {

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f16997b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));

    /* renamed from: a  reason: collision with root package name */
    private final n<g, Data> f16998a;

    public static class a implements o<Uri, InputStream> {
        public void a() {
        }

        @NonNull
        public n<Uri, InputStream> c(r rVar) {
            return new x(rVar.d(g.class, InputStream.class));
        }
    }

    public x(n<g, Data> nVar) {
        this.f16998a = nVar;
    }

    /* renamed from: c */
    public n.a<Data> b(@NonNull Uri uri, int i10, int i11, @NonNull e eVar) {
        return this.f16998a.b(new g(uri.toString()), i10, i11, eVar);
    }

    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return f16997b.contains(uri.getScheme());
    }
}
