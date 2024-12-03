package com.withpersona.sdk2.inquiry.internal.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.internal.InquiryField;
import com.withpersona.sdk2.inquiry.internal.network.CheckInquiryResponse;
import java.util.Map;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class CheckInquiryResponse_AttributesJsonAdapter extends h<CheckInquiryResponse.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26414a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26415b;

    /* renamed from: c  reason: collision with root package name */
    private final h<NextStep> f26416c;

    /* renamed from: d  reason: collision with root package name */
    private final h<Map<String, InquiryField>> f26417d;

    /* renamed from: e  reason: collision with root package name */
    private final h<Boolean> f26418e;

    public CheckInquiryResponse_AttributesJsonAdapter(s sVar) {
        Class<String> cls = String.class;
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("selectedCountryCode", "status", "nextStep", "fields", "waitForTransition", "environment");
        j.f(a10, "of(\"selectedCountryCode\"…ansition\", \"environment\")");
        this.f26414a = a10;
        h<String> f10 = sVar.f(cls, n0.e(), "selectedCountryCode");
        j.f(f10, "moshi.adapter(String::cl…), \"selectedCountryCode\")");
        this.f26415b = f10;
        h<NextStep> f11 = sVar.f(NextStep.class, n0.e(), "nextStep");
        j.f(f11, "moshi.adapter(NextStep::…  emptySet(), \"nextStep\")");
        this.f26416c = f11;
        h<Map<String, InquiryField>> f12 = sVar.f(w.j(Map.class, cls, InquiryField.class), n0.e(), "fields");
        j.f(f12, "moshi.adapter(Types.newP…a), emptySet(), \"fields\")");
        this.f26417d = f12;
        h<Boolean> f13 = sVar.f(Boolean.TYPE, n0.e(), "waitForTransition");
        j.f(f13, "moshi.adapter(Boolean::c…     \"waitForTransition\")");
        this.f26418e = f13;
    }

    /* renamed from: a */
    public CheckInquiryResponse.Attributes fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        Boolean bool = null;
        String str = null;
        String str2 = null;
        NextStep nextStep = null;
        Map map = null;
        String str3 = null;
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f26414a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    str = this.f26415b.fromJson(jsonReader);
                    break;
                case 1:
                    str2 = this.f26415b.fromJson(jsonReader);
                    break;
                case 2:
                    nextStep = this.f26416c.fromJson(jsonReader);
                    if (nextStep != null) {
                        break;
                    } else {
                        JsonDataException x10 = c.x("nextStep", "nextStep", jsonReader);
                        j.f(x10, "unexpectedNull(\"nextStep…      \"nextStep\", reader)");
                        throw x10;
                    }
                case 3:
                    map = this.f26417d.fromJson(jsonReader);
                    break;
                case 4:
                    bool = this.f26418e.fromJson(jsonReader);
                    if (bool != null) {
                        break;
                    } else {
                        JsonDataException x11 = c.x("waitForTransition", "waitForTransition", jsonReader);
                        j.f(x11, "unexpectedNull(\"waitForT…itForTransition\", reader)");
                        throw x11;
                    }
                case 5:
                    str3 = this.f26415b.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.e();
        if (nextStep == null) {
            JsonDataException o10 = c.o("nextStep", "nextStep", jsonReader);
            j.f(o10, "missingProperty(\"nextStep\", \"nextStep\", reader)");
            throw o10;
        } else if (bool != null) {
            return new CheckInquiryResponse.Attributes(str, str2, nextStep, map, bool.booleanValue(), str3);
        } else {
            JsonDataException o11 = c.o("waitForTransition", "waitForTransition", jsonReader);
            j.f(o11, "missingProperty(\"waitFor…itForTransition\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, CheckInquiryResponse.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u("selectedCountryCode");
            this.f26415b.toJson(qVar, attributes.d());
            qVar.u("status");
            this.f26415b.toJson(qVar, attributes.e());
            qVar.u("nextStep");
            this.f26416c.toJson(qVar, attributes.c());
            qVar.u("fields");
            this.f26417d.toJson(qVar, attributes.b());
            qVar.u("waitForTransition");
            this.f26418e.toJson(qVar, Boolean.valueOf(attributes.f()));
            qVar.u("environment");
            this.f26415b.toJson(qVar, attributes.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(53);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CheckInquiryResponse.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
