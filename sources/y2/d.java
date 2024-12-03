package y2;

import c3.i;
import java.util.Arrays;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f18591a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f18592b;

    public d(float[] fArr, int[] iArr) {
        this.f18591a = fArr;
        this.f18592b = iArr;
    }

    private int b(float f10) {
        int binarySearch = Arrays.binarySearch(this.f18591a, f10);
        if (binarySearch >= 0) {
            return this.f18592b[binarySearch];
        }
        int i10 = -(binarySearch + 1);
        if (i10 == 0) {
            return this.f18592b[0];
        }
        int[] iArr = this.f18592b;
        if (i10 == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.f18591a;
        int i11 = i10 - 1;
        float f11 = fArr[i11];
        return c3.d.c((f10 - f11) / (fArr[i10] - f11), iArr[i11], iArr[i10]);
    }

    public d a(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i10 = 0; i10 < fArr.length; i10++) {
            iArr[i10] = b(fArr[i10]);
        }
        return new d(fArr, iArr);
    }

    public int[] c() {
        return this.f18592b;
    }

    public float[] d() {
        return this.f18591a;
    }

    public int e() {
        return this.f18592b.length;
    }

    public void f(d dVar, d dVar2, float f10) {
        if (dVar.f18592b.length == dVar2.f18592b.length) {
            for (int i10 = 0; i10 < dVar.f18592b.length; i10++) {
                this.f18591a[i10] = i.i(dVar.f18591a[i10], dVar2.f18591a[i10], f10);
                this.f18592b[i10] = c3.d.c(f10, dVar.f18592b[i10], dVar2.f18592b[i10]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + dVar.f18592b.length + " vs " + dVar2.f18592b.length + ")");
    }
}
