package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.Store;

public final /* synthetic */ class i implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f21120a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f21121b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Store.Token f21122c;

    public /* synthetic */ i(FirebaseMessaging firebaseMessaging, String str, Store.Token token) {
        this.f21120a = firebaseMessaging;
        this.f21121b = str;
        this.f21122c = token;
    }

    public final Task then(Object obj) {
        return this.f21120a.lambda$blockingGetToken$9(this.f21121b, this.f21122c, (String) obj);
    }
}
