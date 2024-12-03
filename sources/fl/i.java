package fl;

import java.net.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okhttp3.t;
import okhttp3.y;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¨\u0006\u000f"}, d2 = {"Lfl/i;", "", "Lokhttp3/y;", "request", "Ljava/net/Proxy$Type;", "proxyType", "", "b", "", "a", "Lokhttp3/t;", "url", "c", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f29674a = new i();

    private i() {
    }

    private final boolean b(y yVar, Proxy.Type type) {
        return !yVar.f() && type == Proxy.Type.HTTP;
    }

    public final String a(y yVar, Proxy.Type type) {
        j.g(yVar, "request");
        j.g(type, "proxyType");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(yVar.g());
        sb2.append(' ');
        i iVar = f29674a;
        if (iVar.b(yVar, type)) {
            sb2.append(yVar.j());
        } else {
            sb2.append(iVar.c(yVar.j()));
        }
        sb2.append(" HTTP/1.1");
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public final String c(t tVar) {
        j.g(tVar, "url");
        String d10 = tVar.d();
        String f10 = tVar.f();
        if (f10 == null) {
            return d10;
        }
        return d10 + '?' + f10;
    }
}
