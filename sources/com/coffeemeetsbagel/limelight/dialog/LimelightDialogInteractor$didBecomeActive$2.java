package com.coffeemeetsbagel.limelight.dialog;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class LimelightDialogInteractor$didBecomeActive$2 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final LimelightDialogInteractor$didBecomeActive$2 f34373a = new LimelightDialogInteractor$didBecomeActive$2();

    LimelightDialogInteractor$didBecomeActive$2() {
        super(1);
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        String K1 = LimelightDialogInteractor.f34363t;
        j.f(K1, "TAG");
        j.f(th2, "error");
        aVar.c(K1, "", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
