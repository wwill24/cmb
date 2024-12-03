package com.google.android.gms.common.api.internal;

import com.google.android.gms.internal.base.zat;
import java.util.concurrent.ExecutorService;
import ne.c;

public final class e1 {

    /* renamed from: a  reason: collision with root package name */
    private static final ExecutorService f38592a = zat.zaa().zac(2, new c("GAC_Executor"), 2);

    public static ExecutorService a() {
        return f38592a;
    }
}
