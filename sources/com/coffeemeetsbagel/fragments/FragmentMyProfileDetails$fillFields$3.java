package com.coffeemeetsbagel.fragments;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class FragmentMyProfileDetails$fillFields$3 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final FragmentMyProfileDetails$fillFields$3 f13562a = new FragmentMyProfileDetails$fillFields$3();

    FragmentMyProfileDetails$fillFields$3() {
        super(1);
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        j.f(th2, "throwable");
        aVar.c("FragmentMyProfileDetails", "Couldn't update answers.", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
