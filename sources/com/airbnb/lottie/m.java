package com.airbnb.lottie;

import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class m implements e0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f8608a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f8609b;

    public /* synthetic */ m(String str, AtomicBoolean atomicBoolean) {
        this.f8608a = str;
        this.f8609b = atomicBoolean;
    }

    public final void onResult(Object obj) {
        p.C(this.f8608a, this.f8609b, (Throwable) obj);
    }
}
