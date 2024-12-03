package com.withpersona.sdk2.inquiry.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import kotlin.jvm.internal.j;

public final class InternalErrorInfo$Companion$fallbackAdapter$1 extends h<Object> {
    InternalErrorInfo$Companion$fallbackAdapter$1() {
    }

    public Object fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        jsonReader.e();
        return null;
    }

    public void toJson(q qVar, Object obj) {
        String str;
        j.g(qVar, "writer");
        q u10 = qVar.c().u("message");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Error with class '");
        if (obj != null) {
            str = obj.getClass().getCanonicalName();
        } else {
            str = null;
        }
        sb2.append(str);
        sb2.append("' does not have a json adapter registered.");
        u10.S(sb2.toString()).h();
    }
}
