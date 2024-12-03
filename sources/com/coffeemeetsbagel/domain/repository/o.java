package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function2;
import vj.c;

public final /* synthetic */ class o implements c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function2 f12551a;

    public /* synthetic */ o(Function2 function2) {
        this.f12551a = function2;
    }

    public final Object apply(Object obj, Object obj2) {
        return LikesYouMatchRepository.C(this.f12551a, obj, obj2);
    }
}
