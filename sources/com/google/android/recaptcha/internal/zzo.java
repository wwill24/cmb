package com.google.android.recaptcha.internal;

import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

final class zzo extends SuspendLambda implements Function2 {
    zzo(c cVar) {
        super(2, cVar);
    }

    public final c create(Object obj, c cVar) {
        return new zzo(cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        k0 k0Var = (k0) obj;
        return new zzo((c) obj2).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        g.b(obj);
        Thread.currentThread().setPriority(8);
        return Unit.f32013a;
    }
}
