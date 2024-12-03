package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_Document_PagesJsonAdapter extends h<NextStep.Document.Pages> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26738a;

    /* renamed from: b  reason: collision with root package name */
    private final h<NextStep.Document.Pages.DocumentPages> f26739b;

    public NextStep_Document_PagesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("document");
        j.f(a10, "of(\"document\")");
        this.f26738a = a10;
        h<NextStep.Document.Pages.DocumentPages> f10 = sVar.f(NextStep.Document.Pages.DocumentPages.class, n0.e(), "document");
        j.f(f10, "moshi.adapter(NextStep.D…, emptySet(), \"document\")");
        this.f26739b = f10;
    }

    /* renamed from: a */
    public NextStep.Document.Pages fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        NextStep.Document.Pages.DocumentPages documentPages = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26738a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                documentPages = this.f26739b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new NextStep.Document.Pages(documentPages);
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.Document.Pages pages) {
        j.g(qVar, "writer");
        if (pages != null) {
            qVar.c();
            qVar.u("document");
            this.f26739b.toJson(qVar, pages.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(45);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.Document.Pages");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
