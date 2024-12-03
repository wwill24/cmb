package com.google.zxing.datamatrix.encoder;

import com.google.android.gms.common.api.a;
import com.leanplum.messagetemplates.MessageTemplateConstants;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import jh.e;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;
import org.apache.commons.beanutils.PropertyUtils;

public final class MinimalEncoder {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f22045a = {'!', '\"', '#', '$', '%', '&', '\'', PropertyUtils.MAPPED_DELIM, PropertyUtils.MAPPED_DELIM2, TypePool.Default.LazyTypeDescription.GenericTypeToken.WILDCARD_TYPE_PATH, SignatureVisitor.EXTENDS, ',', SignatureVisitor.SUPER, '.', '/', ':', TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER, '<', SignatureVisitor.INSTANCEOF, '>', '?', '@', '[', '\\', PropertyUtils.INDEXED_DELIM2, '^', '_'};

    enum Mode {
        ASCII,
        C40,
        TEXT,
        X12,
        EDF,
        B256
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22053a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f22054b;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0059 */
        static {
            /*
                com.google.zxing.datamatrix.encoder.SymbolShapeHint[] r0 = com.google.zxing.datamatrix.encoder.SymbolShapeHint.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22054b = r0
                r1 = 1
                com.google.zxing.datamatrix.encoder.SymbolShapeHint r2 = com.google.zxing.datamatrix.encoder.SymbolShapeHint.FORCE_SQUARE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f22054b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.zxing.datamatrix.encoder.SymbolShapeHint r3 = com.google.zxing.datamatrix.encoder.SymbolShapeHint.FORCE_RECTANGLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode[] r2 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f22053a = r2
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r3 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.ASCII     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f22053a     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r2 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.B256     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = f22053a     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r1 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.C40     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = f22053a     // Catch:{ NoSuchFieldError -> 0x004e }
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r1 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.TEXT     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = f22053a     // Catch:{ NoSuchFieldError -> 0x0059 }
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r1 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.X12     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = f22053a     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r1 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.EDF     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.encoder.MinimalEncoder.a.<clinit>():void");
        }
    }

    private static final class b {

        /* renamed from: g  reason: collision with root package name */
        private static final int[] f22055g = {3, 5, 8, 10, 12, 16, 18, 22, 30, 32, 36, 44, 49, 62, 86, 114, Opcodes.D2F, Opcodes.FRETURN, 204, 280, 368, 456, 576, 696, 816, 1050, 1304, 1558};

        /* renamed from: h  reason: collision with root package name */
        private static final int[] f22056h = {3, 5, 8, 12, 18, 22, 30, 36, 44, 62, 86, 114, Opcodes.D2F, Opcodes.FRETURN, 204, 280, 368, 456, 576, 696, 816, 1050, 1304, 1558};

        /* renamed from: i  reason: collision with root package name */
        private static final int[] f22057i = {5, 10, 16, 33, 32, 49};
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final c f22058a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final Mode f22059b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f22060c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final int f22061d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final b f22062e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final int f22063f;

        /* synthetic */ b(c cVar, Mode mode, int i10, int i11, b bVar, a aVar) {
            this(cVar, mode, i10, i11, bVar);
        }

        static byte[] h(int i10) {
            return new byte[]{(byte) i10};
        }

        static byte[] i(int i10, int i11) {
            return new byte[]{(byte) i10, (byte) i11};
        }

        private static int j(boolean z10, int i10, char c10, int i11) {
            if (c10 == i11) {
                return 27;
            }
            if (!z10) {
                if (c10 != 0) {
                    if (i10 == 0 && c10 <= 3) {
                        return c10 - 1;
                    }
                    if (i10 == 1 && c10 <= 31) {
                        return c10;
                    }
                    if (c10 == ' ') {
                        return 3;
                    }
                    if (c10 >= '!' && c10 <= '/') {
                        return c10 - '!';
                    }
                    if (c10 >= '0' && c10 <= '9') {
                        return c10 - ',';
                    }
                    if (c10 >= ':' && c10 <= '@') {
                        return c10 - '+';
                    }
                    if (c10 >= 'A' && c10 <= 'Z') {
                        return c10 - '@';
                    }
                    if (c10 >= '[' && c10 <= '_') {
                        return c10 - 'E';
                    }
                    if (c10 != '`') {
                        return (c10 < 'a' || c10 > 'z') ? (c10 < '{' || c10 > 127) ? c10 : c10 - '`' : c10 - 'S';
                    }
                }
                return 0;
            } else if (c10 <= 31) {
                return c10;
            } else {
                if (c10 == ' ') {
                    return 3;
                }
                return c10 <= '/' ? c10 - '!' : c10 <= '9' ? c10 - ',' : c10 <= '@' ? c10 - '+' : c10 <= 'Z' ? c10 - '3' : c10 <= '_' ? c10 - 'E' : c10 <= 127 ? c10 - '`' : c10;
            }
        }

        static int v(char c10, boolean z10, int i10) {
            if ((z10 && MinimalEncoder.l(c10)) || (!z10 && MinimalEncoder.n(c10))) {
                return 0;
            }
            if ((!z10 || !MinimalEncoder.m(c10, i10)) && (z10 || !MinimalEncoder.o(c10, i10))) {
                return 2;
            }
            return 1;
        }

        private static int w(char c10) {
            if (c10 == 13) {
                return 0;
            }
            if (c10 == '*') {
                return 1;
            }
            if (c10 == '>') {
                return 2;
            }
            if (c10 == ' ') {
                return 3;
            }
            return (c10 < '0' || c10 > '9') ? (c10 < 'A' || c10 > 'Z') ? c10 : c10 - '3' : c10 - ',';
        }

        static void y(byte[] bArr, int i10, int i11, int i12, int i13) {
            int i14 = ((i11 & 255) * 1600) + ((i12 & 255) * 40) + (i13 & 255) + 1;
            bArr[i10] = (byte) (i14 / 256);
            bArr[i10 + 1] = (byte) (i14 % 256);
        }

        /* access modifiers changed from: package-private */
        public int g() {
            int i10 = 0;
            b bVar = this;
            while (bVar != null && bVar.f22059b == Mode.B256 && i10 <= 250) {
                i10++;
                bVar = bVar.f22062e;
            }
            return i10;
        }

        /* access modifiers changed from: package-private */
        public byte[] k(boolean z10, int i10) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < this.f22061d; i11++) {
                char charAt = this.f22058a.charAt(this.f22060c + i11);
                if ((z10 && g.h(charAt)) || (!z10 && g.j(charAt))) {
                    arrayList.add(Byte.valueOf((byte) j(z10, 0, charAt, i10)));
                } else if (!MinimalEncoder.k(charAt, i10)) {
                    int v10 = v(charAt, z10, i10);
                    arrayList.add(Byte.valueOf((byte) v10));
                    arrayList.add(Byte.valueOf((byte) j(z10, v10, charAt, i10)));
                } else {
                    char c10 = (char) ((charAt & 255) - 128);
                    if ((!z10 || !g.h(c10)) && (z10 || !g.j(c10))) {
                        arrayList.add((byte) 1);
                        arrayList.add((byte) 30);
                        int v11 = v(c10, z10, i10);
                        arrayList.add(Byte.valueOf((byte) v11));
                        arrayList.add(Byte.valueOf((byte) j(z10, v11, c10, i10)));
                    } else {
                        arrayList.add((byte) 1);
                        arrayList.add((byte) 30);
                        arrayList.add(Byte.valueOf((byte) j(z10, 0, c10, i10)));
                    }
                }
            }
            if (arrayList.size() % 3 != 0) {
                arrayList.add((byte) 0);
            }
            byte[] bArr = new byte[((arrayList.size() / 3) * 2)];
            int i12 = 0;
            for (int i13 = 0; i13 < arrayList.size(); i13 += 3) {
                y(bArr, i12, ((Byte) arrayList.get(i13)).byteValue() & 255, ((Byte) arrayList.get(i13 + 1)).byteValue() & 255, ((Byte) arrayList.get(i13 + 2)).byteValue() & 255);
                i12 += 2;
            }
            return bArr;
        }

