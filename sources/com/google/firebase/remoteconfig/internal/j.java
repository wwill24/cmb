package com.google.firebase.remoteconfig.internal;

import me.d;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f21218a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f21219b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ConfigContainer f21220c;

    public /* synthetic */ j(d dVar, String str, ConfigContainer configContainer) {
        this.f21218a = dVar;
        this.f21219b = str;
        this.f21220c = configContainer;
    }

    public final void run() {
        this.f21218a.accept(this.f21219b, this.f21220c);
    }
}
