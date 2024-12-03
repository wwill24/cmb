package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.ui.network.Suggestion;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_InputAddress_AttributesJsonAdapter extends h<UiComponent.InputAddress.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28120a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28121b;

    /* renamed from: c  reason: collision with root package name */
    private final h<List<Suggestion>> f28122c;

    /* renamed from: d  reason: collision with root package name */
    private final h<Boolean> f28123d;

    /* renamed from: e  reason: collision with root package name */
    private final h<JsonLogicBoolean> f28124e;

    public UiComponent_InputAddress_AttributesJsonAdapter(s sVar) {
        s sVar2 = sVar;
        j.g(sVar2, "moshi");
        JsonReader.b a10 = JsonReader.b.a("label", "fieldKeyAddressStreet1", "prefillAddressStreet1", "placeholderAddressStreet1", "fieldKeyAddressStreet2", "prefillAddressStreet2", "placeholderAddressStreet2", "fieldKeyAddressCity", "prefillAddressCity", "placeholderAddressCity", "fieldKeyAddressSubdivision", "prefillAddressSubdivision", "placeholderAddressSubdivision", "placeholderAddressSubdivisionUs", "fieldKeyAddressPostalCode", "prefillAddressPostalCode", "placeholderAddressPostalCode", "placeholderAddressPostalCodeUs", "selectedCountryCode", "searchQuery", "searchResults", "selectedSearchResultId", "isAddressAutocompleteLoading", "hidden", "disabled");
        j.f(a10, "of(\"label\", \"fieldKeyAdd…    \"hidden\", \"disabled\")");
        this.f28120a = a10;
        h<String> f10 = sVar2.f(String.class, n0.e(), "label");
        j.f(f10, "moshi.adapter(String::cl…     emptySet(), \"label\")");
        this.f28121b = f10;
        h<List<Suggestion>> f11 = sVar2.f(w.j(List.class, Suggestion.class), n0.e(), "searchResults");
        j.f(f11, "moshi.adapter(Types.newP…tySet(), \"searchResults\")");
        this.f28122c = f11;
        h<Boolean> f12 = sVar2.f(Boolean.class, n0.e(), "isAddressAutocompleteLoading");
        j.f(f12, "moshi.adapter(Boolean::c…ressAutocompleteLoading\")");
        this.f28123d = f12;
        h<JsonLogicBoolean> f13 = sVar2.f(JsonLogicBoolean.class, n0.e(), "hidden");
        j.f(f13, "moshi.adapter(JsonLogicB…va, emptySet(), \"hidden\")");
        this.f28124e = f13;
    }

    /* renamed from: a */
    public UiComponent.InputAddress.Attributes fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        List list = null;
        String str21 = null;
        Boolean bool = null;
        JsonLogicBoolean jsonLogicBoolean = null;
        JsonLogicBoolean jsonLogicBoolean2 = null;
        while (jsonReader.g()) {
            switch (jsonReader2.L(this.f28120a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    str = this.f28121b.fromJson(jsonReader2);
                    break;
                case 1:
                    str2 = this.f28121b.fromJson(jsonReader2);
                    break;
                case 2:
                    str3 = this.f28121b.fromJson(jsonReader2);
                    break;
                case 3:
                    str4 = this.f28121b.fromJson(jsonReader2);
                    break;
                case 4:
                    str5 = this.f28121b.fromJson(jsonReader2);
                    break;
                case 5:
                    str6 = this.f28121b.fromJson(jsonReader2);
                    break;
                case 6:
                    str7 = this.f28121b.fromJson(jsonReader2);
                    break;
                case 7:
                    str8 = this.f28121b.fromJson(jsonReader2);
                    break;
                case 8:
                    str9 = this.f28121b.fromJson(jsonReader2);
                    break;
                case 9:
                    str10 = this.f28121b.fromJson(jsonReader2);
                    break;
                case 10:
                    str11 = this.f28121b.fromJson(jsonReader2);
                    break;
                case 11:
                    str12 = this.f28121b.fromJson(jsonReader2);
                    break;
                case 12:
                    str13 = this.f28121b.fromJson(jsonReader2);
                    break;
                case 13:
                    str14 = this.f28121b.fromJson(jsonReader2);
                    break;
                case 14:
                    str15 = this.f28121b.fromJson(jsonReader2);
                    break;
                case 15:
                    str16 = this.f28121b.fromJson(jsonReader2);
                    break;
                case 16:
                    str17 = this.f28121b.fromJson(jsonReader2);
                    break;
                case 17:
                    str18 = this.f28121b.fromJson(jsonReader2);
                    break;
                case 18:
                    str19 = this.f28121b.fromJson(jsonReader2);
                    break;
                case 19:
                    str20 = this.f28121b.fromJson(jsonReader2);
                    break;
                case 20:
                    list = this.f28122c.fromJson(jsonReader2);
                    break;
                case 21:
                    str21 = this.f28121b.fromJson(jsonReader2);
                    break;
                case 22:
                    bool = this.f28123d.fromJson(jsonReader2);
                    break;
                case 23:
                    jsonLogicBoolean = this.f28124e.fromJson(jsonReader2);
                    break;
                case 24:
                    jsonLogicBoolean2 = this.f28124e.fromJson(jsonReader2);
                    break;
            }
        }
        jsonReader.e();
        return new UiComponent.InputAddress.Attributes(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, list, str21, bool, jsonLogicBoolean, jsonLogicBoolean2);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.InputAddress.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u("label");
            this.f28121b.toJson(qVar, attributes.l());
            qVar.u("fieldKeyAddressStreet1");
            this.f28121b.toJson(qVar, attributes.i());
            qVar.u("prefillAddressStreet1");
            this.f28121b.toJson(qVar, attributes.w());
            qVar.u("placeholderAddressStreet1");
            this.f28121b.toJson(qVar, attributes.p());
            qVar.u("fieldKeyAddressStreet2");
            this.f28121b.toJson(qVar, attributes.j());
            qVar.u("prefillAddressStreet2");
            this.f28121b.toJson(qVar, attributes.x());
            qVar.u("placeholderAddressStreet2");
            this.f28121b.toJson(qVar, attributes.q());
            qVar.u("fieldKeyAddressCity");
            this.f28121b.toJson(qVar, attributes.g());
            qVar.u("prefillAddressCity");
            this.f28121b.toJson(qVar, attributes.t());
            qVar.u("placeholderAddressCity");
            this.f28121b.toJson(qVar, attributes.m());
            qVar.u("fieldKeyAddressSubdivision");
            this.f28121b.toJson(qVar, attributes.k());
            qVar.u("prefillAddressSubdivision");
            this.f28121b.toJson(qVar, attributes.z());
            qVar.u("placeholderAddressSubdivision");
            this.f28121b.toJson(qVar, attributes.r());
            qVar.u("placeholderAddressSubdivisionUs");
            this.f28121b.toJson(qVar, attributes.s());
            qVar.u("fieldKeyAddressPostalCode");
            this.f28121b.toJson(qVar, attributes.h());
            qVar.u("prefillAddressPostalCode");
            this.f28121b.toJson(qVar, attributes.u());
            qVar.u("placeholderAddressPostalCode");
            this.f28121b.toJson(qVar, attributes.n());
            qVar.u("placeholderAddressPostalCodeUs");
            this.f28121b.toJson(qVar, attributes.o());
            qVar.u("selectedCountryCode");
            this.f28121b.toJson(qVar, attributes.D());
            qVar.u("searchQuery");
            this.f28121b.toJson(qVar, attributes.A());
            qVar.u("searchResults");
            this.f28122c.toJson(qVar, attributes.B());
            qVar.u("selectedSearchResultId");
            this.f28121b.toJson(qVar, attributes.E());
            qVar.u("isAddressAutocompleteLoading");
            this.f28123d.toJson(qVar, attributes.F());
            qVar.u("hidden");
            this.f28124e.toJson(qVar, attributes.c());
            qVar.u("disabled");
            this.f28124e.toJson(qVar, attributes.d());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(57);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.InputAddress.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
