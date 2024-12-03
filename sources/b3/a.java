package b3;

import android.graphics.PointF;
import c3.j;
import com.airbnb.lottie.h;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import x2.b;
import x2.e;
import x2.i;
import x2.m;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f7756a = JsonReader.a.a("k", "x", "y");

    public static e a(JsonReader jsonReader, h hVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.v() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.b();
            while (jsonReader.g()) {
                arrayList.add(z.a(jsonReader, hVar));
            }
            jsonReader.e();
            u.b(arrayList);
        } else {
            arrayList.add(new d3.a(s.e(jsonReader, j.e())));
        }
        return new e(arrayList);
    }

    static m<PointF, PointF> b(JsonReader jsonReader, h hVar) throws IOException {
        jsonReader.c();
        e eVar = null;
        b bVar = null;
        boolean z10 = false;
        b bVar2 = null;
        while (jsonReader.v() != JsonReader.Token.END_OBJECT) {
            int y10 = jsonReader.y(f7756a);
            if (y10 != 0) {
                if (y10 != 1) {
                    if (y10 != 2) {
                        jsonReader.C();
                        jsonReader.E();
                    } else if (jsonReader.v() == JsonReader.Token.STRING) {
                        jsonReader.E();
                    } else {
                        bVar = d.e(jsonReader, hVar);
                    }
                } else if (jsonReader.v() == JsonReader.Token.STRING) {
                    jsonReader.E();
                } else {
                    bVar2 = d.e(jsonReader, hVar);
                }
                z10 = true;
            } else {
                eVar = a(jsonReader, hVar);
            }
        }
        jsonReader.f();
        if (z10) {
            hVar.a("Lottie doesn't support expressions.");
        }
        if (eVar != null) {
            return eVar;
        }
        return new i(bVar2, bVar);
    }
}
