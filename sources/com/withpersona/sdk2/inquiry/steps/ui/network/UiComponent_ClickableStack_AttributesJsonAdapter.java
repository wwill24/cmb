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

public final class UiComponent_ClickableStack_AttributesJsonAdapter extends h<UiComponent.ClickableStack.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28038a;

    /* renamed from: b  reason: collision with root package name */
    private final h<List<UiComponent>> f28039b;

    /* renamed from: c  reason: collision with root package name */
    private final h<JsonLogicBoolean> f28040c;

    public UiComponent_ClickableStack_AttributesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("children", "hidden", "disabled");
        j.f(a10, "of(\"children\", \"hidden\", \"disabled\")");
        this.f28038a = a10;
        h<List<UiComponent>> f10 = sVar.f(w.j(List.class, UiComponent.class), n0.e(), "children");
        j.f(f10, "moshi.adapter(Types.newP…  emptySet(), \"children\")");
        this.f28039b = f10;
        h<JsonLogicBoolean> f11 = sVar.f(JsonLogicBoolean.class, n0.e(), "hidden");
        j.f(f11, "moshi.adapter(JsonLogicB…va, emptySet(), \"hidden\")");
        this.f28040c = f11;
    }

    /* renamed from: a */
    public UiComponent.ClickableStack.Attributes fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        List list = null;
        JsonLogicBoolean jsonLogicBoolean = null;
        JsonLogicBoolean jsonLogicBoolean2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28038a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                list = this.f28039b.fromJson(jsonReader);
            } else if (L == 1) {
                jsonLogicBoolean = this.f28040c.fromJson(jsonReader);
            } else if (L == 2) {
                jsonLogicBoolean2 = this.f28040c.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new UiComponent.ClickableStack.Attributes(list, jsonLogicBoolean, jsonLogicBoolean2);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.ClickableStack.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u("children");
            this.f28039b.toJson(qVar, attributes.e());
            qVar.u("hidden");
            this.f28040c.toJson(qVar, attributes.c());
            qVar.u("disabled");
            this.f28040c.toJson(qVar, attributes.d());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(59);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.ClickableStack.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
