package com.facebook.gamingservices;

import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;

public final /* synthetic */ class d implements DaemonRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContextCreateDialog f37831a;

    public /* synthetic */ d(ContextCreateDialog contextCreateDialog) {
        this.f37831a = contextCreateDialog;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        ContextCreateDialog.m104showForCloud$lambda2(this.f37831a, graphResponse);
    }
}
