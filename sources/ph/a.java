package ph;

import java.lang.reflect.Array;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b[] f24383a;

    /* renamed from: b  reason: collision with root package name */
    private int f24384b;

    /* renamed from: c  reason: collision with root package name */
    private final int f24385c;

    /* renamed from: d  reason: collision with root package name */
    private final int f24386d;

    a(int i10, int i11) {
        b[] bVarArr = new b[i10];
        this.f24383a = bVarArr;
        int length = bVarArr.length;
        for (int i12 = 0; i12 < length; i12++) {
            this.f24383a[i12] = new b(((i11 + 4) * 17) + 1);
        }
        this.f24386d = i11 * 17;
        this.f24385c = i10;
        this.f24384b = -1;
    }

    /* access modifiers changed from: package-private */
    public b a() {
        return this.f24383a[this.f24384b];
    }

    public byte[][] b(int i10, int i11) {
        int[] iArr = new int[2];
        iArr[1] = this.f24386d * i10;
        iArr[0] = this.f24385c * i11;
        byte[][] bArr = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        int i12 = this.f24385c * i11;
        for (int i13 = 0; i13 < i12; i13++) {
            bArr[(i12 - i13) - 1] = this.f24383a[i13 / i11].b(i10);
        }
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f24384b++;
    }
}
