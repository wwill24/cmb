package com.withpersona.sdk2.inquiry.ui;

import com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent;
import com.withpersona.sdk2.inquiry.ui.network.ComponentParam;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class UiWorkflow$render$10 extends Lambda implements Function2<UiComponent, Map<String, ? extends ComponentParam>, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final UiWorkflow$render$10 f29367a = new UiWorkflow$render$10();

    UiWorkflow$render$10() {
        super(2);
    }

    public final void a(UiComponent uiComponent, Map<String, ? extends ComponentParam> map) {
        j.g(uiComponent, "<anonymous parameter 0>");
        j.g(map, "<anonymous parameter 1>");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        a((UiComponent) obj, (Map) obj2);
        return Unit.f32013a;
    }
}
