package com.squareup.moshi;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import okio.BufferedSink;

public abstract class q implements Closeable, Flushable {

    /* renamed from: a  reason: collision with root package name */
    int f23000a = 0;

    /* renamed from: b  reason: collision with root package name */
    int[] f23001b = new int[32];

    /* renamed from: c  reason: collision with root package name */
    String[] f23002c = new String[32];

    /* renamed from: d  reason: collision with root package name */
    int[] f23003d = new int[32];

    /* renamed from: e  reason: collision with root package name */
    String f23004e;

    /* renamed from: f  reason: collision with root package name */
    boolean f23005f;

    /* renamed from: g  reason: collision with root package name */
    boolean f23006g;

    /* renamed from: h  reason: collision with root package name */
    boolean f23007h;

    /* renamed from: j  reason: collision with root package name */
    int f23008j = -1;

    q() {
    }

    public static q x(BufferedSink bufferedSink) {
        return new m(bufferedSink);
    }

    public final void C() throws IOException {
        int y10 = y();
        if (y10 == 5 || y10 == 3) {
            this.f23007h = true;
            return;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    /* access modifiers changed from: package-private */
    public final void E(int i10) {
        int[] iArr = this.f23001b;
        int i11 = this.f23000a;
        this.f23000a = i11 + 1;
        iArr[i11] = i10;
    }

    /* access modifiers changed from: package-private */
    public final void F(int i10) {
        this.f23001b[this.f23000a - 1] = i10;
    }

    public void G(String str) {
        if (str.isEmpty()) {
            str = null;
        }
        this.f23004e = str;
    }

    public final void I(boolean z10) {
        this.f23005f = z10;
    }

    public final void J(boolean z10) {
        this.f23006g = z10;
    }

    public abstract q L(double d10) throws IOException;

    public abstract q N(long j10) throws IOException;

    public abstract q O(Boolean bool) throws IOException;

    public abstract q P(Number number) throws IOException;

    public abstract q S(String str) throws IOException;

    public abstract q Y(boolean z10) throws IOException;

    public abstract q a() throws IOException;

    public final int b() {
        int y10 = y();
        if (y10 == 5 || y10 == 3 || y10 == 2 || y10 == 1) {
            int i10 = this.f23008j;
            this.f23008j = this.f23000a;
            return i10;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    public abstract q c() throws IOException;

    /* access modifiers changed from: package-private */
    public final boolean e() {
        int i10 = this.f23000a;
        int[] iArr = this.f23001b;
        if (i10 != iArr.length) {
            return false;
        }
        if (i10 != 256) {
            this.f23001b = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f23002c;
            this.f23002c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.f23003d;
            this.f23003d = Arrays.copyOf(iArr2, iArr2.length * 2);
            if (!(this instanceof p)) {
                return true;
            }
            p pVar = (p) this;
            Object[] objArr = pVar.f22998k;
            pVar.f22998k = Arrays.copyOf(objArr, objArr.length * 2);
            return true;
        }
        throw new JsonDataException("Nesting too deep at " + getPath() + ": circular reference?");
    }

    public abstract q f() throws IOException;

    public final void g(int i10) {
        this.f23008j = i10;
    }

    public final String getPath() {
        return k.a(this.f23000a, this.f23001b, this.f23002c, this.f23003d);
    }

    public abstract q h() throws IOException;

    public final String k() {
        String str = this.f23004e;
        return str != null ? str : "";
    }

    public final boolean l() {
        return this.f23006g;
    }

    public final boolean m() {
        return this.f23005f;
    }

    public final q n(Object obj) throws IOException {
        String str;
        if (obj instanceof Map) {
            c();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (!(key instanceof String)) {
                    if (key == null) {
                        str = "Map keys must be non-null";
                    } else {
                        str = "Map keys must be of type String: " + key.getClass().getName();
                    }
                    throw new IllegalArgumentException(str);
                }
                u((String) key);
                n(entry.getValue());
            }
            h();
        } else if (obj instanceof List) {
            a();
            for (Object n10 : (List) obj) {
                n(n10);
            }
            f();
        } else if (obj instanceof String) {
            S((String) obj);
        } else if (obj instanceof Boolean) {
            Y(((Boolean) obj).booleanValue());
        } else if (obj instanceof Double) {
            L(((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            N(((Long) obj).longValue());
        } else if (obj instanceof Number) {
            P((Number) obj);
        } else if (obj == null) {
            v();
        } else {
            throw new IllegalArgumentException("Unsupported type: " + obj.getClass().getName());
        }
        return this;
    }

    public abstract q u(String str) throws IOException;

    public abstract q v() throws IOException;

    /* access modifiers changed from: package-private */
    public final int y() {
        int i10 = this.f23000a;
        if (i10 != 0) {
            return this.f23001b[i10 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }
}
