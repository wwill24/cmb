package com.coffeemeetsbagel.fragments;

import android.view.KeyEvent;
import android.widget.TextView;

public final /* synthetic */ class o2 implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentMyProfileDetails f13787a;

    public /* synthetic */ o2(FragmentMyProfileDetails fragmentMyProfileDetails) {
        this.f13787a = fragmentMyProfileDetails;
    }

    public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        return FragmentMyProfileDetails.t4(this.f13787a, textView, i10, keyEvent);
    }
}
