package un;

import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import java.io.IOException;
import okhttp3.b0;
import okio.BufferedSource;
import okio.ByteString;
import retrofit2.f;

final class c<T> implements f<b0, T> {

    /* renamed from: b  reason: collision with root package name */
    private static final ByteString f42482b = ByteString.c("EFBBBF");

    /* renamed from: a  reason: collision with root package name */
    private final h<T> f42483a;

    c(h<T> hVar) {
        this.f42483a = hVar;
    }

    /* renamed from: a */
    public T convert(b0 b0Var) throws IOException {
        BufferedSource source = b0Var.source();
        try {
            ByteString byteString = f42482b;
            if (source.j0(0, byteString)) {
                source.skip((long) byteString.H());
            }
            JsonReader C = JsonReader.C(source);
            T fromJson = this.f42483a.fromJson(C);
            if (C.E() == JsonReader.Token.END_DOCUMENT) {
                return fromJson;
            }
            throw new JsonDataException("JSON document was not fully consumed.");
        } finally {
            b0Var.close();
        }
    }
}
