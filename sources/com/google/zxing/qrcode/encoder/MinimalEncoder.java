package com.google.zxing.qrcode.encoder;

import com.google.android.gms.common.api.a;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.mparticle.kits.AppsFlyerKit;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;

final class MinimalEncoder {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f22123a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final boolean f22124b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final jh.c f22125c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final ErrorCorrectionLevel f22126d;

    private enum VersionSize {
        SMALL("version 1-9"),
        MEDIUM("version 10-26"),
        LARGE("version 27-40");
        
        private final String description;

        private VersionSize(String str) {
            this.description = str;
        }

        public String toString() {
            return this.description;
        }
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22131a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f22132b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|5|6|7|9|10|11|12|13|14|15|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0059 */
        static {
            /*
                com.google.zxing.qrcode.decoder.Mode[] r0 = com.google.zxing.qrcode.decoder.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22132b = r0
                r1 = 1
                com.google.zxing.qrcode.decoder.Mode r2 = com.google.zxing.qrcode.decoder.Mode.KANJI     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f22132b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.zxing.qrcode.decoder.Mode r3 = com.google.zxing.qrcode.decoder.Mode.ALPHANUMERIC     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f22132b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.zxing.qrcode.decoder.Mode r4 = com.google.zxing.qrcode.decoder.Mode.NUMERIC     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f22132b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.zxing.qrcode.decoder.Mode r4 = com.google.zxing.qrcode.decoder.Mode.BYTE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = f22132b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.zxing.qrcode.decoder.Mode r4 = com.google.zxing.qrcode.decoder.Mode.ECI     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                com.google.zxing.qrcode.encoder.MinimalEncoder$VersionSize[] r3 = com.google.zxing.qrcode.encoder.MinimalEncoder.VersionSize.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f22131a = r3
                com.google.zxing.qrcode.encoder.MinimalEncoder$VersionSize r4 = com.google.zxing.qrcode.encoder.MinimalEncoder.VersionSize.SMALL     // Catch:{ NoSuchFieldError -> 0x004f }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r1 = f22131a     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.google.zxing.qrcode.encoder.MinimalEncoder$VersionSize r3 = com.google.zxing.qrcode.encoder.MinimalEncoder.VersionSize.MEDIUM     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = f22131a     // Catch:{ NoSuchFieldError -> 0x0063 }
                com.google.zxing.qrcode.encoder.MinimalEncoder$VersionSize r1 = com.google.zxing.qrcode.encoder.MinimalEncoder.VersionSize.LARGE     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.MinimalEncoder.a.<clinit>():void");
        }
    }

    private final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final Mode f22133a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f22134b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f22135c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final int f22136d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final b f22137e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final int f22138f;

        /* synthetic */ b(MinimalEncoder minimalEncoder, Mode mode, int i10, int i11, int i12, b bVar, rh.a aVar, a aVar2) {
            this(mode, i10, i11, i12, bVar, aVar);
        }

        private b(Mode mode, int i10, int i11, int i12, b bVar, rh.a aVar) {
            this.f22133a = mode;
            this.f22134b = i10;
            Mode mode2 = Mode.BYTE;
            int i13 = (mode == mode2 || bVar == null) ? i11 : bVar.f22135c;
            this.f22135c = i13;
            this.f22136d = i12;
            this.f22137e = bVar;
            boolean z10 = false;
            int i14 = bVar != null ? bVar.f22138f : 0;
            if ((mode == mode2 && bVar == null && i13 != 0) || !(bVar == null || i13 == bVar.f22135c)) {
                z10 = true;
            }
            int i15 = 4;
            i14 = (bVar == null || mode != bVar.f22133a || z10) ? i14 + mode.b(aVar) + 4 : i14;
            int i16 = a.f22132b[mode.ordinal()];
            if (i16 == 1) {
                i14 += 13;
            } else if (i16 == 2) {
                i14 += i12 == 1 ? 6 : 11;
            } else if (i16 == 3) {
                i14 += i12 != 1 ? i12 == 2 ? 7 : 10 : i15;
            } else if (i16 == 4) {
                i14 += MinimalEncoder.this.f22125c.c(MinimalEncoder.this.f22123a.substring(i10, i12 + i10), i11).length * 8;
                if (z10) {
                    i14 += 12;
                }
            }
            this.f22138f = i14;
        }
    }

    final class c {

        /* renamed from: a  reason: collision with root package name */
        private final List<a> f22140a = new ArrayList();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final rh.a f22141b;

