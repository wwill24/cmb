package com.withpersona.sdk2.inquiry.ui.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.ui.network.AddressAutocompleteRequest;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AddressAutocompleteRequestJsonAdapter extends h<AddressAutocompleteRequest> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29406a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AddressAutocompleteRequest.Meta> f29407b;

    public AddressAutocompleteRequestJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("meta");
        j.f(a10, "of(\"meta\")");
        this.f29406a = a10;
        h<AddressAutocompleteRequest.Meta> f10 = sVar.f(AddressAutocompleteRequest.Meta.class, n0.e(), "meta");
        j.f(f10, "moshi.adapter(AddressAut…java, emptySet(), \"meta\")");
        this.f29407b = f10;
    }

    /* renamed from: a */
    public AddressAutocompleteRequest fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        AddressAutocompleteRequest.Meta meta = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29406a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0 && (meta = this.f29407b.fromJson(jsonReader)) == null) {
                JsonDataException x10 = c.x("meta", "meta", jsonReader);
                j.f(x10, "unexpectedNull(\"meta\", \"meta\",\n            reader)");
                throw x10;
            }
        }
        jsonReader.e();
        if (meta != null) {
            return new AddressAutocompleteRequest(meta);
        }
        JsonDataException o10 = c.o("meta", "meta", jsonReader);
        j.f(o10, "missingProperty(\"meta\", \"meta\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, AddressAutocompleteRequest addressAutocompleteRequest) {
        j.g(qVar, "writer");
        if (addressAutocompleteRequest != null) {
            qVar.c();
            qVar.u("meta");
            this.f29407b.toJson(qVar, addressAutocompleteRequest.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(48);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AddressAutocompleteRequest");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
