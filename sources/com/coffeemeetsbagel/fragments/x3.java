package com.coffeemeetsbagel.fragments;

import com.coffeemeetsbagel.models.dto.Answer;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public final /* synthetic */ class x3 implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map f13887a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f13888b;

    public /* synthetic */ x3(Map map, List list) {
        this.f13887a = map;
        this.f13888b = list;
    }

    public final void accept(Object obj) {
        FragmentMyProfileDetails.s3(this.f13887a, this.f13888b, (Answer) obj);
    }
}
