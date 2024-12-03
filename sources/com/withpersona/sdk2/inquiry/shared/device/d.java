package com.withpersona.sdk2.inquiry.shared.device;

import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class d implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f27504a;

    public /* synthetic */ d(Function1 function1) {
        this.f27504a = function1;
    }

    public final void onSuccess(Object obj) {
        RealAppSetIDHelper.e(this.f27504a, obj);
    }
}
