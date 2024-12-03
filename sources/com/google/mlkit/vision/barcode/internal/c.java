package com.google.mlkit.vision.barcode.internal;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.mlkit.common.sdkinternal.d;

public final /* synthetic */ class c implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ c f21483a = new c();

    private /* synthetic */ c() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new d((e) componentContainer.get(e.class), (d) componentContainer.get(d.class));
    }
}
