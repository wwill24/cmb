package io.sentry.vendor.gson.stream;

import com.facebook.internal.ServerProtocol;
import com.facebook.internal.security.CertificateUtil;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class b implements Closeable, Flushable {

    /* renamed from: k  reason: collision with root package name */
    private static final String[] f31761k = new String[128];

    /* renamed from: l  reason: collision with root package name */
    private static final String[] f31762l;

    /* renamed from: a  reason: collision with root package name */
    private final Writer f31763a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f31764b = new int[32];

    /* renamed from: c  reason: collision with root package name */
    private int f31765c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String f31766d;

    /* renamed from: e  reason: collision with root package name */
    private String f31767e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f31768f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f31769g;

    /* renamed from: h  reason: collision with root package name */
    private String f31770h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f31771j;

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f31761k[i10] = String.format("\\u%04x", new Object[]{Integer.valueOf(i10)});
        }
        String[] strArr = f31761k;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f31762l = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public b(Writer writer) {
        v(6);
        this.f31767e = CertificateUtil.DELIMITER;
        this.f31771j = true;
        if (writer != null) {
            this.f31763a = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    private void C(String str) throws IOException {
        String[] strArr;
        String str2;
        if (this.f31769g) {
            strArr = f31762l;
        } else {
            strArr = f31761k;
        }
        this.f31763a.write(34);
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
                this.f31763a.write(str, i10, i11 - i10);
            }
            this.f31763a.write(str2);
            i10 = i11 + 1;
        }
        if (i10 < length) {
            this.f31763a.write(str, i10, length - i10);
        }
        this.f31763a.write(34);
    }

    private void L() throws IOException {
        if (this.f31770h != null) {
            a();
            C(this.f31770h);
            this.f31770h = null;
        }
    }

    private void a() throws IOException {
        int u10 = u();
        if (u10 == 5) {
            this.f31763a.write(44);
        } else if (u10 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        l();
        x(4);
    }

    private void b() throws IOException {
        int u10 = u();
        if (u10 == 1) {
            x(2);
            l();
        } else if (u10 == 2) {
            this.f31763a.append(',');
            l();
        } else if (u10 != 4) {
            if (u10 != 6) {
                if (u10 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                } else if (!this.f31768f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            x(7);
        } else {
            this.f31763a.append(this.f31767e);
            x(5);
        }
    }

    private b f(int i10, int i11, char c10) throws IOException {
        int u10 = u();
        if (u10 != i11 && u10 != i10) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f31770h == null) {
            this.f31765c--;
            if (u10 == i11) {
                l();
            }
            this.f31763a.write(c10);
            return this;
        } else {
            throw new IllegalStateException("Dangling name: " + this.f31770h);
        }
    }

    private void l() throws IOException {
        if (this.f31766d != null) {
            this.f31763a.write(10);
            int i10 = this.f31765c;
            for (int i11 = 1; i11 < i10; i11++) {
                this.f31763a.write(this.f31766d);
            }
        }
    }

    private b n(int i10, char c10) throws IOException {
        b();
        v(i10);
        this.f31763a.write(c10);
        return this;
    }

    private int u() {
        int i10 = this.f31765c;
        if (i10 != 0) {
            return this.f31764b[i10 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void v(int i10) {
        int i11 = this.f31765c;
        int[] iArr = this.f31764b;
        if (i11 == iArr.length) {
            this.f31764b = Arrays.copyOf(iArr, i11 * 2);
        }
        int[] iArr2 = this.f31764b;
        int i12 = this.f31765c;
        this.f31765c = i12 + 1;
        iArr2[i12] = i10;
    }

    private void x(int i10) {
        this.f31764b[this.f31765c - 1] = i10;
    }

    public b E(long j10) throws IOException {
        L();
        b();
        this.f31763a.write(Long.toString(j10));
        return this;
    }

    public b F(Boolean bool) throws IOException {
        String str;
        if (bool == null) {
            return m();
        }
        L();
        b();
        Writer writer = this.f31763a;
        if (bool.booleanValue()) {
            str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
        } else {
            str = "false";
        }
        writer.write(str);
        return this;
    }

    public b G(Number number) throws IOException {
        if (number == null) {
            return m();
        }
        L();
        String obj = number.toString();
        if (this.f31768f || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            b();
            this.f31763a.append(obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public b I(String str) throws IOException {
        if (str == null) {
            return m();
        }
        L();
        b();
        C(str);
        return this;
    }

    public b J(boolean z10) throws IOException {
        String str;
        L();
        b();
        Writer writer = this.f31763a;
        if (z10) {
            str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
        } else {
            str = "false";
        }
        writer.write(str);
        return this;
    }

    public b c() throws IOException {
        L();
        return n(1, '[');
    }

    public void close() throws IOException {
        this.f31763a.close();
        int i10 = this.f31765c;
        if (i10 > 1 || (i10 == 1 && this.f31764b[i10 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f31765c = 0;
    }

    public b e() throws IOException {
        L();
        return n(3, '{');
    }

    public void flush() throws IOException {
        if (this.f31765c != 0) {
            this.f31763a.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public b g() throws IOException {
        return f(1, 2, PropertyUtils.INDEXED_DELIM2);
    }

    public b h() throws IOException {
        return f(3, 5, '}');
    }

    public b k(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f31770h != null) {
            throw new IllegalStateException();
        } else if (this.f31765c != 0) {
            this.f31770h = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    public b m() throws IOException {
        if (this.f31770h != null) {
            if (this.f31771j) {
                L();
            } else {
                this.f31770h = null;
                return this;
            }
        }
        b();
        this.f31763a.write("null");
        return this;
    }

    public final void y(String str) {
        if (str.length() == 0) {
            this.f31766d = null;
            this.f31767e = CertificateUtil.DELIMITER;
            return;
        }
        this.f31766d = str;
        this.f31767e = ": ";
    }
}
