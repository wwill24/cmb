package com.coffeemeetsbagel.new_user_experience.birthday;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import na.b;

final class BirthdayInteractor$onNextButtonClick$2 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ BirthdayInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BirthdayInteractor$onNextButtonClick$2(BirthdayInteractor birthdayInteractor) {
        super(1);
        this.this$0 = birthdayInteractor;
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String J1 = this.this$0.f34908f;
        j.f(th2, "it");
        String str = "failed to update user's birthday";
        aVar.c(J1, str, th2);
        b K1 = this.this$0.K1();
        String message = th2.getMessage();
        if (message != null) {
            str = message;
        }
        K1.onError(str);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
