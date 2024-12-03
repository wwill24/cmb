package com.coffeemeetsbagel.domain.repository;

import kotlin.jvm.functions.Function1;
import vj.j;

public final /* synthetic */ class p0 implements j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f12556a;

    public /* synthetic */ p0(Function1 function1) {
        this.f12556a = function1;
    }

    public final Object apply(Object obj) {
        return SkuDetailsRepository.j(this.f12556a, obj);
    }
}
