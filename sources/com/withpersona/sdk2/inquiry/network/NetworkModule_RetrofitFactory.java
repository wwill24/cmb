package com.withpersona.sdk2.inquiry.network;

import fj.d;
import fj.g;
import fk.a;
import okhttp3.x;
import retrofit2.s;

public final class NetworkModule_RetrofitFactory implements d<s> {
    private final NetworkModule module;
    private final a<com.squareup.moshi.s> moshiProvider;
    private final a<x> okHttpClientProvider;
    private final a<String> serverEndpointProvider;

    public NetworkModule_RetrofitFactory(NetworkModule networkModule, a<String> aVar, a<x> aVar2, a<com.squareup.moshi.s> aVar3) {
        this.module = networkModule;
        this.serverEndpointProvider = aVar;
        this.okHttpClientProvider = aVar2;
        this.moshiProvider = aVar3;
    }

    public static NetworkModule_RetrofitFactory create(NetworkModule networkModule, a<String> aVar, a<x> aVar2, a<com.squareup.moshi.s> aVar3) {
        return new NetworkModule_RetrofitFactory(networkModule, aVar, aVar2, aVar3);
    }

    public static s retrofit(NetworkModule networkModule, String str, x xVar, com.squareup.moshi.s sVar) {
        return (s) g.e(networkModule.retrofit(str, xVar, sVar));
    }

    public s get() {
        return retrofit(this.module, this.serverEndpointProvider.get(), this.okHttpClientProvider.get(), this.moshiProvider.get());
    }
}
