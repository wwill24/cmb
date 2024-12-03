package ai;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import java.io.IOException;
import java.lang.Enum;
import java.util.Arrays;

public final class a<T extends Enum<T>> extends h<T> {

    /* renamed from: a  reason: collision with root package name */
    final Class<T> f18851a;

    /* renamed from: b  reason: collision with root package name */
    final String[] f18852b;

    /* renamed from: c  reason: collision with root package name */
    final T[] f18853c;

    /* renamed from: d  reason: collision with root package name */
    final JsonReader.b f18854d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f18855e;

    /* renamed from: f  reason: collision with root package name */
    final T f18856f;

    a(Class<T> cls, T t10, boolean z10) {
        this.f18851a = cls;
        this.f18856f = t10;
        this.f18855e = z10;
        try {
            T[] tArr = (Enum[]) cls.getEnumConstants();
            this.f18853c = tArr;
            this.f18852b = new String[tArr.length];
            int i10 = 0;
            while (true) {
                T[] tArr2 = this.f18853c;
                if (i10 < tArr2.length) {
                    String name = tArr2[i10].name();
                    this.f18852b[i10] = c.n(name, cls.getField(name));
                    i10++;
                } else {
                    this.f18854d = JsonReader.b.a(this.f18852b);
                    return;
                }
            }
        } catch (NoSuchFieldException e10) {
            throw new AssertionError("Missing field in " + cls.getName(), e10);
        }
    }

    public static <T extends Enum<T>> a<T> a(Class<T> cls) {
        return new a<>(cls, (Enum) null, false);
    }

    /* renamed from: b */
    public T fromJson(JsonReader jsonReader) throws IOException {
        int N = jsonReader.N(this.f18854d);
        if (N != -1) {
            return this.f18853c[N];
        }
        String path = jsonReader.getPath();
        if (!this.f18855e) {
            String y10 = jsonReader.y();
            throw new JsonDataException("Expected one of " + Arrays.asList(this.f18852b) + " but was " + y10 + " at path " + path);
        } else if (jsonReader.E() == JsonReader.Token.STRING) {
            jsonReader.Y();
            return this.f18856f;
        } else {
            throw new JsonDataException("Expected a string but was " + jsonReader.E() + " at path " + path);
        }
    }

    /* renamed from: c */
    public void toJson(q qVar, T t10) throws IOException {
        if (t10 != null) {
            qVar.S(this.f18852b[t10.ordinal()]);
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }

    public a<T> d(T t10) {
        return new a<>(this.f18851a, t10, true);
    }

    public String toString() {
        return "EnumJsonAdapter(" + this.f18851a.getName() + ")";
    }
}
