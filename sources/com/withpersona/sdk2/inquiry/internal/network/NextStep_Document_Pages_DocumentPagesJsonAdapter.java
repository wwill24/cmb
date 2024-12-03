package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_Document_Pages_DocumentPagesJsonAdapter extends h<NextStep.Document.Pages.DocumentPages> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26740a;

    /* renamed from: b  reason: collision with root package name */
    private final h<NextStep.Document.Pages.DocumentStartPage> f26741b;

    /* renamed from: c  reason: collision with root package name */
    private final h<NextStep.Document.Pages.UploadOptionsDialog> f26742c;

    public NextStep_Document_Pages_DocumentPagesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("prompt", "uploadOptionsDialog");
        j.f(a10, "of(\"prompt\", \"uploadOptionsDialog\")");
        this.f26740a = a10;
        h<NextStep.Document.Pages.DocumentStartPage> f10 = sVar.f(NextStep.Document.Pages.DocumentStartPage.class, n0.e(), "prompt");
        j.f(f10, "moshi.adapter(NextStep.D…va, emptySet(), \"prompt\")");
        this.f26741b = f10;
        h<NextStep.Document.Pages.UploadOptionsDialog> f11 = sVar.f(NextStep.Document.Pages.UploadOptionsDialog.class, n0.e(), "uploadOptionsDialog");
        j.f(f11, "moshi.adapter(NextStep.D…   \"uploadOptionsDialog\")");
        this.f26742c = f11;
    }

    /* renamed from: a */
    public NextStep.Document.Pages.DocumentPages fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        NextStep.Document.Pages.DocumentStartPage documentStartPage = null;
        NextStep.Document.Pages.UploadOptionsDialog uploadOptionsDialog = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26740a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                documentStartPage = this.f26741b.fromJson(jsonReader);
            } else if (L == 1) {
                uploadOptionsDialog = this.f26742c.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new NextStep.Document.Pages.DocumentPages(documentStartPage, uploadOptionsDialog);
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.Document.Pages.DocumentPages documentPages) {
        j.g(qVar, "writer");
        if (documentPages != null) {
            qVar.c();
            qVar.u("prompt");
            this.f26741b.toJson(qVar, documentPages.a());
            qVar.u("uploadOptionsDialog");
            this.f26742c.toJson(qVar, documentPages.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(59);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.Document.Pages.DocumentPages");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
