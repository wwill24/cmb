package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h0;
import d3.c;
import u2.a;
import u2.q;

public class f extends a {
    private final RectF D = new RectF();
    private final Paint E;
    private final float[] F;
    private final Path G;
    private final Layer H;
    private a<ColorFilter, ColorFilter> I;

    f(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        s2.a aVar = new s2.a();
        this.E = aVar;
        this.F = new float[8];
        this.G = new Path();
        this.H = layer;
        aVar.setAlpha(0);
        aVar.setStyle(Paint.Style.FILL);
        aVar.setColor(layer.o());
    }

    public <T> void c(T t10, c<T> cVar) {
        super.c(t10, cVar);
        if (t10 != h0.K) {
            return;
        }
        if (cVar == null) {
            this.I = null;
        } else {
            this.I = new q(cVar);
        }
    }

    public void f(RectF rectF, Matrix matrix, boolean z10) {
        super.f(rectF, matrix, z10);
        this.D.set(0.0f, 0.0f, (float) this.H.q(), (float) this.H.p());
        this.f8762o.mapRect(this.D);
        rectF.set(this.D);
    }

    public void t(Canvas canvas, Matrix matrix, int i10) {
        int i11;
        int alpha = Color.alpha(this.H.o());
        if (alpha != 0) {
            if (this.f8771x.h() == null) {
                i11 = 100;
            } else {
                i11 = this.f8771x.h().h().intValue();
            }
            int i12 = (int) ((((float) i10) / 255.0f) * (((((float) alpha) / 255.0f) * ((float) i11)) / 100.0f) * 255.0f);
            this.E.setAlpha(i12);
            a<ColorFilter, ColorFilter> aVar = this.I;
            if (aVar != null) {
                this.E.setColorFilter(aVar.h());
            }
            if (i12 > 0) {
                float[] fArr = this.F;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = (float) this.H.q();
                float[] fArr2 = this.F;
                fArr2[3] = 0.0f;
                fArr2[4] = (float) this.H.q();
                this.F[5] = (float) this.H.p();
                float[] fArr3 = this.F;
                fArr3[6] = 0.0f;
                fArr3[7] = (float) this.H.p();
                matrix.mapPoints(this.F);
                this.G.reset();
                Path path = this.G;
                float[] fArr4 = this.F;
                path.moveTo(fArr4[0], fArr4[1]);
                Path path2 = this.G;
                float[] fArr5 = this.F;
                path2.lineTo(fArr5[2], fArr5[3]);
                Path path3 = this.G;
                float[] fArr6 = this.F;
                path3.lineTo(fArr6[4], fArr6[5]);
                Path path4 = this.G;
                float[] fArr7 = this.F;
                path4.lineTo(fArr7[6], fArr7[7]);
                Path path5 = this.G;
                float[] fArr8 = this.F;
                path5.lineTo(fArr8[0], fArr8[1]);
                this.G.close();
                canvas.drawPath(this.G, this.E);
            }
        }
    }
}
