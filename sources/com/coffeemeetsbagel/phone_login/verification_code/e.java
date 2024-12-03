package com.coffeemeetsbagel.phone_login.verification_code;

import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class e implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f35776a;

    public /* synthetic */ e(Function1 function1) {
        this.f35776a = function1;
    }

    public final void onSuccess(Object obj) {
        VerificationCodeFragment.g1(this.f35776a, obj);
    }
}
