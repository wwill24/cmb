package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import mg.g;

public abstract class q<T> {

    class a extends q<T> {
        a() {
        }

        public T b(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return q.this.b(jsonReader);
            }
            jsonReader.nextNull();
            return null;
        }

        public void d(JsonWriter jsonWriter, T t10) throws IOException {
            if (t10 == null) {
                jsonWriter.nullValue();
            } else {
                q.this.d(jsonWriter, t10);
            }
        }
    }

    public final q<T> a() {
        return new a();
    }

    public abstract T b(JsonReader jsonReader) throws IOException;

    public final j c(T t10) {
        try {
            g gVar = new g();
            d(gVar, t10);
            return gVar.a();
        } catch (IOException e10) {
            throw new JsonIOException((Throwable) e10);
        }
    }

    public abstract void d(JsonWriter jsonWriter, T t10) throws IOException;
}
