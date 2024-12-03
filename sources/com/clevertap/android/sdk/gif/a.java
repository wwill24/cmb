package com.clevertap.android.sdk.gif;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.p;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import net.bytebuddy.jar.asm.Opcodes;

class a {

    /* renamed from: y  reason: collision with root package name */
    private static final String f10237y = "a";

    /* renamed from: a  reason: collision with root package name */
    private int[] f10238a;

    /* renamed from: b  reason: collision with root package name */
    private final C0117a f10239b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f10240c;

    /* renamed from: d  reason: collision with root package name */
    private int f10241d;

    /* renamed from: e  reason: collision with root package name */
    private int f10242e;

    /* renamed from: f  reason: collision with root package name */
    private int f10243f;

    /* renamed from: g  reason: collision with root package name */
    private c f10244g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10245h;

    /* renamed from: i  reason: collision with root package name */
    private int f10246i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f10247j;

    /* renamed from: k  reason: collision with root package name */
    private int[] f10248k;

    /* renamed from: l  reason: collision with root package name */
    private d f10249l;

    /* renamed from: m  reason: collision with root package name */
    private final int[] f10250m;

    /* renamed from: n  reason: collision with root package name */
    private byte[] f10251n;

    /* renamed from: o  reason: collision with root package name */
    private short[] f10252o;

    /* renamed from: p  reason: collision with root package name */
    private Bitmap f10253p;

    /* renamed from: q  reason: collision with root package name */
    private ByteBuffer f10254q;

    /* renamed from: r  reason: collision with root package name */
    private int f10255r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f10256s;

    /* renamed from: t  reason: collision with root package name */
    private int f10257t;

    /* renamed from: u  reason: collision with root package name */
    private byte[] f10258u;

    /* renamed from: v  reason: collision with root package name */
    private byte[] f10259v;

    /* renamed from: w  reason: collision with root package name */
    private int f10260w;

    /* renamed from: x  reason: collision with root package name */
    private int f10261x;

    /* renamed from: com.clevertap.android.sdk.gif.a$a  reason: collision with other inner class name */
    interface C0117a {
        byte[] a(int i10);

        @NonNull
        Bitmap b(int i10, int i11, Bitmap.Config config);

        int[] c(int i10);
    }

    a(C0117a aVar) {
        this.f10250m = new int[256];
        this.f10260w = 0;
        this.f10261x = 0;
        this.f10239b = aVar;
        this.f10244g = new c();
    }

