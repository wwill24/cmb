package com.google.firebase;

import com.google.firebase.FirebaseApp;

public final /* synthetic */ class b implements FirebaseApp.BackgroundStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseApp f20936a;

    public /* synthetic */ b(FirebaseApp firebaseApp) {
        this.f20936a = firebaseApp;
    }

    public final void onBackgroundStateChanged(boolean z10) {
        this.f20936a.lambda$new$1(z10);
    }
}
