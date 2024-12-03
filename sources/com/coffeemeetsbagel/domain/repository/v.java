package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class v implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12589a;

    public /* synthetic */ v(Function1 function1) {
        this.f12589a = function1;
    }

    public final Object apply(Object obj) {
        return LikesYouMatchRepository.v(this.f12589a, obj);
    }
}
