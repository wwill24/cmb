package t2;

import android.graphics.Path;
import android.graphics.PointF;
import c3.i;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h0;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import d3.c;
import java.util.List;
import u2.a;
import w2.d;
import y2.b;

public class f implements m, a.b, k {

    /* renamed from: a  reason: collision with root package name */
    private final Path f17678a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final String f17679b;

    /* renamed from: c  reason: collision with root package name */
    private final LottieDrawable f17680c;

    /* renamed from: d  reason: collision with root package name */
    private final a<?, PointF> f17681d;

    /* renamed from: e  reason: collision with root package name */
    private final a<?, PointF> f17682e;

    /* renamed from: f  reason: collision with root package name */
    private final b f17683f;

    /* renamed from: g  reason: collision with root package name */
    private final b f17684g = new b();

    /* renamed from: h  reason: collision with root package name */
    private boolean f17685h;

    public f(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, b bVar) {
        this.f17679b = bVar.b();
        this.f17680c = lottieDrawable;
        a<PointF, PointF> a10 = bVar.d().a();
        this.f17681d = a10;
        a<PointF, PointF> a11 = bVar.c().a();
        this.f17682e = a11;
        this.f17683f = bVar;
        aVar.i(a10);
        aVar.i(a11);
        a10.a(this);
        a11.a(this);
    }

    private void g() {
        this.f17685h = false;
        this.f17680c.invalidateSelf();
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
                    this.f17684g.a(uVar);
                    uVar.c(this);
                }
            }
        }
    }

    public <T> void c(T t10, c<T> cVar) {
        if (t10 == h0.f8575k) {
            this.f17681d.n(cVar);
        } else if (t10 == h0.f8578n) {
            this.f17682e.n(cVar);
        }
    }

    public void e(d dVar, int i10, List<d> list, d dVar2) {
        i.k(dVar, i10, list, dVar2, this);
    }

    public String getName() {
        return this.f17679b;
    }

    public Path getPath() {
        if (this.f17685h) {
            return this.f17678a;
        }
        this.f17678a.reset();
        if (this.f17683f.e()) {
            this.f17685h = true;
            return this.f17678a;
        }
        PointF h10 = this.f17681d.h();
        float f10 = h10.x / 2.0f;
        float f11 = h10.y / 2.0f;
        float f12 = f10 * 0.55228f;
        float f13 = 0.55228f * f11;
        this.f17678a.reset();
        if (this.f17683f.f()) {
            float f14 = -f11;
            this.f17678a.moveTo(0.0f, f14);
            float f15 = 0.0f - f12;
            float f16 = -f10;
            float f17 = 0.0f - f13;
            this.f17678a.cubicTo(f15, f14, f16, f17, f16, 0.0f);
            float f18 = f13 + 0.0f;
            float f19 = f14;
            this.f17678a.cubicTo(f16, f18, f15, f11, 0.0f, f11);
            float f20 = f12 + 0.0f;
            this.f17678a.cubicTo(f20, f11, f10, f18, f10, 0.0f);
            this.f17678a.cubicTo(f10, f17, f20, f19, 0.0f, f19);
        } else {
            float f21 = -f11;
            this.f17678a.moveTo(0.0f, f21);
            float f22 = f12 + 0.0f;
            float f23 = 0.0f - f13;
            this.f17678a.cubicTo(f22, f21, f10, f23, f10, 0.0f);
            float f24 = f13 + 0.0f;
            this.f17678a.cubicTo(f10, f24, f22, f11, 0.0f, f11);
            float f25 = 0.0f - f12;
            float f26 = -f10;
            this.f17678a.cubicTo(f25, f11, f26, f24, f26, 0.0f);
            float f27 = f21;
            this.f17678a.cubicTo(f26, f23, f25, f27, 0.0f, f27);
        }
        PointF h11 = this.f17682e.h();
        this.f17678a.offset(h11.x, h11.y);
        this.f17678a.close();
        this.f17684g.b(this.f17678a);
        this.f17685h = true;
        return this.f17678a;
    }
}
