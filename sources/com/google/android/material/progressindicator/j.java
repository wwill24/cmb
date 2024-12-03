package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import com.google.android.material.progressindicator.b;

public final class j<S extends b> extends g {

    /* renamed from: t  reason: collision with root package name */
    private h<S> f19983t;

    /* renamed from: w  reason: collision with root package name */
    private i<ObjectAnimator> f19984w;

    j(@NonNull Context context, @NonNull b bVar, @NonNull h<S> hVar, @NonNull i<ObjectAnimator> iVar) {
        super(context, bVar);
        x(hVar);
        w(iVar);
    }

    @NonNull
    public static j<e> t(@NonNull Context context, @NonNull e eVar) {
        return new j<>(context, eVar, new c(eVar), new d(eVar));
    }

    public void draw(@NonNull Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.f19983t.g(canvas, getBounds(), h());
            this.f19983t.c(canvas, this.f19974n);
            int i10 = 0;
            while (true) {
                i<ObjectAnimator> iVar = this.f19984w;
                int[] iArr = iVar.f19982c;
                if (i10 < iArr.length) {
                    h<S> hVar = this.f19983t;
                    Paint paint = this.f19974n;
                    float[] fArr = iVar.f19981b;
                    int i11 = i10 * 2;
                    hVar.b(canvas, paint, fArr[i11], fArr[i11 + 1], iArr[i10]);
                    i10++;
                } else {
                    canvas.restore();
                    return;
                }
            }
        }
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    public int getIntrinsicHeight() {
        return this.f19983t.d();
    }

    public int getIntrinsicWidth() {
        return this.f19983t.e();
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

    public /* bridge */ /* synthetic */ boolean k() {
        return super.k();
    }

    public /* bridge */ /* synthetic */ void m(@NonNull androidx.vectordrawable.graphics.drawable.b bVar) {
        super.m(bVar);
    }

    public /* bridge */ /* synthetic */ boolean q(boolean z10, boolean z11, boolean z12) {
        return super.q(z10, z11, z12);
    }

    /* access modifiers changed from: package-private */
    public boolean r(boolean z10, boolean z11, boolean z12) {
        boolean r10 = super.r(z10, z11, z12);
        if (!isRunning()) {
            this.f19984w.a();
        }
        this.f19964c.a(this.f19962a.getContentResolver());
        if (z10 && z12) {
            this.f19984w.g();
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
    public i<ObjectAnimator> u() {
        return this.f19984w;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public h<S> v() {
        return this.f19983t;
    }

    /* access modifiers changed from: package-private */
    public void w(@NonNull i<ObjectAnimator> iVar) {
        this.f19984w = iVar;
        iVar.e(this);
    }

    /* access modifiers changed from: package-private */
    public void x(@NonNull h<S> hVar) {
        this.f19983t = hVar;
        hVar.f(this);
    }
}
