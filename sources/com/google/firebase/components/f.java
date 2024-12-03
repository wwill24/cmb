package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class f implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f20942a;

    public /* synthetic */ f(String str) {
        this.f20942a = str;
    }

    public final Object get() {
        return ComponentDiscovery.instantiate(this.f20942a);
    }
}
