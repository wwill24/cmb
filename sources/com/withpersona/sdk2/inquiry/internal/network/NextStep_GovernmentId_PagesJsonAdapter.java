package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_GovernmentId_PagesJsonAdapter extends h<NextStep.GovernmentId.Pages> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26795a;

    /* renamed from: b  reason: collision with root package name */
    private final h<NextStep.GovernmentId.Pages.PassportNfc> f26796b;

    public NextStep_GovernmentId_PagesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("passportNfc");
        j.f(a10, "of(\"passportNfc\")");
        this.f26795a = a10;
        h<NextStep.GovernmentId.Pages.PassportNfc> f10 = sVar.f(NextStep.GovernmentId.Pages.PassportNfc.class, n0.e(), "passportNfc");
        j.f(f10, "moshi.adapter(NextStep.G…mptySet(), \"passportNfc\")");
        this.f26796b = f10;
    }

    /* renamed from: a */
    public NextStep.GovernmentId.Pages fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        NextStep.GovernmentId.Pages.PassportNfc passportNfc = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26795a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                passportNfc = this.f26796b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new NextStep.GovernmentId.Pages(passportNfc);
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.GovernmentId.Pages pages) {
        j.g(qVar, "writer");
        if (pages != null) {
            qVar.c();
            qVar.u("passportNfc");
            this.f26796b.toJson(qVar, pages.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(49);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.GovernmentId.Pages");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
