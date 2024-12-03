package com.google.firebase.perf.config;

import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class b implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RemoteConfigManager f21145a;

    public /* synthetic */ b(RemoteConfigManager remoteConfigManager) {
        this.f21145a = remoteConfigManager;
    }

    public final void onSuccess(Object obj) {
        this.f21145a.lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$0((Boolean) obj);
    }
}
