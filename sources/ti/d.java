package ti;

import com.squareup.moshi.JsonReader;
import kotlin.jvm.internal.j;

public final class d {
    public static final String a(JsonReader jsonReader) {
        j.g(jsonReader, "<this>");
        if (jsonReader.E() != JsonReader.Token.NULL) {
            return jsonReader.y();
        }
        return (String) jsonReader.v();
    }
}
