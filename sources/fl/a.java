package fl;

import bl.d;
import com.facebook.stetho.server.http.HttpHeaders;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.l;
import okhttp3.m;
import okhttp3.u;
import okhttp3.v;
import okhttp3.y;
import okhttp3.z;
import okio.GzipSource;
import okio.Okio;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\f¨\u0006\u0010"}, d2 = {"Lfl/a;", "Lokhttp3/u;", "", "Lokhttp3/l;", "cookies", "", "a", "Lokhttp3/u$a;", "chain", "Lokhttp3/a0;", "intercept", "Lokhttp3/m;", "Lokhttp3/m;", "cookieJar", "<init>", "(Lokhttp3/m;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class a implements u {

    /* renamed from: a  reason: collision with root package name */
    private final m f29654a;

    public a(m mVar) {
        j.g(mVar, "cookieJar");
        this.f29654a = mVar;
    }

    private final String a(List<l> list) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (T next : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                q.s();
            }
            l lVar = (l) next;
            if (i10 > 0) {
                sb2.append("; ");
            }
            sb2.append(lVar.i());
            sb2.append(SignatureVisitor.INSTANCEOF);
            sb2.append(lVar.n());
            i10 = i11;
        }
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public a0 intercept(u.a aVar) throws IOException {
        b0 a10;
        j.g(aVar, "chain");
        y g10 = aVar.g();
        y.a h10 = g10.h();
        z a11 = g10.a();
        if (a11 != null) {
            v b10 = a11.b();
            if (b10 != null) {
                h10.f(HttpHeaders.CONTENT_TYPE, b10.toString());
            }
            long a12 = a11.a();
            if (a12 != -1) {
                h10.f(HttpHeaders.CONTENT_LENGTH, String.valueOf(a12));
                h10.j("Transfer-Encoding");
            } else {
                h10.f("Transfer-Encoding", "chunked");
                h10.j(HttpHeaders.CONTENT_LENGTH);
            }
        }
        boolean z10 = false;
        if (g10.d("Host") == null) {
            h10.f("Host", d.R(g10.j(), false, 1, (Object) null));
        }
        if (g10.d("Connection") == null) {
            h10.f("Connection", "Keep-Alive");
        }
        if (g10.d("Accept-Encoding") == null && g10.d("Range") == null) {
            h10.f("Accept-Encoding", "gzip");
            z10 = true;
        }
        List<l> a13 = this.f29654a.a(g10.j());
        if (!a13.isEmpty()) {
            h10.f("Cookie", a(a13));
        }
        if (g10.d("User-Agent") == null) {
            h10.f("User-Agent", "okhttp/4.10.0");
        }
        a0 a14 = aVar.a(h10.b());
        e.f(this.f29654a, g10.j(), a14.n());
        a0.a s10 = a14.x().s(g10);
        if (z10 && r.t("gzip", a0.m(a14, "Content-Encoding", (String) null, 2, (Object) null), true) && e.b(a14) && (a10 = a14.a()) != null) {
            GzipSource gzipSource = new GzipSource(a10.source());
            s10.l(a14.n().j().h("Content-Encoding").h(HttpHeaders.CONTENT_LENGTH).f());
            s10.b(new h(a0.m(a14, HttpHeaders.CONTENT_TYPE, (String) null, 2, (Object) null), -1, Okio.c(gzipSource)));
        }
        return s10.c();
    }
}
