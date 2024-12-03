package h2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.work.c;
import b2.f;
import g2.u;
import i2.b;

public class x implements Runnable {

    /* renamed from: g  reason: collision with root package name */
    static final String f15310g = f.i("WorkForegroundRunnable");

    /* renamed from: a  reason: collision with root package name */
    final androidx.work.impl.utils.futures.a<Void> f15311a = androidx.work.impl.utils.futures.a.s();

    /* renamed from: b  reason: collision with root package name */
    final Context f15312b;

    /* renamed from: c  reason: collision with root package name */
    final u f15313c;

    /* renamed from: d  reason: collision with root package name */
    final c f15314d;

    /* renamed from: e  reason: collision with root package name */
    final b2.c f15315e;

    /* renamed from: f  reason: collision with root package name */
    final b f15316f;

    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ androidx.work.impl.utils.futures.a f15317a;

        a(androidx.work.impl.utils.futures.a aVar) {
            this.f15317a = aVar;
        }

        public void run() {
            if (!x.this.f15311a.isCancelled()) {
                try {
                    b2.b bVar = (b2.b) this.f15317a.get();
                    if (bVar != null) {
                        f e10 = f.e();
                        String str = x.f15310g;
                        e10.a(str, "Updating notification for " + x.this.f15313c.f15079c);
                        x xVar = x.this;
                        xVar.f15311a.q(xVar.f15315e.a(xVar.f15312b, xVar.f15314d.e(), bVar));
                        return;
                    }
                    throw new IllegalStateException("Worker was marked important (" + x.this.f15313c.f15079c + ") but did not provide ForegroundInfo");
                } catch (Throwable th2) {
                    x.this.f15311a.p(th2);
                }
            }
        }
    }

    @SuppressLint({"LambdaLast"})
    public x(@NonNull Context context, @NonNull u uVar, @NonNull c cVar, @NonNull b2.c cVar2, @NonNull b bVar) {
        this.f15312b = context;
        this.f15313c = uVar;
        this.f15314d = cVar;
        this.f15315e = cVar2;
        this.f15316f = bVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(androidx.work.impl.utils.futures.a aVar) {
        if (!this.f15311a.isCancelled()) {
            aVar.q(this.f15314d.d());
        } else {
            aVar.cancel(true);
        }
    }

    @NonNull
    public zf.a<Void> b() {
        return this.f15311a;
    }

    @SuppressLint({"UnsafeExperimentalUsageError"})
    public void run() {
        if (!this.f15313c.f15093q || Build.VERSION.SDK_INT >= 31) {
            this.f15311a.o(null);
            return;
        }
        androidx.work.impl.utils.futures.a s10 = androidx.work.impl.utils.futures.a.s();
        this.f15316f.a().execute(new w(this, s10));
        s10.addListener(new a(s10), this.f15316f.a());
    }
}
