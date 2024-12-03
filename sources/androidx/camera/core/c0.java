package androidx.camera.core;

import android.media.ImageReader;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.e0;
import androidx.camera.core.impl.w0;
import androidx.camera.core.impl.x0;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import u.f;
import zf.a;

class c0 implements e0 {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final e0 f2192a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final e0 f2193b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final a<List<Void>> f2194c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    final Executor f2195d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2196e;

    /* renamed from: f  reason: collision with root package name */
    private x0 f2197f = null;

    /* renamed from: g  reason: collision with root package name */
    private l1 f2198g = null;

    /* renamed from: h  reason: collision with root package name */
    private final Object f2199h = new Object();

    /* renamed from: i  reason: collision with root package name */
    private boolean f2200i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2201j = false;

    /* renamed from: k  reason: collision with root package name */
    CallbackToFutureAdapter.a<Void> f2202k;

    /* renamed from: l  reason: collision with root package name */
    private a<Void> f2203l;

    c0(@NonNull e0 e0Var, int i10, @NonNull e0 e0Var2, @NonNull Executor executor) {
        this.f2192a = e0Var;
        this.f2193b = e0Var2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(e0Var.b());
        arrayList.add(e0Var2.b());
        this.f2194c = f.c(arrayList);
        this.f2195d = executor;
        this.f2196e = i10;
    }

    private void j() {
        boolean z10;
        boolean z11;
        CallbackToFutureAdapter.a<Void> aVar;
        synchronized (this.f2199h) {
            z10 = this.f2200i;
            z11 = this.f2201j;
            aVar = this.f2202k;
            if (z10 && !z11) {
                this.f2197f.close();
            }
        }
        if (z10 && !z11 && aVar != null) {
            this.f2194c.addListener(new a0(aVar), androidx.camera.core.impl.utils.executor.a.a());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Void l(List list) {
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object m(CallbackToFutureAdapter.a aVar) throws Exception {
        synchronized (this.f2199h) {
            this.f2202k = aVar;
        }
        return "CaptureProcessorPipeline-close";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(x0 x0Var) {
        o1 g10 = x0Var.g();
        try {
            this.f2195d.execute(new b0(this, g10));
        } catch (RejectedExecutionException unused) {
            v1.c("CaptureProcessorPipeline", "The executor for post-processing might have been shutting down or terminated!");
            g10.close();
        }
    }

    public void a(@NonNull Surface surface, int i10) {
        this.f2193b.a(surface, i10);
    }

    @NonNull
    public a<Void> b() {
        a<Void> aVar;
        synchronized (this.f2199h) {
            if (!this.f2200i || this.f2201j) {
                if (this.f2203l == null) {
                    this.f2203l = CallbackToFutureAdapter.a(new z(this));
                }
                aVar = f.j(this.f2203l);
            } else {
                aVar = f.o(this.f2194c, new y(), androidx.camera.core.impl.utils.executor.a.a());
            }
        }
        return aVar;
    }

    public void c(@NonNull Size size) {
        d dVar = new d(ImageReader.newInstance(size.getWidth(), size.getHeight(), 35, this.f2196e));
        this.f2197f = dVar;
        this.f2192a.a(dVar.getSurface(), 35);
        this.f2192a.c(size);
        this.f2193b.c(size);
        this.f2197f.f(new x(this), androidx.camera.core.impl.utils.executor.a.a());
    }

    public void close() {
        synchronized (this.f2199h) {
            if (!this.f2200i) {
                this.f2200i = true;
                this.f2192a.close();
                this.f2193b.close();
                j();
            }
        }
    }

    public void d(@NonNull w0 w0Var) {
        synchronized (this.f2199h) {
            if (!this.f2200i) {
                this.f2201j = true;
                a<o1> b10 = w0Var.b(w0Var.a().get(0).intValue());
                h.a(b10.isDone());
                try {
                    this.f2198g = b10.get().z1();
                    this.f2192a.d(w0Var);
                } catch (InterruptedException | ExecutionException unused) {
                    throw new IllegalArgumentException("Can not successfully extract ImageProxy from the ImageProxyBundle.");
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void n(o1 o1Var) {
        boolean z10;
        synchronized (this.f2199h) {
            z10 = this.f2200i;
        }
        if (!z10) {
            Size size = new Size(o1Var.getWidth(), o1Var.getHeight());
            h.g(this.f2198g);
            String next = this.f2198g.c().d().iterator().next();
            int intValue = ((Integer) this.f2198g.c().c(next)).intValue();
            t2 t2Var = new t2(o1Var, size, this.f2198g);
            this.f2198g = null;
            u2 u2Var = new u2(Collections.singletonList(Integer.valueOf(intValue)), next);
            u2Var.c(t2Var);
            try {
                this.f2193b.d(u2Var);
            } catch (Exception e10) {
                v1.c("CaptureProcessorPipeline", "Post processing image failed! " + e10.getMessage());
            }
        }
        synchronized (this.f2199h) {
            this.f2201j = false;
        }
        j();
    }
}
