package com.coffeemeetsbagel.fragments;

import com.coffeemeetsbagel.models.dto.Option;
import java.util.Map;
import java.util.function.Consumer;

public final /* synthetic */ class z3 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f13905a;

    public /* synthetic */ z3(Map map) {
        this.f13905a = map;
    }

    public final void accept(Object obj) {
        FragmentMyProfileDetails.a3(this.f13905a, (Option) obj);
    }
}
