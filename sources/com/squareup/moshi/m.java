package com.squareup.moshi;

import com.facebook.internal.ServerProtocol;
import com.facebook.internal.security.CertificateUtil;
import java.io.IOException;
import okio.BufferedSink;
import org.apache.commons.beanutils.PropertyUtils;

final class m extends q {

    /* renamed from: n  reason: collision with root package name */
    private static final String[] f22976n = new String[128];

    /* renamed from: k  reason: collision with root package name */
    private final BufferedSink f22977k;

    /* renamed from: l  reason: collision with root package name */
    private String f22978l = CertificateUtil.DELIMITER;

    /* renamed from: m  reason: collision with root package name */
    private String f22979m;

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f22976n[i10] = String.format("\\u%04x", new Object[]{Integer.valueOf(i10)});
        }
        String[] strArr = f22976n;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    m(BufferedSink bufferedSink) {
        if (bufferedSink != null) {
            this.f22977k = bufferedSink;
            E(6);
            return;
        }
        throw new NullPointerException("sink == null");
    }

    private void c0() throws IOException {
        int y10 = y();
        if (y10 == 5) {
            this.f22977k.writeByte(44);
        } else if (y10 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        i0();
        F(4);
    }

    private void e0() throws IOException {
        int y10 = y();
        int i10 = 7;
        if (y10 != 1) {
            if (y10 != 2) {
                if (y10 == 4) {
                    i10 = 5;
                    this.f22977k.h0(this.f22978l);
                } else if (y10 == 9) {
                    throw new IllegalStateException("Sink from valueSink() was not closed");
                } else if (y10 != 6) {
                    if (y10 != 7) {
                        throw new IllegalStateException("Nesting problem.");
                    } else if (!this.f23005f) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                }
                F(i10);
            }
            this.f22977k.writeByte(44);
        }
        i0();
        i10 = 2;
        F(i10);
    }

    private q f0(int i10, int i11, char c10) throws IOException {
        int y10 = y();
        if (y10 != i11 && y10 != i10) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f22979m == null) {
            int i12 = this.f23000a;
            int i13 = this.f23008j;
            if (i12 == (~i13)) {
                this.f23008j = ~i13;
                return this;
            }
            int i14 = i12 - 1;
            this.f23000a = i14;
            this.f23002c[i14] = null;
            int[] iArr = this.f23003d;
            int i15 = i14 - 1;
            iArr[i15] = iArr[i15] + 1;
            if (y10 == i11) {
                i0();
            }
            this.f22977k.writeByte(c10);
            return this;
        } else {
            throw new IllegalStateException("Dangling name: " + this.f22979m);
        }
    }

    private void i0() throws IOException {
        if (this.f23004e != null) {
            this.f22977k.writeByte(10);
            int i10 = this.f23000a;
            for (int i11 = 1; i11 < i10; i11++) {
                this.f22977k.h0(this.f23004e);
            }
        }
    }

    private q m0(int i10, int i11, char c10) throws IOException {
        int i12 = this.f23000a;
        int i13 = this.f23008j;
        if (i12 == i13) {
            int[] iArr = this.f23001b;
            if (iArr[i12 - 1] == i10 || iArr[i12 - 1] == i11) {
                this.f23008j = ~i13;
                return this;
            }
        }
        e0();
        e();
        E(i10);
        this.f23003d[this.f23000a - 1] = 0;
        this.f22977k.writeByte(c10);
        return this;
    }

    static void q0(BufferedSink bufferedSink, String str) throws IOException {
        String str2;
        String[] strArr = f22976n;
        bufferedSink.writeByte(34);
        int length = str.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i10 < i11) {
                bufferedSink.n0(str, i10, i11);
            }
            bufferedSink.h0(str2);
            i10 = i11 + 1;
        }
        if (i10 < length) {
            bufferedSink.n0(str, i10, length);
        }
        bufferedSink.writeByte(34);
    }

    private void r0() throws IOException {
        if (this.f22979m != null) {
            c0();
            q0(this.f22977k, this.f22979m);
            this.f22979m = null;
        }
    }

    public void G(String str) {
        String str2;
        super.G(str);
        if (!str.isEmpty()) {
            str2 = ": ";
        } else {
            str2 = CertificateUtil.DELIMITER;
        }
        this.f22978l = str2;
    }

    public q L(double d10) throws IOException {
        if (!this.f23005f && (Double.isNaN(d10) || Double.isInfinite(d10))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d10);
        } else if (this.f23007h) {
            this.f23007h = false;
            return u(Double.toString(d10));
        } else {
            r0();
            e0();
            this.f22977k.h0(Double.toString(d10));
            int[] iArr = this.f23003d;
            int i10 = this.f23000a - 1;
            iArr[i10] = iArr[i10] + 1;
            return this;
        }
    }

    public q N(long j10) throws IOException {
        if (this.f23007h) {
            this.f23007h = false;
            return u(Long.toString(j10));
        }
        r0();
        e0();
        this.f22977k.h0(Long.toString(j10));
        int[] iArr = this.f23003d;
        int i10 = this.f23000a - 1;
        iArr[i10] = iArr[i10] + 1;
        return this;
    }

    public q O(Boolean bool) throws IOException {
        if (bool == null) {
            return v();
        }
        return Y(bool.booleanValue());
    }

    public q P(Number number) throws IOException {
        if (number == null) {
            return v();
        }
        String obj = number.toString();
        if (!this.f23005f && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        } else if (this.f23007h) {
            this.f23007h = false;
            return u(obj);
        } else {
            r0();
            e0();
            this.f22977k.h0(obj);
            int[] iArr = this.f23003d;
            int i10 = this.f23000a - 1;
            iArr[i10] = iArr[i10] + 1;
            return this;
        }
    }

    public q S(String str) throws IOException {
        if (str == null) {
            return v();
        }
        if (this.f23007h) {
            this.f23007h = false;
            return u(str);
        }
        r0();
        e0();
        q0(this.f22977k, str);
        int[] iArr = this.f23003d;
        int i10 = this.f23000a - 1;
        iArr[i10] = iArr[i10] + 1;
        return this;
    }

    public q Y(boolean z10) throws IOException {
        String str;
        if (!this.f23007h) {
            r0();
            e0();
            BufferedSink bufferedSink = this.f22977k;
            if (z10) {
                str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            } else {
                str = "false";
            }
            bufferedSink.h0(str);
            int[] iArr = this.f23003d;
            int i10 = this.f23000a - 1;
            iArr[i10] = iArr[i10] + 1;
            return this;
        }
        throw new IllegalStateException("Boolean cannot be used as a map key in JSON at path " + getPath());
    }

    public q a() throws IOException {
        if (!this.f23007h) {
            r0();
            return m0(1, 2, '[');
        }
        throw new IllegalStateException("Array cannot be used as a map key in JSON at path " + getPath());
    }

    public q c() throws IOException {
        if (!this.f23007h) {
            r0();
            return m0(3, 5, '{');
        }
        throw new IllegalStateException("Object cannot be used as a map key in JSON at path " + getPath());
    }

    public void close() throws IOException {
        this.f22977k.close();
        int i10 = this.f23000a;
        if (i10 > 1 || (i10 == 1 && this.f23001b[i10 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f23000a = 0;
    }

    public q f() throws IOException {
        return f0(1, 2, PropertyUtils.INDEXED_DELIM2);
    }

    public void flush() throws IOException {
        if (this.f23000a != 0) {
            this.f22977k.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public q h() throws IOException {
        this.f23007h = false;
        return f0(3, 5, '}');
    }

    public q u(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f23000a != 0) {
            int y10 = y();
            if ((y10 == 3 || y10 == 5) && this.f22979m == null && !this.f23007h) {
                this.f22979m = str;
                this.f23002c[this.f23000a - 1] = str;
                return this;
            }
            throw new IllegalStateException("Nesting problem.");
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    public q v() throws IOException {
        if (!this.f23007h) {
            if (this.f22979m != null) {
                if (this.f23006g) {
                    r0();
                } else {
                    this.f22979m = null;
                    return this;
                }
            }
            e0();
            this.f22977k.h0("null");
            int[] iArr = this.f23003d;
            int i10 = this.f23000a - 1;
            iArr[i10] = iArr[i10] + 1;
            return this;
        }
        throw new IllegalStateException("null cannot be used as a map key in JSON at path " + getPath());
    }
}
