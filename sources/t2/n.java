package t2;

import android.graphics.Path;
import android.graphics.PointF;
import c3.i;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h0;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import d3.c;
import java.util.List;
import u2.a;
import w2.d;

public class n implements m, a.b, k {

    /* renamed from: a  reason: collision with root package name */
    private final Path f17736a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f17737b;

    /* renamed from: c  reason: collision with root package name */
    private final LottieDrawable f17738c;

    /* renamed from: d  reason: collision with root package name */
    private final PolystarShape.Type f17739d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f17740e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f17741f;

    /* renamed from: g  reason: collision with root package name */
    private final u2.a<?, Float> f17742g;

    /* renamed from: h  reason: collision with root package name */
    private final u2.a<?, PointF> f17743h;

    /* renamed from: i  reason: collision with root package name */
    private final u2.a<?, Float> f17744i;

    /* renamed from: j  reason: collision with root package name */
    private final u2.a<?, Float> f17745j;

    /* renamed from: k  reason: collision with root package name */
    private final u2.a<?, Float> f17746k;

    /* renamed from: l  reason: collision with root package name */
    private final u2.a<?, Float> f17747l;

    /* renamed from: m  reason: collision with root package name */
    private final u2.a<?, Float> f17748m;

    /* renamed from: n  reason: collision with root package name */
    private final b f17749n = new b();

