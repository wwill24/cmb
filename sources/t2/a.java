package t2;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.MaskFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import c3.i;
import c3.j;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h0;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
import u2.a;
import u2.c;
import u2.f;
import u2.q;
import x2.d;

public abstract class a implements a.b, k, e {

    /* renamed from: a  reason: collision with root package name */
    private final PathMeasure f17647a = new PathMeasure();

    /* renamed from: b  reason: collision with root package name */
    private final Path f17648b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f17649c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final RectF f17650d = new RectF();

    /* renamed from: e  reason: collision with root package name */
    private final LottieDrawable f17651e;

    /* renamed from: f  reason: collision with root package name */
    protected final com.airbnb.lottie.model.layer.a f17652f;

    /* renamed from: g  reason: collision with root package name */
    private final List<b> f17653g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private final float[] f17654h;

    /* renamed from: i  reason: collision with root package name */
    final Paint f17655i;

    /* renamed from: j  reason: collision with root package name */
    private final u2.a<?, Float> f17656j;

    /* renamed from: k  reason: collision with root package name */
    private final u2.a<?, Integer> f17657k;

    /* renamed from: l  reason: collision with root package name */
    private final List<u2.a<?, Float>> f17658l;

    /* renamed from: m  reason: collision with root package name */
    private final u2.a<?, Float> f17659m;

    /* renamed from: n  reason: collision with root package name */
    private u2.a<ColorFilter, ColorFilter> f17660n;

    /* renamed from: o  reason: collision with root package name */
    private u2.a<Float, Float> f17661o;

    /* renamed from: p  reason: collision with root package name */
    float f17662p;

    /* renamed from: q  reason: collision with root package name */
    private c f17663q;

    private static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final List<m> f17664a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final u f17665b;

