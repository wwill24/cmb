package t2;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import c3.i;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h0;
import d3.c;
import java.util.List;
import u2.a;
import w2.d;
import y2.g;

public class p implements e, m, j, a.b, k {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f17763a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Path f17764b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final LottieDrawable f17765c;

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.model.layer.a f17766d;

    /* renamed from: e  reason: collision with root package name */
    private final String f17767e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f17768f;

    /* renamed from: g  reason: collision with root package name */
    private final a<Float, Float> f17769g;

    /* renamed from: h  reason: collision with root package name */
    private final a<Float, Float> f17770h;

    /* renamed from: i  reason: collision with root package name */
    private final u2.p f17771i;

    /* renamed from: j  reason: collision with root package name */
    private d f17772j;

    public p(LottieDrawable lottieDrawable, com.airbnb.lottie.model.layer.a aVar, g gVar) {
        this.f17765c = lottieDrawable;
        this.f17766d = aVar;
        this.f17767e = gVar.c();
        this.f17768f = gVar.f();
        a<Float, Float> a10 = gVar.b().a();
        this.f17769g = a10;
        aVar.i(a10);
        a10.a(this);
        a<Float, Float> a11 = gVar.d().a();
        this.f17770h = a11;
        aVar.i(a11);
        a11.a(this);
        u2.p b10 = gVar.e().b();
        this.f17771i = b10;
        b10.a(aVar);
        b10.b(this);
    }

    public void a() {
        this.f17765c.invalidateSelf();
    }

    public void b(List<c> list, List<c> list2) {
        this.f17772j.b(list, list2);
    }

    public <T> void c(T t10, c<T> cVar) {
        if (!this.f17771i.c(t10, cVar)) {
            if (t10 == h0.f8585u) {
                this.f17769g.n(cVar);
            } else if (t10 == h0.f8586v) {
                this.f17770h.n(cVar);
            }
        }
    }

    public void e(d dVar, int i10, List<d> list, d dVar2) {
        i.k(dVar, i10, list, dVar2, this);
        for (int i11 = 0; i11 < this.f17772j.j().size(); i11++) {
            c cVar = this.f17772j.j().get(i11);
            if (cVar instanceof k) {
                i.k(dVar, i10, list, dVar2, (k) cVar);
            }
        }
    }

    public void f(RectF rectF, Matrix matrix, boolean z10) {
        this.f17772j.f(rectF, matrix, z10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0005 A[LOOP:0: B:3:0x0005->B:6:0x000f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(java.util.ListIterator<t2.c> r9) {
        /*
            r8 = this;
            t2.d r0 = r8.f17772j
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r9.hasPrevious()
            if (r0 == 0) goto L_0x0012
            java.lang.Object r0 = r9.previous()
            if (r0 == r8) goto L_0x0012
            goto L_0x0005
        L_0x0012:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L_0x0017:
            boolean r0 = r9.hasPrevious()
            if (r0 == 0) goto L_0x002a
            java.lang.Object r0 = r9.previous()
            t2.c r0 = (t2.c) r0
            r6.add(r0)
            r9.remove()
            goto L_0x0017
        L_0x002a:
            java.util.Collections.reverse(r6)
            t2.d r9 = new t2.d
            com.airbnb.lottie.LottieDrawable r2 = r8.f17765c
            com.airbnb.lottie.model.layer.a r3 = r8.f17766d
            boolean r5 = r8.f17768f
            r7 = 0
            java.lang.String r4 = "Repeater"
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)
            r8.f17772j = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: t2.p.g(java.util.ListIterator):void");
    }

    public String getName() {
        return this.f17767e;
    }

    public Path getPath() {
        Path path = this.f17772j.getPath();
        this.f17764b.reset();
        float floatValue = this.f17769g.h().floatValue();
        float floatValue2 = this.f17770h.h().floatValue();
        for (int i10 = ((int) floatValue) - 1; i10 >= 0; i10--) {
            this.f17763a.set(this.f17771i.g(((float) i10) + floatValue2));
            this.f17764b.addPath(path, this.f17763a);
        }
        return this.f17764b;
    }

    public void h(Canvas canvas, Matrix matrix, int i10) {
        float floatValue = this.f17769g.h().floatValue();
        float floatValue2 = this.f17770h.h().floatValue();
        float floatValue3 = this.f17771i.i().h().floatValue() / 100.0f;
        float floatValue4 = this.f17771i.e().h().floatValue() / 100.0f;
        for (int i11 = ((int) floatValue) - 1; i11 >= 0; i11--) {
            this.f17763a.set(matrix);
            float f10 = (float) i11;
            this.f17763a.preConcat(this.f17771i.g(f10 + floatValue2));
            this.f17772j.h(canvas, this.f17763a, (int) (((float) i10) * i.i(floatValue3, floatValue4, f10 / floatValue)));
        }
    }
}
