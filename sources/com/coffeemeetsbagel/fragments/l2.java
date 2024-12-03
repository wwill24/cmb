package com.coffeemeetsbagel.fragments;

import android.view.KeyEvent;
import android.widget.TextView;

public final /* synthetic */ class l2 implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentMyProfileDetails f13766a;

    public /* synthetic */ l2(FragmentMyProfileDetails fragmentMyProfileDetails) {
        this.f13766a = fragmentMyProfileDetails;
    }

    public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        return FragmentMyProfileDetails.q4(this.f13766a, textView, i10, keyEvent);
    }
}
