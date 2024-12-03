package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_GovernmentId_Pages_PassportNfcModuleMissingPage_ComponentNameMappingJsonAdapter extends h<NextStep.GovernmentId.Pages.PassportNfcModuleMissingPage.ComponentNameMapping> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26815a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26816b;

    public NextStep_GovernmentId_Pages_PassportNfcModuleMissingPage_ComponentNameMappingJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("confirmButton");
        j.f(a10, "of(\"confirmButton\")");
        this.f26815a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "confirmButton");
        j.f(f10, "moshi.adapter(String::cl…tySet(), \"confirmButton\")");
        this.f26816b = f10;
    }

    /* renamed from: a */
    public NextStep.GovernmentId.Pages.PassportNfcModuleMissingPage.ComponentNameMapping fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26815a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f26816b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new NextStep.GovernmentId.Pages.PassportNfcModuleMissingPage.ComponentNameMapping(str);
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.GovernmentId.Pages.PassportNfcModuleMissingPage.ComponentNameMapping componentNameMapping) {
        j.g(qVar, "writer");
        if (componentNameMapping != null) {
            qVar.c();
            qVar.u("confirmButton");
            this.f26816b.toJson(qVar, componentNameMapping.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(99);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.GovernmentId.Pages.PassportNfcModuleMissingPage.ComponentNameMapping");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
