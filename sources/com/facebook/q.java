package com.facebook;

import com.facebook.GraphRequest;
import java.util.ArrayList;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArrayList f37925a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GraphRequestBatch f37926b;

    public /* synthetic */ q(ArrayList arrayList, GraphRequestBatch graphRequestBatch) {
        this.f37925a = arrayList;
        this.f37926b = graphRequestBatch;
    }

    public final void run() {
        GraphRequest.Companion.m30runCallbacks$lambda2(this.f37925a, this.f37926b);
    }
}
