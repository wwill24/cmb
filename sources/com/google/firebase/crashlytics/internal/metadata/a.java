package com.google.firebase.crashlytics.internal.metadata;

import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserMetadata f21022a;

    public /* synthetic */ a(UserMetadata userMetadata) {
        this.f21022a = userMetadata;
    }

    public final Object call() {
        return this.f21022a.lambda$setUserId$0();
    }
}
