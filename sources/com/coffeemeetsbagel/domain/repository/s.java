package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class s implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12570a;

    public /* synthetic */ s(Function1 function1) {
        this.f12570a = function1;
    }

    public final Object apply(Object obj) {
        return LikesYouMatchRepository.O(this.f12570a, obj);
    }
}
