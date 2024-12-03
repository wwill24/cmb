package com.facebook.gamingservices;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.bolts.TaskCompletionSource;

public final /* synthetic */ class j implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f37841a;

    public /* synthetic */ j(TaskCompletionSource taskCompletionSource) {
        this.f37841a = taskCompletionSource;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        TournamentUpdater.m110update$lambda0(this.f37841a, graphResponse);
    }
}
