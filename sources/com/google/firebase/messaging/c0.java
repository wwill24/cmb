package com.google.firebase.messaging;

public final /* synthetic */ class c0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SharedPreferencesQueue f21104a;

    public /* synthetic */ c0(SharedPreferencesQueue sharedPreferencesQueue) {
        this.f21104a = sharedPreferencesQueue;
    }

    public final void run() {
        this.f21104a.syncState();
    }
}
