package com.mparticle;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

class v implements u {

    /* renamed from: a  reason: collision with root package name */
    private HttpURLConnection f22636a;

    /* renamed from: b  reason: collision with root package name */
    private b0 f22637b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f22638c = null;

    public v(HttpURLConnection httpURLConnection, b0 b0Var) {
        this.f22636a = httpURLConnection;
        this.f22637b = b0Var;
    }

    public void a(String str) throws ProtocolException {
        this.f22636a.setRequestMethod(str);
    }

    public void b(Integer num) {
        this.f22636a.setReadTimeout(num.intValue());
    }

    public InputStream c() throws IOException {
        return this.f22636a.getInputStream();
    }

    public int d() throws IOException {
        Integer num = this.f22638c;
        if (num == null) {
            return this.f22636a.getResponseCode();
        }
        return num.intValue();
    }

    public boolean e() {
        return this.f22636a instanceof HttpsURLConnection;
    }

    public String f() throws IOException {
        return this.f22636a.getResponseMessage();
    }

    public String g() {
        return this.f22636a.getRequestMethod();
    }

    public b0 h() {
        return this.f22637b;
    }

    public void a(Boolean bool) {
        this.f22636a.setDoOutput(bool.booleanValue());
    }

    public String b(String str) {
        return this.f22636a.getHeaderField(str);
    }

    public void a(Integer num) {
        this.f22636a.setConnectTimeout(num.intValue());
    }

    public OutputStream b() throws IOException {
        return this.f22636a.getOutputStream();
    }

    public void a(String str, String str2) {
        this.f22636a.setRequestProperty(str, str2);
    }

    public InputStream a() {
        return this.f22636a.getErrorStream();
    }

    public void a(SSLSocketFactory sSLSocketFactory) {
        ((HttpsURLConnection) this.f22636a).setSSLSocketFactory(sSLSocketFactory);
    }
}
