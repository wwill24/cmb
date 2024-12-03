package io.sentry.vendor.gson.stream;

import com.facebook.internal.ServerProtocol;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final Reader f31746a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f31747b = false;

    /* renamed from: c  reason: collision with root package name */
    private final char[] f31748c = new char[1024];

    /* renamed from: d  reason: collision with root package name */
    private int f31749d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f31750e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f31751f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f31752g = 0;

    /* renamed from: h  reason: collision with root package name */
    int f31753h = 0;

    /* renamed from: j  reason: collision with root package name */
    private long f31754j;

    /* renamed from: k  reason: collision with root package name */
    private int f31755k;

    /* renamed from: l  reason: collision with root package name */
    private String f31756l;

    /* renamed from: m  reason: collision with root package name */
    private int[] f31757m;

    /* renamed from: n  reason: collision with root package name */
    private int f31758n;

    /* renamed from: p  reason: collision with root package name */
    private String[] f31759p;

    /* renamed from: q  reason: collision with root package name */
    private int[] f31760q;

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f31757m = iArr;
        this.f31758n = 0 + 1;
        iArr[0] = 6;
        this.f31759p = new String[32];
        this.f31760q = new int[32];
        if (reader != null) {
            this.f31746a = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    private int C(boolean z10) throws IOException {
        char[] cArr = this.f31748c;
        int i10 = this.f31749d;
        int i11 = this.f31750e;
        while (true) {
            if (i10 == i11) {
                this.f31749d = i10;
                if (k(1)) {
                    i10 = this.f31749d;
                    i11 = this.f31750e;
                } else if (!z10) {
                    return -1;
                } else {
                    throw new EOFException("End of input" + m());
                }
            }
            int i12 = i10 + 1;
            char c10 = cArr[i10];
            if (c10 == 10) {
                this.f31751f++;
                this.f31752g = i12;
            } else if (!(c10 == ' ' || c10 == 13 || c10 == 9)) {
                if (c10 == '/') {
                    this.f31749d = i12;
                    if (i12 == i11) {
                        this.f31749d = i12 - 1;
                        boolean k10 = k(2);
                        this.f31749d++;
                        if (!k10) {
                            return c10;
                        }
                    }
                    c();
                    int i13 = this.f31749d;
                    char c11 = cArr[i13];
                    if (c11 == '*') {
                        this.f31749d = i13 + 1;
                        if (Y("*/")) {
                            i10 = this.f31749d + 2;
                            i11 = this.f31750e;
                        } else {
                            throw i0("Unterminated comment");
                        }
                    } else if (c11 != '/') {
                        return c10;
                    } else {
                        this.f31749d = i13 + 1;
                        c0();
                        i10 = this.f31749d;
                        i11 = this.f31750e;
                    }
                } else if (c10 == '#') {
                    this.f31749d = i12;
                    c();
                    c0();
                    i10 = this.f31749d;
                    i11 = this.f31750e;
                } else {
                    this.f31749d = i12;
                    return c10;
                }
            }
            i10 = i12;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        if (r1 != null) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
        r1.append(r0, r3, r2 - r3);
        r9.f31749d = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String F(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.f31748c
            r1 = 0
        L_0x0003:
            int r2 = r9.f31749d
            int r3 = r9.f31750e
        L_0x0007:
            r4 = r3
            r3 = r2
        L_0x0009:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L_0x005c
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L_0x0028
            r9.f31749d = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L_0x0020
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r3, r7)
            return r10
        L_0x0020:
            r1.append(r0, r3, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L_0x0028:
            r8 = 92
            if (r2 != r8) goto L_0x004f
            r9.f31749d = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L_0x0040
            int r1 = r7 + 1
            int r1 = r1 * 2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r2.<init>(r1)
            r1 = r2
        L_0x0040:
            r1.append(r0, r3, r7)
            char r2 = r9.P()
            r1.append(r2)
            int r2 = r9.f31749d
            int r3 = r9.f31750e
            goto L_0x0007
        L_0x004f:
            r5 = 10
            if (r2 != r5) goto L_0x005a
            int r2 = r9.f31751f
            int r2 = r2 + r6
            r9.f31751f = r2
            r9.f31752g = r7
        L_0x005a:
            r2 = r7
            goto L_0x0009
        L_0x005c:
            if (r1 != 0) goto L_0x006c
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L_0x006c:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.f31749d = r2
            boolean r2 = r9.k(r6)
            if (r2 == 0) goto L_0x007a
            goto L_0x0003
        L_0x007a:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.i0(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.gson.stream.a.F(char):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        c();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String I() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            r2 = r0
        L_0x0003:
            int r3 = r6.f31749d
            int r4 = r3 + r2
            int r5 = r6.f31750e
            if (r4 >= r5) goto L_0x004e
            char[] r4 = r6.f31748c
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L_0x005c
            r4 = 10
            if (r3 == r4) goto L_0x005c
            r4 = 12
            if (r3 == r4) goto L_0x005c
            r4 = 13
            if (r3 == r4) goto L_0x005c
            r4 = 32
            if (r3 == r4) goto L_0x005c
            r4 = 35
            if (r3 == r4) goto L_0x004a
            r4 = 44
            if (r3 == r4) goto L_0x005c
            r4 = 47
            if (r3 == r4) goto L_0x004a
            r4 = 61
            if (r3 == r4) goto L_0x004a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 58
            if (r3 == r4) goto L_0x005c
            r4 = 59
            if (r3 == r4) goto L_0x004a
            switch(r3) {
                case 91: goto L_0x005c;
                case 92: goto L_0x004a;
                case 93: goto L_0x005c;
                default: goto L_0x0047;
            }
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x004a:
            r6.c()
            goto L_0x005c
        L_0x004e:
            char[] r3 = r6.f31748c
            int r3 = r3.length
            if (r2 >= r3) goto L_0x005e
            int r3 = r2 + 1
            boolean r3 = r6.k(r3)
            if (r3 == 0) goto L_0x005c
            goto L_0x0003
        L_0x005c:
            r0 = r2
            goto L_0x007e
        L_0x005e:
            if (r1 != 0) goto L_0x006b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L_0x006b:
            char[] r3 = r6.f31748c
            int r4 = r6.f31749d
            r1.append(r3, r4, r2)
            int r3 = r6.f31749d
            int r3 = r3 + r2
            r6.f31749d = r3
            r2 = 1
            boolean r2 = r6.k(r2)
            if (r2 != 0) goto L_0x0002
        L_0x007e:
            if (r1 != 0) goto L_0x008a
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f31748c
            int r3 = r6.f31749d
            r1.<init>(r2, r3, r0)
            goto L_0x0095
        L_0x008a:
            char[] r2 = r6.f31748c
            int r3 = r6.f31749d
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L_0x0095:
            int r2 = r6.f31749d
            int r2 = r2 + r0
            r6.f31749d = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.gson.stream.a.I():java.lang.String");
    }

    private int L() throws IOException {
        String str;
        String str2;
        int i10;
        char c10 = this.f31748c[this.f31749d];
        if (c10 == 't' || c10 == 'T') {
            i10 = 5;
            str2 = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            str = "TRUE";
        } else if (c10 == 'f' || c10 == 'F') {
            i10 = 6;
            str2 = "false";
            str = "FALSE";
        } else if (c10 != 'n' && c10 != 'N') {
            return 0;
        } else {
            i10 = 7;
            str2 = "null";
            str = "NULL";
        }
        int length = str2.length();
        for (int i11 = 1; i11 < length; i11++) {
            if (this.f31749d + i11 >= this.f31750e && !k(i11 + 1)) {
                return 0;
            }
            char c11 = this.f31748c[this.f31749d + i11];
            if (c11 != str2.charAt(i11) && c11 != str.charAt(i11)) {
                return 0;
            }
        }
        if ((this.f31749d + length < this.f31750e || k(length + 1)) && l(this.f31748c[this.f31749d + length])) {
            return 0;
        }
        this.f31749d += length;
        this.f31753h = i10;
        return i10;
    }

    private int N() throws IOException {
        char c10;
        boolean z10;
        char[] cArr = this.f31748c;
        int i10 = this.f31749d;
        int i11 = this.f31750e;
        int i12 = 0;
        boolean z11 = true;
        int i13 = 0;
        char c11 = 0;
        boolean z12 = false;
        long j10 = 0;
        while (true) {
            if (i10 + i13 == i11) {
                if (i13 == cArr.length) {
                    return i12;
                }
                if (!k(i13 + 1)) {
                    break;
                }
                i10 = this.f31749d;
                i11 = this.f31750e;
            }
            c10 = cArr[i10 + i13];
            char c12 = 3;
            if (c10 == '+') {
                c12 = 6;
                i12 = 0;
                if (c11 != 5) {
                    return 0;
                }
            } else if (c10 == 'E' || c10 == 'e') {
                i12 = 0;
                if (c11 != 2 && c11 != 4) {
                    return 0;
                }
                c11 = 5;
                i13++;
            } else if (c10 == '-') {
                c12 = 6;
                i12 = 0;
                if (c11 == 0) {
                    c11 = 1;
                    z12 = true;
                    i13++;
                } else if (c11 != 5) {
                    return 0;
                }
            } else if (c10 == '.') {
                i12 = 0;
                if (c11 != 2) {
                    return 0;
                }
            } else if (c10 >= '0' && c10 <= '9') {
                if (c11 == 1 || c11 == 0) {
                    j10 = (long) (-(c10 - '0'));
                    c11 = 2;
                } else if (c11 != 2) {
                    if (c11 == 3) {
                        i12 = 0;
                        c11 = 4;
                    } else if (c11 == 5 || c11 == 6) {
                        i12 = 0;
                        c11 = 7;
                    }
                    i13++;
                } else if (j10 == 0) {
                    return 0;
                } else {
                    long j11 = (10 * j10) - ((long) (c10 - '0'));
                    int i14 = (j10 > -922337203685477580L ? 1 : (j10 == -922337203685477580L ? 0 : -1));
                    if (i14 > 0 || (i14 == 0 && j11 < j10)) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 &= z10;
                    j10 = j11;
                }
                i12 = 0;
                i13++;
            }
            c11 = c12;
            i13++;
        }
        if (l(c10)) {
            return 0;
        }
        if (c11 == 2 && z11 && ((j10 != Long.MIN_VALUE || z12) && (j10 != 0 || !z12))) {
            if (!z12) {
                j10 = -j10;
            }
            this.f31754j = j10;
            this.f31749d += i13;
            this.f31753h = 15;
            return 15;
        } else if (c11 != 2 && c11 != 4 && c11 != 7) {
            return 0;
        } else {
            this.f31755k = i13;
            this.f31753h = 16;
            return 16;
        }
    }

    private void O(int i10) {
        int i11 = this.f31758n;
        int[] iArr = this.f31757m;
        if (i11 == iArr.length) {
            int i12 = i11 * 2;
            this.f31757m = Arrays.copyOf(iArr, i12);
            this.f31760q = Arrays.copyOf(this.f31760q, i12);
            this.f31759p = (String[]) Arrays.copyOf(this.f31759p, i12);
        }
        int[] iArr2 = this.f31757m;
        int i13 = this.f31758n;
        this.f31758n = i13 + 1;
        iArr2[i13] = i10;
    }

    private char P() throws IOException {
        int i10;
        int i11;
        if (this.f31749d != this.f31750e || k(1)) {
            char[] cArr = this.f31748c;
            int i12 = this.f31749d;
            int i13 = i12 + 1;
            this.f31749d = i13;
            char c10 = cArr[i12];
            if (c10 == 10) {
                this.f31751f++;
                this.f31752g = i13;
            } else if (!(c10 == '\"' || c10 == '\'' || c10 == '/' || c10 == '\\')) {
                if (c10 == 'b') {
                    return 8;
                }
                if (c10 == 'f') {
                    return 12;
                }
                if (c10 == 'n') {
                    return 10;
                }
                if (c10 == 'r') {
                    return 13;
                }
                if (c10 == 't') {
                    return 9;
                }
                if (c10 != 'u') {
                    throw i0("Invalid escape sequence");
                } else if (i13 + 4 <= this.f31750e || k(4)) {
                    char c11 = 0;
                    int i14 = this.f31749d;
                    int i15 = i14 + 4;
                    while (i14 < i15) {
                        char c12 = this.f31748c[i14];
                        char c13 = (char) (c11 << 4);
                        if (c12 < '0' || c12 > '9') {
                            if (c12 >= 'a' && c12 <= 'f') {
                                i10 = c12 - 'a';
                            } else if (c12 < 'A' || c12 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.f31748c, this.f31749d, 4));
                            } else {
                                i10 = c12 - 'A';
                            }
                            i11 = i10 + 10;
                        } else {
                            i11 = c12 - '0';
                        }
                        c11 = (char) (c13 + i11);
                        i14++;
                    }
                    this.f31749d += 4;
                    return c11;
                } else {
                    throw i0("Unterminated escape sequence");
                }
            }
            return c10;
        }
        throw i0("Unterminated escape sequence");
    }

    private void S(char c10) throws IOException {
        char[] cArr = this.f31748c;
        do {
            int i10 = this.f31749d;
            int i11 = this.f31750e;
            while (i10 < i11) {
                int i12 = i10 + 1;
                char c11 = cArr[i10];
                if (c11 == c10) {
                    this.f31749d = i12;
                    return;
                } else if (c11 == '\\') {
                    this.f31749d = i12;
                    P();
                    i10 = this.f31749d;
                    i11 = this.f31750e;
                } else {
                    if (c11 == 10) {
                        this.f31751f++;
                        this.f31752g = i12;
                    }
                    i10 = i12;
                }
            }
            this.f31749d = i10;
        } while (k(1));
        throw i0("Unterminated string");
    }

    private boolean Y(String str) throws IOException {
        int length = str.length();
        while (true) {
            int i10 = 0;
            if (this.f31749d + length > this.f31750e && !k(length)) {
                return false;
            }
            char[] cArr = this.f31748c;
            int i11 = this.f31749d;
            if (cArr[i11] == 10) {
                this.f31751f++;
                this.f31752g = i11 + 1;
            } else {
                while (i10 < length) {
                    if (this.f31748c[this.f31749d + i10] == str.charAt(i10)) {
                        i10++;
                    }
                }
                return true;
            }
            this.f31749d++;
        }
    }

    private void c() throws IOException {
        if (!this.f31747b) {
            throw i0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void c0() throws IOException {
        char c10;
        do {
            if (this.f31749d < this.f31750e || k(1)) {
                char[] cArr = this.f31748c;
                int i10 = this.f31749d;
                int i11 = i10 + 1;
                this.f31749d = i11;
                c10 = cArr[i10];
                if (c10 == 10) {
                    this.f31751f++;
                    this.f31752g = i11;
                    return;
                }
            } else {
                return;
            }
        } while (c10 != 13);
    }

    private void e() throws IOException {
        C(true);
        int i10 = this.f31749d - 1;
        this.f31749d = i10;
        if (i10 + 5 <= this.f31750e || k(5)) {
            char[] cArr = this.f31748c;
            if (cArr[i10] == ')' && cArr[i10 + 1] == ']' && cArr[i10 + 2] == '}' && cArr[i10 + 3] == '\'' && cArr[i10 + 4] == 10) {
                this.f31749d += 5;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0048, code lost:
        c();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void e0() throws java.io.IOException {
        /*
            r4 = this;
        L_0x0000:
            r0 = 0
        L_0x0001:
            int r1 = r4.f31749d
            int r2 = r1 + r0
            int r3 = r4.f31750e
            if (r2 >= r3) goto L_0x0051
            char[] r2 = r4.f31748c
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L_0x004b
            r2 = 10
            if (r1 == r2) goto L_0x004b
            r2 = 12
            if (r1 == r2) goto L_0x004b
            r2 = 13
            if (r1 == r2) goto L_0x004b
            r2 = 32
            if (r1 == r2) goto L_0x004b
            r2 = 35
            if (r1 == r2) goto L_0x0048
            r2 = 44
            if (r1 == r2) goto L_0x004b
            r2 = 47
            if (r1 == r2) goto L_0x0048
            r2 = 61
            if (r1 == r2) goto L_0x0048
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 58
            if (r1 == r2) goto L_0x004b
            r2 = 59
            if (r1 == r2) goto L_0x0048
            switch(r1) {
                case 91: goto L_0x004b;
                case 92: goto L_0x0048;
                case 93: goto L_0x004b;
                default: goto L_0x0045;
            }
        L_0x0045:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0048:
            r4.c()
        L_0x004b:
            int r1 = r4.f31749d
            int r1 = r1 + r0
            r4.f31749d = r1
            return
        L_0x0051:
            int r1 = r1 + r0
            r4.f31749d = r1
            r0 = 1
            boolean r0 = r4.k(r0)
            if (r0 != 0) goto L_0x0000
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.vendor.gson.stream.a.e0():void");
    }

    private IOException i0(String str) throws IOException {
        throw new MalformedJsonException(str + m());
    }

    private boolean k(int i10) throws IOException {
        int i11;
        int i12;
        char[] cArr = this.f31748c;
        int i13 = this.f31752g;
        int i14 = this.f31749d;
        this.f31752g = i13 - i14;
        int i15 = this.f31750e;
        if (i15 != i14) {
            int i16 = i15 - i14;
            this.f31750e = i16;
            System.arraycopy(cArr, i14, cArr, 0, i16);
        } else {
            this.f31750e = 0;
        }
        this.f31749d = 0;
        do {
            Reader reader = this.f31746a;
            int i17 = this.f31750e;
            int read = reader.read(cArr, i17, cArr.length - i17);
            if (read == -1) {
                return false;
            }
            i11 = this.f31750e + read;
            this.f31750e = i11;
            if (this.f31751f == 0 && (i12 = this.f31752g) == 0 && i11 > 0 && cArr[0] == 65279) {
                this.f31749d++;
                this.f31752g = i12 + 1;
                i10++;
                continue;
            }
        } while (i11 < i10);
        return true;
    }

    private boolean l(char c10) throws IOException {
        if (c10 == 9 || c10 == 10 || c10 == 12 || c10 == 13 || c10 == ' ') {
            return false;
        }
        if (c10 != '#') {
            if (c10 == ',') {
                return false;
            }
            if (!(c10 == '/' || c10 == '=')) {
                if (c10 == '{' || c10 == '}' || c10 == ':') {
                    return false;
                }
                if (c10 != ';') {
                    switch (c10) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        c();
        return false;
    }

    public void E() throws IOException {
        int i10 = this.f31753h;
        if (i10 == 0) {
            i10 = f();
        }
        if (i10 == 7) {
            this.f31753h = 0;
            int[] iArr = this.f31760q;
            int i11 = this.f31758n - 1;
            iArr[i11] = iArr[i11] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + J() + m());
    }

    public String G() throws IOException {
        String str;
        int i10 = this.f31753h;
        if (i10 == 0) {
            i10 = f();
        }
        if (i10 == 10) {
            str = I();
        } else if (i10 == 8) {
            str = F('\'');
        } else if (i10 == 9) {
            str = F('\"');
        } else if (i10 == 11) {
            str = this.f31756l;
            this.f31756l = null;
        } else if (i10 == 15) {
            str = Long.toString(this.f31754j);
        } else if (i10 == 16) {
            str = new String(this.f31748c, this.f31749d, this.f31755k);
            this.f31749d += this.f31755k;
        } else {
            throw new IllegalStateException("Expected a string but was " + J() + m());
        }
        this.f31753h = 0;
        int[] iArr = this.f31760q;
        int i11 = this.f31758n - 1;
        iArr[i11] = iArr[i11] + 1;
        return str;
    }

    public JsonToken J() throws IOException {
        int i10 = this.f31753h;
        if (i10 == 0) {
            i10 = f();
        }
        switch (i10) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public void a() throws IOException {
        int i10 = this.f31753h;
        if (i10 == 0) {
            i10 = f();
        }
        if (i10 == 3) {
            O(1);
            this.f31760q[this.f31758n - 1] = 0;
            this.f31753h = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + J() + m());
    }

    public void b() throws IOException {
        int i10 = this.f31753h;
        if (i10 == 0) {
            i10 = f();
        }
        if (i10 == 1) {
            O(3);
            this.f31753h = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + J() + m());
    }

    public void close() throws IOException {
        this.f31753h = 0;
        this.f31757m[0] = 8;
        this.f31758n = 1;
        this.f31746a.close();
    }

    /* access modifiers changed from: package-private */
    public int f() throws IOException {
        int C;
        int[] iArr = this.f31757m;
        int i10 = this.f31758n;
        int i11 = iArr[i10 - 1];
        if (i11 == 1) {
            iArr[i10 - 1] = 2;
        } else if (i11 == 2) {
            int C2 = C(true);
            if (C2 != 44) {
                if (C2 == 59) {
                    c();
                } else if (C2 == 93) {
                    this.f31753h = 4;
                    return 4;
                } else {
                    throw i0("Unterminated array");
                }
            }
        } else if (i11 == 3 || i11 == 5) {
            iArr[i10 - 1] = 4;
            if (i11 == 5 && (C = C(true)) != 44) {
                if (C == 59) {
                    c();
                } else if (C == 125) {
                    this.f31753h = 2;
                    return 2;
                } else {
                    throw i0("Unterminated object");
                }
            }
            int C3 = C(true);
            if (C3 == 34) {
                this.f31753h = 13;
                return 13;
            } else if (C3 == 39) {
                c();
                this.f31753h = 12;
                return 12;
            } else if (C3 != 125) {
                c();
                this.f31749d--;
                if (l((char) C3)) {
                    this.f31753h = 14;
                    return 14;
                }
                throw i0("Expected name");
            } else if (i11 != 5) {
                this.f31753h = 2;
                return 2;
            } else {
                throw i0("Expected name");
            }
        } else if (i11 == 4) {
            iArr[i10 - 1] = 5;
            int C4 = C(true);
            if (C4 != 58) {
                if (C4 == 61) {
                    c();
                    if (this.f31749d < this.f31750e || k(1)) {
                        char[] cArr = this.f31748c;
                        int i12 = this.f31749d;
                        if (cArr[i12] == '>') {
                            this.f31749d = i12 + 1;
                        }
                    }
                } else {
                    throw i0("Expected ':'");
                }
            }
        } else if (i11 == 6) {
            if (this.f31747b) {
                e();
            }
            this.f31757m[this.f31758n - 1] = 7;
        } else if (i11 == 7) {
            if (C(false) == -1) {
                this.f31753h = 17;
                return 17;
            }
            c();
            this.f31749d--;
        } else if (i11 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int C5 = C(true);
        if (C5 == 34) {
            this.f31753h = 9;
            return 9;
        } else if (C5 != 39) {
            if (!(C5 == 44 || C5 == 59)) {
                if (C5 == 91) {
                    this.f31753h = 3;
                    return 3;
                } else if (C5 != 93) {
                    if (C5 != 123) {
                        this.f31749d--;
                        int L = L();
                        if (L != 0) {
                            return L;
                        }
                        int N = N();
                        if (N != 0) {
                            return N;
                        }
                        if (l(this.f31748c[this.f31749d])) {
                            c();
                            this.f31753h = 10;
                            return 10;
                        }
                        throw i0("Expected value");
                    }
                    this.f31753h = 1;
                    return 1;
                } else if (i11 == 1) {
                    this.f31753h = 4;
                    return 4;
                }
            }
            if (i11 == 1 || i11 == 2) {
                c();
                this.f31749d--;
                this.f31753h = 7;
                return 7;
            }
            throw i0("Unexpected value");
        } else {
            c();
            this.f31753h = 8;
            return 8;
        }
    }

    public void f0() throws IOException {
        int i10 = 0;
        do {
            int i11 = this.f31753h;
            if (i11 == 0) {
                i11 = f();
            }
            if (i11 == 3) {
                O(1);
            } else if (i11 == 1) {
                O(3);
            } else {
                if (i11 == 4) {
                    this.f31758n--;
                } else if (i11 == 2) {
                    this.f31758n--;
                } else if (i11 == 14 || i11 == 10) {
                    e0();
                    this.f31753h = 0;
                } else if (i11 == 8 || i11 == 12) {
                    S('\'');
                    this.f31753h = 0;
                } else if (i11 == 9 || i11 == 13) {
                    S('\"');
                    this.f31753h = 0;
                } else {
                    if (i11 == 16) {
                        this.f31749d += this.f31755k;
                    }
                    this.f31753h = 0;
                }
                i10--;
                this.f31753h = 0;
            }
            i10++;
            this.f31753h = 0;
        } while (i10 != 0);
        int[] iArr = this.f31760q;
        int i12 = this.f31758n;
        int i13 = i12 - 1;
        iArr[i13] = iArr[i13] + 1;
        this.f31759p[i12 - 1] = "null";
    }

    public void g() throws IOException {
        int i10 = this.f31753h;
        if (i10 == 0) {
            i10 = f();
        }
        if (i10 == 4) {
            int i11 = this.f31758n - 1;
            this.f31758n = i11;
            int[] iArr = this.f31760q;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
            this.f31753h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + J() + m());
    }

    public String getPath() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('$');
        int i10 = this.f31758n;
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = this.f31757m[i11];
            if (i12 == 1 || i12 == 2) {
                sb2.append('[');
                sb2.append(this.f31760q[i11]);
                sb2.append(PropertyUtils.INDEXED_DELIM2);
            } else if (i12 == 3 || i12 == 4 || i12 == 5) {
                sb2.append('.');
                String str = this.f31759p[i11];
                if (str != null) {
                    sb2.append(str);
                }
            }
        }
        return sb2.toString();
    }

    public void h() throws IOException {
        int i10 = this.f31753h;
        if (i10 == 0) {
            i10 = f();
        }
        if (i10 == 2) {
            int i11 = this.f31758n - 1;
            this.f31758n = i11;
            this.f31759p[i11] = null;
            int[] iArr = this.f31760q;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
            this.f31753h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + J() + m());
    }

    /* access modifiers changed from: package-private */
    public String m() {
        return " at line " + (this.f31751f + 1) + " column " + ((this.f31749d - this.f31752g) + 1) + " path " + getPath();
    }

    public boolean n() throws IOException {
        int i10 = this.f31753h;
        if (i10 == 0) {
            i10 = f();
        }
        if (i10 == 5) {
            this.f31753h = 0;
            int[] iArr = this.f31760q;
            int i11 = this.f31758n - 1;
            iArr[i11] = iArr[i11] + 1;
            return true;
        } else if (i10 == 6) {
            this.f31753h = 0;
            int[] iArr2 = this.f31760q;
            int i12 = this.f31758n - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + J() + m());
        }
    }

    public String toString() {
        return getClass().getSimpleName() + m();
    }

    public double u() throws IOException {
        char c10;
        int i10 = this.f31753h;
        if (i10 == 0) {
            i10 = f();
        }
        if (i10 == 15) {
            this.f31753h = 0;
            int[] iArr = this.f31760q;
            int i11 = this.f31758n - 1;
            iArr[i11] = iArr[i11] + 1;
            return (double) this.f31754j;
        }
        if (i10 == 16) {
            this.f31756l = new String(this.f31748c, this.f31749d, this.f31755k);
            this.f31749d += this.f31755k;
        } else if (i10 == 8 || i10 == 9) {
            if (i10 == 8) {
                c10 = '\'';
            } else {
                c10 = '\"';
            }
            this.f31756l = F(c10);
        } else if (i10 == 10) {
            this.f31756l = I();
        } else if (i10 != 11) {
            throw new IllegalStateException("Expected a double but was " + J() + m());
        }
        this.f31753h = 11;
        double parseDouble = Double.parseDouble(this.f31756l);
        if (this.f31747b || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.f31756l = null;
            this.f31753h = 0;
            int[] iArr2 = this.f31760q;
            int i12 = this.f31758n - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return parseDouble;
        }
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + m());
    }

    public int v() throws IOException {
        char c10;
        int i10 = this.f31753h;
        if (i10 == 0) {
            i10 = f();
        }
        if (i10 == 15) {
            long j10 = this.f31754j;
            int i11 = (int) j10;
            if (j10 == ((long) i11)) {
                this.f31753h = 0;
                int[] iArr = this.f31760q;
                int i12 = this.f31758n - 1;
                iArr[i12] = iArr[i12] + 1;
                return i11;
            }
            throw new NumberFormatException("Expected an int but was " + this.f31754j + m());
        }
        if (i10 == 16) {
            this.f31756l = new String(this.f31748c, this.f31749d, this.f31755k);
            this.f31749d += this.f31755k;
        } else if (i10 == 8 || i10 == 9 || i10 == 10) {
            if (i10 == 10) {
                this.f31756l = I();
            } else {
                if (i10 == 8) {
                    c10 = '\'';
                } else {
                    c10 = '\"';
                }
                this.f31756l = F(c10);
            }
            try {
                int parseInt = Integer.parseInt(this.f31756l);
                this.f31753h = 0;
                int[] iArr2 = this.f31760q;
                int i13 = this.f31758n - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + J() + m());
        }
        this.f31753h = 11;
        double parseDouble = Double.parseDouble(this.f31756l);
        int i14 = (int) parseDouble;
        if (((double) i14) == parseDouble) {
            this.f31756l = null;
            this.f31753h = 0;
            int[] iArr3 = this.f31760q;
            int i15 = this.f31758n - 1;
            iArr3[i15] = iArr3[i15] + 1;
            return i14;
        }
        throw new NumberFormatException("Expected an int but was " + this.f31756l + m());
    }

    public long x() throws IOException {
        char c10;
        int i10 = this.f31753h;
        if (i10 == 0) {
            i10 = f();
        }
        if (i10 == 15) {
            this.f31753h = 0;
            int[] iArr = this.f31760q;
            int i11 = this.f31758n - 1;
            iArr[i11] = iArr[i11] + 1;
            return this.f31754j;
        }
        if (i10 == 16) {
            this.f31756l = new String(this.f31748c, this.f31749d, this.f31755k);
            this.f31749d += this.f31755k;
        } else if (i10 == 8 || i10 == 9 || i10 == 10) {
            if (i10 == 10) {
                this.f31756l = I();
            } else {
                if (i10 == 8) {
                    c10 = '\'';
                } else {
                    c10 = '\"';
                }
                this.f31756l = F(c10);
            }
            try {
                long parseLong = Long.parseLong(this.f31756l);
                this.f31753h = 0;
                int[] iArr2 = this.f31760q;
                int i12 = this.f31758n - 1;
                iArr2[i12] = iArr2[i12] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + J() + m());
        }
        this.f31753h = 11;
        double parseDouble = Double.parseDouble(this.f31756l);
        long j10 = (long) parseDouble;
        if (((double) j10) == parseDouble) {
            this.f31756l = null;
            this.f31753h = 0;
            int[] iArr3 = this.f31760q;
            int i13 = this.f31758n - 1;
            iArr3[i13] = iArr3[i13] + 1;
            return j10;
        }
        throw new NumberFormatException("Expected a long but was " + this.f31756l + m());
    }

    public String y() throws IOException {
        String str;
        int i10 = this.f31753h;
        if (i10 == 0) {
            i10 = f();
        }
        if (i10 == 14) {
            str = I();
        } else if (i10 == 12) {
            str = F('\'');
        } else if (i10 == 13) {
            str = F('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + J() + m());
        }
        this.f31753h = 0;
        this.f31759p[this.f31758n - 1] = str;
        return str;
    }
}
