package mg;

import com.google.gson.d;
import com.google.gson.q;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import mg.k;
import qg.a;

final class n<T> extends q<T> {

    /* renamed from: a  reason: collision with root package name */
    private final d f23731a;

    /* renamed from: b  reason: collision with root package name */
    private final q<T> f23732b;

    /* renamed from: c  reason: collision with root package name */
    private final Type f23733c;

    n(d dVar, q<T> qVar, Type type) {
        this.f23731a = dVar;
        this.f23732b = qVar;
        this.f23733c = type;
    }

    private static Type e(Type type, Object obj) {
        if (obj == null) {
            return type;
        }
        if ((type instanceof Class) || (type instanceof TypeVariable)) {
            return obj.getClass();
        }
        return type;
    }

    private static boolean f(q<?> qVar) {
        q<?> e10;
        while ((qVar instanceof l) && (e10 = ((l) qVar).e()) != qVar) {
            qVar = e10;
        }
        return qVar instanceof k.b;
    }

    public T b(JsonReader jsonReader) throws IOException {
        return this.f23732b.b(jsonReader);
    }

    public void d(JsonWriter jsonWriter, T t10) throws IOException {
        q<T> qVar = this.f23732b;
        Type e10 = e(this.f23733c, t10);
        if (e10 != this.f23733c) {
            qVar = this.f23731a.o(a.b(e10));
            if ((qVar instanceof k.b) && !f(this.f23732b)) {
                qVar = this.f23732b;
            }
        }
        qVar.d(jsonWriter, t10);
    }
}
