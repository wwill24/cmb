package com.withpersona.sdk2.inquiry.network;

import fj.d;
import fj.g;

public final class NetworkModule_KeyInflectionFactory implements d<String> {
    private final NetworkModule module;

    public NetworkModule_KeyInflectionFactory(NetworkModule networkModule) {
        this.module = networkModule;
    }

    public static NetworkModule_KeyInflectionFactory create(NetworkModule networkModule) {
        return new NetworkModule_KeyInflectionFactory(networkModule);
    }

    public static String keyInflection(NetworkModule networkModule) {
        return (String) g.e(networkModule.keyInflection());
    }

    public String get() {
        return keyInflection(this.module);
    }
}
