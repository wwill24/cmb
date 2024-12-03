package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.base.zau;

final class s2 extends zau {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u2 f38740a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s2(u2 u2Var, Looper looper) {
        super(looper);
        this.f38740a = u2Var;
    }

    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            f fVar = (f) message.obj;
            synchronized (this.f38740a.f38772e) {
                u2 u2Var = (u2) p.k(this.f38740a.f38769b);
                if (fVar == null) {
                    u2Var.l(new Status(13, "Transform returned null"));
                } else if (fVar instanceof k2) {
                    u2Var.l(((k2) fVar).a());
                } else {
                    u2Var.k(fVar);
                }
            }
        } else if (i10 != 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("TransformationResultHandler received unknown message type: ");
            sb2.append(i10);
        } else {
            RuntimeException runtimeException = (RuntimeException) message.obj;
            "Runtime exception on the transformation worker thread: ".concat(String.valueOf(runtimeException.getMessage()));
            throw runtimeException;
        }
    }
}
