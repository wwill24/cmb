package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class l implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f21125a;

    public /* synthetic */ l(FirebaseMessaging firebaseMessaging) {
        this.f21125a = firebaseMessaging;
    }

    public final void onSuccess(Object obj) {
        this.f21125a.lambda$new$2((TopicsSubscriber) obj);
    }
}
