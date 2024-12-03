package io.sentry.transport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public final class ReusableCountLatch {

    /* renamed from: a  reason: collision with root package name */
    private final Sync f31639a;

    private static final class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = 5970133580157457018L;

        Sync(int i10) {
            setState(i10);
        }

        /* access modifiers changed from: private */
        public void d() {
            releaseShared(1);
        }

        /* access modifiers changed from: private */
        public int e() {
            return getState();
        }

        /* access modifiers changed from: private */
        public void f() {
            int state;
            do {
                state = getState();
            } while (!compareAndSetState(state, state + 1));
        }

        public int tryAcquireShared(int i10) {
            return getState() == 0 ? 1 : -1;
        }

        public boolean tryReleaseShared(int i10) {
            int state;
            int i11;
            do {
                state = getState();
                if (state == 0) {
                    return false;
                }
                i11 = state - 1;
            } while (!compareAndSetState(state, i11));
            if (i11 == 0) {
                return true;
            }
            return false;
        }
    }

    public ReusableCountLatch(int i10) {
        if (i10 >= 0) {
            this.f31639a = new Sync(i10);
            return;
        }
        throw new IllegalArgumentException("negative initial count '" + i10 + "' is not allowed");
    }

    public void a() {
        this.f31639a.d();
    }

    public int b() {
        return this.f31639a.e();
    }

    public void c() {
        this.f31639a.f();
    }

    public boolean d(long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.f31639a.tryAcquireSharedNanos(1, timeUnit.toNanos(j10));
    }

    public ReusableCountLatch() {
        this(0);
    }
}
