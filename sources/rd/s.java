package rd;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class s implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicInteger f41874a = new AtomicInteger();

    /* synthetic */ s(r rVar) {
    }

    public final Thread newThread(Runnable runnable) {
        int incrementAndGet = f41874a.incrementAndGet();
        StringBuilder sb2 = new StringBuilder(23);
        sb2.append("measurement-");
        sb2.append(incrementAndGet);
        return new t(runnable, sb2.toString());
    }
}
