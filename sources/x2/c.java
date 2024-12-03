package x2;

import d3.a;
import java.util.Arrays;
import java.util.List;
import u2.e;
import y2.d;

public class c extends n<d, d> {
    public c(List<a<d>> list) {
        super(d(list));
    }

    private static a<d> c(a<d> aVar) {
        d dVar = (d) aVar.f14406b;
        d dVar2 = (d) aVar.f14407c;
        if (dVar == null || dVar2 == null || dVar.d().length == dVar2.d().length) {
            return aVar;
        }
        float[] e10 = e(dVar.d(), dVar2.d());
        return aVar.b(dVar.a(e10), dVar2.a(e10));
    }

    private static List<a<d>> d(List<a<d>> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            list.set(i10, c(list.get(i10)));
        }
        return list;
    }

    static float[] e(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f10 = Float.NaN;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            float f11 = fArr3[i11];
            if (f11 != f10) {
                fArr3[i10] = f11;
                i10++;
                f10 = fArr3[i11];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i10);
    }

    public u2.a<d, d> a() {
        return new e(this.f18525a);
    }

    public /* bridge */ /* synthetic */ List b() {
        return super.b();
    }

    public /* bridge */ /* synthetic */ boolean isStatic() {
        return super.isStatic();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
