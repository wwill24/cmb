package com.withpersona.sdk2.inquiry.governmentid.nfc;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.IdConfig;
import com.withpersona.sdk2.inquiry.governmentid.IdPart;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;

final class PassportNfcRenderer$renderMrzScan$2 extends Lambda implements Function1<Unit, l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>> {
    final /* synthetic */ GovernmentIdState.MrzScan $renderState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PassportNfcRenderer$renderMrzScan$2(GovernmentIdState.MrzScan mrzScan) {
        super(1);
        this.$renderState = mrzScan;
    }

    /* renamed from: a */
    public final l<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b> invoke(Unit unit) {
        j.g(unit, "it");
        final GovernmentIdState.MrzScan mrzScan = this.$renderState;
        return Workflows__WorkflowActionKt.c((String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
            public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                j.g(cVar, "$this$action");
                if (mrzScan.p() == GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture.Hidden) {
                    cVar.e(GovernmentIdState.MrzScan.m(mrzScan, (IdPart.PassportNfcPart) null, (List) null, (List) null, 0, (GovernmentIdState) null, (IdConfig) null, GovernmentIdWorkflow.Screen.CameraScreen.ManualCapture.Enabled, false, Opcodes.ATHROW, (Object) null));
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null);
    }
}
