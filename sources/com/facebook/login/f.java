package com.facebook.login;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

public final /* synthetic */ class f implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceAuthDialog f37893a;

    public /* synthetic */ f(DeviceAuthDialog deviceAuthDialog) {
        this.f37893a = deviceAuthDialog;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        DeviceAuthDialog.m152_get_pollRequest_$lambda5(this.f37893a, graphResponse);
    }
}
