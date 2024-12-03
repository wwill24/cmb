package n;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.g1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class c extends g1<b> {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<b> f16347a = new ArrayList();

        a(List<b> list) {
            for (b add : list) {
                this.f16347a.add(add);
            }
        }

        public void a() {
            for (b a10 : this.f16347a) {
                a10.a();
            }
        }

        @NonNull
        public List<d0> b() {
            ArrayList arrayList = new ArrayList();
            for (b b10 : this.f16347a) {
                d0 b11 = b10.b();
                if (b11 != null) {
                    arrayList.add(b11);
                }
            }
            return arrayList;
        }

        @NonNull
        public List<d0> c() {
            ArrayList arrayList = new ArrayList();
            for (b c10 : this.f16347a) {
                d0 c11 = c10.c();
                if (c11 != null) {
                    arrayList.add(c11);
                }
            }
            return arrayList;
        }

        @NonNull
        public List<d0> d() {
            ArrayList arrayList = new ArrayList();
            for (b d10 : this.f16347a) {
                d0 d11 = d10.d();
                if (d11 != null) {
                    arrayList.add(d11);
                }
            }
            return arrayList;
        }

        @NonNull
        public List<d0> e() {
            ArrayList arrayList = new ArrayList();
            for (b e10 : this.f16347a) {
                d0 e11 = e10.e();
                if (e11 != null) {
                    arrayList.add(e11);
                }
            }
            return arrayList;
        }
    }

    public c(@NonNull b... bVarArr) {
        a(Arrays.asList(bVarArr));
    }

    @NonNull
    public static c e() {
        return new c(new b[0]);
    }

    @NonNull
    /* renamed from: b */
    public g1<b> clone() {
        c e10 = e();
        e10.a(c());
        return e10;
    }

    @NonNull
    public a d() {
        return new a(c());
    }
}
