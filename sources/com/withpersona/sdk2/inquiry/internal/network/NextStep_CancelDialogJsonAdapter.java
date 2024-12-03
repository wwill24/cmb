package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class NextStep_CancelDialogJsonAdapter extends h<NextStep.CancelDialog> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26718a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26719b;

    public NextStep_CancelDialogJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("title", "prompt", "btnSubmit", "btnResume");
        j.f(a10, "of(\"title\", \"prompt\", \"b…bmit\",\n      \"btnResume\")");
        this.f26718a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "title");
        j.f(f10, "moshi.adapter(String::cl…     emptySet(), \"title\")");
        this.f26719b = f10;
    }

    /* renamed from: a */
    public NextStep.CancelDialog fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26718a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f26719b.fromJson(jsonReader);
            } else if (L == 1) {
                str2 = this.f26719b.fromJson(jsonReader);
            } else if (L == 2) {
                str3 = this.f26719b.fromJson(jsonReader);
            } else if (L == 3) {
                str4 = this.f26719b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new NextStep.CancelDialog(str, str2, str3, str4);
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.CancelDialog cancelDialog) {
        j.g(qVar, "writer");
        if (cancelDialog != null) {
            qVar.c();
            qVar.u("title");
            this.f26719b.toJson(qVar, cancelDialog.e());
            qVar.u("prompt");
            this.f26719b.toJson(qVar, cancelDialog.d());
            qVar.u("btnSubmit");
            this.f26719b.toJson(qVar, cancelDialog.c());
            qVar.u("btnResume");
            this.f26719b.toJson(qVar, cancelDialog.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(43);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.CancelDialog");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
