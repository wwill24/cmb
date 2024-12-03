package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.camera2.internal.r2;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.r1;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import p.k;
import r.g;
import r.h;
import r.v;

final class d3 {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final b f1718a;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Executor f1719a;

        /* renamed from: b  reason: collision with root package name */
        private final ScheduledExecutorService f1720b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f1721c;

        /* renamed from: d  reason: collision with root package name */
        private final t1 f1722d;

        /* renamed from: e  reason: collision with root package name */
        private final r1 f1723e;

        /* renamed from: f  reason: collision with root package name */
        private final r1 f1724f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f1725g;

        a(@NonNull Executor executor, @NonNull ScheduledExecutorService scheduledExecutorService, @NonNull Handler handler, @NonNull t1 t1Var, @NonNull r1 r1Var, @NonNull r1 r1Var2) {
            boolean z10;
            this.f1719a = executor;
            this.f1720b = scheduledExecutorService;
            this.f1721c = handler;
            this.f1722d = t1Var;
            this.f1723e = r1Var;
            this.f1724f = r1Var2;
            if (new h(r1Var, r1Var2).b() || new v(r1Var).i() || new g(r1Var2).d()) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f1725g = z10;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: androidx.camera.camera2.internal.c3} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.camera.camera2.internal.x2} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: androidx.camera.camera2.internal.c3} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.camera.camera2.internal.c3} */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Multi-variable type inference failed */
        @androidx.annotation.NonNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.camera.camera2.internal.d3 a() {
            /*
                r9 = this;
                androidx.camera.camera2.internal.d3 r0 = new androidx.camera.camera2.internal.d3
                boolean r1 = r9.f1725g
                if (r1 == 0) goto L_0x0019
                androidx.camera.camera2.internal.c3 r1 = new androidx.camera.camera2.internal.c3
                androidx.camera.core.impl.r1 r3 = r9.f1723e
                androidx.camera.core.impl.r1 r4 = r9.f1724f
                androidx.camera.camera2.internal.t1 r5 = r9.f1722d
                java.util.concurrent.Executor r6 = r9.f1719a
                java.util.concurrent.ScheduledExecutorService r7 = r9.f1720b
                android.os.Handler r8 = r9.f1721c
                r2 = r1
                r2.<init>(r3, r4, r5, r6, r7, r8)
                goto L_0x0026
            L_0x0019:
                androidx.camera.camera2.internal.x2 r1 = new androidx.camera.camera2.internal.x2
                androidx.camera.camera2.internal.t1 r2 = r9.f1722d
                java.util.concurrent.Executor r3 = r9.f1719a
                java.util.concurrent.ScheduledExecutorService r4 = r9.f1720b
                android.os.Handler r5 = r9.f1721c
                r1.<init>(r2, r3, r4, r5)
            L_0x0026:
                r0.<init>(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.d3.a.a():androidx.camera.camera2.internal.d3");
        }
    }

    interface b {
        @NonNull
        Executor a();

        @NonNull
        k b(int i10, @NonNull List<p.b> list, @NonNull r2.a aVar);

        @NonNull
        zf.a<List<Surface>> h(@NonNull List<DeferrableSurface> list, long j10);

        @NonNull
        zf.a<Void> i(@NonNull CameraDevice cameraDevice, @NonNull k kVar, @NonNull List<DeferrableSurface> list);

        boolean stop();
    }

    d3(@NonNull b bVar) {
        this.f1718a = bVar;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public k a(int i10, @NonNull List<p.b> list, @NonNull r2.a aVar) {
        return this.f1718a.b(i10, list, aVar);
    }

    @NonNull
    public Executor b() {
        return this.f1718a.a();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public zf.a<Void> c(@NonNull CameraDevice cameraDevice, @NonNull k kVar, @NonNull List<DeferrableSurface> list) {
        return this.f1718a.i(cameraDevice, kVar, list);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public zf.a<List<Surface>> d(@NonNull List<DeferrableSurface> list, long j10) {
        return this.f1718a.h(list, j10);
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return this.f1718a.stop();
    }
}
