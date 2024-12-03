package com.withpersona.sdk2.inquiry.governmentid.nfc;

import androidx.core.net.b;
import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentId;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflowUtilsKt;
import com.withpersona.sdk2.inquiry.governmentid.IdConfig;
import com.withpersona.sdk2.inquiry.governmentid.IdPart;
import com.withpersona.sdk2.inquiry.governmentid.network.GovernmentIdRequestArguments;
import com.withpersona.sdk2.inquiry.governmentid.network.PassportNfcRequestArguments;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PassportNfcRenderer$renderPassportNfcConfirmDetails$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;
    final /* synthetic */ GovernmentIdWorkflow.a $renderProps;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PassportNfcRenderer$renderPassportNfcConfirmDetails$3(h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar, GovernmentIdWorkflow.a aVar2) {
        super(0);
        this.$context = aVar;
        this.$renderProps = aVar2;
    }

    public final void invoke() {
        f c10 = this.$context.c();
        final GovernmentIdWorkflow.a aVar = this.$renderProps;
        c10.d(Workflows__WorkflowActionKt.c((String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
            public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                GovernmentIdState.PassportNfcConfirmDetails passportNfcConfirmDetails;
                j.g(cVar, "$this$action");
                Object c10 = cVar.c();
                if (c10 instanceof GovernmentIdState.PassportNfcConfirmDetails) {
                    passportNfcConfirmDetails = (GovernmentIdState.PassportNfcConfirmDetails) c10;
                } else {
                    passportNfcConfirmDetails = null;
                }
                if (passportNfcConfirmDetails != null) {
                    IdConfig p10 = passportNfcConfirmDetails.p();
                    List<GovernmentId> j10 = passportNfcConfirmDetails.j();
                    List<IdPart> i10 = passportNfcConfirmDetails.i();
                    int h10 = passportNfcConfirmDetails.h();
                    GovernmentIdState c11 = GovernmentIdWorkflowUtilsKt.c(cVar, false, 1, (Object) null);
                    PassportNfcData o10 = passportNfcConfirmDetails.o();
                    String a10 = aVar.o().a();
                    if (a10 != null) {
                        cVar.e(new GovernmentIdState.Submit(p10, j10, (IdPart) null, i10, h10, c11, (GovernmentIdRequestArguments) null, new PassportNfcRequestArguments(a10, b.a(o10.a()), b.a(o10.c()), b.a(o10.d())), 68, (DefaultConstructorMarker) null));
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }
}