        final class a {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public final Mode f22143a;

            /* renamed from: b  reason: collision with root package name */
            private final int f22144b;

            /* renamed from: c  reason: collision with root package name */
            private final int f22145c;

            /* renamed from: d  reason: collision with root package name */
            private final int f22146d;

            a(Mode mode, int i10, int i11, int i12) {
                this.f22143a = mode;
                this.f22144b = i10;
                this.f22145c = i11;
                this.f22146d = i12;
            }

            /* access modifiers changed from: private */
            public void d(jh.a aVar) throws WriterException {
                aVar.c(this.f22143a.a(), 4);
                if (this.f22146d > 0) {
                    aVar.c(e(), this.f22143a.b(c.this.f22141b));
                }
                if (this.f22143a == Mode.ECI) {
                    aVar.c(MinimalEncoder.this.f22125c.e(this.f22145c), 8);
                } else if (this.f22146d > 0) {
                    String b10 = MinimalEncoder.this.f22123a;
                    int i10 = this.f22144b;
                    b.c(b10.substring(i10, this.f22146d + i10), this.f22143a, aVar, MinimalEncoder.this.f22125c.d(this.f22145c));
                }
            }

            private int e() {
                if (this.f22143a != Mode.BYTE) {
                    return this.f22146d;
                }
                jh.c c10 = MinimalEncoder.this.f22125c;
                String b10 = MinimalEncoder.this.f22123a;
                int i10 = this.f22144b;
                return c10.c(b10.substring(i10, this.f22146d + i10), this.f22145c).length;
            }

            /* access modifiers changed from: private */
            public int f(rh.a aVar) {
                int i10 = 4;
                int b10 = this.f22143a.b(aVar) + 4;
                int i11 = a.f22132b[this.f22143a.ordinal()];
                if (i11 != 1) {
                    int i12 = 0;
                    if (i11 == 2) {
                        int i13 = this.f22146d;
                        int i14 = b10 + ((i13 / 2) * 11);
                        if (i13 % 2 == 1) {
                            i12 = 6;
                        }
                        return i14 + i12;
                    } else if (i11 == 3) {
                        int i15 = this.f22146d;
                        b10 += (i15 / 3) * 10;
                        int i16 = i15 % 3;
                        if (i16 != 1) {
                            if (i16 == 2) {
                                i10 = 7;
                            } else {
                                i10 = 0;
                            }
                        }
                    } else if (i11 == 4) {
                        i10 = e() * 8;
                    } else if (i11 != 5) {
                        return b10;
                    } else {
                        return b10 + 8;
                    }
                } else {
                    i10 = this.f22146d * 13;
                }
                return b10 + i10;
            }

            private String g(String str) {
                StringBuilder sb2 = new StringBuilder();
                for (int i10 = 0; i10 < str.length(); i10++) {
                    if (str.charAt(i10) < ' ' || str.charAt(i10) > '~') {
                        sb2.append('.');
                    } else {
                        sb2.append(str.charAt(i10));
                    }
                }
                return sb2.toString();
            }

            public String toString() {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f22143a);
                sb2.append(PropertyUtils.MAPPED_DELIM);
                if (this.f22143a == Mode.ECI) {
                    sb2.append(MinimalEncoder.this.f22125c.d(this.f22145c).displayName());
                } else {
                    String b10 = MinimalEncoder.this.f22123a;
                    int i10 = this.f22144b;
                    sb2.append(g(b10.substring(i10, this.f22146d + i10)));
                }
                sb2.append(PropertyUtils.MAPPED_DELIM2);
                return sb2.toString();
            }
        }

