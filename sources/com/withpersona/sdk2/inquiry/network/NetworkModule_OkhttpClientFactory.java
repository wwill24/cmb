package com.withpersona.sdk2.inquiry.network;

import android.content.Context;
import com.withpersona.sdk2.inquiry.shared.device.c;
import fj.d;
import fj.g;
import fk.a;
import java.util.Map;
import java.util.Set;
import okhttp3.u;
import okhttp3.x;

public final class NetworkModule_OkhttpClientFactory implements d<x> {
    private final a<com.withpersona.sdk2.inquiry.shared.device.a> appSetIDHelperProvider;
    private final a<Context> contextProvider;
    private final a<c> deviceInfoProvider;
    private final a<Map<String, String>> headersProvider;
    private final a<Set<u>> interceptorsProvider;
    private final NetworkModule module;

    public NetworkModule_OkhttpClientFactory(NetworkModule networkModule, a<Set<u>> aVar, a<Map<String, String>> aVar2, a<Context> aVar3, a<com.withpersona.sdk2.inquiry.shared.device.a> aVar4, a<c> aVar5) {
        this.module = networkModule;
        this.interceptorsProvider = aVar;
        this.headersProvider = aVar2;
        this.contextProvider = aVar3;
        this.appSetIDHelperProvider = aVar4;
        this.deviceInfoProvider = aVar5;
    }

    public static NetworkModule_OkhttpClientFactory create(NetworkModule networkModule, a<Set<u>> aVar, a<Map<String, String>> aVar2, a<Context> aVar3, a<com.withpersona.sdk2.inquiry.shared.device.a> aVar4, a<c> aVar5) {
        return new NetworkModule_OkhttpClientFactory(networkModule, aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static x okhttpClient(NetworkModule networkModule, Set<u> set, Map<String, String> map, Context context, com.withpersona.sdk2.inquiry.shared.device.a aVar, c cVar) {
        return (x) g.e(networkModule.okhttpClient(set, map, context, aVar, cVar));
    }

    public x get() {
        return okhttpClient(this.module, this.interceptorsProvider.get(), this.headersProvider.get(), this.contextProvider.get(), this.appSetIDHelperProvider.get(), this.deviceInfoProvider.get());
    }
}
