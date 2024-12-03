package com.coffeemeetsbagel.phone_login.verification_code;

import android.view.View;
import com.coffeemeetsbagel.phone_login.verification_code.VerificationCodeFragment;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VerificationCodeFragment f35778a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f35779b;

    public /* synthetic */ g(VerificationCodeFragment verificationCodeFragment, String str) {
        this.f35778a = verificationCodeFragment;
        this.f35779b = str;
    }

    public final void onClick(View view) {
        VerificationCodeFragment.c.b(this.f35778a, this.f35779b, view);
    }
}
