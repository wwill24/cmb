package com.skydoves.balloon;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class Balloon$handler$2 extends Lambda implements Function0<Handler> {

    /* renamed from: a  reason: collision with root package name */
    public static final Balloon$handler$2 f22759a = new Balloon$handler$2();

    Balloon$handler$2() {
        super(0);
    }

    /* renamed from: a */
    public final Handler invoke() {
        return new Handler(Looper.getMainLooper());
    }
}
