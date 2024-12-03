package com.withpersona.sdk2.inquiry.network;

import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.network.ErrorResponse;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class ErrorResponseJsonAdapter extends h<ErrorResponse> {
    private final h<List<ErrorResponse.Error>> nullableListOfErrorAdapter;
    private final JsonReader.b options;

    public ErrorResponseJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a(IdentityHttpResponse.ERRORS);
        j.f(a10, "of(\"errors\")");
        this.options = a10;
        h<List<ErrorResponse.Error>> f10 = sVar.f(w.j(List.class, ErrorResponse.Error.class), n0.e(), IdentityHttpResponse.ERRORS);
        j.f(f10, "moshi.adapter(Types.newP…    emptySet(), \"errors\")");
        this.nullableListOfErrorAdapter = f10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("ErrorResponse");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    public ErrorResponse fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        List list = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.options);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                list = this.nullableListOfErrorAdapter.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new ErrorResponse(list);
    }

    public void toJson(q qVar, ErrorResponse errorResponse) {
        j.g(qVar, "writer");
        if (errorResponse != null) {
            qVar.c();
            qVar.u(IdentityHttpResponse.ERRORS);
            this.nullableListOfErrorAdapter.toJson(qVar, errorResponse.getErrors());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
