package com.coffeemeetsbagel.fragments;

import com.coffeemeetsbagel.models.dto.Option;
import java.util.Map;
import java.util.function.Consumer;

public final /* synthetic */ class w3 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f13864a;

    public /* synthetic */ w3(Map map) {
        this.f13864a = map;
    }

    public final void accept(Object obj) {
        FragmentMyProfileDetails.r3(this.f13864a, (Option) obj);
    }
}
