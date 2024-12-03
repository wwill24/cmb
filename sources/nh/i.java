package nh;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

public final class i extends o {
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + n.b(str);
            } catch (FormatException e10) {
                throw new IllegalArgumentException(e10);
            }
        } else if (length == 8) {
            try {
                if (!n.a(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 7 or 8 digits long, but got " + length);
        }
        l.c(str);
        boolean[] zArr = new boolean[67];
        int b10 = l.b(zArr, 0, n.f23820a, true) + 0;
        for (int i10 = 0; i10 <= 3; i10++) {
            b10 += l.b(zArr, b10, n.f23823d[Character.digit(str.charAt(i10), 10)], false);
        }
        int b11 = b10 + l.b(zArr, b10, n.f23821b, false);
        for (int i11 = 4; i11 <= 7; i11++) {
            b11 += l.b(zArr, b11, n.f23823d[Character.digit(str.charAt(i11), 10)], true);
        }
        l.b(zArr, b11, n.f23820a, true);
        return zArr;
    }

    /* access modifiers changed from: protected */
    public Collection<BarcodeFormat> g() {
        return Collections.singleton(BarcodeFormat.EAN_8);
    }
}
