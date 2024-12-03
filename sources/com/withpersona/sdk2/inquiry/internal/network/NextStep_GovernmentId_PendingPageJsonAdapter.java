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

public final class NextStep_GovernmentId_PendingPageJsonAdapter extends h<NextStep.GovernmentId.PendingPage> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26849a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26850b;

    public NextStep_GovernmentId_PendingPageJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("title", "description");
        j.f(a10, "of(\"title\", \"description\")");
        this.f26849a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "title");
        j.f(f10, "moshi.adapter(String::cl…mptySet(),\n      \"title\")");
        this.f26850b = f10;
    }

    /* renamed from: a */
    public NextStep.GovernmentId.PendingPage fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26849a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f26850b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("title", "title", jsonReader);
                    j.f(x10, "unexpectedNull(\"title\", …tle\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1 && (str2 = this.f26850b.fromJson(jsonReader)) == null) {
                JsonDataException x11 = c.x("description", "description", jsonReader);
                j.f(x11, "unexpectedNull(\"descript…\", \"description\", reader)");
                throw x11;
            }
        }
        jsonReader.e();
        if (str == null) {
            JsonDataException o10 = c.o("title", "title", jsonReader);
            j.f(o10, "missingProperty(\"title\", \"title\", reader)");
            throw o10;
        } else if (str2 != null) {
            return new NextStep.GovernmentId.PendingPage(str, str2);
        } else {
            JsonDataException o11 = c.o("description", "description", jsonReader);
            j.f(o11, "missingProperty(\"descrip…ion\",\n            reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.GovernmentId.PendingPage pendingPage) {
        j.g(qVar, "writer");
        if (pendingPage != null) {
            qVar.c();
            qVar.u("title");
            this.f26850b.toJson(qVar, pendingPage.c());
            qVar.u("description");
            this.f26850b.toJson(qVar, pendingPage.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.GovernmentId.PendingPage");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
