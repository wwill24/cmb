package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$SpacerHeightStyle;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.AttributeStyles$SpacerWidthStyle;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_SpacerComponentStyleJsonAdapter extends h<UiComponent.SpacerComponentStyle> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28313a;

    /* renamed from: b  reason: collision with root package name */
    private final h<AttributeStyles$SpacerHeightStyle> f28314b;

    /* renamed from: c  reason: collision with root package name */
    private final h<AttributeStyles$SpacerWidthStyle> f28315c;

    public UiComponent_SpacerComponentStyleJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        j.f(a10, "of(\"height\", \"width\")");
        this.f28313a = a10;
        h<AttributeStyles$SpacerHeightStyle> f10 = sVar.f(AttributeStyles$SpacerHeightStyle.class, n0.e(), ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        j.f(f10, "moshi.adapter(AttributeS…va, emptySet(), \"height\")");
        this.f28314b = f10;
        h<AttributeStyles$SpacerWidthStyle> f11 = sVar.f(AttributeStyles$SpacerWidthStyle.class, n0.e(), ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        j.f(f11, "moshi.adapter(AttributeS…ava, emptySet(), \"width\")");
        this.f28315c = f11;
    }

    /* renamed from: a */
    public UiComponent.SpacerComponentStyle fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        AttributeStyles$SpacerHeightStyle attributeStyles$SpacerHeightStyle = null;
        AttributeStyles$SpacerWidthStyle attributeStyles$SpacerWidthStyle = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28313a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                attributeStyles$SpacerHeightStyle = this.f28314b.fromJson(jsonReader);
            } else if (L == 1) {
                attributeStyles$SpacerWidthStyle = this.f28315c.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new UiComponent.SpacerComponentStyle(attributeStyles$SpacerHeightStyle, attributeStyles$SpacerWidthStyle);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.SpacerComponentStyle spacerComponentStyle) {
        j.g(qVar, "writer");
        if (spacerComponentStyle != null) {
            qVar.c();
            qVar.u(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            this.f28314b.toJson(qVar, spacerComponentStyle.a());
            qVar.u(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            this.f28315c.toJson(qVar, spacerComponentStyle.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.SpacerComponentStyle");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
