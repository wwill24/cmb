package androidx.work;

import androidx.annotation.NonNull;
import androidx.work.impl.d;
import b2.e;
import b2.k;
import b2.o;
import com.google.android.gms.common.api.a;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    final Executor f7369a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    final Executor f7370b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    final o f7371c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    final e f7372d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    final k f7373e;

    /* renamed from: f  reason: collision with root package name */
    final androidx.core.util.a<Throwable> f7374f;

    /* renamed from: g  reason: collision with root package name */
    final androidx.core.util.a<Throwable> f7375g;

    /* renamed from: h  reason: collision with root package name */
    final String f7376h;

    /* renamed from: i  reason: collision with root package name */
    final int f7377i;

    /* renamed from: j  reason: collision with root package name */
    final int f7378j;

    /* renamed from: k  reason: collision with root package name */
    final int f7379k;

    /* renamed from: l  reason: collision with root package name */
    final int f7380l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f7381m;

    /* renamed from: androidx.work.a$a  reason: collision with other inner class name */
    class C0081a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f7382a = new AtomicInteger(0);

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f7383b;

        C0081a(boolean z10) {
            this.f7383b = z10;
        }

        public Thread newThread(Runnable runnable) {
            String str;
            if (this.f7383b) {
                str = "WM.task-";
            } else {
                str = "androidx.work-";
            }
            return new Thread(runnable, str + this.f7382a.incrementAndGet());
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        Executor f7385a;

        /* renamed from: b  reason: collision with root package name */
        o f7386b;

        /* renamed from: c  reason: collision with root package name */
        e f7387c;

        /* renamed from: d  reason: collision with root package name */
        Executor f7388d;

        /* renamed from: e  reason: collision with root package name */
        k f7389e;

        /* renamed from: f  reason: collision with root package name */
        androidx.core.util.a<Throwable> f7390f;

        /* renamed from: g  reason: collision with root package name */
        androidx.core.util.a<Throwable> f7391g;

        /* renamed from: h  reason: collision with root package name */
        String f7392h;

        /* renamed from: i  reason: collision with root package name */
        int f7393i = 4;

        /* renamed from: j  reason: collision with root package name */
        int f7394j = 0;

        /* renamed from: k  reason: collision with root package name */
        int f7395k = a.e.API_PRIORITY_OTHER;

        /* renamed from: l  reason: collision with root package name */
        int f7396l = 20;

        @NonNull
        public a a() {
            return new a(this);
        }
    }

    public interface c {
        @NonNull
        a a();
    }

    a(@NonNull b bVar) {
        Executor executor = bVar.f7385a;
        if (executor == null) {
            this.f7369a = a(false);
        } else {
            this.f7369a = executor;
        }
        Executor executor2 = bVar.f7388d;
        if (executor2 == null) {
            this.f7381m = true;
            this.f7370b = a(true);
        } else {
            this.f7381m = false;
            this.f7370b = executor2;
        }
        o oVar = bVar.f7386b;
        if (oVar == null) {
            this.f7371c = o.c();
        } else {
            this.f7371c = oVar;
        }
        e eVar = bVar.f7387c;
        if (eVar == null) {
            this.f7372d = e.c();
        } else {
            this.f7372d = eVar;
        }
        k kVar = bVar.f7389e;
        if (kVar == null) {
            this.f7373e = new d();
        } else {
            this.f7373e = kVar;
        }
        this.f7377i = bVar.f7393i;
        this.f7378j = bVar.f7394j;
        this.f7379k = bVar.f7395k;
        this.f7380l = bVar.f7396l;
        this.f7374f = bVar.f7390f;
        this.f7375g = bVar.f7391g;
        this.f7376h = bVar.f7392h;
    }

    @NonNull
    private Executor a(boolean z10) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), b(z10));
    }

    @NonNull
    private ThreadFactory b(boolean z10) {
        return new C0081a(z10);
    }

    public String c() {
        return this.f7376h;
    }

    @NonNull
    public Executor d() {
        return this.f7369a;
    }

    public androidx.core.util.a<Throwable> e() {
        return this.f7374f;
    }

    @NonNull
    public e f() {
        return this.f7372d;
    }

    public int g() {
        return this.f7379k;
    }

    public int h() {
        return this.f7380l;
    }

    public int i() {
        return this.f7378j;
    }

    public int j() {
        return this.f7377i;
    }

    @NonNull
    public k k() {
        return this.f7373e;
    }

    public androidx.core.util.a<Throwable> l() {
        return this.f7375g;
    }

    @NonNull
    public Executor m() {
        return this.f7370b;
    }

    @NonNull
    public o n() {
        return this.f7371c;
    }
}
