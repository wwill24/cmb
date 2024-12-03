package b3;

import android.graphics.PointF;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.coffeemeetsbagel.models.NetworkProfile;
import java.io.IOException;

public class i implements n0<DocumentData> {

    /* renamed from: a  reason: collision with root package name */
    public static final i f7775a = new i();

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.a f7776b = JsonReader.a.a("t", NetworkProfile.FEMALE, "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of", "ps", "sz");

    private i() {
    }

    /* renamed from: b */
    public DocumentData a(JsonReader jsonReader, float f10) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.c();
        DocumentData.Justification justification2 = justification;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        String str = null;
        String str2 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        boolean z10 = true;
        while (jsonReader.g()) {
            switch (jsonReader.y(f7776b)) {
                case 0:
                    str = jsonReader.n();
                    break;
                case 1:
                    str2 = jsonReader.n();
                    break;
                case 2:
                    f11 = (float) jsonReader.k();
                    break;
                case 3:
                    int l10 = jsonReader.l();
                    justification2 = DocumentData.Justification.CENTER;
                    if (l10 <= justification2.ordinal() && l10 >= 0) {
                        justification2 = DocumentData.Justification.values()[l10];
                        break;
                    }
                case 4:
                    i10 = jsonReader.l();
                    break;
                case 5:
                    f12 = (float) jsonReader.k();
                    break;
                case 6:
                    f13 = (float) jsonReader.k();
                    break;
                case 7:
                    i11 = s.d(jsonReader);
                    break;
                case 8:
                    i12 = s.d(jsonReader);
                    break;
                case 9:
                    f14 = (float) jsonReader.k();
                    break;
                case 10:
                    z10 = jsonReader.h();
                    break;
                case 11:
                    jsonReader.b();
                    PointF pointF3 = new PointF(((float) jsonReader.k()) * f10, ((float) jsonReader.k()) * f10);
                    jsonReader.e();
                    pointF = pointF3;
                    break;
                case 12:
                    jsonReader.b();
                    PointF pointF4 = new PointF(((float) jsonReader.k()) * f10, ((float) jsonReader.k()) * f10);
                    jsonReader.e();
                    pointF2 = pointF4;
                    break;
                default:
                    jsonReader.C();
                    jsonReader.E();
                    break;
            }
        }
        JsonReader jsonReader2 = jsonReader;
        jsonReader.f();
        return new DocumentData(str, str2, f11, justification2, i10, f12, f13, i11, i12, f14, z10, pointF, pointF2);
    }
}
