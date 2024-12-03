package com.leanplum.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.leanplum.utils.BitmapUtil;
import com.leanplum.utils.SizeUtil;

public class BackgroundImageView extends AppCompatImageView {
    private Matrix emptyMatrix = new Matrix();
    private boolean loadedBitmap;
    private Paint paint = new Paint();
    private boolean roundedCorners;

    public BackgroundImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init();
    }

    private void init() {
        this.paint.setColor(-16711936);
        this.paint.setStrokeWidth(2.0f);
        this.paint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public Bitmap loadBitmapFromView(View view) {
        if (view.getMeasuredHeight() <= 0) {
            view.measure(-2, -2);
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        this.loadedBitmap = true;
        view.draw(canvas);
        return createBitmap;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.roundedCorners) {
            if (this.loadedBitmap) {
                this.loadedBitmap = false;
                return;
            }
            Bitmap loadBitmapFromView = loadBitmapFromView(this);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            canvas.drawBitmap(BitmapUtil.getRoundedCornerBitmap(loadBitmapFromView, SizeUtil.dp20), this.emptyMatrix, this.paint);
        }
    }

    public BackgroundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public BackgroundImageView(Context context, boolean z10) {
        super(context);
        init();
        this.roundedCorners = !z10;
    }

    public BackgroundImageView(Context context, int i10, Bitmap bitmap, boolean z10) {
        super(context);
        this.roundedCorners = z10;
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        setImageBitmap(bitmap);
        ViewUtils.applyBackground(this, i10, z10);
        init();
    }
}
