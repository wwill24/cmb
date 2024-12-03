package b3;

import com.airbnb.lottie.h;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mparticle.kits.ReportingMessage;
import java.io.IOException;
import x2.b;
import x2.l;
import y2.g;

class e0 {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f7767a = JsonReader.a.a("nm", "c", ReportingMessage.MessageType.OPT_OUT, "tr", "hd");

    static g a(JsonReader jsonReader, h hVar) throws IOException {
        boolean z10 = false;
        String str = null;
        b bVar = null;
        b bVar2 = null;
        l lVar = null;
        while (jsonReader.g()) {
            int y10 = jsonReader.y(f7767a);
            if (y10 == 0) {
                str = jsonReader.n();
            } else if (y10 == 1) {
                bVar = d.f(jsonReader, hVar, false);
            } else if (y10 == 2) {
                bVar2 = d.f(jsonReader, hVar, false);
            } else if (y10 == 3) {
                lVar = c.g(jsonReader, hVar);
            } else if (y10 != 4) {
                jsonReader.E();
            } else {
                z10 = jsonReader.h();
            }
        }
        return new g(str, bVar, bVar2, lVar, z10);
    }
}
