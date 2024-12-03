package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_GovernmentId_PromptPageJsonAdapter extends h<NextStep.GovernmentId.PromptPage> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26851a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26852b;

    public NextStep_GovernmentId_PromptPageJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("cameraPermissionsTitle", "cameraPermissionsPrompt", "cameraPermissionsBtnContinueMobile", "cameraPermissionsBtnCancel", "microphonePermissionsBtnCancel", "microphonePermissionsBtnContinueMobile", "microphonePermissionsPrompt", "microphonePermissionsTitle");
        j.f(a10, "of(\"cameraPermissionsTit…rophonePermissionsTitle\")");
        this.f26851a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "cameraPermissionsTitle");
        j.f(f10, "moshi.adapter(String::cl…\"cameraPermissionsTitle\")");
        this.f26852b = f10;
    }

    /* renamed from: a */
    public NextStep.GovernmentId.PromptPage fromJson(JsonReader jsonReader) {
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
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f26851a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    str = this.f26852b.fromJson(jsonReader);
                    break;
                case 1:
                    str2 = this.f26852b.fromJson(jsonReader);
                    break;
                case 2:
                    str3 = this.f26852b.fromJson(jsonReader);
                    break;
                case 3:
                    str4 = this.f26852b.fromJson(jsonReader);
                    break;
                case 4:
                    str5 = this.f26852b.fromJson(jsonReader);
                    break;
                case 5:
                    str6 = this.f26852b.fromJson(jsonReader);
                    break;
                case 6:
                    str7 = this.f26852b.fromJson(jsonReader);
                    break;
                case 7:
                    str8 = this.f26852b.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.e();
        return new NextStep.GovernmentId.PromptPage(str, str2, str3, str4, str5, str6, str7, str8);
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.GovernmentId.PromptPage promptPage) {
        j.g(qVar, "writer");
        if (promptPage != null) {
            qVar.c();
            qVar.u("cameraPermissionsTitle");
            this.f26852b.toJson(qVar, promptPage.e());
            qVar.u("cameraPermissionsPrompt");
            this.f26852b.toJson(qVar, promptPage.d());
            qVar.u("cameraPermissionsBtnContinueMobile");
            this.f26852b.toJson(qVar, promptPage.a());
            qVar.u("cameraPermissionsBtnCancel");
            this.f26852b.toJson(qVar, promptPage.c());
            qVar.u("microphonePermissionsBtnCancel");
            this.f26852b.toJson(qVar, promptPage.f());
            qVar.u("microphonePermissionsBtnContinueMobile");
            this.f26852b.toJson(qVar, promptPage.g());
            qVar.u("microphonePermissionsPrompt");
            this.f26852b.toJson(qVar, promptPage.h());
            qVar.u("microphonePermissionsTitle");
            this.f26852b.toJson(qVar, promptPage.i());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.GovernmentId.PromptPage");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
