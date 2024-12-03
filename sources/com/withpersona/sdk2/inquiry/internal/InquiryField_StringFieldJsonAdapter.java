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

public final class InquiryField_StringFieldJsonAdapter extends h<InquiryField.StringField> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26143a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26144b;

    /* renamed from: c  reason: collision with root package name */
    private final h<String> f26145c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Constructor<InquiryField.StringField> f26146d;

    public InquiryField_StringFieldJsonAdapter(s sVar) {
        Class<String> cls = String.class;
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("value", "type");
        j.f(a10, "of(\"value\", \"type\")");
        this.f26143a = a10;
        h<String> f10 = sVar.f(cls, n0.e(), "value");
        j.f(f10, "moshi.adapter(String::cl…     emptySet(), \"value\")");
        this.f26144b = f10;
        h<String> f11 = sVar.f(cls, n0.e(), "type");
        j.f(f11, "moshi.adapter(String::cl…emptySet(),\n      \"type\")");
        this.f26145c = f11;
    }

    /* renamed from: a */
    public InquiryField.StringField fromJson(JsonReader jsonReader) {
        Class<String> cls = String.class;
        j.g(jsonReader, "reader");
        jsonReader.b();
        int i10 = -1;
        String str = null;
        String str2 = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26143a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f26144b.fromJson(jsonReader);
            } else if (L == 1) {
                str2 = this.f26145c.fromJson(jsonReader);
                if (str2 != null) {
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
            j.e(str2, "null cannot be cast to non-null type kotlin.String");
            return new InquiryField.StringField(str, str2);
        }
        Constructor<InquiryField.StringField> constructor = this.f26146d;
        if (constructor == null) {
            constructor = InquiryField.StringField.class.getDeclaredConstructor(new Class[]{cls, cls, Integer.TYPE, c.f18958c});
            this.f26146d = constructor;
            j.f(constructor, "InquiryField.StringField…his.constructorRef = it }");
        }
        InquiryField.StringField newInstance = constructor.newInstance(new Object[]{str, str2, Integer.valueOf(i10), null});
        j.f(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    /* renamed from: b */
    public void toJson(q qVar, InquiryField.StringField stringField) {
        j.g(qVar, "writer");
        if (stringField != null) {
            qVar.c();
            qVar.u("value");
            this.f26144b.toJson(qVar, stringField.c());
            qVar.u("type");
            this.f26145c.toJson(qVar, stringField.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("InquiryField.StringField");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
