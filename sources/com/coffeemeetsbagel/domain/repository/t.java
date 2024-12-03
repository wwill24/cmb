package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class t implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12575a;

    public /* synthetic */ t(Function1 function1) {
        this.f12575a = function1;
    }

    public final Object apply(Object obj) {
        return LikesYouMatchRepository.H(this.f12575a, obj);
    }
}
