package ih;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import net.bytebuddy.jar.asm.Opcodes;

public final class d {

    /* renamed from: c  reason: collision with root package name */
    static final String[] f23559c = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* renamed from: d  reason: collision with root package name */
    static final int[][] f23560d = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* renamed from: e  reason: collision with root package name */
    private static final int[][] f23561e;

    /* renamed from: f  reason: collision with root package name */
    static final int[][] f23562f;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f23563a;

    /* renamed from: b  reason: collision with root package name */
    private final Charset f23564b;

    class a implements Comparator<f> {
        a() {
        }

        /* renamed from: a */
        public int compare(f fVar, f fVar2) {
            return fVar.f() - fVar2.f();
        }
    }

    static {
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{5, 256});
        f23561e = iArr;
        iArr[0][32] = 1;
        for (int i10 = 65; i10 <= 90; i10++) {
            f23561e[0][i10] = (i10 - 65) + 2;
        }
        f23561e[1][32] = 1;
        for (int i11 = 97; i11 <= 122; i11++) {
            f23561e[1][i11] = (i11 - 97) + 2;
        }
        f23561e[2][32] = 1;
        for (int i12 = 48; i12 <= 57; i12++) {
            f23561e[2][i12] = (i12 - 48) + 2;
        }
        int[] iArr2 = f23561e[2];
        iArr2[44] = 12;
        iArr2[46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, Opcodes.LAND};
        for (int i13 = 0; i13 < 28; i13++) {
            f23561e[3][iArr3[i13]] = i13;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i14 = 0; i14 < 31; i14++) {
            int i15 = iArr4[i14];
            if (i15 > 0) {
                f23561e[4][i15] = i14;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{6, 6});
        f23562f = iArr5;
        for (int[] fill : iArr5) {
            Arrays.fill(fill, -1);
        }
        int[][] iArr6 = f23562f;
        iArr6[0][4] = 0;
        int[] iArr7 = iArr6[1];
        iArr7[4] = 0;
        iArr7[0] = 28;
        iArr6[3][4] = 0;
        int[] iArr8 = iArr6[2];
        iArr8[4] = 0;
        iArr8[0] = 15;
    }

    public d(byte[] bArr, Charset charset) {
        this.f23563a = bArr;
        this.f23564b = charset;
    }

    private static Collection<f> b(Iterable<f> iterable) {
        LinkedList linkedList = new LinkedList();
        for (f next : iterable) {
            boolean z10 = true;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f fVar = (f) it.next();
                if (fVar.h(next)) {
                    z10 = false;
                    break;
                } else if (next.h(fVar)) {
                    it.remove();
                }
            }
            if (z10) {
                linkedList.addFirst(next);
            }
        }
        return linkedList;
    }

    private void c(f fVar, int i10, Collection<f> collection) {
        boolean z10;
        char c10 = (char) (this.f23563a[i10] & 255);
        if (f23561e[fVar.g()][c10] > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        f fVar2 = null;
        for (int i11 = 0; i11 <= 4; i11++) {
            int i12 = f23561e[i11][c10];
            if (i12 > 0) {
                if (fVar2 == null) {
                    fVar2 = fVar.d(i10);
                }
                if (!z10 || i11 == fVar.g() || i11 == 2) {
                    collection.add(fVar2.i(i11, i12));
                }
                if (!z10 && f23562f[fVar.g()][i11] >= 0) {
                    collection.add(fVar2.j(i11, i12));
                }
            }
        }
        if (fVar.e() > 0 || f23561e[fVar.g()][c10] == 0) {
            collection.add(fVar.a(i10));
        }
    }

    private static void d(f fVar, int i10, int i11, Collection<f> collection) {
        f d10 = fVar.d(i10);
        collection.add(d10.i(4, i11));
        if (fVar.g() != 4) {
            collection.add(d10.j(4, i11));
        }
        if (i11 == 3 || i11 == 4) {
            collection.add(d10.i(2, 16 - i11).i(2, 1));
        }
        if (fVar.e() > 0) {
            collection.add(fVar.a(i10).a(i10 + 1));
        }
    }

    private Collection<f> e(Iterable<f> iterable, int i10) {
        LinkedList linkedList = new LinkedList();
        for (f c10 : iterable) {
            c(c10, i10, linkedList);
        }
        return b(linkedList);
    }

    private static Collection<f> f(Iterable<f> iterable, int i10, int i11) {
        LinkedList linkedList = new LinkedList();
        for (f d10 : iterable) {
            d(d10, i10, i11, linkedList);
        }
        return b(linkedList);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public jh.a a() {
        /*
            r8 = this;
            ih.f r0 = ih.f.f23568f
            java.nio.charset.Charset r1 = r8.f23564b
            if (r1 == 0) goto L_0x002e
            com.google.zxing.common.CharacterSetECI r1 = com.google.zxing.common.CharacterSetECI.a(r1)
            if (r1 == 0) goto L_0x0015
            int r1 = r1.c()
            ih.f r0 = r0.b(r1)
            goto L_0x002e
        L_0x0015:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "No ECI code for character set "
            r1.append(r2)
            java.nio.charset.Charset r2 = r8.f23564b
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x002e:
            java.util.List r0 = java.util.Collections.singletonList(r0)
            r1 = 0
            r2 = r1
        L_0x0034:
            byte[] r3 = r8.f23563a
            int r4 = r3.length
            if (r2 >= r4) goto L_0x0078
            int r4 = r2 + 1
            int r5 = r3.length
            if (r4 >= r5) goto L_0x0041
            byte r5 = r3[r4]
            goto L_0x0042
        L_0x0041:
            r5 = r1
        L_0x0042:
            byte r3 = r3[r2]
            r6 = 13
            if (r3 == r6) goto L_0x0064
            r6 = 44
            r7 = 32
            if (r3 == r6) goto L_0x0060
            r6 = 46
            if (r3 == r6) goto L_0x005c
            r6 = 58
            if (r3 == r6) goto L_0x0058
        L_0x0056:
            r3 = r1
            goto L_0x0069
        L_0x0058:
            if (r5 != r7) goto L_0x0056
            r3 = 5
            goto L_0x0069
        L_0x005c:
            if (r5 != r7) goto L_0x0056
            r3 = 3
            goto L_0x0069
        L_0x0060:
            if (r5 != r7) goto L_0x0056
            r3 = 4
            goto L_0x0069
        L_0x0064:
            r3 = 10
            if (r5 != r3) goto L_0x0056
            r3 = 2
        L_0x0069:
            if (r3 <= 0) goto L_0x0071
            java.util.Collection r0 = f(r0, r2, r3)
            r2 = r4
            goto L_0x0075
        L_0x0071:
            java.util.Collection r0 = r8.e(r0, r2)
        L_0x0075:
            int r2 = r2 + 1
            goto L_0x0034
        L_0x0078:
            ih.d$a r1 = new ih.d$a
            r1.<init>()
            java.lang.Object r0 = java.util.Collections.min(r0, r1)
            ih.f r0 = (ih.f) r0
            byte[] r1 = r8.f23563a
            jh.a r0 = r0.k(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ih.d.a():jh.a");
    }
}
