package h5;

import com.coffeemeetsbagel.bakery.Bakery;
import java.lang.Thread;

public final /* synthetic */ class b implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bakery f15339a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Thread.UncaughtExceptionHandler f15340b;

    public /* synthetic */ b(Bakery bakery, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f15339a = bakery;
        this.f15340b = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th2) {
        this.f15339a.T(this.f15340b, thread, th2);
    }
}
