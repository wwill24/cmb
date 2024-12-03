package com.coffeemeetsbagel.new_user_experience.notification;

import kotlin.jvm.functions.Function1;
import vj.f;

public final /* synthetic */ class h implements f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f35547a;

    public /* synthetic */ h(Function1 function1) {
        this.f35547a = function1;
    }

    public final void accept(Object obj) {
        NotificationPresenter.k(this.f35547a, obj);
    }
}
