package com.withpersona.sdk2.inquiry.launchers;

import com.withpersona.sdk2.inquiry.launchers.DocumentSelectWorker;
import kotlin.Unit;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.c;

public final class DocumentSelectWorker$run$$inlined$map$1 implements b<DocumentSelectWorker.a> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f26928a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ DocumentSelectWorker f26929b;

    public DocumentSelectWorker$run$$inlined$map$1(b bVar, DocumentSelectWorker documentSelectWorker) {
        this.f26928a = bVar;
        this.f26929b = documentSelectWorker;
    }

    public Object a(final c cVar, kotlin.coroutines.c cVar2) {
        b bVar = this.f26928a;
        final DocumentSelectWorker documentSelectWorker = this.f26929b;
        Object a10 = bVar.a(new c() {
            /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c4, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
                kotlin.io.b.a(r10, r11);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c8, code lost:
                throw r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ca, code lost:
                r11 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:34:0x00cb, code lost:
                kotlin.io.b.a(r2, r10);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ce, code lost:
                throw r11;
             */
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object c(java.lang.Object r10, kotlin.coroutines.c r11) {
                /*
                    r9 = this;
                    boolean r0 = r11 instanceof com.withpersona.sdk2.inquiry.launchers.DocumentSelectWorker$run$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r11
                    com.withpersona.sdk2.inquiry.launchers.DocumentSelectWorker$run$$inlined$map$1$2$1 r0 = (com.withpersona.sdk2.inquiry.launchers.DocumentSelectWorker$run$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    com.withpersona.sdk2.inquiry.launchers.DocumentSelectWorker$run$$inlined$map$1$2$1 r0 = new com.withpersona.sdk2.inquiry.launchers.DocumentSelectWorker$run$$inlined$map$1$2$1
                    r0.<init>(r9, r11)
                L_0x0018:
                    java.lang.Object r11 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.b.d()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0032
                    if (r2 != r3) goto L_0x002a
                    gk.g.b(r11)
                    goto L_0x00da
                L_0x002a:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r11)
                    throw r10
                L_0x0032:
                    gk.g.b(r11)
                    kotlinx.coroutines.flow.c r11 = r4
                    android.net.Uri r10 = (android.net.Uri) r10
                    if (r10 == 0) goto L_0x00cf
                    com.withpersona.sdk2.inquiry.launchers.DocumentSelectWorker r2 = r2
                    android.content.Context r2 = r2.f26927c
                    android.content.ContentResolver r2 = r2.getContentResolver()
                    java.lang.String r2 = r2.getType(r10)
                    com.withpersona.sdk2.inquiry.launchers.DocumentSelectWorker r4 = r2
                    java.lang.String r4 = r4.c(r10)
                    android.webkit.MimeTypeMap r5 = android.webkit.MimeTypeMap.getSingleton()
                    java.lang.String r2 = r5.getExtensionFromMimeType(r2)
                    if (r2 != 0) goto L_0x0061
                    java.lang.String r2 = r10.toString()
                    java.lang.String r2 = android.webkit.MimeTypeMap.getFileExtensionFromUrl(r2)
                L_0x0061:
                    java.io.File r5 = new java.io.File
                    com.withpersona.sdk2.inquiry.launchers.DocumentSelectWorker r6 = r2
                    android.content.Context r6 = r6.f26927c
                    java.lang.String r7 = ""
                    java.io.File r6 = r6.getExternalFilesDir(r7)
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    r7.<init>()
                    java.lang.String r8 = "document_upload_"
                    r7.append(r8)
                    java.util.UUID r8 = java.util.UUID.randomUUID()
                    r7.append(r8)
                    r8 = 46
                    r7.append(r8)
                    r7.append(r2)
                    java.lang.String r2 = r7.toString()
                    r5.<init>(r6, r2)
                    com.withpersona.sdk2.inquiry.launchers.DocumentSelectWorker r2 = r2
                    android.content.Context r2 = r2.f26927c
                    android.content.ContentResolver r2 = r2.getContentResolver()
                    java.io.InputStream r10 = r2.openInputStream(r10)
                    kotlin.jvm.internal.j.d(r10)
                    java.io.FileOutputStream r2 = new java.io.FileOutputStream
                    r2.<init>(r5)
                    r6 = 0
                    r7 = 2
                    r8 = 0
                    kotlin.io.a.b(r10, r2, r6, r7, r8)     // Catch:{ all -> 0x00c2 }
                    kotlin.io.b.a(r10, r8)     // Catch:{ all -> 0x00c0 }
                    kotlin.io.b.a(r2, r8)
                    com.withpersona.sdk2.inquiry.launchers.DocumentSelectWorker$a$b r10 = new com.withpersona.sdk2.inquiry.launchers.DocumentSelectWorker$a$b
                    java.lang.String r2 = r5.getAbsolutePath()
                    java.lang.String r5 = "localFile.absolutePath"
                    kotlin.jvm.internal.j.f(r2, r5)
                    r10.<init>(r2, r4)
                    goto L_0x00d1
                L_0x00c0:
                    r10 = move-exception
                    goto L_0x00c9
                L_0x00c2:
                    r11 = move-exception
                    throw r11     // Catch:{ all -> 0x00c4 }
                L_0x00c4:
                    r0 = move-exception
                    kotlin.io.b.a(r10, r11)     // Catch:{ all -> 0x00c0 }
                    throw r0     // Catch:{ all -> 0x00c0 }
                L_0x00c9:
                    throw r10     // Catch:{ all -> 0x00ca }
                L_0x00ca:
                    r11 = move-exception
                    kotlin.io.b.a(r2, r10)
                    throw r11
                L_0x00cf:
                    com.withpersona.sdk2.inquiry.launchers.DocumentSelectWorker$a$a r10 = com.withpersona.sdk2.inquiry.launchers.DocumentSelectWorker.a.C0320a.f26932a
                L_0x00d1:
                    r0.label = r3
                    java.lang.Object r10 = r11.c(r10, r0)
                    if (r10 != r1) goto L_0x00da
                    return r1
                L_0x00da:
                    kotlin.Unit r10 = kotlin.Unit.f32013a
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.launchers.DocumentSelectWorker$run$$inlined$map$1.AnonymousClass2.c(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
            }
        }, cVar2);
        if (a10 == b.d()) {
            return a10;
        }
        return Unit.f32013a;
    }
}
