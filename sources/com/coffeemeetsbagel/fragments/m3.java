package com.coffeemeetsbagel.fragments;

import android.view.View;

public final /* synthetic */ class m3 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentMyProfileDetails f13772a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f13773b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f13774c;

    public /* synthetic */ m3(FragmentMyProfileDetails fragmentMyProfileDetails, View view, View view2) {
        this.f13772a = fragmentMyProfileDetails;
        this.f13773b = view;
        this.f13774c = view2;
    }

    public final void run() {
        FragmentMyProfileDetails.g5(this.f13772a, this.f13773b, this.f13774c);
    }
}
