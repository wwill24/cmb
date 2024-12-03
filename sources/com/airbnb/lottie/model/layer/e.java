package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import b3.j;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import java.util.Collections;
import java.util.List;
import t2.d;
import y2.a;
import y2.k;

public class e extends a {
    private final d D;
    private final b E;

    e(LottieDrawable lottieDrawable, Layer layer, b bVar, h hVar) {
        super(lottieDrawable, layer);
        this.E = bVar;
        d dVar = new d(lottieDrawable, this, new k("__container", layer.n(), false), hVar);
        this.D = dVar;
        dVar.b(Collections.emptyList(), Collections.emptyList());
    }

    /* access modifiers changed from: protected */
    public void H(w2.d dVar, int i10, List<w2.d> list, w2.d dVar2) {
        this.D.e(dVar, i10, list, dVar2);
    }

    public void f(RectF rectF, Matrix matrix, boolean z10) {
        super.f(rectF, matrix, z10);
        this.D.f(rectF, this.f8762o, z10);
    }

    /* access modifiers changed from: package-private */
    public void t(@NonNull Canvas canvas, Matrix matrix, int i10) {
        this.D.h(canvas, matrix, i10);
    }

    public a v() {
        a v10 = super.v();
        if (v10 != null) {
            return v10;
        }
        return this.E.v();
    }

    public j x() {
        j x10 = super.x();
        if (x10 != null) {
            return x10;
        }
        return this.E.x();
    }
}
