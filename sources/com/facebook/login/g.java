package com.facebook.login;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

public final /* synthetic */ class g implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceAuthDialog f37894a;

    public /* synthetic */ g(DeviceAuthDialog deviceAuthDialog) {
        this.f37894a = deviceAuthDialog;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        DeviceAuthDialog.m158startLogin$lambda1(this.f37894a, graphResponse);
    }
}
