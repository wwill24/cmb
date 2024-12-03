package androidx.camera.core;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.h0;
import androidx.camera.core.impl.x0;
import java.util.concurrent.Executor;

public class s2 implements x0 {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2890a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private int f2891b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2892c = false;

    /* renamed from: d  reason: collision with root package name */
    private final x0 f2893d;

    /* renamed from: e  reason: collision with root package name */
    private final Surface f2894e;

    /* renamed from: f  reason: collision with root package name */
    private h0.a f2895f;

    /* renamed from: g  reason: collision with root package name */
    private final h0.a f2896g = new q2(this);

    public s2(@NonNull x0 x0Var) {
        this.f2893d = x0Var;
        this.f2894e = x0Var.getSurface();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(o1 o1Var) {
        h0.a aVar;
        synchronized (this.f2890a) {
            int i10 = this.f2891b - 1;
            this.f2891b = i10;
            if (this.f2892c && i10 == 0) {
                close();
            }
            aVar = this.f2895f;
        }
        if (aVar != null) {
            aVar.a(o1Var);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(x0.a aVar, x0 x0Var) {
        aVar.a(this);
    }

    private o1 n(o1 o1Var) {
        if (o1Var == null) {
            return null;
        }
        this.f2891b++;
        v2 v2Var = new v2(o1Var);
        v2Var.a(this.f2896g);
        return v2Var;
    }

    public o1 b() {
        o1 n10;
        synchronized (this.f2890a) {
            n10 = n(this.f2893d.b());
        }
        return n10;
    }

    public int c() {
        int c10;
        synchronized (this.f2890a) {
            c10 = this.f2893d.c();
        }
        return c10;
    }

    public void close() {
        synchronized (this.f2890a) {
            Surface surface = this.f2894e;
            if (surface != null) {
                surface.release();
            }
            this.f2893d.close();
        }
    }

    public void d() {
        synchronized (this.f2890a) {
            this.f2893d.d();
        }
    }

    public int e() {
        int e10;
        synchronized (this.f2890a) {
            e10 = this.f2893d.e();
        }
        return e10;
    }

    public void f(@NonNull x0.a aVar, @NonNull Executor executor) {
        synchronized (this.f2890a) {
            this.f2893d.f(new r2(this, aVar), executor);
        }
    }

    public o1 g() {
        o1 n10;
        synchronized (this.f2890a) {
            n10 = n(this.f2893d.g());
        }
        return n10;
    }

    public int getHeight() {
        int height;
        synchronized (this.f2890a) {
            height = this.f2893d.getHeight();
        }
        return height;
    }

    public Surface getSurface() {
        Surface surface;
        synchronized (this.f2890a) {
            surface = this.f2893d.getSurface();
        }
        return surface;
    }

    public int getWidth() {
        int width;
        synchronized (this.f2890a) {
            width = this.f2893d.getWidth();
        }
        return width;
    }

    public int i() {
        int e10;
        synchronized (this.f2890a) {
            e10 = this.f2893d.e() - this.f2891b;
        }
        return e10;
    }

    public void l() {
        synchronized (this.f2890a) {
            this.f2892c = true;
            this.f2893d.d();
            if (this.f2891b == 0) {
                close();
            }
        }
    }

    public void m(@NonNull h0.a aVar) {
        synchronized (this.f2890a) {
            this.f2895f = aVar;
        }
    }
}
