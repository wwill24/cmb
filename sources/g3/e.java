package g3;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import g3.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

public class e implements a {

    /* renamed from: u  reason: collision with root package name */
    private static final String f15163u = "e";

    /* renamed from: a  reason: collision with root package name */
    private int[] f15164a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f15165b;

    /* renamed from: c  reason: collision with root package name */
    private final a.C0161a f15166c;

    /* renamed from: d  reason: collision with root package name */
    private ByteBuffer f15167d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f15168e;

    /* renamed from: f  reason: collision with root package name */
    private short[] f15169f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f15170g;

    /* renamed from: h  reason: collision with root package name */
    private byte[] f15171h;

    /* renamed from: i  reason: collision with root package name */
    private byte[] f15172i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f15173j;

    /* renamed from: k  reason: collision with root package name */
    private int f15174k;

    /* renamed from: l  reason: collision with root package name */
    private c f15175l;

    /* renamed from: m  reason: collision with root package name */
    private Bitmap f15176m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f15177n;

    /* renamed from: o  reason: collision with root package name */
    private int f15178o;

    /* renamed from: p  reason: collision with root package name */
    private int f15179p;

    /* renamed from: q  reason: collision with root package name */
    private int f15180q;

    /* renamed from: r  reason: collision with root package name */
    private int f15181r;

    /* renamed from: s  reason: collision with root package name */
    private Boolean f15182s;
    @NonNull

    /* renamed from: t  reason: collision with root package name */
    private Bitmap.Config f15183t;

    public e(@NonNull a.C0161a aVar, c cVar, ByteBuffer byteBuffer, int i10) {
        this(aVar);
        q(cVar, byteBuffer, i10);
    }

