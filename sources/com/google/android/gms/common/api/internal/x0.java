package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.base.zau;

final class x0 extends zau {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ z0 f38802a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    x0(z0 z0Var, Looper looper) {
        super(looper);
        this.f38802a = z0Var;
    }

    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            z0.z(this.f38802a);
        } else if (i10 != 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unknown message id: ");
            sb2.append(i10);
        } else {
            z0.y(this.f38802a);
        }
    }
}
