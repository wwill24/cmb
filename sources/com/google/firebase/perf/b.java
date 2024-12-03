package com.google.firebase.perf;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;

public final /* synthetic */ class b implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Qualified f21142a;

    public /* synthetic */ b(Qualified qualified) {
        this.f21142a = qualified;
    }

    public final Object create(ComponentContainer componentContainer) {
        return FirebasePerfRegistrar.lambda$getComponents$0(this.f21142a, componentContainer);
    }
}
