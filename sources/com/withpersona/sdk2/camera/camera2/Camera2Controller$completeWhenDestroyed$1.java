package com.withpersona.sdk2.camera.camera2;

import com.withpersona.sdk2.camera.camera2.Camera2Manager;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.c;
import pk.n;

@d(c = "com.withpersona.sdk2.camera.camera2.Camera2Controller$completeWhenDestroyed$1", f = "Camera2Controller.kt", l = {110}, m = "invokeSuspend")
final class Camera2Controller$completeWhenDestroyed$1 extends SuspendLambda implements n<c<? super Camera2Manager.b>, Camera2Manager.b, kotlin.coroutines.c<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    Camera2Controller$completeWhenDestroyed$1(kotlin.coroutines.c<? super Camera2Controller$completeWhenDestroyed$1> cVar) {
        super(3, cVar);
    }

    /* renamed from: i */
    public final Object l(c<? super Camera2Manager.b> cVar, Camera2Manager.b bVar, kotlin.coroutines.c<? super Boolean> cVar2) {
        Camera2Controller$completeWhenDestroyed$1 camera2Controller$completeWhenDestroyed$1 = new Camera2Controller$completeWhenDestroyed$1(cVar2);
        camera2Controller$completeWhenDestroyed$1.L$0 = cVar;
        camera2Controller$completeWhenDestroyed$1.L$1 = bVar;
        return camera2Controller$completeWhenDestroyed$1.invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Camera2Manager.b bVar;
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            Camera2Manager.b bVar2 = (Camera2Manager.b) this.L$1;
            this.L$0 = bVar2;
            this.label = 1;
            if (((c) this.L$0).c(bVar2, this) == d10) {
                return d10;
            }
            bVar = bVar2;
        } else if (i10 == 1) {
            bVar = (Camera2Manager.b) this.L$0;
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return a.a(!j.b(bVar, Camera2Manager.b.C0151b.f14290a));
    }
}
