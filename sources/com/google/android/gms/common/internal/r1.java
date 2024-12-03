package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;

final class r1 implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ s1 f39046a;

    /* synthetic */ r1(s1 s1Var, q1 q1Var) {
        this.f39046a = s1Var;
    }

    public final boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            synchronized (this.f39046a.f39050f) {
                n1 n1Var = (n1) message.obj;
                p1 p1Var = (p1) this.f39046a.f39050f.get(n1Var);
                if (p1Var != null && p1Var.i()) {
                    if (p1Var.j()) {
                        p1Var.g("GmsClientSupervisor");
                    }
                    this.f39046a.f39050f.remove(n1Var);
                }
            }
            return true;
        } else if (i10 != 1) {
            return false;
        } else {
            synchronized (this.f39046a.f39050f) {
                n1 n1Var2 = (n1) message.obj;
                p1 p1Var2 = (p1) this.f39046a.f39050f.get(n1Var2);
                if (p1Var2 != null && p1Var2.a() == 3) {
                    String valueOf = String.valueOf(n1Var2);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Timeout waiting for ServiceConnection callback ");
                    sb2.append(valueOf);
                    new Exception();
                    ComponentName b10 = p1Var2.b();
                    if (b10 == null) {
                        b10 = n1Var2.b();
                    }
                    if (b10 == null) {
                        String d10 = n1Var2.d();
                        p.k(d10);
                        b10 = new ComponentName(d10, "unknown");
                    }
                    p1Var2.onServiceDisconnected(b10);
                }
            }
            return true;
        }
    }
}
