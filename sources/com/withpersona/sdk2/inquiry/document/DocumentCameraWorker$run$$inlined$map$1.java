package com.withpersona.sdk2.inquiry.document;

import com.withpersona.sdk2.inquiry.document.DocumentCameraWorker;
import kotlin.Unit;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.c;

public final class DocumentCameraWorker$run$$inlined$map$1 implements b<DocumentCameraWorker.a> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f24957a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ DocumentCameraWorker f24958b;

    public DocumentCameraWorker$run$$inlined$map$1(b bVar, DocumentCameraWorker documentCameraWorker) {
        this.f24957a = bVar;
        this.f24958b = documentCameraWorker;
    }

    public Object a(final c cVar, kotlin.coroutines.c cVar2) {
        b bVar = this.f24957a;
        final DocumentCameraWorker documentCameraWorker = this.f24958b;
        Object a10 = bVar.a(new c() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object c(java.lang.Object r8, kotlin.coroutines.c r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof com.withpersona.sdk2.inquiry.document.DocumentCameraWorker$run$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r9
                    com.withpersona.sdk2.inquiry.document.DocumentCameraWorker$run$$inlined$map$1$2$1 r0 = (com.withpersona.sdk2.inquiry.document.DocumentCameraWorker$run$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    com.withpersona.sdk2.inquiry.document.DocumentCameraWorker$run$$inlined$map$1$2$1 r0 = new com.withpersona.sdk2.inquiry.document.DocumentCameraWorker$run$$inlined$map$1$2$1
                    r0.<init>(r7, r9)
                L_0x0018:
                    java.lang.Object r9 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    gk.g.b(r9)
                    goto L_0x0092
                L_0x0029:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L_0x0031:
                    gk.g.b(r9)
                    kotlinx.coroutines.flow.c r9 = r4
                    java.lang.Boolean r8 = (java.lang.Boolean) r8
                    boolean r8 = r8.booleanValue()
                    if (r8 == 0) goto L_0x0087
                    com.withpersona.sdk2.inquiry.document.DocumentCameraWorker r8 = r2
                    java.io.File r8 = r8.e()
                    java.io.File r2 = new java.io.File
                    com.withpersona.sdk2.inquiry.document.DocumentCameraWorker r4 = r2
                    android.content.Context r4 = r4.f24956c
                    java.lang.String r5 = ""
                    java.io.File r4 = r4.getExternalFilesDir(r5)
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                    java.lang.String r6 = "document_camera_"
                    r5.append(r6)
                    java.util.UUID r6 = java.util.UUID.randomUUID()
                    r5.append(r6)
                    java.lang.String r6 = ".jpg"
                    r5.append(r6)
                    java.lang.String r5 = r5.toString()
                    r2.<init>(r4, r5)
                    boolean r8 = r8.renameTo(r2)
                    if (r8 == 0) goto L_0x0084
                    com.withpersona.sdk2.inquiry.document.DocumentCameraWorker$a$b r8 = new com.withpersona.sdk2.inquiry.document.DocumentCameraWorker$a$b
                    java.lang.String r2 = r2.getAbsolutePath()
                    java.lang.String r4 = "renamedFile.absolutePath"
                    kotlin.jvm.internal.j.f(r2, r4)
                    r8.<init>(r2)
                    goto L_0x0089
                L_0x0084:
                    com.withpersona.sdk2.inquiry.document.DocumentCameraWorker$a$a r8 = com.withpersona.sdk2.inquiry.document.DocumentCameraWorker.a.C0299a.f24961a
                    goto L_0x0089
                L_0x0087:
                    com.withpersona.sdk2.inquiry.document.DocumentCameraWorker$a$a r8 = com.withpersona.sdk2.inquiry.document.DocumentCameraWorker.a.C0299a.f24961a
                L_0x0089:
                    r0.label = r3
                    java.lang.Object r8 = r9.c(r8, r0)
                    if (r8 != r1) goto L_0x0092
                    return r1
                L_0x0092:
                    kotlin.Unit r8 = kotlin.Unit.f32013a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.document.DocumentCameraWorker$run$$inlined$map$1.AnonymousClass2.c(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }, cVar2);
        if (a10 == b.d()) {
            return a10;
        }
        return Unit.f32013a;
    }
}
