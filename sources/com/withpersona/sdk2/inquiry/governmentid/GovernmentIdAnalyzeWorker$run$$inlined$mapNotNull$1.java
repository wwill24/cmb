package com.withpersona.sdk2.inquiry.governmentid;

import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker;
import kotlin.Unit;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.c;

public final class GovernmentIdAnalyzeWorker$run$$inlined$mapNotNull$1 implements b<GovernmentIdAnalyzeWorker.b> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f25341a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ GovernmentIdAnalyzeWorker f25342b;

    public GovernmentIdAnalyzeWorker$run$$inlined$mapNotNull$1(b bVar, GovernmentIdAnalyzeWorker governmentIdAnalyzeWorker) {
        this.f25341a = bVar;
        this.f25342b = governmentIdAnalyzeWorker;
    }

    public Object a(final c cVar, kotlin.coroutines.c cVar2) {
        b bVar = this.f25341a;
        final GovernmentIdAnalyzeWorker governmentIdAnalyzeWorker = this.f25342b;
        Object a10 = bVar.a(new c() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object c(java.lang.Object r7, kotlin.coroutines.c r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker$run$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r8
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker$run$$inlined$mapNotNull$1$2$1 r0 = (com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker$run$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker$run$$inlined$mapNotNull$1$2$1 r0 = new com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker$run$$inlined$mapNotNull$1$2$1
                    r0.<init>(r6, r8)
                L_0x0018:
                    java.lang.Object r8 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    gk.g.b(r8)
                    goto L_0x0090
                L_0x0029:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L_0x0031:
                    gk.g.b(r8)
                    kotlinx.coroutines.flow.c r8 = r4
                    kotlin.Result r7 = (kotlin.Result) r7
                    java.lang.Object r7 = r7.j()
                    java.lang.Throwable r2 = kotlin.Result.e(r7)
                    if (r2 != 0) goto L_0x0083
                    com.withpersona.sdk2.camera.ParsedIdSideOrNone r7 = (com.withpersona.sdk2.camera.ParsedIdSideOrNone) r7
                    boolean r2 = r7 instanceof com.withpersona.sdk2.camera.ParsedIdSideOrNone.b
                    if (r2 == 0) goto L_0x0081
                    com.withpersona.sdk2.camera.ParsedIdSideOrNone$b r7 = (com.withpersona.sdk2.camera.ParsedIdSideOrNone.b) r7
                    com.withpersona.sdk2.camera.ImageIdMetadata r2 = r7.e()
                    if (r2 == 0) goto L_0x0075
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker r4 = r2
                    com.withpersona.sdk2.inquiry.governmentid.network.AutocaptureState r5 = r4.d()
                    com.withpersona.sdk2.inquiry.governmentid.network.AutocaptureState r2 = com.withpersona.sdk2.inquiry.governmentid.network.a.b(r5, r2)
                    r4.f(r2)
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker r2 = r2
                    com.withpersona.sdk2.inquiry.governmentid.network.AutocaptureState r2 = r2.d()
                    boolean r2 = com.withpersona.sdk2.inquiry.governmentid.network.a.a(r2)
                    if (r2 == 0) goto L_0x0081
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker$b$b r2 = new com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker$b$b
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker r4 = r2
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentId r7 = r4.c(r7)
                    r2.<init>(r7)
                    goto L_0x0085
                L_0x0075:
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker$b$b r2 = new com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker$b$b
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker r4 = r2
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentId r7 = r4.c(r7)
                    r2.<init>(r7)
                    goto L_0x0085
                L_0x0081:
                    r2 = 0
                    goto L_0x0085
                L_0x0083:
                    com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker$b$a r2 = com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker.b.a.f25347a
                L_0x0085:
                    if (r2 == 0) goto L_0x0090
                    r0.label = r3
                    java.lang.Object r7 = r8.c(r2, r0)
                    if (r7 != r1) goto L_0x0090
                    return r1
                L_0x0090:
                    kotlin.Unit r7 = kotlin.Unit.f32013a
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.GovernmentIdAnalyzeWorker$run$$inlined$mapNotNull$1.AnonymousClass2.c(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }, cVar2);
        if (a10 == b.d()) {
            return a10;
        }
        return Unit.f32013a;
    }
}
