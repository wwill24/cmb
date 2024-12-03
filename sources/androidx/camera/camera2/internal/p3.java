package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageWriter;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.n;
import androidx.camera.core.impl.utils.e;
import androidx.camera.core.impl.x0;
import androidx.camera.core.impl.y0;
import androidx.camera.core.o1;
import androidx.camera.core.s2;
import androidx.camera.core.v1;
import androidx.camera.core.y1;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import o.c0;
import z.d;

final class p3 implements l3 {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final Map<Integer, Size> f1906a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final c0 f1907b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    final d f1908c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1909d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1910e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1911f = false;

    /* renamed from: g  reason: collision with root package name */
    s2 f1912g;

    /* renamed from: h  reason: collision with root package name */
    private n f1913h;

    /* renamed from: i  reason: collision with root package name */
    private DeferrableSurface f1914i;

    /* renamed from: j  reason: collision with root package name */
    ImageWriter f1915j;

    class a extends CameraCaptureSession.StateCallback {
        a() {
        }

        public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
        }

        public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
            Surface inputSurface = cameraCaptureSession.getInputSurface();
            if (inputSurface != null) {
                p3.this.f1915j = w.a.c(inputSurface, 1);
            }
        }
    }

    p3(@NonNull c0 c0Var) {
        this.f1907b = c0Var;
        this.f1911f = q3.a(c0Var, 4);
        this.f1906a = k(c0Var);
        this.f1908c = new d(3, new o3());
    }

    private void j() {
        d dVar = this.f1908c;
        while (!dVar.isEmpty()) {
            ((o1) dVar.a()).close();
        }
        DeferrableSurface deferrableSurface = this.f1914i;
        if (deferrableSurface != null) {
            s2 s2Var = this.f1912g;
            if (s2Var != null) {
                deferrableSurface.i().addListener(new n3(s2Var), androidx.camera.core.impl.utils.executor.a.d());
                this.f1912g = null;
            }
            deferrableSurface.c();
            this.f1914i = null;
        }
        ImageWriter imageWriter = this.f1915j;
        if (imageWriter != null) {
            imageWriter.close();
            this.f1915j = null;
        }
    }

    @NonNull
    private Map<Integer, Size> k(@NonNull c0 c0Var) {
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) c0Var.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null || streamConfigurationMap.getInputFormats() == null) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap();
        for (int i10 : streamConfigurationMap.getInputFormats()) {
            Size[] inputSizes = streamConfigurationMap.getInputSizes(i10);
            if (inputSizes != null) {
                Arrays.sort(inputSizes, new e(true));
                hashMap.put(Integer.valueOf(i10), inputSizes[0]);
            }
        }
        return hashMap;
    }

    private boolean l(@NonNull c0 c0Var, int i10) {
        int[] validOutputFormatsForInput;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) c0Var.a(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null || (validOutputFormatsForInput = streamConfigurationMap.getValidOutputFormatsForInput(i10)) == null) {
            return false;
        }
        for (int i11 : validOutputFormatsForInput) {
            if (i11 == 256) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(x0 x0Var) {
        try {
            o1 b10 = x0Var.b();
            if (b10 != null) {
                this.f1908c.b(b10);
            }
        } catch (IllegalStateException e10) {
            v1.c("ZslControlImpl", "Failed to acquire latest image IllegalStateException = " + e10.getMessage());
        }
    }

    public void b(@NonNull SessionConfig.b bVar) {
        j();
        if (!this.f1909d && this.f1911f && !this.f1906a.isEmpty() && this.f1906a.containsKey(34) && l(this.f1907b, 34)) {
            Size size = this.f1906a.get(34);
            y1 y1Var = new y1(size.getWidth(), size.getHeight(), 34, 9);
            this.f1913h = y1Var.m();
            this.f1912g = new s2(y1Var);
            y1Var.f(new m3(this), androidx.camera.core.impl.utils.executor.a.c());
            y0 y0Var = new y0(this.f1912g.getSurface(), new Size(this.f1912g.getWidth(), this.f1912g.getHeight()), 34);
            this.f1914i = y0Var;
            s2 s2Var = this.f1912g;
            zf.a<Void> i10 = y0Var.i();
            Objects.requireNonNull(s2Var);
            i10.addListener(new n3(s2Var), androidx.camera.core.impl.utils.executor.a.d());
            bVar.k(this.f1914i);
            bVar.d(this.f1913h);
            bVar.j(new a());
            bVar.s(new InputConfiguration(this.f1912g.getWidth(), this.f1912g.getHeight(), this.f1912g.c()));
        }
    }

    public boolean c() {
        return this.f1909d;
    }

    public void d(boolean z10) {
        this.f1910e = z10;
    }

    public void e(boolean z10) {
        this.f1909d = z10;
    }

    public o1 f() {
        try {
            return (o1) this.f1908c.a();
        } catch (NoSuchElementException unused) {
            v1.c("ZslControlImpl", "dequeueImageFromBuffer no such element");
            return null;
        }
    }

    public boolean g(@NonNull o1 o1Var) {
        Image t10 = o1Var.t();
        ImageWriter imageWriter = this.f1915j;
        if (!(imageWriter == null || t10 == null)) {
            try {
                w.a.e(imageWriter, t10);
                return true;
            } catch (IllegalStateException e10) {
                v1.c("ZslControlImpl", "enqueueImageToImageWriter throws IllegalStateException = " + e10.getMessage());
            }
        }
        return false;
    }

    public boolean h() {
        return this.f1910e;
    }
}
