package com.leanplum;

import java.util.Map;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f22192a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f22193b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f22194c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f22195d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f22196e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f22197f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Map f22198g;

    public /* synthetic */ g(String str, String str2, long j10, String str3, String str4, String str5, Map map) {
        this.f22192a = str;
        this.f22193b = str2;
        this.f22194c = j10;
        this.f22195d = str3;
        this.f22196e = str4;
        this.f22197f = str5;
        this.f22198g = map;
    }

    public final void run() {
        Leanplum.lambda$trackGooglePlayPurchase$6(this.f22192a, this.f22193b, this.f22194c, this.f22195d, this.f22196e, this.f22197f, this.f22198g);
    }
}
