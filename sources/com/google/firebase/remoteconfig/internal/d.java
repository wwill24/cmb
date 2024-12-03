package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class d implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfigCacheClient f21202a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f21203b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ConfigContainer f21204c;

    public /* synthetic */ d(ConfigCacheClient configCacheClient, boolean z10, ConfigContainer configContainer) {
        this.f21202a = configCacheClient;
        this.f21203b = z10;
        this.f21204c = configContainer;
    }

    public final Task then(Object obj) {
        return this.f21202a.lambda$put$1(this.f21203b, this.f21204c, (Void) obj);
    }
}
