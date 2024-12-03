package b3;

import com.airbnb.lottie.parser.moshi.JsonReader;
import d3.d;
import java.io.IOException;

public class g0 implements n0<d> {

    /* renamed from: a  reason: collision with root package name */
    public static final g0 f7771a = new g0();

    private g0() {
    }

    /* renamed from: b */
    public d a(JsonReader jsonReader, float f10) throws IOException {
        boolean z10;
        if (jsonReader.v() == JsonReader.Token.BEGIN_ARRAY) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            jsonReader.b();
        }
        float k10 = (float) jsonReader.k();
        float k11 = (float) jsonReader.k();
        while (jsonReader.g()) {
            jsonReader.E();
        }
        if (z10) {
            jsonReader.e();
        }
        return new d((k10 / 100.0f) * f10, (k11 / 100.0f) * f10);
    }
}
