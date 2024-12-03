package com.withpersona.sdk2.inquiry.governmentid.live_hint;

import com.withpersona.sdk2.inquiry.governmentid.live_hint.GovernmentIdHintWorker;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.c;

@d(c = "com.withpersona.sdk2.inquiry.governmentid.live_hint.GovernmentIdHintWorker$run$1", f = "GovernmentIdHintWorker.kt", l = {91}, m = "invokeSuspend")
final class GovernmentIdHintWorker$run$1 extends SuspendLambda implements Function2<c<? super Hint>, kotlin.coroutines.c<? super Unit>, Object> {
    final /* synthetic */ b<GovernmentIdHintWorker.c> $hintFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GovernmentIdHintWorker$run$1(b<GovernmentIdHintWorker.c> bVar, kotlin.coroutines.c<? super GovernmentIdHintWorker$run$1> cVar) {
        super(2, cVar);
        this.$hintFlow = bVar;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        GovernmentIdHintWorker$run$1 governmentIdHintWorker$run$1 = new GovernmentIdHintWorker$run$1(this.$hintFlow, cVar);
        governmentIdHintWorker$run$1.L$0 = obj;
        return governmentIdHintWorker$run$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super Hint> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((GovernmentIdHintWorker$run$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            final c cVar = (c) this.L$0;
            b<GovernmentIdHintWorker.c> k10 = kotlinx.coroutines.flow.d.k(this.$hintFlow);
            AnonymousClass1 r32 = new c() {
                /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
                /* JADX WARNING: Removed duplicated region for block: B:22:0x0057  */
                /* JADX WARNING: Removed duplicated region for block: B:23:0x005c  */
                /* JADX WARNING: Removed duplicated region for block: B:26:0x006e A[RETURN] */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
                /* renamed from: a */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object c(com.withpersona.sdk2.inquiry.governmentid.live_hint.GovernmentIdHintWorker.c r8, kotlin.coroutines.c<? super kotlin.Unit> r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof com.withpersona.sdk2.inquiry.governmentid.live_hint.GovernmentIdHintWorker$run$1$1$emit$1
                        if (r0 == 0) goto L_0x0013
                        r0 = r9
                        com.withpersona.sdk2.inquiry.governmentid.live_hint.GovernmentIdHintWorker$run$1$1$emit$1 r0 = (com.withpersona.sdk2.inquiry.governmentid.live_hint.GovernmentIdHintWorker$run$1$1$emit$1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L_0x0018
                    L_0x0013:
                        com.withpersona.sdk2.inquiry.governmentid.live_hint.GovernmentIdHintWorker$run$1$1$emit$1 r0 = new com.withpersona.sdk2.inquiry.governmentid.live_hint.GovernmentIdHintWorker$run$1$1$emit$1
                        r0.<init>(r7, r9)
                    L_0x0018:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
                        int r2 = r0.label
                        r3 = 0
                        r4 = 2
                        r5 = 1
                        if (r2 == 0) goto L_0x003d
                        if (r2 == r5) goto L_0x0035
                        if (r2 != r4) goto L_0x002d
                        gk.g.b(r9)
                        goto L_0x006f
                    L_0x002d:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L_0x0035:
                        java.lang.Object r8 = r0.L$0
                        com.withpersona.sdk2.inquiry.governmentid.live_hint.GovernmentIdHintWorker$c r8 = (com.withpersona.sdk2.inquiry.governmentid.live_hint.GovernmentIdHintWorker.c) r8
                        gk.g.b(r9)
                        goto L_0x0055
                    L_0x003d:
                        gk.g.b(r9)
                        kotlinx.coroutines.flow.c<com.withpersona.sdk2.inquiry.governmentid.live_hint.Hint> r9 = r5
                        if (r8 == 0) goto L_0x0049
                        com.withpersona.sdk2.inquiry.governmentid.live_hint.Hint r2 = r8.a()
                        goto L_0x004a
                    L_0x0049:
                        r2 = r3
                    L_0x004a:
                        r0.L$0 = r8
                        r0.label = r5
                        java.lang.Object r9 = r9.c(r2, r0)
                        if (r9 != r1) goto L_0x0055
                        return r1
                    L_0x0055:
                        if (r8 == 0) goto L_0x005c
                        long r8 = r8.b()
                        goto L_0x005e
                    L_0x005c:
                        r8 = 0
                    L_0x005e:
                        r5 = 33
                        long r8 = vk.j.d(r8, r5)
                        r0.L$0 = r3
                        r0.label = r4
                        java.lang.Object r8 = kotlinx.coroutines.s0.a(r8, r0)
                        if (r8 != r1) goto L_0x006f
                        return r1
                    L_0x006f:
                        kotlin.Unit r8 = kotlin.Unit.f32013a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.live_hint.GovernmentIdHintWorker$run$1.AnonymousClass1.c(com.withpersona.sdk2.inquiry.governmentid.live_hint.GovernmentIdHintWorker$c, kotlin.coroutines.c):java.lang.Object");
                }
            };
            this.label = 1;
            if (k10.a(r32, this) == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f32013a;
    }
}
