package com.google.firebase.messaging;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

public final /* synthetic */ class d0 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f21108a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ScheduledExecutorService f21109b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f21110c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Metadata f21111d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ GmsRpc f21112e;

    public /* synthetic */ d0(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseMessaging firebaseMessaging, Metadata metadata, GmsRpc gmsRpc) {
        this.f21108a = context;
        this.f21109b = scheduledExecutorService;
        this.f21110c = firebaseMessaging;
        this.f21111d = metadata;
        this.f21112e = gmsRpc;
    }

    public final Object call() {
        return TopicsSubscriber.lambda$createInstance$0(this.f21108a, this.f21109b, this.f21110c, this.f21111d, this.f21112e);
    }
}
