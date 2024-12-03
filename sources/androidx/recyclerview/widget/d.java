package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.h;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

public class d<T> {

    /* renamed from: h  reason: collision with root package name */
    private static final Executor f6478h = new c();

    /* renamed from: a  reason: collision with root package name */
    private final r f6479a;

    /* renamed from: b  reason: collision with root package name */
    final c<T> f6480b;

    /* renamed from: c  reason: collision with root package name */
    Executor f6481c;

    /* renamed from: d  reason: collision with root package name */
    private final List<b<T>> f6482d = new CopyOnWriteArrayList();

    /* renamed from: e  reason: collision with root package name */
    private List<T> f6483e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private List<T> f6484f = Collections.emptyList();

    /* renamed from: g  reason: collision with root package name */
    int f6485g;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f6486a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f6487b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f6488c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Runnable f6489d;

        /* renamed from: androidx.recyclerview.widget.d$a$a  reason: collision with other inner class name */
        class C0071a extends h.b {
            C0071a() {
            }

            public boolean a(int i10, int i11) {
                Object obj = a.this.f6486a.get(i10);
                Object obj2 = a.this.f6487b.get(i11);
                if (obj != null && obj2 != null) {
                    return d.this.f6480b.b().a(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                throw new AssertionError();
            }

            public boolean b(int i10, int i11) {
                Object obj = a.this.f6486a.get(i10);
                Object obj2 = a.this.f6487b.get(i11);
                if (obj != null && obj2 != null) {
                    return d.this.f6480b.b().b(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                return false;
            }

            public Object c(int i10, int i11) {
                Object obj = a.this.f6486a.get(i10);
                Object obj2 = a.this.f6487b.get(i11);
                if (obj != null && obj2 != null) {
                    return d.this.f6480b.b().c(obj, obj2);
                }
                throw new AssertionError();
            }

            public int d() {
                return a.this.f6487b.size();
            }

            public int e() {
                return a.this.f6486a.size();
            }
        }

        class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h.e f6492a;

            b(h.e eVar) {
                this.f6492a = eVar;
            }

            public void run() {
                a aVar = a.this;
                d dVar = d.this;
                if (dVar.f6485g == aVar.f6488c) {
                    dVar.c(aVar.f6487b, this.f6492a, aVar.f6489d);
                }
            }
        }

        a(List list, List list2, int i10, Runnable runnable) {
            this.f6486a = list;
            this.f6487b = list2;
            this.f6488c = i10;
            this.f6489d = runnable;
        }

        public void run() {
            d.this.f6481c.execute(new b(h.b(new C0071a())));
        }
    }

    public interface b<T> {
        void a(@NonNull List<T> list, @NonNull List<T> list2);
    }

    private static class c implements Executor {

        /* renamed from: a  reason: collision with root package name */
        final Handler f6494a = new Handler(Looper.getMainLooper());

        c() {
        }

        public void execute(@NonNull Runnable runnable) {
            this.f6494a.post(runnable);
        }
    }

    public d(@NonNull r rVar, @NonNull c<T> cVar) {
        this.f6479a = rVar;
        this.f6480b = cVar;
        if (cVar.c() != null) {
            this.f6481c = cVar.c();
        } else {
            this.f6481c = f6478h;
        }
    }

    private void d(@NonNull List<T> list, Runnable runnable) {
        for (b<T> a10 : this.f6482d) {
            a10.a(list, this.f6484f);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void a(@NonNull b<T> bVar) {
        this.f6482d.add(bVar);
    }

    @NonNull
    public List<T> b() {
        return this.f6484f;
    }

    /* access modifiers changed from: package-private */
    public void c(@NonNull List<T> list, @NonNull h.e eVar, Runnable runnable) {
        List<T> list2 = this.f6484f;
        this.f6483e = list;
        this.f6484f = Collections.unmodifiableList(list);
        eVar.b(this.f6479a);
        d(list2, runnable);
    }

    public void e(List<T> list) {
        f(list, (Runnable) null);
    }

    public void f(List<T> list, Runnable runnable) {
        int i10 = this.f6485g + 1;
        this.f6485g = i10;
        List<T> list2 = this.f6483e;
        if (list != list2) {
            List<T> list3 = this.f6484f;
            if (list == null) {
                int size = list2.size();
                this.f6483e = null;
                this.f6484f = Collections.emptyList();
                this.f6479a.b(0, size);
                d(list3, runnable);
            } else if (list2 == null) {
                this.f6483e = list;
                this.f6484f = Collections.unmodifiableList(list);
                this.f6479a.a(0, list.size());
                d(list3, runnable);
            } else {
                this.f6480b.a().execute(new a(list2, list, i10, runnable));
            }
        } else if (runnable != null) {
            runnable.run();
        }
    }
}
