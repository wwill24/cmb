package com.clevertap.android.sdk.customviews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatImageView;
import com.clevertap.android.sdk.p;

public final class CloseImageView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private final int f10145a = c(40);

    @SuppressLint({"ResourceType"})
    public CloseImageView(Context context) {
        super(context);
        setId(199272);
    }

    private int c(int i10) {
        return (int) TypedValue.applyDimension(1, (float) i10, getResources().getDisplayMetrics());
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            Context context = getContext();
            Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier("ct_close", "drawable", context.getPackageName()), (BitmapFactory.Options) null);
            if (decodeResource != null) {
                int i10 = this.f10145a;
                canvas.drawBitmap(Bitmap.createScaledBitmap(decodeResource, i10, i10, true), 0.0f, 0.0f, new Paint());
                return;
            }
            p.o("Unable to find inapp notif close button image");
        } catch (Throwable th2) {
            p.r("Error displaying the inapp notif close button image:", th2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        int i12 = this.f10145a;
        setMeasuredDimension(i12, i12);
    }

    @SuppressLint({"ResourceType"})
    public CloseImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setId(199272);
    }
}
