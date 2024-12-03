package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class k implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentRegistrar f20949a;

    public /* synthetic */ k(ComponentRegistrar componentRegistrar) {
        this.f20949a = componentRegistrar;
    }

    public final Object get() {
        return ComponentRuntime.lambda$toProviders$1(this.f20949a);
    }
}
