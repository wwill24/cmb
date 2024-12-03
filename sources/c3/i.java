package c3;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;
import t2.k;
import w2.a;
import w2.d;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final PointF f7942a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f10, float f11, float f12) {
        return Math.max(f11, Math.min(f12, f10));
    }

    public static int c(int i10, int i11, int i12) {
        return Math.max(i11, Math.min(i12, i10));
    }

    public static boolean d(float f10, float f11, float f12) {
        return f10 >= f11 && f10 <= f12;
    }

    private static int e(int i10, int i11) {
        boolean z10;
        int i12 = i10 / i11;
        if ((i10 ^ i11) >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i13 = i10 % i11;
        if (z10 || i13 == 0) {
            return i12;
        }
        return i12 - 1;
    }

    static int f(float f10, float f11) {
        return g((int) f10, (int) f11);
    }

    private static int g(int i10, int i11) {
        return i10 - (i11 * e(i10, i11));
    }

    public static void h(y2.i iVar, Path path) {
        path.reset();
        PointF b10 = iVar.b();
        path.moveTo(b10.x, b10.y);
        f7942a.set(b10.x, b10.y);
        for (int i10 = 0; i10 < iVar.a().size(); i10++) {
            a aVar = iVar.a().get(i10);
            PointF a10 = aVar.a();
            PointF b11 = aVar.b();
            PointF c10 = aVar.c();
            PointF pointF = f7942a;
            if (!a10.equals(pointF) || !b11.equals(c10)) {
                path.cubicTo(a10.x, a10.y, b11.x, b11.y, c10.x, c10.y);
            } else {
                path.lineTo(c10.x, c10.y);
            }
            pointF.set(c10.x, c10.y);
        }
        if (iVar.d()) {
            path.close();
        }
    }

    public static float i(float f10, float f11, float f12) {
        return f10 + (f12 * (f11 - f10));
    }

    public static int j(int i10, int i11, float f10) {
        return (int) (((float) i10) + (f10 * ((float) (i11 - i10))));
    }

    public static void k(d dVar, int i10, List<d> list, d dVar2, k kVar) {
        if (dVar.c(kVar.getName(), i10)) {
            list.add(dVar2.a(kVar.getName()).i(kVar));
        }
    }
}
