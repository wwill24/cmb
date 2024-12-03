package p3;

import androidx.annotation.NonNull;
import androidx.core.util.e;
import com.bumptech.glide.Registry;
import f4.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p3.n;

public class r {

    /* renamed from: e  reason: collision with root package name */
    private static final c f16972e = new c();

    /* renamed from: f  reason: collision with root package name */
    private static final n<Object, Object> f16973f = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<b<?, ?>> f16974a;

    /* renamed from: b  reason: collision with root package name */
    private final c f16975b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<b<?, ?>> f16976c;

    /* renamed from: d  reason: collision with root package name */
    private final e<List<Throwable>> f16977d;

    private static class a implements n<Object, Object> {
        a() {
        }

        public boolean a(@NonNull Object obj) {
            return false;
        }

        public n.a<Object> b(@NonNull Object obj, int i10, int i11, @NonNull i3.e eVar) {
            return null;
        }
    }

    private static class b<Model, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<Model> f16978a;

        /* renamed from: b  reason: collision with root package name */
        final Class<Data> f16979b;

        /* renamed from: c  reason: collision with root package name */
        final o<? extends Model, ? extends Data> f16980c;

        public b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
            this.f16978a = cls;
            this.f16979b = cls2;
            this.f16980c = oVar;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.f16978a.isAssignableFrom(cls);
        }

        public boolean b(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return a(cls) && this.f16979b.isAssignableFrom(cls2);
        }
    }

    static class c {
        c() {
        }

        @NonNull
        public <Model, Data> q<Model, Data> a(@NonNull List<n<Model, Data>> list, @NonNull e<List<Throwable>> eVar) {
            return new q<>(list, eVar);
        }
    }

    public r(@NonNull e<List<Throwable>> eVar) {
        this(eVar, f16972e);
    }

    private <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar, boolean z10) {
        int i10;
        b bVar = new b(cls, cls2, oVar);
        List<b<?, ?>> list = this.f16974a;
        if (z10) {
            i10 = list.size();
        } else {
            i10 = 0;
        }
        list.add(i10, bVar);
    }

    @NonNull
    private <Model, Data> n<Model, Data> e(@NonNull b<?, ?> bVar) {
        return (n) j.d(bVar.f16980c.c(this));
    }

    @NonNull
    private static <Model, Data> n<Model, Data> f() {
        return f16973f;
    }

    @NonNull
    private <Model, Data> o<Model, Data> h(@NonNull b<?, ?> bVar) {
        return bVar.f16980c;
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public synchronized <Model> List<n<Model, ?>> c(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b next : this.f16974a) {
                if (!this.f16976c.contains(next)) {
                    if (next.a(cls)) {
                        this.f16976c.add(next);
                        arrayList.add(e(next));
                        this.f16976c.remove(next);
                    }
                }
            }
        } catch (Throwable th2) {
            this.f16976c.clear();
            throw th2;
        }
        return arrayList;
    }

    @NonNull
    public synchronized <Model, Data> n<Model, Data> d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z10 = false;
            for (b next : this.f16974a) {
                if (this.f16976c.contains(next)) {
                    z10 = true;
                } else if (next.b(cls, cls2)) {
                    this.f16976c.add(next);
                    arrayList.add(e(next));
                    this.f16976c.remove(next);
                }
            }
            if (arrayList.size() > 1) {
                return this.f16975b.a(arrayList, this.f16977d);
            } else if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            } else if (z10) {
                return f();
            } else {
                throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
            }
        } catch (Throwable th2) {
            this.f16976c.clear();
            throw th2;
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public synchronized List<Class<?>> g(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b next : this.f16974a) {
            if (!arrayList.contains(next.f16979b) && next.a(cls)) {
                arrayList.add(next.f16979b);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public synchronized <Model, Data> List<o<? extends Model, ? extends Data>> i(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<b<?, ?>> it = this.f16974a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.b(cls, cls2)) {
                it.remove();
                arrayList.add(h(next));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public synchronized <Model, Data> List<o<? extends Model, ? extends Data>> j(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<? extends Model, ? extends Data> oVar) {
        List<o<? extends Model, ? extends Data>> i10;
        i10 = i(cls, cls2);
        b(cls, cls2, oVar);
        return i10;
    }

    r(@NonNull e<List<Throwable>> eVar, @NonNull c cVar) {
        this.f16974a = new ArrayList();
        this.f16976c = new HashSet();
        this.f16977d = eVar;
        this.f16975b = cVar;
    }
}
