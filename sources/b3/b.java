package b3;

import com.airbnb.lottie.h;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import x2.a;
import x2.k;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f7758a = JsonReader.a.a("a");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.a f7759b = JsonReader.a.a("fc", "sc", "sw", "t");

    public static k a(JsonReader jsonReader, h hVar) throws IOException {
        jsonReader.c();
        k kVar = null;
        while (jsonReader.g()) {
            if (jsonReader.y(f7758a) != 0) {
                jsonReader.C();
                jsonReader.E();
            } else {
                kVar = b(jsonReader, hVar);
            }
        }
        jsonReader.f();
        if (kVar == null) {
            return new k((a) null, (a) null, (x2.b) null, (x2.b) null);
        }
        return kVar;
    }

    private static k b(JsonReader jsonReader, h hVar) throws IOException {
        jsonReader.c();
        a aVar = null;
        a aVar2 = null;
        x2.b bVar = null;
        x2.b bVar2 = null;
        while (jsonReader.g()) {
            int y10 = jsonReader.y(f7759b);
            if (y10 == 0) {
                aVar = d.c(jsonReader, hVar);
            } else if (y10 == 1) {
                aVar2 = d.c(jsonReader, hVar);
            } else if (y10 == 2) {
                bVar = d.e(jsonReader, hVar);
            } else if (y10 != 3) {
                jsonReader.C();
                jsonReader.E();
            } else {
                bVar2 = d.e(jsonReader, hVar);
            }
        }
        jsonReader.f();
        return new k(aVar, aVar2, bVar, bVar2);
    }
}
