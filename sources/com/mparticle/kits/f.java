package com.mparticle.kits;

import com.mparticle.internal.KitsLoadedCallback;
import org.json.a;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ KitManagerImpl f22602a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f22603b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ KitsLoadedCallback f22604c;

    public /* synthetic */ f(KitManagerImpl kitManagerImpl, a aVar, KitsLoadedCallback kitsLoadedCallback) {
        this.f22602a = kitManagerImpl;
        this.f22603b = aVar;
        this.f22604c = kitsLoadedCallback;
    }

    public final void run() {
        this.f22602a.lambda$updateKits$1(this.f22603b, this.f22604c);
    }
}
