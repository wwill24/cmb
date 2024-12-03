package b3;

import com.airbnb.lottie.h;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.content.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mparticle.kits.ReportingMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import x2.b;
import x2.c;
import x2.d;
import x2.f;

class q {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f7802a = JsonReader.a.a("nm", "g", ReportingMessage.MessageType.OPT_OUT, "t", "s", ReportingMessage.MessageType.EVENT, "w", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.a f7803b = JsonReader.a.a(XHTMLText.P, "k");

    /* renamed from: c  reason: collision with root package name */
    private static final JsonReader.a f7804c = JsonReader.a.a("n", ReportingMessage.MessageType.SCREEN_VIEW);

    static a a(JsonReader jsonReader, h hVar) throws IOException {
        c cVar;
        GradientType gradientType;
        JsonReader jsonReader2 = jsonReader;
        h hVar2 = hVar;
        ArrayList arrayList = new ArrayList();
        float f10 = 0.0f;
        String str = null;
        GradientType gradientType2 = null;
        c cVar2 = null;
        f fVar = null;
        f fVar2 = null;
        b bVar = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        b bVar2 = null;
        boolean z10 = false;
        d dVar = null;
        while (jsonReader.g()) {
            switch (jsonReader2.y(f7802a)) {
                case 0:
                    str = jsonReader.n();
                    break;
                case 1:
                    int i10 = -1;
                    jsonReader.c();
                    while (jsonReader.g()) {
                        int y10 = jsonReader2.y(f7803b);
                        if (y10 != 0) {
                            cVar = cVar2;
                            if (y10 != 1) {
                                jsonReader.C();
                                jsonReader.E();
                            } else {
                                cVar2 = d.g(jsonReader2, hVar2, i10);
                            }
                        } else {
                            cVar = cVar2;
                            i10 = jsonReader.l();
                        }
                        cVar2 = cVar;
                    }
                    c cVar3 = cVar2;
                    jsonReader.f();
                    break;
                case 2:
                    dVar = d.h(jsonReader, hVar);
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
                    bVar = d.e(jsonReader, hVar);
                    break;
                case 7:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.l() - 1];
                    break;
                case 8:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.l() - 1];
                    break;
                case 9:
                    f10 = (float) jsonReader.k();
                    break;
                case 10:
                    z10 = jsonReader.h();
                    break;
                case 11:
                    jsonReader.b();
                    while (jsonReader.g()) {
                        jsonReader.c();
                        String str2 = null;
                        b bVar3 = null;
                        while (jsonReader.g()) {
                            int y11 = jsonReader2.y(f7804c);
                            if (y11 != 0) {
                                b bVar4 = bVar2;
                                if (y11 != 1) {
                                    jsonReader.C();
                                    jsonReader.E();
                                } else {
                                    bVar3 = d.e(jsonReader, hVar);
                                }
                                bVar2 = bVar4;
                            } else {
                                b bVar5 = bVar2;
                                str2 = jsonReader.n();
                            }
                        }
                        b bVar6 = bVar2;
                        jsonReader.f();
                        if (str2.equals(ReportingMessage.MessageType.OPT_OUT)) {
                            bVar2 = bVar3;
                        } else {
                            if (str2.equals("d") || str2.equals("g")) {
                                hVar2.u(true);
                                arrayList.add(bVar3);
                            }
                            bVar2 = bVar6;
                        }
                    }
                    b bVar7 = bVar2;
                    jsonReader.e();
                    if (arrayList.size() == 1) {
                        arrayList.add((b) arrayList.get(0));
                    }
                    bVar2 = bVar7;
                    break;
                default:
                    jsonReader.C();
                    jsonReader.E();
                    break;
            }
        }
        if (dVar == null) {
            dVar = new d(Collections.singletonList(new d3.a(100)));
        }
        return new a(str, gradientType2, cVar2, dVar, fVar, fVar2, bVar, lineCapType, lineJoinType, f10, arrayList, bVar2, z10);
    }
}
