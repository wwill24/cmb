package u2;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.h0;
import com.airbnb.lottie.model.layer.a;
import d3.c;
import d3.d;
import java.util.Collections;
import u2.a;
import x2.l;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f17997a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f17998b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f17999c;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f18000d;

    /* renamed from: e  reason: collision with root package name */
    private final float[] f18001e;

    /* renamed from: f  reason: collision with root package name */
    private a<PointF, PointF> f18002f;

    /* renamed from: g  reason: collision with root package name */
    private a<?, PointF> f18003g;

    /* renamed from: h  reason: collision with root package name */
    private a<d, d> f18004h;

    /* renamed from: i  reason: collision with root package name */
    private a<Float, Float> f18005i;

    /* renamed from: j  reason: collision with root package name */
    private a<Integer, Integer> f18006j;

    /* renamed from: k  reason: collision with root package name */
    private d f18007k;

    /* renamed from: l  reason: collision with root package name */
    private d f18008l;

    /* renamed from: m  reason: collision with root package name */
    private a<?, Float> f18009m;

    /* renamed from: n  reason: collision with root package name */
    private a<?, Float> f18010n;

    public p(l lVar) {
        a<PointF, PointF> aVar;
        a<PointF, PointF> aVar2;
        a<d, d> aVar3;
        a<Float, Float> aVar4;
        d dVar;
        d dVar2;
        if (lVar.c() == null) {
            aVar = null;
        } else {
            aVar = lVar.c().a();
        }
        this.f18002f = aVar;
        if (lVar.f() == null) {
            aVar2 = null;
        } else {
            aVar2 = lVar.f().a();
        }
        this.f18003g = aVar2;
        if (lVar.h() == null) {
            aVar3 = null;
        } else {
            aVar3 = lVar.h().a();
        }
        this.f18004h = aVar3;
        if (lVar.g() == null) {
            aVar4 = null;
        } else {
            aVar4 = lVar.g().a();
        }
        this.f18005i = aVar4;
        if (lVar.i() == null) {
            dVar = null;
        } else {
            dVar = (d) lVar.i().a();
        }
        this.f18007k = dVar;
        if (dVar != null) {
            this.f17998b = new Matrix();
            this.f17999c = new Matrix();
            this.f18000d = new Matrix();
            this.f18001e = new float[9];
        } else {
            this.f17998b = null;
            this.f17999c = null;
            this.f18000d = null;
            this.f18001e = null;
        }
        if (lVar.j() == null) {
            dVar2 = null;
        } else {
            dVar2 = (d) lVar.j().a();
        }
        this.f18008l = dVar2;
        if (lVar.e() != null) {
            this.f18006j = lVar.e().a();
        }
        if (lVar.k() != null) {
            this.f18009m = lVar.k().a();
        } else {
            this.f18009m = null;
        }
        if (lVar.d() != null) {
            this.f18010n = lVar.d().a();
        } else {
            this.f18010n = null;
        }
    }

    private void d() {
        for (int i10 = 0; i10 < 9; i10++) {
            this.f18001e[i10] = 0.0f;
        }
    }

    public void a(a aVar) {
        aVar.i(this.f18006j);
        aVar.i(this.f18009m);
        aVar.i(this.f18010n);
        aVar.i(this.f18002f);
        aVar.i(this.f18003g);
        aVar.i(this.f18004h);
        aVar.i(this.f18005i);
        aVar.i(this.f18007k);
        aVar.i(this.f18008l);
    }

    public void b(a.b bVar) {
        a<Integer, Integer> aVar = this.f18006j;
        if (aVar != null) {
            aVar.a(bVar);
        }
        a<?, Float> aVar2 = this.f18009m;
        if (aVar2 != null) {
            aVar2.a(bVar);
        }
        a<?, Float> aVar3 = this.f18010n;
        if (aVar3 != null) {
            aVar3.a(bVar);
        }
        a<PointF, PointF> aVar4 = this.f18002f;
        if (aVar4 != null) {
            aVar4.a(bVar);
        }
        a<?, PointF> aVar5 = this.f18003g;
        if (aVar5 != null) {
            aVar5.a(bVar);
        }
        a<d, d> aVar6 = this.f18004h;
        if (aVar6 != null) {
            aVar6.a(bVar);
        }
        a<Float, Float> aVar7 = this.f18005i;
        if (aVar7 != null) {
            aVar7.a(bVar);
        }
        d dVar = this.f18007k;
        if (dVar != null) {
            dVar.a(bVar);
        }
        d dVar2 = this.f18008l;
        if (dVar2 != null) {
            dVar2.a(bVar);
        }
    }

    public <T> boolean c(T t10, c<T> cVar) {
        if (t10 == h0.f8570f) {
            a<PointF, PointF> aVar = this.f18002f;
            if (aVar == null) {
                this.f18002f = new q(cVar, new PointF());
                return true;
            }
            aVar.n(cVar);
            return true;
        } else if (t10 == h0.f8571g) {
            a<?, PointF> aVar2 = this.f18003g;
            if (aVar2 == null) {
                this.f18003g = new q(cVar, new PointF());
                return true;
            }
            aVar2.n(cVar);
            return true;
        } else {
            if (t10 == h0.f8572h) {
                a<?, PointF> aVar3 = this.f18003g;
                if (aVar3 instanceof n) {
                    ((n) aVar3).r(cVar);
                    return true;
                }
            }
            if (t10 == h0.f8573i) {
                a<?, PointF> aVar4 = this.f18003g;
                if (aVar4 instanceof n) {
                    ((n) aVar4).s(cVar);
                    return true;
                }
            }
            if (t10 == h0.f8579o) {
                a<d, d> aVar5 = this.f18004h;
                if (aVar5 == null) {
                    this.f18004h = new q(cVar, new d());
                    return true;
                }
                aVar5.n(cVar);
                return true;
            } else if (t10 == h0.f8580p) {
                a<Float, Float> aVar6 = this.f18005i;
                if (aVar6 == null) {
                    this.f18005i = new q(cVar, Float.valueOf(0.0f));
                    return true;
                }
                aVar6.n(cVar);
                return true;
            } else if (t10 == h0.f8567c) {
                a<Integer, Integer> aVar7 = this.f18006j;
                if (aVar7 == null) {
                    this.f18006j = new q(cVar, 100);
                    return true;
                }
                aVar7.n(cVar);
                return true;
            } else if (t10 == h0.C) {
                a<?, Float> aVar8 = this.f18009m;
                if (aVar8 == null) {
                    this.f18009m = new q(cVar, Float.valueOf(100.0f));
                    return true;
                }
                aVar8.n(cVar);
                return true;
            } else if (t10 == h0.D) {
                a<?, Float> aVar9 = this.f18010n;
                if (aVar9 == null) {
                    this.f18010n = new q(cVar, Float.valueOf(100.0f));
                    return true;
                }
                aVar9.n(cVar);
                return true;
            } else if (t10 == h0.f8581q) {
                if (this.f18007k == null) {
                    this.f18007k = new d(Collections.singletonList(new d3.a(Float.valueOf(0.0f))));
                }
                this.f18007k.n(cVar);
                return true;
            } else if (t10 != h0.f8582r) {
                return false;
            } else {
                if (this.f18008l == null) {
                    this.f18008l = new d(Collections.singletonList(new d3.a(Float.valueOf(0.0f))));
                }
                this.f18008l.n(cVar);
                return true;
            }
        }
    }

    public a<?, Float> e() {
        return this.f18010n;
    }

    public Matrix f() {
        PointF h10;
        float f10;
        float f11;
        float f12;
        PointF h11;
        this.f17997a.reset();
        a<?, PointF> aVar = this.f18003g;
        if (!(aVar == null || (h11 = aVar.h()) == null)) {
            float f13 = h11.x;
            if (!(f13 == 0.0f && h11.y == 0.0f)) {
                this.f17997a.preTranslate(f13, h11.y);
            }
        }
        a<Float, Float> aVar2 = this.f18005i;
        if (aVar2 != null) {
            if (aVar2 instanceof q) {
                f12 = aVar2.h().floatValue();
            } else {
                f12 = ((d) aVar2).p();
            }
            if (f12 != 0.0f) {
                this.f17997a.preRotate(f12);
            }
        }
        d dVar = this.f18007k;
        if (dVar != null) {
            d dVar2 = this.f18008l;
            if (dVar2 == null) {
                f10 = 0.0f;
            } else {
                f10 = (float) Math.cos(Math.toRadians((double) ((-dVar2.p()) + 90.0f)));
            }
            d dVar3 = this.f18008l;
            if (dVar3 == null) {
                f11 = 1.0f;
            } else {
                f11 = (float) Math.sin(Math.toRadians((double) ((-dVar3.p()) + 90.0f)));
            }
            float tan = (float) Math.tan(Math.toRadians((double) dVar.p()));
            d();
            float[] fArr = this.f18001e;
            fArr[0] = f10;
            fArr[1] = f11;
            float f14 = -f11;
            fArr[3] = f14;
            fArr[4] = f10;
            fArr[8] = 1.0f;
            this.f17998b.setValues(fArr);
            d();
            float[] fArr2 = this.f18001e;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f17999c.setValues(fArr2);
            d();
            float[] fArr3 = this.f18001e;
            fArr3[0] = f10;
            fArr3[1] = f14;
            fArr3[3] = f11;
            fArr3[4] = f10;
            fArr3[8] = 1.0f;
            this.f18000d.setValues(fArr3);
            this.f17999c.preConcat(this.f17998b);
            this.f18000d.preConcat(this.f17999c);
            this.f17997a.preConcat(this.f18000d);
        }
        a<d, d> aVar3 = this.f18004h;
        if (aVar3 != null) {
            d h12 = aVar3.h();
            if (!(h12.b() == 1.0f && h12.c() == 1.0f)) {
                this.f17997a.preScale(h12.b(), h12.c());
            }
        }
        a<PointF, PointF> aVar4 = this.f18002f;
        if (!(aVar4 == null || (((h10 = aVar4.h()) == null || h10.x == 0.0f) && h10.y == 0.0f))) {
            this.f17997a.preTranslate(-h10.x, -h10.y);
        }
        return this.f17997a;
    }

    public Matrix g(float f10) {
        PointF pointF;
        d dVar;
        float f11;
        a<?, PointF> aVar = this.f18003g;
        PointF pointF2 = null;
        if (aVar == null) {
            pointF = null;
        } else {
            pointF = aVar.h();
        }
        a<d, d> aVar2 = this.f18004h;
        if (aVar2 == null) {
            dVar = null;
        } else {
            dVar = aVar2.h();
        }
        this.f17997a.reset();
        if (pointF != null) {
            this.f17997a.preTranslate(pointF.x * f10, pointF.y * f10);
        }
        if (dVar != null) {
            double d10 = (double) f10;
            this.f17997a.preScale((float) Math.pow((double) dVar.b(), d10), (float) Math.pow((double) dVar.c(), d10));
        }
        a<Float, Float> aVar3 = this.f18005i;
        if (aVar3 != null) {
            float floatValue = aVar3.h().floatValue();
            a<PointF, PointF> aVar4 = this.f18002f;
            if (aVar4 != null) {
                pointF2 = aVar4.h();
            }
            Matrix matrix = this.f17997a;
            float f12 = floatValue * f10;
            float f13 = 0.0f;
            if (pointF2 == null) {
                f11 = 0.0f;
            } else {
                f11 = pointF2.x;
            }
            if (pointF2 != null) {
                f13 = pointF2.y;
            }
            matrix.preRotate(f12, f11, f13);
        }
        return this.f17997a;
    }

    public a<?, Integer> h() {
        return this.f18006j;
    }

    public a<?, Float> i() {
        return this.f18009m;
    }

    public void j(float f10) {
        a<Integer, Integer> aVar = this.f18006j;
        if (aVar != null) {
            aVar.m(f10);
        }
        a<?, Float> aVar2 = this.f18009m;
        if (aVar2 != null) {
            aVar2.m(f10);
        }
        a<?, Float> aVar3 = this.f18010n;
        if (aVar3 != null) {
            aVar3.m(f10);
        }
        a<PointF, PointF> aVar4 = this.f18002f;
        if (aVar4 != null) {
            aVar4.m(f10);
        }
        a<?, PointF> aVar5 = this.f18003g;
        if (aVar5 != null) {
            aVar5.m(f10);
        }
        a<d, d> aVar6 = this.f18004h;
        if (aVar6 != null) {
            aVar6.m(f10);
        }
        a<Float, Float> aVar7 = this.f18005i;
        if (aVar7 != null) {
            aVar7.m(f10);
        }
        d dVar = this.f18007k;
        if (dVar != null) {
            dVar.m(f10);
        }
        d dVar2 = this.f18008l;
        if (dVar2 != null) {
            dVar2.m(f10);
        }
    }
}
