package com.withpersona.sdk2.inquiry.internal.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.governmentid.network.CaptureOptionNativeMobile;
import com.withpersona.sdk2.inquiry.governmentid.network.Id;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_GovernmentId_ConfigJsonAdapter extends h<NextStep.GovernmentId.Config> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26766a;

    /* renamed from: b  reason: collision with root package name */
    private final h<List<Id>> f26767b;

    /* renamed from: c  reason: collision with root package name */
    private final h<Boolean> f26768c;

    /* renamed from: d  reason: collision with root package name */
    private final h<NextStep.GovernmentId.Localizations> f26769d;

    /* renamed from: e  reason: collision with root package name */
    private final h<List<CaptureOptionNativeMobile>> f26770e;

    /* renamed from: f  reason: collision with root package name */
    private final h<Integer> f26771f;

    /* renamed from: g  reason: collision with root package name */
    private final h<Long> f26772g;

    /* renamed from: h  reason: collision with root package name */
    private final h<String> f26773h;

    /* renamed from: i  reason: collision with root package name */
    private final h<NextStep.GovernmentId.NfcPassport> f26774i;

    /* renamed from: j  reason: collision with root package name */
    private final h<List<NextStep.GovernmentId.LocalizationOverride>> f26775j;

    /* renamed from: k  reason: collision with root package name */
    private final h<NextStep.GovernmentId.Pages> f26776k;

    /* renamed from: l  reason: collision with root package name */
    private final h<List<NextStep.GovernmentId.CaptureFileType>> f26777l;

    public NextStep_GovernmentId_ConfigJsonAdapter(s sVar) {
        s sVar2 = sVar;
        j.g(sVar2, "moshi");
        JsonReader.b a10 = JsonReader.b.a("idclasses", "backStepEnabled", "cancelButtonEnabled", "localizations", "enabledCaptureOptionsNativeMobile", "imageCaptureCount", "nativeMobileCameraManualCaptureDelayMs", "fieldKeyDocument", "fieldKeyIdclass", "nfcPassport", "localizationOverrides", "pages", "shouldSkipReviewScreen", "enabledCaptureFileTypes");
        j.f(a10, "of(\"idclasses\", \"backSte…enabledCaptureFileTypes\")");
        this.f26766a = a10;
        h<List<Id>> f10 = sVar2.f(w.j(List.class, Id.class), n0.e(), "idclasses");
        j.f(f10, "moshi.adapter(Types.newP…Set(),\n      \"idclasses\")");
        this.f26767b = f10;
        h<Boolean> f11 = sVar2.f(Boolean.class, n0.e(), "backStepEnabled");
        j.f(f11, "moshi.adapter(Boolean::c…Set(), \"backStepEnabled\")");
        this.f26768c = f11;
        h<NextStep.GovernmentId.Localizations> f12 = sVar2.f(NextStep.GovernmentId.Localizations.class, n0.e(), "localizations");
        j.f(f12, "moshi.adapter(NextStep.G…tySet(), \"localizations\")");
        this.f26769d = f12;
        h<List<CaptureOptionNativeMobile>> f13 = sVar2.f(w.j(List.class, CaptureOptionNativeMobile.class), n0.e(), "enabledCaptureOptionsNativeMobile");
        j.f(f13, "moshi.adapter(Types.newP…tureOptionsNativeMobile\")");
        this.f26770e = f13;
        h<Integer> f14 = sVar2.f(Integer.class, n0.e(), "imageCaptureCount");
        j.f(f14, "moshi.adapter(Int::class…t(), \"imageCaptureCount\")");
        this.f26771f = f14;
        h<Long> f15 = sVar2.f(Long.class, n0.e(), "nativeMobileCameraManualCaptureDelayMs");
        j.f(f15, "moshi.adapter(Long::clas…eraManualCaptureDelayMs\")");
        this.f26772g = f15;
        h<String> f16 = sVar2.f(String.class, n0.e(), "fieldKeyDocument");
        j.f(f16, "moshi.adapter(String::cl…      \"fieldKeyDocument\")");
        this.f26773h = f16;
        h<NextStep.GovernmentId.NfcPassport> f17 = sVar2.f(NextStep.GovernmentId.NfcPassport.class, n0.e(), "nfcPassport");
        j.f(f17, "moshi.adapter(NextStep.G…mptySet(), \"nfcPassport\")");
        this.f26774i = f17;
        h<List<NextStep.GovernmentId.LocalizationOverride>> f18 = sVar2.f(w.j(List.class, NextStep.GovernmentId.LocalizationOverride.class), n0.e(), "localizationOverrides");
        j.f(f18, "moshi.adapter(Types.newP… \"localizationOverrides\")");
        this.f26775j = f18;
        h<NextStep.GovernmentId.Pages> f19 = sVar2.f(NextStep.GovernmentId.Pages.class, n0.e(), "pages");
        j.f(f19, "moshi.adapter(NextStep.G…ava, emptySet(), \"pages\")");
        this.f26776k = f19;
        h<List<NextStep.GovernmentId.CaptureFileType>> f20 = sVar2.f(w.j(List.class, NextStep.GovernmentId.CaptureFileType.class), n0.e(), "enabledCaptureFileTypes");
        j.f(f20, "moshi.adapter(Types.newP…enabledCaptureFileTypes\")");
        this.f26777l = f20;
    }

    /* renamed from: a */
    public NextStep.GovernmentId.Config fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        List list = null;
        Boolean bool = null;
        Boolean bool2 = null;
        NextStep.GovernmentId.Localizations localizations = null;
        List list2 = null;
        Integer num = null;
        Long l10 = null;
        String str = null;
        String str2 = null;
        NextStep.GovernmentId.NfcPassport nfcPassport = null;
        List list3 = null;
        NextStep.GovernmentId.Pages pages = null;
        Boolean bool3 = null;
        List list4 = null;
        while (true) {
            NextStep.GovernmentId.Pages pages2 = pages;
            List list5 = list3;
            if (jsonReader.g()) {
                switch (jsonReader2.L(this.f26766a)) {
                    case -1:
                        jsonReader.S();
                        jsonReader.Y();
                        break;
                    case 0:
                        list = this.f26767b.fromJson(jsonReader2);
                        break;
                    case 1:
                        bool = this.f26768c.fromJson(jsonReader2);
                        break;
                    case 2:
                        bool2 = this.f26768c.fromJson(jsonReader2);
                        break;
                    case 3:
                        localizations = this.f26769d.fromJson(jsonReader2);
                        if (localizations == null) {
                            JsonDataException x10 = c.x("localizations", "localizations", jsonReader2);
                            j.f(x10, "unexpectedNull(\"localiza… \"localizations\", reader)");
                            throw x10;
                        }
                        break;
                    case 4:
                        list2 = this.f26770e.fromJson(jsonReader2);
                        break;
                    case 5:
                        num = this.f26771f.fromJson(jsonReader2);
                        break;
                    case 6:
                        l10 = this.f26772g.fromJson(jsonReader2);
                        break;
                    case 7:
                        str = this.f26773h.fromJson(jsonReader2);
                        if (str == null) {
                            JsonDataException x11 = c.x("fieldKeyDocument", "fieldKeyDocument", jsonReader2);
                            j.f(x11, "unexpectedNull(\"fieldKey…ieldKeyDocument\", reader)");
                            throw x11;
                        }
                        break;
                    case 8:
                        str2 = this.f26773h.fromJson(jsonReader2);
                        if (str2 == null) {
                            JsonDataException x12 = c.x("fieldKeyIdclass", "fieldKeyIdclass", jsonReader2);
                            j.f(x12, "unexpectedNull(\"fieldKey…fieldKeyIdclass\", reader)");
                            throw x12;
                        }
                        break;
                    case 9:
                        nfcPassport = this.f26774i.fromJson(jsonReader2);
                        break;
                    case 10:
                        list3 = this.f26775j.fromJson(jsonReader2);
                        pages = pages2;
                        continue;
                    case 11:
                        pages = this.f26776k.fromJson(jsonReader2);
                        break;
                    case 12:
                        bool3 = this.f26768c.fromJson(jsonReader2);
                        break;
                    case 13:
                        list4 = this.f26777l.fromJson(jsonReader2);
                        break;
                }
                pages = pages2;
                list3 = list5;
            } else {
                jsonReader.e();
                if (localizations == null) {
                    JsonDataException o10 = c.o("localizations", "localizations", jsonReader2);
                    j.f(o10, "missingProperty(\"localiz… \"localizations\", reader)");
                    throw o10;
                } else if (str == null) {
                    JsonDataException o11 = c.o("fieldKeyDocument", "fieldKeyDocument", jsonReader2);
                    j.f(o11, "missingProperty(\"fieldKe…ieldKeyDocument\", reader)");
                    throw o11;
                } else if (str2 != null) {
                    return new NextStep.GovernmentId.Config(list, bool, bool2, localizations, list2, num, l10, str, str2, nfcPassport, list5, pages2, bool3, list4);
                } else {
                    JsonDataException o12 = c.o("fieldKeyIdclass", "fieldKeyIdclass", jsonReader2);
                    j.f(o12, "missingProperty(\"fieldKe…fieldKeyIdclass\", reader)");
                    throw o12;
                }
            }
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.GovernmentId.Config config) {
        j.g(qVar, "writer");
        if (config != null) {
            qVar.c();
            qVar.u("idclasses");
            this.f26767b.toJson(qVar, config.g());
            qVar.u("backStepEnabled");
            this.f26768c.toJson(qVar, config.a());
            qVar.u("cancelButtonEnabled");
            this.f26768c.toJson(qVar, config.b());
            qVar.u("localizations");
            this.f26769d.toJson(qVar, config.j());
            qVar.u("enabledCaptureOptionsNativeMobile");
            this.f26770e.toJson(qVar, config.d());
            qVar.u("imageCaptureCount");
            this.f26771f.toJson(qVar, config.h());
            qVar.u("nativeMobileCameraManualCaptureDelayMs");
            this.f26772g.toJson(qVar, config.k());
            qVar.u("fieldKeyDocument");
            this.f26773h.toJson(qVar, config.e());
            qVar.u("fieldKeyIdclass");
            this.f26773h.toJson(qVar, config.f());
            qVar.u("nfcPassport");
            this.f26774i.toJson(qVar, config.l());
            qVar.u("localizationOverrides");
            this.f26775j.toJson(qVar, config.i());
            qVar.u("pages");
            this.f26776k.toJson(qVar, config.m());
            qVar.u("shouldSkipReviewScreen");
            this.f26768c.toJson(qVar, config.n());
            qVar.u("enabledCaptureFileTypes");
            this.f26777l.toJson(qVar, config.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(50);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.GovernmentId.Config");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
