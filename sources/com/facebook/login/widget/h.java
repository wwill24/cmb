package com.facebook.login.widget;

import android.view.ViewTreeObserver;

public final /* synthetic */ class h implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ToolTipPopup f37920a;

    public /* synthetic */ h(ToolTipPopup toolTipPopup) {
        this.f37920a = toolTipPopup;
    }

    public final void onScrollChanged() {
        ToolTipPopup.m174scrollListener$lambda1(this.f37920a);
    }
}
