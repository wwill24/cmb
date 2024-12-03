package e1;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.n0;
import e1.a;
import e1.b;
import java.util.ArrayList;

public abstract class b<T extends b<T>> implements a.b {

    /* renamed from: m  reason: collision with root package name */
    public static final r f14525m = new f("translationX");

    /* renamed from: n  reason: collision with root package name */
    public static final r f14526n = new g("translationY");

    /* renamed from: o  reason: collision with root package name */
    public static final r f14527o = new h("translationZ");

    /* renamed from: p  reason: collision with root package name */
    public static final r f14528p = new i("scaleX");

    /* renamed from: q  reason: collision with root package name */
    public static final r f14529q = new j("scaleY");

    /* renamed from: r  reason: collision with root package name */
    public static final r f14530r = new k("rotation");

    /* renamed from: s  reason: collision with root package name */
    public static final r f14531s = new l("rotationX");

    /* renamed from: t  reason: collision with root package name */
    public static final r f14532t = new m("rotationY");

    /* renamed from: u  reason: collision with root package name */
    public static final r f14533u = new n("x");

    /* renamed from: v  reason: collision with root package name */
    public static final r f14534v = new a("y");

    /* renamed from: w  reason: collision with root package name */
    public static final r f14535w = new C0156b("z");

    /* renamed from: x  reason: collision with root package name */
    public static final r f14536x = new c("alpha");

    /* renamed from: y  reason: collision with root package name */
    public static final r f14537y = new d("scrollX");

    /* renamed from: z  reason: collision with root package name */
    public static final r f14538z = new e("scrollY");

    /* renamed from: a  reason: collision with root package name */
    float f14539a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    float f14540b = Float.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    boolean f14541c = false;

    /* renamed from: d  reason: collision with root package name */
    final Object f14542d;

    /* renamed from: e  reason: collision with root package name */
    final c f14543e;

    /* renamed from: f  reason: collision with root package name */
    boolean f14544f = false;

    /* renamed from: g  reason: collision with root package name */
    float f14545g = Float.MAX_VALUE;

    /* renamed from: h  reason: collision with root package name */
    float f14546h = (-Float.MAX_VALUE);

    /* renamed from: i  reason: collision with root package name */
    private long f14547i = 0;

    /* renamed from: j  reason: collision with root package name */
    private float f14548j;

    /* renamed from: k  reason: collision with root package name */
    private final ArrayList<p> f14549k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    private final ArrayList<q> f14550l = new ArrayList<>();

    static class a extends r {
        a(String str) {
            super(str, (f) null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getY();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setY(f10);
        }
    }

    /* renamed from: e1.b$b  reason: collision with other inner class name */
    static class C0156b extends r {
        C0156b(String str) {
            super(str, (f) null);
        }

        /* renamed from: c */
        public float a(View view) {
            return n0.P(view);
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            n0.Q0(view, f10);
        }
    }

    static class c extends r {
        c(String str) {
            super(str, (f) null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getAlpha();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setAlpha(f10);
        }
    }

    static class d extends r {
        d(String str) {
            super(str, (f) null);
        }

        /* renamed from: c */
        public float a(View view) {
            return (float) view.getScrollX();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setScrollX((int) f10);
        }
    }

    static class e extends r {
        e(String str) {
            super(str, (f) null);
        }

        /* renamed from: c */
        public float a(View view) {
            return (float) view.getScrollY();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setScrollY((int) f10);
        }
    }

    static class f extends r {
        f(String str) {
            super(str, (f) null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getTranslationX();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setTranslationX(f10);
        }
    }

    static class g extends r {
        g(String str) {
            super(str, (f) null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getTranslationY();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setTranslationY(f10);
        }
    }

    static class h extends r {
        h(String str) {
            super(str, (f) null);
        }

        /* renamed from: c */
        public float a(View view) {
            return n0.M(view);
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            n0.O0(view, f10);
        }
    }

