package kotlinx.coroutines;

import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

@Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007\u001a\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¨\u0006\u0007"}, d2 = {"", "name", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "d", "", "nThreads", "b", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class s2 {
    public static final ExecutorCoroutineDispatcher b(int i10, String str) {
        boolean z10 = true;
        if (i10 < 1) {
            z10 = false;
        }
        if (z10) {
            return k1.c(Executors.newScheduledThreadPool(i10, new r2(i10, str, new AtomicInteger())));
        }
        throw new IllegalArgumentException(("Expected at least one thread, but " + i10 + " specified").toString());
    }

    /* access modifiers changed from: private */
    public static final Thread c(int i10, String str, AtomicInteger atomicInteger, Runnable runnable) {
        if (i10 != 1) {
            str = str + SignatureVisitor.SUPER + atomicInteger.incrementAndGet();
        }
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(true);
        return thread;
    }

    public static final ExecutorCoroutineDispatcher d(String str) {
        return b(1, str);
    }
}
