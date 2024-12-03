package com.withpersona.sdk2.camera.camera2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.api.a;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public final class Camera2PreviewView extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private int f14297a;

    /* renamed from: b  reason: collision with root package name */
    private int f14298b;

    /* renamed from: c  reason: collision with root package name */
    private SurfaceView f14299c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Camera2PreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.g(context, IdentityHttpResponse.CONTEXT);
        SurfaceView surfaceView = new SurfaceView(getContext());
        this.f14299c = surfaceView;
        addView(surfaceView);
    }

    public final void a() {
        removeAllViews();
        SurfaceView surfaceView = new SurfaceView(getContext());
        this.f14299c = surfaceView;
        addView(surfaceView);
        requestLayout();
    }

    public final void b(int i10, int i11, int i12) {
        if (i12 == 90 || i12 == 270) {
            this.f14297a = i11;
            this.f14298b = i10;
        } else {
            this.f14297a = i10;
            this.f14298b = i11;
        }
        getHolder().setFixedSize(i10, i11);
        requestLayout();
    }

    public final SurfaceHolder getHolder() {
        SurfaceHolder holder = this.f14299c.getHolder();
        j.f(holder, "surfaceView.holder");
        return holder;
    }

    public final SurfaceView getSurfaceView() {
        return this.f14299c;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.f14297a == 0 || this.f14298b == 0) {
            this.f14299c.layout(i10, i11, i12, i13);
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        double max = Double.max(((double) measuredWidth) / ((double) this.f14297a), ((double) measuredHeight) / ((double) this.f14298b));
        int ceil = (int) Math.ceil(((double) this.f14297a) * max);
        int ceil2 = (int) Math.ceil(max * ((double) this.f14298b));
        int c10 = (j.c(ceil - measuredWidth, 0) / 2) * -1;
        int c11 = (j.c(ceil2 - measuredHeight, 0) / 2) * -1;
        this.f14299c.layout(c10, c11, ceil + c10, ceil2 + c11);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension(View.resolveSize(a.e.API_PRIORITY_OTHER, i10), View.resolveSize(a.e.API_PRIORITY_OTHER, i11));
        this.f14299c.measure(View.MeasureSpec.makeMeasureSpec(this.f14297a, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f14298b, 1073741824));
    }

    public final void setSurfaceView(SurfaceView surfaceView) {
        j.g(surfaceView, "<set-?>");
        this.f14299c = surfaceView;
    }
}
