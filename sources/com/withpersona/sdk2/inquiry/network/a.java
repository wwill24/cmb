package com.withpersona.sdk2.inquiry.network;

import com.squareup.moshi.s;
import okhttp3.a0;
import okhttp3.u;

public final /* synthetic */ class a implements u {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s f27015a;

    public /* synthetic */ a(s sVar) {
        this.f27015a = sVar;
    }

    public final a0 intercept(u.a aVar) {
        return NetworkModule.interceptor$lambda$3(this.f27015a, aVar);
    }
}
