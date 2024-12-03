package com.coffeemeetsbagel.activities;

import android.app.Activity;
import android.content.Intent;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivityLogin f10936a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f10937b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Intent f10938c;

    public /* synthetic */ n(ActivityLogin activityLogin, Activity activity, Intent intent) {
        this.f10936a = activityLogin;
        this.f10937b = activity;
        this.f10938c = intent;
    }

    public final void run() {
        this.f10936a.f1(this.f10937b, this.f10938c);
    }
}
