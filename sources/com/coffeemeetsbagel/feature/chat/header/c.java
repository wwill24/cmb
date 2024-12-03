package com.coffeemeetsbagel.feature.chat.header;

import java.util.concurrent.Callable;

public final /* synthetic */ class c implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatHeaderInteractor f12845a;

    public /* synthetic */ c(ChatHeaderInteractor chatHeaderInteractor) {
        this.f12845a = chatHeaderInteractor;
    }

    public final Object call() {
        return ChatHeaderInteractor.S1(this.f12845a);
    }
}
