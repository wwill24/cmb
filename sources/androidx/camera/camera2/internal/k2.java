package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.f2;
import androidx.camera.core.impl.i1;
import androidx.camera.core.impl.y0;
import androidx.camera.core.v1;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import o.c0;
import r.p;
import u.c;
import u.f;

class k2 {

    /* renamed from: a  reason: collision with root package name */
    private DeferrableSurface f1829a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final SessionConfig f1830b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final b f1831c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final p f1832d = new p();

    class a implements c<Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Surface f1833a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SurfaceTexture f1834b;

        a(Surface surface, SurfaceTexture surfaceTexture) {
            this.f1833a = surface;
            this.f1834b = surfaceTexture;
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
            this.f1833a.release();
            this.f1834b.release();
        }

        public void onFailure(@NonNull Throwable th2) {
            throw new IllegalStateException("Future should never fail. Did it get completed by GC?", th2);
        }
    }

    private static class b implements f2<UseCase> {
        @NonNull
        private final Config A;

        b() {
            i1 O = i1.O();
            O.p(f2.f2526p, new d1());
            this.A = O;
        }

        @NonNull
        public Config getConfig() {
            return this.A;
        }
    }

    k2(@NonNull c0 c0Var, @NonNull v1 v1Var) {
        b bVar = new b();
        this.f1831c = bVar;
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        Size d10 = d(c0Var, v1Var);
        v1.a("MeteringRepeating", "MeteringSession SurfaceTexture size: " + d10);
        surfaceTexture.setDefaultBufferSize(d10.getWidth(), d10.getHeight());
        Surface surface = new Surface(surfaceTexture);
        SessionConfig.b o10 = SessionConfig.b.o(bVar);
        o10.t(1);
        y0 y0Var = new y0(surface);
        this.f1829a = y0Var;
        f.b(y0Var.i(), new a(surface, surfaceTexture), androidx.camera.core.impl.utils.executor.a.a());
        o10.k(this.f1829a);
        this.f1830b = o10.m();
    }

    @NonNull
    private Size d(@NonNull c0 c0Var, @NonNull v1 v1Var) {
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) c0Var.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null) {
            v1.c("MeteringRepeating", "Can not retrieve SCALER_STREAM_CONFIGURATION_MAP.");
            return new Size(0, 0);
        }
        Size[] outputSizes = streamConfigurationMap.getOutputSizes(34);
        if (outputSizes == null) {
            v1.c("MeteringRepeating", "Can not get output size list.");
            return new Size(0, 0);
        }
        Size[] a10 = this.f1832d.a(outputSizes);
        List asList = Arrays.asList(a10);
        Collections.sort(asList, new j2());
        Size d10 = v1Var.d();
        long min = Math.min(((long) d10.getWidth()) * ((long) d10.getHeight()), 307200);
        Size size = null;
        int length = a10.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            Size size2 = a10[i10];
            int i11 = ((((long) size2.getWidth()) * ((long) size2.getHeight())) > min ? 1 : ((((long) size2.getWidth()) * ((long) size2.getHeight())) == min ? 0 : -1));
            if (i11 == 0) {
                return size2;
            }
            if (i11 <= 0) {
                i10++;
                size = size2;
            } else if (size != null) {
                return size;
            }
        }
        return (Size) asList.get(0);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        v1.a("MeteringRepeating", "MeteringRepeating clear!");
        DeferrableSurface deferrableSurface = this.f1829a;
        if (deferrableSurface != null) {
            deferrableSurface.c();
        }
        this.f1829a = null;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public String c() {
        return "MeteringRepeating";
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public SessionConfig e() {
        return this.f1830b;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public f2<?> f() {
        return this.f1831c;
    }
}
