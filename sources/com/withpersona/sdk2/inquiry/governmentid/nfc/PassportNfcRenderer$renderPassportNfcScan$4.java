package com.withpersona.sdk2.inquiry.governmentid.nfc;

import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.IdConfig;
import com.withpersona.sdk2.inquiry.governmentid.IdPart;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcScanPage;
import com.withpersona.sdk2.inquiry.nfc.MrzKey;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PassportNfcRenderer$renderPassportNfcScan$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;
    final /* synthetic */ GovernmentIdState.PassportNfcScan $renderState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PassportNfcRenderer$renderPassportNfcScan$4(h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar, GovernmentIdState.PassportNfcScan passportNfcScan) {
        super(0);
        this.$context = aVar;
        this.$renderState = passportNfcScan;
    }

    public final void invoke() {
        f c10 = this.$context.c();
        final GovernmentIdState.PassportNfcScan passportNfcScan = this.$renderState;
        c10.d(Workflows__WorkflowActionKt.c((String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
            public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                j.g(cVar, "$this$action");
                cVar.e(GovernmentIdState.PassportNfcScan.m(passportNfcScan, (IdPart.PassportNfcPart) null, (List) null, (List) null, 0, (GovernmentIdState) null, (PassportNfcScanPage) null, (IdConfig) null, (MrzKey) null, true, 255, (Object) null));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }
}
