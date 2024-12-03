package com.withpersona.sdk2.inquiry.governmentid.nfc;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentId;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdPages;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflowUtilsKt;
import com.withpersona.sdk2.inquiry.governmentid.IdConfig;
import com.withpersona.sdk2.inquiry.governmentid.IdPart;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcConfirmDetailsPage;
import com.withpersona.sdk2.inquiry.governmentid.PassportNfcScanPage;
import com.withpersona.sdk2.inquiry.nfc.MrzKey;
import com.withpersona.sdk2.inquiry.nfc.PassportNfcReaderOutput;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class PassportNfcRenderer$renderPassportNfcScan$1 extends Lambda implements Function1<PassportNfcReaderOutput, l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>> {
    final /* synthetic */ GovernmentIdWorkflow.a $renderProps;
    final /* synthetic */ GovernmentIdState.PassportNfcScan $renderState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PassportNfcRenderer$renderPassportNfcScan$1(GovernmentIdState.PassportNfcScan passportNfcScan, GovernmentIdWorkflow.a aVar) {
        super(1);
        this.$renderState = passportNfcScan;
        this.$renderProps = aVar;
    }

    /* renamed from: a */
    public final l<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b> invoke(final PassportNfcReaderOutput passportNfcReaderOutput) {
        j.g(passportNfcReaderOutput, "it");
        final GovernmentIdState.PassportNfcScan passportNfcScan = this.$renderState;
        final GovernmentIdWorkflow.a aVar = this.$renderProps;
        return Workflows__WorkflowActionKt.c((String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {

            /* renamed from: com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcRenderer$renderPassportNfcScan$1$1$a */
            public /* synthetic */ class a {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f25963a;

                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
                static {
                    /*
                        com.withpersona.sdk2.inquiry.nfc.PassportNfcReaderOutput$ErrorType[] r0 = com.withpersona.sdk2.inquiry.nfc.PassportNfcReaderOutput.ErrorType.values()
                        int r0 = r0.length
                        int[] r0 = new int[r0]
                        com.withpersona.sdk2.inquiry.nfc.PassportNfcReaderOutput$ErrorType r1 = com.withpersona.sdk2.inquiry.nfc.PassportNfcReaderOutput.ErrorType.AuthenticationError     // Catch:{ NoSuchFieldError -> 0x0010 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                        r2 = 1
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                    L_0x0010:
                        com.withpersona.sdk2.inquiry.nfc.PassportNfcReaderOutput$ErrorType r1 = com.withpersona.sdk2.inquiry.nfc.PassportNfcReaderOutput.ErrorType.Unknown     // Catch:{ NoSuchFieldError -> 0x0019 }
                        int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                        r2 = 2
                        r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                    L_0x0019:
                        f25963a = r0
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcRenderer$renderPassportNfcScan$1.AnonymousClass1.a.<clinit>():void");
                }
            }

            public final void a(l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar) {
                GovernmentIdState.PassportNfcScan passportNfcScan;
                PassportNfcConfirmDetailsPage passportNfcConfirmDetailsPage;
                l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c cVar2 = cVar;
                j.g(cVar2, "$this$action");
                Object c10 = cVar.c();
                if (c10 instanceof GovernmentIdState.PassportNfcScan) {
                    passportNfcScan = (GovernmentIdState.PassportNfcScan) c10;
                } else {
                    passportNfcScan = null;
                }
                if (passportNfcScan != null) {
                    PassportNfcReaderOutput passportNfcReaderOutput = passportNfcReaderOutput;
                    if (j.b(passportNfcReaderOutput, PassportNfcReaderOutput.Cancel.f27034a)) {
                        cVar2.e(GovernmentIdState.PassportNfcScan.m(passportNfcScan, (IdPart.PassportNfcPart) null, (List) null, (List) null, 0, (GovernmentIdState) null, (PassportNfcScanPage) null, (IdConfig) null, (MrzKey) null, false, 255, (Object) null));
                    } else if (passportNfcReaderOutput instanceof PassportNfcReaderOutput.Error) {
                        int i10 = a.f25963a[((PassportNfcReaderOutput.Error) passportNfcReaderOutput).a().ordinal()];
                        if (i10 == 1) {
                            GovernmentIdState governmentIdState = (GovernmentIdState) cVar.c();
                            do {
                                if (governmentIdState == null || !(governmentIdState instanceof GovernmentIdState.VerifyPassportDetails)) {
                                    governmentIdState = ((GovernmentIdState) cVar.c()).f();
                                } else {
                                    cVar2.e(governmentIdState);
                                    return;
                                }
                            } while (((GovernmentIdState) cVar.c()).f() != null);
                        } else if (i10 == 2) {
                            cVar2.e(GovernmentIdState.PassportNfcScan.m(passportNfcScan, (IdPart.PassportNfcPart) null, (List) null, (List) null, 0, (GovernmentIdState) null, (PassportNfcScanPage) null, (IdConfig) null, (MrzKey) null, false, 255, (Object) null));
                        }
                    } else if (passportNfcReaderOutput instanceof PassportNfcReaderOutput.Success) {
                        IdPart.PassportNfcPart n10 = passportNfcScan.n();
                        List<GovernmentId> j10 = passportNfcScan.j();
                        IdConfig q10 = passportNfcScan.q();
                        List<IdPart> i11 = passportNfcScan.i();
                        int h10 = passportNfcScan.h();
                        GovernmentIdPages n11 = aVar.n();
                        if (n11 != null) {
                            passportNfcConfirmDetailsPage = n11.a();
                        } else {
                            passportNfcConfirmDetailsPage = null;
                        }
                        if (passportNfcConfirmDetailsPage != null) {
                            cVar2.e(new GovernmentIdState.PassportNfcConfirmDetails(n10, j10, i11, h10, GovernmentIdWorkflowUtilsKt.c(cVar2, false, 1, (Object) null), passportNfcConfirmDetailsPage, q10, new PassportNfcData(((PassportNfcReaderOutput.Success) passportNfcReaderOutput).a(), ((PassportNfcReaderOutput.Success) passportNfcReaderOutput).c(), ((PassportNfcReaderOutput.Success) passportNfcReaderOutput).e()), ((PassportNfcReaderOutput.Success) passportNfcReaderOutput).d()));
                            return;
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null);
    }
}
