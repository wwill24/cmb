package n3;

import androidx.annotation.NonNull;
import androidx.core.util.e;
import f4.g;
import f4.k;
import g4.a;
import g4.c;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private final g<i3.b, String> f16417a = new g<>(1000);

    /* renamed from: b  reason: collision with root package name */
    private final e<b> f16418b = g4.a.d(10, new a());

    class a implements a.d<b> {
        a() {
        }

        /* renamed from: a */
        public b create() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    private static final class b implements a.f {

        /* renamed from: a  reason: collision with root package name */
        final MessageDigest f16420a;

        /* renamed from: b  reason: collision with root package name */
        private final c f16421b = c.a();

        b(MessageDigest messageDigest) {
            this.f16420a = messageDigest;
        }

        @NonNull
        public c d() {
            return this.f16421b;
        }
    }

    private String a(i3.b bVar) {
        b bVar2 = (b) f4.j.d(this.f16418b.acquire());
        try {
            bVar.updateDiskCacheKey(bVar2.f16420a);
            return k.s(bVar2.f16420a.digest());
        } finally {
            this.f16418b.a(bVar2);
        }
    }

    public String b(i3.b bVar) {
        String g10;
        synchronized (this.f16417a) {
            g10 = this.f16417a.g(bVar);
        }
        if (g10 == null) {
            g10 = a(bVar);
        }
        synchronized (this.f16417a) {
            this.f16417a.k(bVar, g10);
        }
        return g10;
    }
}
