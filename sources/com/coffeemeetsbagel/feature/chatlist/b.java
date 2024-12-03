package com.coffeemeetsbagel.feature.chatlist;

import android.view.View;
import androidx.fragment.app.Fragment;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BannerHolder f12894a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Fragment f12895b;

    public /* synthetic */ b(BannerHolder bannerHolder, Fragment fragment) {
        this.f12894a = bannerHolder;
        this.f12895b = fragment;
    }

    public final void onClick(View view) {
        this.f12894a.M(this.f12895b, view);
    }
}
