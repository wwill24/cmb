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

public final class UiComponent_FooterJsonAdapter extends h<UiComponent.Footer> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28089a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f28090b;

    /* renamed from: c  reason: collision with root package name */
    private final h<UiComponent.Footer.Attributes> f28091c;

    /* renamed from: d  reason: collision with root package name */
    private final h<UiComponent.FooterComponentStyle> f28092d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Constructor<UiComponent.Footer> f28093e;

    public UiComponent_FooterJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("name", "attributes", "styles");
        j.f(a10, "of(\"name\", \"attributes\", \"styles\")");
        this.f28089a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "name");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"name\")");
        this.f28090b = f10;
        h<UiComponent.Footer.Attributes> f11 = sVar.f(UiComponent.Footer.Attributes.class, n0.e(), "attributes");
        j.f(f11, "moshi.adapter(UiComponen…emptySet(), \"attributes\")");
        this.f28091c = f11;
        h<UiComponent.FooterComponentStyle> f12 = sVar.f(UiComponent.FooterComponentStyle.class, n0.e(), "styles");
        j.f(f12, "moshi.adapter(UiComponen…va, emptySet(), \"styles\")");
        this.f28092d = f12;
    }

    /* renamed from: a */
    public UiComponent.Footer fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        int i10 = -1;
        String str = null;
        UiComponent.Footer.Attributes attributes = null;
        UiComponent.FooterComponentStyle footerComponentStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader2.L(this.f28089a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f28090b.fromJson(jsonReader2);
                if (str == null) {
                    JsonDataException x10 = c.x("name", "name", jsonReader2);
                    j.f(x10, "unexpectedNull(\"name\", \"name\",\n            reader)");
                    throw x10;
                }
            } else if (L == 1) {
                attributes = this.f28091c.fromJson(jsonReader2);
            } else if (L == 2) {
                footerComponentStyle = this.f28092d.fromJson(jsonReader2);
                i10 &= -5;
            }
        }
        jsonReader.e();
        if (i10 != -5) {
            Constructor<UiComponent.Footer> constructor = this.f28093e;
            if (constructor == null) {
                constructor = UiComponent.Footer.class.getDeclaredConstructor(new Class[]{String.class, UiComponent.Footer.Attributes.class, UiComponent.FooterComponentStyle.class, Integer.TYPE, c.f18958c});
                this.f28093e = constructor;
                j.f(constructor, "UiComponent.Footer::clas…his.constructorRef = it }");
            }
            Object[] objArr = new Object[5];
            if (str != null) {
                objArr[0] = str;
                objArr[1] = attributes;
                objArr[2] = footerComponentStyle;
                objArr[3] = Integer.valueOf(i10);
                objArr[4] = null;
                UiComponent.Footer newInstance = constructor.newInstance(objArr);
                j.f(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                return newInstance;
            }
            JsonDataException o10 = c.o("name", "name", jsonReader2);
            j.f(o10, "missingProperty(\"name\", \"name\", reader)");
            throw o10;
        } else if (str != null) {
            return new UiComponent.Footer(str, attributes, footerComponentStyle);
        } else {
            JsonDataException o11 = c.o("name", "name", jsonReader2);
            j.f(o11, "missingProperty(\"name\", \"name\", reader)");
            throw o11;
        }
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.Footer footer) {
        j.g(qVar, "writer");
        if (footer != null) {
            qVar.c();
            qVar.u("name");
            this.f28090b.toJson(qVar, footer.A());
            qVar.u("attributes");
            this.f28091c.toJson(qVar, footer.z());
            qVar.u("styles");
            this.f28092d.toJson(qVar, footer.G());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.Footer");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
