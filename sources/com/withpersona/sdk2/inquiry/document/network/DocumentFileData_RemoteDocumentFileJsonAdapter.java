package com.withpersona.sdk2.inquiry.document.network;

import bi.c;
import com.leanplum.internal.Constants;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.document.network.DocumentFileData;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class DocumentFileData_RemoteDocumentFileJsonAdapter extends h<DocumentFileData.RemoteDocumentFile> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f25208a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f25209b;

    public DocumentFileData_RemoteDocumentFileJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("url", Constants.Keys.FILENAME);
        j.f(a10, "of(\"url\", \"filename\")");
        this.f25208a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "url");
        j.f(f10, "moshi.adapter(String::cl… emptySet(),\n      \"url\")");
        this.f25209b = f10;
    }

    /* renamed from: a */
    public DocumentFileData.RemoteDocumentFile fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f25208a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f25209b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("url", "url", jsonReader);
                    j.f(x10, "unexpectedNull(\"url\", \"url\", reader)");
                    throw x10;
                }
            } else if (L == 1 && (str2 = this.f25209b.fromJson(jsonReader)) == null) {
                JsonDataException x11 = c.x(Constants.Keys.FILENAME, Constants.Keys.FILENAME, jsonReader);
                j.f(x11, "unexpectedNull(\"filename…      \"filename\", reader)");
                throw x11;
            }
        }
        jsonReader.e();
        if (str == null) {
            JsonDataException o10 = c.o("url", "url", jsonReader);
            j.f(o10, "missingProperty(\"url\", \"url\", reader)");
            throw o10;
        } else if (str2 != null) {
            return new DocumentFileData.RemoteDocumentFile(str, str2);
        } else {
            JsonDataException o11 = c.o(Constants.Keys.FILENAME, Constants.Keys.FILENAME, jsonReader);
            j.f(o11, "missingProperty(\"filename\", \"filename\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, DocumentFileData.RemoteDocumentFile remoteDocumentFile) {
        j.g(qVar, "writer");
        if (remoteDocumentFile != null) {
            qVar.c();
            qVar.u("url");
            this.f25209b.toJson(qVar, remoteDocumentFile.b());
            qVar.u(Constants.Keys.FILENAME);
            this.f25209b.toJson(qVar, remoteDocumentFile.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(57);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("DocumentFileData.RemoteDocumentFile");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
