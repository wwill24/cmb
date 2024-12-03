package com.withpersona.sdk2.inquiry.steps.ui.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.LocalImageComponentStyle;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_LocalImageJsonAdapter extends h<UiComponent.LocalImage> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28272a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28273b;

    /* renamed from: c  reason: collision with root package name */
    private final h<UiComponent.LocalImage.Attributes> f28274c;

    /* renamed from: d  reason: collision with root package name */
    private final h<LocalImageComponentStyle> f28275d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Constructor<UiComponent.LocalImage> f28276e;

    public UiComponent_LocalImageJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("name", "attributes", "styles");
        j.f(a10, "of(\"name\", \"attributes\", \"styles\")");
        this.f28272a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "name");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"name\")");
        this.f28273b = f10;
        h<UiComponent.LocalImage.Attributes> f11 = sVar.f(UiComponent.LocalImage.Attributes.class, n0.e(), "attributes");
        j.f(f11, "moshi.adapter(UiComponen…emptySet(), \"attributes\")");
        this.f28274c = f11;
        h<LocalImageComponentStyle> f12 = sVar.f(LocalImageComponentStyle.class, n0.e(), "styles");
        j.f(f12, "moshi.adapter(LocalImage…va, emptySet(), \"styles\")");
        this.f28275d = f12;
    }

    /* renamed from: a */
    public UiComponent.LocalImage fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        int i10 = -1;
        String str = null;
        UiComponent.LocalImage.Attributes attributes = null;
        LocalImageComponentStyle localImageComponentStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader2.L(this.f28272a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f28273b.fromJson(jsonReader2);
                if (str == null) {
                    JsonDataException x10 = c.x("name", "name", jsonReader2);
                    j.f(x10, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                attributes = this.f28274c.fromJson(jsonReader2);
            } else if (L == 2) {
                localImageComponentStyle = this.f28275d.fromJson(jsonReader2);
                i10 &= -5;
            }
        }
        jsonReader.e();
        if (i10 != -5) {
            Constructor<UiComponent.LocalImage> constructor = this.f28276e;
            if (constructor == null) {
                constructor = UiComponent.LocalImage.class.getDeclaredConstructor(new Class[]{String.class, UiComponent.LocalImage.Attributes.class, LocalImageComponentStyle.class, Integer.TYPE, c.f18958c});
                this.f28276e = constructor;
                j.f(constructor, "UiComponent.LocalImage::…his.constructorRef = it }");
            }
            Object[] objArr = new Object[5];
            if (str != null) {
                objArr[0] = str;
                objArr[1] = attributes;
                objArr[2] = localImageComponentStyle;
                objArr[3] = Integer.valueOf(i10);
                objArr[4] = null;
                UiComponent.LocalImage newInstance = constructor.newInstance(objArr);
                j.f(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                return newInstance;
            }
            JsonDataException o10 = c.o("name", "name", jsonReader2);
            j.f(o10, "missingProperty(\"name\", \"name\", reader)");
            throw o10;
        } else if (str != null) {
            return new UiComponent.LocalImage(str, attributes, localImageComponentStyle);
        } else {
            JsonDataException o11 = c.o("name", "name", jsonReader2);
            j.f(o11, "missingProperty(\"name\", \"name\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.LocalImage localImage) {
        j.g(qVar, "writer");
        if (localImage != null) {
            qVar.c();
            qVar.u("name");
            this.f28273b.toJson(qVar, localImage.A());
            qVar.u("attributes");
            this.f28274c.toJson(qVar, localImage.z());
            qVar.u("styles");
            this.f28275d.toJson(qVar, localImage.D());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(44);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.LocalImage");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
