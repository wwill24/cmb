package com.withpersona.sdk2.inquiry.governmentid;

import android.view.View;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f25776a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f25777b;

    public /* synthetic */ g(float f10, View view) {
        this.f25776a = f10;
        this.f25777b = view;
    }

    public final void run() {
        CameraScreenRunner.x(this.f25776a, this.f25777b);
    }
}
