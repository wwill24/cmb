package b3;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class b0 implements n0<PointF> {

    /* renamed from: a  reason: collision with root package name */
    public static final b0 f7760a = new b0();

    private b0() {
    }

    /* renamed from: b */
    public PointF a(JsonReader jsonReader, float f10) throws IOException {
        JsonReader.Token v10 = jsonReader.v();
        if (v10 == JsonReader.Token.BEGIN_ARRAY) {
            return s.e(jsonReader, f10);
        }
        if (v10 == JsonReader.Token.BEGIN_OBJECT) {
            return s.e(jsonReader, f10);
        }
        if (v10 == JsonReader.Token.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.k()) * f10, ((float) jsonReader.k()) * f10);
            while (jsonReader.g()) {
                jsonReader.E();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + v10);
    }
}
