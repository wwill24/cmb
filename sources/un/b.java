package un;

import com.squareup.moshi.h;
import com.squareup.moshi.q;
import java.io.IOException;
import okhttp3.v;
import okhttp3.z;
import okio.Buffer;
import retrofit2.f;

final class b<T> implements f<T, z> {

    /* renamed from: b  reason: collision with root package name */
    private static final v f42480b = v.e("application/json; charset=UTF-8");

    /* renamed from: a  reason: collision with root package name */
    private final h<T> f42481a;

    b(h<T> hVar) {
        this.f42481a = hVar;
    }

    /* renamed from: a */
    public z convert(T t10) throws IOException {
        Buffer buffer = new Buffer();
        this.f42481a.toJson(q.x(buffer), t10);
        return z.e(f42480b, buffer.y1());
    }
}