    /* renamed from: o  reason: collision with root package name */
    private boolean f17750o;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17751a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.airbnb.lottie.model.content.PolystarShape$Type[] r0 = com.airbnb.lottie.model.content.PolystarShape.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f17751a = r0
                com.airbnb.lottie.model.content.PolystarShape$Type r1 = com.airbnb.lottie.model.content.PolystarShape.Type.STAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f17751a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.content.PolystarShape$Type r1 = com.airbnb.lottie.model.content.PolystarShape.Type.POLYGON     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: t2.n.a.<clinit>():void");
        }
    }

    public n(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.f17738c = lottieDrawable;
        this.f17737b = polystarShape.d();
        PolystarShape.Type j10 = polystarShape.j();
        this.f17739d = j10;
        this.f17740e = polystarShape.k();
        this.f17741f = polystarShape.l();
        u2.a<Float, Float> a10 = polystarShape.g().a();
        this.f17742g = a10;
        u2.a<PointF, PointF> a11 = polystarShape.h().a();
        this.f17743h = a11;
        u2.a<Float, Float> a12 = polystarShape.i().a();
        this.f17744i = a12;
        u2.a<Float, Float> a13 = polystarShape.e().a();
        this.f17746k = a13;
        u2.a<Float, Float> a14 = polystarShape.f().a();
        this.f17748m = a14;
        PolystarShape.Type type = PolystarShape.Type.STAR;
        if (j10 == type) {
            this.f17745j = polystarShape.b().a();
            this.f17747l = polystarShape.c().a();
        } else {
            this.f17745j = null;
            this.f17747l = null;
        }
        aVar.i(a10);
        aVar.i(a11);
        aVar.i(a12);
        aVar.i(a13);
        aVar.i(a14);
        if (j10 == type) {
            aVar.i(this.f17745j);
            aVar.i(this.f17747l);
        }
        a10.a(this);
        a11.a(this);
        a12.a(this);
        a13.a(this);
        a14.a(this);
        if (j10 == type) {
            this.f17745j.a(this);
            this.f17747l.a(this);
        }
    }

    private void g() {
        double d10;
        double d11;
        double d12;
        double d13;
        int i10;
        int floor = (int) Math.floor((double) this.f17742g.h().floatValue());
        u2.a<?, Float> aVar = this.f17744i;
        if (aVar == null) {
            d10 = 0.0d;
        } else {
            d10 = (double) aVar.h().floatValue();
        }
        double radians = Math.toRadians(d10 - 90.0d);
        double d14 = (double) floor;
        float floatValue = this.f17748m.h().floatValue() / 100.0f;
        float floatValue2 = this.f17746k.h().floatValue();
        double d15 = (double) floatValue2;
        float cos = (float) (Math.cos(radians) * d15);
        float sin = (float) (Math.sin(radians) * d15);
        this.f17736a.moveTo(cos, sin);
        double d16 = (double) ((float) (6.283185307179586d / d14));
        double d17 = radians + d16;
        double ceil = Math.ceil(d14);
        int i11 = 0;
        while (((double) i11) < ceil) {
            float cos2 = (float) (Math.cos(d17) * d15);
            double d18 = ceil;
            float sin2 = (float) (d15 * Math.sin(d17));
            if (floatValue != 0.0f) {
                d13 = d15;
                i10 = i11;
                d12 = d17;
                double atan2 = (double) ((float) (Math.atan2((double) sin, (double) cos) - 1.5707963267948966d));
                float cos3 = (float) Math.cos(atan2);
                d11 = d16;
                double atan22 = (double) ((float) (Math.atan2((double) sin2, (double) cos2) - 1.5707963267948966d));
                float f10 = floatValue2 * floatValue * 0.25f;
                float f11 = cos3 * f10;
                float sin3 = ((float) Math.sin(atan2)) * f10;
                float cos4 = ((float) Math.cos(atan22)) * f10;
                float sin4 = f10 * ((float) Math.sin(atan22));
                this.f17736a.cubicTo(cos - f11, sin - sin3, cos2 + cos4, sin2 + sin4, cos2, sin2);
            } else {
                d12 = d17;
                d13 = d15;
                d11 = d16;
                i10 = i11;
                this.f17736a.lineTo(cos2, sin2);
            }
            d17 = d12 + d11;
            i11 = i10 + 1;
            sin = sin2;
            cos = cos2;
            ceil = d18;
            d15 = d13;
            d16 = d11;
        }
        PointF h10 = this.f17743h.h();
        this.f17736a.offset(h10.x, h10.y);
        this.f17736a.close();
    }

    private void i() {
        double d10;
        float f10;
        float f11;
        double d11;
        int i10;
        float f12;
        float f13;
        float f14;
        double d12;
        float f15;
        float f16;
        float f17;
        double d13;
        float f18;
        float f19;
        float f20;
        float f21;
        float f22;
        float f23;
        float f24;
        float f25;
        float floatValue = this.f17742g.h().floatValue();
        u2.a<?, Float> aVar = this.f17744i;
        if (aVar == null) {
            d10 = 0.0d;
        } else {
            d10 = (double) aVar.h().floatValue();
        }
        double radians = Math.toRadians(d10 - 90.0d);
        double d14 = (double) floatValue;
        float f26 = (float) (6.283185307179586d / d14);
        if (this.f17741f) {
            f26 *= -1.0f;
        }
        float f27 = f26 / 2.0f;
        float f28 = floatValue - ((float) ((int) floatValue));
        int i11 = (f28 > 0.0f ? 1 : (f28 == 0.0f ? 0 : -1));
        if (i11 != 0) {
            radians += (double) ((1.0f - f28) * f27);
        }
        float floatValue2 = this.f17746k.h().floatValue();
        float floatValue3 = this.f17745j.h().floatValue();
        u2.a<?, Float> aVar2 = this.f17747l;
        if (aVar2 != null) {
            f10 = aVar2.h().floatValue() / 100.0f;
        } else {
            f10 = 0.0f;
        }
        u2.a<?, Float> aVar3 = this.f17748m;
        if (aVar3 != null) {
            f11 = aVar3.h().floatValue() / 100.0f;
        } else {
            f11 = 0.0f;
        }
        if (i11 != 0) {
            f12 = ((floatValue2 - floatValue3) * f28) + floatValue3;
            i10 = i11;
            double d15 = (double) f12;
            d11 = d14;
            f14 = (float) (d15 * Math.cos(radians));
            f13 = (float) (d15 * Math.sin(radians));
            this.f17736a.moveTo(f14, f13);
            d12 = radians + ((double) ((f26 * f28) / 2.0f));
        } else {
            d11 = d14;
            i10 = i11;
            double d16 = (double) floatValue2;
            float cos = (float) (Math.cos(radians) * d16);
            float sin = (float) (d16 * Math.sin(radians));
            this.f17736a.moveTo(cos, sin);
            d12 = radians + ((double) f27);
            f14 = cos;
            f13 = sin;
            f12 = 0.0f;
        }
        double ceil = Math.ceil(d11) * 2.0d;
        float f29 = floatValue2;
        float f30 = floatValue3;
        int i12 = 0;
        boolean z10 = false;
        while (true) {
            double d17 = (double) i12;
            if (d17 < ceil) {
                if (z10) {
                    f15 = f29;
                } else {
                    f15 = f30;
                }
                int i13 = (f12 > 0.0f ? 1 : (f12 == 0.0f ? 0 : -1));
                if (i13 == 0 || d17 != ceil - 2.0d) {
                    f16 = f26;
                    f17 = f27;
                } else {
                    f16 = f26;
                    f17 = (f26 * f28) / 2.0f;
                }
                if (i13 == 0 || d17 != ceil - 1.0d) {
                    f18 = f27;
                    d13 = d17;
                    f19 = f15;
                } else {
                    f18 = f27;
                    d13 = d17;
                    f19 = f12;
                }
                double d18 = (double) f19;
                double d19 = ceil;
                float cos2 = (float) (d18 * Math.cos(d12));
                float sin2 = (float) (d18 * Math.sin(d12));
                if (f10 == 0.0f && f11 == 0.0f) {
                    this.f17736a.lineTo(cos2, sin2);
                    f21 = f10;
                    f20 = f12;
                } else {
                    f21 = f10;
                    f20 = f12;
                    double atan2 = (double) ((float) (Math.atan2((double) f13, (double) f14) - 1.5707963267948966d));
                    float sin3 = (float) Math.sin(atan2);
                    float cos3 = (float) Math.cos(atan2);
                    double atan22 = (double) ((float) (Math.atan2((double) sin2, (double) cos2) - 1.5707963267948966d));
                    float cos4 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    if (z10) {
                        f22 = f21;
                    } else {
                        f22 = f11;
                    }
                    if (z10) {
                        f23 = f11;
                    } else {
                        f23 = f21;
                    }
                    if (z10) {
                        f24 = f30;
                    } else {
                        f24 = f29;
                    }
                    if (z10) {
                        f25 = f29;
                    } else {
                        f25 = f30;
                    }
                    float f31 = f24 * f22 * 0.47829f;
                    float f32 = cos3 * f31;
                    float f33 = f31 * sin3;
                    float f34 = f25 * f23 * 0.47829f;
                    float f35 = cos4 * f34;
                    float f36 = f34 * sin4;
                    if (i10 != 0) {
                        if (i12 == 0) {
                            f32 *= f28;
                            f33 *= f28;
                        } else if (d13 == d19 - 1.0d) {
                            f35 *= f28;
                            f36 *= f28;
                        }
                    }
                    this.f17736a.cubicTo(f14 - f32, f13 - f33, cos2 + f35, sin2 + f36, cos2, sin2);
                }
                d12 += (double) f17;
                z10 = !z10;
                i12++;
                f14 = cos2;
                f13 = sin2;
                f10 = f21;
                f12 = f20;
                f27 = f18;
                f26 = f16;
                ceil = d19;
            } else {
                PointF h10 = this.f17743h.h();
                this.f17736a.offset(h10.x, h10.y);
                this.f17736a.close();
                return;
            }
        }
    }

    private void j() {
        this.f17750o = false;
        this.f17738c.invalidateSelf();
    }

    public void a() {
        j();
    }

    public void b(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVar = list.get(i10);
            if (cVar instanceof u) {
                u uVar = (u) cVar;
                if (uVar.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f17749n.a(uVar);
                    uVar.c(this);
                }
            }
        }
    }

    public <T> void c(T t10, c<T> cVar) {
        u2.a<?, Float> aVar;
        u2.a<?, Float> aVar2;
        if (t10 == h0.f8587w) {
            this.f17742g.n(cVar);
        } else if (t10 == h0.f8588x) {
            this.f17744i.n(cVar);
        } else if (t10 == h0.f8578n) {
            this.f17743h.n(cVar);
        } else if (t10 == h0.f8589y && (aVar2 = this.f17745j) != null) {
            aVar2.n(cVar);
        } else if (t10 == h0.f8590z) {
            this.f17746k.n(cVar);
        } else if (t10 == h0.A && (aVar = this.f17747l) != null) {
            aVar.n(cVar);
        } else if (t10 == h0.B) {
            this.f17748m.n(cVar);
        }
    }

    public void e(d dVar, int i10, List<d> list, d dVar2) {
        i.k(dVar, i10, list, dVar2, this);
    }

    public String getName() {
        return this.f17737b;
    }

    public Path getPath() {
        if (this.f17750o) {
            return this.f17736a;
        }
        this.f17736a.reset();
        if (this.f17740e) {
            this.f17750o = true;
            return this.f17736a;
        }
        int i10 = a.f17751a[this.f17739d.ordinal()];
        if (i10 == 1) {
            i();
        } else if (i10 == 2) {
            g();
        }
        this.f17736a.close();
        this.f17749n.b(this.f17736a);
        this.f17750o = true;
        return this.f17736a;
    }
}
