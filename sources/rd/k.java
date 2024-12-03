package rd;

import android.annotation.TargetApi;
import com.google.android.gms.common.internal.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.f;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    private final n f41856a;

    /* renamed from: b  reason: collision with root package name */
    private final f f41857b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f41858c;

    /* renamed from: d  reason: collision with root package name */
    private long f41859d;

    /* renamed from: e  reason: collision with root package name */
    private long f41860e;

    /* renamed from: f  reason: collision with root package name */
    private long f41861f;

    /* renamed from: g  reason: collision with root package name */
    private long f41862g;

    /* renamed from: h  reason: collision with root package name */
    private long f41863h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f41864i;

    /* renamed from: j  reason: collision with root package name */
    private final Map<Class<? extends m>, m> f41865j;

    /* renamed from: k  reason: collision with root package name */
    private final List<w> f41866k;

    k(k kVar) {
        this.f41856a = kVar.f41856a;
        this.f41857b = kVar.f41857b;
        this.f41859d = kVar.f41859d;
        this.f41860e = kVar.f41860e;
        this.f41861f = kVar.f41861f;
        this.f41862g = kVar.f41862g;
        this.f41863h = kVar.f41863h;
        this.f41866k = new ArrayList(kVar.f41866k);
        this.f41865j = new HashMap(kVar.f41865j.size());
        for (Map.Entry next : kVar.f41865j.entrySet()) {
            m n10 = n((Class) next.getKey());
            ((m) next.getValue()).zzc(n10);
            this.f41865j.put((Class) next.getKey(), n10);
        }
    }

    @TargetApi(19)
    private static <T extends m> T n(Class<T> cls) {
        try {
            return (m) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e10) {
            if (e10 instanceof InstantiationException) {
                throw new IllegalArgumentException("dataType doesn't have default constructor", e10);
            } else if (e10 instanceof IllegalAccessException) {
                throw new IllegalArgumentException("dataType default constructor is not accessible", e10);
            } else if (e10 instanceof ReflectiveOperationException) {
                throw new IllegalArgumentException("Linkage exception", e10);
            } else {
                throw new RuntimeException(e10);
            }
        }
    }

    public final long a() {
        return this.f41859d;
    }

    public final <T extends m> T b(Class<T> cls) {
        T t10 = (m) this.f41865j.get(cls);
        if (t10 != null) {
            return t10;
        }
        T n10 = n(cls);
        this.f41865j.put(cls, n10);
        return n10;
    }

    public final <T extends m> T c(Class<T> cls) {
        return (m) this.f41865j.get(cls);
    }

    /* access modifiers changed from: package-private */
    public final n d() {
        return this.f41856a;
    }

    public final Collection<m> e() {
        return this.f41865j.values();
    }

    public final List<w> f() {
        return this.f41866k;
    }

    public final void g(m mVar) {
        p.k(mVar);
        Class cls = mVar.getClass();
        if (cls.getSuperclass() == m.class) {
            mVar.zzc(b(cls));
            return;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public final void h() {
        this.f41864i = true;
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        this.f41861f = this.f41857b.b();
        long j10 = this.f41860e;
        if (j10 != 0) {
            this.f41859d = j10;
        } else {
            this.f41859d = this.f41857b.currentTimeMillis();
        }
        this.f41858c = true;
    }

    public final void j(long j10) {
        this.f41860e = j10;
    }

    public final void k() {
        this.f41856a.b().k(this);
    }

    /* access modifiers changed from: package-private */
    public final boolean l() {
        return this.f41864i;
    }

    public final boolean m() {
        return this.f41858c;
    }

    k(n nVar, f fVar) {
        p.k(nVar);
        p.k(fVar);
        this.f41856a = nVar;
        this.f41857b = fVar;
        this.f41862g = 1800000;
        this.f41863h = 3024000000L;
        this.f41865j = new HashMap();
        this.f41866k = new ArrayList();
    }
}
