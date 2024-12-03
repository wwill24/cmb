package com.withpersona.sdk2.inquiry.governmentid.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.withpersona.sdk2.inquiry.governmentid.p0;
import com.withpersona.sdk2.inquiry.shared.ui.k;

public final class SpotlightView extends View {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f26032a;

    /* renamed from: b  reason: collision with root package name */
    private float f26033b;

    /* renamed from: c  reason: collision with root package name */
    private Path f26034c;

    public SpotlightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    private final void c(Context context, AttributeSet attributeSet) {
        Resources.Theme theme;
        TypedArray obtainStyledAttributes;
        if (context != null && (theme = context.getTheme()) != null && (obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, p0.Pi2Spotlight, 0, 0)) != null) {
            try {
                this.f26032a = obtainStyledAttributes.getResourceId(p0.Pi2Spotlight_pi2Target, 0);
                this.f26033b = obtainStyledAttributes.getDimension(p0.Pi2Spotlight_pi2Radius, 0.0f);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void d(int i10, int i11, int i12, int i13) {
        Path path = new Path();
        float f10 = this.f26033b;
        path.addRoundRect((float) i10, (float) i11, (float) i12, (float) i13, f10, f10, Path.Direction.CW);
        this.f26034c = path;
        invalidate();
    }

    public void draw(Canvas canvas) {
        Path path = this.f26034c;
        if (path != null) {
            if (canvas != null) {
                canvas.save();
            }
            if (Build.VERSION.SDK_INT >= 26) {
                if (canvas != null) {
                    boolean unused = canvas.clipOutPath(path);
                }
            } else if (canvas != null) {
                canvas.clipPath(path, Region.Op.DIFFERENCE);
            }
            super.draw(canvas);
            if (canvas != null) {
                canvas.restore();
                return;
            }
            return;
        }
        super.draw(canvas);
    }

    public final float getRadius() {
        return this.f26033b;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        k.b(this, new SpotlightView$onFinishInflate$1(this));
    }

    public final void setRadius(float f10) {
        this.f26033b = f10;
    }
}
