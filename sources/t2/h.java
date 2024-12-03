package t2;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.MaskFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.collection.e;
import c3.i;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h0;
import com.airbnb.lottie.model.content.GradientType;
import java.util.ArrayList;
import java.util.List;
import u2.a;
import u2.c;
import u2.q;
import y2.d;

public class h implements e, a.b, k {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final String f17699a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17700b;

    /* renamed from: c  reason: collision with root package name */
    private final com.airbnb.lottie.model.layer.a f17701c;

    /* renamed from: d  reason: collision with root package name */
    private final e<LinearGradient> f17702d = new e<>();

    /* renamed from: e  reason: collision with root package name */
    private final e<RadialGradient> f17703e = new e<>();

    /* renamed from: f  reason: collision with root package name */
    private final Path f17704f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f17705g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f17706h;

    /* renamed from: i  reason: collision with root package name */
    private final List<m> f17707i;

    /* renamed from: j  reason: collision with root package name */
    private final GradientType f17708j;

    /* renamed from: k  reason: collision with root package name */
    private final a<d, d> f17709k;

    /* renamed from: l  reason: collision with root package name */
    private final a<Integer, Integer> f17710l;

    /* renamed from: m  reason: collision with root package name */
    private final a<PointF, PointF> f17711m;

    /* renamed from: n  reason: collision with root package name */
    private final a<PointF, PointF> f17712n;

    /* renamed from: o  reason: collision with root package name */
    private a<ColorFilter, ColorFilter> f17713o;

    /* renamed from: p  reason: collision with root package name */
    private q f17714p;

    /* renamed from: q  reason: collision with root package name */
    private final LottieDrawable f17715q;

    /* renamed from: r  reason: collision with root package name */
    private final int f17716r;

    /* renamed from: s  reason: collision with root package name */
    private a<Float, Float> f17717s;

    /* renamed from: t  reason: collision with root package name */
    float f17718t;

    /* renamed from: u  reason: collision with root package name */
    private c f17719u;

    public h(LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar, com.airbnb.lottie.model.layer.a aVar, y2.e eVar) {
        Path path = new Path();
        this.f17704f = path;
        this.f17705g = new s2.a(1);
        this.f17706h = new RectF();
        this.f17707i = new ArrayList();
        this.f17718t = 0.0f;
        this.f17701c = aVar;
        this.f17699a = eVar.f();
        this.f17700b = eVar.i();
        this.f17715q = lottieDrawable;
        this.f17708j = eVar.e();
        path.setFillType(eVar.c());
        this.f17716r = (int) (hVar.d() / 32.0f);
        a<d, d> a10 = eVar.d().a();
        this.f17709k = a10;
        a10.a(this);
        aVar.i(a10);
        a<Integer, Integer> a11 = eVar.g().a();
        this.f17710l = a11;
        a11.a(this);
        aVar.i(a11);
        a<PointF, PointF> a12 = eVar.h().a();
        this.f17711m = a12;
        a12.a(this);
        aVar.i(a12);
        a<PointF, PointF> a13 = eVar.b().a();
        this.f17712n = a13;
        a13.a(this);
        aVar.i(a13);
        if (aVar.v() != null) {
            a<Float, Float> a14 = aVar.v().a().a();
            this.f17717s = a14;
            a14.a(this);
            aVar.i(this.f17717s);
        }
        if (aVar.x() != null) {
            this.f17719u = new c(this, aVar, aVar.x());
        }
    }

    private int[] g(int[] iArr) {
        q qVar = this.f17714p;
        if (qVar != null) {
            Integer[] numArr = (Integer[]) qVar.h();
            int i10 = 0;
            if (iArr.length == numArr.length) {
                while (i10 < iArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i10 < numArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            }
        }
        return iArr;
    }

    private int i() {
        int i10;
        int round = Math.round(this.f17711m.f() * ((float) this.f17716r));
        int round2 = Math.round(this.f17712n.f() * ((float) this.f17716r));
        int round3 = Math.round(this.f17709k.f() * ((float) this.f17716r));
        if (round != 0) {
            i10 = 527 * round;
        } else {
            i10 = 17;
        }
        if (round2 != 0) {
            i10 = i10 * 31 * round2;
        }
        if (round3 != 0) {
            return i10 * 31 * round3;
        }
        return i10;
    }

    private LinearGradient j() {
        long i10 = (long) i();
        LinearGradient e10 = this.f17702d.e(i10);
        if (e10 != null) {
            return e10;
        }
        PointF h10 = this.f17711m.h();
        PointF h11 = this.f17712n.h();
        d h12 = this.f17709k.h();
        LinearGradient linearGradient = new LinearGradient(h10.x, h10.y, h11.x, h11.y, g(h12.c()), h12.d(), Shader.TileMode.CLAMP);
        this.f17702d.l(i10, linearGradient);
        return linearGradient;
    }

    private RadialGradient k() {
        long i10 = (long) i();
        RadialGradient e10 = this.f17703e.e(i10);
        if (e10 != null) {
            return e10;
        }
        PointF h10 = this.f17711m.h();
        PointF h11 = this.f17712n.h();
        d h12 = this.f17709k.h();
        int[] g10 = g(h12.c());
        float[] d10 = h12.d();
        float f10 = h10.x;
        float f11 = h10.y;
        float hypot = (float) Math.hypot((double) (h11.x - f10), (double) (h11.y - f11));
        if (hypot <= 0.0f) {
            hypot = 0.001f;
        }
        RadialGradient radialGradient = new RadialGradient(f10, f11, hypot, g10, d10, Shader.TileMode.CLAMP);
        this.f17703e.l(i10, radialGradient);
        return radialGradient;
    }

    public void a() {
        this.f17715q.invalidateSelf();
    }

    public void b(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < list2.size(); i10++) {
            c cVar = list2.get(i10);
            if (cVar instanceof m) {
                this.f17707i.add((m) cVar);
            }
        }
    }

