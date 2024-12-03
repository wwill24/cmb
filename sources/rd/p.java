package rd;

import android.util.Log;
import java.lang.Thread;
import java.util.concurrent.FutureTask;

final class p extends FutureTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q f41872a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    p(q qVar, Runnable runnable, Object obj) {
        super(runnable, obj);
        this.f41872a = qVar;
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th2) {
        Thread.UncaughtExceptionHandler e10 = this.f41872a.f41873a.f41881f;
        if (e10 != null) {
            e10.uncaughtException(Thread.currentThread(), th2);
        } else if (Log.isLoggable("GAv4", 6)) {
            String valueOf = String.valueOf(th2);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 37);
            sb2.append("MeasurementExecutor: job failed with ");
            sb2.append(valueOf);
        }
        super.setException(th2);
    }
}
