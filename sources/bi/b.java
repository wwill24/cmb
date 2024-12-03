package bi;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import java.io.IOException;

public final class b<T> extends h<T> {

    /* renamed from: a  reason: collision with root package name */
    private final h<T> f18955a;

    public b(h<T> hVar) {
        this.f18955a = hVar;
    }

    public T fromJson(JsonReader jsonReader) throws IOException {
        if (jsonReader.E() == JsonReader.Token.NULL) {
            return jsonReader.v();
        }
        return this.f18955a.fromJson(jsonReader);
    }

    public void toJson(q qVar, T t10) throws IOException {
        if (t10 == null) {
            qVar.v();
        } else {
            this.f18955a.toJson(qVar, t10);
        }
    }

    public String toString() {
        return this.f18955a + ".nullSafe()";
    }
}
