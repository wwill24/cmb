package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import qj.v;

public final class e extends v {

    /* renamed from: d  reason: collision with root package name */
    private static final RxThreadFactory f30663d = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));

    /* renamed from: c  reason: collision with root package name */
    final ThreadFactory f30664c;

    public e() {
        this(f30663d);
    }

    public v.c b() {
        return new f(this.f30664c);
    }

    public e(ThreadFactory threadFactory) {
        this.f30664c = threadFactory;
    }
}
