package com.squareup.moshi;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class p extends q {

    /* renamed from: k  reason: collision with root package name */
    Object[] f22998k = new Object[32];

    /* renamed from: l  reason: collision with root package name */
    private String f22999l;

    p() {
        E(6);
    }

    private p c0(Object obj) {
        String str;
        Object put;
        int y10 = y();
        int i10 = this.f23000a;
        if (i10 == 1) {
            if (y10 == 6) {
                this.f23001b[i10 - 1] = 7;
                this.f22998k[i10 - 1] = obj;
            } else {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
        } else if (y10 != 3 || (str = this.f22999l) == null) {
            if (y10 == 1) {
                ((List) this.f22998k[i10 - 1]).add(obj);
            } else if (y10 == 9) {
                throw new IllegalStateException("Sink from valueSink() was not closed");
            } else {
                throw new IllegalStateException("Nesting problem.");
            }
        } else if ((obj != null || this.f23006g) && (put = ((Map) this.f22998k[i10 - 1]).put(str, obj)) != null) {
            throw new IllegalArgumentException("Map key '" + this.f22999l + "' has multiple values at path " + getPath() + ": " + put + " and " + obj);
        } else {
            this.f22999l = null;
        }
        return this;
    }

    public q L(double d10) throws IOException {
        if (!this.f23005f && (Double.isNaN(d10) || d10 == Double.NEGATIVE_INFINITY || d10 == Double.POSITIVE_INFINITY)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d10);
        } else if (this.f23007h) {
            this.f23007h = false;
            return u(Double.toString(d10));
        } else {
            c0(Double.valueOf(d10));
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
        c0(Long.valueOf(j10));
        int[] iArr = this.f23003d;
        int i10 = this.f23000a - 1;
        iArr[i10] = iArr[i10] + 1;
        return this;
    }

    public q O(Boolean bool) throws IOException {
        if (!this.f23007h) {
            c0(bool);
            int[] iArr = this.f23003d;
            int i10 = this.f23000a - 1;
            iArr[i10] = iArr[i10] + 1;
            return this;
        }
        throw new IllegalStateException("Boolean cannot be used as a map key in JSON at path " + getPath());
    }

    public q P(Number number) throws IOException {
        BigDecimal bigDecimal;
        if ((number instanceof Byte) || (number instanceof Short) || (number instanceof Integer) || (number instanceof Long)) {
            return N(number.longValue());
        }
        if ((number instanceof Float) || (number instanceof Double)) {
            return L(number.doubleValue());
        }
        if (number == null) {
            return v();
        }
        if (number instanceof BigDecimal) {
            bigDecimal = (BigDecimal) number;
        } else {
            bigDecimal = new BigDecimal(number.toString());
        }
        if (this.f23007h) {
            this.f23007h = false;
            return u(bigDecimal.toString());
        }
        c0(bigDecimal);
        int[] iArr = this.f23003d;
        int i10 = this.f23000a - 1;
        iArr[i10] = iArr[i10] + 1;
        return this;
    }

    public q S(String str) throws IOException {
        if (this.f23007h) {
            this.f23007h = false;
            return u(str);
        }
        c0(str);
        int[] iArr = this.f23003d;
        int i10 = this.f23000a - 1;
        iArr[i10] = iArr[i10] + 1;
        return this;
    }

    public q Y(boolean z10) throws IOException {
        if (!this.f23007h) {
            c0(Boolean.valueOf(z10));
            int[] iArr = this.f23003d;
            int i10 = this.f23000a - 1;
            iArr[i10] = iArr[i10] + 1;
            return this;
        }
        throw new IllegalStateException("Boolean cannot be used as a map key in JSON at path " + getPath());
    }

    public q a() throws IOException {
        if (!this.f23007h) {
            int i10 = this.f23000a;
            int i11 = this.f23008j;
            if (i10 == i11 && this.f23001b[i10 - 1] == 1) {
                this.f23008j = ~i11;
                return this;
            }
            e();
            ArrayList arrayList = new ArrayList();
            c0(arrayList);
            Object[] objArr = this.f22998k;
            int i12 = this.f23000a;
            objArr[i12] = arrayList;
            this.f23003d[i12] = 0;
            E(1);
            return this;
        }
        throw new IllegalStateException("Array cannot be used as a map key in JSON at path " + getPath());
    }

    public q c() throws IOException {
        if (!this.f23007h) {
            int i10 = this.f23000a;
            int i11 = this.f23008j;
            if (i10 == i11 && this.f23001b[i10 - 1] == 3) {
                this.f23008j = ~i11;
                return this;
            }
            e();
            LinkedHashTreeMap linkedHashTreeMap = new LinkedHashTreeMap();
            c0(linkedHashTreeMap);
            this.f22998k[this.f23000a] = linkedHashTreeMap;
            E(3);
            return this;
        }
        throw new IllegalStateException("Object cannot be used as a map key in JSON at path " + getPath());
    }

    public void close() throws IOException {
        int i10 = this.f23000a;
        if (i10 > 1 || (i10 == 1 && this.f23001b[i10 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f23000a = 0;
    }

    public Object e0() {
        int i10 = this.f23000a;
        if (i10 <= 1 && (i10 != 1 || this.f23001b[i10 - 1] == 7)) {
            return this.f22998k[0];
        }
        throw new IllegalStateException("Incomplete document");
    }

    public q f() throws IOException {
        if (y() == 1) {
            int i10 = this.f23000a;
            int i11 = this.f23008j;
            if (i10 == (~i11)) {
                this.f23008j = ~i11;
                return this;
            }
            int i12 = i10 - 1;
            this.f23000a = i12;
            this.f22998k[i12] = null;
            int[] iArr = this.f23003d;
            int i13 = i12 - 1;
            iArr[i13] = iArr[i13] + 1;
            return this;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    public void flush() throws IOException {
        if (this.f23000a == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    public q h() throws IOException {
        if (y() != 3) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f22999l == null) {
            int i10 = this.f23000a;
            int i11 = this.f23008j;
            if (i10 == (~i11)) {
                this.f23008j = ~i11;
                return this;
            }
            this.f23007h = false;
            int i12 = i10 - 1;
            this.f23000a = i12;
            this.f22998k[i12] = null;
            this.f23002c[i12] = null;
            int[] iArr = this.f23003d;
            int i13 = i12 - 1;
            iArr[i13] = iArr[i13] + 1;
            return this;
        } else {
            throw new IllegalStateException("Dangling name: " + this.f22999l);
        }
    }

    public q u(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f23000a == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else if (y() == 3 && this.f22999l == null && !this.f23007h) {
            this.f22999l = str;
            this.f23002c[this.f23000a - 1] = str;
            return this;
        } else {
            throw new IllegalStateException("Nesting problem.");
        }
    }

    public q v() throws IOException {
        if (!this.f23007h) {
            c0((Object) null);
            int[] iArr = this.f23003d;
            int i10 = this.f23000a - 1;
            iArr[i10] = iArr[i10] + 1;
            return this;
        }
        throw new IllegalStateException("null cannot be used as a map key in JSON at path " + getPath());
    }
}
