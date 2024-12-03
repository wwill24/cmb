package com.withpersona.sdk2.inquiry.internal;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.InquiryField;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class InquiryField_FloatFieldJsonAdapter extends h<InquiryField.FloatField> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26135a;

    /* renamed from: b  reason: collision with root package name */
    private final h<Float> f26136b;

    /* renamed from: c  reason: collision with root package name */
    private final h<String> f26137c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Constructor<InquiryField.FloatField> f26138d;

    public InquiryField_FloatFieldJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("value", "type");
        j.f(a10, "of(\"value\", \"type\")");
        this.f26135a = a10;
        h<Float> f10 = sVar.f(Float.class, n0.e(), "value");
        j.f(f10, "moshi.adapter(Float::cla…     emptySet(), \"value\")");
        this.f26136b = f10;
        h<String> f11 = sVar.f(String.class, n0.e(), "type");
        j.f(f11, "moshi.adapter(String::cl…emptySet(),\n      \"type\")");
        this.f26137c = f11;
    }

    /* renamed from: a */
    public InquiryField.FloatField fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        int i10 = -1;
        Float f10 = null;
        String str = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26135a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                f10 = this.f26136b.fromJson(jsonReader);
            } else if (L == 1) {
                str = this.f26137c.fromJson(jsonReader);
                if (str != null) {
                    i10 &= -3;
                } else {
                    JsonDataException x10 = c.x("type", "type", jsonReader);
                    j.f(x10, "unexpectedNull(\"type\", \"type\", reader)");
                    throw x10;
                }
            } else {
                continue;
            }
        }
        jsonReader.e();
        if (i10 == -3) {
            j.e(str, "null cannot be cast to non-null type kotlin.String");
            return new InquiryField.FloatField(f10, str);
        }
        Constructor<InquiryField.FloatField> constructor = this.f26138d;
        if (constructor == null) {
            constructor = InquiryField.FloatField.class.getDeclaredConstructor(new Class[]{Float.class, String.class, Integer.TYPE, c.f18958c});
            this.f26138d = constructor;
            j.f(constructor, "InquiryField.FloatField:…his.constructorRef = it }");
        }
        InquiryField.FloatField newInstance = constructor.newInstance(new Object[]{f10, str, Integer.valueOf(i10), null});
        j.f(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    /* renamed from: b */
    public void toJson(q qVar, InquiryField.FloatField floatField) {
        j.g(qVar, "writer");
        if (floatField != null) {
            qVar.c();
            qVar.u("value");
            this.f26136b.toJson(qVar, floatField.c());
            qVar.u("type");
            this.f26137c.toJson(qVar, floatField.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(45);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("InquiryField.FloatField");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
