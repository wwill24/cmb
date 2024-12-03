package com.withpersona.sdk2.inquiry.internal.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.ErrorRequest;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class ErrorRequestJsonAdapter extends h<ErrorRequest> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26462a;

    /* renamed from: b  reason: collision with root package name */
    private final h<ErrorRequest.ErrorType> f26463b;

    /* renamed from: c  reason: collision with root package name */
    private final h<Object> f26464c;

    public ErrorRequestJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("errorType", "debugDescription");
        j.f(a10, "of(\"errorType\", \"debugDescription\")");
        this.f26462a = a10;
        h<ErrorRequest.ErrorType> f10 = sVar.f(ErrorRequest.ErrorType.class, n0.e(), "errorType");
        j.f(f10, "moshi.adapter(ErrorReque… emptySet(), \"errorType\")");
        this.f26463b = f10;
        h<Object> f11 = sVar.f(Object.class, n0.e(), "debugDescription");
        j.f(f11, "moshi.adapter(Any::class…      \"debugDescription\")");
        this.f26464c = f11;
    }

    /* renamed from: a */
    public ErrorRequest fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        ErrorRequest.ErrorType errorType = null;
        Object obj = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26462a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                errorType = this.f26463b.fromJson(jsonReader);
                if (errorType == null) {
                    JsonDataException x10 = c.x("errorType", "errorType", jsonReader);
                    j.f(x10, "unexpectedNull(\"errorTyp…     \"errorType\", reader)");
                    throw x10;
                }
            } else if (L == 1) {
                obj = this.f26464c.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        if (errorType != null) {
            return new ErrorRequest(errorType, obj);
        }
        JsonDataException o10 = c.o("errorType", "errorType", jsonReader);
        j.f(o10, "missingProperty(\"errorType\", \"errorType\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, ErrorRequest errorRequest) {
        j.g(qVar, "writer");
        if (errorRequest != null) {
            qVar.c();
            qVar.u("errorType");
            this.f26463b.toJson(qVar, errorRequest.b());
            qVar.u("debugDescription");
            this.f26464c.toJson(qVar, errorRequest.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(34);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("ErrorRequest");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
