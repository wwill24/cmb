package com.coffeemeetsbagel.phone_login.verification_code;

import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class d implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VerificationCodeFragment f35775a;

    public /* synthetic */ d(VerificationCodeFragment verificationCodeFragment) {
        this.f35775a = verificationCodeFragment;
    }

    public final void onFailure(Exception exc) {
        VerificationCodeFragment.f1(this.f35775a, exc);
    }
}