        /* access modifiers changed from: package-private */
        public int l(int i10) {
            return r(i10) - i10;
        }

        /* access modifiers changed from: package-private */
        public byte[] m() {
            switch (a.f22053a[this.f22059b.ordinal()]) {
                case 1:
                    if (this.f22058a.a(this.f22060c)) {
                        return i(241, this.f22058a.b(this.f22060c) + 1);
                    }
                    if (MinimalEncoder.k(this.f22058a.charAt(this.f22060c), this.f22058a.f())) {
                        return i(235, this.f22058a.charAt(this.f22060c) - 127);
                    }
                    if (this.f22061d == 2) {
                        return h(((((this.f22058a.charAt(this.f22060c) - '0') * 10) + this.f22058a.charAt(this.f22060c + 1)) - 48) + Opcodes.IXOR);
                    }
                    if (this.f22058a.h(this.f22060c)) {
                        return h(232);
                    }
                    return h(this.f22058a.charAt(this.f22060c) + 1);
                case 2:
                    return h(this.f22058a.charAt(this.f22060c));
                case 3:
                    return k(true, this.f22058a.f());
                case 4:
                    return k(false, this.f22058a.f());
                case 5:
                    return x();
                case 6:
                    return n();
                default:
                    return new byte[0];
            }
        }

