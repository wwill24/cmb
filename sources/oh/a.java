package oh;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.pdf417.encoder.Compaction;
import gh.c;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;
import jh.b;
import ph.d;

public final class a implements c {
    private static b b(byte[][] bArr, int i10) {
        int i11 = i10 * 2;
        b bVar = new b(bArr[0].length + i11, bArr.length + i11);
        bVar.b();
        int e10 = (bVar.e() - i10) - 1;
        int i12 = 0;
        while (i12 < bArr.length) {
            byte[] bArr2 = bArr[i12];
            for (int i13 = 0; i13 < bArr[0].length; i13++) {
                if (bArr2[i13] == 1) {
                    bVar.i(i13 + i10, e10);
                }
            }
            i12++;
            e10--;
        }
        return bVar;
    }

    private static b c(d dVar, String str, int i10, int i11, int i12, int i13, boolean z10) throws WriterException {
        boolean z11;
        boolean z12;
        boolean z13;
        dVar.e(str, i10, z10);
        byte[][] b10 = dVar.f().b(1, 4);
        if (i12 > i11) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (b10[0].length < b10.length) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 != z12) {
            b10 = d(b10);
            z13 = true;
        } else {
            z13 = false;
        }
        int min = Math.min(i11 / b10[0].length, i12 / b10.length);
        if (min <= 1) {
            return b(b10, i13);
        }
        byte[][] b11 = dVar.f().b(min, min * 4);
        if (z13) {
            b11 = d(b11);
        }
        return b(b11, i13);
    }

    private static byte[][] d(byte[][] bArr) {
        int length = bArr[0].length;
        int[] iArr = new int[2];
        iArr[1] = bArr.length;
        iArr[0] = length;
        byte[][] bArr2 = (byte[][]) Array.newInstance(Byte.TYPE, iArr);
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int length2 = (bArr.length - i10) - 1;
            for (int i11 = 0; i11 < bArr[0].length; i11++) {
                bArr2[i11][length2] = bArr[i10][i11];
            }
        }
        return bArr2;
    }

    public b a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.PDF_417) {
            d dVar = new d();
            int i12 = 30;
            int i13 = 2;
            boolean z10 = false;
            if (map != null) {
                EncodeHintType encodeHintType = EncodeHintType.PDF417_COMPACT;
                if (map.containsKey(encodeHintType)) {
                    dVar.h(Boolean.parseBoolean(map.get(encodeHintType).toString()));
                }
                EncodeHintType encodeHintType2 = EncodeHintType.PDF417_COMPACTION;
                if (map.containsKey(encodeHintType2)) {
                    dVar.i(Compaction.valueOf(map.get(encodeHintType2).toString()));
                }
                EncodeHintType encodeHintType3 = EncodeHintType.PDF417_DIMENSIONS;
                if (map.containsKey(encodeHintType3)) {
                    ph.c cVar = (ph.c) map.get(encodeHintType3);
                    dVar.j(cVar.a(), cVar.c(), cVar.b(), cVar.d());
                }
                EncodeHintType encodeHintType4 = EncodeHintType.MARGIN;
                if (map.containsKey(encodeHintType4)) {
                    i12 = Integer.parseInt(map.get(encodeHintType4).toString());
                }
                EncodeHintType encodeHintType5 = EncodeHintType.ERROR_CORRECTION;
                if (map.containsKey(encodeHintType5)) {
                    i13 = Integer.parseInt(map.get(encodeHintType5).toString());
                }
                EncodeHintType encodeHintType6 = EncodeHintType.CHARACTER_SET;
                if (map.containsKey(encodeHintType6)) {
                    dVar.k(Charset.forName(map.get(encodeHintType6).toString()));
                }
                EncodeHintType encodeHintType7 = EncodeHintType.PDF417_AUTO_ECI;
                if (map.containsKey(encodeHintType7) && Boolean.parseBoolean(map.get(encodeHintType7).toString())) {
                    z10 = true;
                }
            }
            boolean z11 = z10;
            return c(dVar, str, i13, i10, i11, i12, z11);
        }
        throw new IllegalArgumentException("Can only encode PDF_417, but got " + barcodeFormat);
    }
}