        c(rh.a aVar, b bVar) {
            int i10;
            int i11;
            Mode mode;
            boolean z10;
            int i12 = 0;
            int i13 = 0;
            boolean z11 = false;
            while (true) {
                i10 = 1;
                if (bVar == null) {
                    break;
                }
                int a10 = i13 + bVar.f22136d;
                b e10 = bVar.f22137e;
                if (!(bVar.f22133a == Mode.BYTE && e10 == null && bVar.f22135c != 0) && (e10 == null || bVar.f22135c == e10.f22135c)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                z11 = z10 ? true : z11;
                if (e10 == null || e10.f22133a != bVar.f22133a || z10) {
                    this.f22140a.add(0, new a(bVar.f22133a, bVar.f22134b, bVar.f22135c, a10));
                    a10 = 0;
                }
                if (z10) {
                    this.f22140a.add(0, new a(Mode.ECI, bVar.f22134b, bVar.f22135c, 0));
                }
                bVar = e10;
                i13 = a10;
            }
            if (MinimalEncoder.this.f22124b) {
                a aVar2 = this.f22140a.get(0);
                if (!(aVar2 == null || aVar2.f22143a == (mode = Mode.ECI) || !z11)) {
                    this.f22140a.add(0, new a(mode, 0, 0, 0));
                }
                this.f22140a.add(this.f22140a.get(0).f22143a == Mode.ECI ? 1 : i12, new a(Mode.FNC1_FIRST_POSITION, 0, 0, 0));
            }
            int f10 = aVar.f();
            int i14 = a.f22131a[MinimalEncoder.m(aVar).ordinal()];
            if (i14 == 1) {
                i11 = 9;
            } else if (i14 != 2) {
                i10 = 27;
                i11 = 40;
            } else {
                i10 = 10;
                i11 = 26;
            }
            int d10 = d(aVar);
            while (f10 < i11 && !b.v(d10, rh.a.e(f10), MinimalEncoder.this.f22126d)) {
                f10++;
            }
            while (f10 > i10 && b.v(d10, rh.a.e(f10 - 1), MinimalEncoder.this.f22126d)) {
                f10--;
            }
            this.f22141b = rh.a.e(f10);
        }

        private int d(rh.a aVar) {
            int i10 = 0;
            for (a b10 : this.f22140a) {
                i10 += b10.f(aVar);
            }
            return i10;
        }

        /* access modifiers changed from: package-private */
        public void b(jh.a aVar) throws WriterException {
            for (a c10 : this.f22140a) {
                c10.d(aVar);
            }
        }

        /* access modifiers changed from: package-private */
        public int c() {
            return d(this.f22141b);
        }

        /* access modifiers changed from: package-private */
        public rh.a e() {
            return this.f22141b;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            a aVar = null;
            for (a next : this.f22140a) {
                if (aVar != null) {
                    sb2.append(AppsFlyerKit.COMMA);
                }
                sb2.append(next.toString());
                aVar = next;
            }
            return sb2.toString();
        }
    }

    MinimalEncoder(String str, Charset charset, boolean z10, ErrorCorrectionLevel errorCorrectionLevel) {
        this.f22123a = str;
        this.f22124b = z10;
        this.f22125c = new jh.c(str, charset, -1);
        this.f22126d = errorCorrectionLevel;
    }

    static c h(String str, rh.a aVar, Charset charset, boolean z10, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        return new MinimalEncoder(str, charset, z10, errorCorrectionLevel).i(aVar);
    }

