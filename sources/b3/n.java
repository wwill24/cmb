package b3;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import w2.b;

class n {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f7798a = JsonReader.a.a("fFamily", "fName", "fStyle", "ascent");

    static b a(JsonReader jsonReader) throws IOException {
        jsonReader.c();
        String str = null;
        String str2 = null;
        float f10 = 0.0f;
        String str3 = null;
        while (jsonReader.g()) {
            int y10 = jsonReader.y(f7798a);
            if (y10 == 0) {
                str = jsonReader.n();
            } else if (y10 == 1) {
                str3 = jsonReader.n();
            } else if (y10 == 2) {
                str2 = jsonReader.n();
            } else if (y10 != 3) {
                jsonReader.C();
                jsonReader.E();
            } else {
                f10 = (float) jsonReader.k();
            }
        }
        jsonReader.f();
        return new b(str, str3, str2, f10);
    }
}
