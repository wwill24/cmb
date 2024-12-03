package com.withpersona.sdk2.inquiry.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.network.GenericFileUploadErrorResponse;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class GenericFileUploadErrorResponse_DocumentErrorResponse_GovernmentIdDimensionSizeError_DetailsJsonAdapter extends h<GenericFileUploadErrorResponse.DocumentErrorResponse.GovernmentIdDimensionSizeError.Details> {
    private final h<Integer> intAdapter;
    private final JsonReader.b options;

    public GenericFileUploadErrorResponse_DocumentErrorResponse_GovernmentIdDimensionSizeError_DetailsJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("min_dimension_size", "max_dimension_size");
        j.f(a10, "of(\"min_dimension_size\",…    \"max_dimension_size\")");
        this.options = a10;
        h<Integer> f10 = sVar.f(Integer.TYPE, n0.e(), "minDimensionSize");
        j.f(f10, "moshi.adapter(Int::class…      \"minDimensionSize\")");
        this.intAdapter = f10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(113);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("GenericFileUploadErrorResponse.DocumentErrorResponse.GovernmentIdDimensionSizeError.Details");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    public GenericFileUploadErrorResponse.DocumentErrorResponse.GovernmentIdDimensionSizeError.Details fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        Integer num = null;
        Integer num2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.options);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                num = this.intAdapter.fromJson(jsonReader);
                if (num == null) {
                    JsonDataException x10 = c.x("minDimensionSize", "min_dimension_size", jsonReader);
                    j.f(x10, "unexpectedNull(\"minDimen…_dimension_size\", reader)");
                    throw x10;
                }
            } else if (L == 1 && (num2 = this.intAdapter.fromJson(jsonReader)) == null) {
                JsonDataException x11 = c.x("maxDimensionSize", "max_dimension_size", jsonReader);
                j.f(x11, "unexpectedNull(\"maxDimen…_dimension_size\", reader)");
                throw x11;
            }
        }
        jsonReader.e();
        if (num != null) {
            int intValue = num.intValue();
            if (num2 != null) {
                return new GenericFileUploadErrorResponse.DocumentErrorResponse.GovernmentIdDimensionSizeError.Details(intValue, num2.intValue());
            }
            JsonDataException o10 = c.o("maxDimensionSize", "max_dimension_size", jsonReader);
            j.f(o10, "missingProperty(\"maxDime…_dimension_size\", reader)");
            throw o10;
        }
        JsonDataException o11 = c.o("minDimensionSize", "min_dimension_size", jsonReader);
        j.f(o11, "missingProperty(\"minDime…_dimension_size\", reader)");
        throw o11;
    }

    public void toJson(q qVar, GenericFileUploadErrorResponse.DocumentErrorResponse.GovernmentIdDimensionSizeError.Details details) {
        j.g(qVar, "writer");
        if (details != null) {
            qVar.c();
            qVar.u("min_dimension_size");
            this.intAdapter.toJson(qVar, Integer.valueOf(details.getMinDimensionSize()));
            qVar.u("max_dimension_size");
            this.intAdapter.toJson(qVar, Integer.valueOf(details.getMaxDimensionSize()));
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
