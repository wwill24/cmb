package b3;

import c3.j;
import com.airbnb.lottie.h;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import u2.i;

class z {
    static i a(JsonReader jsonReader, h hVar) throws IOException {
        boolean z10;
        if (jsonReader.v() == JsonReader.Token.BEGIN_OBJECT) {
            z10 = true;
        } else {
            z10 = false;
        }
        return new i(hVar, t.c(jsonReader, hVar, j.e(), a0.f7757a, z10, false));
    }
}
