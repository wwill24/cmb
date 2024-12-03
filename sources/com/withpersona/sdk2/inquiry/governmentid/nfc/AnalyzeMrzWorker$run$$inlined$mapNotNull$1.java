package com.withpersona.sdk2.inquiry.governmentid.nfc;

import com.withpersona.sdk2.inquiry.governmentid.nfc.AnalyzeMrzWorker;
import kotlin.Unit;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.c;

public final class AnalyzeMrzWorker$run$$inlined$mapNotNull$1 implements b<AnalyzeMrzWorker.b> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f25898a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AnalyzeMrzWorker f25899b;

    public AnalyzeMrzWorker$run$$inlined$mapNotNull$1(b bVar, AnalyzeMrzWorker analyzeMrzWorker) {
        this.f25898a = bVar;
        this.f25899b = analyzeMrzWorker;
    }

    public Object a(final c cVar, kotlin.coroutines.c cVar2) {
        b bVar = this.f25898a;
        final AnalyzeMrzWorker analyzeMrzWorker = this.f25899b;
        Object a10 = bVar.a(new c() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object c(java.lang.Object r6, kotlin.coroutines.c r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof com.withpersona.sdk2.inquiry.governmentid.nfc.AnalyzeMrzWorker$run$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r7
                    com.withpersona.sdk2.inquiry.governmentid.nfc.AnalyzeMrzWorker$run$$inlined$mapNotNull$1$2$1 r0 = (com.withpersona.sdk2.inquiry.governmentid.nfc.AnalyzeMrzWorker$run$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    com.withpersona.sdk2.inquiry.governmentid.nfc.AnalyzeMrzWorker$run$$inlined$mapNotNull$1$2$1 r0 = new com.withpersona.sdk2.inquiry.governmentid.nfc.AnalyzeMrzWorker$run$$inlined$mapNotNull$1$2$1
                    r0.<init>(r5, r7)
                L_0x0018:
                    java.lang.Object r7 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    gk.g.b(r7)
                    goto L_0x0086
                L_0x0029:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L_0x0031:
                    gk.g.b(r7)
                    kotlinx.coroutines.flow.c r7 = r4
                    kotlin.Result r6 = (kotlin.Result) r6
                    java.lang.Object r6 = r6.j()
                    java.lang.Throwable r2 = kotlin.Result.e(r6)
                    r4 = 0
                    if (r2 != 0) goto L_0x007b
                    com.withpersona.sdk2.camera.ParsedIdSideOrNone r6 = (com.withpersona.sdk2.camera.ParsedIdSideOrNone) r6
                    boolean r2 = r6 instanceof com.withpersona.sdk2.camera.ParsedIdSideOrNone.b
                    if (r2 == 0) goto L_0x007b
                    com.withpersona.sdk2.camera.ParsedIdSideOrNone$b r6 = (com.withpersona.sdk2.camera.ParsedIdSideOrNone.b) r6
                    com.withpersona.sdk2.camera.e r6 = r6.c()
                    boolean r2 = r6 instanceof com.withpersona.sdk2.camera.e.a
                    if (r2 == 0) goto L_0x007b
                    com.withpersona.sdk2.inquiry.governmentid.nfc.AnalyzeMrzWorker r2 = r2
                    com.withpersona.sdk2.camera.e$a r6 = (com.withpersona.sdk2.camera.e.a) r6
                    com.withpersona.sdk2.inquiry.governmentid.PassportNfcKeys r6 = r2.e(r6)
                    com.withpersona.sdk2.inquiry.governmentid.nfc.AnalyzeMrzWorker r2 = r2
                    com.withpersona.sdk2.inquiry.governmentid.PassportNfcKeys r2 = r2.f25897c
                    if (r2 == 0) goto L_0x0076
                    com.withpersona.sdk2.inquiry.governmentid.nfc.AnalyzeMrzWorker r2 = r2
                    com.withpersona.sdk2.inquiry.governmentid.PassportNfcKeys r2 = r2.f25897c
                    boolean r2 = kotlin.jvm.internal.j.b(r2, r6)
                    if (r2 == 0) goto L_0x0076
                    com.withpersona.sdk2.inquiry.governmentid.nfc.AnalyzeMrzWorker$b r2 = new com.withpersona.sdk2.inquiry.governmentid.nfc.AnalyzeMrzWorker$b
                    r2.<init>(r6)
                    r4 = r2
                    goto L_0x007b
                L_0x0076:
                    com.withpersona.sdk2.inquiry.governmentid.nfc.AnalyzeMrzWorker r2 = r2
                    r2.f25897c = r6
                L_0x007b:
                    if (r4 == 0) goto L_0x0086
                    r0.label = r3
                    java.lang.Object r6 = r7.c(r4, r0)
                    if (r6 != r1) goto L_0x0086
                    return r1
                L_0x0086:
                    kotlin.Unit r6 = kotlin.Unit.f32013a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.governmentid.nfc.AnalyzeMrzWorker$run$$inlined$mapNotNull$1.AnonymousClass2.c(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }, cVar2);
        if (a10 == b.d()) {
            return a10;
        }
        return Unit.f32013a;
    }
}
