package com.google.firebase.remoteconfig;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;

public final /* synthetic */ class n implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Qualified f21231a;

    public /* synthetic */ n(Qualified qualified) {
        this.f21231a = qualified;
    }

    public final Object create(ComponentContainer componentContainer) {
        return RemoteConfigRegistrar.lambda$getComponents$0(this.f21231a, componentContainer);
    }
}
