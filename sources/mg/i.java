package mg;

import com.google.gson.JsonSyntaxException;
import com.google.gson.ToNumberPolicy;
import com.google.gson.d;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public final class i extends q<Number> {

    /* renamed from: b  reason: collision with root package name */
    private static final r f23688b = f(ToNumberPolicy.LAZILY_PARSED_NUMBER);

    /* renamed from: a  reason: collision with root package name */
    private final p f23689a;

    class a implements r {
        a() {
        }

        public <T> q<T> a(d dVar, qg.a<T> aVar) {
            if (aVar.c() == Number.class) {
                return i.this;
            }
            return null;
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f23691a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.gson.stream.JsonToken[] r0 = com.google.gson.stream.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f23691a = r0
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NULL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f23691a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.NUMBER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f23691a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.STRING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: mg.i.b.<clinit>():void");
        }
    }

    private i(p pVar) {
        this.f23689a = pVar;
    }

    public static r e(p pVar) {
        if (pVar == ToNumberPolicy.LAZILY_PARSED_NUMBER) {
            return f23688b;
        }
        return f(pVar);
    }

    private static r f(p pVar) {
        return new a();
    }

    /* renamed from: g */
    public Number b(JsonReader jsonReader) throws IOException {
        JsonToken peek = jsonReader.peek();
        int i10 = b.f23691a[peek.ordinal()];
        if (i10 == 1) {
            jsonReader.nextNull();
            return null;
        } else if (i10 == 2 || i10 == 3) {
            return this.f23689a.a(jsonReader);
        } else {
            throw new JsonSyntaxException("Expecting number, got: " + peek + "; at path " + jsonReader.getPath());
        }
    }

    /* renamed from: h */
    public void d(JsonWriter jsonWriter, Number number) throws IOException {
        jsonWriter.value(number);
    }
}
