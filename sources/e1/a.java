package e1;

import android.os.SystemClock;
import android.view.Choreographer;
import androidx.collection.g;
import java.util.ArrayList;

class a {

    /* renamed from: g  reason: collision with root package name */
    public static final ThreadLocal<a> f14513g = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    private final g<b, Long> f14514a = new g<>();

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<b> f14515b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final C0154a f14516c = new C0154a();

    /* renamed from: d  reason: collision with root package name */
    private c f14517d;

    /* renamed from: e  reason: collision with root package name */
    long f14518e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14519f = false;

    /* renamed from: e1.a$a  reason: collision with other inner class name */
    class C0154a {
        C0154a() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            a.this.f14518e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.c(aVar.f14518e);
            if (a.this.f14515b.size() > 0) {
                a.this.e().a();
            }
        }
    }

    interface b {
        boolean a(long j10);
    }

    static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final C0154a f14521a;

        c(C0154a aVar) {
            this.f14521a = aVar;
        }

        /* access modifiers changed from: package-private */
        public abstract void a();
    }

    private static class d extends c {

        /* renamed from: b  reason: collision with root package name */
        private final Choreographer f14522b = Choreographer.getInstance();

        /* renamed from: c  reason: collision with root package name */
        private final Choreographer.FrameCallback f14523c = new C0155a();

        /* renamed from: e1.a$d$a  reason: collision with other inner class name */
        class C0155a implements Choreographer.FrameCallback {
            C0155a() {
            }

            public void doFrame(long j10) {
                d.this.f14521a.a();
            }
        }

        d(C0154a aVar) {
            super(aVar);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f14522b.postFrameCallback(this.f14523c);
        }
    }

    a() {
    }

    private void b() {
        if (this.f14519f) {
            for (int size = this.f14515b.size() - 1; size >= 0; size--) {
                if (this.f14515b.get(size) == null) {
                    this.f14515b.remove(size);
                }
            }
            this.f14519f = false;
        }
    }

    public static a d() {
        ThreadLocal<a> threadLocal = f14513g;
        if (threadLocal.get() == null) {
            threadLocal.set(new a());
        }
        return threadLocal.get();
    }

    private boolean f(b bVar, long j10) {
        Long l10 = this.f14514a.get(bVar);
        if (l10 == null) {
            return true;
        }
        if (l10.longValue() >= j10) {
            return false;
        }
        this.f14514a.remove(bVar);
        return true;
    }

    public void a(b bVar, long j10) {
        if (this.f14515b.size() == 0) {
            e().a();
        }
        if (!this.f14515b.contains(bVar)) {
            this.f14515b.add(bVar);
        }
        if (j10 > 0) {
            this.f14514a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j10));
        }
    }

    /* access modifiers changed from: package-private */
    public void c(long j10) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i10 = 0; i10 < this.f14515b.size(); i10++) {
            b bVar = this.f14515b.get(i10);
            if (bVar != null && f(bVar, uptimeMillis)) {
                bVar.a(j10);
            }
        }
        b();
    }

    /* access modifiers changed from: package-private */
    public c e() {
        if (this.f14517d == null) {
            this.f14517d = new d(this.f14516c);
        }
        return this.f14517d;
    }

    public void g(b bVar) {
        this.f14514a.remove(bVar);
        int indexOf = this.f14515b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f14515b.set(indexOf, (Object) null);
            this.f14519f = true;
        }
    }
}
