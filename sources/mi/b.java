package mi;

import android.content.Context;
import com.mparticle.identity.IdentityHttpResponse;
import java.lang.Thread;
import kotlin.jvm.internal.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f32790a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f32791b = true;

    /* renamed from: c  reason: collision with root package name */
    private final c f32792c;

    public b(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f32792c = new c(context);
    }

    /* access modifiers changed from: private */
    public static final void f(b bVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread thread, Throwable th2) {
        j.g(bVar, "this$0");
        if (bVar.f32791b) {
            try {
                c cVar = bVar.f32792c;
                j.f(th2, "paramThrowable");
                cVar.g(th2);
            } catch (Exception unused) {
            }
        }
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th2);
        } else {
            System.exit(1);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }

    public final void b() {
        this.f32792c.a();
    }

    public final String c() {
        return this.f32792c.e();
    }

    public final boolean d() {
        return this.f32792c.f();
    }

    public final synchronized void e() {
        if (!this.f32790a) {
            this.f32790a = true;
            Thread.setDefaultUncaughtExceptionHandler(new a(this, Thread.getDefaultUncaughtExceptionHandler()));
        }
    }

    public final synchronized void g() {
        if (this.f32790a) {
            this.f32791b = false;
        }
    }
}
