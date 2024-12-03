package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserMetadata.SerializeableKeysMap f21023a;

    public /* synthetic */ b(UserMetadata.SerializeableKeysMap serializeableKeysMap) {
        this.f21023a = serializeableKeysMap;
    }

    public final Object call() {
        return this.f21023a.lambda$scheduleSerializationTaskIfNeeded$0();
    }
}
