package com.android.billingclient.api;

import android.os.Bundle;
import java.util.concurrent.Callable;

public final /* synthetic */ class y implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f9044a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f9045b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f9046c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f9047d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ h f9048e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Bundle f9049f;

    public /* synthetic */ y(f fVar, int i10, String str, String str2, h hVar, Bundle bundle) {
        this.f9044a = fVar;
        this.f9045b = i10;
        this.f9046c = str;
        this.f9047d = str2;
        this.f9048e = hVar;
        this.f9049f = bundle;
    }

    public final Object call() {
        return this.f9044a.C(this.f9045b, this.f9046c, this.f9047d, this.f9048e, this.f9049f);
    }
}
