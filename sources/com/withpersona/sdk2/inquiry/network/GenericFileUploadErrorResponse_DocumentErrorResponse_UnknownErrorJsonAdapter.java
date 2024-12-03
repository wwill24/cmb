package com.withpersona.sdk2.inquiry.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.bouncycastle.i18n.ErrorBundle;

public final class GenericFileUploadErrorResponse_DocumentErrorResponse_UnknownErrorJsonAdapter extends h<GenericFileUploadErrorResponse.DocumentErrorResponse.UnknownError> {
    private volatile Constructor<GenericFileUploadErrorResponse.DocumentErrorResponse.UnknownError> constructorRef;
    private final h<ErrorDetails> nullableErrorDetailsAdapter;
    private final h<String> nullableStringAdapter;
    private final JsonReader.b options;
    private final h<String> stringAdapter;

    public GenericFileUploadErrorResponse_DocumentErrorResponse_UnknownErrorJsonAdapter(s sVar) {
        Class<String> cls = String.class;
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("title", "code", ErrorBundle.DETAIL_ENTRY);
        j.f(a10, "of(\"title\", \"code\", \"details\")");
        this.options = a10;
        h<String> f10 = sVar.f(cls, n0.e(), "title");
        j.f(f10, "moshi.adapter(String::cl…mptySet(),\n      \"title\")");
        this.stringAdapter = f10;
        h<String> f11 = sVar.f(cls, n0.e(), "code");
        j.f(f11, "moshi.adapter(String::cl…      emptySet(), \"code\")");
        this.nullableStringAdapter = f11;
        h<ErrorDetails> f12 = sVar.f(ErrorDetails.class, n0.e(), ErrorBundle.DETAIL_ENTRY);
        j.f(f12, "moshi.adapter(ErrorDetai…a, emptySet(), \"details\")");
        this.nullableErrorDetailsAdapter = f12;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(87);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("GenericFileUploadErrorResponse.DocumentErrorResponse.UnknownError");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    public GenericFileUploadErrorResponse.DocumentErrorResponse.UnknownError fromJson(JsonReader jsonReader) {
        Class<String> cls = String.class;
        j.g(jsonReader, "reader");
        jsonReader.b();
        int i10 = -1;
        String str = null;
        String str2 = null;
        ErrorDetails errorDetails = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.options);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str != null) {
                    i10 &= -2;
                } else {
                    JsonDataException x10 = c.x("title", "title", jsonReader);
                    j.f(x10, "unexpectedNull(\"title\", …e\",\n              reader)");
                    throw x10;
                }
            } else if (L == 1) {
                str2 = this.nullableStringAdapter.fromJson(jsonReader);
                i10 &= -3;
            } else if (L == 2) {
                errorDetails = this.nullableErrorDetailsAdapter.fromJson(jsonReader);
                i10 &= -5;
            }
        }
        jsonReader.e();
        if (i10 == -8) {
            j.e(str, "null cannot be cast to non-null type kotlin.String");
            return new GenericFileUploadErrorResponse.DocumentErrorResponse.UnknownError(str, str2, errorDetails);
        }
        Constructor<GenericFileUploadErrorResponse.DocumentErrorResponse.UnknownError> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = GenericFileUploadErrorResponse.DocumentErrorResponse.UnknownError.class.getDeclaredConstructor(new Class[]{cls, cls, ErrorDetails.class, Integer.TYPE, c.f18958c});
            this.constructorRef = constructor;
            j.f(constructor, "GenericFileUploadErrorRe…his.constructorRef = it }");
        }
        GenericFileUploadErrorResponse.DocumentErrorResponse.UnknownError newInstance = constructor.newInstance(new Object[]{str, str2, errorDetails, Integer.valueOf(i10), null});
        j.f(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    public void toJson(q qVar, GenericFileUploadErrorResponse.DocumentErrorResponse.UnknownError unknownError) {
        j.g(qVar, "writer");
        if (unknownError != null) {
            qVar.c();
            qVar.u("title");
            this.stringAdapter.toJson(qVar, unknownError.getTitle());
            qVar.u("code");
            this.nullableStringAdapter.toJson(qVar, unknownError.getCode());
            qVar.u(ErrorBundle.DETAIL_ENTRY);
            this.nullableErrorDetailsAdapter.toJson(qVar, unknownError.getDetails());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
