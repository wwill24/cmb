package com.withpersona.sdk2.inquiry.network;

import com.squareup.moshi.h;
import com.squareup.moshi.s;
import fj.d;
import fj.g;
import fk.a;
import java.util.Set;

public final class NetworkModule_MoshiFactory implements d<s> {
    private final a<Set<JsonAdapterBinding<?>>> jsonAdapterBindingsProvider;
    private final a<Set<h.e>> jsonAdapterFactoryProvider;
    private final a<Set<Object>> jsonAdaptersProvider;
    private final NetworkModule module;

    public NetworkModule_MoshiFactory(NetworkModule networkModule, a<Set<Object>> aVar, a<Set<JsonAdapterBinding<?>>> aVar2, a<Set<h.e>> aVar3) {
        this.module = networkModule;
        this.jsonAdaptersProvider = aVar;
        this.jsonAdapterBindingsProvider = aVar2;
        this.jsonAdapterFactoryProvider = aVar3;
    }

    public static NetworkModule_MoshiFactory create(NetworkModule networkModule, a<Set<Object>> aVar, a<Set<JsonAdapterBinding<?>>> aVar2, a<Set<h.e>> aVar3) {
        return new NetworkModule_MoshiFactory(networkModule, aVar, aVar2, aVar3);
    }

    public static s moshi(NetworkModule networkModule, Set<Object> set, Set<JsonAdapterBinding<?>> set2, Set<h.e> set3) {
        return (s) g.e(networkModule.moshi(set, set2, set3));
    }

    public s get() {
        return moshi(this.module, this.jsonAdaptersProvider.get(), this.jsonAdapterBindingsProvider.get(), this.jsonAdapterFactoryProvider.get());
    }
}
