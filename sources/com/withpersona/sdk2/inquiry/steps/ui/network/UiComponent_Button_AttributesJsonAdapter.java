package com.withpersona.sdk2.inquiry.steps.ui.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_Button_AttributesJsonAdapter extends h<UiComponent.Button.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28014a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28015b;

    /* renamed from: c  reason: collision with root package name */
    private final h<UiComponent.Button.ButtonType> f28016c;

    /* renamed from: d  reason: collision with root package name */
    private final h<JsonLogicBoolean> f28017d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Constructor<UiComponent.Button.Attributes> f28018e;

    public UiComponent_Button_AttributesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("text", "buttonType", "hidden", "disabled");
        j.f(a10, "of(\"text\", \"buttonType\",…idden\",\n      \"disabled\")");
        this.f28014a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "text");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"text\")");
        this.f28015b = f10;
        h<UiComponent.Button.ButtonType> f11 = sVar.f(UiComponent.Button.ButtonType.class, n0.e(), "buttonType");
        j.f(f11, "moshi.adapter(UiComponen…emptySet(), \"buttonType\")");
        this.f28016c = f11;
        h<JsonLogicBoolean> f12 = sVar.f(JsonLogicBoolean.class, n0.e(), "hidden");
        j.f(f12, "moshi.adapter(JsonLogicB…va, emptySet(), \"hidden\")");
        this.f28017d = f12;
    }

    /* renamed from: a */
    public UiComponent.Button.Attributes fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        int i10 = -1;
        String str = null;
        UiComponent.Button.ButtonType buttonType = null;
        JsonLogicBoolean jsonLogicBoolean = null;
        JsonLogicBoolean jsonLogicBoolean2 = null;
        while (jsonReader.g()) {
            int L = jsonReader2.L(this.f28014a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f28015b.fromJson(jsonReader2);
                if (str == null) {
                    JsonDataException x10 = c.x("text", "text", jsonReader2);
                    j.f(x10, "unexpectedNull(\"text\", \"text\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                buttonType = this.f28016c.fromJson(jsonReader2);
            } else if (L == 2) {
                jsonLogicBoolean = this.f28017d.fromJson(jsonReader2);
                i10 &= -5;
            } else if (L == 3) {
                jsonLogicBoolean2 = this.f28017d.fromJson(jsonReader2);
                i10 &= -9;
            }
        }
        jsonReader.e();
        if (i10 != -13) {
            Constructor<UiComponent.Button.Attributes> constructor = this.f28018e;
            if (constructor == null) {
                constructor = UiComponent.Button.Attributes.class.getDeclaredConstructor(new Class[]{String.class, UiComponent.Button.ButtonType.class, JsonLogicBoolean.class, JsonLogicBoolean.class, Integer.TYPE, c.f18958c});
                this.f28018e = constructor;
                j.f(constructor, "UiComponent.Button.Attri…his.constructorRef = it }");
            }
            Object[] objArr = new Object[6];
            if (str != null) {
                objArr[0] = str;
                objArr[1] = buttonType;
                objArr[2] = jsonLogicBoolean;
                objArr[3] = jsonLogicBoolean2;
                objArr[4] = Integer.valueOf(i10);
                objArr[5] = null;
                UiComponent.Button.Attributes newInstance = constructor.newInstance(objArr);
                j.f(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                return newInstance;
            }
            JsonDataException o10 = c.o("text", "text", jsonReader2);
            j.f(o10, "missingProperty(\"text\", \"text\", reader)");
            throw o10;
        } else if (str != null) {
            return new UiComponent.Button.Attributes(str, buttonType, jsonLogicBoolean, jsonLogicBoolean2);
        } else {
            JsonDataException o11 = c.o("text", "text", jsonReader2);
            j.f(o11, "missingProperty(\"text\", \"text\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.Button.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u("text");
            this.f28015b.toJson(qVar, attributes.f());
            qVar.u("buttonType");
            this.f28016c.toJson(qVar, attributes.e());
            qVar.u("hidden");
            this.f28017d.toJson(qVar, attributes.c());
            qVar.u("disabled");
            this.f28017d.toJson(qVar, attributes.d());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(51);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.Button.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
