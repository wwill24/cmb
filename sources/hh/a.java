package hh;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import gh.c;
import java.nio.charset.Charset;
import java.util.Map;
import jh.b;

public final class a implements c {
    private static b b(String str, BarcodeFormat barcodeFormat, int i10, int i11, Charset charset, int i12, int i13) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return c(ih.c.d(str, i12, i13, charset), i10, i11);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
    }

    private static b c(ih.a aVar, int i10, int i11) {
        b a10 = aVar.a();
        if (a10 != null) {
            int h10 = a10.h();
            int e10 = a10.e();
            int max = Math.max(i10, h10);
            int max2 = Math.max(i11, e10);
            int min = Math.min(max / h10, max2 / e10);
            int i12 = (max - (h10 * min)) / 2;
            int i13 = (max2 - (e10 * min)) / 2;
            b bVar = new b(max, max2);
            int i14 = 0;
            while (i14 < e10) {
                int i15 = 0;
                int i16 = i12;
                while (i15 < h10) {
                    if (a10.d(i15, i14)) {
                        bVar.j(i16, i13, min, min);
                    }
                    i15++;
                    i16 += min;
                }
                i14++;
                i13 += min;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }

    public b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) {
        Charset charset = null;
        int i12 = 33;
        int i13 = 0;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.CHARACTER_SET;
            if (map.containsKey(encodeHintType)) {
                charset = Charset.forName(map.get(encodeHintType).toString());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.ERROR_CORRECTION;
            if (map.containsKey(encodeHintType2)) {
                i12 = Integer.parseInt(map.get(encodeHintType2).toString());
            }
            EncodeHintType encodeHintType3 = EncodeHintType.AZTEC_LAYERS;
            if (map.containsKey(encodeHintType3)) {
                i13 = Integer.parseInt(map.get(encodeHintType3).toString());
            }
        }
        return b(str, barcodeFormat, i10, i11, charset, i12, i13);
    }
}
