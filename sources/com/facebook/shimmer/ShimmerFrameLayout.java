package com.facebook.shimmer;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.facebook.shimmer.Shimmer;

public class ShimmerFrameLayout extends FrameLayout {
    private final Paint mContentPaint = new Paint();
    private final ShimmerDrawable mShimmerDrawable = new ShimmerDrawable();
    private boolean mShowShimmer = true;

    public ShimmerFrameLayout(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Shimmer.Builder builder;
        setWillNotDraw(false);
        this.mShimmerDrawable.setCallback(this);
        if (attributeSet == null) {
            setShimmer(new Shimmer.AlphaHighlightBuilder().build());
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0);
        try {
            int i10 = R.styleable.ShimmerFrameLayout_shimmer_colored;
            if (!obtainStyledAttributes.hasValue(i10) || !obtainStyledAttributes.getBoolean(i10, false)) {
                builder = new Shimmer.AlphaHighlightBuilder();
            } else {
                builder = new Shimmer.ColorHighlightBuilder();
            }
            setShimmer(builder.consumeAttributes(obtainStyledAttributes).build());
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mShowShimmer) {
            this.mShimmerDrawable.draw(canvas);
        }
    }

    public void hideShimmer() {
        if (this.mShowShimmer) {
            stopShimmer();
            this.mShowShimmer = false;
            invalidate();
        }
    }

    public boolean isShimmerStarted() {
        return this.mShimmerDrawable.isShimmerStarted();
    }

    public boolean isShimmerVisible() {
        return this.mShowShimmer;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mShimmerDrawable.maybeStartShimmer();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopShimmer();
    }

    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        this.mShimmerDrawable.setBounds(0, 0, getWidth(), getHeight());
    }

    public ShimmerFrameLayout setShimmer(Shimmer shimmer) {
        this.mShimmerDrawable.setShimmer(shimmer);
        if (shimmer == null || !shimmer.clipToChildren) {
            setLayerType(0, (Paint) null);
        } else {
            setLayerType(2, this.mContentPaint);
        }
        return this;
    }

    public void showShimmer(boolean z10) {
        if (!this.mShowShimmer) {
            this.mShowShimmer = true;
            if (z10) {
                startShimmer();
            }
        }
    }

    public void startShimmer() {
        this.mShimmerDrawable.startShimmer();
    }

    public void stopShimmer() {
        this.mShimmerDrawable.stopShimmer();
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mShimmerDrawable;
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init(context, attributeSet);
    }

    @TargetApi(21)
    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        init(context, attributeSet);
    }
}
