package com.facebook.gamingservices;

import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;

public final /* synthetic */ class a implements DaemonRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContextChooseDialog f37826a;

    public /* synthetic */ a(ContextChooseDialog contextChooseDialog) {
        this.f37826a = contextChooseDialog;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        ContextChooseDialog.m102showForCloud$lambda2(this.f37826a, graphResponse);
    }
}
