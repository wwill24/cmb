package com.coffeemeetsbagel.bakery;

import a6.a;
import com.coffeemeetsbagel.feature.profile.ProfileManager;
import fj.d;
import fj.g;

public final class v implements d<a> {

    /* renamed from: a  reason: collision with root package name */
    private final fk.a<ProfileManager> f11384a;

    public v(fk.a<ProfileManager> aVar) {
        this.f11384a = aVar;
    }

    public static a a(ProfileManager profileManager) {
        return (a) g.e(c.s(profileManager));
    }

    public static v b(fk.a<ProfileManager> aVar) {
        return new v(aVar);
    }

    /* renamed from: c */
    public a get() {
        return a(this.f11384a.get());
    }
}
