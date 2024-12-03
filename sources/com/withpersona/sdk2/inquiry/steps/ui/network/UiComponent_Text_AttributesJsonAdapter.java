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

public final class UiComponent_Text_AttributesJsonAdapter extends h<UiComponent.Text.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28331a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28332b;

    /* renamed from: c  reason: collision with root package name */
    private final h<JsonLogicBoolean> f28333c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Constructor<UiComponent.Text.Attributes> f28334d;

    public UiComponent_Text_AttributesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("text", "hidden", "disabled");
        j.f(a10, "of(\"text\", \"hidden\", \"disabled\")");
        this.f28331a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "text");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"text\")");
        this.f28332b = f10;
        h<JsonLogicBoolean> f11 = sVar.f(JsonLogicBoolean.class, n0.e(), "hidden");
        j.f(f11, "moshi.adapter(JsonLogicB…va, emptySet(), \"hidden\")");
        this.f28333c = f11;
    }

    /* renamed from: a */
    public UiComponent.Text.Attributes fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        int i10 = -1;
        String str = null;
        JsonLogicBoolean jsonLogicBoolean = null;
        JsonLogicBoolean jsonLogicBoolean2 = null;
        while (jsonReader.g()) {
            int L = jsonReader2.L(this.f28331a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f28332b.fromJson(jsonReader2);
                if (str == null) {
                    JsonDataException x10 = c.x("text", "text", jsonReader2);
                    j.f(x10, "unexpectedNull(\"text\", \"text\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                jsonLogicBoolean = this.f28333c.fromJson(jsonReader2);
                i10 &= -3;
            } else if (L == 2) {
                jsonLogicBoolean2 = this.f28333c.fromJson(jsonReader2);
                i10 &= -5;
            }
        }
        jsonReader.e();
        if (i10 != -7) {
            Constructor<UiComponent.Text.Attributes> constructor = this.f28334d;
            if (constructor == null) {
                constructor = UiComponent.Text.Attributes.class.getDeclaredConstructor(new Class[]{String.class, JsonLogicBoolean.class, JsonLogicBoolean.class, Integer.TYPE, c.f18958c});
                this.f28334d = constructor;
                j.f(constructor, "UiComponent.Text.Attribu…his.constructorRef = it }");
            }
            Object[] objArr = new Object[5];
            if (str != null) {
                objArr[0] = str;
                objArr[1] = jsonLogicBoolean;
                objArr[2] = jsonLogicBoolean2;
                objArr[3] = Integer.valueOf(i10);
                objArr[4] = null;
                UiComponent.Text.Attributes newInstance = constructor.newInstance(objArr);
                j.f(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                return newInstance;
            }
            JsonDataException o10 = c.o("text", "text", jsonReader2);
            j.f(o10, "missingProperty(\"text\", \"text\", reader)");
            throw o10;
        } else if (str != null) {
            return new UiComponent.Text.Attributes(str, jsonLogicBoolean, jsonLogicBoolean2);
        } else {
            JsonDataException o11 = c.o("text", "text", jsonReader2);
            j.f(o11, "missingProperty(\"text\", \"text\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.Text.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u("text");
            this.f28332b.toJson(qVar, attributes.e());
            qVar.u("hidden");
            this.f28333c.toJson(qVar, attributes.c());
            qVar.u("disabled");
            this.f28333c.toJson(qVar, attributes.d());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(49);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.Text.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
