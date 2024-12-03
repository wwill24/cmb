package com.android.billingclient.api;

import java.util.concurrent.Callable;

public final /* synthetic */ class z implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f9050a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f9051b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f9052c;

    public /* synthetic */ z(f fVar, String str, String str2) {
        this.f9050a = fVar;
        this.f9051b = str;
        this.f9052c = str2;
    }

    public final Object call() {
        return this.f9050a.D(this.f9051b, this.f9052c);
    }
}
