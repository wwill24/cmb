package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import java.util.Map;

public abstract class LiveData<T> {

    /* renamed from: k  reason: collision with root package name */
    static final Object f5933k = new Object();

    /* renamed from: a  reason: collision with root package name */
    final Object f5934a;

    /* renamed from: b  reason: collision with root package name */
    private j.b<u<? super T>, LiveData<T>.c> f5935b;

    /* renamed from: c  reason: collision with root package name */
    int f5936c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5937d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Object f5938e;

    /* renamed from: f  reason: collision with root package name */
    volatile Object f5939f;

    /* renamed from: g  reason: collision with root package name */
    private int f5940g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f5941h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5942i;

    /* renamed from: j  reason: collision with root package name */
    private final Runnable f5943j;

    class LifecycleBoundObserver extends LiveData<T>.c implements i {
        @NonNull

        /* renamed from: e  reason: collision with root package name */
        final l f5944e;

        LifecycleBoundObserver(@NonNull l lVar, u<? super T> uVar) {
            super(uVar);
            this.f5944e = lVar;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f5944e.getLifecycle().d(this);
        }

        /* access modifiers changed from: package-private */
        public boolean c(l lVar) {
            return this.f5944e == lVar;
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            return this.f5944e.getLifecycle().b().b(Lifecycle.State.STARTED);
        }

        public void e(@NonNull l lVar, @NonNull Lifecycle.Event event) {
            Lifecycle.State b10 = this.f5944e.getLifecycle().b();
            if (b10 == Lifecycle.State.DESTROYED) {
                LiveData.this.n(this.f5948a);
                return;
            }
            Lifecycle.State state = null;
            while (state != b10) {
                a(d());
                state = b10;
                b10 = this.f5944e.getLifecycle().b();
            }
        }
    }

    class a implements Runnable {
        a() {
        }

        public void run() {
            Object obj;
            synchronized (LiveData.this.f5934a) {
                obj = LiveData.this.f5939f;
                LiveData.this.f5939f = LiveData.f5933k;
            }
            LiveData.this.o(obj);
        }
    }

    private class b extends LiveData<T>.c {
        b(u<? super T> uVar) {
            super(uVar);
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            return true;
        }
    }

    private abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final u<? super T> f5948a;

        /* renamed from: b  reason: collision with root package name */
        boolean f5949b;

        /* renamed from: c  reason: collision with root package name */
        int f5950c = -1;

        c(u<? super T> uVar) {
            this.f5948a = uVar;
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z10) {
            int i10;
            if (z10 != this.f5949b) {
                this.f5949b = z10;
                LiveData liveData = LiveData.this;
                if (z10) {
                    i10 = 1;
                } else {
                    i10 = -1;
                }
                liveData.c(i10);
                if (this.f5949b) {
                    LiveData.this.e(this);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
        }

        /* access modifiers changed from: package-private */
        public boolean c(l lVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public abstract boolean d();
    }

    public LiveData(T t10) {
        this.f5934a = new Object();
        this.f5935b = new j.b<>();
        this.f5936c = 0;
        this.f5939f = f5933k;
        this.f5943j = new a();
        this.f5938e = t10;
        this.f5940g = 0;
    }

    static void b(String str) {
        if (!i.c.g().b()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }

    private void d(LiveData<T>.c cVar) {
        if (cVar.f5949b) {
            if (!cVar.d()) {
                cVar.a(false);
                return;
            }
            int i10 = cVar.f5950c;
            int i11 = this.f5940g;
            if (i10 < i11) {
                cVar.f5950c = i11;
                cVar.f5948a.b(this.f5938e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i10) {
        boolean z10;
        boolean z11;
        int i11 = this.f5936c;
        this.f5936c = i10 + i11;
        if (!this.f5937d) {
            this.f5937d = true;
            while (true) {
                try {
                    int i12 = this.f5936c;
                    if (i11 != i12) {
                        if (i11 != 0 || i12 <= 0) {
                            z10 = false;
                        } else {
                            z10 = true;
                        }
                        if (i11 <= 0 || i12 != 0) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        if (z10) {
                            k();
                        } else if (z11) {
                            l();
                        }
                        i11 = i12;
                    } else {
                        return;
                    }
                } finally {
                    this.f5937d = false;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void e(LiveData<T>.c cVar) {
        if (this.f5941h) {
            this.f5942i = true;
            return;
        }
        this.f5941h = true;
        do {
            this.f5942i = false;
            if (cVar == null) {
                j.b<K, V>.d f10 = this.f5935b.f();
                while (f10.hasNext()) {
                    d((c) ((Map.Entry) f10.next()).getValue());
                    if (this.f5942i) {
                        break;
                    }
                }
            } else {
                d(cVar);
                cVar = null;
            }
        } while (this.f5942i);
        this.f5941h = false;
    }

    public T f() {
        T t10 = this.f5938e;
        if (t10 != f5933k) {
            return t10;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f5940g;
    }

    public boolean h() {
        return this.f5936c > 0;
    }

    public void i(@NonNull l lVar, @NonNull u<? super T> uVar) {
        b("observe");
        if (lVar.getLifecycle().b() != Lifecycle.State.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lVar, uVar);
            c j10 = this.f5935b.j(uVar, lifecycleBoundObserver);
            if (j10 != null && !j10.c(lVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (j10 == null) {
                lVar.getLifecycle().a(lifecycleBoundObserver);
            }
        }
    }

    public void j(@NonNull u<? super T> uVar) {
        b("observeForever");
        b bVar = new b(uVar);
        c j10 = this.f5935b.j(uVar, bVar);
        if (j10 instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (j10 == null) {
            bVar.a(true);
        }
    }

    /* access modifiers changed from: protected */
    public void k() {
    }

    /* access modifiers changed from: protected */
    public void l() {
    }

    /* access modifiers changed from: protected */
    public void m(T t10) {
        boolean z10;
        synchronized (this.f5934a) {
            if (this.f5939f == f5933k) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f5939f = t10;
        }
        if (z10) {
            i.c.g().c(this.f5943j);
        }
    }

    public void n(@NonNull u<? super T> uVar) {
        b("removeObserver");
        c m10 = this.f5935b.m(uVar);
        if (m10 != null) {
            m10.b();
            m10.a(false);
        }
    }

    /* access modifiers changed from: protected */
    public void o(T t10) {
        b("setValue");
        this.f5940g++;
        this.f5938e = t10;
        e((LiveData<T>.c) null);
    }

    public LiveData() {
        this.f5934a = new Object();
        this.f5935b = new j.b<>();
        this.f5936c = 0;
        Object obj = f5933k;
        this.f5939f = obj;
        this.f5943j = new a();
        this.f5938e = obj;
        this.f5940g = -1;
    }
}
