package b3;

import com.airbnb.lottie.h;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import y2.c;
import y2.k;

class j0 {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f7783a = JsonReader.a.a("nm", "hd", "it");

    static k a(JsonReader jsonReader, h hVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z10 = false;
        while (jsonReader.g()) {
            int y10 = jsonReader.y(f7783a);
            if (y10 == 0) {
                str = jsonReader.n();
            } else if (y10 == 1) {
                z10 = jsonReader.h();
            } else if (y10 != 2) {
                jsonReader.E();
            } else {
                jsonReader.b();
                while (jsonReader.g()) {
                    c a10 = h.a(jsonReader, hVar);
                    if (a10 != null) {
                        arrayList.add(a10);
                    }
                }
                jsonReader.e();
            }
        }
        return new k(str, arrayList, z10);
    }
}
