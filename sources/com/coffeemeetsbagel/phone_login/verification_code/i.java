package com.coffeemeetsbagel.phone_login.verification_code;

import android.view.KeyEvent;
import android.widget.TextView;

public final /* synthetic */ class i implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VerificationCodeView f35780a;

    public /* synthetic */ i(VerificationCodeView verificationCodeView) {
        this.f35780a = verificationCodeView;
    }

    public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        return this.f35780a.n(textView, i10, keyEvent);
    }
}
