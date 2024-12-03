package com.airbnb.lottie.parser.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;

public abstract class JsonReader implements Closeable {

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f8795g = new String[128];

    /* renamed from: a  reason: collision with root package name */
    int f8796a;

    /* renamed from: b  reason: collision with root package name */
    int[] f8797b = new int[32];

    /* renamed from: c  reason: collision with root package name */
    String[] f8798c = new String[32];

    /* renamed from: d  reason: collision with root package name */
    int[] f8799d = new int[32];

    /* renamed from: e  reason: collision with root package name */
    boolean f8800e;

    /* renamed from: f  reason: collision with root package name */
    boolean f8801f;

    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final String[] f8813a;

        /* renamed from: b  reason: collision with root package name */
        final Options f8814b;

        private a(String[] strArr, Options options) {
            this.f8813a = strArr;
            this.f8814b = options;
        }

        public static a a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i10 = 0; i10 < strArr.length; i10++) {
                    JsonReader.F(buffer, strArr[i10]);
                    buffer.readByte();
                    byteStringArr[i10] = buffer.y1();
                }
                return new a((String[]) strArr.clone(), Options.o(byteStringArr));
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f8795g[i10] = String.format("\\u%04x", new Object[]{Integer.valueOf(i10)});
        }
        String[] strArr = f8795g;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    JsonReader() {
    }

    /* access modifiers changed from: private */
    public static void F(BufferedSink bufferedSink, String str) throws IOException {
        String str2;
        String[] strArr = f8795g;
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

    public static JsonReader u(BufferedSource bufferedSource) {
        return new b(bufferedSource);
    }

    public abstract void C() throws IOException;

    public abstract void E() throws IOException;

    /* access modifiers changed from: package-private */
    public final JsonEncodingException G(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + getPath());
    }

    public abstract void b() throws IOException;

    public abstract void c() throws IOException;

    public abstract void e() throws IOException;

    public abstract void f() throws IOException;

    public abstract boolean g() throws IOException;

    public final String getPath() {
        return a.a(this.f8796a, this.f8797b, this.f8798c, this.f8799d);
    }

    public abstract boolean h() throws IOException;

    public abstract double k() throws IOException;

    public abstract int l() throws IOException;

    public abstract String m() throws IOException;

    public abstract String n() throws IOException;

    public abstract Token v() throws IOException;

    /* access modifiers changed from: package-private */
    public final void x(int i10) {
        int i11 = this.f8796a;
        int[] iArr = this.f8797b;
        if (i11 == iArr.length) {
            if (i11 != 256) {
                this.f8797b = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f8798c;
                this.f8798c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f8799d;
                this.f8799d = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
        }
        int[] iArr3 = this.f8797b;
        int i12 = this.f8796a;
        this.f8796a = i12 + 1;
        iArr3[i12] = i10;
    }

    public abstract int y(a aVar) throws IOException;
}
