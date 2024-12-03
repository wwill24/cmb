package com.coffeemeetsbagel.phone_login.phone_number_input;

import com.coffeemeetsbagel.country.CmbCountry;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class PhoneInputFragment$onResume$7 extends Lambda implements Function1<CmbCountry, Unit> {
    final /* synthetic */ PhoneInputFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PhoneInputFragment$onResume$7(PhoneInputFragment phoneInputFragment) {
        super(1);
        this.this$0 = phoneInputFragment;
    }

    public final void a(CmbCountry cmbCountry) {
        this.this$0.L0().setFlagAndCode(cmbCountry);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((CmbCountry) obj);
        return Unit.f32013a;
    }
}
