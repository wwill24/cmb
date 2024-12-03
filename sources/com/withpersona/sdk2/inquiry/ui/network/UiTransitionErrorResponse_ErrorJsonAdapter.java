package com.withpersona.sdk2.inquiry.ui.network;

import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse;
import java.util.Map;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;
import org.bouncycastle.i18n.ErrorBundle;

public final class UiTransitionErrorResponse_ErrorJsonAdapter extends h<UiTransitionErrorResponse.Error> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29491a;

    /* renamed from: b  reason: collision with root package name */
    private final h<String> f29492b;

    /* renamed from: c  reason: collision with root package name */
    private final h<Map<String, UiTransitionErrorResponse.UiComponentError>> f29493c;

    public UiTransitionErrorResponse_ErrorJsonAdapter(s sVar) {
        Class<String> cls = String.class;
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a("title", ErrorBundle.DETAIL_ENTRY);
        j.f(a10, "of(\"title\", \"details\")");
        this.f29491a = a10;
        h<String> f10 = sVar.f(cls, n0.e(), "title");
        j.f(f10, "moshi.adapter(String::cl…     emptySet(), \"title\")");
        this.f29492b = f10;
        h<Map<String, UiTransitionErrorResponse.UiComponentError>> f11 = sVar.f(w.j(Map.class, cls, UiTransitionErrorResponse.UiComponentError.class), n0.e(), ErrorBundle.DETAIL_ENTRY);
        j.f(f11, "moshi.adapter(Types.newP…), emptySet(), \"details\")");
        this.f29493c = f11;
    }

    /* renamed from: a */
    public UiTransitionErrorResponse.Error fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        String str = null;
        Map map = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29491a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                str = this.f29492b.fromJson(jsonReader);
            } else if (L == 1) {
                map = this.f29493c.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new UiTransitionErrorResponse.Error(str, map);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiTransitionErrorResponse.Error error) {
        j.g(qVar, "writer");
        if (error != null) {
            qVar.c();
            qVar.u("title");
            this.f29492b.toJson(qVar, error.b());
            qVar.u(ErrorBundle.DETAIL_ENTRY);
            this.f29493c.toJson(qVar, error.a());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(53);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiTransitionErrorResponse.Error");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
