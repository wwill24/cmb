package com.withpersona.sdk2.inquiry.nfc;

import gk.g;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;

@d(c = "com.withpersona.sdk2.inquiry.nfc.ScanNfcWorker$run$1", f = "ScanNfcWorker.kt", l = {44}, m = "invokeSuspend")
final class ScanNfcWorker$run$1 extends SuspendLambda implements Function2<c<? super PassportNfcReaderOutput>, kotlin.coroutines.c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ScanNfcWorker this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScanNfcWorker$run$1(ScanNfcWorker scanNfcWorker, kotlin.coroutines.c<? super ScanNfcWorker$run$1> cVar) {
        super(2, cVar);
        this.this$0 = scanNfcWorker;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        ScanNfcWorker$run$1 scanNfcWorker$run$1 = new ScanNfcWorker$run$1(this.this$0, cVar);
        scanNfcWorker$run$1.L$0 = obj;
        return scanNfcWorker$run$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super PassportNfcReaderOutput> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((ScanNfcWorker$run$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            final c cVar = (c) this.L$0;
            this.this$0.f27058b.b(new PassportNfcReaderConfig(new MrzKey(this.this$0.f27060d, this.this$0.f27062f, this.this$0.f27061e), this.this$0.f27063g, this.this$0.f27064h, this.this$0.f27065i, this.this$0.f27066j));
            g gVar = new g();
            final ScanNfcWorker scanNfcWorker = this.this$0;
            AnonymousClass1 r32 = new c() {
                /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
                /* JADX WARNING: Removed duplicated region for block: B:20:0x0071 A[RETURN] */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
                /* renamed from: a */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object c(com.withpersona.sdk2.inquiry.nfc.PassportNfcReaderOutput r8, kotlin.coroutines.c<? super kotlin.Unit> r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof com.withpersona.sdk2.inquiry.nfc.ScanNfcWorker$run$1$1$emit$1
                        if (r0 == 0) goto L_0x0013
                        r0 = r9
                        com.withpersona.sdk2.inquiry.nfc.ScanNfcWorker$run$1$1$emit$1 r0 = (com.withpersona.sdk2.inquiry.nfc.ScanNfcWorker$run$1$1$emit$1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L_0x0018
                    L_0x0013:
                        com.withpersona.sdk2.inquiry.nfc.ScanNfcWorker$run$1$1$emit$1 r0 = new com.withpersona.sdk2.inquiry.nfc.ScanNfcWorker$run$1$1$emit$1
                        r0.<init>(r7, r9)
                    L_0x0018:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L_0x0040
                        if (r2 == r4) goto L_0x0034
                        if (r2 != r3) goto L_0x002c
                        gk.g.b(r9)
                        goto L_0x0072
                    L_0x002c:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L_0x0034:
                        java.lang.Object r8 = r0.L$1
                        com.withpersona.sdk2.inquiry.nfc.PassportNfcReaderOutput r8 = (com.withpersona.sdk2.inquiry.nfc.PassportNfcReaderOutput) r8
                        java.lang.Object r2 = r0.L$0
                        com.withpersona.sdk2.inquiry.nfc.ScanNfcWorker$run$1$1 r2 = (com.withpersona.sdk2.inquiry.nfc.ScanNfcWorker$run$1.AnonymousClass1) r2
                        gk.g.b(r9)
                        goto L_0x0062
                    L_0x0040:
                        gk.g.b(r9)
                        com.withpersona.sdk2.inquiry.nfc.ScanNfcWorker r9 = r4
                        android.content.Context r9 = r9.f27059c
                        android.content.res.Resources r9 = r9.getResources()
                        int r2 = com.withpersona.sdk2.inquiry.nfc.h.pi2_transition_animation_duration
                        int r9 = r9.getInteger(r2)
                        long r5 = (long) r9
                        r0.L$0 = r7
                        r0.L$1 = r8
                        r0.label = r4
                        java.lang.Object r9 = kotlinx.coroutines.s0.a(r5, r0)
                        if (r9 != r1) goto L_0x0061
                        return r1
                    L_0x0061:
                        r2 = r7
                    L_0x0062:
                        kotlinx.coroutines.flow.c<com.withpersona.sdk2.inquiry.nfc.PassportNfcReaderOutput> r9 = r11
                        r2 = 0
                        r0.L$0 = r2
                        r0.L$1 = r2
                        r0.label = r3
                        java.lang.Object r8 = r9.c(r8, r0)
                        if (r8 != r1) goto L_0x0072
                        return r1
                    L_0x0072:
                        kotlin.Unit r8 = kotlin.Unit.f32013a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.nfc.ScanNfcWorker$run$1.AnonymousClass1.c(com.withpersona.sdk2.inquiry.nfc.PassportNfcReaderOutput, kotlin.coroutines.c):java.lang.Object");
                }
            };
            this.label = 1;
            if (gVar.a(r32, this) == d10) {
                return d10;
            }
        } else if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            g.b(obj);
        }
        throw new KotlinNothingValueException();
    }
}
