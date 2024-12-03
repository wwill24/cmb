package com.withpersona.sdk2.inquiry.selfie.view;

import kotlin.jvm.functions.Function0;
import si.c;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SelfieOverlayView f27492a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f27493b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function0 f27494c;

    public /* synthetic */ h(SelfieOverlayView selfieOverlayView, c cVar, Function0 function0) {
        this.f27492a = selfieOverlayView;
        this.f27493b = cVar;
        this.f27494c = function0;
    }

    public final void run() {
        SelfieOverlayView$switchAnimation$1.c(this.f27492a, this.f27493b, this.f27494c);
    }
}
