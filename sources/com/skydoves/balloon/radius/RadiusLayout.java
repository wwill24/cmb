package com.skydoves.balloon.radius;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.mparticle.identity.IdentityHttpResponse;
import com.skydoves.balloon.internals.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.j;
import wk.l;

public final class RadiusLayout extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ l<Object>[] f22841c = {kotlin.jvm.internal.l.d(new MutablePropertyReference1Impl(RadiusLayout.class, "radius", "getRadius()F", 0))};

    /* renamed from: a  reason: collision with root package name */
    private final Path f22842a;

    /* renamed from: b  reason: collision with root package name */
    private final b f22843b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RadiusLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        j.g(context, IdentityHttpResponse.CONTEXT);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RadiusLayout(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        j.g(canvas, "canvas");
        canvas.clipPath(this.f22842a);
        super.dispatchDraw(canvas);
    }

    public final float getRadius() {
        return ((Number) this.f22843b.getValue(this, f22841c[0])).floatValue();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f22842a.addRoundRect(new RectF(0.0f, 0.0f, (float) i10, (float) i11), getRadius(), getRadius(), Path.Direction.CW);
    }

    public final void setRadius(float f10) {
        this.f22843b.setValue(this, f22841c[0], Float.valueOf(f10));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadiusLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f22842a = new Path();
        this.f22843b = j.g(this, "<this>");
    }
}
