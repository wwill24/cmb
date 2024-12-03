package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$FooterBorderWidthStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$FooterColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$FooterPaddingStyle;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_FooterComponentStyleJsonAdapter extends h<UiComponent.FooterComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28085a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$FooterColorStyle> f28086b;

    /* renamed from: c  reason: collision with root package name */
    private final h<AttributeStyles$FooterPaddingStyle> f28087c;

    /* renamed from: d  reason: collision with root package name */
    private final h<AttributeStyles$FooterBorderWidthStyle> f28088d;

    public UiComponent_FooterComponentStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("backgroundColor", "padding", "borderWidth");
        j.f(a10, "of(\"backgroundColor\", \"p…ng\",\n      \"borderWidth\")");
        this.f28085a = a10;
        h<AttributeStyles$FooterColorStyle> f10 = sVar.f(AttributeStyles$FooterColorStyle.class, n0.e(), "backgroundColor");
        j.f(f10, "moshi.adapter(AttributeS…Set(), \"backgroundColor\")");
        this.f28086b = f10;
        h<AttributeStyles$FooterPaddingStyle> f11 = sVar.f(AttributeStyles$FooterPaddingStyle.class, n0.e(), "padding");
        j.f(f11, "moshi.adapter(AttributeS…a, emptySet(), \"padding\")");
        this.f28087c = f11;
        h<AttributeStyles$FooterBorderWidthStyle> f12 = sVar.f(AttributeStyles$FooterBorderWidthStyle.class, n0.e(), "borderWidth");
        j.f(f12, "moshi.adapter(AttributeS…mptySet(), \"borderWidth\")");
        this.f28088d = f12;
    }

    /* renamed from: a */
    public UiComponent.FooterComponentStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        AttributeStyles$FooterColorStyle attributeStyles$FooterColorStyle = null;
        AttributeStyles$FooterPaddingStyle attributeStyles$FooterPaddingStyle = null;
        AttributeStyles$FooterBorderWidthStyle attributeStyles$FooterBorderWidthStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28085a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                attributeStyles$FooterColorStyle = this.f28086b.fromJson(jsonReader);
            } else if (L == 1) {
                attributeStyles$FooterPaddingStyle = this.f28087c.fromJson(jsonReader);
            } else if (L == 2) {
                attributeStyles$FooterBorderWidthStyle = this.f28088d.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new UiComponent.FooterComponentStyle(attributeStyles$FooterColorStyle, attributeStyles$FooterPaddingStyle, attributeStyles$FooterBorderWidthStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.FooterComponentStyle footerComponentStyle) {
        j.g(qVar, "writer");
        if (footerComponentStyle != null) {
            qVar.c();
            qVar.u("backgroundColor");
            this.f28086b.toJson(qVar, footerComponentStyle.a());
            qVar.u("padding");
            this.f28087c.toJson(qVar, footerComponentStyle.d());
            qVar.u("borderWidth");
            this.f28088d.toJson(qVar, footerComponentStyle.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.FooterComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
