package nh;

import com.google.zxing.BarcodeFormat;
import java.util.Collection;
import java.util.Collections;

public final class j extends l {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f23815b = {1, 1, 1, 1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f23816c = {3, 1, 1};

    /* renamed from: d  reason: collision with root package name */
    private static final int[][] f23817d = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    public boolean[] d(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        } else if (length <= 80) {
            l.c(str);
            boolean[] zArr = new boolean[((length * 9) + 9)];
            int b10 = l.b(zArr, 0, f23815b, true);
            for (int i10 = 0; i10 < length; i10 += 2) {
                int digit = Character.digit(str.charAt(i10), 10);
                int digit2 = Character.digit(str.charAt(i10 + 1), 10);
                int[] iArr = new int[10];
                for (int i11 = 0; i11 < 5; i11++) {
                    int i12 = i11 * 2;
                    int[][] iArr2 = f23817d;
                    iArr[i12] = iArr2[digit][i11];
                    iArr[i12 + 1] = iArr2[digit2][i11];
                }
                b10 += l.b(zArr, b10, iArr, true);
            }
            l.b(zArr, b10, f23816c, true);
            return zArr;
        } else {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
    }

    /* access modifiers changed from: protected */
    public Collection<BarcodeFormat> g() {
        return Collections.singleton(BarcodeFormat.ITF);
    }
}
