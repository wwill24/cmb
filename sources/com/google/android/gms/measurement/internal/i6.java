package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;

final class i6 implements s9 {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ u6 f39936a;

    i6(u6 u6Var) {
        this.f39936a = u6Var;
    }

    public final void a(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.f39936a.t("auto", "_err", bundle, str);
        } else {
            this.f39936a.r("auto", "_err", bundle);
        }
    }
}
