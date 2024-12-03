package com.withpersona.sdk2.inquiry.internal.fallbackmode;

import android.content.Context;
import com.squareup.moshi.s;
import fk.a;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final a<s> f26387a;

    /* renamed from: b  reason: collision with root package name */
    private final a<Context> f26388b;

    public j(a<s> aVar, a<Context> aVar2) {
        this.f26387a = aVar;
        this.f26388b = aVar2;
    }

    public static j a(a<s> aVar, a<Context> aVar2) {
        return new j(aVar, aVar2);
    }

    public static i c(s sVar, Context context, int i10) {
        return new i(sVar, context, i10);
    }

    public i b(int i10) {
        return c(this.f26387a.get(), this.f26388b.get(), i10);
    }
}
