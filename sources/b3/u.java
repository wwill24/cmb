package b3;

import com.airbnb.lottie.h;
import com.airbnb.lottie.parser.moshi.JsonReader;
import d3.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import u2.i;

class u {

    /* renamed from: a  reason: collision with root package name */
    static JsonReader.a f7812a = JsonReader.a.a("k");

    static <T> List<a<T>> a(JsonReader jsonReader, h hVar, float f10, n0<T> n0Var, boolean z10) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.v() == JsonReader.Token.STRING) {
            hVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.c();
        while (jsonReader.g()) {
            if (jsonReader.y(f7812a) != 0) {
                jsonReader.E();
            } else if (jsonReader.v() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.b();
                if (jsonReader.v() == JsonReader.Token.NUMBER) {
                    arrayList.add(t.c(jsonReader, hVar, f10, n0Var, false, z10));
                } else {
                    while (jsonReader.g()) {
                        arrayList.add(t.c(jsonReader, hVar, f10, n0Var, true, z10));
                    }
                }
                jsonReader.e();
            } else {
                arrayList.add(t.c(jsonReader, hVar, f10, n0Var, false, z10));
            }
        }
        jsonReader.f();
        b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends a<T>> list) {
        int i10;
        T t10;
        int size = list.size();
        int i11 = 0;
        while (true) {
            i10 = size - 1;
            if (i11 >= i10) {
                break;
            }
            a aVar = (a) list.get(i11);
            i11++;
            a aVar2 = (a) list.get(i11);
            aVar.f14412h = Float.valueOf(aVar2.f14411g);
            if (aVar.f14407c == null && (t10 = aVar2.f14406b) != null) {
                aVar.f14407c = t10;
                if (aVar instanceof i) {
                    ((i) aVar).j();
                }
            }
        }
        a aVar3 = (a) list.get(i10);
        if ((aVar3.f14406b == null || aVar3.f14407c == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}
