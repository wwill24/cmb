package com.withpersona.sdk2.inquiry.document.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.document.network.DocumentFileData;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class DocumentFileData_AttributesJsonAdapter extends h<DocumentFileData.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f25206a;

    /* renamed from: b  reason: collision with root package name */
    private final h<List<DocumentFileData.RemoteDocumentFile>> f25207b;

    public DocumentFileData_AttributesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("originals");
        j.f(a10, "of(\"originals\")");
        this.f25206a = a10;
        h<List<DocumentFileData.RemoteDocumentFile>> f10 = sVar.f(w.j(List.class, DocumentFileData.RemoteDocumentFile.class), n0.e(), "originals");
        j.f(f10, "moshi.adapter(Types.newP… emptySet(), \"originals\")");
        this.f25207b = f10;
    }

    /* renamed from: a */
    public DocumentFileData.Attributes fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        List list = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f25206a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                list = this.f25207b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new DocumentFileData.Attributes(list);
    }

    /* renamed from: b */
    public void toJson(q qVar, DocumentFileData.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u("originals");
            this.f25207b.toJson(qVar, attributes.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(49);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("DocumentFileData.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
