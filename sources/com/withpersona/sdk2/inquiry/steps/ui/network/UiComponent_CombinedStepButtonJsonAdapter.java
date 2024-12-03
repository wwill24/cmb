package com.withpersona.sdk2.inquiry.steps.ui.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.ButtonCombinedStepComponentStyle;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_CombinedStepButtonJsonAdapter extends h<UiComponent.CombinedStepButton> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28041a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28042b;

    /* renamed from: c  reason: collision with root package name */
    private final h<UiComponent.Button.Attributes> f28043c;

    /* renamed from: d  reason: collision with root package name */
    private final h<ButtonCombinedStepComponentStyle> f28044d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Constructor<UiComponent.CombinedStepButton> f28045e;

    public UiComponent_CombinedStepButtonJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("name", "attributes", "styles");
        j.f(a10, "of(\"name\", \"attributes\", \"styles\")");
        this.f28041a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "name");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"name\")");
        this.f28042b = f10;
        h<UiComponent.Button.Attributes> f11 = sVar.f(UiComponent.Button.Attributes.class, n0.e(), "attributes");
        j.f(f11, "moshi.adapter(UiComponen…emptySet(), \"attributes\")");
        this.f28043c = f11;
        h<ButtonCombinedStepComponentStyle> f12 = sVar.f(ButtonCombinedStepComponentStyle.class, n0.e(), "styles");
        j.f(f12, "moshi.adapter(ButtonComb…va, emptySet(), \"styles\")");
        this.f28044d = f12;
    }

    /* renamed from: a */
    public UiComponent.CombinedStepButton fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        int i10 = -1;
        String str = null;
        UiComponent.Button.Attributes attributes = null;
        ButtonCombinedStepComponentStyle buttonCombinedStepComponentStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader2.L(this.f28041a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f28042b.fromJson(jsonReader2);
                if (str == null) {
                    JsonDataException x10 = c.x("name", "name", jsonReader2);
                    j.f(x10, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                attributes = this.f28043c.fromJson(jsonReader2);
            } else if (L == 2) {
                buttonCombinedStepComponentStyle = this.f28044d.fromJson(jsonReader2);
                i10 &= -5;
            }
        }
        jsonReader.e();
        if (i10 != -5) {
            Constructor<UiComponent.CombinedStepButton> constructor = this.f28045e;
            if (constructor == null) {
                constructor = UiComponent.CombinedStepButton.class.getDeclaredConstructor(new Class[]{String.class, UiComponent.Button.Attributes.class, ButtonCombinedStepComponentStyle.class, Integer.TYPE, c.f18958c});
                this.f28045e = constructor;
                j.f(constructor, "UiComponent.CombinedStep…his.constructorRef = it }");
            }
            Object[] objArr = new Object[5];
            if (str != null) {
                objArr[0] = str;
                objArr[1] = attributes;
                objArr[2] = buttonCombinedStepComponentStyle;
                objArr[3] = Integer.valueOf(i10);
                objArr[4] = null;
                UiComponent.CombinedStepButton newInstance = constructor.newInstance(objArr);
                j.f(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                return newInstance;
            }
            JsonDataException o10 = c.o("name", "name", jsonReader2);
            j.f(o10, "missingProperty(\"name\", \"name\", reader)");
            throw o10;
        } else if (str != null) {
            return new UiComponent.CombinedStepButton(str, attributes, buttonCombinedStepComponentStyle);
        } else {
            JsonDataException o11 = c.o("name", "name", jsonReader2);
            j.f(o11, "missingProperty(\"name\", \"name\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.CombinedStepButton combinedStepButton) {
        j.g(qVar, "writer");
        if (combinedStepButton != null) {
            qVar.c();
            qVar.u("name");
            this.f28042b.toJson(qVar, combinedStepButton.A());
            qVar.u("attributes");
            this.f28043c.toJson(qVar, combinedStepButton.z());
            qVar.u("styles");
            this.f28044d.toJson(qVar, combinedStepButton.D());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(52);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.CombinedStepButton");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
