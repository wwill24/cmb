package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_Document_PendingPageJsonAdapter extends h<NextStep.Document.PendingPage> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26753a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26754b;

    public NextStep_Document_PendingPageJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("title", "description");
        j.f(a10, "of(\"title\", \"description\")");
        this.f26753a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "title");
        j.f(f10, "moshi.adapter(String::cl…     emptySet(), \"title\")");
        this.f26754b = f10;
    }

    /* renamed from: a */
    public NextStep.Document.PendingPage fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26753a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f26754b.fromJson(jsonReader);
            } else if (L == 1) {
                str2 = this.f26754b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new NextStep.Document.PendingPage(str, str2);
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.Document.PendingPage pendingPage) {
        j.g(qVar, "writer");
        if (pendingPage != null) {
            qVar.c();
            qVar.u("title");
            this.f26754b.toJson(qVar, pendingPage.c());
            qVar.u("description");
            this.f26754b.toJson(qVar, pendingPage.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(51);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.Document.PendingPage");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
