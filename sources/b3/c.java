package b3;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.h;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mparticle.kits.ReportingMessage;
import d3.a;
import d3.d;
import java.io.IOException;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import x2.b;
import x2.e;
import x2.g;
import x2.i;
import x2.l;
import x2.m;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f7761a = JsonReader.a.a("a", XHTMLText.P, "s", "rz", StreamManagement.AckRequest.ELEMENT, ReportingMessage.MessageType.OPT_OUT, "so", "eo", "sk", "sa");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.a f7762b = JsonReader.a.a("k");

    private static boolean a(e eVar) {
        return eVar == null || (eVar.isStatic() && ((PointF) eVar.b().get(0).f14406b).equals(0.0f, 0.0f));
    }

    private static boolean b(m<PointF, PointF> mVar) {
        if (mVar == null || (!(mVar instanceof i) && mVar.isStatic() && ((PointF) mVar.b().get(0).f14406b).equals(0.0f, 0.0f))) {
            return true;
        }
        return false;
    }

    private static boolean c(b bVar) {
        return bVar == null || (bVar.isStatic() && ((Float) ((a) bVar.b().get(0)).f14406b).floatValue() == 0.0f);
    }

    private static boolean d(g gVar) {
        return gVar == null || (gVar.isStatic() && ((d) ((a) gVar.b().get(0)).f14406b).a(1.0f, 1.0f));
    }

    private static boolean e(b bVar) {
        return bVar == null || (bVar.isStatic() && ((Float) ((a) bVar.b().get(0)).f14406b).floatValue() == 0.0f);
    }

    private static boolean f(b bVar) {
        return bVar == null || (bVar.isStatic() && ((Float) ((a) bVar.b().get(0)).f14406b).floatValue() == 0.0f);
    }

    public static l g(JsonReader jsonReader, h hVar) throws IOException {
        boolean z10;
        e eVar;
        m<PointF, PointF> mVar;
        b bVar;
        b bVar2;
        b bVar3;
        boolean z11;
        JsonReader jsonReader2 = jsonReader;
        h hVar2 = hVar;
        boolean z12 = false;
        if (jsonReader.v() == JsonReader.Token.BEGIN_OBJECT) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            jsonReader.c();
        }
        b bVar4 = null;
        e eVar2 = null;
        m<PointF, PointF> mVar2 = null;
        g gVar = null;
        b bVar5 = null;
        b bVar6 = null;
        x2.d dVar = null;
        b bVar7 = null;
        b bVar8 = null;
        while (jsonReader.g()) {
            switch (jsonReader2.y(f7761a)) {
                case 0:
                    boolean z13 = z12;
                    jsonReader.c();
                    while (jsonReader.g()) {
                        if (jsonReader2.y(f7762b) != 0) {
                            jsonReader.C();
                            jsonReader.E();
                        } else {
                            eVar2 = a.a(jsonReader, hVar);
                        }
                    }
                    jsonReader.f();
                    z12 = z13;
                    continue;
                case 1:
                    boolean z14 = z12;
                    mVar2 = a.b(jsonReader, hVar);
                    continue;
                case 2:
                    boolean z15 = z12;
                    gVar = d.j(jsonReader, hVar);
                    continue;
                case 3:
                    hVar2.a("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    dVar = d.h(jsonReader, hVar);
                    continue;
                case 6:
                    bVar7 = d.f(jsonReader2, hVar2, z12);
                    continue;
                case 7:
                    bVar8 = d.f(jsonReader2, hVar2, z12);
                    continue;
                case 8:
                    bVar5 = d.f(jsonReader2, hVar2, z12);
                    continue;
                case 9:
                    bVar6 = d.f(jsonReader2, hVar2, z12);
                    continue;
                default:
                    boolean z16 = z12;
                    jsonReader.C();
                    jsonReader.E();
                    continue;
            }
            b f10 = d.f(jsonReader2, hVar2, z12);
            if (f10.b().isEmpty()) {
                a aVar = r1;
                a aVar2 = new a(hVar, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, 0.0f, Float.valueOf(hVar.f()));
                f10.b().add(aVar);
            } else if (((a) f10.b().get(0)).f14406b == null) {
                z11 = false;
                f10.b().set(0, new a(hVar, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, 0.0f, Float.valueOf(hVar.f())));
                z12 = z11;
                bVar4 = f10;
            }
            z11 = false;
            z12 = z11;
            bVar4 = f10;
        }
        if (z10) {
            jsonReader.f();
        }
        if (a(eVar2)) {
            eVar = null;
        } else {
            eVar = eVar2;
        }
        if (b(mVar2)) {
            mVar = null;
        } else {
            mVar = mVar2;
        }
        if (c(bVar4)) {
            bVar = null;
        } else {
            bVar = bVar4;
        }
        if (d(gVar)) {
            gVar = null;
        }
        if (f(bVar5)) {
            bVar2 = null;
        } else {
            bVar2 = bVar5;
        }
        if (e(bVar6)) {
            bVar3 = null;
        } else {
            bVar3 = bVar6;
        }
        return new l(eVar, mVar, gVar, bVar, dVar, bVar7, bVar8, bVar2, bVar3);
    }
}
