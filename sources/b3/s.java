package b3;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class s {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f7806a = JsonReader.a.a("x", "y");

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7807a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.airbnb.lottie.parser.moshi.JsonReader$Token[] r0 = com.airbnb.lottie.parser.moshi.JsonReader.Token.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7807a = r0
                com.airbnb.lottie.parser.moshi.JsonReader$Token r1 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7807a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.parser.moshi.JsonReader$Token r1 = com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7807a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.airbnb.lottie.parser.moshi.JsonReader$Token r1 = com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b3.s.a.<clinit>():void");
        }
    }

    private static PointF a(JsonReader jsonReader, float f10) throws IOException {
        jsonReader.b();
        float k10 = (float) jsonReader.k();
        float k11 = (float) jsonReader.k();
        while (jsonReader.v() != JsonReader.Token.END_ARRAY) {
            jsonReader.E();
        }
        jsonReader.e();
        return new PointF(k10 * f10, k11 * f10);
    }

    private static PointF b(JsonReader jsonReader, float f10) throws IOException {
        float k10 = (float) jsonReader.k();
        float k11 = (float) jsonReader.k();
        while (jsonReader.g()) {
            jsonReader.E();
        }
        return new PointF(k10 * f10, k11 * f10);
    }

    private static PointF c(JsonReader jsonReader, float f10) throws IOException {
        jsonReader.c();
        float f11 = 0.0f;
        float f12 = 0.0f;
        while (jsonReader.g()) {
            int y10 = jsonReader.y(f7806a);
            if (y10 == 0) {
                f11 = g(jsonReader);
            } else if (y10 != 1) {
                jsonReader.C();
                jsonReader.E();
            } else {
                f12 = g(jsonReader);
            }
        }
        jsonReader.f();
        return new PointF(f11 * f10, f12 * f10);
    }

    static int d(JsonReader jsonReader) throws IOException {
        jsonReader.b();
        int k10 = (int) (jsonReader.k() * 255.0d);
        int k11 = (int) (jsonReader.k() * 255.0d);
        int k12 = (int) (jsonReader.k() * 255.0d);
        while (jsonReader.g()) {
            jsonReader.E();
        }
        jsonReader.e();
        return Color.argb(255, k10, k11, k12);
    }

    static PointF e(JsonReader jsonReader, float f10) throws IOException {
        int i10 = a.f7807a[jsonReader.v().ordinal()];
        if (i10 == 1) {
            return b(jsonReader, f10);
        }
        if (i10 == 2) {
            return a(jsonReader, f10);
        }
        if (i10 == 3) {
            return c(jsonReader, f10);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.v());
    }

    static List<PointF> f(JsonReader jsonReader, float f10) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.b();
        while (jsonReader.v() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.b();
            arrayList.add(e(jsonReader, f10));
            jsonReader.e();
        }
        jsonReader.e();
        return arrayList;
    }

    static float g(JsonReader jsonReader) throws IOException {
        JsonReader.Token v10 = jsonReader.v();
        int i10 = a.f7807a[v10.ordinal()];
        if (i10 == 1) {
            return (float) jsonReader.k();
        }
        if (i10 == 2) {
            jsonReader.b();
            float k10 = (float) jsonReader.k();
            while (jsonReader.g()) {
                jsonReader.E();
            }
            jsonReader.e();
            return k10;
        }
        throw new IllegalArgumentException("Unknown value for token of type " + v10);
    }
}
