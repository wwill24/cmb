package io.sentry.util.thread;

import io.sentry.protocol.u;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public interface a {
    boolean a() {
        return d(Thread.currentThread());
    }

    boolean b(long j10);

    boolean c(u uVar) {
        Long j10 = uVar.j();
        if (j10 == null || !b(j10.longValue())) {
            return false;
        }
        return true;
    }

    boolean d(Thread thread) {
        return b(thread.getId());
    }
}
