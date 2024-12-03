package com.google.android.gms.cloudmessaging;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.cloudmessaging.zzf;

final class e extends zzf {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f38442a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    e(c cVar, Looper looper) {
        super(looper);
        this.f38442a = cVar;
    }

    public final void handleMessage(Message message) {
        c.d(this.f38442a, message);
    }
}
