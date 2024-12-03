package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class q implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Deferred.DeferredHandler f20953a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Deferred.DeferredHandler f20954b;

    public /* synthetic */ q(Deferred.DeferredHandler deferredHandler, Deferred.DeferredHandler deferredHandler2) {
        this.f20953a = deferredHandler;
        this.f20954b = deferredHandler2;
    }

    public final void handle(Provider provider) {
        OptionalProvider.lambda$whenAvailable$2(this.f20953a, this.f20954b, provider);
    }
}
