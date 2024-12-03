package com.google.android.play.integrity.internal;

import android.os.IBinder;

final class u extends o {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ IBinder f20525f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ y f20526g;

    u(y yVar, IBinder iBinder) {
        this.f20526g = yVar;
        this.f20525f = iBinder;
    }

    public final void b() {
        this.f20526g.f20528a.f20542m = j.c(this.f20525f);
        z.n(this.f20526g.f20528a);
        this.f20526g.f20528a.f20536g = false;
        for (Runnable run : this.f20526g.f20528a.f20533d) {
            run.run();
        }
        this.f20526g.f20528a.f20533d.clear();
    }
}
