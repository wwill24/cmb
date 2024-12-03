package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OptionalProvider f20943a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Provider f20944b;

    public /* synthetic */ h(OptionalProvider optionalProvider, Provider provider) {
        this.f20943a = optionalProvider;
        this.f20944b = provider;
    }

    public final void run() {
        this.f20943a.set(this.f20944b);
    }
}
