package com.coffeemeetsbagel.today_view.main;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import lc.c;
import r7.h;

public class TodayViewMainView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private h f37360a;

    public TodayViewMainView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        c.h(this.f37360a);
    }

    public void b() {
        if (this.f37360a == null) {
            this.f37360a = new h(getContext());
        }
        this.f37360a.show();
    }
}
