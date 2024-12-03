package com.withpersona.sdk2.inquiry.network;

import bi.c;
import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class GenericFileUploadErrorResponseJsonAdapter extends h<GenericFileUploadErrorResponse> {
    private final h<List<GenericFileUploadErrorResponse.DocumentErrorResponse>> listOfDocumentErrorResponseAdapter;
    private final JsonReader.b options;

    public GenericFileUploadErrorResponseJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a(IdentityHttpResponse.ERRORS);
        j.f(a10, "of(\"errors\")");
        this.options = a10;
        h<List<GenericFileUploadErrorResponse.DocumentErrorResponse>> f10 = sVar.f(w.j(List.class, GenericFileUploadErrorResponse.DocumentErrorResponse.class), n0.e(), IdentityHttpResponse.ERRORS);
        j.f(f10, "moshi.adapter(Types.newP…a), emptySet(), \"errors\")");
        this.listOfDocumentErrorResponseAdapter = f10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(52);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("GenericFileUploadErrorResponse");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    public GenericFileUploadErrorResponse fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        List list = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.options);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (list = this.listOfDocumentErrorResponseAdapter.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x(IdentityHttpResponse.ERRORS, IdentityHttpResponse.ERRORS, jsonReader);
                j.f(x10, "unexpectedNull(\"errors\", \"errors\", reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (list != null) {
            return new GenericFileUploadErrorResponse(list);
        }
        JsonDataException o10 = c.o(IdentityHttpResponse.ERRORS, IdentityHttpResponse.ERRORS, jsonReader);
        j.f(o10, "missingProperty(\"errors\", \"errors\", reader)");
        throw o10;
    }

    public void toJson(q qVar, GenericFileUploadErrorResponse genericFileUploadErrorResponse) {
        j.g(qVar, "writer");
        if (genericFileUploadErrorResponse != null) {
            qVar.c();
            qVar.u(IdentityHttpResponse.ERRORS);
            this.listOfDocumentErrorResponseAdapter.toJson(qVar, genericFileUploadErrorResponse.getErrors());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
