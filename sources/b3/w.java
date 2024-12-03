package b3;

import android.graphics.Rect;
import androidx.collection.e;
import c3.f;
import c3.j;
import com.airbnb.lottie.d0;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mparticle.kits.ReportingMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import w2.b;
import w2.c;
import w2.g;

public class w {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f7817a = JsonReader.a.a("w", "h", "ip", "op", ReportingMessage.MessageType.FIRST_RUN, ReportingMessage.MessageType.SCREEN_VIEW, "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: b  reason: collision with root package name */
    static JsonReader.a f7818b = JsonReader.a.a("id", "layers", "w", "h", XHTMLText.P, "u");

    /* renamed from: c  reason: collision with root package name */
    private static final JsonReader.a f7819c = JsonReader.a.a("list");

    /* renamed from: d  reason: collision with root package name */
    private static final JsonReader.a f7820d = JsonReader.a.a(ReportingMessage.MessageType.COMMERCE_EVENT, "tm", "dr");

    public static h a(JsonReader jsonReader) throws IOException {
        ArrayList arrayList;
        HashMap hashMap;
        JsonReader jsonReader2 = jsonReader;
        float e10 = j.e();
        e eVar = new e();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        androidx.collection.h hVar = new androidx.collection.h();
        h hVar2 = new h();
        jsonReader.c();
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        int i10 = 0;
        int i11 = 0;
        while (jsonReader.g()) {
            switch (jsonReader2.y(f7817a)) {
                case 0:
                    HashMap hashMap5 = hashMap4;
                    ArrayList arrayList4 = arrayList3;
                    i10 = jsonReader.l();
                    continue;
                case 1:
                    HashMap hashMap6 = hashMap4;
                    ArrayList arrayList5 = arrayList3;
                    i11 = jsonReader.l();
                    continue;
                case 2:
                    HashMap hashMap7 = hashMap4;
                    ArrayList arrayList6 = arrayList3;
                    f10 = (float) jsonReader.k();
                    continue;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f11 = ((float) jsonReader.k()) - 0.01f;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f12 = (float) jsonReader.k();
                    break;
                case 5:
                    String[] split = jsonReader.n().split("\\.");
                    if (!j.j(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        hVar2.a("Lottie only supports bodymovin >= 4.4.0");
                        break;
                    }
                    break;
                case 6:
                    e(jsonReader2, hVar2, arrayList2, eVar);
                    break;
                case 7:
                    b(jsonReader2, hVar2, hashMap2, hashMap3);
                    break;
                case 8:
                    d(jsonReader2, hashMap4);
                    break;
                case 9:
                    c(jsonReader2, hVar2, hVar);
                    break;
                case 10:
                    f(jsonReader2, arrayList3);
                    break;
                default:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    jsonReader.C();
                    jsonReader.E();
                    break;
            }
            hashMap = hashMap4;
            arrayList = arrayList3;
            hashMap4 = hashMap;
            arrayList3 = arrayList;
            jsonReader2 = jsonReader;
        }
        ArrayList arrayList7 = arrayList3;
        hVar2.s(new Rect(0, 0, (int) (((float) i10) * e10), (int) (((float) i11) * e10)), f10, f11, f12, arrayList2, eVar, hashMap2, hashMap3, hVar, hashMap4, arrayList3);
        return hVar2;
    }

    private static void b(JsonReader jsonReader, h hVar, Map<String, List<Layer>> map, Map<String, d0> map2) throws IOException {
        jsonReader.b();
        while (jsonReader.g()) {
            ArrayList arrayList = new ArrayList();
            e eVar = new e();
            jsonReader.c();
            int i10 = 0;
            int i11 = 0;
            String str = null;
            String str2 = null;
            String str3 = null;
            while (jsonReader.g()) {
                int y10 = jsonReader.y(f7818b);
                if (y10 == 0) {
                    str = jsonReader.n();
                } else if (y10 == 1) {
                    jsonReader.b();
                    while (jsonReader.g()) {
                        Layer b10 = v.b(jsonReader, hVar);
                        eVar.l(b10.d(), b10);
                        arrayList.add(b10);
                    }
                    jsonReader.e();
                } else if (y10 == 2) {
                    i10 = jsonReader.l();
                } else if (y10 == 3) {
                    i11 = jsonReader.l();
                } else if (y10 == 4) {
                    str2 = jsonReader.n();
                } else if (y10 != 5) {
                    jsonReader.C();
                    jsonReader.E();
                } else {
                    str3 = jsonReader.n();
                }
            }
            jsonReader.f();
            if (str2 != null) {
                d0 d0Var = new d0(i10, i11, str, str2, str3);
                map2.put(d0Var.d(), d0Var);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.e();
    }

    private static void c(JsonReader jsonReader, h hVar, androidx.collection.h<c> hVar2) throws IOException {
        jsonReader.b();
        while (jsonReader.g()) {
            c a10 = m.a(jsonReader, hVar);
            hVar2.k(a10.hashCode(), a10);
        }
        jsonReader.e();
    }

    private static void d(JsonReader jsonReader, Map<String, b> map) throws IOException {
        jsonReader.c();
        while (jsonReader.g()) {
            if (jsonReader.y(f7819c) != 0) {
                jsonReader.C();
                jsonReader.E();
            } else {
                jsonReader.b();
                while (jsonReader.g()) {
                    b a10 = n.a(jsonReader);
                    map.put(a10.b(), a10);
                }
                jsonReader.e();
            }
        }
        jsonReader.f();
    }

    private static void e(JsonReader jsonReader, h hVar, List<Layer> list, e<Layer> eVar) throws IOException {
        jsonReader.b();
        int i10 = 0;
        while (jsonReader.g()) {
            Layer b10 = v.b(jsonReader, hVar);
            if (b10.f() == Layer.LayerType.IMAGE) {
                i10++;
            }
            list.add(b10);
            eVar.l(b10.d(), b10);
            if (i10 > 4) {
                f.c("You have " + i10 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.e();
    }

    private static void f(JsonReader jsonReader, List<g> list) throws IOException {
        jsonReader.b();
        while (jsonReader.g()) {
            String str = null;
            jsonReader.c();
            float f10 = 0.0f;
            float f11 = 0.0f;
            while (jsonReader.g()) {
                int y10 = jsonReader.y(f7820d);
                if (y10 == 0) {
                    str = jsonReader.n();
                } else if (y10 == 1) {
                    f10 = (float) jsonReader.k();
                } else if (y10 != 2) {
                    jsonReader.C();
                    jsonReader.E();
                } else {
                    f11 = (float) jsonReader.k();
                }
            }
            jsonReader.f();
            list.add(new g(str, f10, f11));
        }
        jsonReader.e();
    }
}
