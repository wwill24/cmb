package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class LocalImageComponentStyleJsonAdapter extends h<LocalImageComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28872a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$LocalImageStrokeColorStyle> f28873b;

    /* renamed from: c  reason: collision with root package name */
    private final h<AttributeStyles$LocalImageFillColorStyle> f28874c;

    /* renamed from: d  reason: collision with root package name */
    private final h<AttributeStyles$LocalImageHeightStyle> f28875d;

    /* renamed from: e  reason: collision with root package name */
    private final h<AttributeStyles$LocalImageWidthStyle> f28876e;

    /* renamed from: f  reason: collision with root package name */
    private final h<AttributeStyles$LocalImageJustifyStyle> f28877f;

    /* renamed from: g  reason: collision with root package name */
    private final h<AttributeStyles$LocalImageMarginStyle> f28878g;

    public LocalImageComponentStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("strokeColor", "fillColor", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "justify", "margin");
        j.f(a10, "of(\"strokeColor\", \"fillC…th\", \"justify\", \"margin\")");
        this.f28872a = a10;
        h<AttributeStyles$LocalImageStrokeColorStyle> f10 = sVar.f(AttributeStyles$LocalImageStrokeColorStyle.class, n0.e(), "strokeColor");
        j.f(f10, "moshi.adapter(AttributeS…t(),\n      \"strokeColor\")");
        this.f28873b = f10;
        h<AttributeStyles$LocalImageFillColorStyle> f11 = sVar.f(AttributeStyles$LocalImageFillColorStyle.class, n0.e(), "fillColor");
        j.f(f11, "moshi.adapter(AttributeS… emptySet(), \"fillColor\")");
        this.f28874c = f11;
        h<AttributeStyles$LocalImageHeightStyle> f12 = sVar.f(AttributeStyles$LocalImageHeightStyle.class, n0.e(), ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        j.f(f12, "moshi.adapter(AttributeS…va, emptySet(), \"height\")");
        this.f28875d = f12;
        h<AttributeStyles$LocalImageWidthStyle> f13 = sVar.f(AttributeStyles$LocalImageWidthStyle.class, n0.e(), ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        j.f(f13, "moshi.adapter(AttributeS…ava, emptySet(), \"width\")");
        this.f28876e = f13;
        h<AttributeStyles$LocalImageJustifyStyle> f14 = sVar.f(AttributeStyles$LocalImageJustifyStyle.class, n0.e(), "justify");
        j.f(f14, "moshi.adapter(AttributeS…a, emptySet(), \"justify\")");
        this.f28877f = f14;
        h<AttributeStyles$LocalImageMarginStyle> f15 = sVar.f(AttributeStyles$LocalImageMarginStyle.class, n0.e(), "margin");
        j.f(f15, "moshi.adapter(AttributeS…va, emptySet(), \"margin\")");
        this.f28878g = f15;
    }

    /* renamed from: a */
    public LocalImageComponentStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        AttributeStyles$LocalImageStrokeColorStyle attributeStyles$LocalImageStrokeColorStyle = null;
        AttributeStyles$LocalImageFillColorStyle attributeStyles$LocalImageFillColorStyle = null;
        AttributeStyles$LocalImageHeightStyle attributeStyles$LocalImageHeightStyle = null;
        AttributeStyles$LocalImageWidthStyle attributeStyles$LocalImageWidthStyle = null;
        AttributeStyles$LocalImageJustifyStyle attributeStyles$LocalImageJustifyStyle = null;
        AttributeStyles$LocalImageMarginStyle attributeStyles$LocalImageMarginStyle = null;
        while (jsonReader.g()) {
            switch (jsonReader.L(this.f28872a)) {
                case -1:
                    jsonReader.S();
                    jsonReader.Y();
                    break;
                case 0:
                    attributeStyles$LocalImageStrokeColorStyle = this.f28873b.fromJson(jsonReader);
                    break;
                case 1:
                    attributeStyles$LocalImageFillColorStyle = this.f28874c.fromJson(jsonReader);
                    break;
                case 2:
                    attributeStyles$LocalImageHeightStyle = this.f28875d.fromJson(jsonReader);
                    break;
                case 3:
                    attributeStyles$LocalImageWidthStyle = this.f28876e.fromJson(jsonReader);
                    break;
                case 4:
                    attributeStyles$LocalImageJustifyStyle = this.f28877f.fromJson(jsonReader);
                    break;
                case 5:
                    attributeStyles$LocalImageMarginStyle = this.f28878g.fromJson(jsonReader);
                    break;
            }
        }
        jsonReader.e();
        return new LocalImageComponentStyle(attributeStyles$LocalImageStrokeColorStyle, attributeStyles$LocalImageFillColorStyle, attributeStyles$LocalImageHeightStyle, attributeStyles$LocalImageWidthStyle, attributeStyles$LocalImageJustifyStyle, attributeStyles$LocalImageMarginStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, LocalImageComponentStyle localImageComponentStyle) {
        j.g(qVar, "writer");
        if (localImageComponentStyle != null) {
            qVar.c();
            qVar.u("strokeColor");
            this.f28873b.toJson(qVar, localImageComponentStyle.h());
            qVar.u("fillColor");
            this.f28874c.toJson(qVar, localImageComponentStyle.a());
            qVar.u(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            this.f28875d.toJson(qVar, localImageComponentStyle.c());
            qVar.u(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            this.f28876e.toJson(qVar, localImageComponentStyle.i());
            qVar.u("justify");
            this.f28877f.toJson(qVar, localImageComponentStyle.e());
            qVar.u("margin");
            this.f28878g.toJson(qVar, localImageComponentStyle.f());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("LocalImageComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
