package com.facebook.appevents.cloudbridge;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

public final /* synthetic */ class a implements GraphRequest.Callback {
    public final void onCompleted(GraphResponse graphResponse) {
        AppEventsCAPIManager.m56enable$lambda0(graphResponse);
    }
}
