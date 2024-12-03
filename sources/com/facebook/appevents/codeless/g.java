package com.facebook.appevents.codeless;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.codeless.ViewIndexer;

public final /* synthetic */ class g implements GraphRequest.Callback {
    public final void onCompleted(GraphResponse graphResponse) {
        ViewIndexer.Companion.m65buildAppIndexingRequest$lambda0(graphResponse);
    }
}
