package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$RemoteImageHeightStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$RemoteImageJustifyStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$RemoteImageMarginStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$RemoteImageWidthStyle;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_RemoteImageComponentStyleJsonAdapter extends h<UiComponent.RemoteImageComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28297a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$RemoteImageHeightStyle> f28298b;

    /* renamed from: c  reason: collision with root package name */
    private final h<AttributeStyles$RemoteImageWidthStyle> f28299c;

    /* renamed from: d  reason: collision with root package name */
    private final h<AttributeStyles$RemoteImageJustifyStyle> f28300d;

    /* renamed from: e  reason: collision with root package name */
    private final h<AttributeStyles$RemoteImageMarginStyle> f28301e;

    public UiComponent_RemoteImageComponentStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "justify", "margin");
        j.f(a10, "of(\"height\", \"width\", \"justify\",\n      \"margin\")");
        this.f28297a = a10;
        h<AttributeStyles$RemoteImageHeightStyle> f10 = sVar.f(AttributeStyles$RemoteImageHeightStyle.class, n0.e(), ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        j.f(f10, "moshi.adapter(AttributeS…va, emptySet(), \"height\")");
        this.f28298b = f10;
        h<AttributeStyles$RemoteImageWidthStyle> f11 = sVar.f(AttributeStyles$RemoteImageWidthStyle.class, n0.e(), ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        j.f(f11, "moshi.adapter(AttributeS…ava, emptySet(), \"width\")");
        this.f28299c = f11;
        h<AttributeStyles$RemoteImageJustifyStyle> f12 = sVar.f(AttributeStyles$RemoteImageJustifyStyle.class, n0.e(), "justify");
        j.f(f12, "moshi.adapter(AttributeS…a, emptySet(), \"justify\")");
        this.f28300d = f12;
        h<AttributeStyles$RemoteImageMarginStyle> f13 = sVar.f(AttributeStyles$RemoteImageMarginStyle.class, n0.e(), "margin");
        j.f(f13, "moshi.adapter(AttributeS…va, emptySet(), \"margin\")");
        this.f28301e = f13;
    }

    /* renamed from: a */
    public UiComponent.RemoteImageComponentStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        AttributeStyles$RemoteImageHeightStyle attributeStyles$RemoteImageHeightStyle = null;
        AttributeStyles$RemoteImageWidthStyle attributeStyles$RemoteImageWidthStyle = null;
        AttributeStyles$RemoteImageJustifyStyle attributeStyles$RemoteImageJustifyStyle = null;
        AttributeStyles$RemoteImageMarginStyle attributeStyles$RemoteImageMarginStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28297a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                attributeStyles$RemoteImageHeightStyle = this.f28298b.fromJson(jsonReader);
            } else if (L == 1) {
                attributeStyles$RemoteImageWidthStyle = this.f28299c.fromJson(jsonReader);
            } else if (L == 2) {
                attributeStyles$RemoteImageJustifyStyle = this.f28300d.fromJson(jsonReader);
            } else if (L == 3) {
                attributeStyles$RemoteImageMarginStyle = this.f28301e.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new UiComponent.RemoteImageComponentStyle(attributeStyles$RemoteImageHeightStyle, attributeStyles$RemoteImageWidthStyle, attributeStyles$RemoteImageJustifyStyle, attributeStyles$RemoteImageMarginStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.RemoteImageComponentStyle remoteImageComponentStyle) {
        j.g(qVar, "writer");
        if (remoteImageComponentStyle != null) {
            qVar.c();
            qVar.u(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            this.f28298b.toJson(qVar, remoteImageComponentStyle.a());
            qVar.u(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            this.f28299c.toJson(qVar, remoteImageComponentStyle.e());
            qVar.u("justify");
            this.f28300d.toJson(qVar, remoteImageComponentStyle.c());
            qVar.u("margin");
            this.f28301e.toJson(qVar, remoteImageComponentStyle.d());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(59);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.RemoteImageComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