    private int b(int i10, int i11, int i12) {
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = i10; i18 < this.f10255r + i10; i18++) {
            byte[] bArr = this.f10247j;
            if (i18 >= bArr.length || i18 >= i11) {
                break;
            }
            int i19 = this.f10238a[bArr[i18] & 255];
            if (i19 != 0) {
                i13 += (i19 >> 24) & 255;
                i14 += (i19 >> 16) & 255;
                i15 += (i19 >> 8) & 255;
                i16 += i19 & 255;
                i17++;
            }
        }
        int i20 = i10 + i12;
        for (int i21 = i20; i21 < this.f10255r + i20; i21++) {
            byte[] bArr2 = this.f10247j;
            if (i21 >= bArr2.length || i21 >= i11) {
                break;
            }
            int i22 = this.f10238a[bArr2[i21] & 255];
            if (i22 != 0) {
                i13 += (i22 >> 24) & 255;
                i14 += (i22 >> 16) & 255;
                i15 += (i22 >> 8) & 255;
                i16 += i22 & 255;
                i17++;
            }
        }
        if (i17 == 0) {
            return 0;
        }
        return ((i13 / i17) << 24) | ((i14 / i17) << 16) | ((i15 / i17) << 8) | (i16 / i17);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v6, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r1v20, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(com.clevertap.android.sdk.gif.b r28) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = 0
            r0.f10261x = r2
            r0.f10260w = r2
            if (r1 == 0) goto L_0x0012
            java.nio.ByteBuffer r3 = r0.f10254q
            int r4 = r1.f10262a
            r3.position(r4)
        L_0x0012:
            if (r1 != 0) goto L_0x001b
            com.clevertap.android.sdk.gif.c r1 = r0.f10244g
            int r3 = r1.f10285m
            int r1 = r1.f10281i
            goto L_0x001f
        L_0x001b:
            int r3 = r1.f10268g
            int r1 = r1.f10269h
        L_0x001f:
            int r3 = r3 * r1
            byte[] r1 = r0.f10247j
            if (r1 == 0) goto L_0x0027
            int r1 = r1.length
            if (r1 >= r3) goto L_0x002f
        L_0x0027:
            com.clevertap.android.sdk.gif.a$a r1 = r0.f10239b
            byte[] r1 = r1.a(r3)
            r0.f10247j = r1
        L_0x002f:
            short[] r1 = r0.f10252o
            r4 = 4096(0x1000, float:5.74E-42)
            if (r1 != 0) goto L_0x0039
            short[] r1 = new short[r4]
            r0.f10252o = r1
        L_0x0039:
            byte[] r1 = r0.f10258u
            if (r1 != 0) goto L_0x0041
            byte[] r1 = new byte[r4]
            r0.f10258u = r1
        L_0x0041:
            byte[] r1 = r0.f10251n
            if (r1 != 0) goto L_0x004b
            r1 = 4097(0x1001, float:5.741E-42)
            byte[] r1 = new byte[r1]
            r0.f10251n = r1
        L_0x004b:
            int r1 = r27.p()
            r5 = 1
            int r6 = r5 << r1
            int r7 = r6 + 1
            int r8 = r6 + 2
            int r1 = r1 + r5
            int r9 = r5 << r1
            int r9 = r9 - r5
            r10 = r2
        L_0x005b:
            if (r10 >= r6) goto L_0x0069
            short[] r11 = r0.f10252o
            r11[r10] = r2
            byte[] r11 = r0.f10258u
            byte r12 = (byte) r10
            r11[r10] = r12
            int r10 = r10 + 1
            goto L_0x005b
        L_0x0069:
            r10 = -1
            r19 = r1
            r11 = r2
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r16 = r15
            r21 = r16
            r22 = r21
            r17 = r8
            r18 = r9
            r20 = r10
        L_0x007d:
            if (r11 >= r3) goto L_0x0177
            r2 = 3
            if (r12 != 0) goto L_0x008d
            int r12 = r27.o()
            if (r12 > 0) goto L_0x008c
            r0.f10257t = r2
            goto L_0x0177
        L_0x008c:
            r13 = 0
        L_0x008d:
            byte[] r4 = r0.f10240c
            byte r4 = r4[r13]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r14
            int r15 = r15 + r4
            int r14 = r14 + 8
            int r13 = r13 + r5
            int r12 = r12 + r10
            r4 = r17
            r5 = r19
            r23 = r20
            r24 = r21
        L_0x00a1:
            if (r14 < r5) goto L_0x0161
            r10 = r15 & r18
            int r15 = r15 >> r5
            int r14 = r14 - r5
            if (r10 != r6) goto L_0x00b1
            r5 = r1
            r4 = r8
            r18 = r9
            r10 = -1
            r23 = -1
            goto L_0x00a1
        L_0x00b1:
            if (r10 <= r4) goto L_0x00b6
            r0.f10257t = r2
            goto L_0x00b8
        L_0x00b6:
            if (r10 != r7) goto L_0x00c6
        L_0x00b8:
            r17 = r4
            r19 = r5
            r20 = r23
            r21 = r24
            r2 = 0
            r4 = 4096(0x1000, float:5.74E-42)
            r5 = 1
            r10 = -1
            goto L_0x007d
        L_0x00c6:
            r19 = r1
            r2 = r23
            r1 = -1
            if (r2 != r1) goto L_0x00e2
            byte[] r2 = r0.f10251n
            int r21 = r22 + 1
            byte[] r1 = r0.f10258u
            byte r1 = r1[r10]
            r2[r22] = r1
            r23 = r10
            r24 = r23
            r1 = r19
            r22 = r21
            r2 = 3
            r10 = -1
            goto L_0x00a1
        L_0x00e2:
            if (r10 < r4) goto L_0x00f3
            byte[] r1 = r0.f10251n
            int r21 = r22 + 1
            r25 = r7
            r7 = r24
            byte r7 = (byte) r7
            r1[r22] = r7
            r1 = r2
            r22 = r21
            goto L_0x00f6
        L_0x00f3:
            r25 = r7
            r1 = r10
        L_0x00f6:
            if (r1 < r6) goto L_0x010d
            byte[] r7 = r0.f10251n
            int r21 = r22 + 1
            r24 = r6
            byte[] r6 = r0.f10258u
            byte r6 = r6[r1]
            r7[r22] = r6
            short[] r6 = r0.f10252o
            short r1 = r6[r1]
            r22 = r21
            r6 = r24
            goto L_0x00f6
        L_0x010d:
            r24 = r6
            byte[] r6 = r0.f10258u
            byte r1 = r6[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte[] r7 = r0.f10251n
            int r21 = r22 + 1
            r26 = r8
            byte r8 = (byte) r1
            r7[r22] = r8
            r7 = 4096(0x1000, float:5.74E-42)
            if (r4 >= r7) goto L_0x013b
            short[] r7 = r0.f10252o
            short r2 = (short) r2
            r7[r4] = r2
            r6[r4] = r8
            int r4 = r4 + 1
            r2 = r4 & r18
            if (r2 != 0) goto L_0x0138
            r2 = 4096(0x1000, float:5.74E-42)
            if (r4 >= r2) goto L_0x013c
            int r5 = r5 + 1
            int r18 = r18 + r4
            goto L_0x013c
        L_0x0138:
            r2 = 4096(0x1000, float:5.74E-42)
            goto L_0x013c
        L_0x013b:
            r2 = r7
        L_0x013c:
            r22 = r21
        L_0x013e:
            if (r22 <= 0) goto L_0x0151
            byte[] r6 = r0.f10247j
            int r7 = r16 + 1
            byte[] r8 = r0.f10251n
            int r22 = r22 + -1
            byte r8 = r8[r22]
            r6[r16] = r8
            int r11 = r11 + 1
            r16 = r7
            goto L_0x013e
        L_0x0151:
            r23 = r10
            r6 = r24
            r7 = r25
            r8 = r26
            r2 = 3
            r10 = -1
            r24 = r1
            r1 = r19
            goto L_0x00a1
        L_0x0161:
            r25 = r7
            r2 = r23
            r7 = r24
            r20 = r2
            r17 = r4
            r19 = r5
            r21 = r7
            r7 = r25
            r2 = 0
            r4 = 4096(0x1000, float:5.74E-42)
            r5 = 1
            goto L_0x007d
        L_0x0177:
            r1 = r16
        L_0x0179:
            if (r1 >= r3) goto L_0x0183
            byte[] r2 = r0.f10247j
            r4 = 0
            r2[r1] = r4
            int r1 = r1 + 1
            goto L_0x0179
        L_0x0183:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.gif.a.c(com.clevertap.android.sdk.gif.b):void");
    }

