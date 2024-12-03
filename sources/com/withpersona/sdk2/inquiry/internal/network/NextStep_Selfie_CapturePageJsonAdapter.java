package com.withpersona.sdk2.inquiry.internal.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_Selfie_CapturePageJsonAdapter extends h<NextStep.Selfie.CapturePage> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26863a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26864b;

    public NextStep_Selfie_CapturePageJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("selfieHintTakePhoto", "selfieHintCenterFace", "selfieHintFaceTooClose", "selfieHintPoseNotCenter", "selfieHintLookLeft", "selfieHintLookRight", "selfieHintHoldStill");
        j.f(a10, "of(\"selfieHintTakePhoto\"…\", \"selfieHintHoldStill\")");
        this.f26863a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "selfieHintTakePhoto");
        j.f(f10, "moshi.adapter(String::cl…   \"selfieHintTakePhoto\")");
        this.f26864b = f10;
    }

    /* renamed from: a */
    public NextStep.Selfie.CapturePage fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        while (true) {
            String str8 = str7;
            if (jsonReader.g()) {
                switch (jsonReader2.L(this.f26863a)) {
                    case -1:
                        jsonReader.S();
                        jsonReader.Y();
                        break;
                    case 0:
                        str = this.f26864b.fromJson(jsonReader2);
                        if (str == null) {
                            JsonDataException x10 = c.x("selfieHintTakePhoto", "selfieHintTakePhoto", jsonReader2);
                            j.f(x10, "unexpectedNull(\"selfieHi…ieHintTakePhoto\", reader)");
                            throw x10;
                        }
                        break;
                    case 1:
                        str2 = this.f26864b.fromJson(jsonReader2);
                        if (str2 == null) {
                            JsonDataException x11 = c.x("selfieHintCenterFace", "selfieHintCenterFace", jsonReader2);
                            j.f(x11, "unexpectedNull(\"selfieHi…eHintCenterFace\", reader)");
                            throw x11;
                        }
                        break;
                    case 2:
                        str3 = this.f26864b.fromJson(jsonReader2);
                        if (str3 == null) {
                            JsonDataException x12 = c.x("selfieHintFaceTooClose", "selfieHintFaceTooClose", jsonReader2);
                            j.f(x12, "unexpectedNull(\"selfieHi…intFaceTooClose\", reader)");
                            throw x12;
                        }
                        break;
                    case 3:
                        str4 = this.f26864b.fromJson(jsonReader2);
                        if (str4 == null) {
                            JsonDataException x13 = c.x("selfieHintPoseNotCenter", "selfieHintPoseNotCenter", jsonReader2);
                            j.f(x13, "unexpectedNull(\"selfieHi…ntPoseNotCenter\", reader)");
                            throw x13;
                        }
                        break;
                    case 4:
                        str5 = this.f26864b.fromJson(jsonReader2);
                        if (str5 == null) {
                            JsonDataException x14 = c.x("selfieHintLookLeft", "selfieHintLookLeft", jsonReader2);
                            j.f(x14, "unexpectedNull(\"selfieHi…fieHintLookLeft\", reader)");
                            throw x14;
                        }
                        break;
                    case 5:
                        str6 = this.f26864b.fromJson(jsonReader2);
                        if (str6 == null) {
                            JsonDataException x15 = c.x("selfieHintLookRight", "selfieHintLookRight", jsonReader2);
                            j.f(x15, "unexpectedNull(\"selfieHi…ieHintLookRight\", reader)");
                            throw x15;
                        }
                        break;
                    case 6:
                        str7 = this.f26864b.fromJson(jsonReader2);
                        if (str7 != null) {
                            continue;
                        } else {
                            JsonDataException x16 = c.x("selfieHintHoldStill", "selfieHintHoldStill", jsonReader2);
                            j.f(x16, "unexpectedNull(\"selfieHi…ieHintHoldStill\", reader)");
                            throw x16;
                        }
                }
                str7 = str8;
            } else {
                jsonReader.e();
                if (str == null) {
                    JsonDataException o10 = c.o("selfieHintTakePhoto", "selfieHintTakePhoto", jsonReader2);
                    j.f(o10, "missingProperty(\"selfieH…ieHintTakePhoto\", reader)");
                    throw o10;
                } else if (str2 == null) {
                    JsonDataException o11 = c.o("selfieHintCenterFace", "selfieHintCenterFace", jsonReader2);
                    j.f(o11, "missingProperty(\"selfieH…eHintCenterFace\", reader)");
                    throw o11;
                } else if (str3 == null) {
                    JsonDataException o12 = c.o("selfieHintFaceTooClose", "selfieHintFaceTooClose", jsonReader2);
                    j.f(o12, "missingProperty(\"selfieH…intFaceTooClose\", reader)");
                    throw o12;
                } else if (str4 == null) {
                    JsonDataException o13 = c.o("selfieHintPoseNotCenter", "selfieHintPoseNotCenter", jsonReader2);
                    j.f(o13, "missingProperty(\"selfieH…ter\",\n            reader)");
                    throw o13;
                } else if (str5 == null) {
                    JsonDataException o14 = c.o("selfieHintLookLeft", "selfieHintLookLeft", jsonReader2);
                    j.f(o14, "missingProperty(\"selfieH…fieHintLookLeft\", reader)");
                    throw o14;
                } else if (str6 == null) {
                    JsonDataException o15 = c.o("selfieHintLookRight", "selfieHintLookRight", jsonReader2);
                    j.f(o15, "missingProperty(\"selfieH…ieHintLookRight\", reader)");
                    throw o15;
                } else if (str8 != null) {
                    return new NextStep.Selfie.CapturePage(str, str2, str3, str4, str5, str6, str8);
                } else {
                    JsonDataException o16 = c.o("selfieHintHoldStill", "selfieHintHoldStill", jsonReader2);
                    j.f(o16, "missingProperty(\"selfieH…ieHintHoldStill\", reader)");
                    throw o16;
                }
            }
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.Selfie.CapturePage capturePage) {
        j.g(qVar, "writer");
        if (capturePage != null) {
            qVar.c();
            qVar.u("selfieHintTakePhoto");
            this.f26864b.toJson(qVar, capturePage.h());
            qVar.u("selfieHintCenterFace");
            this.f26864b.toJson(qVar, capturePage.a());
            qVar.u("selfieHintFaceTooClose");
            this.f26864b.toJson(qVar, capturePage.c());
            qVar.u("selfieHintPoseNotCenter");
            this.f26864b.toJson(qVar, capturePage.g());
            qVar.u("selfieHintLookLeft");
            this.f26864b.toJson(qVar, capturePage.e());
            qVar.u("selfieHintLookRight");
            this.f26864b.toJson(qVar, capturePage.f());
            qVar.u("selfieHintHoldStill");
            this.f26864b.toJson(qVar, capturePage.d());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(49);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.Selfie.CapturePage");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
