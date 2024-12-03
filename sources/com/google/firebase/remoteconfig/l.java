package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.Personalization;
import me.d;

public final /* synthetic */ class l implements d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Personalization f21229a;

    public /* synthetic */ l(Personalization personalization) {
        this.f21229a = personalization;
    }

    public final void accept(Object obj, Object obj2) {
        this.f21229a.logArmActive((String) obj, (ConfigContainer) obj2);
    }
}
