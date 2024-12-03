package mg;

import com.google.gson.d;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.f;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public final class b implements r {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.gson.internal.b f23660a;

    private static final class a<E> extends q<Collection<E>> {

        /* renamed from: a  reason: collision with root package name */
        private final q<E> f23661a;

        /* renamed from: b  reason: collision with root package name */
        private final f<? extends Collection<E>> f23662b;

        public a(d dVar, Type type, q<E> qVar, f<? extends Collection<E>> fVar) {
            this.f23661a = new n(dVar, qVar, type);
            this.f23662b = fVar;
        }

        /* renamed from: e */
        public Collection<E> b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Collection<E> collection = (Collection) this.f23662b.a();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                collection.add(this.f23661a.b(jsonReader));
            }
            jsonReader.endArray();
            return collection;
        }

        /* renamed from: f */
        public void d(JsonWriter jsonWriter, Collection<E> collection) throws IOException {
            if (collection == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            for (E d10 : collection) {
                this.f23661a.d(jsonWriter, d10);
            }
            jsonWriter.endArray();
        }
    }

    public b(com.google.gson.internal.b bVar) {
        this.f23660a = bVar;
    }

    public <T> q<T> a(d dVar, qg.a<T> aVar) {
        Type d10 = aVar.d();
        Class<? super T> c10 = aVar.c();
        if (!Collection.class.isAssignableFrom(c10)) {
            return null;
        }
        Type h10 = C$Gson$Types.h(d10, c10);
        return new a(dVar, h10, dVar.o(qg.a.b(h10)), this.f23660a.b(aVar));
    }
}
