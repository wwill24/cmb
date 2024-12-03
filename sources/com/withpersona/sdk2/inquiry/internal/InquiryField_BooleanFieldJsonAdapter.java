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

public final class InquiryField_BooleanFieldJsonAdapter extends h<InquiryField.BooleanField> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26123a;

    /* renamed from: b  reason: collision with root package name */
    private final h<Boolean> f26124b;

    /* renamed from: c  reason: collision with root package name */
    private final h<String> f26125c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Constructor<InquiryField.BooleanField> f26126d;

    public InquiryField_BooleanFieldJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("value", "type");
        j.f(a10, "of(\"value\", \"type\")");
        this.f26123a = a10;
        h<Boolean> f10 = sVar.f(Boolean.class, n0.e(), "value");
        j.f(f10, "moshi.adapter(Boolean::c…ype, emptySet(), \"value\")");
        this.f26124b = f10;
        h<String> f11 = sVar.f(String.class, n0.e(), "type");
        j.f(f11, "moshi.adapter(String::cl…emptySet(),\n      \"type\")");
        this.f26125c = f11;
    }

    /* renamed from: a */
    public InquiryField.BooleanField fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        int i10 = -1;
        Boolean bool = null;
        String str = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26123a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                bool = this.f26124b.fromJson(jsonReader);
            } else if (L == 1) {
                str = this.f26125c.fromJson(jsonReader);
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
            return new InquiryField.BooleanField(bool, str);
        }
        Constructor<InquiryField.BooleanField> constructor = this.f26126d;
        if (constructor == null) {
            constructor = InquiryField.BooleanField.class.getDeclaredConstructor(new Class[]{Boolean.class, String.class, Integer.TYPE, c.f18958c});
            this.f26126d = constructor;
            j.f(constructor, "InquiryField.BooleanFiel…his.constructorRef = it }");
        }
        InquiryField.BooleanField newInstance = constructor.newInstance(new Object[]{bool, str, Integer.valueOf(i10), null});
        j.f(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    /* renamed from: b */
    public void toJson(q qVar, InquiryField.BooleanField booleanField) {
        j.g(qVar, "writer");
        if (booleanField != null) {
            qVar.c();
            qVar.u("value");
            this.f26124b.toJson(qVar, booleanField.c());
            qVar.u("type");
            this.f26125c.toJson(qVar, booleanField.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(47);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("InquiryField.BooleanField");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
