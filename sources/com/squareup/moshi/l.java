package com.squareup.moshi;

import com.facebook.internal.ServerProtocol;
import com.squareup.moshi.JsonReader;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

final class l extends JsonReader {

    /* renamed from: p  reason: collision with root package name */
    private static final ByteString f22964p = ByteString.e("'\\");

    /* renamed from: q  reason: collision with root package name */
    private static final ByteString f22965q = ByteString.e("\"\\");

    /* renamed from: t  reason: collision with root package name */
    private static final ByteString f22966t = ByteString.e("{}[]:, \n\t\r\f/\\;#=");

    /* renamed from: w  reason: collision with root package name */
    private static final ByteString f22967w = ByteString.e("\n\r");

    /* renamed from: x  reason: collision with root package name */
    private static final ByteString f22968x = ByteString.e("*/");

    /* renamed from: g  reason: collision with root package name */
    private final BufferedSource f22969g;

    /* renamed from: h  reason: collision with root package name */
    private final Buffer f22970h;

    /* renamed from: j  reason: collision with root package name */
    private int f22971j = 0;

    /* renamed from: k  reason: collision with root package name */
    private long f22972k;

    /* renamed from: l  reason: collision with root package name */
    private int f22973l;

    /* renamed from: m  reason: collision with root package name */
    private String f22974m;

    /* renamed from: n  reason: collision with root package name */
    private o f22975n;

