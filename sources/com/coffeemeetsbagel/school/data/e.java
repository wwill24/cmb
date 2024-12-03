package com.coffeemeetsbagel.school.data;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class e implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f36365a;

    public /* synthetic */ e(Function1 function1) {
        this.f36365a = function1;
    }

    public final void accept(Object obj) {
        SchoolRepository.k(this.f36365a, obj);
    }
}
