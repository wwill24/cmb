package com.withpersona.sdk2.camera.camera2;

import com.withpersona.sdk2.camera.camera2.Camera2Manager;
import com.withpersona.sdk2.camera.n;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.camera.camera2.Camera2Controller$prepare$1", f = "Camera2Controller.kt", l = {43}, m = "invokeSuspend")
final class Camera2Controller$prepare$1 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    int label;
    final /* synthetic */ Camera2Controller this$0;

    static final class a<T> implements kotlinx.coroutines.flow.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Camera2Controller f14261a;

        a(Camera2Controller camera2Controller) {
            this.f14261a = camera2Controller;
        }

        /* renamed from: a */
        public final Object c(Camera2Manager.b bVar, c<? super Unit> cVar) {
            if (!j.b(bVar, Camera2Manager.b.a.f14289a)) {
                if (j.b(bVar, Camera2Manager.b.d.f14292a)) {
                    this.f14261a.f14259d.setValue(n.e.f14371a);
                } else if (j.b(bVar, Camera2Manager.b.C0151b.f14290a)) {
                    this.f14261a.f14259d.setValue(new n.a(this.f14261a.f14260e));
                    Camera2Controller camera2Controller = this.f14261a;
                    camera2Controller.f14258c = camera2Controller.f14256a.a();
                    this.f14261a.f14260e = false;
                } else if (bVar instanceof Camera2Manager.b.c) {
                    Camera2Manager.Error a10 = ((Camera2Manager.b.c) bVar).a();
                    if (a10 instanceof Camera2Manager.Error.InitializationError) {
                        this.f14261a.f14259d.setValue(n.b.f14368a);
                    } else if (a10 instanceof Camera2Manager.Error.MissingPermissionsCameraError) {
                        this.f14261a.f14259d.setValue(n.c.f14369a);
                    }
                }
            }
            return Unit.f32013a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Camera2Controller$prepare$1(Camera2Controller camera2Controller, c<? super Camera2Controller$prepare$1> cVar) {
        super(2, cVar);
        this.this$0 = camera2Controller;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new Camera2Controller$prepare$1(this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((Camera2Controller$prepare$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            Camera2Controller camera2Controller = this.this$0;
            b i11 = camera2Controller.p(camera2Controller.f14258c.C());
            a aVar = new a(this.this$0);
            this.label = 1;
            if (i11.a(aVar, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f32013a;
    }
}
