package com.withpersona.sdk2.inquiry.selfie;

import com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker;
import kotlin.Unit;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.c;

public final class SelfieAnalyzeWorker$run$$inlined$mapNotNull$1 implements b<SelfieAnalyzeWorker.c> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f27197a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ SelfieAnalyzeWorker f27198b;

    public SelfieAnalyzeWorker$run$$inlined$mapNotNull$1(b bVar, SelfieAnalyzeWorker selfieAnalyzeWorker) {
        this.f27197a = bVar;
        this.f27198b = selfieAnalyzeWorker;
    }

    public Object a(final c cVar, kotlin.coroutines.c cVar2) {
        b bVar = this.f27197a;
        final SelfieAnalyzeWorker selfieAnalyzeWorker = this.f27198b;
        Object a10 = bVar.a(new c() {
            /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
            /* JADX WARNING: Removed duplicated region for block: B:33:0x00ac  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object c(java.lang.Object r9, kotlin.coroutines.c r10) {
                /*
                    r8 = this;
                    boolean r0 = r10 instanceof com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker$run$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r10
                    com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker$run$$inlined$mapNotNull$1$2$1 r0 = (com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker$run$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker$run$$inlined$mapNotNull$1$2$1 r0 = new com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker$run$$inlined$mapNotNull$1$2$1
                    r0.<init>(r8, r10)
                L_0x0018:
                    java.lang.Object r10 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
                    int r2 = r0.label
                    r3 = 0
                    r4 = 2
                    r5 = 1
                    if (r2 == 0) goto L_0x003e
                    if (r2 == r5) goto L_0x0036
                    if (r2 != r4) goto L_0x002e
                    gk.g.b(r10)
                    goto L_0x00b7
                L_0x002e:
                    java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                    java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                    r9.<init>(r10)
                    throw r9
                L_0x0036:
                    java.lang.Object r9 = r0.L$0
                    kotlinx.coroutines.flow.c r9 = (kotlinx.coroutines.flow.c) r9
                    gk.g.b(r10)
                    goto L_0x009d
                L_0x003e:
                    gk.g.b(r10)
                    kotlinx.coroutines.flow.c r10 = r4
                    kotlin.Result r9 = (kotlin.Result) r9
                    java.lang.Object r9 = r9.j()
                    java.lang.Throwable r2 = kotlin.Result.e(r9)
                    if (r2 != 0) goto L_0x0075
                    com.withpersona.sdk2.camera.w r9 = (com.withpersona.sdk2.camera.w) r9
                    com.withpersona.sdk2.inquiry.selfie.Selfie$Direction r2 = com.withpersona.sdk2.inquiry.selfie.q.b(r9)
                    com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker r5 = r2
                    com.withpersona.sdk2.inquiry.selfie.Selfie$Direction r5 = r5.f27195d
                    if (r2 != r5) goto L_0x006d
                    com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker$c$b r2 = new com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker$c$b
                    com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker r5 = r2
                    android.content.Context r5 = r5.f27193b
                    com.withpersona.sdk2.inquiry.selfie.Selfie r9 = com.withpersona.sdk2.inquiry.selfie.q.a(r9, r5)
                    r2.<init>(r9)
                    goto L_0x00aa
                L_0x006d:
                    com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker$c$c r2 = new com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker$c$c
                    com.withpersona.sdk2.inquiry.selfie.SelfieError r9 = com.withpersona.sdk2.inquiry.selfie.SelfieError.IncorrectPose
                    r2.<init>(r9)
                    goto L_0x00aa
                L_0x0075:
                    boolean r9 = r2 instanceof com.withpersona.sdk2.camera.SelfieCaptureException.FaceDetectionUnsupportedError
                    if (r9 == 0) goto L_0x00a0
                    com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker r9 = r2
                    int r2 = r9.f27196e
                    int r2 = r2 + r5
                    r9.f27196e = r2
                    com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker r9 = r2
                    int r9 = r9.f27196e
                    r2 = 6
                    if (r9 < r2) goto L_0x008f
                    com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker$c$a r9 = com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker.c.a.f27203a
                    goto L_0x00a9
                L_0x008f:
                    r6 = 500(0x1f4, double:2.47E-321)
                    r0.L$0 = r10
                    r0.label = r5
                    java.lang.Object r9 = kotlinx.coroutines.s0.a(r6, r0)
                    if (r9 != r1) goto L_0x009c
                    return r1
                L_0x009c:
                    r9 = r10
                L_0x009d:
                    r10 = r9
                    r9 = r3
                    goto L_0x00a9
                L_0x00a0:
                    com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker$c$c r9 = new com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker$c$c
                    com.withpersona.sdk2.inquiry.selfie.SelfieError r2 = com.withpersona.sdk2.inquiry.selfie.o.a(r2)
                    r9.<init>(r2)
                L_0x00a9:
                    r2 = r9
                L_0x00aa:
                    if (r2 == 0) goto L_0x00b7
                    r0.L$0 = r3
                    r0.label = r4
                    java.lang.Object r9 = r10.c(r2, r0)
                    if (r9 != r1) goto L_0x00b7
                    return r1
                L_0x00b7:
                    kotlin.Unit r9 = kotlin.Unit.f32013a
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.selfie.SelfieAnalyzeWorker$run$$inlined$mapNotNull$1.AnonymousClass2.c(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }, cVar2);
        if (a10 == b.d()) {
            return a10;
        }
        return Unit.f32013a;
    }
}
