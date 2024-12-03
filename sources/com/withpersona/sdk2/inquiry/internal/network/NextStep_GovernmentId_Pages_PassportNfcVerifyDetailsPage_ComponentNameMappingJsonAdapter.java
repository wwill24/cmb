package com.withpersona.sdk2.inquiry.internal.network;

import com.facebook.AuthenticationTokenClaims;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_GovernmentId_Pages_PassportNfcVerifyDetailsPage_ComponentNameMappingJsonAdapter extends h<NextStep.GovernmentId.Pages.PassportNfcVerifyDetailsPage.ComponentNameMapping> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26847a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26848b;

    public NextStep_GovernmentId_Pages_PassportNfcVerifyDetailsPage_ComponentNameMappingJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("documentNumber", "dob", AuthenticationTokenClaims.JSON_KEY_EXP, "confirmButton");
        j.f(a10, "of(\"documentNumber\", \"do…\",\n      \"confirmButton\")");
        this.f26847a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "documentNumber");
        j.f(f10, "moshi.adapter(String::cl…ySet(), \"documentNumber\")");
        this.f26848b = f10;
    }

    /* renamed from: a */
    public NextStep.GovernmentId.Pages.PassportNfcVerifyDetailsPage.ComponentNameMapping fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26847a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f26848b.fromJson(jsonReader);
            } else if (L == 1) {
                str2 = this.f26848b.fromJson(jsonReader);
            } else if (L == 2) {
                str3 = this.f26848b.fromJson(jsonReader);
            } else if (L == 3) {
                str4 = this.f26848b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new NextStep.GovernmentId.Pages.PassportNfcVerifyDetailsPage.ComponentNameMapping(str, str2, str3, str4);
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.GovernmentId.Pages.PassportNfcVerifyDetailsPage.ComponentNameMapping componentNameMapping) {
        j.g(qVar, "writer");
        if (componentNameMapping != null) {
            qVar.c();
            qVar.u("documentNumber");
            this.f26848b.toJson(qVar, componentNameMapping.c());
            qVar.u("dob");
            this.f26848b.toJson(qVar, componentNameMapping.b());
            qVar.u(AuthenticationTokenClaims.JSON_KEY_EXP);
            this.f26848b.toJson(qVar, componentNameMapping.d());
            qVar.u("confirmButton");
            this.f26848b.toJson(qVar, componentNameMapping.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(99);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.GovernmentId.Pages.PassportNfcVerifyDetailsPage.ComponentNameMapping");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
