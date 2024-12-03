package androidx.camera.core;

import java.util.concurrent.ExecutorService;

public final /* synthetic */ class c1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExecutorService f2204a;

    public /* synthetic */ c1(ExecutorService executorService) {
        this.f2204a = executorService;
    }

    public final void run() {
        this.f2204a.shutdown();
    }
}
