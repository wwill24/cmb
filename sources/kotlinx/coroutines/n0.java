package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.e1;

@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b,\u0010 J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0014\u0010\f\u001a\u00020\u00042\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u0004H\u0016J$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\r2\n\u0010\u0014\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016R\u0014\u0010\u001c\u001a\u00020\r8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u0012\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%R\u0014\u0010+\u001a\u00020\u00068TX\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lkotlinx/coroutines/n0;", "Lkotlinx/coroutines/e1;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "G1", "Ljava/lang/Thread;", "w1", "", "F1", "r1", "task", "b1", "", "now", "Lkotlinx/coroutines/e1$c;", "delayedTask", "R0", "shutdown", "timeMillis", "block", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlinx/coroutines/z0;", "u", "run", "j", "J", "KEEP_ALIVE_NANOS", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "()V", "", "debugStatus", "I", "A1", "()Z", "isShutDown", "C1", "isShutdownRequested", "Q0", "()Ljava/lang/Thread;", "thread", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class n0 extends e1 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: h  reason: collision with root package name */
    public static final n0 f32584h;

    /* renamed from: j  reason: collision with root package name */
    private static final long f32585j;

    static {
        Long l10;
        n0 n0Var = new n0();
        f32584h = n0Var;
        d1.t0(n0Var, false, 1, (Object) null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l10 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l10 = 1000L;
        }
        f32585j = timeUnit.toNanos(l10.longValue());
    }

    private n0() {
    }

    private final boolean A1() {
        return debugStatus == 4;
    }

    private final boolean C1() {
        int i10 = debugStatus;
        return i10 == 2 || i10 == 3;
    }

    private final synchronized boolean F1() {
        if (C1()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    private final void G1() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    private final synchronized void r1() {
        if (C1()) {
            debugStatus = 3;
            h1();
            notifyAll();
        }
    }

    private final synchronized Thread w1() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    /* access modifiers changed from: protected */
    public Thread Q0() {
        Thread thread = _thread;
        return thread == null ? w1() : thread;
    }

    /* access modifiers changed from: protected */
    public void R0(long j10, e1.c cVar) {
        G1();
    }

    public void b1(Runnable runnable) {
        if (A1()) {
            G1();
        }
        super.b1(runnable);
    }

    public void run() {
        q2.f32598a.d(this);
        c.a();
        try {
            if (F1()) {
                long j10 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long H0 = H0();
                    if (H0 == Long.MAX_VALUE) {
                        c.a();
                        long nanoTime = System.nanoTime();
                        if (j10 == Long.MAX_VALUE) {
                            j10 = f32585j + nanoTime;
                        }
                        long j11 = j10 - nanoTime;
                        if (j11 <= 0) {
                            _thread = null;
                            r1();
                            c.a();
                            if (!e1()) {
                                Q0();
                                return;
                            }
                            return;
                        }
                        H0 = j.h(H0, j11);
                    } else {
                        j10 = Long.MAX_VALUE;
                    }
                    if (H0 > 0) {
                        if (C1()) {
                            _thread = null;
                            r1();
                            c.a();
                            if (!e1()) {
                                Q0();
                                return;
                            }
                            return;
                        }
                        c.a();
                        LockSupport.parkNanos(this, H0);
                    }
                }
            }
        } finally {
            _thread = null;
            r1();
            c.a();
            if (!e1()) {
                Q0();
            }
        }
    }

    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    public z0 u(long j10, Runnable runnable, CoroutineContext coroutineContext) {
        return m1(j10, runnable);
    }
}