        /* access modifiers changed from: package-private */
        public byte[] n() {
            int i10;
            int ceil = (int) Math.ceil(((double) this.f22061d) / 4.0d);
            byte[] bArr = new byte[(ceil * 3)];
            int i11 = this.f22060c;
            int min = Math.min((this.f22061d + i11) - 1, this.f22058a.length() - 1);
            for (int i12 = 0; i12 < ceil; i12 += 3) {
                int[] iArr = new int[4];
                for (int i13 = 0; i13 < 4; i13++) {
                    if (i11 <= min) {
                        iArr[i13] = this.f22058a.charAt(i11) & '?';
                        i11++;
                    } else {
                        if (i11 == min + 1) {
                            i10 = 31;
                        } else {
                            i10 = 0;
                        }
                        iArr[i13] = i10;
                    }
                }
                int i14 = (iArr[0] << 18) | (iArr[1] << 12) | (iArr[2] << 6) | iArr[3];
                bArr[i12] = (byte) ((i14 >> 16) & 255);
                bArr[i12 + 1] = (byte) ((i14 >> 8) & 255);
                bArr[i12 + 2] = (byte) (i14 & 255);
            }
            return bArr;
        }

        /* access modifiers changed from: package-private */
        public Mode o() {
            if (this.f22059b == Mode.EDF) {
                if (this.f22061d < 4) {
                    return Mode.ASCII;
                }
                int p10 = p();
                if (p10 > 0 && l(this.f22063f + p10) <= 2 - p10) {
                    return Mode.ASCII;
                }
            }
            Mode mode = this.f22059b;
            if (mode == Mode.C40 || mode == Mode.TEXT || mode == Mode.X12) {
                if (this.f22060c + this.f22061d >= this.f22058a.length() && l(this.f22063f) == 0) {
                    return Mode.ASCII;
                }
                if (p() == 1 && l(this.f22063f + 1) == 0) {
                    return Mode.ASCII;
                }
            }
            return this.f22059b;
        }

