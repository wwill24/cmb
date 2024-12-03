package com.leanplum.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.leanplum.utils.SizeUtil;

public class CloseButton extends View {
    private Paint circlePaint = new Paint();
    private Paint circlePressedPaint = new Paint();
    private boolean isPressed = false;
    private Paint linePaint = new Paint();
    private float size;

    /* renamed from: x1  reason: collision with root package name */
    private float f22224x1;

    /* renamed from: x2  reason: collision with root package name */
    private float f22225x2;

    /* renamed from: y1  reason: collision with root package name */
    private float f22226y1;

    /* renamed from: y2  reason: collision with root package name */
    private float f22227y2;

    public CloseButton(Context context) {
        super(context);
        SizeUtil.init(context);
        initLabelView();
    }

    private void initLabelView() {
        this.circlePaint.setAntiAlias(true);
        this.circlePaint.setColor(-2236963);
        this.circlePaint.setStrokeWidth(2.0f);
        this.circlePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.circlePressedPaint.setAntiAlias(true);
        this.circlePressedPaint.setColor(-6710887);
        this.circlePressedPaint.setStrokeWidth(2.0f);
        this.circlePressedPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.linePaint.setAntiAlias(true);
        this.linePaint.setColor(-16777216);
        this.linePaint.setStrokeWidth(3.0f);
        this.linePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        float f10 = (float) SizeUtil.dp30;
        this.size = f10;
        this.f22224x1 = f10 * 0.33333334f;
        this.f22225x2 = f10 * 0.6666667f;
        this.f22226y1 = 0.33333334f * f10;
        this.f22227y2 = f10 * 0.6666667f;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Paint paint;
        super.onDraw(canvas);
        if (this.isPressed) {
            paint = this.circlePressedPaint;
        } else {
            paint = this.circlePaint;
        }
        canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, (((float) getWidth()) / 2.0f) - 1.0f, paint);
        canvas.drawLine(this.f22224x1, this.f22226y1, this.f22225x2, this.f22227y2, this.linePaint);
        canvas.drawLine(this.f22225x2, this.f22226y1, this.f22224x1, this.f22227y2, this.linePaint);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i10);
        float f10 = this.size;
        setMeasuredDimension((int) f10, (int) f10);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.isPressed = true;
            invalidate();
            return true;
        } else if (motionEvent.getAction() != 1) {
            return super.onTouchEvent(motionEvent);
        } else {
            this.isPressed = false;
            invalidate();
            performClick();
            return true;
        }
    }

    public boolean performClick() {
        return super.performClick();
    }

    public CloseButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        SizeUtil.init(context);
        initLabelView();
    }
}
