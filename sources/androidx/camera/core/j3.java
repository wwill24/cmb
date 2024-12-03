package androidx.camera.core;

import android.view.Surface;

public final /* synthetic */ class j3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Surface f2778a;

    public /* synthetic */ j3(Surface surface) {
        this.f2778a = surface;
    }

    public final void run() {
        this.f2778a.release();
    }
}
