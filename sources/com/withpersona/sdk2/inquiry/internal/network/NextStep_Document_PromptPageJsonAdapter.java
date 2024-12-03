package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_Document_PromptPageJsonAdapter extends h<NextStep.Document.PromptPage> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26755a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26756b;

    public NextStep_Document_PromptPageJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("title", "prompt", "disclaimer", "captureOptionsDialogTitle", "btnCapture", "btnUpload", "btnSubmit", "cameraPermissionsTitle", "cameraPermissionsPrompt", "cameraPermissionsBtnContinueMobile", "cameraPermissionsBtnCancel");
        j.f(a10, "of(\"title\", \"prompt\", \"d…eraPermissionsBtnCancel\")");
        this.f26755a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "title");
        j.f(f10, "moshi.adapter(String::cl…     emptySet(), \"title\")");
        this.f26756b = f10;
    }

    /* renamed from: a */
    public NextStep.Document.PromptPage fromJson(JsonReader jsonReader) {
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
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f26755a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    str = this.f26756b.fromJson(jsonReader);
                    break;
                case 1:
                    str2 = this.f26756b.fromJson(jsonReader);
                    break;
                case 2:
                    str3 = this.f26756b.fromJson(jsonReader);
                    break;
                case 3:
                    str4 = this.f26756b.fromJson(jsonReader);
                    break;
                case 4:
                    str5 = this.f26756b.fromJson(jsonReader);
                    break;
                case 5:
                    str6 = this.f26756b.fromJson(jsonReader);
                    break;
                case 6:
                    str7 = this.f26756b.fromJson(jsonReader);
                    break;
                case 7:
                    str8 = this.f26756b.fromJson(jsonReader);
                    break;
                case 8:
                    str9 = this.f26756b.fromJson(jsonReader);
                    break;
                case 9:
                    str10 = this.f26756b.fromJson(jsonReader);
                    break;
                case 10:
                    str11 = this.f26756b.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.e();
        return new NextStep.Document.PromptPage(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.Document.PromptPage promptPage) {
        j.g(qVar, "writer");
        if (promptPage != null) {
            qVar.c();
            qVar.u("title");
            this.f26756b.toJson(qVar, promptPage.l());
            qVar.u("prompt");
            this.f26756b.toJson(qVar, promptPage.k());
            qVar.u("disclaimer");
            this.f26756b.toJson(qVar, promptPage.j());
            qVar.u("captureOptionsDialogTitle");
            this.f26756b.toJson(qVar, promptPage.i());
            qVar.u("btnCapture");
            this.f26756b.toJson(qVar, promptPage.a());
            qVar.u("btnUpload");
            this.f26756b.toJson(qVar, promptPage.d());
            qVar.u("btnSubmit");
            this.f26756b.toJson(qVar, promptPage.c());
            qVar.u("cameraPermissionsTitle");
            this.f26756b.toJson(qVar, promptPage.h());
            qVar.u("cameraPermissionsPrompt");
            this.f26756b.toJson(qVar, promptPage.g());
            qVar.u("cameraPermissionsBtnContinueMobile");
            this.f26756b.toJson(qVar, promptPage.e());
            qVar.u("cameraPermissionsBtnCancel");
            this.f26756b.toJson(qVar, promptPage.f());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(50);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.Document.PromptPage");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
