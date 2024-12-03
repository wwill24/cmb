package com.leanplum;

import com.leanplum.callbacks.ForceContentUpdateCallback;
import com.leanplum.callbacks.VariablesChangedCallback;

public final /* synthetic */ class f implements ForceContentUpdateCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VariablesChangedCallback f22190a;

    public /* synthetic */ f(VariablesChangedCallback variablesChangedCallback) {
        this.f22190a = variablesChangedCallback;
    }

    public final void onContentUpdated(boolean z10) {
        Leanplum.lambda$forceContentUpdate$8(this.f22190a, z10);
    }
}
