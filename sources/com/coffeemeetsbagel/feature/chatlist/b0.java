package com.coffeemeetsbagel.feature.chatlist;

import com.coffeemeetsbagel.models.enums.EventType;

public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g0 f12896a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EventType f12897b;

    public /* synthetic */ b0(g0 g0Var, EventType eventType) {
        this.f12896a = g0Var;
        this.f12897b = eventType;
    }

    public final void run() {
        this.f12896a.G1(this.f12897b);
    }
}
