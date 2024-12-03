package io.reactivex.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    final boolean nonBlocking;
    final String prefix;
    final int priority;

    static final class a extends Thread implements g {
        a(Runnable runnable, String str) {
            super(runnable, str);
        }
    }

    public RxThreadFactory(String str) {
        this(str, 5, false);
    }

    public Thread newThread(Runnable runnable) {
        Thread thread;
        String str = this.prefix + SignatureVisitor.SUPER + incrementAndGet();
        if (this.nonBlocking) {
            thread = new a(runnable, str);
        } else {
            thread = new Thread(runnable, str);
        }
        thread.setPriority(this.priority);
        thread.setDaemon(true);
        return thread;
    }

    public String toString() {
        return "RxThreadFactory[" + this.prefix + "]";
    }

    public RxThreadFactory(String str, int i10) {
        this(str, i10, false);
    }

    public RxThreadFactory(String str, int i10, boolean z10) {
        this.prefix = str;
        this.priority = i10;
        this.nonBlocking = z10;
    }
}
