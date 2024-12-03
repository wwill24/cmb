package q3;

import androidx.annotation.NonNull;
import i3.d;
import i3.e;
import j3.j;
import java.io.InputStream;
import p3.g;
import p3.m;
import p3.n;
import p3.o;
import p3.r;

public class a implements n<g, InputStream> {

    /* renamed from: b  reason: collision with root package name */
    public static final d<Integer> f17122b = d.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: a  reason: collision with root package name */
    private final m<g, g> f17123a;

    /* renamed from: q3.a$a  reason: collision with other inner class name */
    public static class C0193a implements o<g, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final m<g, g> f17124a = new m<>(500);

        public void a() {
        }

        @NonNull
        public n<g, InputStream> c(r rVar) {
            return new a(this.f17124a);
        }
    }

    public a(m<g, g> mVar) {
        this.f17123a = mVar;
    }

    /* renamed from: c */
    public n.a<InputStream> b(@NonNull g gVar, int i10, int i11, @NonNull e eVar) {
        m<g, g> mVar = this.f17123a;
        if (mVar != null) {
            g a10 = mVar.a(gVar, 0, 0);
            if (a10 == null) {
                this.f17123a.b(gVar, 0, 0, gVar);
            } else {
                gVar = a10;
            }
        }
        return new n.a<>(gVar, new j(gVar, ((Integer) eVar.a(f17122b)).intValue()));
    }

    /* renamed from: d */
    public boolean a(@NonNull g gVar) {
        return true;
    }
}
