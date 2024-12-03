package com.mparticle;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.mparticle.internal.Logger;
import com.mparticle.internal.listeners.InternalListenerManager;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class b extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f22267a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f22268b;

    /* renamed from: c  reason: collision with root package name */
    private ConcurrentHashMap<Message, Boolean> f22269c = new ConcurrentHashMap<>();

    public b(Looper looper) {
        super(looper);
    }

    public void a(Message message) {
    }

    public void a(boolean z10) {
        this.f22267a = z10;
        removeCallbacksAndMessages((Object) null);
        do {
        } while (this.f22268b);
    }

    public final void handleMessage(Message message) {
        if (this.f22267a) {
            Logger.error("Handler: " + getClass().getName() + " is destroyed! Message: \"" + message.toString() + "\" will not be processed");
            return;
        }
        this.f22268b = true;
        if (message != null) {
            try {
                this.f22269c.remove(message);
            } catch (OutOfMemoryError unused) {
                Logger.error("Out of memory");
            } catch (Throwable th2) {
                this.f22268b = false;
                throw th2;
            }
        }
        if (message != null && message.what == -1) {
            Object obj = message.obj;
            if (obj instanceof CountDownLatch) {
                ((CountDownLatch) obj).countDown();
                this.f22268b = false;
            }
        }
        if (InternalListenerManager.isEnabled()) {
            InternalListenerManager.getListener().onThreadMessage(getClass().getName(), message, true);
        }
        a(message);
        this.f22268b = false;
    }

    public boolean sendMessageAtTime(Message message, long j10) {
        if (this.f22267a) {
            return false;
        }
        if (InternalListenerManager.isEnabled()) {
            InternalListenerManager.getListener().onThreadMessage(getClass().getName(), message, false);
        }
        if (message != null) {
            this.f22269c.put(message, Boolean.TRUE);
        }
        return super.sendMessageAtTime(message, j10);
    }

    public boolean a() {
        return this.f22267a;
    }

    public void a(int i10) {
        for (Message next : this.f22269c.keySet()) {
            if (next.what == i10) {
                this.f22269c.remove(next);
            }
        }
        super.removeMessages(i10);
    }
}
