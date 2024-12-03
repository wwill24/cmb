package com.google.firebase.perf;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final /* synthetic */ class a implements ComponentFactory {
    public final Object create(ComponentContainer componentContainer) {
        return FirebasePerfRegistrar.providesFirebasePerformance(componentContainer);
    }
}
