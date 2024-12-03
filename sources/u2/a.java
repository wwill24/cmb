package u2;

import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public abstract class a<K, A> {

    /* renamed from: a  reason: collision with root package name */
    final List<b> f17949a = new ArrayList(1);

    /* renamed from: b  reason: collision with root package name */
    private boolean f17950b = false;

    /* renamed from: c  reason: collision with root package name */
    private final d<K> f17951c;

    /* renamed from: d  reason: collision with root package name */
    protected float f17952d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    protected d3.c<A> f17953e;

    /* renamed from: f  reason: collision with root package name */
    private A f17954f = null;

    /* renamed from: g  reason: collision with root package name */
    private float f17955g = -1.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f17956h = -1.0f;

    public interface b {
        void a();
    }

    private static final class c<T> implements d<T> {
        private c() {
        }

        public boolean a(float f10) {
            throw new IllegalStateException("not implemented");
        }

        public d3.a<T> b() {
            throw new IllegalStateException("not implemented");
        }

        public boolean c(float f10) {
            return false;
        }

        public float d() {
            return 0.0f;
        }

        public float e() {
            return 1.0f;
        }

        public boolean isEmpty() {
            return true;
        }
    }

    private interface d<T> {
        boolean a(float f10);

        d3.a<T> b();

        boolean c(float f10);

        float d();

        float e();

        boolean isEmpty();
    }

    private static final class e<T> implements d<T> {

        /* renamed from: a  reason: collision with root package name */
        private final List<? extends d3.a<T>> f17957a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private d3.a<T> f17958b;

        /* renamed from: c  reason: collision with root package name */
        private d3.a<T> f17959c = null;

        /* renamed from: d  reason: collision with root package name */
        private float f17960d = -1.0f;

        e(List<? extends d3.a<T>> list) {
            this.f17957a = list;
            this.f17958b = f(0.0f);
        }

        private d3.a<T> f(float f10) {
            List<? extends d3.a<T>> list = this.f17957a;
            d3.a<T> aVar = (d3.a) list.get(list.size() - 1);
            if (f10 >= aVar.f()) {
                return aVar;
            }
            for (int size = this.f17957a.size() - 2; size >= 1; size--) {
                d3.a<T> aVar2 = (d3.a) this.f17957a.get(size);
                if (this.f17958b != aVar2 && aVar2.a(f10)) {
                    return aVar2;
                }
            }
            return (d3.a) this.f17957a.get(0);
        }

        public boolean a(float f10) {
            d3.a<T> aVar = this.f17959c;
            d3.a<T> aVar2 = this.f17958b;
            if (aVar == aVar2 && this.f17960d == f10) {
                return true;
            }
            this.f17959c = aVar2;
            this.f17960d = f10;
            return false;
        }

        @NonNull
        public d3.a<T> b() {
            return this.f17958b;
        }

        public boolean c(float f10) {
            if (this.f17958b.a(f10)) {
                return !this.f17958b.i();
            }
            this.f17958b = f(f10);
            return true;
        }

        public float d() {
            return ((d3.a) this.f17957a.get(0)).f();
        }

        public float e() {
            List<? extends d3.a<T>> list = this.f17957a;
            return ((d3.a) list.get(list.size() - 1)).c();
        }

        public boolean isEmpty() {
            return false;
        }
    }

    private static final class f<T> implements d<T> {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final d3.a<T> f17961a;

        /* renamed from: b  reason: collision with root package name */
        private float f17962b = -1.0f;

        f(List<? extends d3.a<T>> list) {
            this.f17961a = (d3.a) list.get(0);
        }

        public boolean a(float f10) {
            if (this.f17962b == f10) {
                return true;
            }
            this.f17962b = f10;
            return false;
        }

        public d3.a<T> b() {
            return this.f17961a;
        }

        public boolean c(float f10) {
            return !this.f17961a.i();
        }

        public float d() {
            return this.f17961a.f();
        }

        public float e() {
            return this.f17961a.c();
        }

        public boolean isEmpty() {
            return false;
        }
    }

    a(List<? extends d3.a<K>> list) {
        this.f17951c = o(list);
    }

    private float g() {
        if (this.f17955g == -1.0f) {
            this.f17955g = this.f17951c.d();
        }
        return this.f17955g;
    }

    private static <T> d<T> o(List<? extends d3.a<T>> list) {
        if (list.isEmpty()) {
            return new c();
        }
        if (list.size() == 1) {
            return new f(list);
        }
        return new e(list);
    }

    public void a(b bVar) {
        this.f17949a.add(bVar);
    }

    /* access modifiers changed from: protected */
    public d3.a<K> b() {
        com.airbnb.lottie.c.a("BaseKeyframeAnimation#getCurrentKeyframe");
        d3.a<K> b10 = this.f17951c.b();
        com.airbnb.lottie.c.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return b10;
    }

    /* access modifiers changed from: package-private */
    public float c() {
        if (this.f17956h == -1.0f) {
            this.f17956h = this.f17951c.e();
        }
        return this.f17956h;
    }

    /* access modifiers changed from: protected */
    public float d() {
        d3.a b10 = b();
        if (b10 == null || b10.i()) {
            return 0.0f;
        }
        return b10.f14408d.getInterpolation(e());
    }

    /* access modifiers changed from: package-private */
    public float e() {
        if (this.f17950b) {
            return 0.0f;
        }
        d3.a b10 = b();
        if (b10.i()) {
            return 0.0f;
        }
        return (this.f17952d - b10.f()) / (b10.c() - b10.f());
    }

    public float f() {
        return this.f17952d;
    }

    public A h() {
        A a10;
        float e10 = e();
        if (this.f17953e == null && this.f17951c.a(e10)) {
            return this.f17954f;
        }
        d3.a b10 = b();
        Interpolator interpolator = b10.f14409e;
        if (interpolator == null || b10.f14410f == null) {
            a10 = i(b10, d());
        } else {
            a10 = j(b10, e10, interpolator.getInterpolation(e10), b10.f14410f.getInterpolation(e10));
        }
        this.f17954f = a10;
        return a10;
    }

    /* access modifiers changed from: package-private */
    public abstract A i(d3.a<K> aVar, float f10);

    /* access modifiers changed from: protected */
    public A j(d3.a<K> aVar, float f10, float f11, float f12) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void k() {
        for (int i10 = 0; i10 < this.f17949a.size(); i10++) {
            this.f17949a.get(i10).a();
        }
    }

    public void l() {
        this.f17950b = true;
    }

    public void m(float f10) {
        if (!this.f17951c.isEmpty()) {
            if (f10 < g()) {
                f10 = g();
            } else if (f10 > c()) {
                f10 = c();
            }
            if (f10 != this.f17952d) {
                this.f17952d = f10;
                if (this.f17951c.c(f10)) {
                    k();
                }
            }
        }
    }

    public void n(d3.c<A> cVar) {
        d3.c<A> cVar2 = this.f17953e;
        if (cVar2 != null) {
            cVar2.c((a<?, ?>) null);
        }
        this.f17953e = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}
