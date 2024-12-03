package nh;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

public final class h extends o {
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + n.b(str);
            } catch (FormatException e10) {
                throw new IllegalArgumentException(e10);
            }
        } else if (length == 13) {
            try {
                if (!n.a(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got " + length);
        }
        l.c(str);
        int i10 = g.f23814f[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int b10 = l.b(zArr, 0, n.f23820a, true) + 0;
        for (int i11 = 1; i11 <= 6; i11++) {
            int digit = Character.digit(str.charAt(i11), 10);
            if (((i10 >> (6 - i11)) & 1) == 1) {
                digit += 10;
            }
            b10 += l.b(zArr, b10, n.f23824e[digit], false);
        }
        int b11 = b10 + l.b(zArr, b10, n.f23821b, false);
        for (int i12 = 7; i12 <= 12; i12++) {
            b11 += l.b(zArr, b11, n.f23823d[Character.digit(str.charAt(i12), 10)], true);
        }
        l.b(zArr, b11, n.f23820a, true);
        return zArr;
    }

    /* access modifiers changed from: protected */
    public Collection<BarcodeFormat> g() {
        return Collections.singleton(BarcodeFormat.EAN_13);
    }
}
