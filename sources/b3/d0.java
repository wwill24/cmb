package b3;

import android.graphics.PointF;
import com.airbnb.lottie.h;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import x2.b;
import x2.m;
import y2.f;

class d0 {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f7764a = JsonReader.a.a("nm", XHTMLText.P, "s", StreamManagement.AckRequest.ELEMENT, "hd");

    static f a(JsonReader jsonReader, h hVar) throws IOException {
        String str = null;
        m<PointF, PointF> mVar = null;
        x2.f fVar = null;
        b bVar = null;
        boolean z10 = false;
        while (jsonReader.g()) {
            int y10 = jsonReader.y(f7764a);
            if (y10 == 0) {
                str = jsonReader.n();
            } else if (y10 == 1) {
                mVar = a.b(jsonReader, hVar);
            } else if (y10 == 2) {
                fVar = d.i(jsonReader, hVar);
            } else if (y10 == 3) {
                bVar = d.e(jsonReader, hVar);
            } else if (y10 != 4) {
                jsonReader.E();
            } else {
                z10 = jsonReader.h();
            }
        }
        return new f(str, mVar, fVar, bVar, z10);
    }
}
