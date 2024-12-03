package com.coffeemeetsbagel.feature.chatlist;

import java.util.concurrent.Callable;

public final /* synthetic */ class w0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GetBagelUseCase f12989a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f12990b;

    public /* synthetic */ w0(GetBagelUseCase getBagelUseCase, String str) {
        this.f12989a = getBagelUseCase;
        this.f12990b = str;
    }

    public final Object call() {
        return GetBagelUseCase.f(this.f12989a, this.f12990b);
    }
}
