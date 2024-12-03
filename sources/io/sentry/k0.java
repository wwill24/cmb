package io.sentry;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public interface k0 {
    void a(long j10);

    Future<?> schedule(Runnable runnable, long j10);

    Future<?> submit(Runnable runnable);

    <T> Future<T> submit(Callable<T> callable);
}
