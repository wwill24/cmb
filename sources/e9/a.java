package e9;

import android.os.Build;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import okhttp3.a0;
import okhttp3.u;
import okhttp3.y;

public class a implements u {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f14609a;

    /* renamed from: b  reason: collision with root package name */
    private final ka.a f14610b;

    public a(Map<String, String> map, ka.a aVar) {
        this.f14609a = map;
        this.f14610b = aVar;
    }

    public void a(Map<String, String> map) {
        this.f14609a = map;
    }

    public a0 intercept(u.a aVar) throws IOException {
        y.a a10 = aVar.g().h().j("User-Agent").a("User-Agent", String.format("CMB/%s (%s; Android %s)", new Object[]{"6.32.0", Build.DEVICE, Build.VERSION.RELEASE})).a("Request-Id", UUID.randomUUID().toString());
        for (Map.Entry next : this.f14609a.entrySet()) {
            a10.f(next.getKey().toString(), next.getValue().toString());
        }
        a0 a11 = aVar.a(a10.b());
        this.f14610b.a(a11);
        return a11;
    }
}