        /* access modifiers changed from: package-private */
        public int p() {
            int length = this.f22058a.length();
            int i10 = this.f22060c + this.f22061d;
            int i11 = length - i10;
            if (i11 <= 4 && i10 < length) {
                if (i11 == 1) {
                    if (MinimalEncoder.k(this.f22058a.charAt(i10), this.f22058a.f())) {
                        return 0;
                    }
                    return 1;
                } else if (i11 == 2) {
                    if (!MinimalEncoder.k(this.f22058a.charAt(i10), this.f22058a.f())) {
                        int i12 = i10 + 1;
                        if (!MinimalEncoder.k(this.f22058a.charAt(i12), this.f22058a.f())) {
                            if (!g.f(this.f22058a.charAt(i10)) || !g.f(this.f22058a.charAt(i12))) {
                                return 2;
                            }
                            return 1;
                        }
                    }
                    return 0;
                } else if (i11 == 3) {
                    if (g.f(this.f22058a.charAt(i10)) && g.f(this.f22058a.charAt(i10 + 1)) && !MinimalEncoder.k(this.f22058a.charAt(i10 + 2), this.f22058a.f())) {
                        return 2;
                    }
                    if (!g.f(this.f22058a.charAt(i10 + 1)) || !g.f(this.f22058a.charAt(i10 + 2)) || MinimalEncoder.k(this.f22058a.charAt(i10), this.f22058a.f())) {
                        return 0;
                    }
                    return 2;
                } else if (!g.f(this.f22058a.charAt(i10)) || !g.f(this.f22058a.charAt(i10 + 1)) || !g.f(this.f22058a.charAt(i10 + 2)) || !g.f(this.f22058a.charAt(i10 + 3))) {
                    return 0;
                } else {
                    return 2;
                }
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public byte[] q() {
            int[] iArr = a.f22053a;
            switch (iArr[t().ordinal()]) {
                case 1:
                case 2:
                    int i10 = iArr[this.f22059b.ordinal()];
                    if (i10 == 2) {
                        return h(231);
                    }
                    if (i10 == 3) {
                        return h(230);
                    }
                    if (i10 == 4) {
                        return h(239);
                    }
                    if (i10 == 5) {
                        return h(238);
                    }
                    if (i10 == 6) {
                        return h(240);
                    }
                    break;
                case 3:
                case 4:
                case 5:
                    if (this.f22059b != t()) {
                        switch (iArr[this.f22059b.ordinal()]) {
                            case 1:
                                return h(254);
                            case 2:
                                return i(254, 231);
                            case 3:
                                return i(254, 230);
                            case 4:
                                return i(254, 239);
                            case 5:
                                return i(254, 238);
                            case 6:
                                return i(254, 240);
                        }
                    }
                    break;
            }
            return new byte[0];
        }

        /* access modifiers changed from: package-private */
        public int r(int i10) {
            int i11 = a.f22054b[this.f22058a.l().ordinal()];
            if (i11 == 1) {
                for (int i12 : f22056h) {
                    if (i12 >= i10) {
                        return i12;
                    }
                }
            } else if (i11 == 2) {
                for (int i13 : f22057i) {
                    if (i13 >= i10) {
                        return i13;
                    }
                }
            }
            for (int i14 : f22055g) {
                if (i14 >= i10) {
                    return i14;
                }
            }
            int[] iArr = f22055g;
            return iArr[iArr.length - 1];
        }

        /* access modifiers changed from: package-private */
        public Mode s() {
            return this.f22059b;
        }

        /* access modifiers changed from: package-private */
        public Mode t() {
            b bVar = this.f22062e;
            return bVar == null ? Mode.ASCII : bVar.o();
        }

        /* access modifiers changed from: package-private */
        public Mode u() {
            b bVar = this.f22062e;
            return bVar == null ? Mode.ASCII : bVar.f22059b;
        }

        /* access modifiers changed from: package-private */
        public byte[] x() {
            int i10 = (this.f22061d / 3) * 2;
            byte[] bArr = new byte[i10];
            for (int i11 = 0; i11 < i10; i11 += 2) {
                int i12 = (i11 / 2) * 3;
                y(bArr, i11, w(this.f22058a.charAt(this.f22060c + i12)), w(this.f22058a.charAt(this.f22060c + i12 + 1)), w(this.f22058a.charAt(this.f22060c + i12 + 2)));
            }
            return bArr;
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
            if (r0 != com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.f22049d) goto L_0x00b9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x003c, code lost:
            r10 = r10 + 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x006d, code lost:
            if (r0 == r1) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0091, code lost:
            if (r0 != com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.f22049d) goto L_0x00b9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x00b6, code lost:
            if (r0 != com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.f22049d) goto L_0x00b9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00b9, code lost:
            r5.f22063f = r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00bb, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private b(com.google.zxing.datamatrix.encoder.MinimalEncoder.c r6, com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode r7, int r8, int r9, com.google.zxing.datamatrix.encoder.MinimalEncoder.b r10) {
            /*
                r5 = this;
                r5.<init>()
                r5.f22058a = r6
                r5.f22059b = r7
                r5.f22060c = r8
                r5.f22061d = r9
                r5.f22062e = r10
                r9 = 0
                if (r10 == 0) goto L_0x0013
                int r10 = r10.f22063f
                goto L_0x0014
            L_0x0013:
                r10 = r9
            L_0x0014:
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r0 = r5.t()
                int[] r1 = com.google.zxing.datamatrix.encoder.MinimalEncoder.a.f22053a
                int r2 = r7.ordinal()
                r1 = r1[r2]
                switch(r1) {
                    case 1: goto L_0x0094;
                    case 2: goto L_0x0070;
                    case 3: goto L_0x0044;
                    case 4: goto L_0x0044;
                    case 5: goto L_0x0044;
                    case 6: goto L_0x0025;
                    default: goto L_0x0023;
                }
            L_0x0023:
                goto L_0x00b9
            L_0x0025:
                int r10 = r10 + 3
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r6 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.ASCII
                if (r0 == r6) goto L_0x0040
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r6 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.B256
                if (r0 != r6) goto L_0x0030
                goto L_0x0040
            L_0x0030:
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r6 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.C40
                if (r0 == r6) goto L_0x003c
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r6 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.TEXT
                if (r0 == r6) goto L_0x003c
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r6 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.X12
                if (r0 != r6) goto L_0x00b9
            L_0x003c:
                int r10 = r10 + 2
                goto L_0x00b9
            L_0x0040:
                int r10 = r10 + 1
                goto L_0x00b9
            L_0x0044:
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r1 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.X12
                if (r7 != r1) goto L_0x004b
                int r10 = r10 + 2
                goto L_0x005a
            L_0x004b:
                r2 = 1
                int[] r3 = new int[r2]
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r4 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.C40
                if (r7 != r4) goto L_0x0053
                r9 = r2
            L_0x0053:
                int r6 = com.google.zxing.datamatrix.encoder.MinimalEncoder.j(r6, r8, r9, r3)
                int r6 = r6 * 2
                int r10 = r10 + r6
            L_0x005a:
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r6 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.ASCII
                if (r0 == r6) goto L_0x0040
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r6 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.B256
                if (r0 != r6) goto L_0x0063
                goto L_0x0040
            L_0x0063:
                if (r0 == r7) goto L_0x00b9
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r6 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.C40
                if (r0 == r6) goto L_0x003c
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r6 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.TEXT
                if (r0 == r6) goto L_0x003c
                if (r0 != r1) goto L_0x00b9
                goto L_0x0093
            L_0x0070:
                int r10 = r10 + 1
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r6 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.B256
                if (r0 == r6) goto L_0x0079
            L_0x0076:
                int r10 = r10 + 1
                goto L_0x0082
            L_0x0079:
                int r6 = r5.g()
                r7 = 250(0xfa, float:3.5E-43)
                if (r6 != r7) goto L_0x0082
                goto L_0x0076
            L_0x0082:
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r6 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.ASCII
                if (r0 != r6) goto L_0x0087
                goto L_0x0040
            L_0x0087:
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r6 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.C40
                if (r0 == r6) goto L_0x003c
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r6 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.TEXT
                if (r0 == r6) goto L_0x003c
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r6 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.X12
                if (r0 != r6) goto L_0x00b9
            L_0x0093:
                goto L_0x003c
            L_0x0094:
                int r10 = r10 + 1
                boolean r7 = r6.a(r8)
                if (r7 != 0) goto L_0x00aa
                char r7 = r6.charAt(r8)
                int r6 = r6.f()
                boolean r6 = com.google.zxing.datamatrix.encoder.MinimalEncoder.k(r7, r6)
                if (r6 == 0) goto L_0x00ac
            L_0x00aa:
                int r10 = r10 + 1
            L_0x00ac:
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r6 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.C40
                if (r0 == r6) goto L_0x0040
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r6 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.TEXT
                if (r0 == r6) goto L_0x0040
                com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r6 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.X12
                if (r0 != r6) goto L_0x00b9
                goto L_0x0040
            L_0x00b9:
                r5.f22063f = r10
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.encoder.MinimalEncoder.b.<init>(com.google.zxing.datamatrix.encoder.MinimalEncoder$c, com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode, int, int, com.google.zxing.datamatrix.encoder.MinimalEncoder$b):void");
        }
    }

    private static final class c extends e {

        /* renamed from: c  reason: collision with root package name */
        private final SymbolShapeHint f22064c;

        /* renamed from: d  reason: collision with root package name */
        private final int f22065d;

        /* synthetic */ c(String str, Charset charset, int i10, SymbolShapeHint symbolShapeHint, int i11, a aVar) {
            this(str, charset, i10, symbolShapeHint, i11);
        }

        /* access modifiers changed from: private */
        public int k() {
            return this.f22065d;
        }

        /* access modifiers changed from: private */
        public SymbolShapeHint l() {
            return this.f22064c;
        }

        private c(String str, Charset charset, int i10, SymbolShapeHint symbolShapeHint, int i11) {
            super(str, charset, i10);
            this.f22064c = symbolShapeHint;
            this.f22065d = i11;
        }
    }

    private static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f22066a;

        d(b bVar) {
            int i10;
            int i11;
            c b10 = bVar.f22058a;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int i12 = 0;
            if ((bVar.f22059b == Mode.C40 || bVar.f22059b == Mode.TEXT || bVar.f22059b == Mode.X12) && bVar.o() != Mode.ASCII) {
                i10 = c(b.h(254), arrayList) + 0;
            } else {
                i10 = 0;
            }
            for (b bVar2 = bVar; bVar2 != null; bVar2 = bVar2.f22062e) {
                int c10 = i10 + c(bVar2.m(), arrayList);
                if (bVar2.f22062e == null || bVar2.u() != bVar2.s()) {
                    if (bVar2.s() == Mode.B256) {
                        if (c10 <= 249) {
                            arrayList.add(0, Byte.valueOf((byte) c10));
                            i11 = c10 + 1;
                        } else {
                            arrayList.add(0, Byte.valueOf((byte) (c10 % MessageTemplateConstants.Values.CENTER_POPUP_HEIGHT)));
                            arrayList.add(0, Byte.valueOf((byte) ((c10 / MessageTemplateConstants.Values.CENTER_POPUP_HEIGHT) + 249)));
                            i11 = c10 + 2;
                        }
                        arrayList2.add(Integer.valueOf(arrayList.size()));
                        arrayList3.add(Integer.valueOf(i11));
                    }
                    c(bVar2.q(), arrayList);
                    c10 = 0;
                }
            }
            if (b10.k() == 5) {
                c(b.h(236), arrayList);
            } else if (b10.k() == 6) {
                c(b.h(237), arrayList);
            }
            if (b10.f() > 0) {
                c(b.h(232), arrayList);
            }
            for (int i13 = 0; i13 < arrayList2.size(); i13++) {
                a(arrayList, arrayList.size() - ((Integer) arrayList2.get(i13)).intValue(), ((Integer) arrayList3.get(i13)).intValue());
            }
            int r10 = bVar.r(arrayList.size());
            if (arrayList.size() < r10) {
                arrayList.add((byte) -127);
            }
            while (arrayList.size() < r10) {
                arrayList.add(Byte.valueOf((byte) d(arrayList.size() + 1)));
            }
            this.f22066a = new byte[arrayList.size()];
            while (true) {
                byte[] bArr = this.f22066a;
                if (i12 < bArr.length) {
                    bArr[i12] = ((Byte) arrayList.get(i12)).byteValue();
                    i12++;
                } else {
                    return;
                }
            }
        }

        static void a(List<Byte> list, int i10, int i11) {
            for (int i12 = 0; i12 < i11; i12++) {
                int i13 = i10 + i12;
                int byteValue = (list.get(i13).byteValue() & 255) + (((i13 + 1) * Opcodes.FCMPL) % 255) + 1;
                if (byteValue > 255) {
                    byteValue -= 256;
                }
                list.set(i13, Byte.valueOf((byte) byteValue));
            }
        }

        static int c(byte[] bArr, List<Byte> list) {
            for (int length = bArr.length - 1; length >= 0; length--) {
                list.add(0, Byte.valueOf(bArr[length]));
            }
            return bArr.length;
        }

        private static int d(int i10) {
            int i11 = ((i10 * Opcodes.FCMPL) % 253) + 1 + 129;
            return i11 <= 254 ? i11 : i11 - 254;
        }

        public byte[] b() {
            return this.f22066a;
        }
    }

    static void e(b[][] bVarArr, b bVar) {
        int a10 = bVar.f22060c + bVar.f22061d;
        if (bVarArr[a10][bVar.o().ordinal()] == null || bVarArr[a10][bVar.o().ordinal()].f22063f > bVar.f22063f) {
            bVarArr[a10][bVar.o().ordinal()] = bVar;
        }
    }

    /* JADX WARNING: type inference failed for: r11v0 */
    /* JADX WARNING: type inference failed for: r11v4 */
    /* JADX WARNING: type inference failed for: r11v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void f(com.google.zxing.datamatrix.encoder.MinimalEncoder.c r17, com.google.zxing.datamatrix.encoder.MinimalEncoder.b[][] r18, int r19, com.google.zxing.datamatrix.encoder.MinimalEncoder.b r20) {
        /*
            r7 = r17
            r8 = r18
            r9 = r19
            boolean r0 = r7.a(r9)
            if (r0 == 0) goto L_0x0020
            com.google.zxing.datamatrix.encoder.MinimalEncoder$b r10 = new com.google.zxing.datamatrix.encoder.MinimalEncoder$b
            com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r2 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.ASCII
            r4 = 1
            r6 = 0
            r0 = r10
            r1 = r17
            r3 = r19
            r5 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6)
            e(r8, r10)
            return
        L_0x0020:
            char r0 = r7.charAt(r9)
            r10 = 3
            r11 = 0
            r12 = 1
            if (r20 == 0) goto L_0x0031
            com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r1 = r20.o()
            com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r2 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.EDF
            if (r1 == r2) goto L_0x00f7
        L_0x0031:
            boolean r0 = com.google.zxing.datamatrix.encoder.g.f(r0)
            r13 = 2
            if (r0 == 0) goto L_0x005e
            boolean r0 = r7.g(r9, r13)
            if (r0 == 0) goto L_0x005e
            int r0 = r9 + 1
            char r0 = r7.charAt(r0)
            boolean r0 = com.google.zxing.datamatrix.encoder.g.f(r0)
            if (r0 == 0) goto L_0x005e
            com.google.zxing.datamatrix.encoder.MinimalEncoder$b r14 = new com.google.zxing.datamatrix.encoder.MinimalEncoder$b
            com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r2 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.ASCII
            r4 = 2
            r6 = 0
            r0 = r14
            r1 = r17
            r3 = r19
            r5 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6)
            e(r8, r14)
            goto L_0x0071
        L_0x005e:
            com.google.zxing.datamatrix.encoder.MinimalEncoder$b r14 = new com.google.zxing.datamatrix.encoder.MinimalEncoder$b
            com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r2 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.ASCII
            r4 = 1
            r6 = 0
            r0 = r14
            r1 = r17
            r3 = r19
            r5 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6)
            e(r8, r14)
        L_0x0071:
            com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode[] r14 = new com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode[r13]
            com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r0 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.C40
            r14[r11] = r0
            com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r0 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.TEXT
            r14[r12] = r0
            r15 = r11
        L_0x007c:
            if (r15 >= r13) goto L_0x00a9
            r2 = r14[r15]
            int[] r0 = new int[r12]
            com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r1 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.C40
            if (r2 != r1) goto L_0x0088
            r1 = r12
            goto L_0x0089
        L_0x0088:
            r1 = r11
        L_0x0089:
            int r1 = j(r7, r9, r1, r0)
            if (r1 <= 0) goto L_0x00a5
            com.google.zxing.datamatrix.encoder.MinimalEncoder$b r6 = new com.google.zxing.datamatrix.encoder.MinimalEncoder$b
            r4 = r0[r11]
            r16 = 0
            r0 = r6
            r1 = r17
            r3 = r19
            r5 = r20
            r11 = r6
            r6 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6)
            e(r8, r11)
        L_0x00a5:
            int r15 = r15 + 1
            r11 = 0
            goto L_0x007c
        L_0x00a9:
            boolean r0 = r7.g(r9, r10)
            if (r0 == 0) goto L_0x00e4
            char r0 = r7.charAt(r9)
            boolean r0 = com.google.zxing.datamatrix.encoder.g.k(r0)
            if (r0 == 0) goto L_0x00e4
            int r0 = r9 + 1
            char r0 = r7.charAt(r0)
            boolean r0 = com.google.zxing.datamatrix.encoder.g.k(r0)
            if (r0 == 0) goto L_0x00e4
            int r0 = r9 + 2
            char r0 = r7.charAt(r0)
            boolean r0 = com.google.zxing.datamatrix.encoder.g.k(r0)
            if (r0 == 0) goto L_0x00e4
            com.google.zxing.datamatrix.encoder.MinimalEncoder$b r11 = new com.google.zxing.datamatrix.encoder.MinimalEncoder$b
            com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r2 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.X12
            r4 = 3
            r6 = 0
            r0 = r11
            r1 = r17
            r3 = r19
            r5 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6)
            e(r8, r11)
        L_0x00e4:
            com.google.zxing.datamatrix.encoder.MinimalEncoder$b r11 = new com.google.zxing.datamatrix.encoder.MinimalEncoder$b
            com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r2 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.B256
            r4 = 1
            r6 = 0
            r0 = r11
            r1 = r17
            r3 = r19
            r5 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6)
            e(r8, r11)
        L_0x00f7:
            r11 = 0
        L_0x00f8:
            if (r11 >= r10) goto L_0x0122
            int r0 = r9 + r11
            boolean r1 = r7.g(r0, r12)
            if (r1 == 0) goto L_0x0122
            char r0 = r7.charAt(r0)
            boolean r0 = com.google.zxing.datamatrix.encoder.g.i(r0)
            if (r0 == 0) goto L_0x0122
            com.google.zxing.datamatrix.encoder.MinimalEncoder$b r13 = new com.google.zxing.datamatrix.encoder.MinimalEncoder$b
            com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r2 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.EDF
            int r11 = r11 + 1
            r6 = 0
            r0 = r13
            r1 = r17
            r3 = r19
            r4 = r11
            r5 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6)
            e(r8, r13)
            goto L_0x00f8
        L_0x0122:
            if (r11 != r10) goto L_0x014a
            r0 = 4
            boolean r0 = r7.g(r9, r0)
            if (r0 == 0) goto L_0x014a
            int r0 = r9 + 3
            char r0 = r7.charAt(r0)
            boolean r0 = com.google.zxing.datamatrix.encoder.g.i(r0)
            if (r0 == 0) goto L_0x014a
            com.google.zxing.datamatrix.encoder.MinimalEncoder$b r10 = new com.google.zxing.datamatrix.encoder.MinimalEncoder$b
            com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode r2 = com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.EDF
            r4 = 4
            r6 = 0
            r0 = r10
            r1 = r17
            r3 = r19
            r5 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6)
            e(r8, r10)
        L_0x014a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.encoder.MinimalEncoder.f(com.google.zxing.datamatrix.encoder.MinimalEncoder$c, com.google.zxing.datamatrix.encoder.MinimalEncoder$b[][], int, com.google.zxing.datamatrix.encoder.MinimalEncoder$b):void");
    }

    static byte[] g(String str, Charset charset, int i10, SymbolShapeHint symbolShapeHint, int i11) {
        return i(new c(str, charset, i10, symbolShapeHint, i11, (a) null)).b();
    }

    public static String h(String str, Charset charset, int i10, SymbolShapeHint symbolShapeHint) {
        int i11;
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            i11 = 5;
            str = str.substring(7, str.length() - 2);
        } else if (!str.startsWith("[)>\u001e06\u001d") || !str.endsWith("\u001e\u0004")) {
            i11 = 0;
        } else {
            i11 = 6;
            str = str.substring(7, str.length() - 2);
        }
        return new String(g(str, charset, i10, symbolShapeHint, i11), StandardCharsets.ISO_8859_1);
    }

    static d i(c cVar) {
        int i10;
        int length = cVar.length();
        int[] iArr = new int[2];
        iArr[1] = 6;
        iArr[0] = length + 1;
        b[][] bVarArr = (b[][]) Array.newInstance(b.class, iArr);
        f(cVar, bVarArr, 0, (b) null);
        for (int i11 = 1; i11 <= length; i11++) {
            for (int i12 = 0; i12 < 6; i12++) {
                b bVar = bVarArr[i11][i12];
                if (bVar != null && i11 < length) {
                    f(cVar, bVarArr, i11, bVar);
                }
            }
            for (int i13 = 0; i13 < 6; i13++) {
                bVarArr[i11 - 1][i13] = null;
            }
        }
        int i14 = -1;
        int i15 = a.e.API_PRIORITY_OTHER;
        for (int i16 = 0; i16 < 6; i16++) {
            b bVar2 = bVarArr[length][i16];
            if (bVar2 != null) {
                if (i16 < 1 || i16 > 3) {
                    i10 = bVar2.f22063f;
                } else {
                    i10 = bVar2.f22063f + 1;
                }
                if (i10 < i15) {
                    i14 = i16;
                    i15 = i10;
                }
            }
        }
        if (i14 >= 0) {
            return new d(bVarArr[length][i14]);
        }
        throw new IllegalStateException("Failed to encode \"" + cVar + "\"");
    }

    static int j(c cVar, int i10, boolean z10, int[] iArr) {
        int i11 = 0;
        for (int i12 = i10; i12 < cVar.length(); i12++) {
            if (cVar.a(i12)) {
                iArr[0] = 0;
                return 0;
            }
            char charAt = cVar.charAt(i12);
            if ((z10 && g.h(charAt)) || (!z10 && g.j(charAt))) {
                i11++;
            } else if (!k(charAt, cVar.f())) {
                i11 += 2;
            } else {
                char c10 = charAt & 255;
                if (c10 < 128 || ((!z10 || !g.h((char) (c10 - 128))) && (z10 || !g.j((char) (c10 - 128))))) {
                    i11 += 4;
                } else {
                    i11 += 3;
                }
            }
            if (i11 % 3 == 0 || ((i11 - 2) % 3 == 0 && i12 + 1 == cVar.length())) {
                iArr[0] = (i12 - i10) + 1;
                return (int) Math.ceil(((double) i11) / 3.0d);
            }
        }
        iArr[0] = 0;
        return 0;
    }

    static boolean k(char c10, int i10) {
        return c10 != i10 && c10 >= 128 && c10 <= 255;
    }

    /* access modifiers changed from: private */
    public static boolean l(char c10) {
        return c10 <= 31;
    }

    /* access modifiers changed from: private */
    public static boolean m(char c10, int i10) {
        for (char c11 : f22045a) {
            if (c11 == c10) {
                return true;
            }
        }
        return c10 == i10;
    }

    /* access modifiers changed from: private */
    public static boolean n(char c10) {
        return l(c10);
    }

    /* access modifiers changed from: private */
    public static boolean o(char c10, int i10) {
        return m(c10, i10);
    }
}
