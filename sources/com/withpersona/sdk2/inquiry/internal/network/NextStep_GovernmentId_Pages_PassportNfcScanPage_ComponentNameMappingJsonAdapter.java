package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_GovernmentId_Pages_PassportNfcScanPage_ComponentNameMappingJsonAdapter extends h<NextStep.GovernmentId.Pages.PassportNfcScanPage.ComponentNameMapping> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26832a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26833b;

    public NextStep_GovernmentId_Pages_PassportNfcScanPage_ComponentNameMappingJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("confirmButton");
        j.f(a10, "of(\"confirmButton\")");
        this.f26832a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "confirmButton");
        j.f(f10, "moshi.adapter(String::cl…tySet(), \"confirmButton\")");
        this.f26833b = f10;
    }

    /* renamed from: a */
    public NextStep.GovernmentId.Pages.PassportNfcScanPage.ComponentNameMapping fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26832a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f26833b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new NextStep.GovernmentId.Pages.PassportNfcScanPage.ComponentNameMapping(str);
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.GovernmentId.Pages.PassportNfcScanPage.ComponentNameMapping componentNameMapping) {
        j.g(qVar, "writer");
        if (componentNameMapping != null) {
            qVar.c();
            qVar.u("confirmButton");
            this.f26833b.toJson(qVar, componentNameMapping.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(90);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.GovernmentId.Pages.PassportNfcScanPage.ComponentNameMapping");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
