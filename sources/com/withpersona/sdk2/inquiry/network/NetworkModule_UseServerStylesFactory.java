package com.withpersona.sdk2.inquiry.network;

import fj.d;
import fj.g;

public final class NetworkModule_UseServerStylesFactory implements d<String> {
    private final NetworkModule module;

    public NetworkModule_UseServerStylesFactory(NetworkModule networkModule) {
        this.module = networkModule;
    }

    public static NetworkModule_UseServerStylesFactory create(NetworkModule networkModule) {
        return new NetworkModule_UseServerStylesFactory(networkModule);
    }

    public static String useServerStyles(NetworkModule networkModule) {
        return (String) g.e(networkModule.useServerStyles());
    }

    public String get() {
        return useServerStyles(this.module);
    }
}