    static class i extends r {
        i(String str) {
            super(str, (f) null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getScaleX();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setScaleX(f10);
        }
    }

    static class j extends r {
        j(String str) {
            super(str, (f) null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getScaleY();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setScaleY(f10);
        }
    }

    static class k extends r {
        k(String str) {
            super(str, (f) null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getRotation();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setRotation(f10);
        }
    }

    static class l extends r {
        l(String str) {
            super(str, (f) null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getRotationX();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setRotationX(f10);
        }
    }

    static class m extends r {
        m(String str) {
            super(str, (f) null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getRotationY();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setRotationY(f10);
        }
    }

    static class n extends r {
        n(String str) {
            super(str, (f) null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getX();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setX(f10);
        }
    }

    static class o {

        /* renamed from: a  reason: collision with root package name */
        float f14551a;

        /* renamed from: b  reason: collision with root package name */
        float f14552b;

        o() {
        }
    }

    public interface p {
        void a(b bVar, boolean z10, float f10, float f11);
    }

    public interface q {
        void a(b bVar, float f10, float f11);
    }

    public static abstract class r extends c<View> {
        /* synthetic */ r(String str, f fVar) {
            this(str);
        }

        private r(String str) {
            super(str);
        }
    }

    <K> b(K k10, c<K> cVar) {
        this.f14542d = k10;
        this.f14543e = cVar;
        if (cVar == f14530r || cVar == f14531s || cVar == f14532t) {
            this.f14548j = 0.1f;
        } else if (cVar == f14536x) {
            this.f14548j = 0.00390625f;
        } else if (cVar == f14528p || cVar == f14529q) {
            this.f14548j = 0.00390625f;
        } else {
            this.f14548j = 1.0f;
        }
    }

    private void b(boolean z10) {
        this.f14544f = false;
        a.d().g(this);
        this.f14547i = 0;
        this.f14541c = false;
        for (int i10 = 0; i10 < this.f14549k.size(); i10++) {
            if (this.f14549k.get(i10) != null) {
                this.f14549k.get(i10).a(this, z10, this.f14540b, this.f14539a);
            }
        }
        f(this.f14549k);
    }

    private float c() {
        return this.f14543e.a(this.f14542d);
    }

    private static <T> void f(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void j() {
        if (!this.f14544f) {
            this.f14544f = true;
            if (!this.f14541c) {
                this.f14540b = c();
            }
            float f10 = this.f14540b;
            if (f10 > this.f14545g || f10 < this.f14546h) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
            a.d().a(this, 0);
        }
    }

    public boolean a(long j10) {
        long j11 = this.f14547i;
        if (j11 == 0) {
            this.f14547i = j10;
            g(this.f14540b);
            return false;
        }
        this.f14547i = j10;
        boolean k10 = k(j10 - j11);
        float min = Math.min(this.f14540b, this.f14545g);
        this.f14540b = min;
        float max = Math.max(min, this.f14546h);
        this.f14540b = max;
        g(max);
        if (k10) {
            b(false);
        }
        return k10;
    }

    /* access modifiers changed from: package-private */
    public float d() {
        return this.f14548j * 0.75f;
    }

    public boolean e() {
        return this.f14544f;
    }

    /* access modifiers changed from: package-private */
    public void g(float f10) {
        this.f14543e.b(this.f14542d, f10);
        for (int i10 = 0; i10 < this.f14550l.size(); i10++) {
            if (this.f14550l.get(i10) != null) {
                this.f14550l.get(i10).a(this, this.f14540b, this.f14539a);
            }
        }
        f(this.f14550l);
    }

    public T h(float f10) {
        this.f14540b = f10;
        this.f14541c = true;
        return this;
    }

    public void i() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (!this.f14544f) {
            j();
        }
    }

    /* access modifiers changed from: package-private */
    public abstract boolean k(long j10);
}
