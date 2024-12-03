package com.google.mlkit.vision.text.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.d;

public final /* synthetic */ class n implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ n f21602a = new n();

    private /* synthetic */ n() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new j((k) componentContainer.get(k.class), (d) componentContainer.get(d.class));
    }
}
