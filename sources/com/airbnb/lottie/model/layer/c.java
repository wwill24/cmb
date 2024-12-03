package com.airbnb.lottie.model.layer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import c3.j;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.d0;
import com.airbnb.lottie.h0;
import s2.a;
import u2.q;

public class c extends a {
    private final Paint D = new a(3);
    private final Rect E = new Rect();
    private final Rect F = new Rect();
    private final d0 G;
    private u2.a<ColorFilter, ColorFilter> H;
    private u2.a<Bitmap, Bitmap> I;

    c(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.G = lottieDrawable.M(layer.m());
    }

    private Bitmap O() {
        Bitmap h10;
        u2.a<Bitmap, Bitmap> aVar = this.I;
        if (aVar != null && (h10 = aVar.h()) != null) {
            return h10;
        }
        Bitmap E2 = this.f8763p.E(this.f8764q.m());
        if (E2 != null) {
            return E2;
        }
        d0 d0Var = this.G;
        if (d0Var != null) {
            return d0Var.a();
        }
        return null;
    }

    public <T> void c(T t10, d3.c<T> cVar) {
        super.c(t10, cVar);
        if (t10 == h0.K) {
            if (cVar == null) {
                this.H = null;
            } else {
                this.H = new q(cVar);
            }
        } else if (t10 != h0.N) {
        } else {
            if (cVar == null) {
                this.I = null;
            } else {
                this.I = new q(cVar);
            }
        }
    }

    public void f(RectF rectF, Matrix matrix, boolean z10) {
        super.f(rectF, matrix, z10);
        if (this.G != null) {
            float e10 = j.e();
            rectF.set(0.0f, 0.0f, ((float) this.G.e()) * e10, ((float) this.G.c()) * e10);
            this.f8762o.mapRect(rectF);
        }
    }

    public void t(@NonNull Canvas canvas, Matrix matrix, int i10) {
        Bitmap O = O();
        if (O != null && !O.isRecycled() && this.G != null) {
            float e10 = j.e();
            this.D.setAlpha(i10);
            u2.a<ColorFilter, ColorFilter> aVar = this.H;
            if (aVar != null) {
                this.D.setColorFilter(aVar.h());
            }
            canvas.save();
            canvas.concat(matrix);
            this.E.set(0, 0, O.getWidth(), O.getHeight());
            if (this.f8763p.N()) {
                this.F.set(0, 0, (int) (((float) this.G.e()) * e10), (int) (((float) this.G.c()) * e10));
            } else {
                this.F.set(0, 0, (int) (((float) O.getWidth()) * e10), (int) (((float) O.getHeight()) * e10));
            }
            canvas.drawBitmap(O, this.E, this.F, this.D);
            canvas.restore();
        }
    }
}
