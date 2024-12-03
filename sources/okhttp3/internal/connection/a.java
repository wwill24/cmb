package okhttp3.internal.connection;

import fl.g;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import okhttp3.a0;
import okhttp3.u;
import okhttp3.y;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lokhttp3/internal/connection/a;", "Lokhttp3/u;", "Lokhttp3/u$a;", "chain", "Lokhttp3/a0;", "intercept", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class a implements u {

    /* renamed from: a  reason: collision with root package name */
    public static final a f33015a = new a();

    private a() {
    }

    public a0 intercept(u.a aVar) throws IOException {
        j.g(aVar, "chain");
        g gVar = (g) aVar;
        return g.d(gVar, 0, gVar.e().u(gVar), (y) null, 0, 0, 0, 61, (Object) null).a(gVar.j());
    }
}
