package tf;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class m {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public float f24589a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public float f24590b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public float f24591c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public float f24592d;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public float f24593e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public float f24594f;

    /* renamed from: g  reason: collision with root package name */
    private final List<f> f24595g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private final List<g> f24596h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private boolean f24597i;

    class a extends g {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f24598c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Matrix f24599d;

        a(List list, Matrix matrix) {
            this.f24598c = list;
            this.f24599d = matrix;
        }

        public void a(Matrix matrix, sf.a aVar, int i10, Canvas canvas) {
            for (g a10 : this.f24598c) {
                a10.a(this.f24599d, aVar, i10, canvas);
            }
        }
    }

    static class b extends g {

        /* renamed from: c  reason: collision with root package name */
        private final d f24601c;

        public b(d dVar) {
            this.f24601c = dVar;
        }

        public void a(Matrix matrix, @NonNull sf.a aVar, int i10, @NonNull Canvas canvas) {
            float h10 = this.f24601c.m();
            float i11 = this.f24601c.n();
            aVar.a(canvas, matrix, new RectF(this.f24601c.k(), this.f24601c.o(), this.f24601c.l(), this.f24601c.j()), i10, h10, i11);
        }
    }

    static class c extends g {

        /* renamed from: c  reason: collision with root package name */
        private final e f24602c;

        /* renamed from: d  reason: collision with root package name */
        private final float f24603d;

        /* renamed from: e  reason: collision with root package name */
        private final float f24604e;

        public c(e eVar, float f10, float f11) {
            this.f24602c = eVar;
            this.f24603d = f10;
            this.f24604e = f11;
        }

        public void a(Matrix matrix, @NonNull sf.a aVar, int i10, @NonNull Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot((double) (this.f24602c.f24613c - this.f24604e), (double) (this.f24602c.f24612b - this.f24603d)), 0.0f);
            this.f24616a.set(matrix);
            this.f24616a.preTranslate(this.f24603d, this.f24604e);
            this.f24616a.preRotate(c());
            aVar.b(canvas, this.f24616a, rectF, i10);
        }

        /* access modifiers changed from: package-private */
        public float c() {
            return (float) Math.toDegrees(Math.atan((double) ((this.f24602c.f24613c - this.f24604e) / (this.f24602c.f24612b - this.f24603d))));
        }
    }

    public static class d extends f {

        /* renamed from: h  reason: collision with root package name */
        private static final RectF f24605h = new RectF();
        @Deprecated

        /* renamed from: b  reason: collision with root package name */
        public float f24606b;
        @Deprecated

        /* renamed from: c  reason: collision with root package name */
        public float f24607c;
        @Deprecated

        /* renamed from: d  reason: collision with root package name */
        public float f24608d;
        @Deprecated

        /* renamed from: e  reason: collision with root package name */
        public float f24609e;
        @Deprecated

        /* renamed from: f  reason: collision with root package name */
        public float f24610f;
        @Deprecated

        /* renamed from: g  reason: collision with root package name */
        public float f24611g;

        public d(float f10, float f11, float f12, float f13) {
            q(f10);
            u(f11);
            r(f12);
            p(f13);
        }

        /* access modifiers changed from: private */
        public float j() {
            return this.f24609e;
        }

        /* access modifiers changed from: private */
        public float k() {
            return this.f24606b;
        }

        /* access modifiers changed from: private */
        public float l() {
            return this.f24608d;
        }

        /* access modifiers changed from: private */
        public float m() {
            return this.f24610f;
        }

        /* access modifiers changed from: private */
        public float n() {
            return this.f24611g;
        }

        /* access modifiers changed from: private */
        public float o() {
            return this.f24607c;
        }

        private void p(float f10) {
            this.f24609e = f10;
        }

        private void q(float f10) {
            this.f24606b = f10;
        }

        private void r(float f10) {
            this.f24608d = f10;
        }

        /* access modifiers changed from: private */
        public void s(float f10) {
            this.f24610f = f10;
        }

        /* access modifiers changed from: private */
        public void t(float f10) {
            this.f24611g = f10;
        }

        private void u(float f10) {
            this.f24607c = f10;
        }

        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f24614a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f24605h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    public static class e extends f {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public float f24612b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public float f24613c;

        public void a(@NonNull Matrix matrix, @NonNull Path path) {
            Matrix matrix2 = this.f24614a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f24612b, this.f24613c);
            path.transform(matrix);
        }
    }

    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        protected final Matrix f24614a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    static abstract class g {

        /* renamed from: b  reason: collision with root package name */
        static final Matrix f24615b = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        final Matrix f24616a = new Matrix();

        g() {
        }

        public abstract void a(Matrix matrix, sf.a aVar, int i10, Canvas canvas);

        public final void b(sf.a aVar, int i10, Canvas canvas) {
            a(f24615b, aVar, i10, canvas);
        }
    }

    public m() {
        n(0.0f, 0.0f);
    }

    private void b(float f10) {
        if (g() != f10) {
            float g10 = ((f10 - g()) + 360.0f) % 360.0f;
            if (g10 <= 180.0f) {
                d dVar = new d(i(), j(), i(), j());
                dVar.s(g());
                dVar.t(g10);
                this.f24596h.add(new b(dVar));
                p(f10);
            }
        }
    }

    private void c(g gVar, float f10, float f11) {
        b(f10);
        this.f24596h.add(gVar);
        p(f11);
    }

    private float g() {
        return this.f24593e;
    }

    private float h() {
        return this.f24594f;
    }

    private void p(float f10) {
        this.f24593e = f10;
    }

    private void q(float f10) {
        this.f24594f = f10;
    }

    private void r(float f10) {
        this.f24591c = f10;
    }

    private void s(float f10) {
        this.f24592d = f10;
    }

    private void t(float f10) {
        this.f24589a = f10;
    }

    private void u(float f10) {
        this.f24590b = f10;
    }

    public void a(float f10, float f11, float f12, float f13, float f14, float f15) {
        boolean z10;
        float f16;
        d dVar = new d(f10, f11, f12, f13);
        dVar.s(f14);
        dVar.t(f15);
        this.f24595g.add(dVar);
        b bVar = new b(dVar);
        float f17 = f14 + f15;
        if (f15 < 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            f14 = (f14 + 180.0f) % 360.0f;
        }
        if (z10) {
            f16 = (180.0f + f17) % 360.0f;
        } else {
            f16 = f17;
        }
        c(bVar, f14, f16);
        double d10 = (double) f17;
        r(((f10 + f12) * 0.5f) + (((f12 - f10) / 2.0f) * ((float) Math.cos(Math.toRadians(d10)))));
        s(((f11 + f13) * 0.5f) + (((f13 - f11) / 2.0f) * ((float) Math.sin(Math.toRadians(d10)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f24595g.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f24595g.get(i10).a(matrix, path);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        return this.f24597i;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public g f(Matrix matrix) {
        b(h());
        return new a(new ArrayList(this.f24596h), new Matrix(matrix));
    }

    /* access modifiers changed from: package-private */
    public float i() {
        return this.f24591c;
    }

    /* access modifiers changed from: package-private */
    public float j() {
        return this.f24592d;
    }

    /* access modifiers changed from: package-private */
    public float k() {
        return this.f24589a;
    }

    /* access modifiers changed from: package-private */
    public float l() {
        return this.f24590b;
    }

    public void m(float f10, float f11) {
        e eVar = new e();
        float unused = eVar.f24612b = f10;
        float unused2 = eVar.f24613c = f11;
        this.f24595g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f10);
        s(f11);
    }

    public void n(float f10, float f11) {
        o(f10, f11, 270.0f, 0.0f);
    }

    public void o(float f10, float f11, float f12, float f13) {
        t(f10);
        u(f11);
        r(f10);
        s(f11);
        p(f12);
        q((f12 + f13) % 360.0f);
        this.f24595g.clear();
        this.f24596h.clear();
        this.f24597i = false;
    }
}
