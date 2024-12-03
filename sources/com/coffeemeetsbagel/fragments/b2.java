package com.coffeemeetsbagel.fragments;

import android.view.KeyEvent;
import android.widget.TextView;

public final /* synthetic */ class b2 implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentMyProfileDetails f13608a;

    public /* synthetic */ b2(FragmentMyProfileDetails fragmentMyProfileDetails) {
        this.f13608a = fragmentMyProfileDetails;
    }

    public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        return FragmentMyProfileDetails.A4(this.f13608a, textView, i10, keyEvent);
    }
}
