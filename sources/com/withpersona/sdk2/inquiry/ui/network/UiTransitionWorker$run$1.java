package com.withpersona.sdk2.inquiry.ui.network;

import com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;

@d(c = "com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker$run$1", f = "UiTransitionWorker.kt", l = {33, 43, 69, 77, 81}, m = "invokeSuspend")
final class UiTransitionWorker$run$1 extends SuspendLambda implements Function2<c<? super UiTransitionWorker.b>, kotlin.coroutines.c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UiTransitionWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UiTransitionWorker$run$1(UiTransitionWorker uiTransitionWorker, kotlin.coroutines.c<? super UiTransitionWorker$run$1> cVar) {
        super(2, cVar);
        this.this$0 = uiTransitionWorker;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        UiTransitionWorker$run$1 uiTransitionWorker$run$1 = new UiTransitionWorker$run$1(this.this$0, cVar);
        uiTransitionWorker$run$1.L$0 = obj;
        return uiTransitionWorker$run$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super UiTransitionWorker.b> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((UiTransitionWorker$run$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v21, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlinx.coroutines.flow.c} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00de A[SYNTHETIC, Splitter:B:25:0x00de] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x019f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r12.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r1 == 0) goto L_0x003a
            if (r1 == r6) goto L_0x0032
            if (r1 == r5) goto L_0x0029
            if (r1 == r4) goto L_0x0024
            if (r1 == r3) goto L_0x0024
            if (r1 != r2) goto L_0x001c
            gk.g.b(r13)
            goto L_0x01ac
        L_0x001c:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0024:
            gk.g.b(r13)
            goto L_0x019c
        L_0x0029:
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            gk.g.b(r13)
            goto L_0x00d5
        L_0x0032:
            java.lang.Object r1 = r12.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            gk.g.b(r13)
            goto L_0x009d
        L_0x003a:
            gk.g.b(r13)
            java.lang.Object r13 = r12.L$0
            r1 = r13
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker r13 = r12.this$0
            ui.a r13 = r13.f29506i
            com.withpersona.sdk2.inquiry.ui.network.UiStepData r7 = new com.withpersona.sdk2.inquiry.ui.network.UiStepData
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker r8 = r12.this$0
            java.lang.String r8 = r8.f29501d
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker r9 = r12.this$0
            java.util.Map r9 = r9.f29503f
            r7.<init>(r8, r9)
            r13.b(r7)
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker r13 = r12.this$0
            ji.a r13 = r13.f29507j
            boolean r13 = r13.c()
            if (r13 == 0) goto L_0x00a0
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker r13 = r12.this$0
            ji.a r13 = r13.f29507j
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker r5 = r12.this$0
            java.lang.String r5 = r5.f29499b
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker r7 = r12.this$0
            java.lang.String r7 = r7.f29500c
            com.withpersona.sdk2.inquiry.ui.network.TransitionInquiryRequest$a r8 = com.withpersona.sdk2.inquiry.ui.network.TransitionInquiryRequest.f29446c
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker r9 = r12.this$0
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent r9 = r9.f29502e
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker r10 = r12.this$0
            java.util.Map r10 = r10.f29503f
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker r11 = r12.this$0
            java.lang.String r11 = r11.f29501d
            com.withpersona.sdk2.inquiry.ui.network.TransitionInquiryRequest r8 = r8.a(r9, r10, r11)
            r12.L$0 = r1
            r12.label = r6
            java.lang.Object r13 = r13.a(r5, r7, r8, r12)
            if (r13 != r0) goto L_0x009d
            return r0
        L_0x009d:
            retrofit2.r r13 = (retrofit2.r) r13
            goto L_0x00d7
        L_0x00a0:
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker r13 = r12.this$0
            com.withpersona.sdk2.inquiry.ui.network.b r13 = r13.f29504g
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker r6 = r12.this$0
            java.lang.String r6 = r6.f29499b
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker r7 = r12.this$0
            java.lang.String r7 = r7.f29500c
            com.withpersona.sdk2.inquiry.ui.network.TransitionInquiryRequest$a r8 = com.withpersona.sdk2.inquiry.ui.network.TransitionInquiryRequest.f29446c
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker r9 = r12.this$0
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent r9 = r9.f29502e
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker r10 = r12.this$0
            java.util.Map r10 = r10.f29503f
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker r11 = r12.this$0
            java.lang.String r11 = r11.f29501d
            com.withpersona.sdk2.inquiry.ui.network.TransitionInquiryRequest r8 = r8.a(r9, r10, r11)
            r12.L$0 = r1
            r12.label = r5
            java.lang.Object r13 = r13.b(r6, r7, r8, r12)
            if (r13 != r0) goto L_0x00d5
            return r0
        L_0x00d5:
            retrofit2.r r13 = (retrofit2.r) r13
        L_0x00d7:
            boolean r5 = r13.g()
            r6 = 0
            if (r5 != 0) goto L_0x019f
            okhttp3.b0 r2 = r13.e()     // Catch:{ IOException -> 0x0119, JsonDataException -> 0x0112 }
            if (r2 == 0) goto L_0x0106
            okio.BufferedSource r2 = r2.source()     // Catch:{ IOException -> 0x0119, JsonDataException -> 0x0112 }
            if (r2 == 0) goto L_0x0106
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker r5 = r12.this$0     // Catch:{ IOException -> 0x0119, JsonDataException -> 0x0112 }
            com.squareup.moshi.s r5 = r5.f29505h     // Catch:{ IOException -> 0x0119, JsonDataException -> 0x0112 }
            java.lang.Class<com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse> r7 = com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse.class
            com.squareup.moshi.h r5 = r5.c(r7)     // Catch:{ IOException -> 0x0119, JsonDataException -> 0x0112 }
            okio.Buffer r2 = r2.d()     // Catch:{ IOException -> 0x0119, JsonDataException -> 0x0112 }
            okio.Buffer r2 = r2.clone()     // Catch:{ IOException -> 0x0119, JsonDataException -> 0x0112 }
            java.lang.Object r2 = r5.fromJson((okio.BufferedSource) r2)     // Catch:{ IOException -> 0x0119, JsonDataException -> 0x0112 }
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse r2 = (com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse) r2     // Catch:{ IOException -> 0x0119, JsonDataException -> 0x0112 }
            if (r2 != 0) goto L_0x010c
        L_0x0106:
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse$a r2 = com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse.f29477b     // Catch:{ IOException -> 0x0119, JsonDataException -> 0x0112 }
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse r2 = r2.a()     // Catch:{ IOException -> 0x0119, JsonDataException -> 0x0112 }
        L_0x010c:
            java.lang.String r5 = "{\n        transitionResp…rorResponse.Empty\n      }"
            kotlin.jvm.internal.j.f(r2, r5)     // Catch:{ IOException -> 0x0119, JsonDataException -> 0x0112 }
            goto L_0x011f
        L_0x0112:
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse$a r2 = com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse.f29477b
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse r2 = r2.a()
            goto L_0x011f
        L_0x0119:
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse$a r2 = com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse.f29477b
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse r2 = r2.a()
        L_0x011f:
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse$a r5 = com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse.f29477b
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse r5 = r5.a()
            boolean r5 = kotlin.jvm.internal.j.b(r2, r5)
            if (r5 != 0) goto L_0x0174
            java.util.List r5 = r2.b()
            if (r5 == 0) goto L_0x013e
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.P(r5)
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse$Error r5 = (com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse.Error) r5
            if (r5 == 0) goto L_0x013e
            java.util.Map r5 = r5.a()
            goto L_0x013f
        L_0x013e:
            r5 = r6
        L_0x013f:
            if (r5 != 0) goto L_0x0142
            goto L_0x0174
        L_0x0142:
            java.util.List r13 = r2.b()
            java.lang.Object r13 = kotlin.collections.CollectionsKt___CollectionsKt.P(r13)
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse$Error r13 = (com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse.Error) r13
            if (r13 == 0) goto L_0x0160
            java.util.Map r13 = r13.a()
            if (r13 == 0) goto L_0x0160
            java.util.Collection r13 = r13.values()
            if (r13 == 0) goto L_0x0160
            java.util.List r13 = kotlin.collections.CollectionsKt___CollectionsKt.x0(r13)
            if (r13 != 0) goto L_0x0164
        L_0x0160:
            java.util.List r13 = kotlin.collections.q.j()
        L_0x0164:
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker$b$a r2 = new com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker$b$a
            r2.<init>(r13)
            r12.L$0 = r6
            r12.label = r3
            java.lang.Object r13 = r1.c(r2, r12)
            if (r13 != r0) goto L_0x019c
            return r0
        L_0x0174:
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker$b$b r3 = new com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker$b$b
            java.util.List r2 = r2.b()
            if (r2 == 0) goto L_0x0189
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.P(r2)
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse$Error r2 = (com.withpersona.sdk2.inquiry.ui.network.UiTransitionErrorResponse.Error) r2
            if (r2 == 0) goto L_0x0189
            java.lang.String r2 = r2.b()
            goto L_0x018a
        L_0x0189:
            r2 = r6
        L_0x018a:
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r13 = com.withpersona.sdk2.inquiry.network.NetworkUtilsKt.toErrorInfo(r13)
            r3.<init>(r2, r13)
            r12.L$0 = r6
            r12.label = r4
            java.lang.Object r13 = r1.c(r3, r12)
            if (r13 != r0) goto L_0x019c
            return r0
        L_0x019c:
            kotlin.Unit r13 = kotlin.Unit.f32013a
            return r13
        L_0x019f:
            com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker$b$c r13 = com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker.b.c.f29515a
            r12.L$0 = r6
            r12.label = r2
            java.lang.Object r13 = r1.c(r13, r12)
            if (r13 != r0) goto L_0x01ac
            return r0
        L_0x01ac:
            kotlin.Unit r13 = kotlin.Unit.f32013a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.ui.network.UiTransitionWorker$run$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
