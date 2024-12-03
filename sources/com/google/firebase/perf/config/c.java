package com.google.firebase.perf.config;

import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class c implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RemoteConfigManager f21146a;

    public /* synthetic */ c(RemoteConfigManager remoteConfigManager) {
        this.f21146a = remoteConfigManager;
    }

    public final void onFailure(Exception exc) {
        this.f21146a.lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$1(exc);
    }
}
