package com.google.android.gms.cloudmessaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f38443a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f38444b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f38445c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f38446d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BroadcastReceiver.PendingResult f38447e;

    public /* synthetic */ h(a aVar, Intent intent, Context context, boolean z10, BroadcastReceiver.PendingResult pendingResult) {
        this.f38443a = aVar;
        this.f38444b = intent;
        this.f38445c = context;
        this.f38446d = z10;
        this.f38447e = pendingResult;
    }

    public final void run() {
        this.f38443a.zza(this.f38444b, this.f38445c, this.f38446d, this.f38447e);
    }
}
