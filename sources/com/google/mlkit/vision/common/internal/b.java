package com.google.mlkit.vision.common.internal;

import java.util.concurrent.Callable;
import zg.a;

public final /* synthetic */ class b implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MobileVisionBase f21531a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f21532b;

    public /* synthetic */ b(MobileVisionBase mobileVisionBase, a aVar) {
        this.f21531a = mobileVisionBase;
        this.f21532b = aVar;
    }

    public final Object call() {
        return this.f21531a.c(this.f21532b);
    }
}
