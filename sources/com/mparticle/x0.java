package com.mparticle;

import android.content.Context;
import android.os.HandlerThread;
import com.mparticle.MParticle;

public final /* synthetic */ class x0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f22649a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MParticle.ResetListener f22650b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HandlerThread f22651c;

    public /* synthetic */ x0(Context context, MParticle.ResetListener resetListener, HandlerThread handlerThread) {
        this.f22649a = context;
        this.f22650b = resetListener;
        this.f22651c = handlerThread;
    }

    public final void run() {
        MParticle.lambda$reset$0(this.f22649a, this.f22650b, this.f22651c);
    }
}
