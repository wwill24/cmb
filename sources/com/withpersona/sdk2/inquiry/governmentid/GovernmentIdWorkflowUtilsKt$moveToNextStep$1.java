package com.withpersona.sdk2.inquiry.governmentid;

import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class GovernmentIdWorkflowUtilsKt$moveToNextStep$1 extends Lambda implements Function1<l<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b>.c, Unit> {
    final /* synthetic */ GovernmentId $acceptedId;
    final /* synthetic */ boolean $addCurrentState;
    final /* synthetic */ int $currentPartIndex;
    final /* synthetic */ IdConfig $id;
    final /* synthetic */ List<IdPart> $parts;
    final /* synthetic */ GovernmentIdWorkflow.a $renderProps;
    final /* synthetic */ GovernmentIdState $renderState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdWorkflowUtilsKt$moveToNextStep$1(GovernmentIdState governmentIdState, GovernmentId governmentId, int i10, List<? extends IdPart> list, GovernmentIdWorkflow.a aVar, boolean z10, IdConfig idConfig) {
        super(1);
        this.$renderState = governmentIdState;
        this.$acceptedId = governmentId;
        this.$currentPartIndex = i10;
        this.$parts = list;
        this.$renderProps = aVar;
        this.$addCurrentState = z10;
        this.$id = idConfig;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: java.lang.Object} */
    /* JADX WARNING: type inference failed for: r17v1 */
    /* JADX WARNING: type inference failed for: r14v4 */
    /* JADX WARNING: type inference failed for: r3v28, types: [com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$Submit] */
    /* JADX WARNING: type inference failed for: r3v29, types: [com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$FinalizeVideo] */
    /* JADX WARNING: type inference failed for: r3v30, types: [com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$PassportNfcInstructions] */
    /* JADX WARNING: type inference failed for: r3v31, types: [com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$WaitForAutocapture] */
    /* JADX WARNING: type inference failed for: r3v32, types: [com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$ChooseCaptureMethod] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.squareup.workflow1.l<? super com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.a, com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState, ? extends com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.b>.defpackage.c r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            java.lang.String r2 = "$this$action"
            kotlin.jvm.internal.j.g(r1, r2)
            java.lang.Object r2 = r19.c()
            java.lang.Class r2 = r2.getClass()
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState r3 = r0.$renderState
            java.lang.Class r3 = r3.getClass()
            if (r2 == r3) goto L_0x001a
            return
        L_0x001a:
            com.withpersona.sdk2.inquiry.governmentid.GovernmentId r2 = r0.$acceptedId
            if (r2 == 0) goto L_0x002f
            java.lang.Object r2 = r19.c()
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState r2 = (com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState) r2
            java.util.List r2 = r2.j()
            com.withpersona.sdk2.inquiry.governmentid.GovernmentId r3 = r0.$acceptedId
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.i0(r2, r3)
            goto L_0x0039
        L_0x002f:
            java.lang.Object r2 = r19.c()
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState r2 = (com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState) r2
            java.util.List r2 = r2.j()
        L_0x0039:
            r5 = r2
            int r2 = r0.$currentPartIndex
            java.util.List<com.withpersona.sdk2.inquiry.governmentid.IdPart> r3 = r0.$parts
            int r3 = r3.size()
            if (r2 != r3) goto L_0x0047
            int r2 = r0.$currentPartIndex
            goto L_0x004b
        L_0x0047:
            int r2 = r0.$currentPartIndex
            int r2 = r2 + 1
        L_0x004b:
            java.util.List<com.withpersona.sdk2.inquiry.governmentid.IdPart> r3 = r0.$parts
            java.lang.Object r3 = kotlin.collections.CollectionsKt___CollectionsKt.Q(r3, r2)
            com.withpersona.sdk2.inquiry.governmentid.IdPart r3 = (com.withpersona.sdk2.inquiry.governmentid.IdPart) r3
            boolean r4 = r3 instanceof com.withpersona.sdk2.inquiry.governmentid.IdPart.SideIdPart
            if (r4 == 0) goto L_0x00ac
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$a r4 = r0.$renderProps
            boolean r4 = r4.j()
            if (r4 == 0) goto L_0x007a
            boolean r4 = r0.$addCurrentState
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState r10 = com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflowUtilsKt.b(r1, r4)
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$ChooseCaptureMethod r14 = new com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$ChooseCaptureMethod
            r4 = r3
            com.withpersona.sdk2.inquiry.governmentid.IdPart$SideIdPart r4 = (com.withpersona.sdk2.inquiry.governmentid.IdPart.SideIdPart) r4
            java.util.List<com.withpersona.sdk2.inquiry.governmentid.IdPart> r6 = r0.$parts
            com.withpersona.sdk2.inquiry.governmentid.IdConfig r8 = r0.$id
            r9 = 0
            r11 = 0
            r12 = 160(0xa0, float:2.24E-43)
            r13 = 0
            r3 = r14
            r7 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            goto L_0x0156
        L_0x007a:
            java.lang.Object r4 = r19.b()
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$a r4 = (com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow.a) r4
            r6 = r3
            com.withpersona.sdk2.inquiry.governmentid.IdPart$SideIdPart r6 = (com.withpersona.sdk2.inquiry.governmentid.IdPart.SideIdPart) r6
            com.withpersona.sdk2.inquiry.governmentid.IdConfig$Side r3 = r6.a()
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$Screen$CameraScreen$ManualCapture r7 = com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflowUtilsKt.e(r4, r3)
            boolean r3 = r0.$addCurrentState
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState r11 = com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflowUtilsKt.b(r1, r3)
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$WaitForAutocapture r17 = new com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$WaitForAutocapture
            com.withpersona.sdk2.inquiry.governmentid.IdConfig r8 = r0.$id
            java.util.List<com.withpersona.sdk2.inquiry.governmentid.IdPart> r9 = r0.$parts
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 1856(0x740, float:2.601E-42)
            r16 = 0
            r3 = r17
            r4 = r6
            r6 = r8
            r8 = r9
            r9 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
        L_0x00a8:
            r14 = r17
            goto L_0x0156
        L_0x00ac:
            boolean r4 = r3 instanceof com.withpersona.sdk2.inquiry.governmentid.IdPart.PassportNfcPart
            if (r4 == 0) goto L_0x00e3
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$a r4 = r0.$renderProps
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdPages r4 = r4.n()
            if (r4 == 0) goto L_0x00bd
            com.withpersona.sdk2.inquiry.governmentid.PassportNfcStartPage r4 = r4.i()
            goto L_0x00be
        L_0x00bd:
            r4 = 0
        L_0x00be:
            r9 = r4
            if (r9 == 0) goto L_0x00d7
            boolean r4 = r0.$addCurrentState
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState r8 = com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflowUtilsKt.b(r1, r4)
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$PassportNfcInstructions r14 = new com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$PassportNfcInstructions
            r4 = r3
            com.withpersona.sdk2.inquiry.governmentid.IdPart$PassportNfcPart r4 = (com.withpersona.sdk2.inquiry.governmentid.IdPart.PassportNfcPart) r4
            java.util.List<com.withpersona.sdk2.inquiry.governmentid.IdPart> r6 = r0.$parts
            com.withpersona.sdk2.inquiry.governmentid.IdConfig r10 = r0.$id
            r3 = r14
            r7 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            goto L_0x0156
        L_0x00d7:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Required value was null."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x00e3:
            if (r3 != 0) goto L_0x015a
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$a r3 = r0.$renderProps
            com.withpersona.sdk2.inquiry.governmentid.video_capture.a r3 = r3.u()
            boolean r3 = r3.b()
            if (r3 == 0) goto L_0x012f
            java.lang.Object r3 = r19.c()
            boolean r3 = r3 instanceof com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState.FinalizeVideo
            if (r3 != 0) goto L_0x012f
            java.util.List<com.withpersona.sdk2.inquiry.governmentid.IdPart> r3 = r0.$parts
            java.lang.Object r3 = kotlin.collections.CollectionsKt___CollectionsKt.Y(r3)
            r6 = r3
            com.withpersona.sdk2.inquiry.governmentid.IdPart r6 = (com.withpersona.sdk2.inquiry.governmentid.IdPart) r6
            boolean r3 = r0.$addCurrentState
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState r9 = com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflowUtilsKt.b(r1, r3)
            com.withpersona.sdk2.inquiry.governmentid.network.GovernmentIdRequestArguments r10 = new com.withpersona.sdk2.inquiry.governmentid.network.GovernmentIdRequestArguments
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$a r3 = r0.$renderProps
            java.lang.String r3 = r3.f()
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$a r4 = r0.$renderProps
            java.lang.String r4 = r4.g()
            r10.<init>(r5, r3, r4)
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$FinalizeVideo r17 = new com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$FinalizeVideo
            com.withpersona.sdk2.inquiry.governmentid.IdConfig r4 = r0.$id
            java.util.List<com.withpersona.sdk2.inquiry.governmentid.IdPart> r7 = r0.$parts
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 896(0x380, float:1.256E-42)
            r16 = 0
            r3 = r17
            r8 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16)
            goto L_0x00a8
        L_0x012f:
            boolean r3 = r0.$addCurrentState
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState r9 = com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflowUtilsKt.b(r1, r3)
            com.withpersona.sdk2.inquiry.governmentid.network.GovernmentIdRequestArguments r10 = new com.withpersona.sdk2.inquiry.governmentid.network.GovernmentIdRequestArguments
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$a r3 = r0.$renderProps
            java.lang.String r3 = r3.f()
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow$a r4 = r0.$renderProps
            java.lang.String r4 = r4.g()
            r10.<init>(r5, r3, r4)
            com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$Submit r14 = new com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState$Submit
            com.withpersona.sdk2.inquiry.governmentid.IdConfig r4 = r0.$id
            r6 = 0
            java.util.List<com.withpersona.sdk2.inquiry.governmentid.IdPart> r7 = r0.$parts
            r11 = 0
            r12 = 132(0x84, float:1.85E-43)
            r13 = 0
            r3 = r14
            r8 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
        L_0x0156:
            r1.e(r14)
            return
        L_0x015a:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflowUtilsKt$moveToNextStep$1.a(com.squareup.workflow1.l$c):void");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((l.c) obj);
        return Unit.f32013a;
    }
}
