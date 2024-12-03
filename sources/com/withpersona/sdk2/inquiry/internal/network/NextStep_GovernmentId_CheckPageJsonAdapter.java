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

public final class NextStep_GovernmentId_CheckPageJsonAdapter extends h<NextStep.GovernmentId.CheckPage> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26764a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26765b;

    public NextStep_GovernmentId_CheckPageJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("btnSubmit", "btnRetake");
        j.f(a10, "of(\"btnSubmit\", \"btnRetake\")");
        this.f26764a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "buttonSubmit");
        j.f(f10, "moshi.adapter(String::cl…(),\n      \"buttonSubmit\")");
        this.f26765b = f10;
    }

    /* renamed from: a */
    public NextStep.GovernmentId.CheckPage fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26764a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f26765b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("buttonSubmit", "btnSubmit", jsonReader);
                    j.f(x10, "unexpectedNull(\"buttonSu…it\", \"btnSubmit\", reader)");
                    throw x10;
                }
            } else if (L == 1 && (str2 = this.f26765b.fromJson(jsonReader)) == null) {
                JsonDataException x11 = c.x("buttonRetake", "btnRetake", jsonReader);
                j.f(x11, "unexpectedNull(\"buttonRe…ke\", \"btnRetake\", reader)");
                throw x11;
            }
        }
        jsonReader.e();
        if (str == null) {
            JsonDataException o10 = c.o("buttonSubmit", "btnSubmit", jsonReader);
            j.f(o10, "missingProperty(\"buttonS…mit\",\n            reader)");
            throw o10;
        } else if (str2 != null) {
            return new NextStep.GovernmentId.CheckPage(str, str2);
        } else {
            JsonDataException o11 = c.o("buttonRetake", "btnRetake", jsonReader);
            j.f(o11, "missingProperty(\"buttonR…ake\",\n            reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.GovernmentId.CheckPage checkPage) {
        j.g(qVar, "writer");
        if (checkPage != null) {
            qVar.c();
            qVar.u("btnSubmit");
            this.f26765b.toJson(qVar, checkPage.c());
            qVar.u("btnRetake");
            this.f26765b.toJson(qVar, checkPage.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(53);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.GovernmentId.CheckPage");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
