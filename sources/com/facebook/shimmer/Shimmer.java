package com.facebook.shimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Shimmer {
    private static final int COMPONENT_COUNT = 4;
    boolean alphaShimmer = true;
    long animationDuration = 1000;
    boolean autoStart = true;
    int baseColor = 1291845631;
    final RectF bounds = new RectF();
    boolean clipToChildren = true;
    final int[] colors = new int[4];
    int direction = 0;
    float dropoff = 0.5f;
    int fixedHeight = 0;
    int fixedWidth = 0;
    float heightRatio = 1.0f;
    int highlightColor = -1;
    float intensity = 0.0f;
    final float[] positions = new float[4];
    int repeatCount = -1;
    long repeatDelay;
    int repeatMode = 1;
    int shape = 0;
    float tilt = 20.0f;
    float widthRatio = 1.0f;

    public static class AlphaHighlightBuilder extends Builder<AlphaHighlightBuilder> {
        public AlphaHighlightBuilder() {
            this.mShimmer.alphaShimmer = true;
        }

        /* access modifiers changed from: protected */
        public AlphaHighlightBuilder getThis() {
            return this;
        }
    }

    public static class ColorHighlightBuilder extends Builder<ColorHighlightBuilder> {
        public ColorHighlightBuilder() {
            this.mShimmer.alphaShimmer = false;
        }

        /* access modifiers changed from: protected */
        public ColorHighlightBuilder getThis() {
            return this;
        }

        public ColorHighlightBuilder setBaseColor(int i10) {
            Shimmer shimmer = this.mShimmer;
            shimmer.baseColor = (i10 & 16777215) | (shimmer.baseColor & -16777216);
            return getThis();
        }

        public ColorHighlightBuilder setHighlightColor(int i10) {
            this.mShimmer.highlightColor = i10;
            return getThis();
        }

        /* access modifiers changed from: package-private */
        public ColorHighlightBuilder consumeAttributes(TypedArray typedArray) {
            super.consumeAttributes(typedArray);
            int i10 = R.styleable.ShimmerFrameLayout_shimmer_base_color;
            if (typedArray.hasValue(i10)) {
                setBaseColor(typedArray.getColor(i10, this.mShimmer.baseColor));
            }
            int i11 = R.styleable.ShimmerFrameLayout_shimmer_highlight_color;
            if (typedArray.hasValue(i11)) {
                setHighlightColor(typedArray.getColor(i11, this.mShimmer.highlightColor));
            }
            return getThis();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Direction {
        public static final int BOTTOM_TO_TOP = 3;
        public static final int LEFT_TO_RIGHT = 0;
        public static final int RIGHT_TO_LEFT = 2;
        public static final int TOP_TO_BOTTOM = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Shape {
        public static final int LINEAR = 0;
        public static final int RADIAL = 1;
    }

    Shimmer() {
    }

    /* access modifiers changed from: package-private */
    public int height(int i10) {
        int i11 = this.fixedHeight;
        return i11 > 0 ? i11 : Math.round(this.heightRatio * ((float) i10));
    }

    /* access modifiers changed from: package-private */
    public void updateBounds(int i10, int i11) {
        double max = (double) Math.max(i10, i11);
        int round = Math.round(((float) ((max / Math.sin(1.5707963267948966d - Math.toRadians((double) (this.tilt % 90.0f)))) - max)) / 2.0f) * 3;
        float f10 = (float) (-round);
        this.bounds.set(f10, f10, (float) (width(i10) + round), (float) (height(i11) + round));
    }

    /* access modifiers changed from: package-private */
    public void updateColors() {
        if (this.shape != 1) {
            int[] iArr = this.colors;
            int i10 = this.baseColor;
            iArr[0] = i10;
            int i11 = this.highlightColor;
            iArr[1] = i11;
            iArr[2] = i11;
            iArr[3] = i10;
            return;
        }
        int[] iArr2 = this.colors;
        int i12 = this.highlightColor;
        iArr2[0] = i12;
        iArr2[1] = i12;
        int i13 = this.baseColor;
        iArr2[2] = i13;
        iArr2[3] = i13;
    }

    /* access modifiers changed from: package-private */
    public void updatePositions() {
        if (this.shape != 1) {
            this.positions[0] = Math.max(((1.0f - this.intensity) - this.dropoff) / 2.0f, 0.0f);
            this.positions[1] = Math.max(((1.0f - this.intensity) - 0.001f) / 2.0f, 0.0f);
            this.positions[2] = Math.min(((this.intensity + 1.0f) + 0.001f) / 2.0f, 1.0f);
            this.positions[3] = Math.min(((this.intensity + 1.0f) + this.dropoff) / 2.0f, 1.0f);
            return;
        }
        float[] fArr = this.positions;
        fArr[0] = 0.0f;
        fArr[1] = Math.min(this.intensity, 1.0f);
        this.positions[2] = Math.min(this.intensity + this.dropoff, 1.0f);
        this.positions[3] = 1.0f;
    }

    /* access modifiers changed from: package-private */
    public int width(int i10) {
        int i11 = this.fixedWidth;
        return i11 > 0 ? i11 : Math.round(this.widthRatio * ((float) i10));
    }

    public static abstract class Builder<T extends Builder<T>> {
        final Shimmer mShimmer = new Shimmer();

        private static float clamp(float f10, float f11, float f12) {
            return Math.min(f11, Math.max(f10, f12));
        }

        public Shimmer build() {
            this.mShimmer.updateColors();
            this.mShimmer.updatePositions();
            return this.mShimmer;
        }

        public T consumeAttributes(Context context, AttributeSet attributeSet) {
            return consumeAttributes(context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0));
        }

        public T copyFrom(Shimmer shimmer) {
            setDirection(shimmer.direction);
            setShape(shimmer.shape);
            setFixedWidth(shimmer.fixedWidth);
            setFixedHeight(shimmer.fixedHeight);
            setWidthRatio(shimmer.widthRatio);
            setHeightRatio(shimmer.heightRatio);
            setIntensity(shimmer.intensity);
            setDropoff(shimmer.dropoff);
            setTilt(shimmer.tilt);
            setClipToChildren(shimmer.clipToChildren);
            setAutoStart(shimmer.autoStart);
            setRepeatCount(shimmer.repeatCount);
            setRepeatMode(shimmer.repeatMode);
            setRepeatDelay(shimmer.repeatDelay);
            setDuration(shimmer.animationDuration);
            Shimmer shimmer2 = this.mShimmer;
            shimmer2.baseColor = shimmer.baseColor;
            shimmer2.highlightColor = shimmer.highlightColor;
            return getThis();
        }

        /* access modifiers changed from: protected */
        public abstract T getThis();

        public T setAutoStart(boolean z10) {
            this.mShimmer.autoStart = z10;
            return getThis();
        }

        public T setBaseAlpha(float f10) {
            Shimmer shimmer = this.mShimmer;
            shimmer.baseColor = (((int) (clamp(0.0f, 1.0f, f10) * 255.0f)) << 24) | (shimmer.baseColor & 16777215);
            return getThis();
        }

        public T setClipToChildren(boolean z10) {
            this.mShimmer.clipToChildren = z10;
            return getThis();
        }

        public T setDirection(int i10) {
            this.mShimmer.direction = i10;
            return getThis();
        }

        public T setDropoff(float f10) {
            if (f10 >= 0.0f) {
                this.mShimmer.dropoff = f10;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid dropoff value: " + f10);
        }

        public T setDuration(long j10) {
            if (j10 >= 0) {
                this.mShimmer.animationDuration = j10;
                return getThis();
            }
            throw new IllegalArgumentException("Given a negative duration: " + j10);
        }

        public T setFixedHeight(int i10) {
            if (i10 >= 0) {
                this.mShimmer.fixedHeight = i10;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid height: " + i10);
        }

        public T setFixedWidth(int i10) {
            if (i10 >= 0) {
                this.mShimmer.fixedWidth = i10;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid width: " + i10);
        }

        public T setHeightRatio(float f10) {
            if (f10 >= 0.0f) {
                this.mShimmer.heightRatio = f10;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid height ratio: " + f10);
        }

        public T setHighlightAlpha(float f10) {
            Shimmer shimmer = this.mShimmer;
            shimmer.highlightColor = (((int) (clamp(0.0f, 1.0f, f10) * 255.0f)) << 24) | (shimmer.highlightColor & 16777215);
            return getThis();
        }

        public T setIntensity(float f10) {
            if (f10 >= 0.0f) {
                this.mShimmer.intensity = f10;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid intensity value: " + f10);
        }

        public T setRepeatCount(int i10) {
            this.mShimmer.repeatCount = i10;
            return getThis();
        }

        public T setRepeatDelay(long j10) {
            if (j10 >= 0) {
                this.mShimmer.repeatDelay = j10;
                return getThis();
            }
            throw new IllegalArgumentException("Given a negative repeat delay: " + j10);
        }

        public T setRepeatMode(int i10) {
            this.mShimmer.repeatMode = i10;
            return getThis();
        }

        public T setShape(int i10) {
            this.mShimmer.shape = i10;
            return getThis();
        }

        public T setTilt(float f10) {
            this.mShimmer.tilt = f10;
            return getThis();
        }

        public T setWidthRatio(float f10) {
            if (f10 >= 0.0f) {
                this.mShimmer.widthRatio = f10;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid width ratio: " + f10);
        }

        /* access modifiers changed from: package-private */
        public T consumeAttributes(TypedArray typedArray) {
            int i10 = R.styleable.ShimmerFrameLayout_shimmer_clip_to_children;
            if (typedArray.hasValue(i10)) {
                setClipToChildren(typedArray.getBoolean(i10, this.mShimmer.clipToChildren));
            }
            int i11 = R.styleable.ShimmerFrameLayout_shimmer_auto_start;
            if (typedArray.hasValue(i11)) {
                setAutoStart(typedArray.getBoolean(i11, this.mShimmer.autoStart));
            }
            int i12 = R.styleable.ShimmerFrameLayout_shimmer_base_alpha;
            if (typedArray.hasValue(i12)) {
                setBaseAlpha(typedArray.getFloat(i12, 0.3f));
            }
            int i13 = R.styleable.ShimmerFrameLayout_shimmer_highlight_alpha;
            if (typedArray.hasValue(i13)) {
                setHighlightAlpha(typedArray.getFloat(i13, 1.0f));
            }
            int i14 = R.styleable.ShimmerFrameLayout_shimmer_duration;
            if (typedArray.hasValue(i14)) {
                setDuration((long) typedArray.getInt(i14, (int) this.mShimmer.animationDuration));
            }
            int i15 = R.styleable.ShimmerFrameLayout_shimmer_repeat_count;
            if (typedArray.hasValue(i15)) {
                setRepeatCount(typedArray.getInt(i15, this.mShimmer.repeatCount));
            }
            int i16 = R.styleable.ShimmerFrameLayout_shimmer_repeat_delay;
            if (typedArray.hasValue(i16)) {
                setRepeatDelay((long) typedArray.getInt(i16, (int) this.mShimmer.repeatDelay));
            }
            int i17 = R.styleable.ShimmerFrameLayout_shimmer_repeat_mode;
            if (typedArray.hasValue(i17)) {
                setRepeatMode(typedArray.getInt(i17, this.mShimmer.repeatMode));
            }
            int i18 = R.styleable.ShimmerFrameLayout_shimmer_direction;
            if (typedArray.hasValue(i18)) {
                int i19 = typedArray.getInt(i18, this.mShimmer.direction);
                if (i19 == 1) {
                    setDirection(1);
                } else if (i19 == 2) {
                    setDirection(2);
                } else if (i19 != 3) {
                    setDirection(0);
                } else {
                    setDirection(3);
                }
            }
            int i20 = R.styleable.ShimmerFrameLayout_shimmer_shape;
            if (typedArray.hasValue(i20)) {
                if (typedArray.getInt(i20, this.mShimmer.shape) != 1) {
                    setShape(0);
                } else {
                    setShape(1);
                }
            }
            int i21 = R.styleable.ShimmerFrameLayout_shimmer_dropoff;
            if (typedArray.hasValue(i21)) {
                setDropoff(typedArray.getFloat(i21, this.mShimmer.dropoff));
            }
            int i22 = R.styleable.ShimmerFrameLayout_shimmer_fixed_width;
            if (typedArray.hasValue(i22)) {
                setFixedWidth(typedArray.getDimensionPixelSize(i22, this.mShimmer.fixedWidth));
            }
            int i23 = R.styleable.ShimmerFrameLayout_shimmer_fixed_height;
            if (typedArray.hasValue(i23)) {
                setFixedHeight(typedArray.getDimensionPixelSize(i23, this.mShimmer.fixedHeight));
            }
            int i24 = R.styleable.ShimmerFrameLayout_shimmer_intensity;
            if (typedArray.hasValue(i24)) {
                setIntensity(typedArray.getFloat(i24, this.mShimmer.intensity));
            }
            int i25 = R.styleable.ShimmerFrameLayout_shimmer_width_ratio;
            if (typedArray.hasValue(i25)) {
                setWidthRatio(typedArray.getFloat(i25, this.mShimmer.widthRatio));
            }
            int i26 = R.styleable.ShimmerFrameLayout_shimmer_height_ratio;
            if (typedArray.hasValue(i26)) {
                setHeightRatio(typedArray.getFloat(i26, this.mShimmer.heightRatio));
            }
            int i27 = R.styleable.ShimmerFrameLayout_shimmer_tilt;
            if (typedArray.hasValue(i27)) {
                setTilt(typedArray.getFloat(i27, this.mShimmer.tilt));
            }
            return getThis();
        }
    }
}
