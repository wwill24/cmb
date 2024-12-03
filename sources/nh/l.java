package nh;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import gh.c;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;
import jh.b;

public abstract class l implements c {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f23818a = Pattern.compile("[0-9]+");

    protected static int b(boolean[] zArr, int i10, int[] iArr, boolean z10) {
        int i11 = 0;
        for (int i12 : iArr) {
            int i13 = 0;
            while (i13 < i12) {
                zArr[i10] = z10;
                i13++;
                i10++;
            }
            i11 += i12;
            z10 = !z10;
        }
        return i11;
    }

    protected static void c(String str) {
        if (!f23818a.matcher(str).matches()) {
            throw new IllegalArgumentException("Input should only contain digits 0-9");
        }
    }

    private static b h(boolean[] zArr, int i10, int i11, int i12) {
        int length = zArr.length;
        int i13 = i12 + length;
        int max = Math.max(i10, i13);
        int max2 = Math.max(1, i11);
        int i14 = max / i13;
        int i15 = (max - (length * i14)) / 2;
        b bVar = new b(max, max2);
        int i16 = 0;
        while (i16 < length) {
            if (zArr[i16]) {
                bVar.j(i15, 0, i14, max2);
            }
            i16++;
            i15 += i14;
        }
        return bVar;
    }

    public b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i10 < 0 || i11 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i10 + 'x' + i11);
        } else {
            Collection<BarcodeFormat> g10 = g();
            if (g10 == null || g10.contains(barcodeFormat)) {
                int f10 = f();
                if (map != null) {
                    EncodeHintType encodeHintType = EncodeHintType.MARGIN;
                    if (map.containsKey(encodeHintType)) {
                        f10 = Integer.parseInt(map.get(encodeHintType).toString());
                    }
                }
                return h(e(str, map), i10, i11, f10);
            }
            throw new IllegalArgumentException("Can only encode " + g10 + ", but got " + barcodeFormat);
        }
    }

    public abstract boolean[] d(String str);

    /* access modifiers changed from: protected */
    public boolean[] e(String str, Map<EncodeHintType, ?> map) {
        return d(str);
    }

    public int f() {
        return 10;
    }

    /* access modifiers changed from: protected */
    public abstract Collection<BarcodeFormat> g();
}