    static int k(Mode mode) {
        int i10;
        if (mode == null || (i10 = a.f22132b[mode.ordinal()]) == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        if (i10 == 4) {
            return 3;
        }
        throw new IllegalStateException("Illegal mode " + mode);
    }

    static rh.a l(VersionSize versionSize) {
        int i10 = a.f22131a[versionSize.ordinal()];
        if (i10 == 1) {
            return rh.a.e(9);
        }
        if (i10 != 2) {
            return rh.a.e(40);
        }
        return rh.a.e(26);
    }

    static VersionSize m(rh.a aVar) {
        return aVar.f() <= 9 ? VersionSize.SMALL : aVar.f() <= 26 ? VersionSize.MEDIUM : VersionSize.LARGE;
    }

    static boolean n(char c10) {
        return b.p(c10) != -1;
    }

    static boolean o(char c10) {
        return b.s(String.valueOf(c10));
    }

    static boolean p(char c10) {
        return c10 >= '0' && c10 <= '9';
    }

    /* access modifiers changed from: package-private */
    public void e(b[][][] bVarArr, int i10, b bVar) {
        b[] bVarArr2 = bVarArr[i10 + bVar.f22136d][bVar.f22135c];
        int k10 = k(bVar.f22133a);
        b bVar2 = bVarArr2[k10];
        if (bVar2 == null || bVar2.f22138f > bVar.f22138f) {
            bVarArr2[k10] = bVar;
        }
    }

    /* access modifiers changed from: package-private */
    public void f(rh.a aVar, b[][][] bVarArr, int i10, b bVar) {
        int i11;
        int i12;
        b[][][] bVarArr2 = bVarArr;
        int i13 = i10;
        int g10 = this.f22125c.g();
        int f10 = this.f22125c.f();
        if (f10 < 0 || !this.f22125c.a(this.f22123a.charAt(i13), f10)) {
            f10 = 0;
        } else {
            g10 = f10 + 1;
        }
        int i14 = g10;
        for (int i15 = f10; i15 < i14; i15++) {
            if (this.f22125c.a(this.f22123a.charAt(i13), i15)) {
                e(bVarArr2, i13, new b(this, Mode.BYTE, i10, i15, 1, bVar, aVar, (a) null));
            }
        }
        Mode mode = Mode.KANJI;
        if (g(mode, this.f22123a.charAt(i13))) {
            e(bVarArr2, i13, new b(this, mode, i10, 0, 1, bVar, aVar, (a) null));
        }
        int length = this.f22123a.length();
        Mode mode2 = Mode.ALPHANUMERIC;
        if (g(mode2, this.f22123a.charAt(i13))) {
            int i16 = i13 + 1;
            if (i16 >= length || !g(mode2, this.f22123a.charAt(i16))) {
                i12 = 1;
            } else {
                i12 = 2;
            }
            e(bVarArr2, i13, new b(this, mode2, i10, 0, i12, bVar, aVar, (a) null));
        }
        Mode mode3 = Mode.NUMERIC;
        if (g(mode3, this.f22123a.charAt(i13))) {
            int i17 = i13 + 1;
            if (i17 >= length || !g(mode3, this.f22123a.charAt(i17))) {
                i11 = 1;
            } else {
                int i18 = i13 + 2;
                if (i18 >= length || !g(mode3, this.f22123a.charAt(i18))) {
                    i11 = 2;
                } else {
                    i11 = 3;
                }
            }
            e(bVarArr2, i13, new b(this, mode3, i10, 0, i11, bVar, aVar, (a) null));
        }
    }

    /* access modifiers changed from: package-private */
    public boolean g(Mode mode, char c10) {
        int i10 = a.f22132b[mode.ordinal()];
        if (i10 == 1) {
            return o(c10);
        }
        if (i10 == 2) {
            return n(c10);
        }
        if (i10 == 3) {
            return p(c10);
        }
        if (i10 != 4) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public c i(rh.a aVar) throws WriterException {
        if (aVar == null) {
            rh.a[] aVarArr = {l(VersionSize.SMALL), l(VersionSize.MEDIUM), l(VersionSize.LARGE)};
            c[] cVarArr = {j(aVarArr[0]), j(aVarArr[1]), j(aVarArr[2])};
            int i10 = a.e.API_PRIORITY_OTHER;
            int i11 = -1;
            for (int i12 = 0; i12 < 3; i12++) {
                int c10 = cVarArr[i12].c();
                if (b.v(c10, aVarArr[i12], this.f22126d) && c10 < i10) {
                    i11 = i12;
                    i10 = c10;
                }
            }
            if (i11 >= 0) {
                return cVarArr[i11];
            }
            throw new WriterException("Data too big for any version");
        }
        c j10 = j(aVar);
        if (b.v(j10.c(), l(m(j10.e())), this.f22126d)) {
            return j10;
        }
        throw new WriterException("Data too big for version" + aVar);
    }

    /* access modifiers changed from: package-private */
    public c j(rh.a aVar) throws WriterException {
        int length = this.f22123a.length();
        int g10 = this.f22125c.g();
        int[] iArr = new int[3];
        iArr[2] = 4;
        iArr[1] = g10;
        iArr[0] = length + 1;
        b[][][] bVarArr = (b[][][]) Array.newInstance(b.class, iArr);
        f(aVar, bVarArr, 0, (b) null);
        for (int i10 = 1; i10 <= length; i10++) {
            for (int i11 = 0; i11 < this.f22125c.g(); i11++) {
                for (int i12 = 0; i12 < 4; i12++) {
                    b bVar = bVarArr[i10][i11][i12];
                    if (bVar != null && i10 < length) {
                        f(aVar, bVarArr, i10, bVar);
                    }
                }
            }
        }
        int i13 = a.e.API_PRIORITY_OTHER;
        int i14 = -1;
        int i15 = -1;
        for (int i16 = 0; i16 < this.f22125c.g(); i16++) {
            for (int i17 = 0; i17 < 4; i17++) {
                b bVar2 = bVarArr[length][i16][i17];
                if (bVar2 != null && bVar2.f22138f < i13) {
                    i13 = bVar2.f22138f;
                    i14 = i16;
                    i15 = i17;
                }
            }
        }
        if (i14 >= 0) {
            return new c(aVar, bVarArr[length][i14][i15]);
        }
        throw new WriterException("Internal error: failed to encode \"" + this.f22123a + "\"");
    }
}
