package tf;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private final m[] f24571a = new m[4];

    /* renamed from: b  reason: collision with root package name */
    private final Matrix[] f24572b = new Matrix[4];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix[] f24573c = new Matrix[4];

    /* renamed from: d  reason: collision with root package name */
    private final PointF f24574d = new PointF();

    /* renamed from: e  reason: collision with root package name */
    private final Path f24575e = new Path();

    /* renamed from: f  reason: collision with root package name */
    private final Path f24576f = new Path();

    /* renamed from: g  reason: collision with root package name */
    private final m f24577g = new m();

    /* renamed from: h  reason: collision with root package name */
    private final float[] f24578h = new float[2];

    /* renamed from: i  reason: collision with root package name */
    private final float[] f24579i = new float[2];

    /* renamed from: j  reason: collision with root package name */
    private final Path f24580j = new Path();

    /* renamed from: k  reason: collision with root package name */
    private final Path f24581k = new Path();

    /* renamed from: l  reason: collision with root package name */
    private boolean f24582l = true;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static final l f24583a = new l();
    }

    public interface b {
        void a(m mVar, Matrix matrix, int i10);

        void b(m mVar, Matrix matrix, int i10);
    }

    static final class c {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final k f24584a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final Path f24585b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public final RectF f24586c;

        /* renamed from: d  reason: collision with root package name */
        public final b f24587d;

        /* renamed from: e  reason: collision with root package name */
        public final float f24588e;

        c(@NonNull k kVar, float f10, RectF rectF, b bVar, Path path) {
            this.f24587d = bVar;
            this.f24584a = kVar;
            this.f24588e = f10;
            this.f24586c = rectF;
            this.f24585b = path;
        }
    }

    public l() {
        for (int i10 = 0; i10 < 4; i10++) {
            this.f24571a[i10] = new m();
            this.f24572b[i10] = new Matrix();
            this.f24573c[i10] = new Matrix();
        }
    }

    private float a(int i10) {
        return (float) (((i10 + 1) % 4) * 90);
    }

    private void b(@NonNull c cVar, int i10) {
        this.f24578h[0] = this.f24571a[i10].k();
        this.f24578h[1] = this.f24571a[i10].l();
        this.f24572b[i10].mapPoints(this.f24578h);
        if (i10 == 0) {
            Path path = cVar.f24585b;
            float[] fArr = this.f24578h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.f24585b;
            float[] fArr2 = this.f24578h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f24571a[i10].d(this.f24572b[i10], cVar.f24585b);
        b bVar = cVar.f24587d;
        if (bVar != null) {
            bVar.a(this.f24571a[i10], this.f24572b[i10], i10);
        }
    }

    private void c(@NonNull c cVar, int i10) {
        int i11 = (i10 + 1) % 4;
        this.f24578h[0] = this.f24571a[i10].i();
        this.f24578h[1] = this.f24571a[i10].j();
        this.f24572b[i10].mapPoints(this.f24578h);
        this.f24579i[0] = this.f24571a[i11].k();
        this.f24579i[1] = this.f24571a[i11].l();
        this.f24572b[i11].mapPoints(this.f24579i);
        float[] fArr = this.f24578h;
        float f10 = fArr[0];
        float[] fArr2 = this.f24579i;
        float max = Math.max(((float) Math.hypot((double) (f10 - fArr2[0]), (double) (fArr[1] - fArr2[1]))) - 0.001f, 0.0f);
        float i12 = i(cVar.f24586c, i10);
        this.f24577g.n(0.0f, 0.0f);
        f j10 = j(i10, cVar.f24584a);
        j10.b(max, i12, cVar.f24588e, this.f24577g);
        this.f24580j.reset();
        this.f24577g.d(this.f24573c[i10], this.f24580j);
        if (!this.f24582l || (!j10.a() && !l(this.f24580j, i10) && !l(this.f24580j, i11))) {
            this.f24577g.d(this.f24573c[i10], cVar.f24585b);
        } else {
            Path path = this.f24580j;
            path.op(path, this.f24576f, Path.Op.DIFFERENCE);
            this.f24578h[0] = this.f24577g.k();
            this.f24578h[1] = this.f24577g.l();
            this.f24573c[i10].mapPoints(this.f24578h);
            Path path2 = this.f24575e;
            float[] fArr3 = this.f24578h;
            path2.moveTo(fArr3[0], fArr3[1]);
            this.f24577g.d(this.f24573c[i10], this.f24575e);
        }
        b bVar = cVar.f24587d;
        if (bVar != null) {
            bVar.b(this.f24577g, this.f24573c[i10], i10);
        }
    }

    private void f(int i10, @NonNull RectF rectF, @NonNull PointF pointF) {
        if (i10 == 1) {
            pointF.set(rectF.right, rectF.bottom);
        } else if (i10 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i10 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    private c g(int i10, @NonNull k kVar) {
        if (i10 == 1) {
            return kVar.l();
        }
        if (i10 == 2) {
            return kVar.j();
        }
        if (i10 != 3) {
            return kVar.t();
        }
        return kVar.r();
    }

    private d h(int i10, @NonNull k kVar) {
        if (i10 == 1) {
            return kVar.k();
        }
        if (i10 == 2) {
            return kVar.i();
        }
        if (i10 != 3) {
            return kVar.s();
        }
        return kVar.q();
    }

    private float i(@NonNull RectF rectF, int i10) {
        float[] fArr = this.f24578h;
        m mVar = this.f24571a[i10];
        fArr[0] = mVar.f24591c;
        fArr[1] = mVar.f24592d;
        this.f24572b[i10].mapPoints(fArr);
        if (i10 == 1 || i10 == 3) {
            return Math.abs(rectF.centerX() - this.f24578h[0]);
        }
        return Math.abs(rectF.centerY() - this.f24578h[1]);
    }

    private f j(int i10, @NonNull k kVar) {
        if (i10 == 1) {
            return kVar.h();
        }
        if (i10 == 2) {
            return kVar.n();
        }
        if (i10 != 3) {
            return kVar.o();
        }
        return kVar.p();
    }

    @NonNull
    public static l k() {
        return a.f24583a;
    }

    private boolean l(Path path, int i10) {
        this.f24581k.reset();
        this.f24571a[i10].d(this.f24572b[i10], this.f24581k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f24581k.computeBounds(rectF, true);
        path.op(this.f24581k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (!rectF.isEmpty()) {
            return true;
        }
        if (rectF.width() <= 1.0f || rectF.height() <= 1.0f) {
            return false;
        }
        return true;
    }

    private void m(@NonNull c cVar, int i10) {
        h(i10, cVar.f24584a).b(this.f24571a[i10], 90.0f, cVar.f24588e, cVar.f24586c, g(i10, cVar.f24584a));
        float a10 = a(i10);
        this.f24572b[i10].reset();
        f(i10, cVar.f24586c, this.f24574d);
        Matrix matrix = this.f24572b[i10];
        PointF pointF = this.f24574d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f24572b[i10].preRotate(a10);
    }

    private void n(int i10) {
        this.f24578h[0] = this.f24571a[i10].i();
        this.f24578h[1] = this.f24571a[i10].j();
        this.f24572b[i10].mapPoints(this.f24578h);
        float a10 = a(i10);
        this.f24573c[i10].reset();
        Matrix matrix = this.f24573c[i10];
        float[] fArr = this.f24578h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f24573c[i10].preRotate(a10);
    }

    public void d(k kVar, float f10, RectF rectF, @NonNull Path path) {
        e(kVar, f10, rectF, (b) null, path);
    }

    public void e(k kVar, float f10, RectF rectF, b bVar, @NonNull Path path) {
        path.rewind();
        this.f24575e.rewind();
        this.f24576f.rewind();
        this.f24576f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(kVar, f10, rectF, bVar, path);
        for (int i10 = 0; i10 < 4; i10++) {
            m(cVar, i10);
            n(i10);
        }
        for (int i11 = 0; i11 < 4; i11++) {
            b(cVar, i11);
            c(cVar, i11);
        }
        path.close();
        this.f24575e.close();
        if (!this.f24575e.isEmpty()) {
            path.op(this.f24575e, Path.Op.UNION);
        }
    }
}
