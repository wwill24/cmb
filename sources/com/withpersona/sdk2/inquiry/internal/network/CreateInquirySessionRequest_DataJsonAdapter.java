package com.withpersona.sdk2.inquiry.internal.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.internal.network.CreateInquirySessionRequest;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class CreateInquirySessionRequest_DataJsonAdapter extends h<CreateInquirySessionRequest.Data> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f26444a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f26445b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Constructor<CreateInquirySessionRequest.Data> f26446c;

    public CreateInquirySessionRequest_DataJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("type");
        j.f(a10, "of(\"type\")");
        this.f26444a = a10;
        h<String> f10 = sVar.f(String.class, n0.e(), "type");
        j.f(f10, "moshi.adapter(String::cl…emptySet(),\n      \"type\")");
        this.f26445b = f10;
    }

    /* renamed from: a */
    public CreateInquirySessionRequest.Data fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        int i10 = -1;
        String str = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f26444a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f26445b.fromJson(jsonReader);
                if (str != null) {
                    i10 &= -2;
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
        if (i10 == -2) {
            j.e(str, "null cannot be cast to non-null type kotlin.String");
            return new CreateInquirySessionRequest.Data(str);
        }
        Constructor<CreateInquirySessionRequest.Data> constructor = this.f26446c;
        if (constructor == null) {
            constructor = CreateInquirySessionRequest.Data.class.getDeclaredConstructor(new Class[]{String.class, Integer.TYPE, c.f18958c});
            this.f26446c = constructor;
            j.f(constructor, "CreateInquirySessionRequ…his.constructorRef = it }");
        }
        CreateInquirySessionRequest.Data newInstance = constructor.newInstance(new Object[]{str, Integer.valueOf(i10), null});
        j.f(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    /* renamed from: b */
    public void toJson(q qVar, CreateInquirySessionRequest.Data data) {
        j.g(qVar, "writer");
        if (data != null) {
            qVar.c();
            qVar.u("type");
            this.f26445b.toJson(qVar, data.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("CreateInquirySessionRequest.Data");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
