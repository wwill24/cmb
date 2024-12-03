package com.facebook.gamingservices;

import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;

public final /* synthetic */ class f implements DaemonRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContextSwitchDialog f37834a;

    public /* synthetic */ f(ContextSwitchDialog contextSwitchDialog) {
        this.f37834a = contextSwitchDialog;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        ContextSwitchDialog.m106showForCloud$lambda2(this.f37834a, graphResponse);
    }
}
