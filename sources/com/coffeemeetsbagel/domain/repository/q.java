package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class q implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12559a;

    public /* synthetic */ q(Function1 function1) {
        this.f12559a = function1;
    }

    public final Object apply(Object obj) {
        return LikesYouMatchRepository.z(this.f12559a, obj);
    }
}
