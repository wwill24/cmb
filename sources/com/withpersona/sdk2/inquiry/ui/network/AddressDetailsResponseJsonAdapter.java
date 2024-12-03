package com.withpersona.sdk2.inquiry.ui.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AddressDetailsResponseJsonAdapter extends h<AddressDetailsResponse> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29414a;

    /* renamed from: b  reason: collision with root package name */
    private final h<LocationData> f29415b;

    public AddressDetailsResponseJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("attributes");
        j.f(a10, "of(\"attributes\")");
        this.f29414a = a10;
        h<LocationData> f10 = sVar.f(LocationData.class, n0.e(), "attributes");
        j.f(f10, "moshi.adapter(LocationDa…emptySet(), \"attributes\")");
        this.f29415b = f10;
    }

    /* renamed from: a */
    public AddressDetailsResponse fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        LocationData locationData = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29414a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (locationData = this.f29415b.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x("attributes", "attributes", jsonReader);
                j.f(x10, "unexpectedNull(\"attributes\", \"attributes\", reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (locationData != null) {
            return new AddressDetailsResponse(locationData);
        }
        JsonDataException o10 = c.o("attributes", "attributes", jsonReader);
        j.f(o10, "missingProperty(\"attribu…s\", \"attributes\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, AddressDetailsResponse addressDetailsResponse) {
        j.g(qVar, "writer");
        if (addressDetailsResponse != null) {
            qVar.c();
            qVar.u("attributes");
            this.f29415b.toJson(qVar, addressDetailsResponse.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(44);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AddressDetailsResponse");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
