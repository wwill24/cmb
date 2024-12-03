package com.withpersona.sdk2.camera.camera2;

import android.view.View;
import com.withpersona.sdk2.camera.camera2.Camera2Manager;
import com.withpersona.sdk2.camera.g;
import com.withpersona.sdk2.camera.n;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.r;
import kotlinx.coroutines.flow.s;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.o2;
import kotlinx.coroutines.s1;
import kotlinx.coroutines.x0;

public final class Camera2Controller implements g {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final d f14256a;

    /* renamed from: b  reason: collision with root package name */
    private final k0 f14257b = l0.a(x0.a().e0(o2.b((s1) null, 1, (Object) null)));
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Camera2Manager f14258c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public i<n> f14259d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f14260e;

    public Camera2Controller(d dVar) {
        j.g(dVar, "camera2ManagerFactory");
        this.f14256a = dVar;
        this.f14258c = dVar.a();
        this.f14259d = s.a(n.c.f14369a);
    }

    /* access modifiers changed from: private */
    public final b<Camera2Manager.b> p(r<? extends Camera2Manager.b> rVar) {
        return d.J(rVar, new Camera2Controller$completeWhenDestroyed$1((c<? super Camera2Controller$completeWhenDestroyed$1>) null));
    }

    public void a(boolean z10) {
        this.f14258c.z(z10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(kotlin.coroutines.c<? super java.lang.Boolean> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.withpersona.sdk2.camera.camera2.Camera2Controller$startVideo$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.withpersona.sdk2.camera.camera2.Camera2Controller$startVideo$1 r0 = (com.withpersona.sdk2.camera.camera2.Camera2Controller$startVideo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.withpersona.sdk2.camera.camera2.Camera2Controller$startVideo$1 r0 = new com.withpersona.sdk2.camera.camera2.Camera2Controller$startVideo$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.L$0
            com.withpersona.sdk2.camera.camera2.Camera2Controller r0 = (com.withpersona.sdk2.camera.camera2.Camera2Controller) r0
            gk.g.b(r5)
            goto L_0x005a
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            gk.g.b(r5)
            kotlinx.coroutines.flow.i<com.withpersona.sdk2.camera.n> r5 = r4.f14259d
            java.lang.Object r5 = r5.getValue()
            com.withpersona.sdk2.camera.n$e r2 = com.withpersona.sdk2.camera.n.e.f14371a
            boolean r5 = kotlin.jvm.internal.j.b(r5, r2)
            if (r5 != 0) goto L_0x004c
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.a.a(r5)
            return r5
        L_0x004c:
            com.withpersona.sdk2.camera.camera2.Camera2Manager r5 = r4.f14258c
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.N(r0)
            if (r5 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r0 = r4
        L_0x005a:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0064
            r0.f14260e = r3
        L_0x0064:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.a.a(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.camera2.Camera2Controller.b(kotlin.coroutines.c):java.lang.Object");
    }

    public r<n> c() {
        return this.f14259d;
    }

    public View d() {
        return this.f14258c.B();
    }

    public void e() {
        this.f14258c.A();
    }

    public void f(boolean z10) {
        this.f14258c.K(z10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object g(kotlin.coroutines.c<? super kotlin.Result<? extends java.io.File>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.withpersona.sdk2.camera.camera2.Camera2Controller$stopVideo$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.withpersona.sdk2.camera.camera2.Camera2Controller$stopVideo$1 r0 = (com.withpersona.sdk2.camera.camera2.Camera2Controller$stopVideo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.withpersona.sdk2.camera.camera2.Camera2Controller$stopVideo$1 r0 = new com.withpersona.sdk2.camera.camera2.Camera2Controller$stopVideo$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            gk.g.b(r5)
            kotlin.Result r5 = (kotlin.Result) r5
            java.lang.Object r5 = r5.j()
            goto L_0x0048
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            gk.g.b(r5)
            r5 = 0
            r4.f14260e = r5
            com.withpersona.sdk2.camera.camera2.Camera2Manager r5 = r4.f14258c
            r0.label = r3
            java.lang.Object r5 = r5.O(r0)
            if (r5 != r1) goto L_0x0048
            return r1
        L_0x0048:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.camera2.Camera2Controller.g(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object h(kotlin.coroutines.c<? super kotlin.Result<? extends java.io.File>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.withpersona.sdk2.camera.camera2.Camera2Controller$takePicture$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.withpersona.sdk2.camera.camera2.Camera2Controller$takePicture$1 r0 = (com.withpersona.sdk2.camera.camera2.Camera2Controller$takePicture$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.withpersona.sdk2.camera.camera2.Camera2Controller$takePicture$1 r0 = new com.withpersona.sdk2.camera.camera2.Camera2Controller$takePicture$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            gk.g.b(r5)
            kotlin.Result r5 = (kotlin.Result) r5
            java.lang.Object r5 = r5.j()
            goto L_0x0045
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            gk.g.b(r5)
            com.withpersona.sdk2.camera.camera2.Camera2Manager r5 = r4.f14258c
            r0.label = r3
            java.lang.Object r5 = r5.I(r0)
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.camera.camera2.Camera2Controller.h(kotlin.coroutines.c):java.lang.Object");
    }

    public void prepare() {
        if (j.b(this.f14259d.getValue(), n.c.f14369a) || (this.f14259d.getValue() instanceof n.a)) {
            this.f14259d.setValue(n.d.f14370a);
            s1 unused = j.d(this.f14257b, (CoroutineContext) null, (CoroutineStart) null, new Camera2Controller$prepare$1(this, (c<? super Camera2Controller$prepare$1>) null), 3, (Object) null);
            this.f14258c.L();
        }
    }
}
