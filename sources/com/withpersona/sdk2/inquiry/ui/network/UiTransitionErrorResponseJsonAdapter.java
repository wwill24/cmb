package com.withpersona.sdk2.inquiry.ui.network;

import com.mparticle.identity.IdentityHttpResponse;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.h;
import com.squareup.moshi.q;
import com.squareup.moshi.s;
import com.squareup.moshi.w;
import com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse;
import java.util.List;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class UiTransitionErrorResponseJsonAdapter extends h<UiTransitionErrorResponse> {

    /* renamed from: a  reason: collision with root package name */
    private final JsonReader.b f29489a;

    /* renamed from: b  reason: collision with root package name */
    private final h<List<UiTransitionErrorResponse.Error>> f29490b;

    public UiTransitionErrorResponseJsonAdapter(s sVar) {
        j.g(sVar, "moshi");
        JsonReader.b a10 = JsonReader.b.a(IdentityHttpResponse.ERRORS);
        j.f(a10, "of(\"errors\")");
        this.f29489a = a10;
        h<List<UiTransitionErrorResponse.Error>> f10 = sVar.f(w.j(List.class, UiTransitionErrorResponse.Error.class), n0.e(), IdentityHttpResponse.ERRORS);
        j.f(f10, "moshi.adapter(Types.newP…a), emptySet(), \"errors\")");
        this.f29490b = f10;
    }

    /* renamed from: a */
    public UiTransitionErrorResponse fromJson(JsonReader jsonReader) {
        j.g(jsonReader, "reader");
        jsonReader.b();
        List list = null;
        while (jsonReader.g()) {
            int L = jsonReader.L(this.f29489a);
            if (L == -1) {
                jsonReader.S();
                jsonReader.Y();
            } else if (L == 0) {
                list = this.f29490b.fromJson(jsonReader);
            }
        }
        jsonReader.e();
        return new UiTransitionErrorResponse(list);
    }

    /* renamed from: b */
    public void toJson(q qVar, UiTransitionErrorResponse uiTransitionErrorResponse) {
        j.g(qVar, "writer");
        if (uiTransitionErrorResponse != null) {
            qVar.c();
            qVar.u(IdentityHttpResponse.ERRORS);
            this.f29490b.toJson(qVar, uiTransitionErrorResponse.b());
            qVar.h();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(47);
        sb2.append("GeneratedJsonAdapter(");
        sb2.append("UiTransitionErrorResponse");
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        String sb3 = sb2.toString();
        j.f(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
