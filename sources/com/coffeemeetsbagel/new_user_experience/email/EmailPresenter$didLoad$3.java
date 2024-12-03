package com.coffeemeetsbagel.new_user_experience.email;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class EmailPresenter$didLoad$3 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ EmailPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EmailPresenter$didLoad$3(EmailPresenter emailPresenter) {
        super(1);
        this.this$0 = emailPresenter;
    }

    public final void a(String str) {
        this.this$0.u().L0(str);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((String) obj);
        return Unit.f32013a;
    }
}
