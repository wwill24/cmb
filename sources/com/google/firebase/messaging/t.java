package com.google.firebase.messaging;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.messaging.FirebaseMessaging;

public final /* synthetic */ class t implements EventHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging.AutoInit f21137a;

    public /* synthetic */ t(FirebaseMessaging.AutoInit autoInit) {
        this.f21137a = autoInit;
    }

    public final void handle(Event event) {
        this.f21137a.lambda$initialize$0(event);
    }
}
