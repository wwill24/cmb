package com.withpersona.sdk2.inquiry.network;

import bi.c;
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

public final class GenericFileUploadErrorResponse_DocumentErrorResponse_DisabledFileTypeError_DetailsJsonAdapter extends h<GenericFileUploadErrorResponse.DocumentErrorResponse.DisabledFileTypeError.Details> {
    private final h<List<String>> listOfStringAdapter;
    private final JsonReader.b options;
    private final h<String> stringAdapter;

    public GenericFileUploadErrorResponse_DocumentErrorResponse_DisabledFileTypeError_DetailsJsonAdapter(s sVar) {
        Class<String> cls = String.class;
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("uploaded_file_type", "enabled_file_types");
        j.f(a10, "of(\"uploaded_file_type\",…    \"enabled_file_types\")");
        this.options = a10;
        h<String> f10 = sVar.f(cls, n0.e(), "uploadedFileType");
        j.f(f10, "moshi.adapter(String::cl…      \"uploadedFileType\")");
        this.stringAdapter = f10;
        h<List<String>> f11 = sVar.f(w.j(List.class, cls), n0.e(), "enabledFileTypes");
        j.f(f11, "moshi.adapter(Types.newP…      \"enabledFileTypes\")");
        this.listOfStringAdapter = f11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(104);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("GenericFileUploadErrorResponse.DocumentErrorResponse.DisabledFileTypeError.Details");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    public GenericFileUploadErrorResponse.DocumentErrorResponse.DisabledFileTypeError.Details fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        List list = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.options);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.stringAdapter.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("uploadedFileType", "uploaded_file_type", jsonReader);
                    j.f(x10, "unexpectedNull(\"uploaded…oaded_file_type\", reader)");
                    throw x10;
                }
            } else if (L == 1 && (list = this.listOfStringAdapter.fromJson(jsonReader)) == null) {
                JsonDataException x11 = c.x("enabledFileTypes", "enabled_file_types", jsonReader);
                j.f(x11, "unexpectedNull(\"enabledF…bled_file_types\", reader)");
                throw x11;
            }
        }
        jsonReader.e();
        if (str == null) {
            JsonDataException o10 = c.o("uploadedFileType", "uploaded_file_type", jsonReader);
            j.f(o10, "missingProperty(\"uploade…oaded_file_type\", reader)");
            throw o10;
        } else if (list != null) {
            return new GenericFileUploadErrorResponse.DocumentErrorResponse.DisabledFileTypeError.Details(str, list);
        } else {
            JsonDataException o11 = c.o("enabledFileTypes", "enabled_file_types", jsonReader);
            j.f(o11, "missingProperty(\"enabled…bled_file_types\", reader)");
            throw o11;
        }
    }

    public void toJson(q qVar, GenericFileUploadErrorResponse.DocumentErrorResponse.DisabledFileTypeError.Details details) {
        j.g(qVar, "writer");
        if (details != null) {
            qVar.c();
            qVar.u("uploaded_file_type");
            this.stringAdapter.toJson(qVar, details.getUploadedFileType());
            qVar.u("enabled_file_types");
            this.listOfStringAdapter.toJson(qVar, details.getEnabledFileTypes());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
