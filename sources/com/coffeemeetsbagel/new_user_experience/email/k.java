package com.coffeemeetsbagel.new_user_experience.email;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class k implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f34976a;

    public /* synthetic */ k(Function1 function1) {
        this.f34976a = function1;
    }

    public final void accept(Object obj) {
        EmailPresenter.q(this.f34976a, obj);
    }
}
