package com.coffeemeetsbagel.feature.bagel;

import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.NetworkProfile;
import java.util.Map;
import java.util.function.Consumer;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f12711a;

    public /* synthetic */ g(Map map) {
        this.f12711a = map;
    }

    public final void accept(Object obj) {
        ((Bagel) obj).setProfile((NetworkProfile) this.f12711a.get(((Bagel) obj).getProfileId()));
    }
}
