package mg;

import com.google.gson.d;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class a<E> extends q<Object> {

    /* renamed from: c  reason: collision with root package name */
    public static final r f23657c = new C0284a();

    /* renamed from: a  reason: collision with root package name */
    private final Class<E> f23658a;

    /* renamed from: b  reason: collision with root package name */
    private final q<E> f23659b;

    /* renamed from: mg.a$a  reason: collision with other inner class name */
    class C0284a implements r {
        C0284a() {
        }

        public <T> q<T> a(d dVar, qg.a<T> aVar) {
            Type d10 = aVar.d();
            if (!(d10 instanceof GenericArrayType) && (!(d10 instanceof Class) || !((Class) d10).isArray())) {
                return null;
            }
            Type g10 = C$Gson$Types.g(d10);
            return new a(dVar, dVar.o(qg.a.b(g10)), C$Gson$Types.k(g10));
        }
    }

    public a(d dVar, q<E> qVar, Class<E> cls) {
        this.f23659b = new n(dVar, qVar, cls);
        this.f23658a = cls;
    }

    public Object b(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(this.f23659b.b(jsonReader));
        }
        jsonReader.endArray();
        int size = arrayList.size();
        if (!this.f23658a.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance(this.f23658a, size));
        }
        Object newInstance = Array.newInstance(this.f23658a, size);
        for (int i10 = 0; i10 < size; i10++) {
            Array.set(newInstance, i10, arrayList.get(i10));
        }
        return newInstance;
    }

    public void d(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        int length = Array.getLength(obj);
        for (int i10 = 0; i10 < length; i10++) {
            this.f23659b.d(jsonWriter, Array.get(obj, i10));
        }
        jsonWriter.endArray();
    }
}
