package tn;

import com.google.gson.d;
import com.google.gson.q;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.v;
import okhttp3.z;
import okio.Buffer;
import retrofit2.f;

final class b<T> implements f<T, z> {

    /* renamed from: c  reason: collision with root package name */
    private static final v f42470c = v.e("application/json; charset=UTF-8");

    /* renamed from: d  reason: collision with root package name */
    private static final Charset f42471d = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    private final d f42472a;

    /* renamed from: b  reason: collision with root package name */
    private final q<T> f42473b;

    b(d dVar, q<T> qVar) {
        this.f42472a = dVar;
        this.f42473b = qVar;
    }

    /* renamed from: a */
    public z convert(T t10) throws IOException {
        Buffer buffer = new Buffer();
        JsonWriter s10 = this.f42472a.s(new OutputStreamWriter(buffer.x(), f42471d));
        this.f42473b.d(s10, t10);
        s10.close();
        return z.e(f42470c, buffer.y1());
    }
}
