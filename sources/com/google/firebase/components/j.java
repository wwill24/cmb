package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LazySet f20947a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Provider f20948b;

    public /* synthetic */ j(LazySet lazySet, Provider provider) {
        this.f20947a = lazySet;
        this.f20948b = provider;
    }

    public final void run() {
        this.f20947a.add(this.f20948b);
    }
}
