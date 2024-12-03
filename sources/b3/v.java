package b3;

import android.graphics.Color;
import android.graphics.Rect;
import android.view.animation.Interpolator;
import com.airbnb.lottie.h;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.facebook.appevents.UserDataStore;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.Message;
import x2.b;
import x2.j;
import x2.k;
import x2.l;
import y2.c;

public class v {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f7813a = JsonReader.a.a("nm", "ind", "refId", "ty", Message.Thread.PARENT_ATTRIBUTE_NAME, "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", UserDataStore.STATE, "w", "h", "ip", "op", "tm", "cl", "hd");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.a f7814b = JsonReader.a.a("d", "a");

    /* renamed from: c  reason: collision with root package name */
    private static final JsonReader.a f7815c = JsonReader.a.a("ty", "nm");

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7816a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.airbnb.lottie.model.layer.Layer$MatteType[] r0 = com.airbnb.lottie.model.layer.Layer.MatteType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7816a = r0
                com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.LUMA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7816a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.LUMA_INVERTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b3.v.a.<clinit>():void");
        }
    }

    public static Layer a(h hVar) {
        Rect b10 = hVar.b();
        List emptyList = Collections.emptyList();
        Layer.LayerType layerType = Layer.LayerType.PRE_COMP;
        List emptyList2 = Collections.emptyList();
        l lVar = r4;
        l lVar2 = new l();
        return new Layer(emptyList, hVar, "__container", -1, layerType, -1, (String) null, emptyList2, lVar, 0, 0, 0, 0.0f, 0.0f, (float) b10.width(), (float) b10.height(), (j) null, (k) null, Collections.emptyList(), Layer.MatteType.NONE, (b) null, false, (y2.a) null, (j) null);
    }

    public static Layer b(JsonReader jsonReader, h hVar) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        float f10;
        JsonReader jsonReader2 = jsonReader;
        h hVar2 = hVar;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.c();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        Layer.MatteType matteType2 = matteType;
        float f11 = 1.0f;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        boolean z10 = false;
        Layer.LayerType layerType = null;
        String str = null;
        l lVar = null;
        j jVar = null;
        k kVar = null;
        b bVar = null;
        y2.a aVar = null;
        j jVar2 = null;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        long j10 = -1;
        long j11 = 0;
        String str2 = null;
        String str3 = "UNSET";
        while (jsonReader.g()) {
            switch (jsonReader2.y(f7813a)) {
                case 0:
                    str3 = jsonReader.n();
                    break;
                case 1:
                    j11 = (long) jsonReader.l();
                    break;
                case 2:
                    str = jsonReader.n();
                    break;
                case 3:
                    int l10 = jsonReader.l();
                    layerType = Layer.LayerType.UNKNOWN;
                    if (l10 >= layerType.ordinal()) {
                        break;
                    } else {
                        layerType = Layer.LayerType.values()[l10];
                        break;
                    }
                case 4:
                    j10 = (long) jsonReader.l();
                    break;
                case 5:
                    i10 = (int) (((float) jsonReader.l()) * c3.j.e());
                    break;
                case 6:
                    i11 = (int) (((float) jsonReader.l()) * c3.j.e());
                    break;
                case 7:
                    i12 = Color.parseColor(jsonReader.n());
                    break;
                case 8:
                    lVar = c.g(jsonReader, hVar);
                    break;
                case 9:
                    int l11 = jsonReader.l();
                    if (l11 < Layer.MatteType.values().length) {
                        matteType2 = Layer.MatteType.values()[l11];
                        int i13 = a.f7816a[matteType2.ordinal()];
                        if (i13 == 1) {
                            hVar2.a("Unsupported matte type: Luma");
                        } else if (i13 == 2) {
                            hVar2.a("Unsupported matte type: Luma Inverted");
                        }
                        hVar2.r(1);
                        break;
                    } else {
                        hVar2.a("Unsupported matte type: " + l11);
                        break;
                    }
                case 10:
                    jsonReader.b();
                    while (jsonReader.g()) {
                        arrayList3.add(x.a(jsonReader, hVar));
                    }
                    hVar2.r(arrayList3.size());
                    jsonReader.e();
                    break;
                case 11:
                    jsonReader.b();
                    while (jsonReader.g()) {
                        c a10 = h.a(jsonReader, hVar);
                        if (a10 != null) {
                            arrayList4.add(a10);
                        }
                    }
                    jsonReader.e();
                    break;
                case 12:
                    jsonReader.c();
                    while (jsonReader.g()) {
                        int y10 = jsonReader2.y(f7814b);
                        if (y10 == 0) {
                            jVar = d.d(jsonReader, hVar);
                        } else if (y10 != 1) {
                            jsonReader.C();
                            jsonReader.E();
                        } else {
                            jsonReader.b();
                            if (jsonReader.g()) {
                                kVar = b.a(jsonReader, hVar);
                            }
                            while (jsonReader.g()) {
                                jsonReader.E();
                            }
                            jsonReader.e();
                        }
                    }
                    jsonReader.f();
                    break;
                case 13:
                    jsonReader.b();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader.g()) {
                        jsonReader.c();
                        while (jsonReader.g()) {
                            int y11 = jsonReader2.y(f7815c);
                            if (y11 == 0) {
                                int l12 = jsonReader.l();
                                if (l12 == 29) {
                                    aVar = e.b(jsonReader, hVar);
                                } else if (l12 == 25) {
                                    jVar2 = new k().b(jsonReader2, hVar2);
                                }
                            } else if (y11 != 1) {
                                jsonReader.C();
                                jsonReader.E();
                            } else {
                                arrayList5.add(jsonReader.n());
                            }
                        }
                        jsonReader.f();
                    }
                    jsonReader.e();
                    hVar2.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    f11 = (float) jsonReader.k();
                    break;
                case 15:
                    f13 = (float) jsonReader.k();
                    break;
                case 16:
                    f14 = (float) (jsonReader.k() * ((double) c3.j.e()));
                    break;
                case 17:
                    f15 = (float) (jsonReader.k() * ((double) c3.j.e()));
                    break;
                case 18:
                    f12 = (float) jsonReader.k();
                    break;
                case 19:
                    f16 = (float) jsonReader.k();
                    break;
                case 20:
                    bVar = d.f(jsonReader2, hVar2, false);
                    break;
                case 21:
                    str2 = jsonReader.n();
                    break;
                case 22:
                    z10 = jsonReader.h();
                    break;
                default:
                    jsonReader.C();
                    jsonReader.E();
                    break;
            }
        }
        jsonReader.f();
        ArrayList arrayList6 = new ArrayList();
        if (f12 > 0.0f) {
            d3.a aVar2 = r0;
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            d3.a aVar3 = new d3.a(hVar, valueOf2, valueOf2, (Interpolator) null, 0.0f, Float.valueOf(f12));
            arrayList2.add(aVar2);
            f10 = 0.0f;
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            f10 = 0.0f;
        }
        if (f16 <= f10) {
            f16 = hVar.f();
        }
        h hVar3 = hVar;
        arrayList2.add(new d3.a(hVar3, valueOf, valueOf, (Interpolator) null, f12, Float.valueOf(f16)));
        arrayList2.add(new d3.a(hVar3, valueOf2, valueOf2, (Interpolator) null, f16, Float.valueOf(Float.MAX_VALUE)));
        if (str3.endsWith(".ai") || "ai".equals(str2)) {
            hVar2.a("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList4, hVar, str3, j11, layerType, j10, str, arrayList, lVar, i10, i11, i12, f11, f13, f14, f15, jVar, kVar, arrayList2, matteType2, bVar, z10, aVar, jVar2);
    }
}
