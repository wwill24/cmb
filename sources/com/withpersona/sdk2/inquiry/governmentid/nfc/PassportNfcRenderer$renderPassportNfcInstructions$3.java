package com.withpersona.sdk2.inquiry.governmentid.nfc;

import com.squareup.workflow1.f;
import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class PassportNfcRenderer$renderPassportNfcInstructions$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;
    final /* synthetic */ GovernmentIdWorkflow.a $renderProps;
    final /* synthetic */ GovernmentIdState.PassportNfcInstructions $renderState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PassportNfcRenderer$renderPassportNfcInstructions$3(h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar, GovernmentIdWorkflow.a aVar2, GovernmentIdState.PassportNfcInstructions passportNfcInstructions) {
        super(0);
        this.$context = aVar;
        this.$renderProps = aVar2;
        this.$renderState = passportNfcInstructions;
    }

    public final void invoke() {
        f c10 = this.$context.c();
        final GovernmentIdWorkflow.a aVar = this.$renderProps;
        final GovernmentIdState.PassportNfcInstructions passportNfcInstructions = this.$renderState;
        c10.d(Workflows__WorkflowActionKt.c((String) null, new Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit>() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$MrzScan} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$VerifyPassportDetails} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$VerifyPassportDetails} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(com.squareup.workflow1.l<? super com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.a, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState, ? extends com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.b>.defpackage.c r18) {
                /*
                    r17 = this;
                    r0 = r17
                    r1 = r18
                    java.lang.String r2 = "$this$action"
                    kotlin.jvm.internal.j.g(r1, r2)
                    java.lang.Object r2 = r18.c()
                    boolean r3 = r2 instanceof com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState.PassportNfcInstructions
                    r4 = 0
                    if (r3 == 0) goto L_0x0015
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$PassportNfcInstructions r2 = (com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState.PassportNfcInstructions) r2
                    goto L_0x0016
                L_0x0015:
                    r2 = r4
                L_0x0016:
                    if (r2 != 0) goto L_0x0019
                    return
                L_0x0019:
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$a r3 = r2
                    com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcConfig r3 = r3.o()
                    boolean r3 = r3.d()
                    if (r3 == 0) goto L_0x0069
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$PassportNfcInstructions r3 = r3
                    com.withpersona.sdk2.inquiry.governmentid.IdPart$PassportNfcPart r6 = r3.l()
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$PassportNfcInstructions r3 = r3
                    java.util.List r7 = r3.j()
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$PassportNfcInstructions r3 = r3
                    com.withpersona.sdk2.inquiry.governmentid.IdConfig r12 = r3.n()
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$a r3 = r2
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdPages r3 = r3.n()
                    if (r3 == 0) goto L_0x0043
                    com.withpersona.sdk2.inquiry.governmentid.PassportNfcVerifyDetailsPage r4 = r3.j()
                L_0x0043:
                    r11 = r4
                    if (r11 == 0) goto L_0x005d
                    java.util.List r8 = r2.i()
                    int r9 = r2.h()
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$VerifyPassportDetails r2 = new com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$VerifyPassportDetails
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$PassportNfcInstructions r10 = r3
                    r13 = 0
                    r14 = 0
                    r15 = 256(0x100, float:3.59E-43)
                    r16 = 0
                    r5 = r2
                    r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
                    goto L_0x0099
                L_0x005d:
                    java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
                    java.lang.String r2 = "Required value was null."
                    java.lang.String r2 = r2.toString()
                    r1.<init>(r2)
                    throw r1
                L_0x0069:
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$MrzScan r14 = new com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$MrzScan
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$PassportNfcInstructions r3 = r3
                    com.withpersona.sdk2.inquiry.governmentid.IdPart$PassportNfcPart r5 = r3.l()
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$PassportNfcInstructions r3 = r3
                    java.util.List r6 = r3.j()
                    java.util.List r7 = r2.i()
                    int r2 = r2.h()
                    r3 = 0
                    r8 = 1
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState r8 = com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflowUtilsKt.c(r1, r3, r8, r4)
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$PassportNfcInstructions r3 = r3
                    com.withpersona.sdk2.inquiry.governmentid.IdConfig r9 = r3.n()
                    r10 = 0
                    r11 = 0
                    r12 = 192(0xc0, float:2.69E-43)
                    r13 = 0
                    r3 = r14
                    r4 = r5
                    r5 = r6
                    r6 = r7
                    r7 = r2
                    r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                    r2 = r14
                L_0x0099:
                    r1.e(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.nfc.PassportNfcRenderer$renderPassportNfcInstructions$3.AnonymousClass1.a(com.squareup.workflow1.l$c):void");
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }
}
