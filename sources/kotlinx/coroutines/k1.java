package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\n\u0010\b\u001a\u00020\u0004*\u00020\u0005*\f\b\u0007\u0010\t\"\u00020\u00012\u00020\u0001¨\u0006\n"}, d2 = {"Ljava/util/concurrent/ExecutorService;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "c", "(Ljava/util/concurrent/ExecutorService;)Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/CoroutineDispatcher;", "b", "(Ljava/util/concurrent/Executor;)Lkotlinx/coroutines/CoroutineDispatcher;", "a", "CloseableCoroutineDispatcher", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class k1 {
    public static final Executor a(CoroutineDispatcher coroutineDispatcher) {
        Executor Y;
        ExecutorCoroutineDispatcher executorCoroutineDispatcher = coroutineDispatcher instanceof ExecutorCoroutineDispatcher ? (ExecutorCoroutineDispatcher) coroutineDispatcher : null;
        return (executorCoroutineDispatcher == null || (Y = executorCoroutineDispatcher.Y()) == null) ? new w0(coroutineDispatcher) : Y;
    }

    public static final CoroutineDispatcher b(Executor executor) {
        CoroutineDispatcher coroutineDispatcher;
        w0 w0Var = executor instanceof w0 ? (w0) executor : null;
        return (w0Var == null || (coroutineDispatcher = w0Var.f32731a) == null) ? new j1(executor) : coroutineDispatcher;
    }

    public static final ExecutorCoroutineDispatcher c(ExecutorService executorService) {
        return new j1(executorService);
    }
}
