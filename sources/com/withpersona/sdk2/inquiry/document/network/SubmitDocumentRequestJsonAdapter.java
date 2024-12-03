package com.withpersona.sdk2.inquiry.document.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.document.network.SubmitDocumentRequest;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class SubmitDocumentRequestJsonAdapter extends h<SubmitDocumentRequest> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f25262a;

    /* renamed from: b  reason: collision with root package name */
    private final h<SubmitDocumentRequest.Data> f25263b;

    /* renamed from: c  reason: collision with root package name */
    private final h<SubmitDocumentRequest.Meta> f25264c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Constructor<SubmitDocumentRequest> f25265d;

    public SubmitDocumentRequestJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("data", "meta");
        j.f(a10, "of(\"data\", \"meta\")");
        this.f25262a = a10;
        h<SubmitDocumentRequest.Data> f10 = sVar.f(SubmitDocumentRequest.Data.class, n0.e(), "data");
        j.f(f10, "moshi.adapter(SubmitDocu…java, emptySet(), \"data\")");
        this.f25263b = f10;
        h<SubmitDocumentRequest.Meta> f11 = sVar.f(SubmitDocumentRequest.Meta.class, n0.e(), "meta");
        j.f(f11, "moshi.adapter(SubmitDocu…java, emptySet(), \"meta\")");
        this.f25264c = f11;
    }

    /* renamed from: a */
    public SubmitDocumentRequest fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        int i10 = -1;
        SubmitDocumentRequest.Data data = null;
        SubmitDocumentRequest.Meta meta = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f25262a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                data = this.f25263b.fromJson(jsonReader);
                if (data != null) {
                    i10 &= -2;
                } else {
                    JsonDataException x10 = c.x("data_", "data", jsonReader);
                    j.f(x10, "unexpectedNull(\"data_\", \"data\", reader)");
                    throw x10;
                }
            } else if (L == 1 && (meta = this.f25264c.fromJson(jsonReader)) == null) {
                JsonDataException x11 = c.x("meta", "meta", jsonReader);
                j.f(x11, "unexpectedNull(\"meta\", \"meta\",\n            reader)");
                throw x11;
            }
        }
        jsonReader.e();
        if (i10 == -2) {
            j.e(data, "null cannot be cast to non-null type com.withpersona.sdk2.inquiry.document.network.SubmitDocumentRequest.Data");
            if (meta != null) {
                return new SubmitDocumentRequest(data, meta);
            }
            JsonDataException o10 = c.o("meta", "meta", jsonReader);
            j.f(o10, "missingProperty(\"meta\", \"meta\", reader)");
            throw o10;
        }
        Constructor<SubmitDocumentRequest> constructor = this.f25265d;
        if (constructor == null) {
            constructor = SubmitDocumentRequest.class.getDeclaredConstructor(new Class[]{SubmitDocumentRequest.Data.class, SubmitDocumentRequest.Meta.class, Integer.TYPE, c.f18958c});
            this.f25265d = constructor;
            j.f(constructor, "SubmitDocumentRequest::c…his.constructorRef = it }");
        }
        Object[] objArr = new Object[4];
        objArr[0] = data;
        if (meta != null) {
            objArr[1] = meta;
            objArr[2] = Integer.valueOf(i10);
            objArr[3] = null;
            SubmitDocumentRequest newInstance = constructor.newInstance(objArr);
            j.f(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
            return newInstance;
        }
        JsonDataException o11 = c.o("meta", "meta", jsonReader);
        j.f(o11, "missingProperty(\"meta\", \"meta\", reader)");
        throw o11;
    }

    /* renamed from: b */
    public void toJson(q qVar, SubmitDocumentRequest submitDocumentRequest) {
        j.g(qVar, "writer");
        if (submitDocumentRequest != null) {
            qVar.c();
            qVar.u("data");
            this.f25263b.toJson(qVar, submitDocumentRequest.a());
            qVar.u("meta");
            this.f25264c.toJson(qVar, submitDocumentRequest.b());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(43);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("SubmitDocumentRequest");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
