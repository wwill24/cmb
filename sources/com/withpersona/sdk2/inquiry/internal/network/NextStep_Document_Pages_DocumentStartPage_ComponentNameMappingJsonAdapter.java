package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_Document_Pages_DocumentStartPage_ComponentNameMappingJsonAdapter extends h<NextStep.Document.Pages.DocumentStartPage.ComponentNameMapping> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26746a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26747b;

    public NextStep_Document_Pages_DocumentStartPage_ComponentNameMappingJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("buttonFilePicker", "buttonPhotoLibrary", "buttonCamera", "buttonUploadOptions");
        j.f(a10, "of(\"buttonFilePicker\",\n …\", \"buttonUploadOptions\")");
        this.f26746a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "buttonFilePicker");
        j.f(f10, "moshi.adapter(String::cl…et(), \"buttonFilePicker\")");
        this.f26747b = f10;
    }

    /* renamed from: a */
    public NextStep.Document.Pages.DocumentStartPage.ComponentNameMapping fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26746a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f26747b.fromJson(jsonReader);
            } else if (L == 1) {
                str2 = this.f26747b.fromJson(jsonReader);
            } else if (L == 2) {
                str3 = this.f26747b.fromJson(jsonReader);
            } else if (L == 3) {
                str4 = this.f26747b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new NextStep.Document.Pages.DocumentStartPage.ComponentNameMapping(str, str2, str3, str4);
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.Document.Pages.DocumentStartPage.ComponentNameMapping componentNameMapping) {
        j.g(qVar, "writer");
        if (componentNameMapping != null) {
            qVar.c();
            qVar.u("buttonFilePicker");
            this.f26747b.toJson(qVar, componentNameMapping.c());
            qVar.u("buttonPhotoLibrary");
            this.f26747b.toJson(qVar, componentNameMapping.d());
            qVar.u("buttonCamera");
            this.f26747b.toJson(qVar, componentNameMapping.a());
            qVar.u("buttonUploadOptions");
            this.f26747b.toJson(qVar, componentNameMapping.e());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(84);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.Document.Pages.DocumentStartPage.ComponentNameMapping");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
