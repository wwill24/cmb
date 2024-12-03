package com.withpersona.sdk2.inquiry.network;

import com.squareup.moshi.h;
import fj.d;
import fj.g;
import java.util.Set;

public final class NetworkModule_Companion_ProvideMoshiJsonAdapterFactoryFactory implements d<Set<h.e>> {

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final NetworkModule_Companion_ProvideMoshiJsonAdapterFactoryFactory INSTANCE = new NetworkModule_Companion_ProvideMoshiJsonAdapterFactoryFactory();

        private InstanceHolder() {
        }
    }

    public static NetworkModule_Companion_ProvideMoshiJsonAdapterFactoryFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Set<h.e> provideMoshiJsonAdapterFactory() {
        return (Set) g.e(NetworkModule.Companion.provideMoshiJsonAdapterFactory());
    }

    public Set<h.e> get() {
        return provideMoshiJsonAdapterFactory();
    }
}
