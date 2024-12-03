package b3;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import x2.b;
import y2.h;

public class f0 {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f7769a = JsonReader.a.a("nm", StreamManagement.AckRequest.ELEMENT, "hd");

    static h a(JsonReader jsonReader, com.airbnb.lottie.h hVar) throws IOException {
        boolean z10 = false;
        String str = null;
        b bVar = null;
        while (jsonReader.g()) {
            int y10 = jsonReader.y(f7769a);
            if (y10 == 0) {
                str = jsonReader.n();
            } else if (y10 == 1) {
                bVar = d.f(jsonReader, hVar, true);
            } else if (y10 != 2) {
                jsonReader.E();
            } else {
                z10 = jsonReader.h();
            }
        }
        if (z10) {
            return null;
        }
        return new h(str, bVar);
    }
}
