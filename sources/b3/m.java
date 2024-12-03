package b3;

import com.airbnb.lottie.h;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import w2.c;
import y2.k;

class m {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f7795a = JsonReader.a.a("ch", "size", "w", "style", "fFamily", "data");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.a f7796b = JsonReader.a.a("shapes");

    static c a(JsonReader jsonReader, h hVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.c();
        String str = null;
        String str2 = null;
        double d10 = 0.0d;
        double d11 = 0.0d;
        char c10 = 0;
        while (jsonReader.g()) {
            int y10 = jsonReader.y(f7795a);
            if (y10 == 0) {
                c10 = jsonReader.n().charAt(0);
            } else if (y10 == 1) {
                d10 = jsonReader.k();
            } else if (y10 == 2) {
                d11 = jsonReader.k();
            } else if (y10 == 3) {
                str = jsonReader.n();
            } else if (y10 == 4) {
                str2 = jsonReader.n();
            } else if (y10 != 5) {
                jsonReader.C();
                jsonReader.E();
            } else {
                jsonReader.c();
                while (jsonReader.g()) {
                    if (jsonReader.y(f7796b) != 0) {
                        jsonReader.C();
                        jsonReader.E();
                    } else {
                        jsonReader.b();
                        while (jsonReader.g()) {
                            arrayList.add((k) h.a(jsonReader, hVar));
                        }
                        jsonReader.e();
                    }
                }
                jsonReader.f();
            }
        }
        jsonReader.f();
        return new c(arrayList, c10, d10, d11, str, str2);
    }
}
