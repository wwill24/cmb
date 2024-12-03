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

public final class UiComponent_CombinedStepImagePreviewJsonAdapter extends h<UiComponent.CombinedStepImagePreview> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28046a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28047b;

    /* renamed from: c  reason: collision with root package name */
    private final h<UiComponent.CombinedStepImagePreview.Attributes> f28048c;

    /* renamed from: d  reason: collision with root package name */
    private final h<UiComponent.CombinedStepImagePreview.CombinedStepImagePreviewComponentStyle> f28049d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Constructor<UiComponent.CombinedStepImagePreview> f28050e;

    public UiComponent_CombinedStepImagePreviewJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("name", "attributes", "styles");
        j.f(a10, "of(\"name\", \"attributes\", \"styles\")");
        this.f28046a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "name");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"name\")");
        this.f28047b = f10;
        h<UiComponent.CombinedStepImagePreview.Attributes> f11 = sVar.f(UiComponent.CombinedStepImagePreview.Attributes.class, n0.e(), "attributes");
        j.f(f11, "moshi.adapter(UiComponen…et(),\n      \"attributes\")");
        this.f28048c = f11;
        h<UiComponent.CombinedStepImagePreview.CombinedStepImagePreviewComponentStyle> f12 = sVar.f(UiComponent.CombinedStepImagePreview.CombinedStepImagePreviewComponentStyle.class, n0.e(), "styles");
        j.f(f12, "moshi.adapter(UiComponen…    emptySet(), \"styles\")");
        this.f28049d = f12;
    }

    /* renamed from: a */
    public UiComponent.CombinedStepImagePreview fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        int i10 = -1;
        String str = null;
        UiComponent.CombinedStepImagePreview.Attributes attributes = null;
        UiComponent.CombinedStepImagePreview.CombinedStepImagePreviewComponentStyle combinedStepImagePreviewComponentStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader2.L(this.f28046a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f28047b.fromJson(jsonReader2);
                if (str == null) {
                    JsonDataException x10 = c.x("name", "name", jsonReader2);
                    j.f(x10, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                attributes = this.f28048c.fromJson(jsonReader2);
            } else if (L == 2) {
                combinedStepImagePreviewComponentStyle = this.f28049d.fromJson(jsonReader2);
                i10 &= -5;
            }
        }
        jsonReader.e();
        if (i10 != -5) {
            Constructor<UiComponent.CombinedStepImagePreview> constructor = this.f28050e;
            if (constructor == null) {
                constructor = UiComponent.CombinedStepImagePreview.class.getDeclaredConstructor(new Class[]{String.class, UiComponent.CombinedStepImagePreview.Attributes.class, UiComponent.CombinedStepImagePreview.CombinedStepImagePreviewComponentStyle.class, Integer.TYPE, c.f18958c});
                this.f28050e = constructor;
                j.f(constructor, "UiComponent.CombinedStep…his.constructorRef = it }");
            }
            Object[] objArr = new Object[5];
            if (str != null) {
                objArr[0] = str;
                objArr[1] = attributes;
                objArr[2] = combinedStepImagePreviewComponentStyle;
                objArr[3] = Integer.valueOf(i10);
                objArr[4] = null;
                UiComponent.CombinedStepImagePreview newInstance = constructor.newInstance(objArr);
                j.f(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                return newInstance;
            }
            JsonDataException o10 = c.o("name", "name", jsonReader2);
            j.f(o10, "missingProperty(\"name\", \"name\", reader)");
            throw o10;
        } else if (str != null) {
            return new UiComponent.CombinedStepImagePreview(str, attributes, combinedStepImagePreviewComponentStyle);
        } else {
            JsonDataException o11 = c.o("name", "name", jsonReader2);
            j.f(o11, "missingProperty(\"name\", \"name\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.CombinedStepImagePreview combinedStepImagePreview) {
        j.g(qVar, "writer");
        if (combinedStepImagePreview != null) {
            qVar.c();
            qVar.u("name");
            this.f28047b.toJson(qVar, combinedStepImagePreview.A());
            qVar.u("attributes");
            this.f28048c.toJson(qVar, combinedStepImagePreview.z());
            qVar.u("styles");
            this.f28049d.toJson(qVar, combinedStepImagePreview.D());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(58);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.CombinedStepImagePreview");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
