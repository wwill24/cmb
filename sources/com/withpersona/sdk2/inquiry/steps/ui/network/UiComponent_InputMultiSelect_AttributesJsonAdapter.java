package com.withpersona.sdk2.inquiry.steps.ui.network;

import bi.c;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.xdata.FormField;

public final class UiComponent_InputMultiSelect_AttributesJsonAdapter extends h<UiComponent.InputMultiSelect.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28183a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28184b;

    /* renamed from: c  reason: collision with root package name */
    private final h<List<String>> f28185c;

    /* renamed from: d  reason: collision with root package name */
    private final h<List<UiComponent.InputMultiSelect.Option>> f28186d;

    /* renamed from: e  reason: collision with root package name */
    private final h<JsonLogicBoolean> f28187e;

    public UiComponent_InputMultiSelect_AttributesJsonAdapter(s sVar) {
        Class<String> cls = String.class;
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a(FormField.ELEMENT, "prefill", "label", "placeholder", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "hidden");
        j.f(a10, "of(\"field\", \"prefill\", \"…er\", \"options\", \"hidden\")");
        this.f28183a = a10;
        h<String> f10 = sVar.f(cls, n0.e(), FormField.ELEMENT);
        j.f(f10, "moshi.adapter(String::cl…     emptySet(), \"field\")");
        this.f28184b = f10;
        h<List<String>> f11 = sVar.f(w.j(List.class, cls), n0.e(), "prefill");
        j.f(f11, "moshi.adapter(Types.newP…tySet(),\n      \"prefill\")");
        this.f28185c = f11;
        h<List<UiComponent.InputMultiSelect.Option>> f12 = sVar.f(w.j(List.class, UiComponent.InputMultiSelect.Option.class), n0.e(), SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        j.f(f12, "moshi.adapter(Types.newP…), emptySet(), \"options\")");
        this.f28186d = f12;
        h<JsonLogicBoolean> f13 = sVar.f(JsonLogicBoolean.class, n0.e(), "hidden");
        j.f(f13, "moshi.adapter(JsonLogicB…va, emptySet(), \"hidden\")");
        this.f28187e = f13;
    }

    /* renamed from: a */
    public UiComponent.InputMultiSelect.Attributes fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        List list = null;
        String str2 = null;
        String str3 = null;
        List list2 = null;
        JsonLogicBoolean jsonLogicBoolean = null;
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f28183a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    str = this.f28184b.fromJson(jsonReader);
                    break;
                case 1:
                    list = this.f28185c.fromJson(jsonReader);
                    break;
                case 2:
                    str2 = this.f28184b.fromJson(jsonReader);
                    break;
                case 3:
                    str3 = this.f28184b.fromJson(jsonReader);
                    break;
                case 4:
                    list2 = this.f28186d.fromJson(jsonReader);
                    if (list2 != null) {
                        break;
                    } else {
                        JsonDataException x10 = c.x("options_", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, jsonReader);
                        j.f(x10, "unexpectedNull(\"options_\", \"options\", reader)");
                        throw x10;
                    }
                case 5:
                    jsonLogicBoolean = this.f28187e.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.e();
        if (list2 != null) {
            return new UiComponent.InputMultiSelect.Attributes(str, list, str2, str3, list2, jsonLogicBoolean);
        }
        JsonDataException o10 = c.o("options_", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, jsonReader);
        j.f(o10, "missingProperty(\"options_\", \"options\", reader)");
        throw o10;
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.InputMultiSelect.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u(FormField.ELEMENT);
            this.f28184b.toJson(qVar, attributes.f());
            qVar.u("prefill");
            this.f28185c.toJson(qVar, attributes.j());
            qVar.u("label");
            this.f28184b.toJson(qVar, attributes.g());
            qVar.u("placeholder");
            this.f28184b.toJson(qVar, attributes.i());
            qVar.u(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
            this.f28186d.toJson(qVar, attributes.h());
            qVar.u("hidden");
            this.f28187e.toJson(qVar, attributes.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(61);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.InputMultiSelect.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
