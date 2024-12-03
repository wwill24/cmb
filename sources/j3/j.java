package j3;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import f4.c;
import f4.f;
import j3.d;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import p3.g;

public class j implements d<InputStream> {

    /* renamed from: g  reason: collision with root package name */
    static final b f15567g = new a();

    /* renamed from: a  reason: collision with root package name */
    private final g f15568a;

    /* renamed from: b  reason: collision with root package name */
    private final int f15569b;

    /* renamed from: c  reason: collision with root package name */
    private final b f15570c;

    /* renamed from: d  reason: collision with root package name */
    private HttpURLConnection f15571d;

    /* renamed from: e  reason: collision with root package name */
    private InputStream f15572e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f15573f;

    private static class a implements b {
        a() {
        }

        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public j(g gVar, int i10) {
        this(gVar, i10, f15567g);
    }

    private InputStream c(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f15572e = c.b(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Got non empty content encoding: ");
                sb2.append(httpURLConnection.getContentEncoding());
            }
            this.f15572e = httpURLConnection.getInputStream();
        }
        return this.f15572e;
    }

    private static boolean f(int i10) {
        return i10 / 100 == 2;
    }

    private static boolean g(int i10) {
        return i10 / 100 == 3;
    }

    private InputStream h(URL url, int i10, URL url2, Map<String, String> map) throws IOException {
        if (i10 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new HttpException("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f15571d = this.f15570c.a(url);
            for (Map.Entry next : map.entrySet()) {
                this.f15571d.addRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            this.f15571d.setConnectTimeout(this.f15569b);
            this.f15571d.setReadTimeout(this.f15569b);
            this.f15571d.setUseCaches(false);
            this.f15571d.setDoInput(true);
            this.f15571d.setInstanceFollowRedirects(false);
            this.f15571d.connect();
            this.f15572e = this.f15571d.getInputStream();
            if (this.f15573f) {
                return null;
            }
            int responseCode = this.f15571d.getResponseCode();
            if (f(responseCode)) {
                return c(this.f15571d);
            }
            if (g(responseCode)) {
                String headerField = this.f15571d.getHeaderField("Location");
                if (!TextUtils.isEmpty(headerField)) {
                    URL url3 = new URL(url, headerField);
                    b();
                    return h(url3, i10 + 1, url, map);
                }
                throw new HttpException("Received empty or null redirect url");
            } else if (responseCode == -1) {
                throw new HttpException(responseCode);
            } else {
                throw new HttpException(this.f15571d.getResponseMessage(), responseCode);
            }
        } else {
            throw new HttpException("Too many (> 5) redirects!");
        }
    }

    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    public void b() {
        InputStream inputStream = this.f15572e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f15571d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f15571d = null;
    }

    public void cancel() {
        this.f15573f = true;
    }

    public void d(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        StringBuilder sb2;
        long b10 = f.b();
        try {
            aVar.f(h(this.f15568a.g(), 0, (URL) null, this.f15568a.c()));
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb2 = new StringBuilder();
                sb2.append("Finished http url fetcher fetch in ");
                sb2.append(f.a(b10));
            }
        } catch (IOException e10) {
            boolean isLoggable = Log.isLoggable("HttpUrlFetcher", 3);
            aVar.c(e10);
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb2 = new StringBuilder();
            }
        } catch (Throwable th2) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Finished http url fetcher fetch in ");
                sb3.append(f.a(b10));
            }
            throw th2;
        }
    }

    @NonNull
    public DataSource e() {
        return DataSource.REMOTE;
    }

    j(g gVar, int i10, b bVar) {
        this.f15568a = gVar;
        this.f15569b = i10;
        this.f15570c = bVar;
    }
}
