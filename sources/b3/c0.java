package b3;

import android.graphics.PointF;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.softwareinfo.form.SoftwareInfoForm;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import x2.b;
import x2.m;

class c0 {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f7763a = JsonReader.a.a("nm", "sy", "pt", XHTMLText.P, StreamManagement.AckRequest.ELEMENT, "or", SoftwareInfoForm.OS, "ir", "is", "hd", "d");

    static PolystarShape a(JsonReader jsonReader, h hVar, int i10) throws IOException {
        boolean z10;
        JsonReader jsonReader2 = jsonReader;
        h hVar2 = hVar;
        if (i10 == 3) {
            z10 = true;
        } else {
            z10 = false;
        }
        boolean z11 = false;
        boolean z12 = z10;
        String str = null;
        PolystarShape.Type type = null;
        b bVar = null;
        m<PointF, PointF> mVar = null;
        b bVar2 = null;
        b bVar3 = null;
        b bVar4 = null;
        b bVar5 = null;
        b bVar6 = null;
        while (jsonReader.g()) {
            switch (jsonReader2.y(f7763a)) {
                case 0:
                    str = jsonReader.n();
                    break;
                case 1:
                    type = PolystarShape.Type.b(jsonReader.l());
                    break;
                case 2:
                    bVar = d.f(jsonReader2, hVar2, false);
                    break;
                case 3:
                    mVar = a.b(jsonReader, hVar);
                    break;
                case 4:
                    bVar2 = d.f(jsonReader2, hVar2, false);
                    break;
                case 5:
                    bVar4 = d.e(jsonReader, hVar);
                    break;
                case 6:
                    bVar6 = d.f(jsonReader2, hVar2, false);
                    break;
                case 7:
                    bVar3 = d.e(jsonReader, hVar);
                    break;
                case 8:
                    bVar5 = d.f(jsonReader2, hVar2, false);
                    break;
                case 9:
                    z11 = jsonReader.h();
                    break;
                case 10:
                    if (jsonReader.l() != 3) {
                        z12 = false;
                        break;
                    } else {
                        z12 = true;
                        break;
                    }
                default:
                    jsonReader.C();
                    jsonReader.E();
                    break;
            }
        }
        return new PolystarShape(str, type, bVar, mVar, bVar2, bVar3, bVar4, bVar5, bVar6, z11, z12);
    }
}
