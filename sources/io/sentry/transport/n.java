package io.sentry.transport;

import com.facebook.stetho.server.http.HttpHeaders;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.b2;
import io.sentry.h0;
import io.sentry.w2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;

final class n {

    /* renamed from: e  reason: collision with root package name */
    private static final Charset f31665e = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    private final Proxy f31666a;

    /* renamed from: b  reason: collision with root package name */
    private final b2 f31667b;

    /* renamed from: c  reason: collision with root package name */
    private final SentryOptions f31668c;

    /* renamed from: d  reason: collision with root package name */
    private final y f31669d;

    public n(SentryOptions sentryOptions, b2 b2Var, y yVar) {
        this(sentryOptions, b2Var, l.a(), yVar);
    }

    private void a(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.getInputStream().close();
        } catch (IOException unused) {
        } catch (Throwable th2) {
            httpURLConnection.disconnect();
            throw th2;
        }
        httpURLConnection.disconnect();
    }

    private HttpURLConnection b() throws IOException {
        HttpURLConnection e10 = e();
        for (Map.Entry next : this.f31667b.a().entrySet()) {
            e10.setRequestProperty((String) next.getKey(), (String) next.getValue());
        }
        e10.setRequestMethod("POST");
        e10.setDoOutput(true);
        e10.setRequestProperty("Content-Encoding", "gzip");
        e10.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/x-sentry-envelope");
        e10.setRequestProperty("Accept", "application/json");
        e10.setRequestProperty("Connection", Close.ELEMENT);
        e10.setConnectTimeout(this.f31668c.getConnectionTimeoutMillis());
        e10.setReadTimeout(this.f31668c.getReadTimeoutMillis());
        HostnameVerifier hostnameVerifier = this.f31668c.getHostnameVerifier();
        boolean z10 = e10 instanceof HttpsURLConnection;
        if (z10 && hostnameVerifier != null) {
            ((HttpsURLConnection) e10).setHostnameVerifier(hostnameVerifier);
        }
        SSLSocketFactory sslSocketFactory = this.f31668c.getSslSocketFactory();
        if (z10 && sslSocketFactory != null) {
            ((HttpsURLConnection) e10).setSSLSocketFactory(sslSocketFactory);
        }
        e10.connect();
        return e10;
    }

    private String c(HttpURLConnection httpURLConnection) {
        BufferedReader bufferedReader;
        try {
            InputStream errorStream = httpURLConnection.getErrorStream();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(errorStream, f31665e));
                StringBuilder sb2 = new StringBuilder();
                boolean z10 = true;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (!z10) {
                        sb2.append("\n");
                    }
                    sb2.append(readLine);
                    z10 = false;
                }
                String sb3 = sb2.toString();
                bufferedReader.close();
                if (errorStream != null) {
                    errorStream.close();
                }
                return sb3;
            } catch (Throwable th2) {
                if (errorStream != null) {
                    errorStream.close();
                }
                throw th2;
            }
            throw th;
        } catch (IOException unused) {
            return "Failed to obtain error message while analyzing send failure.";
        } catch (Throwable th3) {
            th2.addSuppressed(th3);
        }
    }

    private boolean d(int i10) {
        return i10 == 200;
    }

    /* JADX INFO: finally extract failed */
    private z f(HttpURLConnection httpURLConnection) {
        try {
            int responseCode = httpURLConnection.getResponseCode();
            i(httpURLConnection, responseCode);
            if (!d(responseCode)) {
                h0 logger = this.f31668c.getLogger();
                SentryLevel sentryLevel = SentryLevel.ERROR;
                logger.c(sentryLevel, "Request failed, API returned %s", Integer.valueOf(responseCode));
                if (this.f31668c.isDebug()) {
                    this.f31668c.getLogger().c(sentryLevel, c(httpURLConnection), new Object[0]);
                }
                z b10 = z.b(responseCode);
                a(httpURLConnection);
                return b10;
            }
            this.f31668c.getLogger().c(SentryLevel.DEBUG, "Envelope sent successfully.", new Object[0]);
            z e10 = z.e();
            a(httpURLConnection);
            return e10;
        } catch (IOException e11) {
            this.f31668c.getLogger().a(SentryLevel.ERROR, e11, "Error reading and logging the response stream", new Object[0]);
            a(httpURLConnection);
            return z.a();
        } catch (Throwable th2) {
            a(httpURLConnection);
            throw th2;
        }
    }

    private Proxy g(SentryOptions.e eVar) {
        if (eVar != null) {
            String c10 = eVar.c();
            String a10 = eVar.a();
            if (!(c10 == null || a10 == null)) {
                try {
                    return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(a10, Integer.parseInt(c10)));
                } catch (NumberFormatException e10) {
                    h0 logger = this.f31668c.getLogger();
                    SentryLevel sentryLevel = SentryLevel.ERROR;
                    logger.a(sentryLevel, e10, "Failed to parse Sentry Proxy port: " + eVar.c() + ". Proxy is ignored", new Object[0]);
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public HttpURLConnection e() throws IOException {
        URLConnection uRLConnection;
        if (this.f31666a == null) {
            uRLConnection = this.f31667b.b().openConnection();
        } else {
            uRLConnection = this.f31667b.b().openConnection(this.f31666a);
        }
        return (HttpURLConnection) uRLConnection;
    }

    public z h(w2 w2Var) throws IOException {
        GZIPOutputStream gZIPOutputStream;
        HttpURLConnection b10 = b();
        try {
            OutputStream outputStream = b10.getOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(outputStream);
                this.f31668c.getSerializer().b(w2Var, gZIPOutputStream);
                gZIPOutputStream.close();
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Throwable th2) {
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                this.f31668c.getLogger().a(SentryLevel.ERROR, th3, "An exception occurred while submitting the envelope to the Sentry server.", new Object[0]);
            } catch (Throwable th4) {
                f(b10);
                throw th4;
            }
        }
        return f(b10);
        throw th;
    }

    public void i(HttpURLConnection httpURLConnection, int i10) {
        String headerField = httpURLConnection.getHeaderField("Retry-After");
        this.f31669d.k(httpURLConnection.getHeaderField("X-Sentry-Rate-Limits"), headerField, i10);
    }

    n(SentryOptions sentryOptions, b2 b2Var, l lVar, y yVar) {
        this.f31667b = b2Var;
        this.f31668c = sentryOptions;
        this.f31669d = yVar;
        Proxy g10 = g(sentryOptions.getProxy());
        this.f31666a = g10;
        if (g10 != null && sentryOptions.getProxy() != null) {
            String d10 = sentryOptions.getProxy().d();
            String b10 = sentryOptions.getProxy().b();
            if (d10 != null && b10 != null) {
                lVar.b(new u(d10, b10));
            }
        }
    }
}
