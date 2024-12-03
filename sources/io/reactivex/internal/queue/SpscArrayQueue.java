package io.reactivex.internal.queue;

import io.reactivex.internal.util.g;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import net.bytebuddy.jar.asm.Opcodes;
import yj.h;

public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements h<E> {

    /* renamed from: a  reason: collision with root package name */
    private static final Integer f30591a = Integer.getInteger("jctools.spsc.max.lookahead.step", Opcodes.ACC_SYNTHETIC);
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex = new AtomicLong();
    final int lookAheadStep;
    final int mask = (length() - 1);
    final AtomicLong producerIndex = new AtomicLong();
    long producerLookAhead;

    public SpscArrayQueue(int i10) {
        super(g.a(i10));
        this.lookAheadStep = Math.min(i10 / 4, f30591a.intValue());
    }

    /* access modifiers changed from: package-private */
    public int a(long j10) {
        return ((int) j10) & this.mask;
    }

    /* access modifiers changed from: package-private */
    public int c(long j10, int i10) {
        return ((int) j10) & i10;
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public E d(int i10) {
        return get(i10);
    }

    /* access modifiers changed from: package-private */
    public void e(long j10) {
        this.consumerIndex.lazySet(j10);
    }

    /* access modifiers changed from: package-private */
    public void f(int i10, E e10) {
        lazySet(i10, e10);
    }

    /* access modifiers changed from: package-private */
    public void g(long j10) {
        this.producerIndex.lazySet(j10);
    }

    public boolean isEmpty() {
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    public boolean offer(E e10) {
        if (e10 != null) {
            int i10 = this.mask;
            long j10 = this.producerIndex.get();
            int c10 = c(j10, i10);
            if (j10 >= this.producerLookAhead) {
                long j11 = ((long) this.lookAheadStep) + j10;
                if (d(c(j11, i10)) == null) {
                    this.producerLookAhead = j11;
                } else if (d(c10) != null) {
                    return false;
                }
            }
            f(c10, e10);
            g(j10 + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public E poll() {
        long j10 = this.consumerIndex.get();
        int a10 = a(j10);
        E d10 = d(a10);
        if (d10 == null) {
            return null;
        }
        e(j10 + 1);
        f(a10, (Object) null);
        return d10;
    }
}
