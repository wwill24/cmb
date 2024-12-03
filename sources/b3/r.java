package b3;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class r implements n0<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final r f7805a = new r();

    private r() {
    }

    /* renamed from: b */
    public Integer a(JsonReader jsonReader, float f10) throws IOException {
        return Integer.valueOf(Math.round(s.g(jsonReader) * f10));
    }
}
