package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import l3.c;

class s {

    /* renamed from: a  reason: collision with root package name */
    private boolean f9438a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f9439b = new Handler(Looper.getMainLooper(), new a());

    private static final class a implements Handler.Callback {
        a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((c) message.obj).a();
            return true;
        }
    }

    s() {
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(c<?> cVar, boolean z10) {
        if (!this.f9438a) {
            if (!z10) {
                this.f9438a = true;
                cVar.a();
                this.f9438a = false;
            }
        }
        this.f9439b.obtainMessage(1, cVar).sendToTarget();
    }
}
