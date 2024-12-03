package com.leanplum;

import com.leanplum.callbacks.ForceContentUpdateCallback;

public final /* synthetic */ class a implements ForceContentUpdateCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActionContext f22183a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22184b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f22185c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f22186d;

    public /* synthetic */ a(ActionContext actionContext, String str, String str2, boolean z10) {
        this.f22183a = actionContext;
        this.f22184b = str;
        this.f22185c = str2;
        this.f22186d = z10;
    }

    public final void onContentUpdated(boolean z10) {
        this.f22183a.lambda$performChainedAction$0(this.f22184b, this.f22185c, this.f22186d, z10);
    }
}
