package b3;

import com.airbnb.lottie.h;
import com.airbnb.lottie.parser.moshi.JsonReader;
import d3.a;
import java.io.IOException;
import java.util.List;
import x2.b;
import x2.c;
import x2.f;
import x2.g;
import x2.j;

public class d {
    private static <T> List<a<T>> a(JsonReader jsonReader, float f10, h hVar, n0<T> n0Var) throws IOException {
        return u.a(jsonReader, hVar, f10, n0Var, false);
    }

    private static <T> List<a<T>> b(JsonReader jsonReader, h hVar, n0<T> n0Var) throws IOException {
        return u.a(jsonReader, hVar, 1.0f, n0Var, false);
    }

    static x2.a c(JsonReader jsonReader, h hVar) throws IOException {
        return new x2.a(b(jsonReader, hVar, g.f7770a));
    }

    static j d(JsonReader jsonReader, h hVar) throws IOException {
        return new j(a(jsonReader, c3.j.e(), hVar, i.f7775a));
    }

    public static b e(JsonReader jsonReader, h hVar) throws IOException {
        return f(jsonReader, hVar, true);
    }

    public static b f(JsonReader jsonReader, h hVar, boolean z10) throws IOException {
        float f10;
        if (z10) {
            f10 = c3.j.e();
        } else {
            f10 = 1.0f;
        }
        return new b(a(jsonReader, f10, hVar, l.f7792a));
    }

    static c g(JsonReader jsonReader, h hVar, int i10) throws IOException {
        return new c(b(jsonReader, hVar, new o(i10)));
    }

    static x2.d h(JsonReader jsonReader, h hVar) throws IOException {
        return new x2.d(b(jsonReader, hVar, r.f7805a));
    }

    static f i(JsonReader jsonReader, h hVar) throws IOException {
        return new f(u.a(jsonReader, hVar, c3.j.e(), b0.f7760a, true));
    }

    static g j(JsonReader jsonReader, h hVar) throws IOException {
        return new g(b(jsonReader, hVar, g0.f7771a));
    }

    static x2.h k(JsonReader jsonReader, h hVar) throws IOException {
        return new x2.h(a(jsonReader, c3.j.e(), hVar, h0.f7773a));
    }
}
