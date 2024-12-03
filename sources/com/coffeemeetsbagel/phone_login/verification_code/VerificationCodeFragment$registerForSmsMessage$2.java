package com.coffeemeetsbagel.phone_login.verification_code;

import android.content.IntentFilter;
import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class VerificationCodeFragment$registerForSmsMessage$2 extends Lambda implements Function1<Void, Unit> {
    final /* synthetic */ VerificationCodeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VerificationCodeFragment$registerForSmsMessage$2(VerificationCodeFragment verificationCodeFragment) {
        super(1);
        this.this$0 = verificationCodeFragment;
    }

    public final void a(Void voidR) {
        a.f40771d.a(this.this$0.f35743f, "SMS LISTENING_SUCCESS");
        this.this$0.requireActivity().registerReceiver(this.this$0.f35747k, new IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED"));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Void) obj);
        return Unit.f32013a;
    }
}
