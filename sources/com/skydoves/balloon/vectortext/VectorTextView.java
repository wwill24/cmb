package com.skydoves.balloon.vectortext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.d0;
import com.mparticle.identity.IdentityHttpResponse;
import com.skydoves.balloon.v;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import xh.d;
import zh.a;

public final class VectorTextView extends d0 {

    /* renamed from: h  reason: collision with root package name */
    private a f22844h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VectorTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.g(context, IdentityHttpResponse.CONTEXT);
        r(context, attributeSet);
    }

    private final void r(Context context, AttributeSet attributeSet) {
        AttributeSet attributeSet2 = attributeSet;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet2, v.VectorTextView);
            j.f(obtainStyledAttributes, "context.obtainStyledAttr…styleable.VectorTextView)");
            setDrawableTextViewParams(new a(com.skydoves.balloon.internals.a.a(obtainStyledAttributes.getResourceId(v.VectorTextView_balloon_drawableStart, Integer.MIN_VALUE)), com.skydoves.balloon.internals.a.a(obtainStyledAttributes.getResourceId(v.VectorTextView_balloon_drawableEnd, Integer.MIN_VALUE)), com.skydoves.balloon.internals.a.a(obtainStyledAttributes.getResourceId(v.VectorTextView_balloon_drawableBottom, Integer.MIN_VALUE)), com.skydoves.balloon.internals.a.a(obtainStyledAttributes.getResourceId(v.VectorTextView_balloon_drawableTop, Integer.MIN_VALUE)), (Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null, false, (CharSequence) null, (Integer) null, (Integer) null, (Integer) null, com.skydoves.balloon.internals.a.a(obtainStyledAttributes.getResourceId(v.VectorTextView_balloon_drawablePadding, Integer.MIN_VALUE)), com.skydoves.balloon.internals.a.a(obtainStyledAttributes.getColor(v.VectorTextView_balloon_drawableTintColor, Integer.MIN_VALUE)), com.skydoves.balloon.internals.a.a(obtainStyledAttributes.getResourceId(v.VectorTextView_balloon_drawableWidth, Integer.MIN_VALUE)), com.skydoves.balloon.internals.a.a(obtainStyledAttributes.getResourceId(v.VectorTextView_balloon_drawableHeight, Integer.MIN_VALUE)), com.skydoves.balloon.internals.a.a(obtainStyledAttributes.getResourceId(v.VectorTextView_balloon_drawableSquareSize, Integer.MIN_VALUE)), 8176, (DefaultConstructorMarker) null));
            obtainStyledAttributes.recycle();
            return;
        }
    }

    public final a getDrawableTextViewParams() {
        return this.f22844h;
    }

    public final void s(boolean z10) {
        a aVar = this.f22844h;
        if (aVar != null) {
            aVar.A(z10);
            d.a(this, aVar);
        }
    }

    public final void setDrawableTextViewParams(a aVar) {
        if (aVar != null) {
            d.a(this, aVar);
        } else {
            aVar = null;
        }
        this.f22844h = aVar;
    }
}
