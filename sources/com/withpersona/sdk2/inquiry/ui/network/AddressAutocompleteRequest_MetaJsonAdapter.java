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

public final class AddressAutocompleteRequest_MetaJsonAdapter extends h<AddressAutocompleteRequest.Meta> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29408a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f29409b;

    public AddressAutocompleteRequest_MetaJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("fromComponent", "searchInput");
        j.f(a10, "of(\"fromComponent\", \"searchInput\")");
        this.f29408a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "fromComponent");
        j.f(f10, "moshi.adapter(String::cl…),\n      \"fromComponent\")");
        this.f29409b = f10;
    }

    /* renamed from: a */
    public AddressAutocompleteRequest.Meta fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29408a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f29409b.fromJson(jsonReader);
                if (str == null) {
                    JsonDataException x10 = c.x("fromComponent", "fromComponent", jsonReader);
                    j.f(x10, "unexpectedNull(\"fromComp… \"fromComponent\", reader)");
                    throw x10;
                }
            } else if (L == 1 && (str2 = this.f29409b.fromJson(jsonReader)) == null) {
                JsonDataException x11 = c.x("searchInput", "searchInput", jsonReader);
                j.f(x11, "unexpectedNull(\"searchIn…\", \"searchInput\", reader)");
                throw x11;
            }
        }
        jsonReader.e();
        if (str == null) {
            JsonDataException o10 = c.o("fromComponent", "fromComponent", jsonReader);
            j.f(o10, "missingProperty(\"fromCom… \"fromComponent\", reader)");
            throw o10;
        } else if (str2 != null) {
            return new AddressAutocompleteRequest.Meta(str, str2);
        } else {
            JsonDataException o11 = c.o("searchInput", "searchInput", jsonReader);
            j.f(o11, "missingProperty(\"searchI…put\",\n            reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, AddressAutocompleteRequest.Meta meta) {
        j.g(qVar, "writer");
        if (meta != null) {
            qVar.c();
            qVar.u("fromComponent");
            this.f29409b.toJson(qVar, meta.a());
            qVar.u("searchInput");
            this.f29409b.toJson(qVar, meta.b());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(53);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("AddressAutocompleteRequest.Meta");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
