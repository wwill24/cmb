package com.airbnb.lottie.parser.moshi;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.facebook.internal.ServerProtocol;
import java.io.EOFException;
import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

final class b extends JsonReader {

    /* renamed from: p  reason: collision with root package name */
    private static final ByteString f8815p = ByteString.e("'\\");

    /* renamed from: q  reason: collision with root package name */
    private static final ByteString f8816q = ByteString.e("\"\\");

    /* renamed from: t  reason: collision with root package name */
    private static final ByteString f8817t = ByteString.e("{}[]:, \n\t\r\f/\\;#=");

    /* renamed from: w  reason: collision with root package name */
    private static final ByteString f8818w = ByteString.e("\n\r");

    /* renamed from: x  reason: collision with root package name */
    private static final ByteString f8819x = ByteString.e("*/");

    /* renamed from: h  reason: collision with root package name */
    private final BufferedSource f8820h;

    /* renamed from: j  reason: collision with root package name */
    private final Buffer f8821j;

    /* renamed from: k  reason: collision with root package name */
    private int f8822k = 0;

    /* renamed from: l  reason: collision with root package name */
    private long f8823l;

    /* renamed from: m  reason: collision with root package name */
    private int f8824m;

    /* renamed from: n  reason: collision with root package name */
    private String f8825n;

    b(BufferedSource bufferedSource) {
        if (bufferedSource != null) {
            this.f8820h = bufferedSource;
            this.f8821j = bufferedSource.B();
            x(6);
            return;
        }
        throw new NullPointerException("source == null");
    }

