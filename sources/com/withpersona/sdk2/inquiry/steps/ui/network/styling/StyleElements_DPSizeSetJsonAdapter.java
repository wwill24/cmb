package com.withpersona.sdk2.inquiry.steps.ui.network.styling;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.steps.ui.network.styling.StyleElements;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class StyleElements_DPSizeSetJsonAdapter extends h<StyleElements.DPSizeSet> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29204a;

    /* renamed from: b  reason: collision with root package name */
    private final h<StyleElements.DPSize> f29205b;

    public StyleElements_DPSizeSetJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a(ViewHierarchyConstants.DIMENSION_TOP_KEY, "bottom", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "right");
        j.f(a10, "of(\"top\", \"bottom\", \"left\", \"right\")");
        this.f29204a = a10;
        h<StyleElements.DPSize> f10 = sVar.f(StyleElements.DPSize.class, n0.e(), ViewHierarchyConstants.DIMENSION_TOP_KEY);
        j.f(f10, "moshi.adapter(StyleEleme….java, emptySet(), \"top\")");
        this.f29205b = f10;
    }

    /* renamed from: a */
    public StyleElements.DPSizeSet fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        StyleElements.DPSize dPSize = null;
        StyleElements.DPSize dPSize2 = null;
        StyleElements.DPSize dPSize3 = null;
        StyleElements.DPSize dPSize4 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29204a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                dPSize = this.f29205b.fromJson(jsonReader);
            } else if (L == 1) {
                dPSize2 = this.f29205b.fromJson(jsonReader);
            } else if (L == 2) {
                dPSize3 = this.f29205b.fromJson(jsonReader);
            } else if (L == 3) {
                dPSize4 = this.f29205b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new StyleElements.DPSizeSet(dPSize, dPSize2, dPSize3, dPSize4);
    }

    /* renamed from: b */
    public void toJson(q qVar, StyleElements.DPSizeSet dPSizeSet) {
        j.g(qVar, "writer");
        if (dPSizeSet != null) {
            qVar.c();
            qVar.u(ViewHierarchyConstants.DIMENSION_TOP_KEY);
            this.f29205b.toJson(qVar, dPSizeSet.e());
            qVar.u("bottom");
            this.f29205b.toJson(qVar, dPSizeSet.a());
            qVar.u(ViewHierarchyConstants.DIMENSION_LEFT_KEY);
            this.f29205b.toJson(qVar, dPSizeSet.c());
            qVar.u("right");
            this.f29205b.toJson(qVar, dPSizeSet.d());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(45);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("StyleElements.DPSizeSet");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
