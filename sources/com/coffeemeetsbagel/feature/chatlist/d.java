package com.coffeemeetsbagel.feature.chatlist;

import android.view.View;
import androidx.fragment.app.Fragment;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BannerHolder f12909a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Fragment f12910b;

    public /* synthetic */ d(BannerHolder bannerHolder, Fragment fragment) {
        this.f12909a = bannerHolder;
        this.f12910b = fragment;
    }

    public final void onClick(View view) {
        this.f12909a.K(this.f12910b, view);
    }
}
