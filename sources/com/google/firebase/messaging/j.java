package com.google.firebase.messaging;

import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;

public final /* synthetic */ class j implements FirebaseInstanceIdInternal.NewTokenListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f21123a;

    public /* synthetic */ j(FirebaseMessaging firebaseMessaging) {
        this.f21123a = firebaseMessaging;
    }

    public final void onNewToken(String str) {
        this.f21123a.lambda$new$0(str);
    }
}
