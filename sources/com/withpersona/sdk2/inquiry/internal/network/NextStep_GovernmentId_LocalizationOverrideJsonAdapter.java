package com.withpersona.sdk2.inquiry.internal.network;

import bi.c;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;

public final class NextStep_GovernmentId_LocalizationOverrideJsonAdapter extends h<NextStep.GovernmentId.LocalizationOverride> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26778a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26779b;

    /* renamed from: c  reason: collision with root package name */
    private final h<String> f26780c;

    public NextStep_GovernmentId_LocalizationOverrideJsonAdapter(s sVar) {
        Class<String> cls = String.class;
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a(RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, "idClass", "side", DataLayout.ELEMENT, SDKConstants.PARAM_KEY, "text");
        j.f(a10, "of(\"countryCode\", \"idCla…   \"page\", \"key\", \"text\")");
        this.f26778a = a10;
        h<String> f10 = sVar.f(cls, n0.e(), RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE);
        j.f(f10, "moshi.adapter(String::cl…mptySet(), \"countryCode\")");
        this.f26779b = f10;
        h<String> f11 = sVar.f(cls, n0.e(), DataLayout.ELEMENT);
        j.f(f11, "moshi.adapter(String::cl…emptySet(),\n      \"page\")");
        this.f26780c = f11;
    }

    /* renamed from: a */
    public NextStep.GovernmentId.LocalizationOverride fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f26778a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    str = this.f26779b.fromJson(jsonReader);
                    break;
                case 1:
                    str2 = this.f26779b.fromJson(jsonReader);
                    break;
                case 2:
                    str3 = this.f26779b.fromJson(jsonReader);
                    break;
                case 3:
                    str4 = this.f26780c.fromJson(jsonReader);
                    if (str4 != null) {
                        break;
                    } else {
                        JsonDataException x10 = c.x(DataLayout.ELEMENT, DataLayout.ELEMENT, jsonReader);
                        j.f(x10, "unexpectedNull(\"page\", \"page\",\n            reader)");
                        throw x10;
                    }
                case 4:
                    str5 = this.f26780c.fromJson(jsonReader);
                    if (str5 != null) {
                        break;
                    } else {
                        JsonDataException x11 = c.x(SDKConstants.PARAM_KEY, SDKConstants.PARAM_KEY, jsonReader);
                        j.f(x11, "unexpectedNull(\"key\", \"key\", reader)");
                        throw x11;
                    }
                case 5:
                    str6 = this.f26780c.fromJson(jsonReader);
                    if (str6 != null) {
                        break;
                    } else {
                        JsonDataException x12 = c.x("text", "text", jsonReader);
                        j.f(x12, "unexpectedNull(\"text\", \"text\",\n            reader)");
                        throw x12;
                    }
            }
        }
        jsonReader.e();
        if (str4 == null) {
            JsonDataException o10 = c.o(DataLayout.ELEMENT, DataLayout.ELEMENT, jsonReader);
            j.f(o10, "missingProperty(\"page\", \"page\", reader)");
            throw o10;
        } else if (str5 == null) {
            JsonDataException o11 = c.o(SDKConstants.PARAM_KEY, SDKConstants.PARAM_KEY, jsonReader);
            j.f(o11, "missingProperty(\"key\", \"key\", reader)");
            throw o11;
        } else if (str6 != null) {
            return new NextStep.GovernmentId.LocalizationOverride(str, str2, str3, str4, str5, str6);
        } else {
            JsonDataException o12 = c.o("text", "text", jsonReader);
            j.f(o12, "missingProperty(\"text\", \"text\", reader)");
            throw o12;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.GovernmentId.LocalizationOverride localizationOverride) {
        j.g(qVar, "writer");
        if (localizationOverride != null) {
            qVar.c();
            qVar.u(RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE);
            this.f26779b.toJson(qVar, localizationOverride.c());
            qVar.u("idClass");
            this.f26779b.toJson(qVar, localizationOverride.d());
            qVar.u("side");
            this.f26779b.toJson(qVar, localizationOverride.j());
            qVar.u(DataLayout.ELEMENT);
            this.f26780c.toJson(qVar, localizationOverride.h());
            qVar.u(SDKConstants.PARAM_KEY);
            this.f26780c.toJson(qVar, localizationOverride.e());
            qVar.u("text");
            this.f26780c.toJson(qVar, localizationOverride.k());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.GovernmentId.LocalizationOverride");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
