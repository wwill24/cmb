package com.facebook.gamingservices;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.bolts.TaskCompletionSource;

public final /* synthetic */ class g implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f37835a;

    public /* synthetic */ g(TaskCompletionSource taskCompletionSource) {
        this.f37835a = taskCompletionSource;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        TournamentFetcher.m107fetchTournaments$lambda1(this.f37835a, graphResponse);
    }
}
