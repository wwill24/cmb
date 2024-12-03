package com.google.firebase.sessions;

import android.content.Context;
import com.google.firebase.FirebaseAppLifecycleListener;
import com.google.firebase.FirebaseOptions;

public final /* synthetic */ class b implements FirebaseAppLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f21233a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SessionInitiator f21234b;

    public /* synthetic */ b(Context context, SessionInitiator sessionInitiator) {
        this.f21233a = context;
        this.f21234b = sessionInitiator;
    }

    public final void onDeleted(String str, FirebaseOptions firebaseOptions) {
        FirebaseSessions.m3_init_$lambda0(this.f21233a, this.f21234b, str, firebaseOptions);
    }
}
