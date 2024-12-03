package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$QRCodeFillColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$QRCodeJustifyStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$QRCodeMarginStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$QRCodeStrokeColorStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$QRCodeWidthStyle;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_QRCodeComponentStyleJsonAdapter extends h<UiComponent.QRCodeComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28285a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$QRCodeWidthStyle> f28286b;

    /* renamed from: c  reason: collision with root package name */
    private final h<AttributeStyles$QRCodeJustifyStyle> f28287c;

    /* renamed from: d  reason: collision with root package name */
    private final h<AttributeStyles$QRCodeMarginStyle> f28288d;

    /* renamed from: e  reason: collision with root package name */
    private final h<AttributeStyles$QRCodeStrokeColorStyle> f28289e;

    /* renamed from: f  reason: collision with root package name */
    private final h<AttributeStyles$QRCodeFillColorStyle> f28290f;

    public UiComponent_QRCodeComponentStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "justify", "margin", "strokeColor", "fillColor");
        j.f(a10, "of(\"width\", \"justify\", \"…trokeColor\", \"fillColor\")");
        this.f28285a = a10;
        h<AttributeStyles$QRCodeWidthStyle> f10 = sVar.f(AttributeStyles$QRCodeWidthStyle.class, n0.e(), ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        j.f(f10, "moshi.adapter(AttributeS…ava, emptySet(), \"width\")");
        this.f28286b = f10;
        h<AttributeStyles$QRCodeJustifyStyle> f11 = sVar.f(AttributeStyles$QRCodeJustifyStyle.class, n0.e(), "justify");
        j.f(f11, "moshi.adapter(AttributeS…a, emptySet(), \"justify\")");
        this.f28287c = f11;
        h<AttributeStyles$QRCodeMarginStyle> f12 = sVar.f(AttributeStyles$QRCodeMarginStyle.class, n0.e(), "margin");
        j.f(f12, "moshi.adapter(AttributeS…va, emptySet(), \"margin\")");
        this.f28288d = f12;
        h<AttributeStyles$QRCodeStrokeColorStyle> f13 = sVar.f(AttributeStyles$QRCodeStrokeColorStyle.class, n0.e(), "strokeColor");
        j.f(f13, "moshi.adapter(AttributeS…mptySet(), \"strokeColor\")");
        this.f28289e = f13;
        h<AttributeStyles$QRCodeFillColorStyle> f14 = sVar.f(AttributeStyles$QRCodeFillColorStyle.class, n0.e(), "fillColor");
        j.f(f14, "moshi.adapter(AttributeS… emptySet(), \"fillColor\")");
        this.f28290f = f14;
    }

    /* renamed from: a */
    public UiComponent.QRCodeComponentStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        AttributeStyles$QRCodeWidthStyle attributeStyles$QRCodeWidthStyle = null;
        AttributeStyles$QRCodeJustifyStyle attributeStyles$QRCodeJustifyStyle = null;
        AttributeStyles$QRCodeMarginStyle attributeStyles$QRCodeMarginStyle = null;
        AttributeStyles$QRCodeStrokeColorStyle attributeStyles$QRCodeStrokeColorStyle = null;
        AttributeStyles$QRCodeFillColorStyle attributeStyles$QRCodeFillColorStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28285a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                attributeStyles$QRCodeWidthStyle = this.f28286b.fromJson(jsonReader);
            } else if (L == 1) {
                attributeStyles$QRCodeJustifyStyle = this.f28287c.fromJson(jsonReader);
            } else if (L == 2) {
                attributeStyles$QRCodeMarginStyle = this.f28288d.fromJson(jsonReader);
            } else if (L == 3) {
                attributeStyles$QRCodeStrokeColorStyle = this.f28289e.fromJson(jsonReader);
            } else if (L == 4) {
                attributeStyles$QRCodeFillColorStyle = this.f28290f.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new UiComponent.QRCodeComponentStyle(attributeStyles$QRCodeWidthStyle, attributeStyles$QRCodeJustifyStyle, attributeStyles$QRCodeMarginStyle, attributeStyles$QRCodeStrokeColorStyle, attributeStyles$QRCodeFillColorStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.QRCodeComponentStyle qRCodeComponentStyle) {
        j.g(qVar, "writer");
        if (qRCodeComponentStyle != null) {
            qVar.c();
            qVar.u(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            this.f28286b.toJson(qVar, qRCodeComponentStyle.f());
            qVar.u("justify");
            this.f28287c.toJson(qVar, qRCodeComponentStyle.c());
            qVar.u("margin");
            this.f28288d.toJson(qVar, qRCodeComponentStyle.d());
            qVar.u("strokeColor");
            this.f28289e.toJson(qVar, qRCodeComponentStyle.e());
            qVar.u("fillColor");
            this.f28290f.toJson(qVar, qRCodeComponentStyle.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.QRCodeComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
