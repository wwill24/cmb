package com.withpersona.sdk2.inquiry.selfie;

import com.withpersona.sdk2.inquiry.selfie.SelfieDetectWorker;
import kotlin.Unit;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.c;

public final class SelfieDetectWorker$run$$inlined$map$1 implements b<SelfieDetectWorker.a> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f27214a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ SelfieDetectWorker f27215b;

    public SelfieDetectWorker$run$$inlined$map$1(b bVar, SelfieDetectWorker selfieDetectWorker) {
        this.f27214a = bVar;
        this.f27215b = selfieDetectWorker;
    }

    public Object a(final c cVar, kotlin.coroutines.c cVar2) {
        b bVar = this.f27214a;
        final SelfieDetectWorker selfieDetectWorker = this.f27215b;
        Object a10 = bVar.a(new c() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object c(java.lang.Object r5, kotlin.coroutines.c r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof com.withpersona.sdk2.inquiry.selfie.SelfieDetectWorker$run$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    com.withpersona.sdk2.inquiry.selfie.SelfieDetectWorker$run$$inlined$map$1$2$1 r0 = (com.withpersona.sdk2.inquiry.selfie.SelfieDetectWorker$run$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    com.withpersona.sdk2.inquiry.selfie.SelfieDetectWorker$run$$inlined$map$1$2$1 r0 = new com.withpersona.sdk2.inquiry.selfie.SelfieDetectWorker$run$$inlined$map$1$2$1
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    gk.g.b(r6)
                    goto L_0x0067
                L_0x0029:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x0031:
                    gk.g.b(r6)
                    kotlinx.coroutines.flow.c r6 = r4
                    kotlin.Result r5 = (kotlin.Result) r5
                    java.lang.Object r5 = r5.j()
                    java.lang.Throwable r2 = kotlin.Result.e(r5)
                    if (r2 != 0) goto L_0x0054
                    com.withpersona.sdk2.camera.w r5 = (com.withpersona.sdk2.camera.w) r5
                    boolean r5 = r5 instanceof com.withpersona.sdk2.camera.w.a
                    if (r5 == 0) goto L_0x004b
                    com.withpersona.sdk2.inquiry.selfie.SelfieDetectWorker$a$b r5 = com.withpersona.sdk2.inquiry.selfie.SelfieDetectWorker.a.b.f27219a
                    goto L_0x005e
                L_0x004b:
                    com.withpersona.sdk2.inquiry.selfie.SelfieDetectWorker r5 = r2
                    com.withpersona.sdk2.inquiry.selfie.SelfieError r2 = com.withpersona.sdk2.inquiry.selfie.SelfieError.IncorrectPose
                    com.withpersona.sdk2.inquiry.selfie.SelfieDetectWorker$a$a r5 = r5.c(r2)
                    goto L_0x005e
                L_0x0054:
                    com.withpersona.sdk2.inquiry.selfie.SelfieDetectWorker r5 = r2
                    com.withpersona.sdk2.inquiry.selfie.SelfieError r2 = com.withpersona.sdk2.inquiry.selfie.o.a(r2)
                    com.withpersona.sdk2.inquiry.selfie.SelfieDetectWorker$a$a r5 = r5.c(r2)
                L_0x005e:
                    r0.label = r3
                    java.lang.Object r5 = r6.c(r5, r0)
                    if (r5 != r1) goto L_0x0067
                    return r1
                L_0x0067:
                    kotlin.Unit r5 = kotlin.Unit.f32013a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.selfie.SelfieDetectWorker$run$$inlined$map$1.AnonymousClass2.c(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }, cVar2);
        if (a10 == b.d()) {
            return a10;
        }
        return Unit.f32013a;
    }
}
