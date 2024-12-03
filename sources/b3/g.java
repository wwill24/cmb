package b3;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class g implements n0<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final g f7770a = new g();

    private g() {
    }

    /* renamed from: b */
    public Integer a(JsonReader jsonReader, float f10) throws IOException {
        boolean z10;
        double d10;
        if (jsonReader.v() == JsonReader.Token.BEGIN_ARRAY) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            jsonReader.b();
        }
        double k10 = jsonReader.k();
        double k11 = jsonReader.k();
        double k12 = jsonReader.k();
        if (jsonReader.v() == JsonReader.Token.NUMBER) {
            d10 = jsonReader.k();
        } else {
            d10 = 1.0d;
        }
        if (z10) {
            jsonReader.e();
        }
        if (k10 <= 1.0d && k11 <= 1.0d && k12 <= 1.0d) {
            k10 *= 255.0d;
            k11 *= 255.0d;
            k12 *= 255.0d;
            if (d10 <= 1.0d) {
                d10 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) d10, (int) k10, (int) k11, (int) k12));
    }
}
