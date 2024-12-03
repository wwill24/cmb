package lh;

import gh.c;
import jh.b;
import mh.d;

public final class a implements c {
    private static b b(sh.a aVar, int i10, int i11) {
        b bVar;
        int e10 = aVar.e();
        int d10 = aVar.d();
        int max = Math.max(i10, e10);
        int max2 = Math.max(i11, d10);
        int min = Math.min(max / e10, max2 / d10);
        int i12 = (max - (e10 * min)) / 2;
        int i13 = (max2 - (d10 * min)) / 2;
        if (i11 < d10 || i10 < e10) {
            bVar = new b(e10, d10);
            i12 = 0;
            i13 = 0;
        } else {
            bVar = new b(i10, i11);
        }
        bVar.b();
        int i14 = 0;
        while (i14 < d10) {
            int i15 = i12;
            int i16 = 0;
            while (i16 < e10) {
                if (aVar.b(i16, i14) == 1) {
                    bVar.j(i15, i13, min, min);
                }
                i16++;
                i15 += min;
            }
            i14++;
            i13 += min;
        }
        return bVar;
    }

    private static b c(mh.b bVar, d dVar, int i10, int i11) {
        boolean z10;
        boolean z11;
        int h10 = dVar.h();
        int g10 = dVar.g();
        sh.a aVar = new sh.a(dVar.j(), dVar.i());
        int i12 = 0;
        for (int i13 = 0; i13 < g10; i13++) {
            if (i13 % dVar.f23792e == 0) {
                int i14 = 0;
                for (int i15 = 0; i15 < dVar.j(); i15++) {
                    if (i15 % 2 == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    aVar.g(i14, i12, z11);
                    i14++;
                }
                i12++;
            }
            int i16 = 0;
            for (int i17 = 0; i17 < h10; i17++) {
                if (i17 % dVar.f23791d == 0) {
                    aVar.g(i16, i12, true);
                    i16++;
                }
                aVar.g(i16, i12, bVar.e(i17, i13));
                i16++;
                int i18 = dVar.f23791d;
                if (i17 % i18 == i18 - 1) {
                    if (i13 % 2 == 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    aVar.g(i16, i12, z10);
                    i16++;
                }
            }
            i12++;
            int i19 = dVar.f23792e;
            if (i13 % i19 == i19 - 1) {
                int i20 = 0;
                for (int i21 = 0; i21 < dVar.j(); i21++) {
                    aVar.g(i20, i12, true);
                    i20++;
                }
                i12++;
            }
        }
        return b(aVar, i10, i11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public jh.b a(java.lang.String r8, com.google.zxing.BarcodeFormat r9, int r10, int r11, java.util.Map<com.google.zxing.EncodeHintType, ?> r12) {
        /*
            r7 = this;
            boolean r0 = r8.isEmpty()
            if (r0 != 0) goto L_0x0102
            com.google.zxing.BarcodeFormat r0 = com.google.zxing.BarcodeFormat.DATA_MATRIX
            if (r9 != r0) goto L_0x00eb
            if (r10 < 0) goto L_0x00cc
            if (r11 < 0) goto L_0x00cc
            com.google.zxing.datamatrix.encoder.SymbolShapeHint r9 = com.google.zxing.datamatrix.encoder.SymbolShapeHint.FORCE_NONE
            r0 = 0
            if (r12 == 0) goto L_0x0037
            com.google.zxing.EncodeHintType r1 = com.google.zxing.EncodeHintType.DATA_MATRIX_SHAPE
            java.lang.Object r1 = r12.get(r1)
            com.google.zxing.datamatrix.encoder.SymbolShapeHint r1 = (com.google.zxing.datamatrix.encoder.SymbolShapeHint) r1
            if (r1 == 0) goto L_0x001e
            r9 = r1
        L_0x001e:
            com.google.zxing.EncodeHintType r1 = com.google.zxing.EncodeHintType.MIN_SIZE
            java.lang.Object r1 = r12.get(r1)
            gh.a r1 = (gh.a) r1
            if (r1 == 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r1 = r0
        L_0x002a:
            com.google.zxing.EncodeHintType r2 = com.google.zxing.EncodeHintType.MAX_SIZE
            java.lang.Object r2 = r12.get(r2)
            gh.a r2 = (gh.a) r2
            if (r2 == 0) goto L_0x0035
            goto L_0x0039
        L_0x0035:
            r2 = r0
            goto L_0x0039
        L_0x0037:
            r1 = r0
            r2 = r1
        L_0x0039:
            r3 = 0
            r4 = 1
            if (r12 == 0) goto L_0x0055
            com.google.zxing.EncodeHintType r5 = com.google.zxing.EncodeHintType.DATA_MATRIX_COMPACT
            boolean r6 = r12.containsKey(r5)
            if (r6 == 0) goto L_0x0055
            java.lang.Object r5 = r12.get(r5)
            java.lang.String r5 = r5.toString()
            boolean r5 = java.lang.Boolean.parseBoolean(r5)
            if (r5 == 0) goto L_0x0055
            r5 = r4
            goto L_0x0056
        L_0x0055:
            r5 = r3
        L_0x0056:
            if (r5 == 0) goto L_0x008e
            com.google.zxing.EncodeHintType r5 = com.google.zxing.EncodeHintType.GS1_FORMAT
            boolean r6 = r12.containsKey(r5)
            if (r6 == 0) goto L_0x006f
            java.lang.Object r5 = r12.get(r5)
            java.lang.String r5 = r5.toString()
            boolean r5 = java.lang.Boolean.parseBoolean(r5)
            if (r5 == 0) goto L_0x006f
            r3 = r4
        L_0x006f:
            com.google.zxing.EncodeHintType r5 = com.google.zxing.EncodeHintType.CHARACTER_SET
            boolean r6 = r12.containsKey(r5)
            if (r6 == 0) goto L_0x0083
            java.lang.Object r12 = r12.get(r5)
            java.lang.String r12 = r12.toString()
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r12)
        L_0x0083:
            if (r3 == 0) goto L_0x0088
            r12 = 29
            goto L_0x0089
        L_0x0088:
            r12 = -1
        L_0x0089:
            java.lang.String r8 = com.google.zxing.datamatrix.encoder.MinimalEncoder.h(r8, r0, r12, r9)
            goto L_0x00ab
        L_0x008e:
            if (r12 == 0) goto L_0x00a7
            com.google.zxing.EncodeHintType r0 = com.google.zxing.EncodeHintType.FORCE_C40
            boolean r5 = r12.containsKey(r0)
            if (r5 == 0) goto L_0x00a7
            java.lang.Object r12 = r12.get(r0)
            java.lang.String r12 = r12.toString()
            boolean r12 = java.lang.Boolean.parseBoolean(r12)
            if (r12 == 0) goto L_0x00a7
            r3 = r4
        L_0x00a7:
            java.lang.String r8 = com.google.zxing.datamatrix.encoder.g.b(r8, r9, r1, r2, r3)
        L_0x00ab:
            int r12 = r8.length()
            mh.d r9 = mh.d.l(r12, r9, r1, r2, r4)
            java.lang.String r8 = mh.c.b(r8, r9)
            mh.b r12 = new mh.b
            int r0 = r9.h()
            int r1 = r9.g()
            r12.<init>(r8, r0, r1)
            r12.h()
            jh.b r8 = c(r12, r9, r10, r11)
            return r8
        L_0x00cc:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r12 = "Requested dimensions can't be negative: "
            r9.append(r12)
            r9.append(r10)
            r10 = 120(0x78, float:1.68E-43)
            r9.append(r10)
            r9.append(r11)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x00eb:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Can only encode DATA_MATRIX, but got "
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        L_0x0102:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Found empty contents"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: lh.a.a(java.lang.String, com.google.zxing.BarcodeFormat, int, int, java.util.Map):jh.b");
    }
}
