package e9;

import c7.a;
import java.io.IOException;
import okhttp3.a0;
import okhttp3.u;
import okhttp3.y;

public class b implements u {
    public a0 intercept(u.a aVar) throws IOException {
        y g10 = aVar.g();
        a0 a10 = aVar.a(g10);
        String a11 = a.a("CmbRestLoggingInterceptor");
        String g11 = g10.g();
        String tVar = g10.j().toString();
        int f10 = a10.f();
        fa.a.k(a11, a.b(g11, tVar));
        fa.a.j(a11, a.c(g11, tVar, f10));
        return a10;
    }
}
