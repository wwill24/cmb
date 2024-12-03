package b3;

import android.graphics.Path;
import com.airbnb.lottie.h;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mparticle.kits.ReportingMessage;
import java.io.IOException;
import java.util.Collections;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import x2.a;
import x2.d;
import y2.j;

class i0 {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f7777a = JsonReader.a.a("nm", "c", ReportingMessage.MessageType.OPT_OUT, "fillEnabled", StreamManagement.AckRequest.ELEMENT, "hd");

    static j a(JsonReader jsonReader, h hVar) throws IOException {
        d dVar;
        Path.FillType fillType;
        d dVar2 = null;
        boolean z10 = false;
        boolean z11 = false;
        int i10 = 1;
        String str = null;
        a aVar = null;
        while (jsonReader.g()) {
            int y10 = jsonReader.y(f7777a);
            if (y10 == 0) {
                str = jsonReader.n();
            } else if (y10 == 1) {
                aVar = d.c(jsonReader, hVar);
            } else if (y10 == 2) {
                dVar2 = d.h(jsonReader, hVar);
            } else if (y10 == 3) {
                z10 = jsonReader.h();
            } else if (y10 == 4) {
                i10 = jsonReader.l();
            } else if (y10 != 5) {
                jsonReader.C();
                jsonReader.E();
            } else {
                z11 = jsonReader.h();
            }
        }
        if (dVar2 == null) {
            dVar = new d(Collections.singletonList(new d3.a(100)));
        } else {
            dVar = dVar2;
        }
        if (i10 == 1) {
            fillType = Path.FillType.WINDING;
        } else {
            fillType = Path.FillType.EVEN_ODD;
        }
        return new j(str, z10, fillType, aVar, dVar, z11);
    }
}