    l(BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            this.f22969g = bufferedSource;
            this.f22970h = bufferedSource.d();
            I(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    private char A0() throws IOException {
        int i10;
        int i11;
        if (this.f22969g.r(1)) {
            byte readByte = this.f22970h.readByte();
            if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
                return (char) readByte;
            }
            if (readByte == 98) {
                return 8;
            }
            if (readByte == 102) {
                return 12;
            }
            if (readByte == 110) {
                return 10;
            }
            if (readByte == 114) {
                return 13;
            }
            if (readByte == 116) {
                return 9;
            }
            if (readByte != 117) {
                if (this.f22868e) {
                    return (char) readByte;
                }
                throw c0("Invalid escape sequence: \\" + ((char) readByte));
            } else if (this.f22969g.r(4)) {
                char c10 = 0;
                for (int i12 = 0; i12 < 4; i12++) {
                    byte l10 = this.f22970h.l((long) i12);
                    char c11 = (char) (c10 << 4);
                    if (l10 < 48 || l10 > 57) {
                        if (l10 >= 97 && l10 <= 102) {
                            i10 = l10 - 97;
                        } else if (l10 < 65 || l10 > 70) {
                            throw c0("\\u" + this.f22970h.L0(4));
                        } else {
                            i10 = l10 - 65;
                        }
                        i11 = i10 + 10;
                    } else {
                        i11 = l10 - 48;
                    }
                    c10 = (char) (c11 + i11);
                }
                this.f22970h.skip(4);
                return c10;
            } else {
                throw new EOFException("Unterminated escape sequence at path " + getPath());
            }
        } else {
            throw c0("Unterminated escape sequence");
        }
    }

    private void B0(ByteString byteString) throws IOException {
        while (true) {
            long U = this.f22969g.U(byteString);
            if (U == -1) {
                throw c0("Unterminated string");
            } else if (this.f22970h.l(U) == 92) {
                this.f22970h.skip(U + 1);
                A0();
            } else {
                this.f22970h.skip(U + 1);
                return;
            }
        }
    }

    private boolean E0() throws IOException {
        boolean z10;
        long j10;
        BufferedSource bufferedSource = this.f22969g;
        ByteString byteString = f22968x;
        long M = bufferedSource.M(byteString);
        if (M != -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Buffer buffer = this.f22970h;
        if (z10) {
            j10 = M + ((long) byteString.H());
        } else {
            j10 = buffer.size();
        }
        buffer.skip(j10);
        return z10;
    }

    private void H0() throws IOException {
        long j10;
        long U = this.f22969g.U(f22967w);
        Buffer buffer = this.f22970h;
        if (U != -1) {
            j10 = U + 1;
        } else {
            j10 = buffer.size();
        }
        buffer.skip(j10);
    }

    private void I0() throws IOException {
        long U = this.f22969g.U(f22966t);
        Buffer buffer = this.f22970h;
        if (U == -1) {
            U = buffer.size();
        }
        buffer.skip(U);
    }

    private void f0() throws IOException {
        if (!this.f22868e) {
            throw c0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int i0() throws IOException {
        int[] iArr = this.f22865b;
        int i10 = this.f22864a;
        int i11 = iArr[i10 - 1];
        if (i11 == 1) {
            iArr[i10 - 1] = 2;
        } else if (i11 == 2) {
            int s02 = s0(true);
            this.f22970h.readByte();
            if (s02 != 44) {
                if (s02 == 59) {
                    f0();
                } else if (s02 == 93) {
                    this.f22971j = 4;
                    return 4;
                } else {
                    throw c0("Unterminated array");
                }
            }
        } else if (i11 == 3 || i11 == 5) {
            iArr[i10 - 1] = 4;
            if (i11 == 5) {
                int s03 = s0(true);
                this.f22970h.readByte();
                if (s03 != 44) {
                    if (s03 == 59) {
                        f0();
                    } else if (s03 == 125) {
                        this.f22971j = 2;
                        return 2;
                    } else {
                        throw c0("Unterminated object");
                    }
                }
            }
            int s04 = s0(true);
            if (s04 == 34) {
                this.f22970h.readByte();
                this.f22971j = 13;
                return 13;
            } else if (s04 == 39) {
                this.f22970h.readByte();
                f0();
                this.f22971j = 12;
                return 12;
            } else if (s04 != 125) {
                f0();
                if (r0((char) s04)) {
                    this.f22971j = 14;
                    return 14;
                }
                throw c0("Expected name");
            } else if (i11 != 5) {
                this.f22970h.readByte();
                this.f22971j = 2;
                return 2;
            } else {
                throw c0("Expected name");
            }
        } else if (i11 == 4) {
            iArr[i10 - 1] = 5;
            int s05 = s0(true);
            this.f22970h.readByte();
            if (s05 != 58) {
                if (s05 == 61) {
                    f0();
                    if (this.f22969g.r(1) && this.f22970h.l(0) == 62) {
                        this.f22970h.readByte();
                    }
                } else {
                    throw c0("Expected ':'");
                }
            }
        } else if (i11 == 6) {
            iArr[i10 - 1] = 7;
        } else if (i11 == 7) {
            if (s0(false) == -1) {
                this.f22971j = 18;
                return 18;
            }
            f0();
        } else if (i11 == 9) {
            this.f22975n.b();
            this.f22975n = null;
            this.f22864a--;
            return i0();
        } else if (i11 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int s06 = s0(true);
        if (s06 == 34) {
            this.f22970h.readByte();
            this.f22971j = 9;
            return 9;
        } else if (s06 != 39) {
            if (!(s06 == 44 || s06 == 59)) {
                if (s06 == 91) {
                    this.f22970h.readByte();
                    this.f22971j = 3;
                    return 3;
                } else if (s06 != 93) {
                    if (s06 != 123) {
                        int v02 = v0();
                        if (v02 != 0) {
                            return v02;
                        }
                        int x02 = x0();
                        if (x02 != 0) {
                            return x02;
                        }
                        if (r0(this.f22970h.l(0))) {
                            f0();
                            this.f22971j = 10;
                            return 10;
                        }
                        throw c0("Expected value");
                    }
                    this.f22970h.readByte();
                    this.f22971j = 1;
                    return 1;
                } else if (i11 == 1) {
                    this.f22970h.readByte();
                    this.f22971j = 4;
                    return 4;
                }
            }
            if (i11 == 1 || i11 == 2) {
                f0();
                this.f22971j = 7;
                return 7;
            }
            throw c0("Unexpected value");
        } else {
            f0();
            this.f22970h.readByte();
            this.f22971j = 8;
            return 8;
        }
    }

    private int m0(String str, JsonReader.b bVar) {
        int length = bVar.f22882a.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (str.equals(bVar.f22882a[i10])) {
                this.f22971j = 0;
                this.f22866c[this.f22864a - 1] = str;
                return i10;
            }
        }
        return -1;
    }

    private int q0(String str, JsonReader.b bVar) {
        int length = bVar.f22882a.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (str.equals(bVar.f22882a[i10])) {
                this.f22971j = 0;
                int[] iArr = this.f22867d;
                int i11 = this.f22864a - 1;
                iArr[i11] = iArr[i11] + 1;
                return i10;
            }
        }
        return -1;
    }

    private boolean r0(int i10) throws IOException {
        if (i10 == 9 || i10 == 10 || i10 == 12 || i10 == 13 || i10 == 32) {
            return false;
        }
        if (i10 != 35) {
            if (i10 == 44) {
                return false;
            }
            if (!(i10 == 47 || i10 == 61)) {
                if (i10 == 123 || i10 == 125 || i10 == 58) {
                    return false;
                }
                if (i10 != 59) {
                    switch (i10) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        f0();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        r6.f22970h.skip((long) (r3 - 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        if (r1 != 47) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r6.f22969g.r(2) != false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        f0();
        r3 = r6.f22970h.l(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0049, code lost:
        if (r3 == 42) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        if (r3 == 47) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004e, code lost:
        r6.f22970h.readByte();
        r6.f22970h.readByte();
        H0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        r6.f22970h.readByte();
        r6.f22970h.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
        if (E0() == false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
        throw c0("Unterminated comment");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
        if (r1 != 35) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0078, code lost:
        f0();
        H0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007f, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int s0(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L_0x0001:
            r1 = r0
        L_0x0002:
            okio.BufferedSource r2 = r6.f22969g
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.r(r4)
            if (r2 == 0) goto L_0x0082
            okio.Buffer r2 = r6.f22970h
            long r4 = (long) r1
            byte r1 = r2.l(r4)
            r2 = 10
            if (r1 == r2) goto L_0x0080
            r2 = 32
            if (r1 == r2) goto L_0x0080
            r2 = 13
            if (r1 == r2) goto L_0x0080
            r2 = 9
            if (r1 != r2) goto L_0x0025
            goto L_0x0080
        L_0x0025:
            okio.Buffer r2 = r6.f22970h
            int r3 = r3 + -1
            long r3 = (long) r3
            r2.skip(r3)
            r2 = 47
            if (r1 != r2) goto L_0x0074
            okio.BufferedSource r3 = r6.f22969g
            r4 = 2
            boolean r3 = r3.r(r4)
            if (r3 != 0) goto L_0x003c
            return r1
        L_0x003c:
            r6.f0()
            okio.Buffer r3 = r6.f22970h
            r4 = 1
            byte r3 = r3.l(r4)
            r4 = 42
            if (r3 == r4) goto L_0x005c
            if (r3 == r2) goto L_0x004e
            return r1
        L_0x004e:
            okio.Buffer r1 = r6.f22970h
            r1.readByte()
            okio.Buffer r1 = r6.f22970h
            r1.readByte()
            r6.H0()
            goto L_0x0001
        L_0x005c:
            okio.Buffer r1 = r6.f22970h
            r1.readByte()
            okio.Buffer r1 = r6.f22970h
            r1.readByte()
            boolean r1 = r6.E0()
            if (r1 == 0) goto L_0x006d
            goto L_0x0001
        L_0x006d:
            java.lang.String r7 = "Unterminated comment"
            com.squareup.moshi.JsonEncodingException r7 = r6.c0(r7)
            throw r7
        L_0x0074:
            r2 = 35
            if (r1 != r2) goto L_0x007f
            r6.f0()
            r6.H0()
            goto L_0x0001
        L_0x007f:
            return r1
        L_0x0080:
            r1 = r3
            goto L_0x0002
        L_0x0082:
            if (r7 != 0) goto L_0x0086
            r7 = -1
            return r7
        L_0x0086:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.l.s0(boolean):int");
    }

    private String t0(ByteString byteString) throws IOException {
        StringBuilder sb2 = null;
        while (true) {
            long U = this.f22969g.U(byteString);
            if (U == -1) {
                throw c0("Unterminated string");
            } else if (this.f22970h.l(U) == 92) {
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(this.f22970h.L0(U));
                this.f22970h.readByte();
                sb2.append(A0());
            } else if (sb2 == null) {
                String L0 = this.f22970h.L0(U);
                this.f22970h.readByte();
                return L0;
            } else {
                sb2.append(this.f22970h.L0(U));
                this.f22970h.readByte();
                return sb2.toString();
            }
        }
    }

    private String u0() throws IOException {
        long U = this.f22969g.U(f22966t);
        if (U != -1) {
            return this.f22970h.L0(U);
        }
        return this.f22970h.G();
    }

    private int v0() throws IOException {
        String str;
        String str2;
        int i10;
        byte l10 = this.f22970h.l(0);
        if (l10 == 116 || l10 == 84) {
            i10 = 5;
            str2 = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            str = "TRUE";
        } else if (l10 == 102 || l10 == 70) {
            i10 = 6;
            str2 = "false";
            str = "FALSE";
        } else if (l10 != 110 && l10 != 78) {
            return 0;
        } else {
            i10 = 7;
            str2 = "null";
            str = "NULL";
        }
        int length = str2.length();
        int i11 = 1;
        while (i11 < length) {
            int i12 = i11 + 1;
            if (!this.f22969g.r((long) i12)) {
                return 0;
            }
            byte l11 = this.f22970h.l((long) i11);
            if (l11 != str2.charAt(i11) && l11 != str.charAt(i11)) {
                return 0;
            }
            i11 = i12;
        }
        if (this.f22969g.r((long) (length + 1)) && r0(this.f22970h.l((long) length))) {
            return 0;
        }
        this.f22970h.skip((long) length);
        this.f22971j = i10;
        return i10;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int x0() throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = 0
            r3 = 1
            r4 = 0
            r8 = r1
            r7 = r3
            r5 = r4
            r6 = r5
            r10 = r6
        L_0x000b:
            okio.BufferedSource r11 = r0.f22969g
            int r12 = r5 + 1
            long r13 = (long) r12
            boolean r11 = r11.r(r13)
            r15 = 2
            if (r11 != 0) goto L_0x0019
            goto L_0x0084
        L_0x0019:
            okio.Buffer r11 = r0.f22970h
            long r13 = (long) r5
            byte r11 = r11.l(r13)
            r13 = 43
            r14 = 5
            if (r11 == r13) goto L_0x00d3
            r13 = 69
            if (r11 == r13) goto L_0x00ca
            r13 = 101(0x65, float:1.42E-43)
            if (r11 == r13) goto L_0x00ca
            r13 = 45
            if (r11 == r13) goto L_0x00c0
            r13 = 46
            if (r11 == r13) goto L_0x00bb
            r13 = 48
            if (r11 < r13) goto L_0x007e
            r13 = 57
            if (r11 <= r13) goto L_0x003e
            goto L_0x007e
        L_0x003e:
            if (r6 == r3) goto L_0x0077
            if (r6 != 0) goto L_0x0043
            goto L_0x0077
        L_0x0043:
            if (r6 != r15) goto L_0x0067
            int r5 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x004a
            return r4
        L_0x004a:
            r13 = 10
            long r13 = r13 * r8
            int r11 = r11 + -48
            long r3 = (long) r11
            long r13 = r13 - r3
            r3 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 > 0) goto L_0x0063
            if (r3 != 0) goto L_0x0061
            int r3 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r3 = 0
            goto L_0x0064
        L_0x0063:
            r3 = 1
        L_0x0064:
            r7 = r7 & r3
            r8 = r13
            goto L_0x007c
        L_0x0067:
            r3 = 3
            if (r6 != r3) goto L_0x006e
            r4 = 0
            r6 = 4
            goto L_0x00d7
        L_0x006e:
            if (r6 == r14) goto L_0x0073
            r3 = 6
            if (r6 != r3) goto L_0x007c
        L_0x0073:
            r4 = 0
            r6 = 7
            goto L_0x00d7
        L_0x0077:
            int r11 = r11 + -48
            int r3 = -r11
            long r8 = (long) r3
            r6 = r15
        L_0x007c:
            r4 = 0
            goto L_0x00d7
        L_0x007e:
            boolean r3 = r0.r0(r11)
            if (r3 != 0) goto L_0x00b9
        L_0x0084:
            if (r6 != r15) goto L_0x00a7
            if (r7 == 0) goto L_0x00a7
            r3 = -9223372036854775808
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x0090
            if (r10 == 0) goto L_0x00a7
        L_0x0090:
            int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0096
            if (r10 != 0) goto L_0x00a7
        L_0x0096:
            if (r10 == 0) goto L_0x0099
            goto L_0x009a
        L_0x0099:
            long r8 = -r8
        L_0x009a:
            r0.f22972k = r8
            okio.Buffer r1 = r0.f22970h
            long r2 = (long) r5
            r1.skip(r2)
            r1 = 16
            r0.f22971j = r1
            return r1
        L_0x00a7:
            if (r6 == r15) goto L_0x00b2
            r1 = 4
            if (r6 == r1) goto L_0x00b2
            r1 = 7
            if (r6 != r1) goto L_0x00b0
            goto L_0x00b2
        L_0x00b0:
            r4 = 0
            return r4
        L_0x00b2:
            r0.f22973l = r5
            r1 = 17
            r0.f22971j = r1
            return r1
        L_0x00b9:
            r4 = 0
            return r4
        L_0x00bb:
            r3 = 3
            if (r6 != r15) goto L_0x00bf
            goto L_0x00d6
        L_0x00bf:
            return r4
        L_0x00c0:
            r3 = 6
            if (r6 != 0) goto L_0x00c6
            r6 = 1
            r10 = 1
            goto L_0x00d7
        L_0x00c6:
            if (r6 != r14) goto L_0x00c9
            goto L_0x00d6
        L_0x00c9:
            return r4
        L_0x00ca:
            if (r6 == r15) goto L_0x00d1
            r3 = 4
            if (r6 != r3) goto L_0x00d0
            goto L_0x00d1
        L_0x00d0:
            return r4
        L_0x00d1:
            r6 = r14
            goto L_0x00d7
        L_0x00d3:
            r3 = 6
            if (r6 != r14) goto L_0x00db
        L_0x00d6:
            r6 = r3
        L_0x00d7:
            r5 = r12
            r3 = 1
            goto L_0x000b
        L_0x00db:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.l.x0():int");
    }

    public JsonReader.Token E() throws IOException {
        int i10 = this.f22971j;
        if (i10 == 0) {
            i10 = i0();
        }
        switch (i10) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public JsonReader F() {
        return new l(this);
    }

    public void G() throws IOException {
        if (g()) {
            this.f22974m = u();
            this.f22971j = 11;
        }
    }

    public int L(JsonReader.b bVar) throws IOException {
        int i10 = this.f22971j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 < 12 || i10 > 15) {
            return -1;
        }
        if (i10 == 15) {
            return m0(this.f22974m, bVar);
        }
        int a22 = this.f22969g.a2(bVar.f22883b);
        if (a22 != -1) {
            this.f22971j = 0;
            this.f22866c[this.f22864a - 1] = bVar.f22882a[a22];
            return a22;
        }
        String str = this.f22866c[this.f22864a - 1];
        String u10 = u();
        int m02 = m0(u10, bVar);
        if (m02 == -1) {
            this.f22971j = 15;
            this.f22974m = u10;
            this.f22866c[this.f22864a - 1] = str;
        }
        return m02;
    }

    public int N(JsonReader.b bVar) throws IOException {
        int i10 = this.f22971j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 < 8 || i10 > 11) {
            return -1;
        }
        if (i10 == 11) {
            return q0(this.f22974m, bVar);
        }
        int a22 = this.f22969g.a2(bVar.f22883b);
        if (a22 != -1) {
            this.f22971j = 0;
            int[] iArr = this.f22867d;
            int i11 = this.f22864a - 1;
            iArr[i11] = iArr[i11] + 1;
            return a22;
        }
        String y10 = y();
        int q02 = q0(y10, bVar);
        if (q02 == -1) {
            this.f22971j = 11;
            this.f22974m = y10;
            int[] iArr2 = this.f22867d;
            int i12 = this.f22864a - 1;
            iArr2[i12] = iArr2[i12] - 1;
        }
        return q02;
    }

    public void S() throws IOException {
        if (!this.f22869f) {
            int i10 = this.f22971j;
            if (i10 == 0) {
                i10 = i0();
            }
            if (i10 == 14) {
                I0();
            } else if (i10 == 13) {
                B0(f22965q);
            } else if (i10 == 12) {
                B0(f22964p);
            } else if (i10 != 15) {
                throw new JsonDataException("Expected a name but was " + E() + " at path " + getPath());
            }
            this.f22971j = 0;
            this.f22866c[this.f22864a - 1] = "null";
            return;
        }
        JsonReader.Token E = E();
        u();
        throw new JsonDataException("Cannot skip unexpected " + E + " at " + getPath());
    }

    public void Y() throws IOException {
        if (!this.f22869f) {
            int i10 = 0;
            do {
                int i11 = this.f22971j;
                if (i11 == 0) {
                    i11 = i0();
                }
                if (i11 == 3) {
                    I(1);
                } else if (i11 == 1) {
                    I(3);
                } else {
                    if (i11 == 4) {
                        i10--;
                        if (i10 >= 0) {
                            this.f22864a--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + E() + " at path " + getPath());
                        }
                    } else if (i11 == 2) {
                        i10--;
                        if (i10 >= 0) {
                            this.f22864a--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + E() + " at path " + getPath());
                        }
                    } else if (i11 == 14 || i11 == 10) {
                        I0();
                    } else if (i11 == 9 || i11 == 13) {
                        B0(f22965q);
                    } else if (i11 == 8 || i11 == 12) {
                        B0(f22964p);
                    } else if (i11 == 17) {
                        this.f22970h.skip((long) this.f22973l);
                    } else if (i11 == 18) {
                        throw new JsonDataException("Expected a value but was " + E() + " at path " + getPath());
                    }
                    this.f22971j = 0;
                }
                i10++;
                this.f22971j = 0;
            } while (i10 != 0);
            int[] iArr = this.f22867d;
            int i12 = this.f22864a;
            int i13 = i12 - 1;
            iArr[i13] = iArr[i13] + 1;
            this.f22866c[i12 - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + E() + " at " + getPath());
    }

    public void a() throws IOException {
        int i10 = this.f22971j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 == 3) {
            I(1);
            this.f22867d[this.f22864a - 1] = 0;
            this.f22971j = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_ARRAY but was " + E() + " at path " + getPath());
    }

    public void b() throws IOException {
        int i10 = this.f22971j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 == 1) {
            I(3);
            this.f22971j = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + E() + " at path " + getPath());
    }

    public void c() throws IOException {
        int i10 = this.f22971j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 == 4) {
            int i11 = this.f22864a - 1;
            this.f22864a = i11;
            int[] iArr = this.f22867d;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
            this.f22971j = 0;
            return;
        }
        throw new JsonDataException("Expected END_ARRAY but was " + E() + " at path " + getPath());
    }

    public void close() throws IOException {
        this.f22971j = 0;
        this.f22865b[0] = 8;
        this.f22864a = 1;
        this.f22970h.a();
        this.f22969g.close();
    }

    public void e() throws IOException {
        int i10 = this.f22971j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 == 2) {
            int i11 = this.f22864a - 1;
            this.f22864a = i11;
            this.f22866c[i11] = null;
            int[] iArr = this.f22867d;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
            this.f22971j = 0;
            return;
        }
        throw new JsonDataException("Expected END_OBJECT but was " + E() + " at path " + getPath());
    }

    public boolean g() throws IOException {
        int i10 = this.f22971j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 == 2 || i10 == 4 || i10 == 18) {
            return false;
        }
        return true;
    }

    public boolean k() throws IOException {
        int i10 = this.f22971j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 == 5) {
            this.f22971j = 0;
            int[] iArr = this.f22867d;
            int i11 = this.f22864a - 1;
            iArr[i11] = iArr[i11] + 1;
            return true;
        } else if (i10 == 6) {
            this.f22971j = 0;
            int[] iArr2 = this.f22867d;
            int i12 = this.f22864a - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return false;
        } else {
            throw new JsonDataException("Expected a boolean but was " + E() + " at path " + getPath());
        }
    }

    public double l() throws IOException {
        int i10 = this.f22971j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 == 16) {
            this.f22971j = 0;
            int[] iArr = this.f22867d;
            int i11 = this.f22864a - 1;
            iArr[i11] = iArr[i11] + 1;
            return (double) this.f22972k;
        }
        if (i10 == 17) {
            this.f22974m = this.f22970h.L0((long) this.f22973l);
        } else if (i10 == 9) {
            this.f22974m = t0(f22965q);
        } else if (i10 == 8) {
            this.f22974m = t0(f22964p);
        } else if (i10 == 10) {
            this.f22974m = u0();
        } else if (i10 != 11) {
            throw new JsonDataException("Expected a double but was " + E() + " at path " + getPath());
        }
        this.f22971j = 11;
        try {
            double parseDouble = Double.parseDouble(this.f22974m);
            if (this.f22868e || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
                this.f22974m = null;
                this.f22971j = 0;
                int[] iArr2 = this.f22867d;
                int i12 = this.f22864a - 1;
                iArr2[i12] = iArr2[i12] + 1;
                return parseDouble;
            }
            throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.f22974m + " at path " + getPath());
        }
    }

    public int m() throws IOException {
        String str;
        int i10 = this.f22971j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 == 16) {
            long j10 = this.f22972k;
            int i11 = (int) j10;
            if (j10 == ((long) i11)) {
                this.f22971j = 0;
                int[] iArr = this.f22867d;
                int i12 = this.f22864a - 1;
                iArr[i12] = iArr[i12] + 1;
                return i11;
            }
            throw new JsonDataException("Expected an int but was " + this.f22972k + " at path " + getPath());
        }
        if (i10 == 17) {
            this.f22974m = this.f22970h.L0((long) this.f22973l);
        } else if (i10 == 9 || i10 == 8) {
            if (i10 == 9) {
                str = t0(f22965q);
            } else {
                str = t0(f22964p);
            }
            this.f22974m = str;
            try {
                int parseInt = Integer.parseInt(str);
                this.f22971j = 0;
                int[] iArr2 = this.f22867d;
                int i13 = this.f22864a - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i10 != 11) {
            throw new JsonDataException("Expected an int but was " + E() + " at path " + getPath());
        }
        this.f22971j = 11;
        try {
            double parseDouble = Double.parseDouble(this.f22974m);
            int i14 = (int) parseDouble;
            if (((double) i14) == parseDouble) {
                this.f22974m = null;
                this.f22971j = 0;
                int[] iArr3 = this.f22867d;
                int i15 = this.f22864a - 1;
                iArr3[i15] = iArr3[i15] + 1;
                return i14;
            }
            throw new JsonDataException("Expected an int but was " + this.f22974m + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.f22974m + " at path " + getPath());
        }
    }

    public long n() throws IOException {
        String str;
        int i10 = this.f22971j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 == 16) {
            this.f22971j = 0;
            int[] iArr = this.f22867d;
            int i11 = this.f22864a - 1;
            iArr[i11] = iArr[i11] + 1;
            return this.f22972k;
        }
        if (i10 == 17) {
            this.f22974m = this.f22970h.L0((long) this.f22973l);
        } else if (i10 == 9 || i10 == 8) {
            if (i10 == 9) {
                str = t0(f22965q);
            } else {
                str = t0(f22964p);
            }
            this.f22974m = str;
            try {
                long parseLong = Long.parseLong(str);
                this.f22971j = 0;
                int[] iArr2 = this.f22867d;
                int i12 = this.f22864a - 1;
                iArr2[i12] = iArr2[i12] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else if (i10 != 11) {
            throw new JsonDataException("Expected a long but was " + E() + " at path " + getPath());
        }
        this.f22971j = 11;
        try {
            long longValueExact = new BigDecimal(this.f22974m).longValueExact();
            this.f22974m = null;
            this.f22971j = 0;
            int[] iArr3 = this.f22867d;
            int i13 = this.f22864a - 1;
            iArr3[i13] = iArr3[i13] + 1;
            return longValueExact;
        } catch (ArithmeticException | NumberFormatException unused2) {
            throw new JsonDataException("Expected a long but was " + this.f22974m + " at path " + getPath());
        }
    }

    public String toString() {
        return "JsonReader(" + this.f22969g + ")";
    }

    public String u() throws IOException {
        String str;
        int i10 = this.f22971j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 == 14) {
            str = u0();
        } else if (i10 == 13) {
            str = t0(f22965q);
        } else if (i10 == 12) {
            str = t0(f22964p);
        } else if (i10 == 15) {
            str = this.f22974m;
            this.f22974m = null;
        } else {
            throw new JsonDataException("Expected a name but was " + E() + " at path " + getPath());
        }
        this.f22971j = 0;
        this.f22866c[this.f22864a - 1] = str;
        return str;
    }

    public <T> T v() throws IOException {
        int i10 = this.f22971j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 == 7) {
            this.f22971j = 0;
            int[] iArr = this.f22867d;
            int i11 = this.f22864a - 1;
            iArr[i11] = iArr[i11] + 1;
            return null;
        }
        throw new JsonDataException("Expected null but was " + E() + " at path " + getPath());
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okio.BufferedSource x() throws java.io.IOException {
        /*
            r9 = this;
            int r0 = r9.f22971j
            if (r0 != 0) goto L_0x0008
            int r0 = r9.i0()
        L_0x0008:
            okio.Buffer r1 = new okio.Buffer
            r1.<init>()
            okio.ByteString r2 = com.squareup.moshi.o.f22990n
            r3 = 3
            r4 = 9
            r5 = 0
            r6 = 1
            if (r0 != r3) goto L_0x0020
            java.lang.String r0 = "["
            r1.h0(r0)
            okio.ByteString r2 = com.squareup.moshi.o.f22985h
        L_0x001d:
            r0 = r6
            goto L_0x00b9
        L_0x0020:
            if (r0 != r6) goto L_0x002a
            java.lang.String r0 = "{"
            r1.h0(r0)
            okio.ByteString r2 = com.squareup.moshi.o.f22985h
            goto L_0x001d
        L_0x002a:
            if (r0 != r4) goto L_0x0036
            java.lang.String r0 = "\""
            r1.h0(r0)
            okio.ByteString r2 = com.squareup.moshi.o.f22987k
        L_0x0033:
            r0 = r5
            goto L_0x00b9
        L_0x0036:
            r3 = 8
            if (r0 != r3) goto L_0x0042
            java.lang.String r0 = "'"
            r1.h0(r0)
            okio.ByteString r2 = com.squareup.moshi.o.f22986j
            goto L_0x0033
        L_0x0042:
            r3 = 17
            if (r0 == r3) goto L_0x00b0
            r3 = 16
            if (r0 == r3) goto L_0x00b0
            r3 = 10
            if (r0 != r3) goto L_0x004f
            goto L_0x00b0
        L_0x004f:
            r3 = 5
            if (r0 != r3) goto L_0x0058
            java.lang.String r0 = "true"
            r1.h0(r0)
            goto L_0x0033
        L_0x0058:
            r3 = 6
            if (r0 != r3) goto L_0x0061
            java.lang.String r0 = "false"
            r1.h0(r0)
            goto L_0x0033
        L_0x0061:
            r3 = 7
            if (r0 != r3) goto L_0x006a
            java.lang.String r0 = "null"
            r1.h0(r0)
            goto L_0x0033
        L_0x006a:
            r3 = 11
            if (r0 != r3) goto L_0x0089
            java.lang.String r0 = r9.y()
            com.squareup.moshi.q r3 = com.squareup.moshi.q.x(r1)
            r3.S(r0)     // Catch:{ all -> 0x007d }
            r3.close()
            goto L_0x0033
        L_0x007d:
            r0 = move-exception
            if (r3 == 0) goto L_0x0088
            r3.close()     // Catch:{ all -> 0x0084 }
            goto L_0x0088
        L_0x0084:
            r1 = move-exception
            r0.addSuppressed(r1)
        L_0x0088:
            throw r0
        L_0x0089:
            com.squareup.moshi.JsonDataException r0 = new com.squareup.moshi.JsonDataException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected a value but was "
            r1.append(r2)
            com.squareup.moshi.JsonReader$Token r2 = r9.E()
            r1.append(r2)
            java.lang.String r2 = " at path "
            r1.append(r2)
            java.lang.String r2 = r9.getPath()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00b0:
            java.lang.String r0 = r9.y()
            r1.h0(r0)
            goto L_0x0033
        L_0x00b9:
            int r3 = r9.f22971j
            if (r3 == 0) goto L_0x00c9
            int[] r3 = r9.f22867d
            int r7 = r9.f22864a
            int r7 = r7 - r6
            r8 = r3[r7]
            int r8 = r8 + r6
            r3[r7] = r8
            r9.f22971j = r5
        L_0x00c9:
            com.squareup.moshi.o r3 = new com.squareup.moshi.o
            okio.BufferedSource r5 = r9.f22969g
            r3.<init>(r5, r1, r2, r0)
            r9.f22975n = r3
            r9.I(r4)
            com.squareup.moshi.o r0 = r9.f22975n
            okio.BufferedSource r0 = okio.Okio.c(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.l.x():okio.BufferedSource");
    }

    public String y() throws IOException {
        String str;
        int i10 = this.f22971j;
        if (i10 == 0) {
            i10 = i0();
        }
        if (i10 == 10) {
            str = u0();
        } else if (i10 == 9) {
            str = t0(f22965q);
        } else if (i10 == 8) {
            str = t0(f22964p);
        } else if (i10 == 11) {
            str = this.f22974m;
            this.f22974m = null;
        } else if (i10 == 16) {
            str = Long.toString(this.f22972k);
        } else if (i10 == 17) {
            str = this.f22970h.L0((long) this.f22973l);
        } else {
            throw new JsonDataException("Expected a string but was " + E() + " at path " + getPath());
        }
        this.f22971j = 0;
        int[] iArr = this.f22867d;
        int i11 = this.f22864a - 1;
        iArr[i11] = iArr[i11] + 1;
        return str;
    }

    l(l lVar) {
        super(lVar);
        BufferedSource peek = lVar.f22969g.peek();
        this.f22969g = peek;
        this.f22970h = peek.d();
        this.f22971j = lVar.f22971j;
        this.f22972k = lVar.f22972k;
        this.f22973l = lVar.f22973l;
        this.f22974m = lVar.f22974m;
        try {
            peek.G0(lVar.f22970h.size());
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }
}
