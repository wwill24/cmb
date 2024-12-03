package com.withpersona.sdk2.inquiry.steps.ui.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiComponent_Footer_AttributesJsonAdapter extends h<UiComponent.Footer.Attributes> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f28094a;

    /* renamed from: b  reason: collision with root package name */
    private final h<List<UiComponent>> f28095b;

    /* renamed from: c  reason: collision with root package name */
    private final h<Integer> f28096c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Constructor<UiComponent.Footer.Attributes> f28097d;

    public UiComponent_Footer_AttributesJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("children", "firstBelowTheFoldChildIndex");
        j.f(a10, "of(\"children\",\n      \"fi…tBelowTheFoldChildIndex\")");
        this.f28094a = a10;
        h<List<UiComponent>> f10 = sVar.f(w.j(List.class, UiComponent.class), n0.e(), "children");
        j.f(f10, "moshi.adapter(Types.newP…  emptySet(), \"children\")");
        this.f28095b = f10;
        h<Integer> f11 = sVar.f(Integer.class, n0.e(), "firstBelowTheFoldChildIndex");
        j.f(f11, "moshi.adapter(Int::class…tBelowTheFoldChildIndex\")");
        this.f28096c = f11;
    }

    /* renamed from: a */
    public UiComponent.Footer.Attributes fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        int i10 = -1;
        List list = null;
        Integer num = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f28094a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                list = this.f28095b.fromJson(jsonReader);
                if (list != null) {
                    i10 &= -2;
                } else {
                    JsonDataException x10 = c.x("children", "children", jsonReader);
                    j.f(x10, "unexpectedNull(\"children\", \"children\", reader)");
                    throw x10;
                }
            } else if (L == 1) {
                num = this.f28096c.fromJson(jsonReader);
                i10 &= -3;
            }
        }
        jsonReader.e();
        if (i10 == -4) {
            j.e(list, "null cannot be cast to non-null type kotlin.collections.List<com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent>");
            return new UiComponent.Footer.Attributes(list, num);
        }
        Constructor<UiComponent.Footer.Attributes> constructor = this.f28097d;
        if (constructor == null) {
            constructor = UiComponent.Footer.Attributes.class.getDeclaredConstructor(new Class[]{List.class, Integer.class, Integer.TYPE, c.f18958c});
            this.f28097d = constructor;
            j.f(constructor, "UiComponent.Footer.Attri…his.constructorRef = it }");
        }
        UiComponent.Footer.Attributes newInstance = constructor.newInstance(new Object[]{list, num, Integer.valueOf(i10), null});
        j.f(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    /* renamed from: b */
    public void toJson(q qVar, UiComponent.Footer.Attributes attributes) {
        j.g(qVar, "writer");
        if (attributes != null) {
            qVar.c();
            qVar.u("children");
            this.f28095b.toJson(qVar, attributes.a());
            qVar.u("firstBelowTheFoldChildIndex");
            this.f28096c.toJson(qVar, attributes.c());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(51);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiComponent.Footer.Attributes");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
