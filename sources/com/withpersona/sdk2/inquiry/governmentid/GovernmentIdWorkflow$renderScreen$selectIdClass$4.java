package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class GovernmentIdWorkflow$renderScreen$selectIdClass$4 extends Lambda implements Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public static final GovernmentIdWorkflow$renderScreen$selectIdClass$4 f25641a = new GovernmentIdWorkflow$renderScreen$selectIdClass$4();

    GovernmentIdWorkflow$renderScreen$selectIdClass$4() {
        super(1);
    }

    public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
        j.g(cVar, "$this$action");
        cVar.d(new GovernmentIdWorkflow.b.c(new InternalErrorInfo.IntegrationErrorInfo("Passport NFC was configured to be required but the NFC module was not found.")));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((l.c) obj);
        return Unit.f32013a;
    }
}
