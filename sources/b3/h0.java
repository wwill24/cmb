package b3;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mparticle.kits.ReportingMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import w2.a;
import y2.i;

public class h0 implements n0<i> {

    /* renamed from: a  reason: collision with root package name */
    public static final h0 f7773a = new h0();

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.a f7774b = JsonReader.a.a("c", ReportingMessage.MessageType.SCREEN_VIEW, "i", ReportingMessage.MessageType.OPT_OUT);

    private h0() {
    }

    /* renamed from: b */
    public i a(JsonReader jsonReader, float f10) throws IOException {
        if (jsonReader.v() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.b();
        }
        jsonReader.c();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z10 = false;
        while (jsonReader.g()) {
            int y10 = jsonReader.y(f7774b);
            if (y10 == 0) {
                z10 = jsonReader.h();
            } else if (y10 == 1) {
                list = s.f(jsonReader, f10);
            } else if (y10 == 2) {
                list2 = s.f(jsonReader, f10);
            } else if (y10 != 3) {
                jsonReader.C();
                jsonReader.E();
            } else {
                list3 = s.f(jsonReader, f10);
            }
        }
        jsonReader.f();
        if (jsonReader.v() == JsonReader.Token.END_ARRAY) {
            jsonReader.e();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        } else if (list.isEmpty()) {
            return new i(new PointF(), false, Collections.emptyList());
        } else {
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i10 = 1; i10 < size; i10++) {
                PointF pointF2 = list.get(i10);
                int i11 = i10 - 1;
                arrayList.add(new a(c3.i.a(list.get(i11), list3.get(i11)), c3.i.a(pointF2, list2.get(i10)), pointF2));
            }
            if (z10) {
                PointF pointF3 = list.get(0);
                int i12 = size - 1;
                arrayList.add(new a(c3.i.a(list.get(i12), list3.get(i12)), c3.i.a(pointF3, list2.get(0)), pointF3));
            }
            return new i(pointF, z10, arrayList);
        }
    }
}
