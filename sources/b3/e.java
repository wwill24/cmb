package b3;

import com.airbnb.lottie.h;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mparticle.kits.ReportingMessage;
import java.io.IOException;
import y2.a;

class e {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f7765a = JsonReader.a.a("ef");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.a f7766b = JsonReader.a.a("ty", ReportingMessage.MessageType.SCREEN_VIEW);

    private static a a(JsonReader jsonReader, h hVar) throws IOException {
        jsonReader.c();
        a aVar = null;
        while (true) {
            boolean z10 = false;
            while (true) {
                if (jsonReader.g()) {
                    int y10 = jsonReader.y(f7766b);
                    if (y10 != 0) {
                        if (y10 != 1) {
                            jsonReader.C();
                            jsonReader.E();
                        } else if (z10) {
                            aVar = new a(d.e(jsonReader, hVar));
                        } else {
                            jsonReader.E();
                        }
                    } else if (jsonReader.l() == 0) {
                        z10 = true;
                    }
                } else {
                    jsonReader.f();
                    return aVar;
                }
            }
        }
    }

    static a b(JsonReader jsonReader, h hVar) throws IOException {
        a aVar = null;
        while (jsonReader.g()) {
            if (jsonReader.y(f7765a) != 0) {
                jsonReader.C();
                jsonReader.E();
            } else {
                jsonReader.b();
                while (jsonReader.g()) {
                    a a10 = a(jsonReader, hVar);
                    if (a10 != null) {
                        aVar = a10;
                    }
                }
                jsonReader.e();
            }
        }
        return aVar;
    }
}
