package b3;

import com.airbnb.lottie.h;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import y2.l;

class k0 {

    /* renamed from: a  reason: collision with root package name */
    static JsonReader.a f7791a = JsonReader.a.a("nm", "ind", "ks", "hd");

    static l a(JsonReader jsonReader, h hVar) throws IOException {
        int i10 = 0;
        String str = null;
        x2.h hVar2 = null;
        boolean z10 = false;
        while (jsonReader.g()) {
            int y10 = jsonReader.y(f7791a);
            if (y10 == 0) {
                str = jsonReader.n();
            } else if (y10 == 1) {
                i10 = jsonReader.l();
            } else if (y10 == 2) {
                hVar2 = d.k(jsonReader, hVar);
            } else if (y10 != 3) {
                jsonReader.E();
            } else {
                z10 = jsonReader.h();
            }
        }
        return new l(str, i10, hVar2, z10);
    }
}