        private b(u uVar) {
            this.f17664a = new ArrayList();
            this.f17665b = uVar;
        }
    }

    a(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f10, d dVar, x2.b bVar, List<x2.b> list, x2.b bVar2) {
        s2.a aVar2 = new s2.a(1);
        this.f17655i = aVar2;
        this.f17662p = 0.0f;
        this.f17651e = lottieDrawable;
        this.f17652f = aVar;
        aVar2.setStyle(Paint.Style.STROKE);
        aVar2.setStrokeCap(cap);
        aVar2.setStrokeJoin(join);
        aVar2.setStrokeMiter(f10);
        this.f17657k = dVar.a();
        this.f17656j = bVar.a();
        if (bVar2 == null) {
            this.f17659m = null;
        } else {
            this.f17659m = bVar2.a();
        }
        this.f17658l = new ArrayList(list.size());
        this.f17654h = new float[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            this.f17658l.add(list.get(i10).a());
        }
        aVar.i(this.f17657k);
        aVar.i(this.f17656j);
        for (int i11 = 0; i11 < this.f17658l.size(); i11++) {
            aVar.i(this.f17658l.get(i11));
        }
        u2.a<?, Float> aVar3 = this.f17659m;
        if (aVar3 != null) {
            aVar.i(aVar3);
        }
        this.f17657k.a(this);
        this.f17656j.a(this);
        for (int i12 = 0; i12 < list.size(); i12++) {
            this.f17658l.get(i12).a(this);
        }
        u2.a<?, Float> aVar4 = this.f17659m;
        if (aVar4 != null) {
            aVar4.a(this);
        }
        if (aVar.v() != null) {
            u2.a<Float, Float> a10 = aVar.v().a().a();
            this.f17661o = a10;
            a10.a(this);
            aVar.i(this.f17661o);
        }
        if (aVar.x() != null) {
            this.f17663q = new c(this, aVar, aVar.x());
        }
    }

    private void g(Matrix matrix) {
        float f10;
        com.airbnb.lottie.c.a("StrokeContent#applyDashPattern");
        if (this.f17658l.isEmpty()) {
            com.airbnb.lottie.c.b("StrokeContent#applyDashPattern");
            return;
        }
        float g10 = j.g(matrix);
        for (int i10 = 0; i10 < this.f17658l.size(); i10++) {
            this.f17654h[i10] = ((Float) this.f17658l.get(i10).h()).floatValue();
            if (i10 % 2 == 0) {
                float[] fArr = this.f17654h;
                if (fArr[i10] < 1.0f) {
                    fArr[i10] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f17654h;
                if (fArr2[i10] < 0.1f) {
                    fArr2[i10] = 0.1f;
                }
            }
            float[] fArr3 = this.f17654h;
            fArr3[i10] = fArr3[i10] * g10;
        }
        u2.a<?, Float> aVar = this.f17659m;
        if (aVar == null) {
            f10 = 0.0f;
        } else {
            f10 = g10 * aVar.h().floatValue();
        }
        this.f17655i.setPathEffect(new DashPathEffect(this.f17654h, f10));
        com.airbnb.lottie.c.b("StrokeContent#applyDashPattern");
    }

    private void i(Canvas canvas, b bVar, Matrix matrix) {
        float f10;
        float f11;
        float f12;
        Canvas canvas2 = canvas;
        Matrix matrix2 = matrix;
        com.airbnb.lottie.c.a("StrokeContent#applyTrimPath");
        if (bVar.f17665b == null) {
            com.airbnb.lottie.c.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f17648b.reset();
        for (int size = bVar.f17664a.size() - 1; size >= 0; size--) {
            this.f17648b.addPath(((m) bVar.f17664a.get(size)).getPath(), matrix2);
        }
        float floatValue = bVar.f17665b.i().h().floatValue() / 100.0f;
        float floatValue2 = bVar.f17665b.e().h().floatValue() / 100.0f;
        float floatValue3 = bVar.f17665b.g().h().floatValue() / 360.0f;
        if (floatValue >= 0.01f || floatValue2 <= 0.99f) {
            this.f17647a.setPath(this.f17648b, false);
            float length = this.f17647a.getLength();
            while (this.f17647a.nextContour()) {
                length += this.f17647a.getLength();
            }
            float f13 = floatValue3 * length;
            float f14 = (floatValue * length) + f13;
            float min = Math.min((floatValue2 * length) + f13, (f14 + length) - 1.0f);
            float f15 = 0.0f;
            for (int size2 = bVar.f17664a.size() - 1; size2 >= 0; size2--) {
                this.f17649c.set(((m) bVar.f17664a.get(size2)).getPath());
                this.f17649c.transform(matrix2);
                this.f17647a.setPath(this.f17649c, false);
                float length2 = this.f17647a.getLength();
                if (min > length) {
                    float f16 = min - length;
                    if (f16 < f15 + length2 && f15 < f16) {
                        if (f14 > length) {
                            f12 = (f14 - length) / length2;
                        } else {
                            f12 = 0.0f;
                        }
                        j.a(this.f17649c, f12, Math.min(f16 / length2, 1.0f), 0.0f);
                        canvas2.drawPath(this.f17649c, this.f17655i);
                        f15 += length2;
                    }
                }
                float f17 = f15 + length2;
                if (f17 >= f14 && f15 <= min) {
                    if (f17 > min || f14 >= f15) {
                        if (f14 < f15) {
                            f10 = 0.0f;
                        } else {
                            f10 = (f14 - f15) / length2;
                        }
                        if (min > f17) {
                            f11 = 1.0f;
                        } else {
                            f11 = (min - f15) / length2;
                        }
                        j.a(this.f17649c, f10, f11, 0.0f);
                        canvas2.drawPath(this.f17649c, this.f17655i);
                    } else {
                        canvas2.drawPath(this.f17649c, this.f17655i);
                    }
                }
                f15 += length2;
            }
            com.airbnb.lottie.c.b("StrokeContent#applyTrimPath");
            return;
        }
        canvas2.drawPath(this.f17648b, this.f17655i);
        com.airbnb.lottie.c.b("StrokeContent#applyTrimPath");
    }

    public void a() {
        this.f17651e.invalidateSelf();
    }

    public void b(List<c> list, List<c> list2) {
        u uVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof u) {
                u uVar2 = (u) cVar;
                if (uVar2.j() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    uVar = uVar2;
                }
            }
        }
        if (uVar != null) {
            uVar.c(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            c cVar2 = list2.get(size2);
            if (cVar2 instanceof u) {
                u uVar3 = (u) cVar2;
                if (uVar3.j() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.f17653g.add(bVar);
                    }
                    bVar = new b(uVar3);
                    uVar3.c(this);
                }
            }
            if (cVar2 instanceof m) {
                if (bVar == null) {
                    bVar = new b(uVar);
                }
                bVar.f17664a.add((m) cVar2);
            }
        }
        if (bVar != null) {
            this.f17653g.add(bVar);
        }
    }

    public <T> void c(T t10, d3.c<T> cVar) {
        c cVar2;
        c cVar3;
        c cVar4;
        c cVar5;
        c cVar6;
        if (t10 == h0.f8568d) {
            this.f17657k.n(cVar);
        } else if (t10 == h0.f8583s) {
            this.f17656j.n(cVar);
        } else if (t10 == h0.K) {
            u2.a<ColorFilter, ColorFilter> aVar = this.f17660n;
            if (aVar != null) {
                this.f17652f.G(aVar);
            }
            if (cVar == null) {
                this.f17660n = null;
                return;
            }
            q qVar = new q(cVar);
            this.f17660n = qVar;
            qVar.a(this);
            this.f17652f.i(this.f17660n);
        } else if (t10 == h0.f8574j) {
            u2.a<Float, Float> aVar2 = this.f17661o;
            if (aVar2 != null) {
                aVar2.n(cVar);
                return;
            }
            q qVar2 = new q(cVar);
            this.f17661o = qVar2;
            qVar2.a(this);
            this.f17652f.i(this.f17661o);
        } else if (t10 == h0.f8569e && (cVar6 = this.f17663q) != null) {
            cVar6.c(cVar);
        } else if (t10 == h0.G && (cVar5 = this.f17663q) != null) {
            cVar5.f(cVar);
        } else if (t10 == h0.H && (cVar4 = this.f17663q) != null) {
            cVar4.d(cVar);
        } else if (t10 == h0.I && (cVar3 = this.f17663q) != null) {
            cVar3.e(cVar);
        } else if (t10 == h0.J && (cVar2 = this.f17663q) != null) {
            cVar2.g(cVar);
        }
    }

    public void e(w2.d dVar, int i10, List<w2.d> list, w2.d dVar2) {
        i.k(dVar, i10, list, dVar2, this);
    }

    public void f(RectF rectF, Matrix matrix, boolean z10) {
        com.airbnb.lottie.c.a("StrokeContent#getBounds");
        this.f17648b.reset();
        for (int i10 = 0; i10 < this.f17653g.size(); i10++) {
            b bVar = this.f17653g.get(i10);
            for (int i11 = 0; i11 < bVar.f17664a.size(); i11++) {
                this.f17648b.addPath(((m) bVar.f17664a.get(i11)).getPath(), matrix);
            }
        }
        this.f17648b.computeBounds(this.f17650d, false);
        float p10 = ((u2.d) this.f17656j).p();
        RectF rectF2 = this.f17650d;
        float f10 = p10 / 2.0f;
        rectF2.set(rectF2.left - f10, rectF2.top - f10, rectF2.right + f10, rectF2.bottom + f10);
        rectF.set(this.f17650d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.airbnb.lottie.c.b("StrokeContent#getBounds");
    }

    public void h(Canvas canvas, Matrix matrix, int i10) {
        com.airbnb.lottie.c.a("StrokeContent#draw");
        if (j.h(matrix)) {
            com.airbnb.lottie.c.b("StrokeContent#draw");
            return;
        }
        this.f17655i.setAlpha(i.c((int) ((((((float) i10) / 255.0f) * ((float) ((f) this.f17657k).p())) / 100.0f) * 255.0f), 0, 255));
        this.f17655i.setStrokeWidth(((u2.d) this.f17656j).p() * j.g(matrix));
        if (this.f17655i.getStrokeWidth() <= 0.0f) {
            com.airbnb.lottie.c.b("StrokeContent#draw");
            return;
        }
        g(matrix);
        u2.a<ColorFilter, ColorFilter> aVar = this.f17660n;
        if (aVar != null) {
            this.f17655i.setColorFilter(aVar.h());
        }
        u2.a<Float, Float> aVar2 = this.f17661o;
        if (aVar2 != null) {
            float floatValue = aVar2.h().floatValue();
            if (floatValue == 0.0f) {
                this.f17655i.setMaskFilter((MaskFilter) null);
            } else if (floatValue != this.f17662p) {
                this.f17655i.setMaskFilter(this.f17652f.w(floatValue));
            }
            this.f17662p = floatValue;
        }
        c cVar = this.f17663q;
        if (cVar != null) {
            cVar.b(this.f17655i);
        }
        for (int i11 = 0; i11 < this.f17653g.size(); i11++) {
            b bVar = this.f17653g.get(i11);
            if (bVar.f17665b != null) {
                i(canvas, bVar, matrix);
            } else {
                com.airbnb.lottie.c.a("StrokeContent#buildPath");
                this.f17648b.reset();
                for (int size = bVar.f17664a.size() - 1; size >= 0; size--) {
                    this.f17648b.addPath(((m) bVar.f17664a.get(size)).getPath(), matrix);
                }
                com.airbnb.lottie.c.b("StrokeContent#buildPath");
                com.airbnb.lottie.c.a("StrokeContent#drawPath");
                canvas.drawPath(this.f17648b, this.f17655i);
                com.airbnb.lottie.c.b("StrokeContent#drawPath");
            }
        }
        com.airbnb.lottie.c.b("StrokeContent#draw");
    }
}
