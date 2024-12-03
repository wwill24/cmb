package com.withpersona.sdk2.inquiry.steps.ui.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_HorizontalStack_AttributesJsonAdapter extends h<UiComponent.HorizontalStack.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28114a;

    /* renamed from: b  reason: collision with root package name */
    private final h<List<UiComponent>> f28115b;

    public UiComponent_HorizontalStack_AttributesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("children");
        j.f(a10, "of(\"children\")");
        this.f28114a = a10;
        h<List<UiComponent>> f10 = sVar.f(w.j(List.class, UiComponent.class), n0.e(), "children");
        j.f(f10, "moshi.adapter(Types.newP…  emptySet(), \"children\")");
        this.f28115b = f10;
    }

    /* renamed from: a */
    public UiComponent.HorizontalStack.Attributes fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        List list = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28114a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                list = this.f28115b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new UiComponent.HorizontalStack.Attributes(list);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.HorizontalStack.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u("children");
            this.f28115b.toJson(qVar, attributes.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(60);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.HorizontalStack.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
