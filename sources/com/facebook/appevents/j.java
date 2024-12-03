package com.facebook.appevents;

import android.content.Context;
import com.facebook.appevents.AppEventsLoggerImpl;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f37764a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppEventsLoggerImpl f37765b;

    public /* synthetic */ j(Context context, AppEventsLoggerImpl appEventsLoggerImpl) {
        this.f37764a = context;
        this.f37765b = appEventsLoggerImpl;
    }

    public final void run() {
        AppEventsLoggerImpl.Companion.m43initializeLib$lambda4(this.f37764a, this.f37765b);
    }
}