    private void d(int[] iArr, b bVar, int i10) {
        int i11 = bVar.f10269h;
        int i12 = this.f10255r;
        int i13 = i11 / i12;
        int i14 = bVar.f10267f / i12;
        int i15 = bVar.f10268g / i12;
        int i16 = bVar.f10266e / i12;
        int i17 = this.f10242e;
        int i18 = (i14 * i17) + i16;
        int i19 = (i13 * i17) + i18;
        while (i18 < i19) {
            int i20 = i18 + i15;
            for (int i21 = i18; i21 < i20; i21++) {
                iArr[i21] = i10;
            }
            i18 += this.f10242e;
        }
    }

    private d h() {
        if (this.f10249l == null) {
            this.f10249l = new d();
        }
        return this.f10249l;
    }

    private Bitmap j() {
        Bitmap.Config config;
        if (this.f10245h) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap b10 = this.f10239b.b(this.f10242e, this.f10241d, config);
        s(b10);
        return b10;
    }

    private int o() {
        int p10 = p();
        if (p10 > 0) {
            try {
                if (this.f10240c == null) {
                    this.f10240c = this.f10239b.a(255);
                }
                int i10 = this.f10261x;
                int i11 = this.f10260w;
                int i12 = i10 - i11;
                if (i12 >= p10) {
                    System.arraycopy(this.f10259v, i11, this.f10240c, 0, p10);
                    this.f10260w += p10;
                } else if (this.f10254q.remaining() + i12 >= p10) {
                    System.arraycopy(this.f10259v, this.f10260w, this.f10240c, 0, i12);
                    this.f10260w = this.f10261x;
                    q();
                    int i13 = p10 - i12;
                    System.arraycopy(this.f10259v, 0, this.f10240c, i12, i13);
                    this.f10260w += i13;
                } else {
                    this.f10257t = 1;
                }
            } catch (Exception e10) {
                p.c(f10237y, "Error Reading Block", e10);
                this.f10257t = 1;
            }
        }
        return p10;
    }

