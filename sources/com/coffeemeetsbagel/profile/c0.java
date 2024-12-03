package com.coffeemeetsbagel.profile;

import com.coffeemeetsbagel.models.Bagel;

public final /* synthetic */ class c0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileView f36080a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bagel.STAMP f36081b;

    public /* synthetic */ c0(ProfileView profileView, Bagel.STAMP stamp) {
        this.f36080a = profileView;
        this.f36081b = stamp;
    }

    public final void run() {
        this.f36080a.K(this.f36081b);
    }
}
