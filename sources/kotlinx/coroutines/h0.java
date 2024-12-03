package kotlinx.coroutines;

import gk.g;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\"\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\b¨\u0006\n"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "a", "", "Lkotlinx/coroutines/g0;", "Ljava/util/List;", "handlers", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class h0 {

    /* renamed from: a  reason: collision with root package name */
    private static final List<g0> f32491a;

    static {
        Class<g0> cls = g0.class;
        f32491a = SequencesKt___SequencesKt.t(SequencesKt__SequencesKt.c(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
    }

    public static final void a(CoroutineContext coroutineContext, Throwable th2) {
        for (g0 P : f32491a) {
            try {
                P.P(coroutineContext, th2);
            } catch (Throwable th3) {
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, i0.b(th2, th3));
            }
        }
        Thread currentThread2 = Thread.currentThread();
        try {
            Result.a aVar = Result.f32010a;
            b.a(th2, new DiagnosticCoroutineContextException(coroutineContext));
            Result.b(Unit.f32013a);
        } catch (Throwable th4) {
            Result.a aVar2 = Result.f32010a;
            Result.b(g.a(th4));
        }
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th2);
    }
}
