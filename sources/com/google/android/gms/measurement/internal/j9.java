package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.p;

final class j9 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f39969a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f39970b = "_err";

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Bundle f39971c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ k9 f39972d;

    j9(k9 k9Var, String str, String str2, Bundle bundle) {
        this.f39972d = k9Var;
        this.f39969a = str;
        this.f39971c = bundle;
    }

    public final void run() {
        this.f39972d.f39998a.k((zzau) p.k(this.f39972d.f39998a.h0().y0(this.f39969a, this.f39970b, this.f39971c, "auto", this.f39972d.f39998a.a().currentTimeMillis(), false, true)), this.f39969a);
    }
}