    private int i(int i10, int i11, int i12) {
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = i10; i18 < this.f15179p + i10; i18++) {
            byte[] bArr = this.f15172i;
            if (i18 >= bArr.length || i18 >= i11) {
                break;
            }
            int i19 = this.f15164a[bArr[i18] & 255];
            if (i19 != 0) {
                i13 += (i19 >> 24) & 255;
                i14 += (i19 >> 16) & 255;
                i15 += (i19 >> 8) & 255;
                i16 += i19 & 255;
                i17++;
            }
        }
        int i20 = i10 + i12;
        for (int i21 = i20; i21 < this.f15179p + i20; i21++) {
            byte[] bArr2 = this.f15172i;
            if (i21 >= bArr2.length || i21 >= i11) {
                break;
            }
            int i22 = this.f15164a[bArr2[i21] & 255];
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

    private void j(b bVar) {
        boolean z10;
        boolean z11;
        int i10;
        int i11;
        boolean z12;
        int i12;
        int i13;
        int i14;
        b bVar2 = bVar;
        int[] iArr = this.f15173j;
        int i15 = bVar2.f15138d;
        int i16 = this.f15179p;
        int i17 = i15 / i16;
        int i18 = bVar2.f15136b / i16;
        int i19 = bVar2.f15137c / i16;
        int i20 = bVar2.f15135a / i16;
        if (this.f15174k == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i21 = this.f15181r;
        int i22 = this.f15180q;
        byte[] bArr = this.f15172i;
        int[] iArr2 = this.f15164a;
        Boolean bool = this.f15182s;
        int i23 = 8;
        int i24 = 0;
        int i25 = 0;
        int i26 = 1;
        while (i24 < i17) {
            Boolean bool2 = bool;
            if (bVar2.f15139e) {
                if (i25 >= i17) {
                    i10 = i17;
                    int i27 = i26 + 1;
                    if (i27 == 2) {
                        i26 = i27;
                        i25 = 4;
                    } else if (i27 == 3) {
                        i26 = i27;
                        i23 = 4;
                        i25 = 2;
                    } else if (i27 != 4) {
                        i26 = i27;
                    } else {
                        i26 = i27;
                        i25 = 1;
                        i23 = 2;
                    }
                } else {
                    i10 = i17;
                }
                i11 = i25 + i23;
            } else {
                i10 = i17;
                i11 = i25;
                i25 = i24;
            }
            int i28 = i25 + i18;
            if (i16 == 1) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (i28 < i22) {
                int i29 = i28 * i21;
                int i30 = i29 + i20;
                int i31 = i30 + i19;
                int i32 = i29 + i21;
                if (i32 < i31) {
                    i31 = i32;
                }
                i12 = i11;
                int i33 = i24 * i16 * bVar2.f15137c;
                if (z12) {
                    int i34 = i30;
                    while (i34 < i31) {
                        int i35 = i18;
                        int i36 = iArr2[bArr[i33] & 255];
                        if (i36 != 0) {
                            iArr[i34] = i36;
                        } else if (z10 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i33 += i16;
                        i34++;
                        i18 = i35;
                    }
                } else {
                    i14 = i18;
                    int i37 = ((i31 - i30) * i16) + i33;
                    int i38 = i30;
                    while (true) {
                        i13 = i19;
                        if (i38 >= i31) {
                            break;
                        }
                        int i39 = i(i33, i37, bVar2.f15137c);
                        if (i39 != 0) {
                            iArr[i38] = i39;
                        } else if (z10 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i33 += i16;
                        i38++;
                        i19 = i13;
                    }
                    bool = bool2;
                    i24++;
                    i18 = i14;
                    i19 = i13;
                    i17 = i10;
                    i25 = i12;
                }
            } else {
                i12 = i11;
            }
            i14 = i18;
            i13 = i19;
            bool = bool2;
            i24++;
            i18 = i14;
            i19 = i13;
            i17 = i10;
            i25 = i12;
        }
        Boolean bool3 = bool;
        if (this.f15182s == null) {
            if (bool3 == null) {
                z11 = false;
            } else {
                z11 = bool3.booleanValue();
            }
            this.f15182s = Boolean.valueOf(z11);
        }
    }

    private void k(b bVar) {
        boolean z10;
        boolean z11;
        b bVar2 = bVar;
        int[] iArr = this.f15173j;
        int i10 = bVar2.f15138d;
        int i11 = bVar2.f15136b;
        int i12 = bVar2.f15137c;
        int i13 = bVar2.f15135a;
        if (this.f15174k == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i14 = this.f15181r;
        byte[] bArr = this.f15172i;
        int[] iArr2 = this.f15164a;
        int i15 = 0;
        byte b10 = -1;
        while (i15 < i10) {
            int i16 = (i15 + i11) * i14;
            int i17 = i16 + i13;
            int i18 = i17 + i12;
            int i19 = i16 + i14;
            if (i19 < i18) {
                i18 = i19;
            }
            int i20 = bVar2.f15137c * i15;
            int i21 = i17;
            while (i21 < i18) {
                byte b11 = bArr[i20];
                int i22 = i10;
                byte b12 = b11 & 255;
                if (b12 != b10) {
                    int i23 = iArr2[b12];
                    if (i23 != 0) {
                        iArr[i21] = i23;
                    } else {
                        b10 = b11;
                    }
                }
                i20++;
                i21++;
                b bVar3 = bVar;
                i10 = i22;
            }
            int i24 = i10;
            i15++;
            bVar2 = bVar;
        }
        Boolean bool = this.f15182s;
        if ((bool == null || !bool.booleanValue()) && (this.f15182s != null || !z10 || b10 == -1)) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.f15182s = Boolean.valueOf(z11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: byte} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r7v13, types: [short] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void l(g3.b r29) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            if (r1 == 0) goto L_0x000d
            java.nio.ByteBuffer r2 = r0.f15167d
            int r3 = r1.f15144j
            r2.position(r3)
        L_0x000d:
            if (r1 != 0) goto L_0x0016
            g3.c r1 = r0.f15175l
            int r2 = r1.f15151f
            int r1 = r1.f15152g
            goto L_0x001a
        L_0x0016:
            int r2 = r1.f15137c
            int r1 = r1.f15138d
        L_0x001a:
            int r2 = r2 * r1
            byte[] r1 = r0.f15172i
            if (r1 == 0) goto L_0x0022
            int r1 = r1.length
            if (r1 >= r2) goto L_0x002a
        L_0x0022:
            g3.a$a r1 = r0.f15166c
            byte[] r1 = r1.a(r2)
            r0.f15172i = r1
        L_0x002a:
            byte[] r1 = r0.f15172i
            short[] r3 = r0.f15169f
            r4 = 4096(0x1000, float:5.74E-42)
            if (r3 != 0) goto L_0x0036
            short[] r3 = new short[r4]
            r0.f15169f = r3
        L_0x0036:
            short[] r3 = r0.f15169f
            byte[] r5 = r0.f15170g
            if (r5 != 0) goto L_0x0040
            byte[] r5 = new byte[r4]
            r0.f15170g = r5
        L_0x0040:
            byte[] r5 = r0.f15170g
            byte[] r6 = r0.f15171h
            if (r6 != 0) goto L_0x004c
            r6 = 4097(0x1001, float:5.741E-42)
            byte[] r6 = new byte[r6]
            r0.f15171h = r6
        L_0x004c:
            byte[] r6 = r0.f15171h
            int r7 = r28.p()
            r8 = 1
            int r9 = r8 << r7
            int r10 = r9 + 1
            int r11 = r9 + 2
            int r7 = r7 + r8
            int r12 = r8 << r7
            int r12 = r12 - r8
            r13 = 0
            r14 = r13
        L_0x005f:
            if (r14 >= r9) goto L_0x0069
            r3[r14] = r13
            byte r15 = (byte) r14
            r5[r14] = r15
            int r14 = r14 + 1
            goto L_0x005f
        L_0x0069:
            byte[] r14 = r0.f15168e
            r15 = -1
            r23 = r7
            r21 = r11
            r22 = r12
            r16 = r13
            r17 = r16
            r18 = r17
            r19 = r18
            r20 = r19
            r25 = r20
            r26 = r25
            r24 = r15
        L_0x0082:
            if (r13 >= r2) goto L_0x014b
            if (r16 != 0) goto L_0x0093
            int r16 = r28.o()
            if (r16 > 0) goto L_0x0091
            r3 = 3
            r0.f15178o = r3
            goto L_0x014b
        L_0x0091:
            r17 = 0
        L_0x0093:
            byte r4 = r14[r17]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r18
            int r19 = r19 + r4
            int r18 = r18 + 8
            int r17 = r17 + 1
            int r16 = r16 + -1
            r4 = r18
            r8 = r21
            r15 = r23
            r0 = r24
            r23 = r7
            r7 = r25
        L_0x00ad:
            if (r4 < r15) goto L_0x0135
            r24 = r11
            r11 = r19 & r22
            int r19 = r19 >> r15
            int r4 = r4 - r15
            if (r11 != r9) goto L_0x00c1
            r22 = r12
            r15 = r23
            r8 = r24
            r11 = r8
            r0 = -1
            goto L_0x00ad
        L_0x00c1:
            if (r11 != r10) goto L_0x00d8
            r18 = r4
            r25 = r7
            r21 = r8
            r7 = r23
            r11 = r24
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r24 = r0
            r23 = r15
            r15 = -1
            r0 = r28
            goto L_0x0082
        L_0x00d8:
            r25 = r4
            r4 = -1
            if (r0 != r4) goto L_0x00ec
            byte r0 = r5[r11]
            r1[r20] = r0
            int r20 = r20 + 1
            int r13 = r13 + 1
            r0 = r11
            r7 = r0
            r11 = r24
            r4 = r25
            goto L_0x00ad
        L_0x00ec:
            if (r11 < r8) goto L_0x00f5
            byte r7 = (byte) r7
            r6[r26] = r7
            int r26 = r26 + 1
            r7 = r0
            goto L_0x00f6
        L_0x00f5:
            r7 = r11
        L_0x00f6:
            if (r7 < r9) goto L_0x0101
            byte r21 = r5[r7]
            r6[r26] = r21
            int r26 = r26 + 1
            short r7 = r3[r7]
            goto L_0x00f6
        L_0x0101:
            byte r7 = r5[r7]
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r7
            r1[r20] = r4
        L_0x0108:
            int r20 = r20 + 1
            int r13 = r13 + 1
            if (r26 <= 0) goto L_0x0115
            int r26 = r26 + -1
            byte r27 = r6[r26]
            r1[r20] = r27
            goto L_0x0108
        L_0x0115:
            r27 = r6
            r6 = 4096(0x1000, float:5.74E-42)
            if (r8 >= r6) goto L_0x012c
            short r0 = (short) r0
            r3[r8] = r0
            r5[r8] = r4
            int r8 = r8 + 1
            r0 = r8 & r22
            if (r0 != 0) goto L_0x012c
            if (r8 >= r6) goto L_0x012c
            int r15 = r15 + 1
            int r22 = r22 + r8
        L_0x012c:
            r0 = r11
            r11 = r24
            r4 = r25
            r6 = r27
            goto L_0x00ad
        L_0x0135:
            r25 = r4
            r24 = r0
            r21 = r8
            r18 = r25
            r4 = 4096(0x1000, float:5.74E-42)
            r8 = 1
            r0 = r28
            r25 = r7
            r7 = r23
            r23 = r15
            r15 = -1
            goto L_0x0082
        L_0x014b:
            r13 = r20
            r0 = 0
            java.util.Arrays.fill(r1, r13, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.e.l(g3.b):void");
    }

    private Bitmap n() {
        Bitmap.Config config;
        Boolean bool = this.f15182s;
        if (bool == null || bool.booleanValue()) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = this.f15183t;
        }
        Bitmap b10 = this.f15166c.b(this.f15181r, this.f15180q, config);
        b10.setHasAlpha(true);
        return b10;
    }

    private int o() {
        int p10 = p();
        if (p10 <= 0) {
            return p10;
        }
        ByteBuffer byteBuffer = this.f15167d;
        byteBuffer.get(this.f15168e, 0, Math.min(p10, byteBuffer.remaining()));
        return p10;
    }

    private int p() {
        return this.f15167d.get() & 255;
    }

    private Bitmap r(b bVar, b bVar2) {
        int i10;
        int i11;
        Bitmap bitmap;
        int[] iArr = this.f15173j;
        int i12 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.f15176m;
            if (bitmap2 != null) {
                this.f15166c.d(bitmap2);
            }
            this.f15176m = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.f15141g == 3 && this.f15176m == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i11 = bVar2.f15141g) > 0) {
            if (i11 == 2) {
                if (!bVar.f15140f) {
                    c cVar = this.f15175l;
                    int i13 = cVar.f15157l;
                    if (bVar.f15145k == null || cVar.f15155j != bVar.f15142h) {
                        i12 = i13;
                    }
                }
                int i14 = bVar2.f15138d;
                int i15 = this.f15179p;
                int i16 = i14 / i15;
                int i17 = bVar2.f15136b / i15;
                int i18 = bVar2.f15137c / i15;
                int i19 = bVar2.f15135a / i15;
                int i20 = this.f15181r;
                int i21 = (i17 * i20) + i19;
                int i22 = (i16 * i20) + i21;
                while (i21 < i22) {
                    int i23 = i21 + i18;
                    for (int i24 = i21; i24 < i23; i24++) {
                        iArr[i24] = i12;
                    }
                    i21 += this.f15181r;
                }
            } else if (i11 == 3 && (bitmap = this.f15176m) != null) {
                int i25 = this.f15181r;
                bitmap.getPixels(iArr, 0, i25, 0, 0, i25, this.f15180q);
            }
        }
        l(bVar);
        if (bVar.f15139e || this.f15179p != 1) {
            j(bVar);
        } else {
            k(bVar);
        }
        if (this.f15177n && ((i10 = bVar.f15141g) == 0 || i10 == 1)) {
            if (this.f15176m == null) {
                this.f15176m = n();
            }
            Bitmap bitmap3 = this.f15176m;
            int i26 = this.f15181r;
            bitmap3.setPixels(iArr, 0, i26, 0, 0, i26, this.f15180q);
        }
        Bitmap n10 = n();
        int i27 = this.f15181r;
        n10.setPixels(iArr, 0, i27, 0, 0, i27, this.f15180q);
        return n10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ce, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap a() {
        /*
            r8 = this;
            monitor-enter(r8)
            g3.c r0 = r8.f15175l     // Catch:{ all -> 0x00cf }
            int r0 = r0.f15148c     // Catch:{ all -> 0x00cf }
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L_0x000d
            int r0 = r8.f15174k     // Catch:{ all -> 0x00cf }
            if (r0 >= 0) goto L_0x0032
        L_0x000d:
            java.lang.String r0 = f15163u     // Catch:{ all -> 0x00cf }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00cf }
            if (r0 == 0) goto L_0x0030
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cf }
            r0.<init>()     // Catch:{ all -> 0x00cf }
            java.lang.String r3 = "Unable to decode frame, frameCount="
            r0.append(r3)     // Catch:{ all -> 0x00cf }
            g3.c r3 = r8.f15175l     // Catch:{ all -> 0x00cf }
            int r3 = r3.f15148c     // Catch:{ all -> 0x00cf }
            r0.append(r3)     // Catch:{ all -> 0x00cf }
            java.lang.String r3 = ", framePointer="
            r0.append(r3)     // Catch:{ all -> 0x00cf }
            int r3 = r8.f15174k     // Catch:{ all -> 0x00cf }
            r0.append(r3)     // Catch:{ all -> 0x00cf }
        L_0x0030:
            r8.f15178o = r2     // Catch:{ all -> 0x00cf }
        L_0x0032:
            int r0 = r8.f15178o     // Catch:{ all -> 0x00cf }
            r3 = 0
            if (r0 == r2) goto L_0x00b6
            r4 = 2
            if (r0 != r4) goto L_0x003c
            goto L_0x00b6
        L_0x003c:
            r0 = 0
            r8.f15178o = r0     // Catch:{ all -> 0x00cf }
            byte[] r5 = r8.f15168e     // Catch:{ all -> 0x00cf }
            if (r5 != 0) goto L_0x004d
            g3.a$a r5 = r8.f15166c     // Catch:{ all -> 0x00cf }
            r6 = 255(0xff, float:3.57E-43)
            byte[] r5 = r5.a(r6)     // Catch:{ all -> 0x00cf }
            r8.f15168e = r5     // Catch:{ all -> 0x00cf }
        L_0x004d:
            g3.c r5 = r8.f15175l     // Catch:{ all -> 0x00cf }
            java.util.List<g3.b> r5 = r5.f15150e     // Catch:{ all -> 0x00cf }
            int r6 = r8.f15174k     // Catch:{ all -> 0x00cf }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x00cf }
            g3.b r5 = (g3.b) r5     // Catch:{ all -> 0x00cf }
            int r6 = r8.f15174k     // Catch:{ all -> 0x00cf }
            int r6 = r6 - r2
            if (r6 < 0) goto L_0x0069
            g3.c r7 = r8.f15175l     // Catch:{ all -> 0x00cf }
            java.util.List<g3.b> r7 = r7.f15150e     // Catch:{ all -> 0x00cf }
            java.lang.Object r6 = r7.get(r6)     // Catch:{ all -> 0x00cf }
            g3.b r6 = (g3.b) r6     // Catch:{ all -> 0x00cf }
            goto L_0x006a
        L_0x0069:
            r6 = r3
        L_0x006a:
            int[] r7 = r5.f15145k     // Catch:{ all -> 0x00cf }
            if (r7 == 0) goto L_0x006f
            goto L_0x0073
        L_0x006f:
            g3.c r7 = r8.f15175l     // Catch:{ all -> 0x00cf }
            int[] r7 = r7.f15146a     // Catch:{ all -> 0x00cf }
        L_0x0073:
            r8.f15164a = r7     // Catch:{ all -> 0x00cf }
            if (r7 != 0) goto L_0x0092
            java.lang.String r0 = f15163u     // Catch:{ all -> 0x00cf }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00cf }
            if (r0 == 0) goto L_0x008e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cf }
            r0.<init>()     // Catch:{ all -> 0x00cf }
            java.lang.String r1 = "No valid color table found for frame #"
            r0.append(r1)     // Catch:{ all -> 0x00cf }
            int r1 = r8.f15174k     // Catch:{ all -> 0x00cf }
            r0.append(r1)     // Catch:{ all -> 0x00cf }
        L_0x008e:
            r8.f15178o = r2     // Catch:{ all -> 0x00cf }
            monitor-exit(r8)
            return r3
        L_0x0092:
            boolean r1 = r5.f15140f     // Catch:{ all -> 0x00cf }
            if (r1 == 0) goto L_0x00b0
            int[] r1 = r8.f15165b     // Catch:{ all -> 0x00cf }
            int r2 = r7.length     // Catch:{ all -> 0x00cf }
            java.lang.System.arraycopy(r7, r0, r1, r0, r2)     // Catch:{ all -> 0x00cf }
            int[] r1 = r8.f15165b     // Catch:{ all -> 0x00cf }
            r8.f15164a = r1     // Catch:{ all -> 0x00cf }
            int r2 = r5.f15142h     // Catch:{ all -> 0x00cf }
            r1[r2] = r0     // Catch:{ all -> 0x00cf }
            int r0 = r5.f15141g     // Catch:{ all -> 0x00cf }
            if (r0 != r4) goto L_0x00b0
            int r0 = r8.f15174k     // Catch:{ all -> 0x00cf }
            if (r0 != 0) goto L_0x00b0
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00cf }
            r8.f15182s = r0     // Catch:{ all -> 0x00cf }
        L_0x00b0:
            android.graphics.Bitmap r0 = r8.r(r5, r6)     // Catch:{ all -> 0x00cf }
            monitor-exit(r8)
            return r0
        L_0x00b6:
            java.lang.String r0 = f15163u     // Catch:{ all -> 0x00cf }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00cf }
            if (r0 == 0) goto L_0x00cd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cf }
            r0.<init>()     // Catch:{ all -> 0x00cf }
            java.lang.String r1 = "Unable to decode frame, status="
            r0.append(r1)     // Catch:{ all -> 0x00cf }
            int r1 = r8.f15178o     // Catch:{ all -> 0x00cf }
            r0.append(r1)     // Catch:{ all -> 0x00cf }
        L_0x00cd:
            monitor-exit(r8)
            return r3
        L_0x00cf:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.e.a():android.graphics.Bitmap");
    }

    public void b() {
        this.f15174k = (this.f15174k + 1) % this.f15175l.f15148c;
    }

    public int c() {
        return this.f15175l.f15148c;
    }

    public void clear() {
        this.f15175l = null;
        byte[] bArr = this.f15172i;
        if (bArr != null) {
            this.f15166c.e(bArr);
        }
        int[] iArr = this.f15173j;
        if (iArr != null) {
            this.f15166c.f(iArr);
        }
        Bitmap bitmap = this.f15176m;
        if (bitmap != null) {
            this.f15166c.d(bitmap);
        }
        this.f15176m = null;
        this.f15167d = null;
        this.f15182s = null;
        byte[] bArr2 = this.f15168e;
        if (bArr2 != null) {
            this.f15166c.e(bArr2);
        }
    }

    public void d(@NonNull Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.f15183t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    public int e() {
        int i10;
        if (this.f15175l.f15148c <= 0 || (i10 = this.f15174k) < 0) {
            return 0;
        }
        return m(i10);
    }

    public void f() {
        this.f15174k = -1;
    }

    public int g() {
        return this.f15174k;
    }

    @NonNull
    public ByteBuffer getData() {
        return this.f15167d;
    }

    public int h() {
        return this.f15167d.limit() + this.f15172i.length + (this.f15173j.length * 4);
    }

    public int m(int i10) {
        if (i10 >= 0) {
            c cVar = this.f15175l;
            if (i10 < cVar.f15148c) {
                return cVar.f15150e.get(i10).f15143i;
            }
        }
        return -1;
    }

    public synchronized void q(@NonNull c cVar, @NonNull ByteBuffer byteBuffer, int i10) {
        if (i10 > 0) {
            int highestOneBit = Integer.highestOneBit(i10);
            this.f15178o = 0;
            this.f15175l = cVar;
            this.f15174k = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f15167d = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f15167d.order(ByteOrder.LITTLE_ENDIAN);
            this.f15177n = false;
            Iterator<b> it = cVar.f15150e.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().f15141g == 3) {
                        this.f15177n = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.f15179p = highestOneBit;
            int i11 = cVar.f15151f;
            this.f15181r = i11 / highestOneBit;
            int i12 = cVar.f15152g;
            this.f15180q = i12 / highestOneBit;
            this.f15172i = this.f15166c.a(i11 * i12);
            this.f15173j = this.f15166c.c(this.f15181r * this.f15180q);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i10);
        }
    }

    public e(@NonNull a.C0161a aVar) {
        this.f15165b = new int[256];
        this.f15183t = Bitmap.Config.ARGB_8888;
        this.f15166c = aVar;
        this.f15175l = new c();
    }
}
