package com.google.android.material.textfield;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import androidx.annotation.NonNull;
import tf.g;
import tf.k;

class h extends g {
    @NonNull
    protected final RectF G;

    @TargetApi(18)
    private static class b extends h {
        b(k kVar) {
            super(kVar);
        }

        /* access modifiers changed from: protected */
        public void r(@NonNull Canvas canvas) {
            if (this.G.isEmpty()) {
                super.r(canvas);
                return;
            }
            canvas.save();
            if (Build.VERSION.SDK_INT >= 26) {
                boolean unused = canvas.clipOutRect(this.G);
            } else {
                canvas.clipRect(this.G, Region.Op.DIFFERENCE);
            }
            super.r(canvas);
            canvas.restore();
        }
    }

    static h o0(k kVar) {
        return new b(kVar);
    }

    /* access modifiers changed from: package-private */
    public boolean p0() {
        return !this.G.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void q0() {
        r0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    /* access modifiers changed from: package-private */
    public void r0(float f10, float f11, float f12, float f13) {
        RectF rectF = this.G;
        if (f10 != rectF.left || f11 != rectF.top || f12 != rectF.right || f13 != rectF.bottom) {
            rectF.set(f10, f11, f12, f13);
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void s0(@NonNull RectF rectF) {
        r0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private h(k kVar) {
        super(kVar == null ? new k() : kVar);
        this.G = new RectF();
    }
}
