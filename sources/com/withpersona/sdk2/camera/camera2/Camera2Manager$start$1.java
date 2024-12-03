package com.withpersona.sdk2.camera.camera2;

import android.view.SurfaceHolder;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.s1;

public final class Camera2Manager$start$1 implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Camera2Manager f14296a;

    Camera2Manager$start$1(Camera2Manager camera2Manager) {
        this.f14296a = camera2Manager;
    }

    /* access modifiers changed from: private */
    public static final void b(Camera2Manager camera2Manager) {
        j.g(camera2Manager, "this$0");
        s1 unused = j.d(camera2Manager.f14266e, (CoroutineContext) null, (CoroutineStart) null, new Camera2Manager$start$1$surfaceCreated$1$1(camera2Manager, (c<? super Camera2Manager$start$1$surfaceCreated$1$1>) null), 3, (Object) null);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
        j.g(surfaceHolder, "holder");
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        j.g(surfaceHolder, "holder");
        this.f14296a.f14279r = true;
        this.f14296a.B().b(this.f14296a.f14263b.c().getWidth(), this.f14296a.f14263b.c().getHeight(), this.f14296a.f14270i);
        this.f14296a.B().post(new c(this.f14296a));
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        j.g(surfaceHolder, "holder");
        this.f14296a.f14279r = false;
        this.f14296a.y();
    }
}
