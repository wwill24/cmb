package com.mparticle.kits;

import com.mparticle.internal.KitsLoadedCallback;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KitManagerImpl f22600a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KitsLoadedCallback f22601b;

    public /* synthetic */ e(KitManagerImpl kitManagerImpl, KitsLoadedCallback kitsLoadedCallback) {
        this.f22600a = kitManagerImpl;
        this.f22601b = kitsLoadedCallback;
    }

    public final void run() {
        this.f22600a.lambda$updateKits$0(this.f22601b);
    }
}
