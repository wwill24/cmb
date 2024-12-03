package m3;

import android.util.Log;
import f4.j;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class i implements b {

    /* renamed from: a  reason: collision with root package name */
    private final g<a, Object> f16292a = new g<>();

    /* renamed from: b  reason: collision with root package name */
    private final b f16293b = new b();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, NavigableMap<Integer, Integer>> f16294c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, a<?>> f16295d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final int f16296e;

    /* renamed from: f  reason: collision with root package name */
    private int f16297f;

    private static final class a implements l {

        /* renamed from: a  reason: collision with root package name */
        private final b f16298a;

        /* renamed from: b  reason: collision with root package name */
        int f16299b;

        /* renamed from: c  reason: collision with root package name */
        private Class<?> f16300c;

        a(b bVar) {
            this.f16298a = bVar;
        }

        public void a() {
            this.f16298a.c(this);
        }

        /* access modifiers changed from: package-private */
        public void b(int i10, Class<?> cls) {
            this.f16299b = i10;
            this.f16300c = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f16299b == aVar.f16299b && this.f16300c == aVar.f16300c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i10;
            int i11 = this.f16299b * 31;
            Class<?> cls = this.f16300c;
            if (cls != null) {
                i10 = cls.hashCode();
            } else {
                i10 = 0;
            }
            return i11 + i10;
        }

        public String toString() {
            return "Key{size=" + this.f16299b + "array=" + this.f16300c + '}';
        }
    }

    private static final class b extends c<a> {
        b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public a a() {
            return new a(this);
        }

        /* access modifiers changed from: package-private */
        public a e(int i10, Class<?> cls) {
            a aVar = (a) b();
            aVar.b(i10, cls);
            return aVar;
        }
    }

    public i(int i10) {
        this.f16296e = i10;
    }

    private void e(int i10, Class<?> cls) {
        NavigableMap<Integer, Integer> l10 = l(cls);
        Integer num = l10.get(Integer.valueOf(i10));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i10 + ", this: " + this);
        } else if (num.intValue() == 1) {
            l10.remove(Integer.valueOf(i10));
        } else {
            l10.put(Integer.valueOf(i10), Integer.valueOf(num.intValue() - 1));
        }
    }

    private void f() {
        g(this.f16296e);
    }

    private void g(int i10) {
        while (this.f16297f > i10) {
            Object f10 = this.f16292a.f();
            j.d(f10);
            a h10 = h(f10);
            this.f16297f -= h10.c(f10) * h10.b();
            e(h10.c(f10), f10.getClass());
            if (Log.isLoggable(h10.a(), 2)) {
                h10.a();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("evicted: ");
                sb2.append(h10.c(f10));
            }
        }
    }

    private <T> a<T> h(T t10) {
        return i(t10.getClass());
    }

    private <T> a<T> i(Class<T> cls) {
        a<T> aVar = this.f16295d.get(cls);
        if (aVar == null) {
            if (cls.equals(int[].class)) {
                aVar = new h();
            } else if (cls.equals(byte[].class)) {
                aVar = new f();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f16295d.put(cls, aVar);
        }
        return aVar;
    }

    private <T> T j(a aVar) {
        return this.f16292a.a(aVar);
    }

    private <T> T k(a aVar, Class<T> cls) {
        a<T> i10 = i(cls);
        T j10 = j(aVar);
        if (j10 != null) {
            this.f16297f -= i10.c(j10) * i10.b();
            e(i10.c(j10), cls);
        }
        if (j10 != null) {
            return j10;
        }
        if (Log.isLoggable(i10.a(), 2)) {
            i10.a();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Allocated ");
            sb2.append(aVar.f16299b);
            sb2.append(" bytes");
        }
        return i10.newArray(aVar.f16299b);
    }

    private NavigableMap<Integer, Integer> l(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f16294c.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f16294c.put(cls, treeMap);
        return treeMap;
    }

    private boolean m() {
        int i10 = this.f16297f;
        return i10 == 0 || this.f16296e / i10 >= 2;
    }

    private boolean n(int i10) {
        return i10 <= this.f16296e / 2;
    }

    private boolean o(int i10, Integer num) {
        return num != null && (m() || num.intValue() <= i10 * 8);
    }

    public synchronized void a(int i10) {
        if (i10 >= 40) {
            try {
                b();
            } catch (Throwable th2) {
                throw th2;
            }
        } else if (i10 >= 20 || i10 == 15) {
            g(this.f16296e / 2);
        }
    }

    public synchronized void b() {
        g(0);
    }

    public synchronized <T> T c(int i10, Class<T> cls) {
        a aVar;
        Integer ceilingKey = l(cls).ceilingKey(Integer.valueOf(i10));
        if (o(i10, ceilingKey)) {
            aVar = this.f16293b.e(ceilingKey.intValue(), cls);
        } else {
            aVar = this.f16293b.e(i10, cls);
        }
        return k(aVar, cls);
    }

    public synchronized <T> T d(int i10, Class<T> cls) {
        return k(this.f16293b.e(i10, cls), cls);
    }

    public synchronized <T> void put(T t10) {
        Class<?> cls = t10.getClass();
        a<?> i10 = i(cls);
        int c10 = i10.c(t10);
        int b10 = i10.b() * c10;
        if (n(b10)) {
            a e10 = this.f16293b.e(c10, cls);
            this.f16292a.d(e10, t10);
            NavigableMap<Integer, Integer> l10 = l(cls);
            Integer num = l10.get(Integer.valueOf(e10.f16299b));
            Integer valueOf = Integer.valueOf(e10.f16299b);
            int i11 = 1;
            if (num != null) {
                i11 = 1 + num.intValue();
            }
            l10.put(valueOf, Integer.valueOf(i11));
            this.f16297f += b10;
            f();
        }
    }
}
