package com.withpersona.sdk2.inquiry.steps.ui.network;

import bi.c;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.jivesoftware.smackx.xdata.FormField;

public final class UiComponent_InputDate_AttributesJsonAdapter extends h<UiComponent.InputDate.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28165a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28166b;

    /* renamed from: c  reason: collision with root package name */
    private final h<List<String>> f28167c;

    /* renamed from: d  reason: collision with root package name */
    private final h<JsonLogicBoolean> f28168d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Constructor<UiComponent.InputDate.Attributes> f28169e;

    public UiComponent_InputDate_AttributesJsonAdapter(s sVar) {
        Class<String> cls = String.class;
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a(FormField.ELEMENT, "prefill", "label", "placeholderMonth", "placeholderDay", "placeholderYear", "textMonths", "hidden", "disabled");
        j.f(a10, "of(\"field\", \"prefill\", \"…s\", \"hidden\", \"disabled\")");
        this.f28165a = a10;
        h<String> f10 = sVar.f(cls, n0.e(), FormField.ELEMENT);
        j.f(f10, "moshi.adapter(String::cl…     emptySet(), \"field\")");
        this.f28166b = f10;
        h<List<String>> f11 = sVar.f(w.j(List.class, cls), n0.e(), "textMonths");
        j.f(f11, "moshi.adapter(Types.newP…et(),\n      \"textMonths\")");
        this.f28167c = f11;
        h<JsonLogicBoolean> f12 = sVar.f(JsonLogicBoolean.class, n0.e(), "hidden");
        j.f(f12, "moshi.adapter(JsonLogicB…va, emptySet(), \"hidden\")");
        this.f28168d = f12;
    }

    /* renamed from: a */
    public UiComponent.InputDate.Attributes fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        Class<String> cls = String.class;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        int i10 = -1;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        List list = null;
        JsonLogicBoolean jsonLogicBoolean = null;
        JsonLogicBoolean jsonLogicBoolean2 = null;
        while (jsonReader.g()) {
            switch (jsonReader2.L(this.f28165a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    str = this.f28166b.fromJson(jsonReader2);
                    i10 &= -2;
                    break;
                case 1:
                    str2 = this.f28166b.fromJson(jsonReader2);
                    i10 &= -3;
                    break;
                case 2:
                    str3 = this.f28166b.fromJson(jsonReader2);
                    i10 &= -5;
                    break;
                case 3:
                    str4 = this.f28166b.fromJson(jsonReader2);
                    i10 &= -9;
                    break;
                case 4:
                    str5 = this.f28166b.fromJson(jsonReader2);
                    i10 &= -17;
                    break;
                case 5:
                    str6 = this.f28166b.fromJson(jsonReader2);
                    i10 &= -33;
                    break;
                case 6:
                    list = this.f28167c.fromJson(jsonReader2);
                    i10 &= -65;
                    break;
                case 7:
                    jsonLogicBoolean = this.f28168d.fromJson(jsonReader2);
                    i10 &= -129;
                    break;
                case 8:
                    jsonLogicBoolean2 = this.f28168d.fromJson(jsonReader2);
                    i10 &= -257;
                    break;
            }
        }
        jsonReader.e();
        if (i10 == -512) {
            return new UiComponent.InputDate.Attributes(str, str2, str3, str4, str5, str6, list, jsonLogicBoolean, jsonLogicBoolean2);
        }
        Constructor<UiComponent.InputDate.Attributes> constructor = this.f28169e;
        if (constructor == null) {
            constructor = UiComponent.InputDate.Attributes.class.getDeclaredConstructor(new Class[]{cls, cls, cls, cls, cls, cls, List.class, JsonLogicBoolean.class, JsonLogicBoolean.class, Integer.TYPE, c.f18958c});
            this.f28169e = constructor;
            j.f(constructor, "UiComponent.InputDate.At…his.constructorRef = it }");
        }
        UiComponent.InputDate.Attributes newInstance = constructor.newInstance(new Object[]{str, str2, str3, str4, str5, str6, list, jsonLogicBoolean, jsonLogicBoolean2, Integer.valueOf(i10), null});
        j.f(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.InputDate.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u(FormField.ELEMENT);
            this.f28166b.toJson(qVar, attributes.e());
            qVar.u("prefill");
            this.f28166b.toJson(qVar, attributes.j());
            qVar.u("label");
            this.f28166b.toJson(qVar, attributes.f());
            qVar.u("placeholderMonth");
            this.f28166b.toJson(qVar, attributes.h());
            qVar.u("placeholderDay");
            this.f28166b.toJson(qVar, attributes.g());
            qVar.u("placeholderYear");
            this.f28166b.toJson(qVar, attributes.i());
            qVar.u("textMonths");
            this.f28167c.toJson(qVar, attributes.k());
            qVar.u("hidden");
            this.f28168d.toJson(qVar, attributes.c());
            qVar.u("disabled");
            this.f28168d.toJson(qVar, attributes.d());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.InputDate.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
