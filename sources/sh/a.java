package sh;

import java.lang.reflect.Array;
import java.util.Arrays;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final byte[][] f24487a;

    /* renamed from: b  reason: collision with root package name */
    private final int f24488b;

    /* renamed from: c  reason: collision with root package name */
    private final int f24489c;

    public a(int i10, int i11) {
        int[] iArr = new int[2];
        iArr[1] = i10;
        iArr[0] = i11;
        this.f24487a = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        this.f24488b = i10;
        this.f24489c = i11;
    }

    public void a(byte b10) {
        for (byte[] fill : this.f24487a) {
            Arrays.fill(fill, b10);
        }
    }

    public byte b(int i10, int i11) {
        return this.f24487a[i11][i10];
    }

    public byte[][] c() {
        return this.f24487a;
    }

    public int d() {
        return this.f24489c;
    }

    public int e() {
        return this.f24488b;
    }

    public void f(int i10, int i11, int i12) {
        this.f24487a[i11][i10] = (byte) i12;
    }

    public void g(int i10, int i11, boolean z10) {
        this.f24487a[i11][i10] = z10 ? (byte) 1 : 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder((this.f24488b * 2 * this.f24489c) + 2);
        for (int i10 = 0; i10 < this.f24489c; i10++) {
            byte[] bArr = this.f24487a[i10];
            for (int i11 = 0; i11 < this.f24488b; i11++) {
                byte b10 = bArr[i11];
                if (b10 == 0) {
                    sb2.append(" 0");
                } else if (b10 != 1) {
                    sb2.append("  ");
                } else {
                    sb2.append(" 1");
                }
            }
            sb2.append(10);
        }
        return sb2.toString();
    }
}
