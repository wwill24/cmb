package com.withpersona.sdk2.inquiry.network;

import com.squareup.moshi.s;
import fj.d;
import fj.g;
import fk.a;
import okhttp3.u;

public final class NetworkModule_InterceptorFactory implements d<u> {
    private final NetworkModule module;
    private final a<s> moshiProvider;

    public NetworkModule_InterceptorFactory(NetworkModule networkModule, a<s> aVar) {
        this.module = networkModule;
        this.moshiProvider = aVar;
    }

    public static NetworkModule_InterceptorFactory create(NetworkModule networkModule, a<s> aVar) {
        return new NetworkModule_InterceptorFactory(networkModule, aVar);
    }

    public static u interceptor(NetworkModule networkModule, s sVar) {
        return (u) g.e(networkModule.interceptor(sVar));
    }

    public u get() {
        return interceptor(this.module, this.moshiProvider.get());
    }
}
