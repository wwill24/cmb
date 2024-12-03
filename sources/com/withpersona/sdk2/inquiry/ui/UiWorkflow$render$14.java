package com.withpersona.sdk2.inquiry.ui;

import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class UiWorkflow$render$14 extends Lambda implements Function2<UiComponent.InputAddress, String, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final UiWorkflow$render$14 f29371a = new UiWorkflow$render$14();

    UiWorkflow$render$14() {
        super(2);
    }

    public final void a(UiComponent.InputAddress inputAddress, String str) {
        j.g(inputAddress, "<anonymous parameter 0>");
        j.g(str, "<anonymous parameter 1>");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        a((UiComponent.InputAddress) obj, (String) obj2);
        return Unit.f32013a;
    }
}
