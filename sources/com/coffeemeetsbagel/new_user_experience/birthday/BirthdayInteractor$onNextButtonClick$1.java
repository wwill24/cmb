package com.coffeemeetsbagel.new_user_experience.birthday;

import com.coffeemeetsbagel.models.NetworkProfile;
import gk.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class BirthdayInteractor$onNextButtonClick$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ String $dateString;
    final /* synthetic */ BirthdayInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BirthdayInteractor$onNextButtonClick$1(BirthdayInteractor birthdayInteractor, String str) {
        super(1);
        this.this$0 = birthdayInteractor;
        this.$dateString = str;
    }

    public final void a(Integer num) {
        NetworkProfile j10 = this.this$0.L1().j();
        if (j10 != null) {
            j10.setBirthday(this.$dateString);
        }
        this.this$0.K1().e(g0.f(h.a("field_edited", "Y")));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Integer) obj);
        return Unit.f32013a;
    }
}
