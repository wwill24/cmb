package p3;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import f4.j;
import i3.b;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

public class g implements b {

    /* renamed from: b  reason: collision with root package name */
    private final h f16928b;

    /* renamed from: c  reason: collision with root package name */
    private final URL f16929c;

    /* renamed from: d  reason: collision with root package name */
    private final String f16930d;

    /* renamed from: e  reason: collision with root package name */
    private String f16931e;

    /* renamed from: f  reason: collision with root package name */
    private URL f16932f;

    /* renamed from: g  reason: collision with root package name */
    private volatile byte[] f16933g;

    /* renamed from: h  reason: collision with root package name */
    private int f16934h;

    public g(URL url) {
        this(url, h.f16936b);
    }

    private byte[] b() {
        if (this.f16933g == null) {
            this.f16933g = a().getBytes(b.f15458a);
        }
        return this.f16933g;
    }

    private String d() {
        if (TextUtils.isEmpty(this.f16931e)) {
            String str = this.f16930d;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) j.d(this.f16929c)).toString();
            }
            this.f16931e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f16931e;
    }

    private URL e() throws MalformedURLException {
        if (this.f16932f == null) {
            this.f16932f = new URL(d());
        }
        return this.f16932f;
    }

    public String a() {
        String str = this.f16930d;
        return str != null ? str : ((URL) j.d(this.f16929c)).toString();
    }

    public Map<String, String> c() {
        return this.f16928b.a();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (!a().equals(gVar.a()) || !this.f16928b.equals(gVar.f16928b)) {
            return false;
        }
        return true;
    }

    public String f() {
        return d();
    }

    public URL g() throws MalformedURLException {
        return e();
    }

    public int hashCode() {
        if (this.f16934h == 0) {
            int hashCode = a().hashCode();
            this.f16934h = hashCode;
            this.f16934h = (hashCode * 31) + this.f16928b.hashCode();
        }
        return this.f16934h;
    }

    public String toString() {
        return a();
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(b());
    }

    public g(String str) {
        this(str, h.f16936b);
    }

    public g(URL url, h hVar) {
        this.f16929c = (URL) j.d(url);
        this.f16930d = null;
        this.f16928b = (h) j.d(hVar);
    }

    public g(String str, h hVar) {
        this.f16929c = null;
        this.f16930d = j.b(str);
        this.f16928b = (h) j.d(hVar);
    }
}
