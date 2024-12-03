package com.google.firebase.sessions;

import cd.d;

public final /* synthetic */ class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventGDTLogger f21232a;

    public /* synthetic */ a(EventGDTLogger eventGDTLogger) {
        this.f21232a = eventGDTLogger;
    }

    public final Object apply(Object obj) {
        return this.f21232a.encode((SessionEvent) obj);
    }
}
