package b3;

import android.graphics.Path;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mparticle.kits.ReportingMessage;
import d3.a;
import java.io.IOException;
import java.util.Collections;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import x2.b;
import x2.c;
import x2.d;
import x2.f;
import y2.e;

class p {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f7800a = JsonReader.a.a("nm", "g", ReportingMessage.MessageType.OPT_OUT, "t", "s", ReportingMessage.MessageType.EVENT, StreamManagement.AckRequest.ELEMENT, "hd");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.a f7801b = JsonReader.a.a(XHTMLText.P, "k");

    static e a(JsonReader jsonReader, h hVar) throws IOException {
        d dVar;
        GradientType gradientType;
        Path.FillType fillType;
        d dVar2 = null;
        Path.FillType fillType2 = Path.FillType.WINDING;
        String str = null;
        GradientType gradientType2 = null;
        c cVar = null;
        f fVar = null;
        f fVar2 = null;
        boolean z10 = false;
        while (jsonReader.g()) {
            switch (jsonReader.y(f7800a)) {
                case 0:
                    str = jsonReader.n();
                    break;
                case 1:
                    int i10 = -1;
                    jsonReader.c();
                    while (jsonReader.g()) {
                        int y10 = jsonReader.y(f7801b);
                        if (y10 == 0) {
                            i10 = jsonReader.l();
                        } else if (y10 != 1) {
                            jsonReader.C();
                            jsonReader.E();
                        } else {
                            cVar = d.g(jsonReader, hVar, i10);
                        }
                    }
                    jsonReader.f();
                    break;
                case 2:
                    dVar2 = d.h(jsonReader, hVar);
                    break;
                case 3:
                    if (jsonReader.l() == 1) {
                        gradientType = GradientType.LINEAR;
                    } else {
                        gradientType = GradientType.RADIAL;
                    }
                    gradientType2 = gradientType;
                    break;
                case 4:
                    fVar = d.i(jsonReader, hVar);
                    break;
                case 5:
                    fVar2 = d.i(jsonReader, hVar);
                    break;
                case 6:
                    if (jsonReader.l() == 1) {
                        fillType = Path.FillType.WINDING;
                    } else {
                        fillType = Path.FillType.EVEN_ODD;
                    }
                    fillType2 = fillType;
                    break;
                case 7:
                    z10 = jsonReader.h();
                    break;
                default:
                    jsonReader.C();
                    jsonReader.E();
                    break;
            }
        }
        if (dVar2 == null) {
            dVar = new d(Collections.singletonList(new a(100)));
        } else {
            dVar = dVar2;
        }
        return new e(str, gradientType2, fillType2, cVar, dVar, fVar, fVar2, (b) null, (b) null, z10);
    }
}
