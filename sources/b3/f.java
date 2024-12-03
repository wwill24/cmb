package b3;

import android.graphics.PointF;
import com.airbnb.lottie.h;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import x2.m;
import y2.b;

class f {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f7768a = JsonReader.a.a("nm", XHTMLText.P, "s", "hd", "d");

    static b a(JsonReader jsonReader, h hVar, int i10) throws IOException {
        boolean z10;
        if (i10 == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean z11 = z10;
        boolean z12 = false;
        String str = null;
        m<PointF, PointF> mVar = null;
        x2.f fVar = null;
        while (jsonReader.g()) {
            int y10 = jsonReader.y(f7768a);
            if (y10 == 0) {
                str = jsonReader.n();
            } else if (y10 == 1) {
                mVar = a.b(jsonReader, hVar);
            } else if (y10 == 2) {
                fVar = d.i(jsonReader, hVar);
            } else if (y10 == 3) {
                z12 = jsonReader.h();
            } else if (y10 != 4) {
                jsonReader.C();
                jsonReader.E();
            } else if (jsonReader.l() == 3) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        return new b(str, mVar, fVar, z11, z12);
    }
}
