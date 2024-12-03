package com.coffeemeetsbagel.feature.chatlist;

import android.view.View;
import androidx.fragment.app.Fragment;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BannerHolder f12916a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Fragment f12917b;

    public /* synthetic */ e(BannerHolder bannerHolder, Fragment fragment) {
        this.f12916a = bannerHolder;
        this.f12917b = fragment;
    }

    public final void onClick(View view) {
        this.f12916a.N(this.f12917b, view);
    }
}
