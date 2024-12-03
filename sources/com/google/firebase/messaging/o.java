package com.google.firebase.messaging;

import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.RequestDeduplicator;
import com.google.firebase.messaging.Store;

public final /* synthetic */ class o implements RequestDeduplicator.GetTokenRequest {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f21128a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f21129b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Store.Token f21130c;

    public /* synthetic */ o(FirebaseMessaging firebaseMessaging, String str, Store.Token token) {
        this.f21128a = firebaseMessaging;
        this.f21129b = str;
        this.f21130c = token;
    }

    public final Task start() {
        return this.f21128a.lambda$blockingGetToken$10(this.f21129b, this.f21130c);
    }
}
