package a0;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.executor.a;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class k implements a0, SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    private final m f55a;

    /* renamed from: b  reason: collision with root package name */
    final HandlerThread f56b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f57c;

    /* renamed from: d  reason: collision with root package name */
    final Handler f58d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f59e;

    /* renamed from: f  reason: collision with root package name */
    private final float[] f60f;

    /* renamed from: g  reason: collision with root package name */
    private final float[] f61g;

    /* renamed from: h  reason: collision with root package name */
    final Map<SurfaceOutput, Surface> f62h;

    /* renamed from: i  reason: collision with root package name */
    private int f63i;

    public k() {
        this(v.f107a);
    }

    /* access modifiers changed from: private */
    public void j() {
        if (this.f59e.get() && this.f63i == 0) {
            for (SurfaceOutput close : this.f62h.keySet()) {
                close.close();
            }
            this.f62h.clear();
            this.f55a.u();
            this.f56b.quit();
        }
    }

    private void k(@NonNull v vVar) {
        try {
            CallbackToFutureAdapter.a(new d(this, vVar)).get();
        } catch (InterruptedException | ExecutionException e10) {
            e = e10;
            if (e instanceof ExecutionException) {
                e = e.getCause();
            }
            if (e instanceof RuntimeException) {
                throw ((RuntimeException) e);
            }
            throw new IllegalStateException("Failed to create DefaultSurfaceProcessor", e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(v vVar, CallbackToFutureAdapter.a aVar) {
        try {
            this.f55a.o(vVar);
            aVar.c(null);
        } catch (RuntimeException e10) {
            aVar.f(e10);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object m(v vVar, CallbackToFutureAdapter.a aVar) throws Exception {
        this.f57c.execute(new f(this, vVar, aVar));
        return "Init GlRenderer";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(SurfaceTexture surfaceTexture, Surface surface, SurfaceRequest.e eVar) {
        surfaceTexture.setOnFrameAvailableListener((SurfaceTexture.OnFrameAvailableListener) null);
        surfaceTexture.release();
        surface.release();
        this.f63i--;
        j();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(SurfaceRequest surfaceRequest) {
        this.f63i++;
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f55a.n());
        surfaceTexture.setDefaultBufferSize(surfaceRequest.m().getWidth(), surfaceRequest.m().getHeight());
        Surface surface = new Surface(surfaceTexture);
        surfaceRequest.w(surface, this.f57c, new j(this, surfaceTexture, surface));
        surfaceTexture.setOnFrameAvailableListener(this, this.f58d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(SurfaceOutput surfaceOutput, SurfaceOutput.a aVar) {
        surfaceOutput.close();
        this.f62h.remove(surfaceOutput);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q(SurfaceOutput surfaceOutput) {
        this.f62h.put(surfaceOutput, surfaceOutput.c(this.f57c, new i(this, surfaceOutput)));
    }

    public void a(@NonNull SurfaceRequest surfaceRequest) {
        if (this.f59e.get()) {
            surfaceRequest.z();
        } else {
            this.f57c.execute(new h(this, surfaceRequest));
        }
    }

    public void b(@NonNull SurfaceOutput surfaceOutput) {
        if (this.f59e.get()) {
            surfaceOutput.close();
        } else {
            this.f57c.execute(new g(this, surfaceOutput));
        }
    }

    public void onFrameAvailable(@NonNull SurfaceTexture surfaceTexture) {
        if (!this.f59e.get()) {
            surfaceTexture.updateTexImage();
            surfaceTexture.getTransformMatrix(this.f60f);
            for (Map.Entry next : this.f62h.entrySet()) {
                this.f55a.x((Surface) next.getValue());
                ((SurfaceOutput) next.getKey()).b(this.f61g, this.f60f);
                this.f55a.w(surfaceTexture.getTimestamp(), this.f61g);
            }
        }
    }

    public void release() {
        if (!this.f59e.getAndSet(true)) {
            this.f57c.execute(new e(this));
        }
    }

    public k(@NonNull v vVar) {
        this.f59e = new AtomicBoolean(false);
        this.f60f = new float[16];
        this.f61g = new float[16];
        this.f62h = new LinkedHashMap();
        this.f63i = 0;
        HandlerThread handlerThread = new HandlerThread("GL Thread");
        this.f56b = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.f58d = handler;
        this.f57c = a.e(handler);
        this.f55a = new m();
        try {
            k(vVar);
        } catch (RuntimeException e10) {
            release();
            throw e10;
        }
    }
}
