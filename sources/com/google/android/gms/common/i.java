package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import com.google.android.gms.internal.base.zau;

@SuppressLint({"HandlerLeak"})
final class i extends zau {

    /* renamed from: a  reason: collision with root package name */
    private final Context f38902a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ c f38903b;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public i(com.google.android.gms.common.c r1, android.content.Context r2) {
        /*
            r0 = this;
            r0.f38903b = r1
            android.os.Looper r1 = android.os.Looper.myLooper()
            if (r1 != 0) goto L_0x000d
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            goto L_0x0011
        L_0x000d:
            android.os.Looper r1 = android.os.Looper.myLooper()
        L_0x0011:
            r0.<init>(r1)
            android.content.Context r1 = r2.getApplicationContext()
            r0.f38902a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.i.<init>(com.google.android.gms.common.c, android.content.Context):void");
    }

    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 != 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Don't know how to handle this message: ");
            sb2.append(i10);
            return;
        }
        int i11 = this.f38903b.i(this.f38902a);
        if (this.f38903b.m(i11)) {
            this.f38903b.r(this.f38902a, i11);
        }
    }
}
