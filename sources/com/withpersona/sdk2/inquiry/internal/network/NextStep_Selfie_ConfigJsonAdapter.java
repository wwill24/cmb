package com.withpersona.sdk2.inquiry.internal.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_Selfie_ConfigJsonAdapter extends h<NextStep.Selfie.Config> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26865a;

    /* renamed from: b  reason: collision with root package name */
    private final h<NextStep.Selfie.CaptureMethod> f26866b;

    /* renamed from: c  reason: collision with root package name */
    private final h<Boolean> f26867c;

    /* renamed from: d  reason: collision with root package name */
    private final h<NextStep.Selfie.Localizations> f26868d;

    /* renamed from: e  reason: collision with root package name */
    private final h<String> f26869e;

    /* renamed from: f  reason: collision with root package name */
    private final h<List<NextStep.Selfie.CaptureFileType>> f26870f;

    public NextStep_Selfie_ConfigJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("selfieType", "backStepEnabled", "cancelButtonEnabled", "localizations", "fieldKeySelfie", "skipPromptPage", "enabledCaptureFileTypes");
        j.f(a10, "of(\"selfieType\", \"backSt…enabledCaptureFileTypes\")");
        this.f26865a = a10;
        h<NextStep.Selfie.CaptureMethod> f10 = sVar.f(NextStep.Selfie.CaptureMethod.class, n0.e(), "selfieType");
        j.f(f10, "moshi.adapter(NextStep.S…emptySet(), \"selfieType\")");
        this.f26866b = f10;
        h<Boolean> f11 = sVar.f(Boolean.class, n0.e(), "backStepEnabled");
        j.f(f11, "moshi.adapter(Boolean::c…Set(), \"backStepEnabled\")");
        this.f26867c = f11;
        h<NextStep.Selfie.Localizations> f12 = sVar.f(NextStep.Selfie.Localizations.class, n0.e(), "localizations");
        j.f(f12, "moshi.adapter(NextStep.S…tySet(), \"localizations\")");
        this.f26868d = f12;
        h<String> f13 = sVar.f(String.class, n0.e(), "fieldKeySelfie");
        j.f(f13, "moshi.adapter(String::cl…,\n      \"fieldKeySelfie\")");
        this.f26869e = f13;
        h<List<NextStep.Selfie.CaptureFileType>> f14 = sVar.f(w.j(List.class, NextStep.Selfie.CaptureFileType.class), n0.e(), "enabledCaptureFileTypes");
        j.f(f14, "moshi.adapter(Types.newP…enabledCaptureFileTypes\")");
        this.f26870f = f14;
    }

    /* renamed from: a */
    public NextStep.Selfie.Config fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        NextStep.Selfie.CaptureMethod captureMethod = null;
        Boolean bool = null;
        Boolean bool2 = null;
        NextStep.Selfie.Localizations localizations = null;
        String str = null;
        Boolean bool3 = null;
        List list = null;
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f26865a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    captureMethod = this.f26866b.fromJson(jsonReader);
                    if (captureMethod != null) {
                        break;
                    } else {
                        JsonDataException x10 = c.x("selfieType", "selfieType", jsonReader);
                        j.f(x10, "unexpectedNull(\"selfieType\", \"selfieType\", reader)");
                        throw x10;
                    }
                case 1:
                    bool = this.f26867c.fromJson(jsonReader);
                    break;
                case 2:
                    bool2 = this.f26867c.fromJson(jsonReader);
                    break;
                case 3:
                    localizations = this.f26868d.fromJson(jsonReader);
                    if (localizations != null) {
                        break;
                    } else {
                        JsonDataException x11 = c.x("localizations", "localizations", jsonReader);
                        j.f(x11, "unexpectedNull(\"localiza… \"localizations\", reader)");
                        throw x11;
                    }
                case 4:
                    str = this.f26869e.fromJson(jsonReader);
                    if (str != null) {
                        break;
                    } else {
                        JsonDataException x12 = c.x("fieldKeySelfie", "fieldKeySelfie", jsonReader);
                        j.f(x12, "unexpectedNull(\"fieldKey…\"fieldKeySelfie\", reader)");
                        throw x12;
                    }
                case 5:
                    bool3 = this.f26867c.fromJson(jsonReader);
                    break;
                case 6:
                    list = this.f26870f.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.e();
        if (captureMethod == null) {
            JsonDataException o10 = c.o("selfieType", "selfieType", jsonReader);
            j.f(o10, "missingProperty(\"selfieT…e\", \"selfieType\", reader)");
            throw o10;
        } else if (localizations == null) {
            JsonDataException o11 = c.o("localizations", "localizations", jsonReader);
            j.f(o11, "missingProperty(\"localiz… \"localizations\", reader)");
            throw o11;
        } else if (str != null) {
            return new NextStep.Selfie.Config(captureMethod, bool, bool2, localizations, str, bool3, list);
        } else {
            JsonDataException o12 = c.o("fieldKeySelfie", "fieldKeySelfie", jsonReader);
            j.f(o12, "missingProperty(\"fieldKe…\"fieldKeySelfie\", reader)");
            throw o12;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.Selfie.Config config) {
        j.g(qVar, "writer");
        if (config != null) {
            qVar.c();
            qVar.u("selfieType");
            this.f26866b.toJson(qVar, config.f());
            qVar.u("backStepEnabled");
            this.f26867c.toJson(qVar, config.a());
            qVar.u("cancelButtonEnabled");
            this.f26867c.toJson(qVar, config.b());
            qVar.u("localizations");
            this.f26868d.toJson(qVar, config.e());
            qVar.u("fieldKeySelfie");
            this.f26869e.toJson(qVar, config.d());
            qVar.u("skipPromptPage");
            this.f26867c.toJson(qVar, config.g());
            qVar.u("enabledCaptureFileTypes");
            this.f26870f.toJson(qVar, config.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(44);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.Selfie.Config");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
