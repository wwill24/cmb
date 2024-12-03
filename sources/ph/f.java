package ph;

import com.facebook.appevents.AppEventsConstants;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.pdf417.encoder.Compaction;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import jh.d;
import jh.e;

final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f24403a = {48, Framer.STDOUT_FRAME_PREFIX, Framer.STDERR_FRAME_PREFIX, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, Framer.STDIN_FRAME_PREFIX, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f24404b = {59, 60, 62, 64, 91, 92, 93, Framer.STDIN_REQUEST_FRAME_PREFIX, 96, 126, Framer.ENTER_FRAME_PREFIX, 13, 9, 44, 58, 10, Framer.STDIN_FRAME_PREFIX, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f24405c;

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f24406d = new byte[128];

    /* renamed from: e  reason: collision with root package name */
    private static final Charset f24407e = StandardCharsets.ISO_8859_1;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24408a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.zxing.pdf417.encoder.Compaction[] r0 = com.google.zxing.pdf417.encoder.Compaction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24408a = r0
                com.google.zxing.pdf417.encoder.Compaction r1 = com.google.zxing.pdf417.encoder.Compaction.TEXT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24408a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.zxing.pdf417.encoder.Compaction r1 = com.google.zxing.pdf417.encoder.Compaction.BYTE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f24408a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.zxing.pdf417.encoder.Compaction r1 = com.google.zxing.pdf417.encoder.Compaction.NUMERIC     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ph.f.a.<clinit>():void");
        }
    }

    private static final class b implements d {

        /* renamed from: a  reason: collision with root package name */
        String f24409a;

        /* synthetic */ b(String str, a aVar) {
            this(str);
        }

        public boolean a(int i10) {
            return false;
        }

        public int b(int i10) {
            return -1;
        }

        public char charAt(int i10) {
            return this.f24409a.charAt(i10);
        }

        public int length() {
            return this.f24409a.length();
        }

        public CharSequence subSequence(int i10, int i11) {
            return this.f24409a.subSequence(i10, i11);
        }

        public String toString() {
            return this.f24409a;
        }

        private b(String str) {
            this.f24409a = str;
        }
    }

    static {
        byte[] bArr = new byte[128];
        f24405c = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i10 = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr2 = f24403a;
            if (i11 >= bArr2.length) {
                break;
            }
            byte b10 = bArr2[i11];
            if (b10 > 0) {
                f24405c[b10] = (byte) i11;
            }
            i11++;
        }
        Arrays.fill(f24406d, (byte) -1);
        while (true) {
            byte[] bArr3 = f24404b;
            if (i10 < bArr3.length) {
                byte b11 = bArr3[i10];
                if (b11 > 0) {
                    f24406d[b11] = (byte) i10;
                }
                i10++;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0011 A[LOOP:1: B:6:0x0011->B:13:0x0029, LOOP_START, PHI: r2 r3 
      PHI: (r2v1 int) = (r2v0 int), (r2v5 int) binds: [B:5:0x000f, B:13:0x0029] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r3v1 int) = (r3v0 int), (r3v4 int) binds: [B:5:0x000f, B:13:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(jh.d r6, int r7, java.nio.charset.Charset r8) throws com.google.zxing.WriterException {
        /*
            if (r8 != 0) goto L_0x0004
            r8 = 0
            goto L_0x0008
        L_0x0004:
            java.nio.charset.CharsetEncoder r8 = r8.newEncoder()
        L_0x0008:
            int r0 = r6.length()
            r1 = r7
        L_0x000d:
            if (r1 >= r0) goto L_0x0067
            r2 = 0
            r3 = r1
        L_0x0011:
            r4 = 13
            if (r2 >= r4) goto L_0x002b
            boolean r5 = r6.a(r3)
            if (r5 != 0) goto L_0x002b
            char r3 = r6.charAt(r3)
            boolean r3 = l(r3)
            if (r3 == 0) goto L_0x002b
            int r2 = r2 + 1
            int r3 = r1 + r2
            if (r3 < r0) goto L_0x0011
        L_0x002b:
            if (r2 < r4) goto L_0x002f
            int r1 = r1 - r7
            return r1
        L_0x002f:
            if (r8 == 0) goto L_0x0064
            char r2 = r6.charAt(r1)
            boolean r2 = r8.canEncode(r2)
            if (r2 == 0) goto L_0x003c
            goto L_0x0064
        L_0x003c:
            char r6 = r6.charAt(r1)
            com.google.zxing.WriterException r7 = new com.google.zxing.WriterException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Non-encodable character detected: "
            r8.append(r0)
            r8.append(r6)
            java.lang.String r0 = " (Unicode: "
            r8.append(r0)
            r8.append(r6)
            r6 = 41
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r7.<init>(r6)
            throw r7
        L_0x0064:
            int r1 = r1 + 1
            goto L_0x000d
        L_0x0067:
            int r1 = r1 - r7
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ph.f.a(jh.d, int, java.nio.charset.Charset):int");
    }

    private static int b(d dVar, int i10) {
        int length = dVar.length();
        int i11 = 0;
        if (i10 < length) {
            while (i10 < length && !dVar.a(i10) && l(dVar.charAt(i10))) {
                i11++;
                i10++;
            }
        }
        return i11;
    }

    private static int c(d dVar, int i10) {
        int length = dVar.length();
        int i11 = i10;
        while (i11 < length) {
            int i12 = 0;
            while (i12 < 13 && i11 < length && !dVar.a(i11) && l(dVar.charAt(i11))) {
                i12++;
                i11++;
            }
            if (i12 >= 13) {
                return (i11 - i10) - i12;
            }
            if (i12 <= 0) {
                if (dVar.a(i11) || !o(dVar.charAt(i11))) {
                    break;
                }
                i11++;
            }
        }
        return i11 - i10;
    }

    private static void d(byte[] bArr, int i10, int i11, int i12, StringBuilder sb2) {
        int i13;
        if (i11 == 1 && i12 == 0) {
            sb2.append(913);
        } else if (i11 % 6 == 0) {
            sb2.append(924);
        } else {
            sb2.append(901);
        }
        if (i11 >= 6) {
            char[] cArr = new char[5];
            i13 = i10;
            while ((i10 + i11) - i13 >= 6) {
                long j10 = 0;
                for (int i14 = 0; i14 < 6; i14++) {
                    j10 = (j10 << 8) + ((long) (bArr[i13 + i14] & 255));
                }
                for (int i15 = 0; i15 < 5; i15++) {
                    cArr[i15] = (char) ((int) (j10 % 900));
                    j10 /= 900;
                }
                for (int i16 = 4; i16 >= 0; i16--) {
                    sb2.append(cArr[i16]);
                }
                i13 += 6;
            }
        } else {
            i13 = i10;
        }
        while (i13 < i10 + i11) {
            sb2.append((char) (bArr[i13] & 255));
            i13++;
        }
    }

    static String e(String str, Compaction compaction, Charset charset, boolean z10) throws WriterException {
        d dVar;
        Charset charset2;
        byte[] bArr;
        CharacterSetECI a10;
        if (!str.isEmpty()) {
            if (charset == null && !z10) {
                int i10 = 0;
                while (i10 < str.length()) {
                    if (str.charAt(i10) <= 255) {
                        i10++;
                    } else {
                        throw new WriterException("Non-encodable character detected: " + str.charAt(i10) + " (Unicode: " + str.charAt(i10) + "). Consider specifying EncodeHintType.PDF417_AUTO_ECI and/or EncodeTypeHint.CHARACTER_SET.");
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder(str.length());
            if (z10) {
                dVar = new e(str, charset, -1);
            } else {
                dVar = new b(str, (a) null);
                if (charset == null) {
                    charset = f24407e;
                } else if (!f24407e.equals(charset) && (a10 = CharacterSetECI.a(charset)) != null) {
                    i(a10.c(), sb2);
                }
            }
            int length = dVar.length();
            int i11 = a.f24408a[compaction.ordinal()];
            if (i11 == 1) {
                h(dVar, 0, length, sb2, 0);
            } else if (i11 != 2) {
                if (i11 != 3) {
                    int i12 = 0;
                    int i13 = 0;
                    int i14 = 0;
                    while (i12 < length) {
                        while (i12 < length && dVar.a(i12)) {
                            i(dVar.b(i12), sb2);
                            i12++;
                        }
                        if (i12 >= length) {
                            break;
                        }
                        int b10 = b(dVar, i12);
                        if (b10 >= 13) {
                            sb2.append(902);
                            g(dVar, i12, b10, sb2);
                            i12 += b10;
                            i13 = 0;
                            i14 = 2;
                        } else {
                            int c10 = c(dVar, i12);
                            if (c10 >= 5 || b10 == length) {
                                if (i14 != 0) {
                                    sb2.append(900);
                                    i13 = 0;
                                    i14 = 0;
                                }
                                i13 = h(dVar, i12, c10, sb2, i13);
                                i12 += c10;
                            } else {
                                if (z10) {
                                    charset2 = null;
                                } else {
                                    charset2 = charset;
                                }
                                int a11 = a(dVar, i12, charset2);
                                if (a11 == 0) {
                                    a11 = 1;
                                }
                                if (z10) {
                                    bArr = null;
                                } else {
                                    bArr = dVar.subSequence(i12, i12 + a11).toString().getBytes(charset);
                                }
                                if ((!(bArr == null && a11 == 1) && (bArr == null || bArr.length != 1)) || i14 != 0) {
                                    if (z10) {
                                        f(dVar, i12, i12 + a11, i14, sb2);
                                    } else {
                                        d(bArr, 0, bArr.length, i14, sb2);
                                    }
                                    i13 = 0;
                                    i14 = 1;
                                } else if (z10) {
                                    f(dVar, i12, 1, 0, sb2);
                                } else {
                                    d(bArr, 0, 1, 0, sb2);
                                }
                                i12 += a11;
                            }
                        }
                    }
                } else {
                    sb2.append(902);
                    g(dVar, 0, length, sb2);
                }
            } else if (z10) {
                f(dVar, 0, dVar.length(), 0, sb2);
            } else {
                byte[] bytes = dVar.toString().getBytes(charset);
                d(bytes, 0, bytes.length, 1, sb2);
            }
            return sb2.toString();
        }
        throw new WriterException("Empty message not allowed");
    }

    private static void f(d dVar, int i10, int i11, int i12, StringBuilder sb2) throws WriterException {
        int i13;
        int min = Math.min(i11 + i10, dVar.length());
        int i14 = i10;
        while (true) {
            if (i14 >= min || !dVar.a(i14)) {
                int i15 = i14;
                while (i15 < min && !dVar.a(i15)) {
                    i15++;
                }
                int i16 = i15 - i14;
                if (i16 > 0) {
                    byte[] p10 = p(dVar, i14, i15);
                    if (i14 == i10) {
                        i13 = i12;
                    } else {
                        i13 = 1;
                    }
                    d(p10, 0, i16, i13, sb2);
                    i14 = i15;
                } else {
                    return;
                }
            } else {
                i(dVar.b(i14), sb2);
                i14++;
            }
        }
    }

    private static void g(d dVar, int i10, int i11, StringBuilder sb2) {
        StringBuilder sb3 = new StringBuilder((i11 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900);
        BigInteger valueOf2 = BigInteger.valueOf(0);
        int i12 = 0;
        while (i12 < i11) {
            sb3.setLength(0);
            int min = Math.min(44, i11 - i12);
            StringBuilder sb4 = new StringBuilder();
            sb4.append(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            int i13 = i10 + i12;
            sb4.append(dVar.subSequence(i13, i13 + min));
            BigInteger bigInteger = new BigInteger(sb4.toString());
            do {
                sb3.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = sb3.length() - 1; length >= 0; length--) {
                sb2.append(sb3.charAt(length));
            }
            i12 += min;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:73:0x010c A[EDGE_INSN: B:73:0x010c->B:58:0x010c ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0011 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int h(jh.d r16, int r17, int r18, java.lang.StringBuilder r19, int r20) throws com.google.zxing.WriterException {
        /*
            r0 = r16
            r1 = r18
            r2 = r19
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            r4 = 2
            r5 = 0
            r6 = 1
            r7 = r20
            r8 = r5
        L_0x0011:
            int r9 = r17 + r8
            boolean r10 = r0.a(r9)
            if (r10 == 0) goto L_0x0023
            int r9 = r0.b(r9)
            i(r9, r2)
            int r8 = r8 + 1
            goto L_0x0011
        L_0x0023:
            char r10 = r0.charAt(r9)
            r11 = 26
            r12 = 32
            r13 = 28
            r14 = 27
            r15 = 29
            if (r7 == 0) goto L_0x00d2
            if (r7 == r6) goto L_0x0099
            if (r7 == r4) goto L_0x004c
            boolean r9 = n(r10)
            if (r9 == 0) goto L_0x0047
            byte[] r9 = f24406d
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x0108
        L_0x0047:
            r3.append(r15)
        L_0x004a:
            r7 = r5
            goto L_0x0011
        L_0x004c:
            boolean r11 = m(r10)
            if (r11 == 0) goto L_0x005c
            byte[] r9 = f24405c
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x0108
        L_0x005c:
            boolean r11 = k(r10)
            if (r11 == 0) goto L_0x0066
            r3.append(r13)
            goto L_0x004a
        L_0x0066:
            boolean r11 = j(r10)
            if (r11 == 0) goto L_0x0071
            r3.append(r14)
            goto L_0x00ee
        L_0x0071:
            int r9 = r9 + 1
            if (r9 >= r1) goto L_0x008c
            boolean r11 = r0.a(r9)
            if (r11 != 0) goto L_0x008c
            char r9 = r0.charAt(r9)
            boolean r9 = n(r9)
            if (r9 == 0) goto L_0x008c
            r7 = 3
            r9 = 25
            r3.append(r9)
            goto L_0x0011
        L_0x008c:
            r3.append(r15)
            byte[] r9 = f24406d
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x0108
        L_0x0099:
            boolean r9 = j(r10)
            if (r9 == 0) goto L_0x00ac
            if (r10 != r12) goto L_0x00a5
            r3.append(r11)
            goto L_0x0108
        L_0x00a5:
            int r10 = r10 + -97
            char r9 = (char) r10
            r3.append(r9)
            goto L_0x0108
        L_0x00ac:
            boolean r9 = k(r10)
            if (r9 == 0) goto L_0x00bc
            r3.append(r14)
            int r10 = r10 + -65
            char r9 = (char) r10
            r3.append(r9)
            goto L_0x0108
        L_0x00bc:
            boolean r9 = m(r10)
            if (r9 == 0) goto L_0x00c6
            r3.append(r13)
            goto L_0x00fa
        L_0x00c6:
            r3.append(r15)
            byte[] r9 = f24406d
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
            goto L_0x0108
        L_0x00d2:
            boolean r9 = k(r10)
            if (r9 == 0) goto L_0x00e5
            if (r10 != r12) goto L_0x00de
            r3.append(r11)
            goto L_0x0108
        L_0x00de:
            int r10 = r10 + -65
            char r9 = (char) r10
            r3.append(r9)
            goto L_0x0108
        L_0x00e5:
            boolean r9 = j(r10)
            if (r9 == 0) goto L_0x00f1
            r3.append(r14)
        L_0x00ee:
            r7 = r6
            goto L_0x0011
        L_0x00f1:
            boolean r9 = m(r10)
            if (r9 == 0) goto L_0x00fd
            r3.append(r13)
        L_0x00fa:
            r7 = r4
            goto L_0x0011
        L_0x00fd:
            r3.append(r15)
            byte[] r9 = f24406d
            byte r9 = r9[r10]
            char r9 = (char) r9
            r3.append(r9)
        L_0x0108:
            int r8 = r8 + 1
            if (r8 < r1) goto L_0x0011
            int r0 = r3.length()
            r1 = r5
            r8 = r1
        L_0x0112:
            if (r1 >= r0) goto L_0x0130
            int r9 = r1 % 2
            if (r9 == 0) goto L_0x011a
            r9 = r6
            goto L_0x011b
        L_0x011a:
            r9 = r5
        L_0x011b:
            if (r9 == 0) goto L_0x0129
            int r8 = r8 * 30
            char r9 = r3.charAt(r1)
            int r8 = r8 + r9
            char r8 = (char) r8
            r2.append(r8)
            goto L_0x012d
        L_0x0129:
            char r8 = r3.charAt(r1)
        L_0x012d:
            int r1 = r1 + 1
            goto L_0x0112
        L_0x0130:
            int r0 = r0 % r4
            if (r0 == 0) goto L_0x013a
            int r8 = r8 * 30
            int r8 = r8 + r15
            char r0 = (char) r8
            r2.append(r0)
        L_0x013a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ph.f.h(jh.d, int, int, java.lang.StringBuilder, int):int");
    }

    private static void i(int i10, StringBuilder sb2) throws WriterException {
        if (i10 >= 0 && i10 < 900) {
            sb2.append(927);
            sb2.append((char) i10);
        } else if (i10 < 810900) {
            sb2.append(926);
            sb2.append((char) ((i10 / 900) - 1));
            sb2.append((char) (i10 % 900));
        } else if (i10 < 811800) {
            sb2.append(925);
            sb2.append((char) (810900 - i10));
        } else {
            throw new WriterException("ECI number not in valid range from 0..811799, but was " + i10);
        }
    }

    private static boolean j(char c10) {
        return c10 == ' ' || (c10 >= 'a' && c10 <= 'z');
    }

    private static boolean k(char c10) {
        return c10 == ' ' || (c10 >= 'A' && c10 <= 'Z');
    }

    private static boolean l(char c10) {
        return c10 >= '0' && c10 <= '9';
    }

    private static boolean m(char c10) {
        return f24405c[c10] != -1;
    }

    private static boolean n(char c10) {
        return f24406d[c10] != -1;
    }

    private static boolean o(char c10) {
        return c10 == 9 || c10 == 10 || c10 == 13 || (c10 >= ' ' && c10 <= '~');
    }

    static byte[] p(d dVar, int i10, int i11) {
        byte[] bArr = new byte[(i11 - i10)];
        for (int i12 = i10; i12 < i11; i12++) {
            bArr[i12 - i10] = (byte) (dVar.charAt(i12) & 255);
        }
        return bArr;
    }
}
