package com.coffeemeetsbagel.feature.chatlist;

import android.view.View;
import androidx.fragment.app.Fragment;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BannerHolder f12919a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Fragment f12920b;

    public /* synthetic */ f(BannerHolder bannerHolder, Fragment fragment) {
        this.f12919a = bannerHolder;
        this.f12920b = fragment;
    }

    public final void onClick(View view) {
        this.f12919a.O(this.f12920b, view);
    }
}
