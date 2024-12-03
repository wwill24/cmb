package com.squareup.moshi;

import com.squareup.moshi.JsonReader;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;

public abstract class h<T> {

    class a extends h<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f22955a;

        a(h hVar) {
            this.f22955a = hVar;
        }

        public T fromJson(JsonReader jsonReader) throws IOException {
            return this.f22955a.fromJson(jsonReader);
        }

        /* access modifiers changed from: package-private */
        public boolean isLenient() {
            return this.f22955a.isLenient();
        }

        public void toJson(q qVar, T t10) throws IOException {
            boolean l10 = qVar.l();
            qVar.J(true);
            try {
                this.f22955a.toJson(qVar, t10);
            } finally {
                qVar.J(l10);
            }
        }

        public String toString() {
            return this.f22955a + ".serializeNulls()";
        }
    }

    class b extends h<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f22957a;

        b(h hVar) {
            this.f22957a = hVar;
        }

        public T fromJson(JsonReader jsonReader) throws IOException {
            boolean h10 = jsonReader.h();
            jsonReader.P(true);
            try {
                return this.f22957a.fromJson(jsonReader);
            } finally {
                jsonReader.P(h10);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean isLenient() {
            return true;
        }

        public void toJson(q qVar, T t10) throws IOException {
            boolean m10 = qVar.m();
            qVar.I(true);
            try {
                this.f22957a.toJson(qVar, t10);
            } finally {
                qVar.I(m10);
            }
        }

        public String toString() {
            return this.f22957a + ".lenient()";
        }
    }

    class c extends h<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f22959a;

        c(h hVar) {
            this.f22959a = hVar;
        }

        public T fromJson(JsonReader jsonReader) throws IOException {
            boolean f10 = jsonReader.f();
            jsonReader.O(true);
            try {
                return this.f22959a.fromJson(jsonReader);
            } finally {
                jsonReader.O(f10);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean isLenient() {
            return this.f22959a.isLenient();
        }

        public void toJson(q qVar, T t10) throws IOException {
            this.f22959a.toJson(qVar, t10);
        }

        public String toString() {
            return this.f22959a + ".failOnUnknown()";
        }
    }

    class d extends h<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f22961a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f22962b;

        d(h hVar, String str) {
            this.f22961a = hVar;
            this.f22962b = str;
        }

        public T fromJson(JsonReader jsonReader) throws IOException {
            return this.f22961a.fromJson(jsonReader);
        }

        /* access modifiers changed from: package-private */
        public boolean isLenient() {
            return this.f22961a.isLenient();
        }

        public void toJson(q qVar, T t10) throws IOException {
            String k10 = qVar.k();
            qVar.G(this.f22962b);
            try {
                this.f22961a.toJson(qVar, t10);
            } finally {
                qVar.G(k10);
            }
        }

        public String toString() {
            return this.f22961a + ".indent(\"" + this.f22962b + "\")";
        }
    }

    public interface e {
        h<?> create(Type type, Set<? extends Annotation> set, s sVar);
    }

    public final h<T> failOnUnknown() {
        return new c(this);
    }

    public abstract T fromJson(JsonReader jsonReader) throws IOException;

    public final T fromJson(BufferedSource bufferedSource) throws IOException {
        return fromJson(JsonReader.C(bufferedSource));
    }

    public final T fromJsonValue(Object obj) {
        try {
            return fromJson((JsonReader) new n(obj));
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    public h<T> indent(String str) {
        if (str != null) {
            return new d(this, str);
        }
        throw new NullPointerException("indent == null");
    }

    /* access modifiers changed from: package-private */
    public boolean isLenient() {
        return false;
    }

    public final h<T> lenient() {
        return new b(this);
    }

    public final h<T> nonNull() {
        if (this instanceof bi.a) {
            return this;
        }
        return new bi.a(this);
    }

    public final h<T> nullSafe() {
        if (this instanceof bi.b) {
            return this;
        }
        return new bi.b(this);
    }

    public final h<T> serializeNulls() {
        return new a(this);
    }

    public abstract void toJson(q qVar, T t10) throws IOException;

    public final void toJson(BufferedSink bufferedSink, T t10) throws IOException {
        toJson(q.x(bufferedSink), t10);
    }

    public final Object toJsonValue(T t10) {
        p pVar = new p();
        try {
            toJson((q) pVar, t10);
            return pVar.e0();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }

    public final T fromJson(String str) throws IOException {
        JsonReader C = JsonReader.C(new Buffer().h0(str));
        T fromJson = fromJson(C);
        if (isLenient() || C.E() == JsonReader.Token.END_DOCUMENT) {
            return fromJson;
        }
        throw new JsonDataException("JSON document was not fully consumed.");
    }

    public final String toJson(T t10) {
        Buffer buffer = new Buffer();
        try {
            toJson((BufferedSink) buffer, t10);
            return buffer.G();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }
}
