package mg;

import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.l;
import com.google.gson.m;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class g extends JsonWriter {

    /* renamed from: d  reason: collision with root package name */
    private static final Writer f23677d = new a();

    /* renamed from: e  reason: collision with root package name */
    private static final m f23678e = new m("closed");

    /* renamed from: a  reason: collision with root package name */
    private final List<j> f23679a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private String f23680b;

    /* renamed from: c  reason: collision with root package name */
    private j f23681c = k.f21376a;

    class a extends Writer {
        a() {
        }

        public void close() {
            throw new AssertionError();
        }

        public void flush() {
            throw new AssertionError();
        }

        public void write(char[] cArr, int i10, int i11) {
            throw new AssertionError();
        }
    }

    public g() {
        super(f23677d);
    }

    private j b() {
        List<j> list = this.f23679a;
        return list.get(list.size() - 1);
    }

    private void c(j jVar) {
        if (this.f23680b != null) {
            if (!jVar.i() || getSerializeNulls()) {
                ((l) b()).n(this.f23680b, jVar);
            }
            this.f23680b = null;
        } else if (this.f23679a.isEmpty()) {
            this.f23681c = jVar;
        } else {
            j b10 = b();
            if (b10 instanceof com.google.gson.g) {
                ((com.google.gson.g) b10).n(jVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    public j a() {
        if (this.f23679a.isEmpty()) {
            return this.f23681c;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f23679a);
    }

    public JsonWriter beginArray() throws IOException {
        com.google.gson.g gVar = new com.google.gson.g();
        c(gVar);
        this.f23679a.add(gVar);
        return this;
    }

    public JsonWriter beginObject() throws IOException {
        l lVar = new l();
        c(lVar);
        this.f23679a.add(lVar);
        return this;
    }

    public void close() throws IOException {
        if (this.f23679a.isEmpty()) {
            this.f23679a.add(f23678e);
            return;
        }
        throw new IOException("Incomplete document");
    }

    public JsonWriter endArray() throws IOException {
        if (this.f23679a.isEmpty() || this.f23680b != null) {
            throw new IllegalStateException();
        } else if (b() instanceof com.google.gson.g) {
            List<j> list = this.f23679a;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public JsonWriter endObject() throws IOException {
        if (this.f23679a.isEmpty() || this.f23680b != null) {
            throw new IllegalStateException();
        } else if (b() instanceof l) {
            List<j> list = this.f23679a;
            list.remove(list.size() - 1);
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public void flush() throws IOException {
    }

    public JsonWriter jsonValue(String str) throws IOException {
        throw new UnsupportedOperationException();
    }

    public JsonWriter name(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.f23679a.isEmpty() || this.f23680b != null) {
            throw new IllegalStateException();
        } else if (b() instanceof l) {
            this.f23680b = str;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    public JsonWriter nullValue() throws IOException {
        c(k.f21376a);
        return this;
    }

    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        c(new m(str));
        return this;
    }

    public JsonWriter value(boolean z10) throws IOException {
        c(new m(Boolean.valueOf(z10)));
        return this;
    }

    public JsonWriter value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        c(new m(bool));
        return this;
    }

    public JsonWriter value(float f10) throws IOException {
        if (isLenient() || (!Float.isNaN(f10) && !Float.isInfinite(f10))) {
            c(new m((Number) Float.valueOf(f10)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + f10);
    }

    public JsonWriter value(double d10) throws IOException {
        if (isLenient() || (!Double.isNaN(d10) && !Double.isInfinite(d10))) {
            c(new m((Number) Double.valueOf(d10)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d10);
    }

    public JsonWriter value(long j10) throws IOException {
        c(new m((Number) Long.valueOf(j10)));
        return this;
    }

    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        c(new m(number));
        return this;
    }
}
