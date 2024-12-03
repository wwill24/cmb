package com.withpersona.sdk2.inquiry.ui.network;

import com.withpersona.sdk2.inquiry.ui.network.UiAddressAutocompleteWorker;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;

@d(c = "com.withpersona.sdk2.inquiry.ui.network.UiAddressAutocompleteWorker$run$1", f = "UiAddressAutocompleteWorker.kt", l = {18, 27, 29}, m = "invokeSuspend")
final class UiAddressAutocompleteWorker$run$1 extends SuspendLambda implements Function2<c<? super UiAddressAutocompleteWorker.b>, kotlin.coroutines.c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ UiAddressAutocompleteWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UiAddressAutocompleteWorker$run$1(UiAddressAutocompleteWorker uiAddressAutocompleteWorker, kotlin.coroutines.c<? super UiAddressAutocompleteWorker$run$1> cVar) {
        super(2, cVar);
        this.this$0 = uiAddressAutocompleteWorker;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        UiAddressAutocompleteWorker$run$1 uiAddressAutocompleteWorker$run$1 = new UiAddressAutocompleteWorker$run$1(this.this$0, cVar);
        uiAddressAutocompleteWorker$run$1.L$0 = obj;
        return uiAddressAutocompleteWorker$run$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super UiAddressAutocompleteWorker.b> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((UiAddressAutocompleteWorker$run$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.c} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r9.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0027
            if (r1 == r4) goto L_0x001f
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            goto L_0x001a
        L_0x0012:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001a:
            gk.g.b(r10)
            goto L_0x009d
        L_0x001f:
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            gk.g.b(r10)
            goto L_0x0058
        L_0x0027:
            gk.g.b(r10)
            java.lang.Object r10 = r9.L$0
            r1 = r10
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            com.withpersona.sdk2.inquiry.ui.network.UiAddressAutocompleteWorker r10 = r9.this$0
            com.withpersona.sdk2.inquiry.ui.network.b r10 = r10.f29465e
            com.withpersona.sdk2.inquiry.ui.network.UiAddressAutocompleteWorker r5 = r9.this$0
            java.lang.String r5 = r5.f29462b
            com.withpersona.sdk2.inquiry.ui.network.AddressAutocompleteRequest$a r6 = com.withpersona.sdk2.inquiry.ui.network.AddressAutocompleteRequest.f29402b
            com.withpersona.sdk2.inquiry.ui.network.UiAddressAutocompleteWorker r7 = r9.this$0
            com.withpersona.sdk2.inquiry.steps.ui.network.UiComponent r7 = r7.f29463c
            com.withpersona.sdk2.inquiry.ui.network.UiAddressAutocompleteWorker r8 = r9.this$0
            java.lang.String r8 = r8.f29464d
            com.withpersona.sdk2.inquiry.ui.network.AddressAutocompleteRequest r6 = r6.a(r7, r8)
            r9.L$0 = r1
            r9.label = r4
            java.lang.Object r10 = r10.c(r5, r6, r9)
            if (r10 != r0) goto L_0x0058
            return r0
        L_0x0058:
            retrofit2.r r10 = (retrofit2.r) r10
            boolean r4 = r10.g()
            r5 = 0
            if (r4 != 0) goto L_0x0075
            com.withpersona.sdk2.inquiry.ui.network.UiAddressAutocompleteWorker$b$a r2 = new com.withpersona.sdk2.inquiry.ui.network.UiAddressAutocompleteWorker$b$a
            com.withpersona.sdk2.inquiry.network.InternalErrorInfo$NetworkErrorInfo r10 = com.withpersona.sdk2.inquiry.network.NetworkUtilsKt.toErrorInfo(r10)
            r2.<init>(r10)
            r9.L$0 = r5
            r9.label = r3
            java.lang.Object r10 = r1.c(r2, r9)
            if (r10 != r0) goto L_0x009d
            return r0
        L_0x0075:
            com.withpersona.sdk2.inquiry.ui.network.UiAddressAutocompleteWorker$b$b r3 = new com.withpersona.sdk2.inquiry.ui.network.UiAddressAutocompleteWorker$b$b
            java.lang.Object r10 = r10.a()
            com.withpersona.sdk2.inquiry.ui.network.AddressAutocompleteResponse r10 = (com.withpersona.sdk2.inquiry.ui.network.AddressAutocompleteResponse) r10
            if (r10 == 0) goto L_0x008b
            com.withpersona.sdk2.inquiry.ui.network.Meta r10 = r10.a()
            if (r10 == 0) goto L_0x008b
            java.util.List r10 = r10.a()
            if (r10 != 0) goto L_0x008f
        L_0x008b:
            java.util.List r10 = kotlin.collections.q.j()
        L_0x008f:
            r3.<init>(r10)
            r9.L$0 = r5
            r9.label = r2
            java.lang.Object r10 = r1.c(r3, r9)
            if (r10 != r0) goto L_0x009d
            return r0
        L_0x009d:
            kotlin.Unit r10 = kotlin.Unit.f32013a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.ui.network.UiAddressAutocompleteWorker$run$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
