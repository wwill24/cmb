package com.squareup.workflow1.ui;

import com.squareup.workflow1.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.c;

@Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/b;", "Lkotlinx/coroutines/flow/c;", "collector", "", "a", "(Lkotlinx/coroutines/flow/c;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class AndroidRenderWorkflowKt$renderWorkflowIn$$inlined$map$1 implements b<RenderingT> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f23152a;

    public AndroidRenderWorkflowKt$renderWorkflowIn$$inlined$map$1(b bVar) {
        this.f23152a = bVar;
    }

    public Object a(final c cVar, kotlin.coroutines.c cVar2) {
        Object a10 = this.f23152a.a(new c<e<? extends RenderingT>>() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object c(java.lang.Object r5, kotlin.coroutines.c r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof com.squareup.workflow1.ui.AndroidRenderWorkflowKt$renderWorkflowIn$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    com.squareup.workflow1.ui.AndroidRenderWorkflowKt$renderWorkflowIn$$inlined$map$1$2$1 r0 = (com.squareup.workflow1.ui.AndroidRenderWorkflowKt$renderWorkflowIn$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    com.squareup.workflow1.ui.AndroidRenderWorkflowKt$renderWorkflowIn$$inlined$map$1$2$1 r0 = new com.squareup.workflow1.ui.AndroidRenderWorkflowKt$renderWorkflowIn$$inlined$map$1$2$1
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    gk.g.b(r6)
                    goto L_0x0045
                L_0x0029:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x0031:
                    gk.g.b(r6)
                    kotlinx.coroutines.flow.c r6 = r3
                    com.squareup.workflow1.e r5 = (com.squareup.workflow1.e) r5
                    java.lang.Object r5 = r5.a()
                    r0.label = r3
                    java.lang.Object r5 = r6.c(r5, r0)
                    if (r5 != r1) goto L_0x0045
                    return r1
                L_0x0045:
                    kotlin.Unit r5 = kotlin.Unit.f32013a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.squareup.workflow1.ui.AndroidRenderWorkflowKt$renderWorkflowIn$$inlined$map$1.AnonymousClass2.c(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }, cVar2);
        if (a10 == b.d()) {
            return a10;
        }
        return Unit.f32013a;
    }
}
