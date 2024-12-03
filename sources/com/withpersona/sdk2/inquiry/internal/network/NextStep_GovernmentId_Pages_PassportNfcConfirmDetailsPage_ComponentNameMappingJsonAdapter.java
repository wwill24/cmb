package com.withpersona.sdk2.inquiry.internal.network;

import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.facebook.AuthenticationTokenClaims;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_GovernmentId_Pages_PassportNfcConfirmDetailsPage_ComponentNameMappingJsonAdapter extends h<NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage.ComponentNameMapping> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26800a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26801b;

    public NextStep_GovernmentId_Pages_PassportNfcConfirmDetailsPage_ComponentNameMappingJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("image", "passportNumber", "dob", AuthenticationTokenClaims.JSON_KEY_EXP, "firstName", "lastName", ProfileConstants.Field.GENDER, "issuingAuthority", "nationality", "address", "completeButton", "retryButton");
        j.f(a10, "of(\"image\", \"passportNum…teButton\", \"retryButton\")");
        this.f26800a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "image");
        j.f(f10, "moshi.adapter(String::cl…     emptySet(), \"image\")");
        this.f26801b = f10;
    }

    /* renamed from: a */
    public NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage.ComponentNameMapping fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f26800a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    str = this.f26801b.fromJson(jsonReader);
                    break;
                case 1:
                    str2 = this.f26801b.fromJson(jsonReader);
                    break;
                case 2:
                    str3 = this.f26801b.fromJson(jsonReader);
                    break;
                case 3:
                    str4 = this.f26801b.fromJson(jsonReader);
                    break;
                case 4:
                    str5 = this.f26801b.fromJson(jsonReader);
                    break;
                case 5:
                    str6 = this.f26801b.fromJson(jsonReader);
                    break;
                case 6:
                    str7 = this.f26801b.fromJson(jsonReader);
                    break;
                case 7:
                    str8 = this.f26801b.fromJson(jsonReader);
                    break;
                case 8:
                    str9 = this.f26801b.fromJson(jsonReader);
                    break;
                case 9:
                    str10 = this.f26801b.fromJson(jsonReader);
                    break;
                case 10:
                    str11 = this.f26801b.fromJson(jsonReader);
                    break;
                case 11:
                    str12 = this.f26801b.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.e();
        return new NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage.ComponentNameMapping(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage.ComponentNameMapping componentNameMapping) {
        j.g(qVar, "writer");
        if (componentNameMapping != null) {
            qVar.c();
            qVar.u("image");
            this.f26801b.toJson(qVar, componentNameMapping.g());
            qVar.u("passportNumber");
            this.f26801b.toJson(qVar, componentNameMapping.k());
            qVar.u("dob");
            this.f26801b.toJson(qVar, componentNameMapping.c());
            qVar.u(AuthenticationTokenClaims.JSON_KEY_EXP);
            this.f26801b.toJson(qVar, componentNameMapping.d());
            qVar.u("firstName");
            this.f26801b.toJson(qVar, componentNameMapping.e());
            qVar.u("lastName");
            this.f26801b.toJson(qVar, componentNameMapping.i());
            qVar.u(ProfileConstants.Field.GENDER);
            this.f26801b.toJson(qVar, componentNameMapping.f());
            qVar.u("issuingAuthority");
            this.f26801b.toJson(qVar, componentNameMapping.h());
            qVar.u("nationality");
            this.f26801b.toJson(qVar, componentNameMapping.j());
            qVar.u("address");
            this.f26801b.toJson(qVar, componentNameMapping.a());
            qVar.u("completeButton");
            this.f26801b.toJson(qVar, componentNameMapping.b());
            qVar.u("retryButton");
            this.f26801b.toJson(qVar, componentNameMapping.l());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(100);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.GovernmentId.Pages.PassportNfcConfirmDetailsPage.ComponentNameMapping");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