    public <T> void c(T t10, d3.c<T> cVar) {
        c cVar2;
        c cVar3;
        c cVar4;
        c cVar5;
        c cVar6;
        if (t10 == h0.f8568d) {
            this.f17710l.n(cVar);
        } else if (t10 == h0.K) {
            a<ColorFilter, ColorFilter> aVar = this.f17713o;
            if (aVar != null) {
                this.f17701c.G(aVar);
            }
            if (cVar == null) {
                this.f17713o = null;
                return;
            }
            q qVar = new q(cVar);
            this.f17713o = qVar;
            qVar.a(this);
            this.f17701c.i(this.f17713o);
        } else if (t10 == h0.L) {
            q qVar2 = this.f17714p;
            if (qVar2 != null) {
                this.f17701c.G(qVar2);
            }
            if (cVar == null) {
                this.f17714p = null;
                return;
            }
            this.f17702d.a();
            this.f17703e.a();
            q qVar3 = new q(cVar);
            this.f17714p = qVar3;
            qVar3.a(this);
            this.f17701c.i(this.f17714p);
        } else if (t10 == h0.f8574j) {
            a<Float, Float> aVar2 = this.f17717s;
            if (aVar2 != null) {
                aVar2.n(cVar);
                return;
            }
            q qVar4 = new q(cVar);
            this.f17717s = qVar4;
            qVar4.a(this);
            this.f17701c.i(this.f17717s);
        } else if (t10 == h0.f8569e && (cVar6 = this.f17719u) != null) {
            cVar6.c(cVar);
        } else if (t10 == h0.G && (cVar5 = this.f17719u) != null) {
            cVar5.f(cVar);
        } else if (t10 == h0.H && (cVar4 = this.f17719u) != null) {
            cVar4.d(cVar);
        } else if (t10 == h0.I && (cVar3 = this.f17719u) != null) {
            cVar3.e(cVar);
        } else if (t10 == h0.J && (cVar2 = this.f17719u) != null) {
            cVar2.g(cVar);
        }
    }

    public void e(w2.d dVar, int i10, List<w2.d> list, w2.d dVar2) {
        i.k(dVar, i10, list, dVar2, this);
    }

    public void f(RectF rectF, Matrix matrix, boolean z10) {
        this.f17704f.reset();
        for (int i10 = 0; i10 < this.f17707i.size(); i10++) {
            this.f17704f.addPath(this.f17707i.get(i10).getPath(), matrix);
        }
        this.f17704f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public String getName() {
        return this.f17699a;
    }

    public void h(Canvas canvas, Matrix matrix, int i10) {
        Shader shader;
        if (!this.f17700b) {
            com.airbnb.lottie.c.a("GradientFillContent#draw");
            this.f17704f.reset();
            for (int i11 = 0; i11 < this.f17707i.size(); i11++) {
                this.f17704f.addPath(this.f17707i.get(i11).getPath(), matrix);
            }
            this.f17704f.computeBounds(this.f17706h, false);
            if (this.f17708j == GradientType.LINEAR) {
                shader = j();
            } else {
                shader = k();
            }
            shader.setLocalMatrix(matrix);
            this.f17705g.setShader(shader);
            a<ColorFilter, ColorFilter> aVar = this.f17713o;
            if (aVar != null) {
                this.f17705g.setColorFilter(aVar.h());
            }
            a<Float, Float> aVar2 = this.f17717s;
            if (aVar2 != null) {
                float floatValue = aVar2.h().floatValue();
                if (floatValue == 0.0f) {
                    this.f17705g.setMaskFilter((MaskFilter) null);
                } else if (floatValue != this.f17718t) {
                    this.f17705g.setMaskFilter(new BlurMaskFilter(floatValue, BlurMaskFilter.Blur.NORMAL));
                }
                this.f17718t = floatValue;
            }
            c cVar = this.f17719u;
            if (cVar != null) {
                cVar.b(this.f17705g);
            }
            this.f17705g.setAlpha(i.c((int) ((((((float) i10) / 255.0f) * ((float) this.f17710l.h().intValue())) / 100.0f) * 255.0f), 0, 255));
            canvas.drawPath(this.f17704f, this.f17705g);
            com.airbnb.lottie.c.b("GradientFillContent#draw");
        }
    }
}
