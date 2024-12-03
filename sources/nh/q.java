package nh;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

public final class q extends o {
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + n.b(p.c(str));
            } catch (FormatException e10) {
                throw new IllegalArgumentException(e10);
            }
        } else if (length == 8) {
            try {
                if (!n.a(p.c(str))) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 7 or 8 digits long, but got " + length);
        }
        l.c(str);
        int digit = Character.digit(str.charAt(0), 10);
        if (digit == 0 || digit == 1) {
            int i10 = p.f23826g[digit][Character.digit(str.charAt(7), 10)];
            boolean[] zArr = new boolean[51];
            int b10 = l.b(zArr, 0, n.f23820a, true);
            for (int i11 = 1; i11 <= 6; i11++) {
                int digit2 = Character.digit(str.charAt(i11), 10);
                if (((i10 >> (6 - i11)) & 1) == 1) {
                    digit2 += 10;
                }
                b10 += l.b(zArr, b10, n.f23824e[digit2], false);
            }
            l.b(zArr, b10, n.f23822c, false);
            return zArr;
        }
        throw new IllegalArgumentException("Number system must be 0 or 1");
    }

    /* access modifiers changed from: protected */
    public Collection<BarcodeFormat> g() {
        return Collections.singleton(BarcodeFormat.UPC_E);
    }
}
