package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.collection.e;
import c3.j;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import com.airbnb.lottie.h0;
import d3.c;
import java.util.ArrayList;
import java.util.List;
import u2.q;
import w2.d;

public class b extends a {
    private u2.a<Float, Float> D;
    private final List<a> E = new ArrayList();
    private final RectF F = new RectF();
    private final RectF G = new RectF();
    private final Paint H = new Paint();
    private boolean I = true;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8776a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.airbnb.lottie.model.layer.Layer$MatteType[] r0 = com.airbnb.lottie.model.layer.Layer.MatteType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8776a = r0
                com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.ADD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8776a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.INVERT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.b.a.<clinit>():void");
        }
    }

    public b(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, h hVar) {
        super(lottieDrawable, layer);
        int i10;
        a aVar;
        x2.b u10 = layer.u();
        if (u10 != null) {
            u2.a<Float, Float> a10 = u10.a();
            this.D = a10;
            i(a10);
            this.D.a(this);
        } else {
            this.D = null;
        }
        e eVar = new e(hVar.k().size());
        int size = list.size() - 1;
        a aVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            a u11 = a.u(this, layer2, lottieDrawable, hVar);
            if (u11 != null) {
                eVar.l(u11.y().d(), u11);
                if (aVar2 != null) {
                    aVar2.I(u11);
                    aVar2 = null;
                } else {
                    this.E.add(0, u11);
                    int i11 = a.f8776a[layer2.h().ordinal()];
                    if (i11 == 1 || i11 == 2) {
                        aVar2 = u11;
                    }
                }
            }
            size--;
        }
        for (i10 = 0; i10 < eVar.q(); i10++) {
            a aVar3 = (a) eVar.e(eVar.k(i10));
            if (!(aVar3 == null || (aVar = (a) eVar.e(aVar3.y().j())) == null)) {
                aVar3.K(aVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void H(d dVar, int i10, List<d> list, d dVar2) {
        for (int i11 = 0; i11 < this.E.size(); i11++) {
            this.E.get(i11).e(dVar, i10, list, dVar2);
        }
    }

    public void J(boolean z10) {
        super.J(z10);
        for (a J : this.E) {
            J.J(z10);
        }
    }

    public void L(float f10) {
        super.L(f10);
        if (this.D != null) {
            f10 = ((this.D.h().floatValue() * this.f8764q.b().i()) - this.f8764q.b().p()) / (this.f8763p.G().e() + 0.01f);
        }
        if (this.D == null) {
            f10 -= this.f8764q.r();
        }
        if (this.f8764q.v() != 0.0f && !"__container".equals(this.f8764q.i())) {
            f10 /= this.f8764q.v();
        }
        for (int size = this.E.size() - 1; size >= 0; size--) {
            this.E.get(size).L(f10);
        }
    }

    public void O(boolean z10) {
        this.I = z10;
    }

    public <T> void c(T t10, c<T> cVar) {
        super.c(t10, cVar);
        if (t10 != h0.E) {
            return;
        }
        if (cVar == null) {
            u2.a<Float, Float> aVar = this.D;
            if (aVar != null) {
                aVar.n((c<Float>) null);
                return;
            }
            return;
        }
        q qVar = new q(cVar);
        this.D = qVar;
        qVar.a(this);
        i(this.D);
    }

    public void f(RectF rectF, Matrix matrix, boolean z10) {
        super.f(rectF, matrix, z10);
        for (int size = this.E.size() - 1; size >= 0; size--) {
            this.F.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.E.get(size).f(this.F, this.f8762o, true);
            rectF.union(this.F);
        }
    }

    /* access modifiers changed from: package-private */
    public void t(Canvas canvas, Matrix matrix, int i10) {
        boolean z10;
        boolean z11;
        boolean z12;
        com.airbnb.lottie.c.a("CompositionLayer#draw");
        this.G.set(0.0f, 0.0f, this.f8764q.l(), this.f8764q.k());
        matrix.mapRect(this.G);
        if (!this.f8763p.b0() || this.E.size() <= 1 || i10 == 255) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            this.H.setAlpha(i10);
            j.m(canvas, this.G, this.H);
        } else {
            canvas.save();
        }
        if (z10) {
            i10 = 255;
        }
        for (int size = this.E.size() - 1; size >= 0; size--) {
            if (this.I || !"__container".equals(this.f8764q.i())) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11 || this.G.isEmpty()) {
                z12 = true;
            } else {
                z12 = canvas.clipRect(this.G);
            }
            if (z12) {
                this.E.get(size).h(canvas, matrix, i10);
            }
        }
        canvas.restore();
        com.airbnb.lottie.c.b("CompositionLayer#draw");
    }
}
