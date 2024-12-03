package com.facebook;

import com.facebook.GraphRequest;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class b implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f37774a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Set f37775b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Set f37776c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Set f37777d;

    public /* synthetic */ b(AtomicBoolean atomicBoolean, Set set, Set set2, Set set3) {
        this.f37774a = atomicBoolean;
        this.f37775b = set;
        this.f37776c = set2;
        this.f37777d = set3;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        AccessTokenManager.m13refreshCurrentAccessTokenImpl$lambda1(this.f37774a, this.f37775b, this.f37776c, this.f37777d, graphResponse);
    }
}
