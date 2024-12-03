package t2;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.MaskFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import c3.i;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h0;
import java.util.ArrayList;
import java.util.List;
import u2.a;
import u2.b;
import u2.c;
import u2.q;
import w2.d;
import y2.j;

public class g implements e, a.b, k {

    /* renamed from: a  reason: collision with root package name */
    private final Path f17686a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f17687b = new s2.a(1);

    /* renamed from: c  reason: collision with root package name */
    private final com.airbnb.lottie.model.layer.a f17688c;

    /* renamed from: d  reason: collision with root package name */
    private final String f17689d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f17690e;

    /* renamed from: f  reason: collision with root package name */
    private final List<m> f17691f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final a<Integer, Integer> f17692g;

    /* renamed from: h  reason: collision with root package name */
    private final a<Integer, Integer> f17693h;

    /* renamed from: i  reason: collision with root package name */
    private a<ColorFilter, ColorFilter> f17694i;

    /* renamed from: j  reason: collision with root package name */
    private final LottieDrawable f17695j;

    /* renamed from: k  reason: collision with root package name */
    private a<Float, Float> f17696k;

    /* renamed from: l  reason: collision with root package name */
    float f17697l;

    /* renamed from: m  reason: collision with root package name */
    private c f17698m;

    public g(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, j jVar) {
        Path path = new Path();
        this.f17686a = path;
        this.f17688c = aVar;
        this.f17689d = jVar.d();
        this.f17690e = jVar.f();
        this.f17695j = lottieDrawable;
        if (aVar.v() != null) {
            a<Float, Float> a10 = aVar.v().a().a();
            this.f17696k = a10;
            a10.a(this);
            aVar.i(this.f17696k);
        }
        if (aVar.x() != null) {
            this.f17698m = new c(this, aVar, aVar.x());
        }
        if (jVar.b() == null || jVar.e() == null) {
            this.f17692g = null;
            this.f17693h = null;
            return;
        }
        path.setFillType(jVar.c());
        a<Integer, Integer> a11 = jVar.b().a();
        this.f17692g = a11;
        a11.a(this);
        aVar.i(a11);
        a<Integer, Integer> a12 = jVar.e().a();
        this.f17693h = a12;
        a12.a(this);
        aVar.i(a12);
    }

    public void a() {
        this.f17695j.invalidateSelf();
    }

    public void b(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < list2.size(); i10++) {
            c cVar = list2.get(i10);
            if (cVar instanceof m) {
                this.f17691f.add((m) cVar);
            }
        }
    }

    public <T> void c(T t10, d3.c<T> cVar) {
        c cVar2;
        c cVar3;
        c cVar4;
        c cVar5;
        c cVar6;
        if (t10 == h0.f8565a) {
            this.f17692g.n(cVar);
        } else if (t10 == h0.f8568d) {
            this.f17693h.n(cVar);
        } else if (t10 == h0.K) {
            a<ColorFilter, ColorFilter> aVar = this.f17694i;
            if (aVar != null) {
                this.f17688c.G(aVar);
            }
            if (cVar == null) {
                this.f17694i = null;
                return;
            }
            q qVar = new q(cVar);
            this.f17694i = qVar;
            qVar.a(this);
            this.f17688c.i(this.f17694i);
        } else if (t10 == h0.f8574j) {
            a<Float, Float> aVar2 = this.f17696k;
            if (aVar2 != null) {
                aVar2.n(cVar);
                return;
            }
            q qVar2 = new q(cVar);
            this.f17696k = qVar2;
            qVar2.a(this);
            this.f17688c.i(this.f17696k);
        } else if (t10 == h0.f8569e && (cVar6 = this.f17698m) != null) {
            cVar6.c(cVar);
        } else if (t10 == h0.G && (cVar5 = this.f17698m) != null) {
            cVar5.f(cVar);
        } else if (t10 == h0.H && (cVar4 = this.f17698m) != null) {
            cVar4.d(cVar);
        } else if (t10 == h0.I && (cVar3 = this.f17698m) != null) {
            cVar3.e(cVar);
        } else if (t10 == h0.J && (cVar2 = this.f17698m) != null) {
            cVar2.g(cVar);
        }
    }

    public void e(d dVar, int i10, List<d> list, d dVar2) {
        i.k(dVar, i10, list, dVar2, this);
    }

    public void f(RectF rectF, Matrix matrix, boolean z10) {
        this.f17686a.reset();
        for (int i10 = 0; i10 < this.f17691f.size(); i10++) {
            this.f17686a.addPath(this.f17691f.get(i10).getPath(), matrix);
        }
        this.f17686a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public String getName() {
        return this.f17689d;
    }

    public void h(Canvas canvas, Matrix matrix, int i10) {
        if (!this.f17690e) {
            com.airbnb.lottie.c.a("FillContent#draw");
            this.f17687b.setColor((i.c((int) ((((((float) i10) / 255.0f) * ((float) this.f17693h.h().intValue())) / 100.0f) * 255.0f), 0, 255) << 24) | (((b) this.f17692g).p() & 16777215));
            a<ColorFilter, ColorFilter> aVar = this.f17694i;
            if (aVar != null) {
                this.f17687b.setColorFilter(aVar.h());
            }
            a<Float, Float> aVar2 = this.f17696k;
            if (aVar2 != null) {
                float floatValue = aVar2.h().floatValue();
                if (floatValue == 0.0f) {
                    this.f17687b.setMaskFilter((MaskFilter) null);
                } else if (floatValue != this.f17697l) {
                    this.f17687b.setMaskFilter(this.f17688c.w(floatValue));
                }
                this.f17697l = floatValue;
            }
            c cVar = this.f17698m;
            if (cVar != null) {
                cVar.b(this.f17687b);
            }
            this.f17686a.reset();
            for (int i11 = 0; i11 < this.f17691f.size(); i11++) {
                this.f17686a.addPath(this.f17691f.get(i11).getPath(), matrix);
            }
            canvas.drawPath(this.f17686a, this.f17687b);
            com.airbnb.lottie.c.b("FillContent#draw");
        }
    }
}
