package com.withpersona.sdk2.inquiry.network;

import bi.c;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.withpersona.sdk2.inquiry.network.ErrorResponse;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import java.lang.reflect.Constructor;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class InternalErrorInfo_NetworkErrorInfoJsonAdapter extends h<InternalErrorInfo.NetworkErrorInfo> {
    private final h<Boolean> booleanAdapter;
    private volatile Constructor<InternalErrorInfo.NetworkErrorInfo> constructorRef;
    private final h<Integer> intAdapter;
    private final h<ErrorResponse.Error> nullableErrorAdapter;
    private final h<String> nullableStringAdapter;
    private final JsonReader.b options;

    public InternalErrorInfo_NetworkErrorInfoJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("code", "message", "isRecoverable", "responseError");
        j.f(a10, "of(\"code\", \"message\",\n  …erable\", \"responseError\")");
        this.options = a10;
        h<Integer> f10 = sVar.f(Integer.TYPE, n0.e(), "code");
        j.f(f10, "moshi.adapter(Int::class.java, emptySet(), \"code\")");
        this.intAdapter = f10;
        h<String> f11 = sVar.f(String.class, n0.e(), "message");
        j.f(f11, "moshi.adapter(String::cl…   emptySet(), \"message\")");
        this.nullableStringAdapter = f11;
        h<Boolean> f12 = sVar.f(Boolean.TYPE, n0.e(), "isRecoverable");
        j.f(f12, "moshi.adapter(Boolean::c…),\n      \"isRecoverable\")");
        this.booleanAdapter = f12;
        h<ErrorResponse.Error> f13 = sVar.f(ErrorResponse.Error.class, n0.e(), "responseError");
        j.f(f13, "moshi.adapter(ErrorRespo…tySet(), \"responseError\")");
        this.nullableErrorAdapter = f13;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(56);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("InternalErrorInfo.NetworkErrorInfo");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }

    public InternalErrorInfo.NetworkErrorInfo fromJson(JsonReader jsonReader) {
        JsonReader jsonReader2 = jsonReader;
        j.g(jsonReader2, "reader");
        jsonReader.b();
        int i10 = -1;
        Integer num = null;
        String str = null;
        Boolean bool = null;
        ErrorResponse.Error error = null;
        while (jsonReader.g()) {
            int L = jsonReader2.L(this.options);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                num = this.intAdapter.fromJson(jsonReader2);
                if (num == null) {
                    JsonDataException x10 = c.x("code", "code", jsonReader2);
                    j.f(x10, "unexpectedNull(\"code\", \"code\", reader)");
                    throw x10;
                }
            } else if (L == 1) {
                str = this.nullableStringAdapter.fromJson(jsonReader2);
            } else if (L == 2) {
                bool = this.booleanAdapter.fromJson(jsonReader2);
                if (bool == null) {
                    JsonDataException x11 = c.x("isRecoverable", "isRecoverable", jsonReader2);
                    j.f(x11, "unexpectedNull(\"isRecove… \"isRecoverable\", reader)");
                    throw x11;
                }
            } else if (L == 3) {
                error = this.nullableErrorAdapter.fromJson(jsonReader2);
                i10 &= -9;
            }
        }
        jsonReader.e();
        if (i10 != -9) {
            Constructor<InternalErrorInfo.NetworkErrorInfo> constructor = this.constructorRef;
            if (constructor == null) {
                Class cls = Integer.TYPE;
                constructor = InternalErrorInfo.NetworkErrorInfo.class.getDeclaredConstructor(new Class[]{cls, String.class, Boolean.TYPE, ErrorResponse.Error.class, cls, c.f18958c});
                this.constructorRef = constructor;
                j.f(constructor, "InternalErrorInfo.Networ…his.constructorRef = it }");
            }
            Object[] objArr = new Object[6];
            if (num != null) {
                objArr[0] = Integer.valueOf(num.intValue());
                objArr[1] = str;
                if (bool != null) {
                    objArr[2] = Boolean.valueOf(bool.booleanValue());
                    objArr[3] = error;
                    objArr[4] = Integer.valueOf(i10);
                    objArr[5] = null;
                    InternalErrorInfo.NetworkErrorInfo newInstance = constructor.newInstance(objArr);
                    j.f(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
                    return newInstance;
                }
                JsonDataException o10 = c.o("isRecoverable", "isRecoverable", jsonReader2);
                j.f(o10, "missingProperty(\"isRecov… \"isRecoverable\", reader)");
                throw o10;
            }
            JsonDataException o11 = c.o("code", "code", jsonReader2);
            j.f(o11, "missingProperty(\"code\", \"code\", reader)");
            throw o11;
        } else if (num != null) {
            int intValue = num.intValue();
            if (bool != null) {
                return new InternalErrorInfo.NetworkErrorInfo(intValue, str, bool.booleanValue(), error);
            }
            JsonDataException o12 = c.o("isRecoverable", "isRecoverable", jsonReader2);
            j.f(o12, "missingProperty(\"isRecov… \"isRecoverable\", reader)");
            throw o12;
        } else {
            JsonDataException o13 = c.o("code", "code", jsonReader2);
            j.f(o13, "missingProperty(\"code\", \"code\", reader)");
            throw o13;
        }
    }

    public void toJson(q qVar, InternalErrorInfo.NetworkErrorInfo networkErrorInfo) {
        j.g(qVar, "writer");
        if (networkErrorInfo != null) {
            qVar.c();
            qVar.u("code");
            this.intAdapter.toJson(qVar, Integer.valueOf(networkErrorInfo.getCode()));
            qVar.u("message");
            this.nullableStringAdapter.toJson(qVar, networkErrorInfo.getMessage());
            qVar.u("isRecoverable");
            this.booleanAdapter.toJson(qVar, Boolean.valueOf(networkErrorInfo.isRecoverable()));
            qVar.u("responseError");
            this.nullableErrorAdapter.toJson(qVar, networkErrorInfo.getResponseError());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