    private void I() throws IOException {
        if (!this.f8800e) {
            throw G("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int J() throws IOException {
        int[] iArr = this.f8797b;
        int i10 = this.f8796a;
        int i11 = iArr[i10 - 1];
        if (i11 == 1) {
            iArr[i10 - 1] = 2;
        } else if (i11 == 2) {
            int O = O(true);
            this.f8821j.readByte();
            if (O != 44) {
                if (O == 59) {
                    I();
                } else if (O == 93) {
                    this.f8822k = 4;
                    return 4;
                } else {
                    throw G("Unterminated array");
                }
            }
        } else if (i11 == 3 || i11 == 5) {
            iArr[i10 - 1] = 4;
            if (i11 == 5) {
                int O2 = O(true);
                this.f8821j.readByte();
                if (O2 != 44) {
                    if (O2 == 59) {
                        I();
                    } else if (O2 == 125) {
                        this.f8822k = 2;
                        return 2;
                    } else {
                        throw G("Unterminated object");
                    }
                }
            }
            int O3 = O(true);
            if (O3 == 34) {
                this.f8821j.readByte();
                this.f8822k = 13;
                return 13;
            } else if (O3 == 39) {
                this.f8821j.readByte();
                I();
                this.f8822k = 12;
                return 12;
            } else if (O3 != 125) {
                I();
                if (N((char) O3)) {
                    this.f8822k = 14;
                    return 14;
                }
                throw G("Expected name");
            } else if (i11 != 5) {
                this.f8821j.readByte();
                this.f8822k = 2;
                return 2;
            } else {
                throw G("Expected name");
            }
        } else if (i11 == 4) {
            iArr[i10 - 1] = 5;
            int O4 = O(true);
            this.f8821j.readByte();
            if (O4 != 58) {
                if (O4 == 61) {
                    I();
                    if (this.f8820h.r(1) && this.f8821j.l(0) == 62) {
                        this.f8821j.readByte();
                    }
                } else {
                    throw G("Expected ':'");
                }
            }
        } else if (i11 == 6) {
            iArr[i10 - 1] = 7;
        } else if (i11 == 7) {
            if (O(false) == -1) {
                this.f8822k = 18;
                return 18;
            }
            I();
        } else if (i11 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int O5 = O(true);
        if (O5 == 34) {
            this.f8821j.readByte();
            this.f8822k = 9;
            return 9;
        } else if (O5 != 39) {
            if (!(O5 == 44 || O5 == 59)) {
                if (O5 == 91) {
                    this.f8821j.readByte();
                    this.f8822k = 3;
                    return 3;
                } else if (O5 != 93) {
                    if (O5 != 123) {
                        int Y = Y();
                        if (Y != 0) {
                            return Y;
                        }
                        int c02 = c0();
                        if (c02 != 0) {
                            return c02;
                        }
                        if (N(this.f8821j.l(0))) {
                            I();
                            this.f8822k = 10;
                            return 10;
                        }
                        throw G("Expected value");
                    }
                    this.f8821j.readByte();
                    this.f8822k = 1;
                    return 1;
                } else if (i11 == 1) {
                    this.f8821j.readByte();
                    this.f8822k = 4;
                    return 4;
                }
            }
            if (i11 == 1 || i11 == 2) {
                I();
                this.f8822k = 7;
                return 7;
            }
            throw G("Unexpected value");
        } else {
            I();
            this.f8821j.readByte();
            this.f8822k = 8;
            return 8;
        }
    }

    private int L(String str, JsonReader.a aVar) {
        int length = aVar.f8813a.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (str.equals(aVar.f8813a[i10])) {
                this.f8822k = 0;
                this.f8798c[this.f8796a - 1] = str;
                return i10;
            }
        }
        return -1;
    }

    private boolean N(int i10) throws IOException {
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
        I();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        r6.f8821j.skip((long) (r3 - 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        if (r1 != 47) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r6.f8820h.r(2) != false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        I();
        r3 = r6.f8821j.l(1);
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
        r6.f8821j.readByte();
        r6.f8821j.readByte();
        m0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        r6.f8821j.readByte();
        r6.f8821j.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
        if (i0() == false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0073, code lost:
        throw G("Unterminated comment");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
        if (r1 != 35) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0078, code lost:
        I();
        m0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007f, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int O(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L_0x0001:
            r1 = r0
        L_0x0002:
            okio.BufferedSource r2 = r6.f8820h
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.r(r4)
            if (r2 == 0) goto L_0x0082
            okio.Buffer r2 = r6.f8821j
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
            okio.Buffer r2 = r6.f8821j
            int r3 = r3 + -1
            long r3 = (long) r3
            r2.skip(r3)
            r2 = 47
            if (r1 != r2) goto L_0x0074
            okio.BufferedSource r3 = r6.f8820h
            r4 = 2
            boolean r3 = r3.r(r4)
            if (r3 != 0) goto L_0x003c
            return r1
        L_0x003c:
            r6.I()
            okio.Buffer r3 = r6.f8821j
            r4 = 1
            byte r3 = r3.l(r4)
            r4 = 42
            if (r3 == r4) goto L_0x005c
            if (r3 == r2) goto L_0x004e
            return r1
        L_0x004e:
            okio.Buffer r1 = r6.f8821j
            r1.readByte()
            okio.Buffer r1 = r6.f8821j
            r1.readByte()
            r6.m0()
            goto L_0x0001
        L_0x005c:
            okio.Buffer r1 = r6.f8821j
            r1.readByte()
            okio.Buffer r1 = r6.f8821j
            r1.readByte()
            boolean r1 = r6.i0()
            if (r1 == 0) goto L_0x006d
            goto L_0x0001
        L_0x006d:
            java.lang.String r7 = "Unterminated comment"
            com.airbnb.lottie.parser.moshi.JsonEncodingException r7 = r6.G(r7)
            throw r7
        L_0x0074:
            r2 = 35
            if (r1 != r2) goto L_0x007f
            r6.I()
            r6.m0()
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
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.b.O(boolean):int");
    }

    private String P(ByteString byteString) throws IOException {
        StringBuilder sb2 = null;
        while (true) {
            long U = this.f8820h.U(byteString);
            if (U == -1) {
                throw G("Unterminated string");
            } else if (this.f8821j.l(U) == 92) {
                if (sb2 == null) {
                    sb2 = new StringBuilder();
                }
                sb2.append(this.f8821j.L0(U));
                this.f8821j.readByte();
                sb2.append(e0());
            } else if (sb2 == null) {
                String L0 = this.f8821j.L0(U);
                this.f8821j.readByte();
                return L0;
            } else {
                sb2.append(this.f8821j.L0(U));
                this.f8821j.readByte();
                return sb2.toString();
            }
        }
    }

    private String S() throws IOException {
        long U = this.f8820h.U(f8817t);
        if (U != -1) {
            return this.f8821j.L0(U);
        }
        return this.f8821j.G();
    }

    private int Y() throws IOException {
        String str;
        String str2;
        int i10;
        byte l10 = this.f8821j.l(0);
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
            if (!this.f8820h.r((long) i12)) {
                return 0;
            }
            byte l11 = this.f8821j.l((long) i11);
            if (l11 != str2.charAt(i11) && l11 != str.charAt(i11)) {
                return 0;
            }
            i11 = i12;
        }
        if (this.f8820h.r((long) (length + 1)) && N(this.f8821j.l((long) length))) {
            return 0;
        }
        this.f8821j.skip((long) length);
        this.f8822k = i10;
        return i10;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int c0() throws java.io.IOException {
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
            okio.BufferedSource r11 = r0.f8820h
            int r12 = r5 + 1
            long r13 = (long) r12
            boolean r11 = r11.r(r13)
            r15 = 2
            if (r11 != 0) goto L_0x0019
            goto L_0x0084
        L_0x0019:
            okio.Buffer r11 = r0.f8821j
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
            boolean r3 = r0.N(r11)
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
            r0.f8823l = r8
            okio.Buffer r1 = r0.f8821j
            long r2 = (long) r5
            r1.skip(r2)
            r1 = 16
            r0.f8822k = r1
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
            r0.f8824m = r5
            r1 = 17
            r0.f8822k = r1
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
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.b.c0():int");
    }

    private char e0() throws IOException {
        int i10;
        int i11;
        if (this.f8820h.r(1)) {
            byte readByte = this.f8821j.readByte();
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
                if (this.f8800e) {
                    return (char) readByte;
                }
                throw G("Invalid escape sequence: \\" + ((char) readByte));
            } else if (this.f8820h.r(4)) {
                char c10 = 0;
                for (int i12 = 0; i12 < 4; i12++) {
                    byte l10 = this.f8821j.l((long) i12);
                    char c11 = (char) (c10 << 4);
                    if (l10 < 48 || l10 > 57) {
                        if (l10 >= 97 && l10 <= 102) {
                            i10 = l10 - 97;
                        } else if (l10 < 65 || l10 > 70) {
                            throw G("\\u" + this.f8821j.L0(4));
                        } else {
                            i10 = l10 - 65;
                        }
                        i11 = i10 + 10;
                    } else {
                        i11 = l10 - 48;
                    }
                    c10 = (char) (c11 + i11);
                }
                this.f8821j.skip(4);
                return c10;
            } else {
                throw new EOFException("Unterminated escape sequence at path " + getPath());
            }
        } else {
            throw G("Unterminated escape sequence");
        }
    }

    private void f0(ByteString byteString) throws IOException {
        while (true) {
            long U = this.f8820h.U(byteString);
            if (U == -1) {
                throw G("Unterminated string");
            } else if (this.f8821j.l(U) == 92) {
                this.f8821j.skip(U + 1);
                e0();
            } else {
                this.f8821j.skip(U + 1);
                return;
            }
        }
    }

    private boolean i0() throws IOException {
        boolean z10;
        long j10;
        BufferedSource bufferedSource = this.f8820h;
        ByteString byteString = f8819x;
        long M = bufferedSource.M(byteString);
        if (M != -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        Buffer buffer = this.f8821j;
        if (z10) {
            j10 = M + ((long) byteString.H());
        } else {
            j10 = buffer.size();
        }
        buffer.skip(j10);
        return z10;
    }

    private void m0() throws IOException {
        long j10;
        long U = this.f8820h.U(f8818w);
        Buffer buffer = this.f8821j;
        if (U != -1) {
            j10 = U + 1;
        } else {
            j10 = buffer.size();
        }
        buffer.skip(j10);
    }

    private void q0() throws IOException {
        long U = this.f8820h.U(f8817t);
        Buffer buffer = this.f8821j;
        if (U == -1) {
            U = buffer.size();
        }
        buffer.skip(U);
    }

    public void C() throws IOException {
        if (!this.f8801f) {
            int i10 = this.f8822k;
            if (i10 == 0) {
                i10 = J();
            }
            if (i10 == 14) {
                q0();
            } else if (i10 == 13) {
                f0(f8816q);
            } else if (i10 == 12) {
                f0(f8815p);
            } else if (i10 != 15) {
                throw new JsonDataException("Expected a name but was " + v() + " at path " + getPath());
            }
            this.f8822k = 0;
            this.f8798c[this.f8796a - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + v() + " at " + getPath());
    }

    public void E() throws IOException {
        if (!this.f8801f) {
            int i10 = 0;
            do {
                int i11 = this.f8822k;
                if (i11 == 0) {
                    i11 = J();
                }
                if (i11 == 3) {
                    x(1);
                } else if (i11 == 1) {
                    x(3);
                } else {
                    if (i11 == 4) {
                        i10--;
                        if (i10 >= 0) {
                            this.f8796a--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + v() + " at path " + getPath());
                        }
                    } else if (i11 == 2) {
                        i10--;
                        if (i10 >= 0) {
                            this.f8796a--;
                        } else {
                            throw new JsonDataException("Expected a value but was " + v() + " at path " + getPath());
                        }
                    } else if (i11 == 14 || i11 == 10) {
                        q0();
                    } else if (i11 == 9 || i11 == 13) {
                        f0(f8816q);
                    } else if (i11 == 8 || i11 == 12) {
                        f0(f8815p);
                    } else if (i11 == 17) {
                        this.f8821j.skip((long) this.f8824m);
                    } else if (i11 == 18) {
                        throw new JsonDataException("Expected a value but was " + v() + " at path " + getPath());
                    }
                    this.f8822k = 0;
                }
                i10++;
                this.f8822k = 0;
            } while (i10 != 0);
            int[] iArr = this.f8799d;
            int i12 = this.f8796a;
            int i13 = i12 - 1;
            iArr[i13] = iArr[i13] + 1;
            this.f8798c[i12 - 1] = "null";
            return;
        }
        throw new JsonDataException("Cannot skip unexpected " + v() + " at " + getPath());
    }

    public void b() throws IOException {
        int i10 = this.f8822k;
        if (i10 == 0) {
            i10 = J();
        }
        if (i10 == 3) {
            x(1);
            this.f8799d[this.f8796a - 1] = 0;
            this.f8822k = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_ARRAY but was " + v() + " at path " + getPath());
    }

    public void c() throws IOException {
        int i10 = this.f8822k;
        if (i10 == 0) {
            i10 = J();
        }
        if (i10 == 1) {
            x(3);
            this.f8822k = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + v() + " at path " + getPath());
    }

    public void close() throws IOException {
        this.f8822k = 0;
        this.f8797b[0] = 8;
        this.f8796a = 1;
        this.f8821j.a();
        this.f8820h.close();
    }

    public void e() throws IOException {
        int i10 = this.f8822k;
        if (i10 == 0) {
            i10 = J();
        }
        if (i10 == 4) {
            int i11 = this.f8796a - 1;
            this.f8796a = i11;
            int[] iArr = this.f8799d;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
            this.f8822k = 0;
            return;
        }
        throw new JsonDataException("Expected END_ARRAY but was " + v() + " at path " + getPath());
    }

    public void f() throws IOException {
        int i10 = this.f8822k;
        if (i10 == 0) {
            i10 = J();
        }
        if (i10 == 2) {
            int i11 = this.f8796a - 1;
            this.f8796a = i11;
            this.f8798c[i11] = null;
            int[] iArr = this.f8799d;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
            this.f8822k = 0;
            return;
        }
        throw new JsonDataException("Expected END_OBJECT but was " + v() + " at path " + getPath());
    }

    public boolean g() throws IOException {
        int i10 = this.f8822k;
        if (i10 == 0) {
            i10 = J();
        }
        if (i10 == 2 || i10 == 4 || i10 == 18) {
            return false;
        }
        return true;
    }

    public boolean h() throws IOException {
        int i10 = this.f8822k;
        if (i10 == 0) {
            i10 = J();
        }
        if (i10 == 5) {
            this.f8822k = 0;
            int[] iArr = this.f8799d;
            int i11 = this.f8796a - 1;
            iArr[i11] = iArr[i11] + 1;
            return true;
        } else if (i10 == 6) {
            this.f8822k = 0;
            int[] iArr2 = this.f8799d;
            int i12 = this.f8796a - 1;
            iArr2[i12] = iArr2[i12] + 1;
            return false;
        } else {
            throw new JsonDataException("Expected a boolean but was " + v() + " at path " + getPath());
        }
    }

    public double k() throws IOException {
        int i10 = this.f8822k;
        if (i10 == 0) {
            i10 = J();
        }
        if (i10 == 16) {
            this.f8822k = 0;
            int[] iArr = this.f8799d;
            int i11 = this.f8796a - 1;
            iArr[i11] = iArr[i11] + 1;
            return (double) this.f8823l;
        }
        if (i10 == 17) {
            this.f8825n = this.f8821j.L0((long) this.f8824m);
        } else if (i10 == 9) {
            this.f8825n = P(f8816q);
        } else if (i10 == 8) {
            this.f8825n = P(f8815p);
        } else if (i10 == 10) {
            this.f8825n = S();
        } else if (i10 != 11) {
            throw new JsonDataException("Expected a double but was " + v() + " at path " + getPath());
        }
        this.f8822k = 11;
        try {
            double parseDouble = Double.parseDouble(this.f8825n);
            if (this.f8800e || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
                this.f8825n = null;
                this.f8822k = 0;
                int[] iArr2 = this.f8799d;
                int i12 = this.f8796a - 1;
                iArr2[i12] = iArr2[i12] + 1;
                return parseDouble;
            }
            throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.f8825n + " at path " + getPath());
        }
    }

    public int l() throws IOException {
        String str;
        int i10 = this.f8822k;
        if (i10 == 0) {
            i10 = J();
        }
        if (i10 == 16) {
            long j10 = this.f8823l;
            int i11 = (int) j10;
            if (j10 == ((long) i11)) {
                this.f8822k = 0;
                int[] iArr = this.f8799d;
                int i12 = this.f8796a - 1;
                iArr[i12] = iArr[i12] + 1;
                return i11;
            }
            throw new JsonDataException("Expected an int but was " + this.f8823l + " at path " + getPath());
        }
        if (i10 == 17) {
            this.f8825n = this.f8821j.L0((long) this.f8824m);
        } else if (i10 == 9 || i10 == 8) {
            if (i10 == 9) {
                str = P(f8816q);
            } else {
                str = P(f8815p);
            }
            this.f8825n = str;
            try {
                int parseInt = Integer.parseInt(str);
                this.f8822k = 0;
                int[] iArr2 = this.f8799d;
                int i13 = this.f8796a - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i10 != 11) {
            throw new JsonDataException("Expected an int but was " + v() + " at path " + getPath());
        }
        this.f8822k = 11;
        try {
            double parseDouble = Double.parseDouble(this.f8825n);
            int i14 = (int) parseDouble;
            if (((double) i14) == parseDouble) {
                this.f8825n = null;
                this.f8822k = 0;
                int[] iArr3 = this.f8799d;
                int i15 = this.f8796a - 1;
                iArr3[i15] = iArr3[i15] + 1;
                return i14;
            }
            throw new JsonDataException("Expected an int but was " + this.f8825n + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.f8825n + " at path " + getPath());
        }
    }

    public String m() throws IOException {
        String str;
        int i10 = this.f8822k;
        if (i10 == 0) {
            i10 = J();
        }
        if (i10 == 14) {
            str = S();
        } else if (i10 == 13) {
            str = P(f8816q);
        } else if (i10 == 12) {
            str = P(f8815p);
        } else if (i10 == 15) {
            str = this.f8825n;
        } else {
            throw new JsonDataException("Expected a name but was " + v() + " at path " + getPath());
        }
        this.f8822k = 0;
        this.f8798c[this.f8796a - 1] = str;
        return str;
    }

    public String n() throws IOException {
        String str;
        int i10 = this.f8822k;
        if (i10 == 0) {
            i10 = J();
        }
        if (i10 == 10) {
            str = S();
        } else if (i10 == 9) {
            str = P(f8816q);
        } else if (i10 == 8) {
            str = P(f8815p);
        } else if (i10 == 11) {
            str = this.f8825n;
            this.f8825n = null;
        } else if (i10 == 16) {
            str = Long.toString(this.f8823l);
        } else if (i10 == 17) {
            str = this.f8821j.L0((long) this.f8824m);
        } else {
            throw new JsonDataException("Expected a string but was " + v() + " at path " + getPath());
        }
        this.f8822k = 0;
        int[] iArr = this.f8799d;
        int i11 = this.f8796a - 1;
        iArr[i11] = iArr[i11] + 1;
        return str;
    }

    public String toString() {
        return "JsonReader(" + this.f8820h + ")";
    }

    public JsonReader.Token v() throws IOException {
        int i10 = this.f8822k;
        if (i10 == 0) {
            i10 = J();
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

    public int y(JsonReader.a aVar) throws IOException {
        int i10 = this.f8822k;
        if (i10 == 0) {
            i10 = J();
        }
        if (i10 < 12 || i10 > 15) {
            return -1;
        }
        if (i10 == 15) {
            return L(this.f8825n, aVar);
        }
        int a22 = this.f8820h.a2(aVar.f8814b);
        if (a22 != -1) {
            this.f8822k = 0;
            this.f8798c[this.f8796a - 1] = aVar.f8813a[a22];
            return a22;
        }
        String str = this.f8798c[this.f8796a - 1];
        String m10 = m();
        int L = L(m10, aVar);
        if (L == -1) {
            this.f8822k = 15;
            this.f8825n = m10;
            this.f8798c[this.f8796a - 1] = str;
        }
        return L;
    }
}
