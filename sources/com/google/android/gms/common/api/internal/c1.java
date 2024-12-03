package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.base.zau;

final class c1 extends zau {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d1 f38562a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    c1(d1 d1Var, Looper looper) {
        super(looper);
        this.f38562a = d1Var;
    }

    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            ((b1) message.obj).b(this.f38562a);
        } else if (i10 != 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unknown message id: ");
            sb2.append(i10);
        } else {
            throw ((RuntimeException) message.obj);
        }
    }
}
