package t2;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.e;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h0;
import com.airbnb.lottie.model.content.GradientType;
import d3.c;
import u2.a;
import u2.q;
import y2.d;

public class i extends a {
    private final a<PointF, PointF> A;
    private q B;

    /* renamed from: r  reason: collision with root package name */
    private final String f17720r;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f17721s;

    /* renamed from: t  reason: collision with root package name */
    private final e<LinearGradient> f17722t = new e<>();

    /* renamed from: u  reason: collision with root package name */
    private final e<RadialGradient> f17723u = new e<>();

    /* renamed from: v  reason: collision with root package name */
    private final RectF f17724v = new RectF();

    /* renamed from: w  reason: collision with root package name */
    private final GradientType f17725w;

    /* renamed from: x  reason: collision with root package name */
    private final int f17726x;

    /* renamed from: y  reason: collision with root package name */
    private final a<d, d> f17727y;

    /* renamed from: z  reason: collision with root package name */
    private final a<PointF, PointF> f17728z;

    public i(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.a aVar2) {
        super(lottieDrawable, aVar, aVar2.b().b(), aVar2.g().b(), aVar2.i(), aVar2.k(), aVar2.m(), aVar2.h(), aVar2.c());
        this.f17720r = aVar2.j();
        this.f17725w = aVar2.f();
        this.f17721s = aVar2.n();
        this.f17726x = (int) (lottieDrawable.G().d() / 32.0f);
        a<d, d> a10 = aVar2.e().a();
        this.f17727y = a10;
        a10.a(this);
        aVar.i(a10);
        a<PointF, PointF> a11 = aVar2.l().a();
        this.f17728z = a11;
        a11.a(this);
        aVar.i(a11);
        a<PointF, PointF> a12 = aVar2.d().a();
        this.A = a12;
        a12.a(this);
        aVar.i(a12);
    }

    private int[] j(int[] iArr) {
        q qVar = this.B;
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

    private int k() {
        int i10;
        int round = Math.round(this.f17728z.f() * ((float) this.f17726x));
        int round2 = Math.round(this.A.f() * ((float) this.f17726x));
        int round3 = Math.round(this.f17727y.f() * ((float) this.f17726x));
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

    private LinearGradient l() {
        long k10 = (long) k();
        LinearGradient e10 = this.f17722t.e(k10);
        if (e10 != null) {
            return e10;
        }
        PointF h10 = this.f17728z.h();
        PointF h11 = this.A.h();
        d h12 = this.f17727y.h();
        LinearGradient linearGradient = new LinearGradient(h10.x, h10.y, h11.x, h11.y, j(h12.c()), h12.d(), Shader.TileMode.CLAMP);
        this.f17722t.l(k10, linearGradient);
        return linearGradient;
    }

    private RadialGradient m() {
        long k10 = (long) k();
        RadialGradient e10 = this.f17723u.e(k10);
        if (e10 != null) {
            return e10;
        }
        PointF h10 = this.f17728z.h();
        PointF h11 = this.A.h();
        d h12 = this.f17727y.h();
        int[] j10 = j(h12.c());
        float[] d10 = h12.d();
        float f10 = h10.x;
        float f11 = h10.y;
        RadialGradient radialGradient = new RadialGradient(f10, f11, (float) Math.hypot((double) (h11.x - f10), (double) (h11.y - f11)), j10, d10, Shader.TileMode.CLAMP);
        this.f17723u.l(k10, radialGradient);
        return radialGradient;
    }

    public <T> void c(T t10, c<T> cVar) {
        super.c(t10, cVar);
        if (t10 == h0.L) {
            q qVar = this.B;
            if (qVar != null) {
                this.f17652f.G(qVar);
            }
            if (cVar == null) {
                this.B = null;
                return;
            }
            q qVar2 = new q(cVar);
            this.B = qVar2;
            qVar2.a(this);
            this.f17652f.i(this.B);
        }
    }

    public String getName() {
        return this.f17720r;
    }

    public void h(Canvas canvas, Matrix matrix, int i10) {
        Shader shader;
        if (!this.f17721s) {
            f(this.f17724v, matrix, false);
            if (this.f17725w == GradientType.LINEAR) {
                shader = l();
            } else {
                shader = m();
            }
            shader.setLocalMatrix(matrix);
            this.f17655i.setShader(shader);
            super.h(canvas, matrix, i10);
        }
    }
}
