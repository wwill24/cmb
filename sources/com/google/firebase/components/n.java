package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import java.util.Map;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map.Entry f20951a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Event f20952b;

    public /* synthetic */ n(Map.Entry entry, Event event) {
        this.f20951a = entry;
        this.f20952b = event;
    }

    public final void run() {
        ((EventHandler) this.f20951a.getKey()).handle(this.f20952b);
    }
}
