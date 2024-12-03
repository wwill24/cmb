package b3;

import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.mparticle.kits.ReportingMessage;
import java.io.IOException;
import x2.b;

class m0 {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f7797a = JsonReader.a.a("s", ReportingMessage.MessageType.EVENT, ReportingMessage.MessageType.OPT_OUT, "nm", NetworkProfile.MALE, "hd");

    static ShapeTrimPath a(JsonReader jsonReader, h hVar) throws IOException {
        boolean z10 = false;
        String str = null;
        ShapeTrimPath.Type type = null;
        b bVar = null;
        b bVar2 = null;
        b bVar3 = null;
        while (jsonReader.g()) {
            int y10 = jsonReader.y(f7797a);
            if (y10 == 0) {
                bVar = d.f(jsonReader, hVar, false);
            } else if (y10 == 1) {
                bVar2 = d.f(jsonReader, hVar, false);
            } else if (y10 == 2) {
                bVar3 = d.f(jsonReader, hVar, false);
            } else if (y10 == 3) {
                str = jsonReader.n();
            } else if (y10 == 4) {
                type = ShapeTrimPath.Type.b(jsonReader.l());
            } else if (y10 != 5) {
                jsonReader.E();
            } else {
                z10 = jsonReader.h();
            }
        }
        return new ShapeTrimPath(str, type, bVar, bVar2, bVar3, z10);
    }
}
