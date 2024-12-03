package bi;

import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import java.io.IOException;

public final class a<T> extends h<T> {

    /* renamed from: a  reason: collision with root package name */
    private final h<T> f18954a;

    public a(h<T> hVar) {
        this.f18954a = hVar;
    }

    public T fromJson(JsonReader jsonReader) throws IOException {
        if (jsonReader.E() != JsonReader.Token.NULL) {
            return this.f18954a.fromJson(jsonReader);
        }
        throw new JsonDataException("Unexpected null at " + jsonReader.getPath());
    }

    public void toJson(q qVar, T t10) throws IOException {
        if (t10 != null) {
            this.f18954a.toJson(qVar, t10);
            return;
        }
        throw new JsonDataException("Unexpected null at " + qVar.getPath());
    }

    public String toString() {
        return this.f18954a + ".nonNull()";
    }
}
