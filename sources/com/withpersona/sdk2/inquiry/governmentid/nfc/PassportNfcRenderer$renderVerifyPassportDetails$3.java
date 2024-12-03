package com.withpersona.sdk2.inquiry.governmentid.nfc;

import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentId;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdPages;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.IdConfig;
import com.withpersona.sdk2.inquiry.governmentid.IdPart;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcKeys;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcScanPage;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcVerifyDetailsPage;
import com.withpersona.sdk2.inquiry.nfc.MrzKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import net.bytebuddy.jar.asm.Opcodes;

final class PassportNfcRenderer$renderVerifyPassportDetails$3 extends Lambda implements Function1<PassportNfcKeys, Unit> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;
    final /* synthetic */ PassportNfcVerifyDetailsPage $passportNfcVerifyDetailsPage;
    final /* synthetic */ GovernmentIdWorkflow.a $renderProps;
    final /* synthetic */ GovernmentIdState.VerifyPassportDetails $renderState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PassportNfcRenderer$renderVerifyPassportDetails$3(PassportNfcVerifyDetailsPage passportNfcVerifyDetailsPage, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar, GovernmentIdState.VerifyPassportDetails verifyPassportDetails, GovernmentIdWorkflow.a aVar2) {
        super(1);
        this.$passportNfcVerifyDetailsPage = passportNfcVerifyDetailsPage;
        this.$context = aVar;
        this.$renderState = verifyPassportDetails;
        this.$renderProps = aVar2;
    }

    public final void a(final PassportNfcKeys passportNfcKeys) {
        j.g(passportNfcKeys, "it");
        final ArrayList arrayList = new ArrayList();
        if (r.w(passportNfcKeys.d())) {
            arrayList.add(this.$passportNfcVerifyDetailsPage.c());
        }
        if (passportNfcKeys.a() == null) {
            arrayList.add(this.$passportNfcVerifyDetailsPage.a());
        }
        if (passportNfcKeys.c() == null) {
            arrayList.add(this.$passportNfcVerifyDetailsPage.d());
        }
        if (arrayList.isEmpty()) {
            f c10 = this.$context.c();
            final GovernmentIdState.VerifyPassportDetails verifyPassportDetails = this.$renderState;
            final GovernmentIdWorkflow.a aVar = this.$renderProps;
            c10.d(Workflows__WorkflowActionKt.c((String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
                public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                    GovernmentIdState.VerifyPassportDetails verifyPassportDetails;
                    l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar2 = cVar;
                    j.g(cVar2, "$this$action");
                    Object c10 = cVar.c();
                    PassportNfcScanPage passportNfcScanPage = null;
                    if (c10 instanceof GovernmentIdState.VerifyPassportDetails) {
                        verifyPassportDetails = (GovernmentIdState.VerifyPassportDetails) c10;
                    } else {
                        verifyPassportDetails = null;
                    }
                    if (verifyPassportDetails != null) {
                        IdPart.PassportNfcPart o10 = verifyPassportDetails.o();
                        List<GovernmentId> j10 = verifyPassportDetails.j();
                        IdConfig r10 = verifyPassportDetails.r();
                        List<IdPart> i10 = verifyPassportDetails.i();
                        int h10 = verifyPassportDetails.h();
                        GovernmentIdPages n10 = aVar.n();
                        if (n10 != null) {
                            passportNfcScanPage = n10.g();
                        }
                        PassportNfcScanPage passportNfcScanPage2 = passportNfcScanPage;
                        if (passportNfcScanPage2 != null) {
                            GovernmentIdState.VerifyPassportDetails m10 = GovernmentIdState.VerifyPassportDetails.m(verifyPassportDetails, (IdPart.PassportNfcPart) null, (List) null, (List) null, 0, (GovernmentIdState) null, (PassportNfcVerifyDetailsPage) null, (IdConfig) null, passportNfcKeys, q.j(), Opcodes.LAND, (Object) null);
                            String d10 = passportNfcKeys.d();
                            Date c11 = passportNfcKeys.c();
                            if (c11 != null) {
                                Date a10 = passportNfcKeys.a();
                                if (a10 != null) {
                                    cVar2.e(new GovernmentIdState.PassportNfcScan(o10, j10, i10, h10, m10, passportNfcScanPage2, r10, new MrzKey(d10, c11, a10), false, 256, (DefaultConstructorMarker) null));
                                    return;
                                }
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null));
            return;
        }
        f c11 = this.$context.c();
        final GovernmentIdState.VerifyPassportDetails verifyPassportDetails2 = this.$renderState;
        c11.d(Workflows__WorkflowActionKt.c((String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
            public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                j.g(cVar, "$this$action");
                cVar.e(GovernmentIdState.VerifyPassportDetails.m(verifyPassportDetails2, (IdPart.PassportNfcPart) null, (List) null, (List) null, 0, (GovernmentIdState) null, (PassportNfcVerifyDetailsPage) null, (IdConfig) null, (PassportNfcKeys) null, arrayList, 255, (Object) null));
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((PassportNfcKeys) obj);
        return Unit.f32013a;
    }
}
