package com.skydoves.balloon;

import android.view.View;
import android.widget.ImageView;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Balloon f22792a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f22793b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageView f22794c;

    public /* synthetic */ c(Balloon balloon, View view, ImageView imageView) {
        this.f22792a = balloon;
        this.f22793b = view;
        this.f22794c = imageView;
    }

    public final void run() {
        Balloon.d0(this.f22792a, this.f22793b, this.f22794c);
    }
}
