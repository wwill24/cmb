package com.withpersona.sdk2.inquiry.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class InternalErrorInfo_PermissionErrorInfoJsonAdapter extends h<InternalErrorInfo.PermissionErrorInfo> {
    private final JsonReader.b options;
    private final h<String> stringAdapter;

    public InternalErrorInfo_PermissionErrorInfoJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("message");
        j.f(a10, "of(\"message\")");
        this.options = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "message");
        j.f(f10, "moshi.adapter(String::cl…tySet(),\n      \"message\")");
        this.stringAdapter = f10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(59);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("InternalErrorInfo.PermissionErrorInfo");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    public InternalErrorInfo.PermissionErrorInfo fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.options);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (str = this.stringAdapter.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x("message", "message", jsonReader);
                j.f(x10, "unexpectedNull(\"message\"…       \"message\", reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (str != null) {
            return new InternalErrorInfo.PermissionErrorInfo(str);
        }
        JsonDataException o10 = c.o("message", "message", jsonReader);
        j.f(o10, "missingProperty(\"message\", \"message\", reader)");
        throw o10;
    }

    public void toJson(q qVar, InternalErrorInfo.PermissionErrorInfo permissionErrorInfo) {
        j.g(qVar, "writer");
        if (permissionErrorInfo != null) {
            qVar.c();
            qVar.u("message");
            this.stringAdapter.toJson(qVar, permissionErrorInfo.getMessage());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
