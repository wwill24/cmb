package com.google.firebase.installations;

import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class e implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseApp f21090a;

    public /* synthetic */ e(FirebaseApp firebaseApp) {
        this.f21090a = firebaseApp;
    }

    public final Object get() {
        return FirebaseInstallations.lambda$new$0(this.f21090a);
    }
}
