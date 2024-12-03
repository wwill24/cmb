package com.google.firebase;

import android.content.Context;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class a implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseApp f20934a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f20935b;

    public /* synthetic */ a(FirebaseApp firebaseApp, Context context) {
        this.f20934a = firebaseApp;
        this.f20935b = context;
    }

    public final Object get() {
        return this.f20934a.lambda$new$0(this.f20935b);
    }
}
