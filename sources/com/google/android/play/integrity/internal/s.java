package com.google.android.play.integrity.internal;

final class s extends o {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ z f20524f;

    s(z zVar) {
        this.f20524f = zVar;
    }

    public final void b() {
        z zVar = this.f20524f;
        if (zVar.f20542m != null) {
            zVar.f20531b.d("Unbind from service.", new Object[0]);
            z zVar2 = this.f20524f;
            zVar2.f20530a.unbindService(zVar2.f20541l);
            this.f20524f.f20536g = false;
            this.f20524f.f20542m = null;
            this.f20524f.f20541l = null;
        }
        this.f20524f.t();
    }
}
