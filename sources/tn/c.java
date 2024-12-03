package tn;

import com.google.gson.JsonIOException;
import com.google.gson.d;
import com.google.gson.q;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import okhttp3.b0;
import retrofit2.f;

final class c<T> implements f<b0, T> {

    /* renamed from: a  reason: collision with root package name */
    private final d f42474a;

    /* renamed from: b  reason: collision with root package name */
    private final q<T> f42475b;

    c(d dVar, q<T> qVar) {
        this.f42474a = dVar;
        this.f42475b = qVar;
    }

    /* renamed from: a */
    public T convert(b0 b0Var) throws IOException {
        JsonReader r10 = this.f42474a.r(b0Var.charStream());
        try {
            T b10 = this.f42475b.b(r10);
            if (r10.peek() == JsonToken.END_DOCUMENT) {
                return b10;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            b0Var.close();
        }
    }
}
