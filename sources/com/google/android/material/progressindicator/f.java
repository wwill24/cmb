package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.google.android.material.progressindicator.b;
import e1.c;
import e1.d;
import e1.e;

public final class f<S extends b> extends g {
    private static final c<f> B = new a("indicatorLevel");

    /* renamed from: t  reason: collision with root package name */
    private h<S> f19956t;

    /* renamed from: w  reason: collision with root package name */
    private final e f19957w;

    /* renamed from: x  reason: collision with root package name */
    private final d f19958x;

    /* renamed from: y  reason: collision with root package name */
    private float f19959y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f19960z = false;

    class a extends c<f> {
        a(String str) {
            super(str);
        }

        /* renamed from: c */
        public float a(f fVar) {
            return fVar.x() * 10000.0f;
        }

        /* renamed from: d */
        public void b(f fVar, float f10) {
            fVar.z(f10 / 10000.0f);
        }
    }

    f(@NonNull Context context, @NonNull b bVar, @NonNull h<S> hVar) {
        super(context, bVar);
        y(hVar);
        e eVar = new e();
        this.f19957w = eVar;
        eVar.d(1.0f);
        eVar.f(50.0f);
        d dVar = new d(this, B);
        this.f19958x = dVar;
        dVar.p(eVar);
        n(1.0f);
    }

    @NonNull
    public static f<e> v(@NonNull Context context, @NonNull e eVar) {
        return new f<>(context, eVar, new c(eVar));
    }

    /* access modifiers changed from: private */
    public float x() {
        return this.f19959y;
    }

    /* access modifiers changed from: private */
    public void z(float f10) {
        this.f19959y = f10;
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void A(float f10) {
        setLevel((int) (f10 * 10000.0f));
    }

    public void draw(@NonNull Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.f19956t.g(canvas, getBounds(), h());
            this.f19956t.c(canvas, this.f19974n);
            Canvas canvas2 = canvas;
            this.f19956t.b(canvas2, this.f19974n, 0.0f, x(), hf.a.a(this.f19963b.f19930c[0], getAlpha()));
            canvas.restore();
        }
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    public int getIntrinsicHeight() {
        return this.f19956t.d();
    }

    public int getIntrinsicWidth() {
        return this.f19956t.e();
    }

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean i() {
        return super.i();
    }

    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    public void jumpToCurrentState() {
        this.f19958x.q();
        z(((float) getLevel()) / 10000.0f);
    }

    public /* bridge */ /* synthetic */ boolean k() {
        return super.k();
    }

    public /* bridge */ /* synthetic */ void m(@NonNull androidx.vectordrawable.graphics.drawable.b bVar) {
        super.m(bVar);
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i10) {
        if (this.f19960z) {
            this.f19958x.q();
            z(((float) i10) / 10000.0f);
            return true;
        }
        this.f19958x.h(x() * 10000.0f);
        this.f19958x.l((float) i10);
        return true;
    }

    public /* bridge */ /* synthetic */ boolean q(boolean z10, boolean z11, boolean z12) {
        return super.q(z10, z11, z12);
    }

    /* access modifiers changed from: package-private */
    public boolean r(boolean z10, boolean z11, boolean z12) {
        boolean r10 = super.r(z10, z11, z12);
        float a10 = this.f19964c.a(this.f19962a.getContentResolver());
        if (a10 == 0.0f) {
            this.f19960z = true;
        } else {
            this.f19960z = false;
            this.f19957w.f(50.0f / a10);
        }
        return r10;
    }

    public /* bridge */ /* synthetic */ boolean s(@NonNull androidx.vectordrawable.graphics.drawable.b bVar) {
        return super.s(bVar);
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i10) {
        super.setAlpha(i10);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public /* bridge */ /* synthetic */ boolean setVisible(boolean z10, boolean z11) {
        return super.setVisible(z10, z11);
    }

    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public h<S> w() {
        return this.f19956t;
    }

    /* access modifiers changed from: package-private */
    public void y(@NonNull h<S> hVar) {
        this.f19956t = hVar;
        hVar.f(this);
    }
}
