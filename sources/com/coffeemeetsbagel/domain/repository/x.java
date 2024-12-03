package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class x implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12597a;

    public /* synthetic */ x(Function1 function1) {
        this.f12597a = function1;
    }

    public final void accept(Object obj) {
        LikesYouMatchRepository.R(this.f12597a, obj);
    }
}
