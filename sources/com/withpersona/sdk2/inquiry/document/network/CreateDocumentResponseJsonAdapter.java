package com.withpersona.sdk2.inquiry.document.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.document.network.CreateDocumentResponse;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class CreateDocumentResponseJsonAdapter extends h<CreateDocumentResponse> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f25185a;

    /* renamed from: b  reason: collision with root package name */
    private final h<CreateDocumentResponse.Data> f25186b;

    /* renamed from: c  reason: collision with root package name */
    private final h<List<DocumentFileData>> f25187c;

    public CreateDocumentResponseJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("data", "included");
        j.f(a10, "of(\"data\", \"included\")");
        this.f25185a = a10;
        h<CreateDocumentResponse.Data> f10 = sVar.f(CreateDocumentResponse.Data.class, n0.e(), "data");
        j.f(f10, "moshi.adapter(CreateDocu…java, emptySet(), \"data\")");
        this.f25186b = f10;
        h<List<DocumentFileData>> f11 = sVar.f(w.j(List.class, DocumentFileData.class), n0.e(), "included");
        j.f(f11, "moshi.adapter(Types.newP…  emptySet(), \"included\")");
        this.f25187c = f11;
    }

    /* renamed from: a */
    public CreateDocumentResponse fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        CreateDocumentResponse.Data data = null;
        List list = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f25185a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                data = this.f25186b.fromJson(jsonReader);
                if (data == null) {
                    JsonDataException x10 = c.x("data_", "data", jsonReader);
                    j.f(x10, "unexpectedNull(\"data_\", …ata\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                list = this.f25187c.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        if (data != null) {
            return new CreateDocumentResponse(data, list);
        }
        JsonDataException o10 = c.o("data_", "data", jsonReader);
        j.f(o10, "missingProperty(\"data_\", \"data\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, CreateDocumentResponse createDocumentResponse) {
        j.g(qVar, "writer");
        if (createDocumentResponse != null) {
            qVar.c();
            qVar.u("data");
            this.f25186b.toJson(qVar, createDocumentResponse.a());
            qVar.u("included");
            this.f25187c.toJson(qVar, createDocumentResponse.b());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(44);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CreateDocumentResponse");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
