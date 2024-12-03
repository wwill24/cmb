package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.core.os.OperationCanceledException;
import androidx.core.util.j;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public abstract class a<D> extends b<D> {

    /* renamed from: j  reason: collision with root package name */
    private final Executor f6108j;

    /* renamed from: k  reason: collision with root package name */
    volatile a<D>.defpackage.a f6109k;

    /* renamed from: l  reason: collision with root package name */
    volatile a<D>.defpackage.a f6110l;

    /* renamed from: m  reason: collision with root package name */
    long f6111m;

    /* renamed from: n  reason: collision with root package name */
    long f6112n;

    /* renamed from: o  reason: collision with root package name */
    Handler f6113o;

    /* renamed from: androidx.loader.content.a$a  reason: collision with other inner class name */
    final class C0067a extends ModernAsyncTask<Void, Void, D> implements Runnable {

        /* renamed from: l  reason: collision with root package name */
        private final CountDownLatch f6114l = new CountDownLatch(1);

        /* renamed from: m  reason: collision with root package name */
        boolean f6115m;

        C0067a() {
        }

        /* access modifiers changed from: protected */
        public void h(D d10) {
            try {
                a.this.y(this, d10);
            } finally {
                this.f6114l.countDown();
            }
        }

        /* access modifiers changed from: protected */
        public void i(D d10) {
            try {
                a.this.z(this, d10);
            } finally {
                this.f6114l.countDown();
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: n */
        public D b(Void... voidArr) {
            try {
                return a.this.D();
            } catch (OperationCanceledException e10) {
                if (f()) {
                    return null;
                }
                throw e10;
            }
        }

        public void run() {
            this.f6115m = false;
            a.this.A();
        }
    }

    public a(@NonNull Context context) {
        this(context, ModernAsyncTask.f6089h);
    }

    /* access modifiers changed from: package-private */
    public void A() {
        if (this.f6110l == null && this.f6109k != null) {
            if (this.f6109k.f6115m) {
                this.f6109k.f6115m = false;
                this.f6113o.removeCallbacks(this.f6109k);
            }
            if (this.f6111m <= 0 || SystemClock.uptimeMillis() >= this.f6112n + this.f6111m) {
                this.f6109k.c(this.f6108j, (Params[]) null);
                return;
            }
            this.f6109k.f6115m = true;
            this.f6113o.postAtTime(this.f6109k, this.f6112n + this.f6111m);
        }
    }

    public abstract D B();

    public void C(D d10) {
    }

    /* access modifiers changed from: protected */
    public D D() {
        return B();
    }

    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.g(str, fileDescriptor, printWriter, strArr);
        if (this.f6109k != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f6109k);
            printWriter.print(" waiting=");
            printWriter.println(this.f6109k.f6115m);
        }
        if (this.f6110l != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f6110l);
            printWriter.print(" waiting=");
            printWriter.println(this.f6110l.f6115m);
        }
        if (this.f6111m != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            j.c(this.f6111m, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            j.b(this.f6112n, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    /* access modifiers changed from: protected */
    public boolean l() {
        if (this.f6109k == null) {
            return false;
        }
        if (!this.f6121e) {
            this.f6124h = true;
        }
        if (this.f6110l != null) {
            if (this.f6109k.f6115m) {
                this.f6109k.f6115m = false;
                this.f6113o.removeCallbacks(this.f6109k);
            }
            this.f6109k = null;
            return false;
        } else if (this.f6109k.f6115m) {
            this.f6109k.f6115m = false;
            this.f6113o.removeCallbacks(this.f6109k);
            this.f6109k = null;
            return false;
        } else {
            boolean a10 = this.f6109k.a(false);
            if (a10) {
                this.f6110l = this.f6109k;
                x();
            }
            this.f6109k = null;
            return a10;
        }
    }

    /* access modifiers changed from: protected */
    public void n() {
        super.n();
        b();
        this.f6109k = new C0067a();
        A();
    }

    public void x() {
    }

    /* access modifiers changed from: package-private */
    public void y(a<D>.defpackage.a aVar, D d10) {
        C(d10);
        if (this.f6110l == aVar) {
            t();
            this.f6112n = SystemClock.uptimeMillis();
            this.f6110l = null;
            e();
            A();
        }
    }

    /* access modifiers changed from: package-private */
    public void z(a<D>.defpackage.a aVar, D d10) {
        if (this.f6109k != aVar) {
            y(aVar, d10);
        } else if (j()) {
            C(d10);
        } else {
            c();
            this.f6112n = SystemClock.uptimeMillis();
            this.f6109k = null;
            f(d10);
        }
    }

    private a(@NonNull Context context, @NonNull Executor executor) {
        super(context);
        this.f6112n = -10000;
        this.f6108j = executor;
    }
}
