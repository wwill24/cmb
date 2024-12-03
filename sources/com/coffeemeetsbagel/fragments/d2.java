package com.coffeemeetsbagel.fragments;

import android.view.KeyEvent;
import android.widget.TextView;

public final /* synthetic */ class d2 implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentMyProfileDetails f13644a;

    public /* synthetic */ d2(FragmentMyProfileDetails fragmentMyProfileDetails) {
        this.f13644a = fragmentMyProfileDetails;
    }

    public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        return FragmentMyProfileDetails.C4(this.f13644a, textView, i10, keyEvent);
    }
}
