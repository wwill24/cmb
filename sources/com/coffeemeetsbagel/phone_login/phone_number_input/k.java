package com.coffeemeetsbagel.phone_login.phone_number_input;

import android.view.KeyEvent;
import android.widget.TextView;

public final /* synthetic */ class k implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PhoneNumberInputView f35737a;

    public /* synthetic */ k(PhoneNumberInputView phoneNumberInputView) {
        this.f35737a = phoneNumberInputView;
    }

    public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        return this.f35737a.j(textView, i10, keyEvent);
    }
}
