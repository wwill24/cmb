package com.withpersona.sdk2.inquiry.internal.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.NextStep;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.xdata.FormField;

public final class NextStep_GovernmentId_NfcPassportJsonAdapter extends h<NextStep.GovernmentId.NfcPassport> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26791a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26792b;

    /* renamed from: c  reason: collision with root package name */
    private final h<Boolean> f26793c;

    /* renamed from: d  reason: collision with root package name */
    private final h<NextStep.GovernmentId.PassportNfcOption> f26794d;

    public NextStep_GovernmentId_NfcPassportJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("fieldKeyNfcPassport", "skipMrzScanScreen", FormField.Required.ELEMENT);
        j.f(a10, "of(\"fieldKeyNfcPassport\"…zScanScreen\", \"required\")");
        this.f26791a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "fieldKeyNfcPassport");
        j.f(f10, "moshi.adapter(String::cl…), \"fieldKeyNfcPassport\")");
        this.f26792b = f10;
        h<Boolean> f11 = sVar.f(Boolean.class, n0.e(), "skipMrzScanScreen");
        j.f(f11, "moshi.adapter(Boolean::c…t(), \"skipMrzScanScreen\")");
        this.f26793c = f11;
        h<NextStep.GovernmentId.PassportNfcOption> f12 = sVar.f(NextStep.GovernmentId.PassportNfcOption.class, n0.e(), FormField.Required.ELEMENT);
        j.f(f12, "moshi.adapter(NextStep.G…, emptySet(), \"required\")");
        this.f26794d = f12;
    }

    /* renamed from: a */
    public NextStep.GovernmentId.NfcPassport fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        Boolean bool = null;
        NextStep.GovernmentId.PassportNfcOption passportNfcOption = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26791a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f26792b.fromJson(jsonReader);
            } else if (L == 1) {
                bool = this.f26793c.fromJson(jsonReader);
            } else if (L == 2) {
                passportNfcOption = this.f26794d.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new NextStep.GovernmentId.NfcPassport(str, bool, passportNfcOption);
    }

    /* renamed from: b */
    public void toJson(q qVar, NextStep.GovernmentId.NfcPassport nfcPassport) {
        j.g(qVar, "writer");
        if (nfcPassport != null) {
            qVar.c();
            qVar.u("fieldKeyNfcPassport");
            this.f26792b.toJson(qVar, nfcPassport.a());
            qVar.u("skipMrzScanScreen");
            this.f26793c.toJson(qVar, nfcPassport.c());
            qVar.u(FormField.Required.ELEMENT);
            this.f26794d.toJson(qVar, nfcPassport.b());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("NextStep.GovernmentId.NfcPassport");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
