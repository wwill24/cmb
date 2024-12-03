package androidx.camera.core;

import android.os.HandlerThread;

public final /* synthetic */ class c2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HandlerThread f2205a;

    public /* synthetic */ c2(HandlerThread handlerThread) {
        this.f2205a = handlerThread;
    }

    public final void run() {
        this.f2205a.quitSafely();
    }
}
