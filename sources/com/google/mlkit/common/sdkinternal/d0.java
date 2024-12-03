package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final /* synthetic */ class d0 implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ d0 f21398a = new d0();

    private /* synthetic */ d0() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new m((Context) componentContainer.get(Context.class));
    }
}
