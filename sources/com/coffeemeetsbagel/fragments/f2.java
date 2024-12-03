package com.coffeemeetsbagel.fragments;

import android.view.KeyEvent;
import android.widget.TextView;

public final /* synthetic */ class f2 implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentMyProfileDetails f13680a;

    public /* synthetic */ f2(FragmentMyProfileDetails fragmentMyProfileDetails) {
        this.f13680a = fragmentMyProfileDetails;
    }

    public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        return FragmentMyProfileDetails.E4(this.f13680a, textView, i10, keyEvent);
    }
}
