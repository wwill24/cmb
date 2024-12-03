package com.coffeemeetsbagel.fragments;

import fa.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class FragmentMyProfileDetails$onCreateView$3 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final FragmentMyProfileDetails$onCreateView$3 f13581a = new FragmentMyProfileDetails$onCreateView$3();

    FragmentMyProfileDetails$onCreateView$3() {
        super(1);
    }

    public final void a(Throwable th2) {
        a.C0491a aVar = a.f40771d;
        j.d(th2);
        aVar.c("FragmentMyProfileDetails", "Failed to load Interests.", th2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
