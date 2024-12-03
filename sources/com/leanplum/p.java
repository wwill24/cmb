package com.leanplum;

import android.os.Bundle;
import com.leanplum.LeanplumActivityHelper;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LeanplumActivityHelper.NoTrampolinesLifecycleCallbacks f22220a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bundle f22221b;

    public /* synthetic */ p(LeanplumActivityHelper.NoTrampolinesLifecycleCallbacks noTrampolinesLifecycleCallbacks, Bundle bundle) {
        this.f22220a = noTrampolinesLifecycleCallbacks;
        this.f22221b = bundle;
    }

    public final void run() {
        this.f22220a.lambda$onActivityResumed$0(this.f22221b);
    }
}
