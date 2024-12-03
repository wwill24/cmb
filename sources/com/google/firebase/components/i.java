package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class i implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentRuntime f20945a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Component f20946b;

    public /* synthetic */ i(ComponentRuntime componentRuntime, Component component) {
        this.f20945a = componentRuntime;
        this.f20946b = component;
    }

    public final Object get() {
        return this.f20945a.lambda$discoverComponents$0(this.f20946b);
    }
}
