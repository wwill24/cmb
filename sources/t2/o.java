package t2;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import c3.i;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h0;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import d3.c;
import java.util.List;
import u2.a;
import w2.d;
import y2.f;

public class o implements a.b, k, m {

    /* renamed from: a  reason: collision with root package name */
    private final Path f17752a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f17753b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    private final String f17754c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f17755d;

    /* renamed from: e  reason: collision with root package name */
    private final LottieDrawable f17756e;

    /* renamed from: f  reason: collision with root package name */
    private final a<?, PointF> f17757f;

    /* renamed from: g  reason: collision with root package name */
    private final a<?, PointF> f17758g;

    /* renamed from: h  reason: collision with root package name */
    private final a<?, Float> f17759h;

    /* renamed from: i  reason: collision with root package name */
    private final b f17760i = new b();

    /* renamed from: j  reason: collision with root package name */
    private a<Float, Float> f17761j = null;

    /* renamed from: k  reason: collision with root package name */
    private boolean f17762k;

    public o(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, f fVar) {
        this.f17754c = fVar.c();
        this.f17755d = fVar.f();
        this.f17756e = lottieDrawable;
        a<PointF, PointF> a10 = fVar.d().a();
        this.f17757f = a10;
        a<PointF, PointF> a11 = fVar.e().a();
        this.f17758g = a11;
        a<Float, Float> a12 = fVar.b().a();
        this.f17759h = a12;
        aVar.i(a10);
        aVar.i(a11);
        aVar.i(a12);
        a10.a(this);
        a11.a(this);
        a12.a(this);
    }

    private void g() {
        this.f17762k = false;
        this.f17756e.invalidateSelf();
    }

    public void a() {
        g();
    }

    public void b(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVar = list.get(i10);
            if (cVar instanceof u) {
                u uVar = (u) cVar;
                if (uVar.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f17760i.a(uVar);
                    uVar.c(this);
                }
            }
            if (cVar instanceof q) {
                this.f17761j = ((q) cVar).g();
            }
        }
    }

    public <T> void c(T t10, c<T> cVar) {
        if (t10 == h0.f8576l) {
            this.f17758g.n(cVar);
        } else if (t10 == h0.f8578n) {
            this.f17757f.n(cVar);
        } else if (t10 == h0.f8577m) {
            this.f17759h.n(cVar);
        }
    }

    public void e(d dVar, int i10, List<d> list, d dVar2) {
        i.k(dVar, i10, list, dVar2, this);
    }

    public String getName() {
        return this.f17754c;
    }

    public Path getPath() {
        float f10;
        a<Float, Float> aVar;
        if (this.f17762k) {
            return this.f17752a;
        }
        this.f17752a.reset();
        if (this.f17755d) {
            this.f17762k = true;
            return this.f17752a;
        }
        PointF h10 = this.f17758g.h();
        float f11 = h10.x / 2.0f;
        float f12 = h10.y / 2.0f;
        a<?, Float> aVar2 = this.f17759h;
        if (aVar2 == null) {
            f10 = 0.0f;
        } else {
            f10 = ((u2.d) aVar2).p();
        }
        if (f10 == 0.0f && (aVar = this.f17761j) != null) {
            f10 = Math.min(aVar.h().floatValue(), Math.min(f11, f12));
        }
        float min = Math.min(f11, f12);
        if (f10 > min) {
            f10 = min;
        }
        PointF h11 = this.f17757f.h();
        this.f17752a.moveTo(h11.x + f11, (h11.y - f12) + f10);
        this.f17752a.lineTo(h11.x + f11, (h11.y + f12) - f10);
        int i10 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
        if (i10 > 0) {
            RectF rectF = this.f17753b;
            float f13 = h11.x;
            float f14 = f10 * 2.0f;
            float f15 = h11.y;
            rectF.set((f13 + f11) - f14, (f15 + f12) - f14, f13 + f11, f15 + f12);
            this.f17752a.arcTo(this.f17753b, 0.0f, 90.0f, false);
        }
        this.f17752a.lineTo((h11.x - f11) + f10, h11.y + f12);
        if (i10 > 0) {
            RectF rectF2 = this.f17753b;
            float f16 = h11.x;
            float f17 = h11.y;
            float f18 = f10 * 2.0f;
            rectF2.set(f16 - f11, (f17 + f12) - f18, (f16 - f11) + f18, f17 + f12);
            this.f17752a.arcTo(this.f17753b, 90.0f, 90.0f, false);
        }
        this.f17752a.lineTo(h11.x - f11, (h11.y - f12) + f10);
        if (i10 > 0) {
            RectF rectF3 = this.f17753b;
            float f19 = h11.x;
            float f20 = h11.y;
            float f21 = f10 * 2.0f;
            rectF3.set(f19 - f11, f20 - f12, (f19 - f11) + f21, (f20 - f12) + f21);
            this.f17752a.arcTo(this.f17753b, 180.0f, 90.0f, false);
        }
        this.f17752a.lineTo((h11.x + f11) - f10, h11.y - f12);
        if (i10 > 0) {
            RectF rectF4 = this.f17753b;
            float f22 = h11.x;
            float f23 = f10 * 2.0f;
            float f24 = h11.y;
            rectF4.set((f22 + f11) - f23, f24 - f12, f22 + f11, (f24 - f12) + f23);
            this.f17752a.arcTo(this.f17753b, 270.0f, 90.0f, false);
        }
        this.f17752a.close();
        this.f17760i.b(this.f17752a);
        this.f17762k = true;
        return this.f17752a;
    }
}
