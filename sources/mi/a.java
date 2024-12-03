package mi;

import java.lang.Thread;

public final /* synthetic */ class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f32788a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Thread.UncaughtExceptionHandler f32789b;

    public /* synthetic */ a(b bVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f32788a = bVar;
        this.f32789b = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th2) {
        b.f(this.f32788a, this.f32789b, thread, th2);
    }
}
