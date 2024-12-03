package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class w implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12593a;

    public /* synthetic */ w(Function1 function1) {
        this.f12593a = function1;
    }

    public final void accept(Object obj) {
        LikesYouMatchRepository.w(this.f12593a, obj);
    }
}
