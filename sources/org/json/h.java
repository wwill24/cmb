package org.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private long f24241a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f24242b;

    /* renamed from: c  reason: collision with root package name */
    private long f24243c;

    /* renamed from: d  reason: collision with root package name */
    private long f24244d;

    /* renamed from: e  reason: collision with root package name */
    private char f24245e;

    /* renamed from: f  reason: collision with root package name */
    private final Reader f24246f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f24247g;

    /* renamed from: h  reason: collision with root package name */
    private long f24248h;

    public h(Reader reader) {
        this.f24246f = !reader.markSupported() ? new BufferedReader(reader) : reader;
        this.f24242b = false;
        this.f24247g = false;
        this.f24245e = 0;
        this.f24243c = 0;
        this.f24241a = 1;
        this.f24248h = 0;
        this.f24244d = 1;
    }

    private void b() {
        this.f24243c--;
        char c10 = this.f24245e;
        if (c10 == 13 || c10 == 10) {
            this.f24244d--;
            this.f24241a = this.f24248h;
            return;
        }
        long j10 = this.f24241a;
        if (j10 > 0) {
            this.f24241a = j10 - 1;
        }
    }

    private void e(int i10) {
        if (i10 > 0) {
            this.f24243c++;
            if (i10 == 13) {
                this.f24244d++;
                this.f24248h = this.f24241a;
                this.f24241a = 0;
            } else if (i10 == 10) {
                if (this.f24245e != 13) {
                    this.f24244d++;
                    this.f24248h = this.f24241a;
                }
                this.f24241a = 0;
            } else {
                this.f24241a++;
            }
        }
    }

    public void a() throws JSONException {
        if (this.f24247g || this.f24243c <= 0) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        b();
        this.f24247g = true;
        this.f24242b = false;
    }

    public boolean c() {
        return this.f24242b && !this.f24247g;
    }

    /* access modifiers changed from: protected */
    public char d() {
        return this.f24245e;
    }

    public char f() throws JSONException {
        int i10;
        if (this.f24247g) {
            this.f24247g = false;
            i10 = this.f24245e;
        } else {
            try {
                i10 = this.f24246f.read();
            } catch (IOException e10) {
                throw new JSONException((Throwable) e10);
            }
        }
        if (i10 <= 0) {
            this.f24242b = true;
            return 0;
        }
        e(i10);
        char c10 = (char) i10;
        this.f24245e = c10;
        return c10;
    }

    public String g(int i10) throws JSONException {
        if (i10 == 0) {
            return "";
        }
        char[] cArr = new char[i10];
        int i11 = 0;
        while (i11 < i10) {
            cArr[i11] = f();
            if (!c()) {
                i11++;
            } else {
                throw k("Substring bounds error");
            }
        }
        return new String(cArr);
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public char h() throws org.json.JSONException {
        /*
            r2 = this;
        L_0x0000:
            char r0 = r2.f()
            if (r0 == 0) goto L_0x000a
            r1 = 32
            if (r0 <= r1) goto L_0x0000
        L_0x000a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.h.h():char");
    }

    public String i(char c10) throws JSONException {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            char f10 = f();
            if (f10 != 0 && f10 != 10 && f10 != 13) {
                if (f10 == '\\') {
                    char f11 = f();
                    if (f11 == '\"' || f11 == '\'' || f11 == '/' || f11 == '\\') {
                        sb2.append(f11);
                    } else if (f11 == 'b') {
                        sb2.append(8);
                    } else if (f11 == 'f') {
                        sb2.append(12);
                    } else if (f11 == 'n') {
                        sb2.append(10);
                    } else if (f11 == 'r') {
                        sb2.append(13);
                    } else if (f11 == 't') {
                        sb2.append(9);
                    } else if (f11 == 'u') {
                        try {
                            sb2.append((char) Integer.parseInt(g(4), 16));
                        } catch (NumberFormatException e10) {
                            throw l("Illegal escape.", e10);
                        }
                    } else {
                        throw k("Illegal escape.");
                    }
                } else if (f10 == c10) {
                    return sb2.toString();
                } else {
                    sb2.append(f10);
                }
            }
        }
        throw k("Unterminated string");
    }

    public Object j() throws JSONException {
        char h10 = h();
        if (h10 == '\"' || h10 == '\'') {
            return i(h10);
        }
        if (h10 == '[') {
            a();
            try {
                return new a(this);
            } catch (StackOverflowError e10) {
                throw new JSONException("JSON Array or Object depth too large to process.", e10);
            }
        } else if (h10 != '{') {
            StringBuilder sb2 = new StringBuilder();
            while (h10 >= ' ' && ",:]}/\\\"[{;=#".indexOf(h10) < 0) {
                sb2.append(h10);
                h10 = f();
            }
            if (!this.f24242b) {
                a();
            }
            String trim = sb2.toString().trim();
            if (!"".equals(trim)) {
                return b.stringToValue(trim);
            }
            throw k("Missing value");
        } else {
            a();
            try {
                return new b(this);
            } catch (StackOverflowError e11) {
                throw new JSONException("JSON Array or Object depth too large to process.", e11);
            }
        }
    }

    public JSONException k(String str) {
        return new JSONException(str + toString());
    }

    public JSONException l(String str, Throwable th2) {
        return new JSONException(str + toString(), th2);
    }

    public String toString() {
        return " at " + this.f24243c + " [character " + this.f24241a + " line " + this.f24244d + "]";
    }

    public h(String str) {
        this((Reader) new StringReader(str));
    }
}
