package com.coffeemeetsbagel.cmb_views;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.mparticle.identity.IdentityHttpResponse;
import kotlin.jvm.internal.j;

public final class FitVerticalImageView extends AppCompatImageView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FitVerticalImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(attributeSet, "attrs");
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private final void c() {
        if (getDrawable() != null && getMeasuredHeight() != 0 && getDrawable().getIntrinsicHeight() != 0) {
            float measuredHeight = ((float) getMeasuredHeight()) / ((float) getDrawable().getIntrinsicHeight());
            float f10 = (float) 2;
            float measuredWidth = (((float) getMeasuredWidth()) - (((float) getDrawable().getIntrinsicWidth()) * measuredHeight)) / f10;
            float measuredHeight2 = (((float) getMeasuredHeight()) - (((float) getDrawable().getIntrinsicHeight()) * measuredHeight)) / f10;
            Matrix imageMatrix = getImageMatrix();
            imageMatrix.setScale(measuredHeight, measuredHeight);
            imageMatrix.postTranslate(measuredWidth, measuredHeight2);
            setImageMatrix(imageMatrix);
        }
    }

    /* access modifiers changed from: protected */
    public boolean setFrame(int i10, int i11, int i12, int i13) {
        c();
        return super.setFrame(i10, i11, i12, i13);
    }
}
