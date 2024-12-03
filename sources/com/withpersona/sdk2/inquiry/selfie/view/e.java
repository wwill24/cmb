package com.withpersona.sdk2.inquiry.selfie.view;

import kotlin.jvm.functions.Function0;
import si.c;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SelfieOverlayView f27487a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f27488b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function0 f27489c;

    public /* synthetic */ e(SelfieOverlayView selfieOverlayView, c cVar, Function0 function0) {
        this.f27487a = selfieOverlayView;
        this.f27488b = cVar;
        this.f27489c = function0;
    }

    public final void run() {
        SelfieOverlayView.T(this.f27487a, this.f27488b, this.f27489c);
    }
}