    private int p() {
        try {
            q();
            byte[] bArr = this.f10259v;
            int i10 = this.f10260w;
            this.f10260w = i10 + 1;
            return bArr[i10] & 255;
        } catch (Exception unused) {
            this.f10257t = 1;
            return 0;
        }
    }

    private void q() {
        if (this.f10261x <= this.f10260w) {
            if (this.f10259v == null) {
                this.f10259v = this.f10239b.a(Opcodes.ACC_ENUM);
            }
            this.f10260w = 0;
            int min = Math.min(this.f10254q.remaining(), Opcodes.ACC_ENUM);
            this.f10261x = min;
            this.f10254q.get(this.f10259v, 0, min);
        }
    }

    @TargetApi(12)
    private static void s(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        if (r3.f10274b == r1.f10271j) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap x(com.clevertap.android.sdk.gif.b r18, com.clevertap.android.sdk.gif.b r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            int[] r10 = r0.f10248k
            r11 = 0
            if (r2 != 0) goto L_0x000e
            java.util.Arrays.fill(r10, r11)
        L_0x000e:
            r12 = 3
            r13 = 2
            r14 = 1
            if (r2 == 0) goto L_0x005e
            int r3 = r2.f10264c
            if (r3 <= 0) goto L_0x005e
            if (r3 != r13) goto L_0x0037
            boolean r3 = r1.f10272k
            if (r3 != 0) goto L_0x002c
            com.clevertap.android.sdk.gif.c r3 = r0.f10244g
            int r4 = r3.f10273a
            int[] r5 = r1.f10270i
            if (r5 == 0) goto L_0x0033
            int r3 = r3.f10274b
            int r5 = r1.f10271j
            if (r3 != r5) goto L_0x0033
            goto L_0x0032
        L_0x002c:
            int r3 = r0.f10243f
            if (r3 != 0) goto L_0x0032
            r0.f10245h = r14
        L_0x0032:
            r4 = r11
        L_0x0033:
            r0.d(r10, r2, r4)
            goto L_0x005e
        L_0x0037:
            if (r3 != r12) goto L_0x005e
            android.graphics.Bitmap r3 = r0.f10253p
            if (r3 != 0) goto L_0x0041
            r0.d(r10, r2, r11)
            goto L_0x005e
        L_0x0041:
            int r4 = r2.f10269h
            int r5 = r0.f10255r
            int r9 = r4 / r5
            int r4 = r2.f10267f
            int r7 = r4 / r5
            int r4 = r2.f10268g
            int r8 = r4 / r5
            int r2 = r2.f10266e
            int r6 = r2 / r5
            int r5 = r0.f10242e
            int r2 = r7 * r5
            int r4 = r2 + r6
            r2 = r3
            r3 = r10
            r2.getPixels(r3, r4, r5, r6, r7, r8, r9)
        L_0x005e:
            r17.c(r18)
            int r2 = r1.f10269h
            int r3 = r0.f10255r
            int r2 = r2 / r3
            int r4 = r1.f10267f
            int r4 = r4 / r3
            int r5 = r1.f10268g
            int r5 = r5 / r3
            int r6 = r1.f10266e
            int r6 = r6 / r3
            r3 = 8
            int r7 = r0.f10243f
            if (r7 != 0) goto L_0x0077
            r7 = r14
            goto L_0x0078
        L_0x0077:
            r7 = r11
        L_0x0078:
            r8 = r11
            r9 = r14
        L_0x007a:
            if (r11 >= r2) goto L_0x00fa
            boolean r15 = r1.f10265d
            if (r15 == 0) goto L_0x0096
            r15 = 4
            if (r8 < r2) goto L_0x0093
            int r9 = r9 + 1
            if (r9 == r13) goto L_0x0092
            if (r9 == r12) goto L_0x008f
            if (r9 == r15) goto L_0x008c
            goto L_0x0093
        L_0x008c:
            r3 = r13
            r8 = r14
            goto L_0x0093
        L_0x008f:
            r8 = r13
            r3 = r15
            goto L_0x0093
        L_0x0092:
            r8 = r15
        L_0x0093:
            int r15 = r8 + r3
            goto L_0x0098
        L_0x0096:
            r15 = r8
            r8 = r11
        L_0x0098:
            int r8 = r8 + r4
            int r12 = r0.f10241d
            if (r8 >= r12) goto L_0x00eb
            int r12 = r0.f10242e
            int r8 = r8 * r12
            int r16 = r8 + r6
            int r13 = r16 + r5
            int r14 = r8 + r12
            if (r14 >= r13) goto L_0x00aa
            int r13 = r8 + r12
        L_0x00aa:
            int r8 = r0.f10255r
            int r12 = r11 * r8
            int r14 = r1.f10268g
            int r12 = r12 * r14
            int r14 = r13 - r16
            int r14 = r14 * r8
            int r14 = r14 + r12
            r8 = r16
        L_0x00b7:
            if (r8 >= r13) goto L_0x00eb
            r19 = r2
            int r2 = r0.f10255r
            r16 = r3
            r3 = 1
            if (r2 != r3) goto L_0x00cd
            byte[] r2 = r0.f10247j
            byte r2 = r2[r12]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int[] r3 = r0.f10238a
            r2 = r3[r2]
            goto L_0x00d3
        L_0x00cd:
            int r2 = r1.f10268g
            int r2 = r0.b(r12, r14, r2)
        L_0x00d3:
            if (r2 == 0) goto L_0x00d8
            r10[r8] = r2
            goto L_0x00e1
        L_0x00d8:
            boolean r2 = r0.f10245h
            if (r2 != 0) goto L_0x00e1
            if (r7 == 0) goto L_0x00e1
            r2 = 1
            r0.f10245h = r2
        L_0x00e1:
            int r2 = r0.f10255r
            int r12 = r12 + r2
            int r8 = r8 + 1
            r2 = r19
            r3 = r16
            goto L_0x00b7
        L_0x00eb:
            r19 = r2
            r16 = r3
            int r11 = r11 + 1
            r2 = r19
            r8 = r15
            r3 = r16
            r12 = 3
            r13 = 2
            r14 = 1
            goto L_0x007a
        L_0x00fa:
            boolean r2 = r0.f10256s
            if (r2 == 0) goto L_0x011d
            int r1 = r1.f10264c
            if (r1 == 0) goto L_0x0105
            r2 = 1
            if (r1 != r2) goto L_0x011d
        L_0x0105:
            android.graphics.Bitmap r1 = r0.f10253p
            if (r1 != 0) goto L_0x010f
            android.graphics.Bitmap r1 = r17.j()
            r0.f10253p = r1
        L_0x010f:
            android.graphics.Bitmap r1 = r0.f10253p
            r3 = 0
            int r7 = r0.f10242e
            r5 = 0
            r6 = 0
            int r8 = r0.f10241d
            r2 = r10
            r4 = r7
            r1.setPixels(r2, r3, r4, r5, r6, r7, r8)
        L_0x011d:
            android.graphics.Bitmap r9 = r17.j()
            r3 = 0
            int r7 = r0.f10242e
            r5 = 0
            r6 = 0
            int r8 = r0.f10241d
            r1 = r9
            r2 = r10
            r4 = r7
            r1.setPixels(r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.gif.a.x(com.clevertap.android.sdk.gif.b, com.clevertap.android.sdk.gif.b):android.graphics.Bitmap");
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        if (this.f10244g.f10276d <= 0) {
            return false;
        }
        if (this.f10243f == g() - 1) {
            this.f10246i++;
        }
        c cVar = this.f10244g;
        int i10 = cVar.f10282j;
        if (i10 != -1 && this.f10246i > i10) {
            return false;
        }
        this.f10243f = (this.f10243f + 1) % cVar.f10276d;
        return true;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f10243f;
    }

    /* access modifiers changed from: package-private */
    public int f(int i10) {
        if (i10 >= 0) {
            c cVar = this.f10244g;
            if (i10 < cVar.f10276d) {
                return cVar.f10277e.get(i10).f10263b;
            }
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f10244g.f10276d;
    }

    /* access modifiers changed from: package-private */
    public int i() {
        return this.f10244g.f10281i;
    }

    /* access modifiers changed from: package-private */
    public int k() {
        int i10;
        if (this.f10244g.f10276d <= 0 || (i10 = this.f10243f) < 0) {
            return 0;
        }
        return f(i10);
    }

    /* access modifiers changed from: package-private */
    public synchronized Bitmap l() {
        b bVar;
        if (this.f10244g.f10276d <= 0 || this.f10243f < 0) {
            p.b(f10237y, "unable to decode frame, frameCount=" + this.f10244g.f10276d + " framePointer=" + this.f10243f);
            this.f10257t = 1;
        }
        int i10 = this.f10257t;
        if (i10 != 1) {
            if (i10 != 2) {
                this.f10257t = 0;
                b bVar2 = this.f10244g.f10277e.get(this.f10243f);
                int i11 = this.f10243f - 1;
                if (i11 >= 0) {
                    bVar = this.f10244g.f10277e.get(i11);
                } else {
                    bVar = null;
                }
                int[] iArr = bVar2.f10270i;
                if (iArr == null) {
                    iArr = this.f10244g.f10278f;
                }
                this.f10238a = iArr;
                if (iArr == null) {
                    p.b(f10237y, "No Valid Color Table for frame #" + this.f10243f);
                    this.f10257t = 1;
                    return null;
                }
                if (bVar2.f10272k) {
                    System.arraycopy(iArr, 0, this.f10250m, 0, iArr.length);
                    int[] iArr2 = this.f10250m;
                    this.f10238a = iArr2;
                    iArr2[bVar2.f10271j] = 0;
                }
                return x(bVar2, bVar);
            }
        }
        p.b(f10237y, "Unable to decode frame, status=" + this.f10257t);
        return null;
    }

    /* access modifiers changed from: package-private */
    public int m() {
        return this.f10244g.f10285m;
    }

    /* access modifiers changed from: package-private */
    public synchronized int n(byte[] bArr) {
        c b10 = h().p(bArr).b();
        this.f10244g = b10;
        if (bArr != null) {
            v(b10, bArr);
        }
        return this.f10257t;
    }

    /* access modifiers changed from: package-private */
    public void r() {
        this.f10246i = 0;
    }

    /* access modifiers changed from: package-private */
    public synchronized void t(c cVar, ByteBuffer byteBuffer) {
        u(cVar, byteBuffer, 1);
    }

    /* access modifiers changed from: package-private */
    public synchronized void u(c cVar, ByteBuffer byteBuffer, int i10) {
        if (i10 > 0) {
            int highestOneBit = Integer.highestOneBit(i10);
            this.f10257t = 0;
            this.f10244g = cVar;
            this.f10245h = false;
            this.f10243f = -1;
            r();
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f10254q = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f10254q.order(ByteOrder.LITTLE_ENDIAN);
            this.f10256s = false;
            Iterator<b> it = cVar.f10277e.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().f10264c == 3) {
                        this.f10256s = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.f10255r = highestOneBit;
            int i11 = cVar.f10285m;
            this.f10242e = i11 / highestOneBit;
            int i12 = cVar.f10281i;
            this.f10241d = i12 / highestOneBit;
            this.f10247j = this.f10239b.a(i11 * i12);
            this.f10248k = this.f10239b.c(this.f10242e * this.f10241d);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i10);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void v(c cVar, byte[] bArr) {
        t(cVar, ByteBuffer.wrap(bArr));
    }

    /* access modifiers changed from: package-private */
    public boolean w(int i10) {
        if (i10 < -1 || i10 >= g()) {
            return false;
        }
        this.f10243f = i10;
        return true;
    }

    a() {
        this(new e());
    }
}
