package fl;

import bl.d;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.internal.connection.c;
import okhttp3.u;
import okhttp3.y;
import okhttp3.z;
import okio.BufferedSink;
import okio.Okio;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Close;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lfl/b;", "Lokhttp3/u;", "Lokhttp3/u$a;", "chain", "Lokhttp3/a0;", "intercept", "", "a", "Z", "forWebSocket", "<init>", "(Z)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class b implements u {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f29655a;

    public b(boolean z10) {
        this.f29655a = z10;
    }

    public a0 intercept(u.a aVar) throws IOException {
        boolean z10;
        a0.a aVar2;
        a0 a0Var;
        long j10;
        j.g(aVar, "chain");
        g gVar = (g) aVar;
        c h10 = gVar.h();
        j.d(h10);
        y j11 = gVar.j();
        z a10 = j11.a();
        long currentTimeMillis = System.currentTimeMillis();
        h10.t(j11);
        Long l10 = null;
        if (!f.a(j11.g()) || a10 == null) {
            h10.n();
            aVar2 = null;
            z10 = true;
        } else {
            if (r.t("100-continue", j11.d("Expect"), true)) {
                h10.f();
                aVar2 = h10.p(true);
                h10.r();
                z10 = false;
            } else {
                aVar2 = null;
                z10 = true;
            }
            if (aVar2 != null) {
                h10.n();
                if (!h10.h().v()) {
                    h10.m();
                }
            } else if (a10.g()) {
                h10.f();
                a10.i(Okio.b(h10.c(j11, true)));
            } else {
                BufferedSink b10 = Okio.b(h10.c(j11, false));
                a10.i(b10);
                b10.close();
            }
        }
        if (a10 == null || !a10.g()) {
            h10.e();
        }
        if (aVar2 == null) {
            aVar2 = h10.p(false);
            j.d(aVar2);
            if (z10) {
                h10.r();
                z10 = false;
            }
        }
        a0 c10 = aVar2.s(j11).j(h10.h().r()).t(currentTimeMillis).r(System.currentTimeMillis()).c();
        int f10 = c10.f();
        if (f10 == 100) {
            a0.a p10 = h10.p(false);
            j.d(p10);
            if (z10) {
                h10.r();
            }
            c10 = p10.s(j11).j(h10.h().r()).t(currentTimeMillis).r(System.currentTimeMillis()).c();
            f10 = c10.f();
        }
        h10.q(c10);
        if (!this.f29655a || f10 != 101) {
            a0Var = c10.x().b(h10.o(c10)).c();
        } else {
            a0Var = c10.x().b(d.f24930c).c();
        }
        if (r.t(Close.ELEMENT, a0Var.F().d("Connection"), true) || r.t(Close.ELEMENT, a0.m(a0Var, "Connection", (String) null, 2, (Object) null), true)) {
            h10.m();
        }
        if (f10 == 204 || f10 == 205) {
            b0 a11 = a0Var.a();
            if (a11 == null) {
                j10 = -1;
            } else {
                j10 = a11.contentLength();
            }
            if (j10 > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("HTTP ");
                sb2.append(f10);
                sb2.append(" had non-zero Content-Length: ");
                b0 a12 = a0Var.a();
                if (a12 != null) {
                    l10 = Long.valueOf(a12.contentLength());
                }
                sb2.append(l10);
                throw new ProtocolException(sb2.toString());
            }
        }
        return a0Var;
    }
}
