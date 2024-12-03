package com.withpersona.sdk2.inquiry.launchers;

import com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;

@d(c = "com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker$run$1", f = "DocumentsSelectWorker.kt", l = {30, 34}, m = "invokeSuspend")
final class DocumentsSelectWorker$run$1 extends SuspendLambda implements Function2<c<? super DocumentsSelectWorker.a>, kotlin.coroutines.c<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DocumentsSelectWorker this$0;

    static final class a<T> implements c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DocumentsSelectWorker f26948a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c<DocumentsSelectWorker.a> f26949b;

        a(DocumentsSelectWorker documentsSelectWorker, c<? super DocumentsSelectWorker.a> cVar) {
            this.f26948a = documentsSelectWorker;
            this.f26949b = cVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0097, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            kotlin.io.b.a(r6, r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x009b, code lost:
            throw r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x009d, code lost:
            r6 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            kotlin.io.b.a(r7, r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a1, code lost:
            throw r6;
         */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00b0  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0033 A[SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object c(java.util.List<? extends android.net.Uri> r13, kotlin.coroutines.c<? super kotlin.Unit> r14) {
            /*
                r12 = this;
                android.webkit.MimeTypeMap r0 = android.webkit.MimeTypeMap.getSingleton()
                com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker r1 = r12.f26948a
                android.content.Context r1 = r1.f26936c
                android.content.ContentResolver r1 = r1.getContentResolver()
                boolean r2 = r13.isEmpty()
                if (r2 == 0) goto L_0x0026
                kotlinx.coroutines.flow.c<com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker$a> r13 = r12.f26949b
                com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker$a$a r0 = com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker.a.C0321a.f26944a
                java.lang.Object r13 = r13.c(r0, r14)
                java.lang.Object r14 = kotlin.coroutines.intrinsics.b.d()
                if (r13 != r14) goto L_0x0023
                return r13
            L_0x0023:
                kotlin.Unit r13 = kotlin.Unit.f32013a
                return r13
            L_0x0026:
                com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker r2 = r12.f26948a
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                java.util.Iterator r13 = r13.iterator()
                r4 = 0
                r5 = r4
            L_0x0033:
                boolean r6 = r13.hasNext()
                if (r6 == 0) goto L_0x00b5
                java.lang.Object r6 = r13.next()
                android.net.Uri r6 = (android.net.Uri) r6
                java.lang.String r7 = r1.getType(r6)     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                java.lang.String r7 = r0.getExtensionFromMimeType(r7)     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                java.io.File r8 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                android.content.Context r9 = r2.f26936c     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                java.lang.String r10 = ""
                java.io.File r9 = r9.getExternalFilesDir(r10)     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                r10.<init>()     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                java.lang.String r11 = "document_upload_"
                r10.append(r11)     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                java.util.UUID r11 = java.util.UUID.randomUUID()     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                r10.append(r11)     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                r11 = 46
                r10.append(r11)     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                r10.append(r7)     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                java.lang.String r7 = r10.toString()     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                r8.<init>(r9, r7)     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                java.io.InputStream r6 = r1.openInputStream(r6)     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                if (r6 == 0) goto L_0x00a2
                java.lang.String r7 = "contentResolver.openInpu…w FileNotFoundException()"
                kotlin.jvm.internal.j.f(r6, r7)     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                r7.<init>(r8)     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                r9 = 0
                r10 = 2
                kotlin.io.a.b(r6, r7, r9, r10, r4)     // Catch:{ all -> 0x0095 }
                kotlin.io.b.a(r6, r4)     // Catch:{ all -> 0x0093 }
                kotlin.io.b.a(r7, r4)     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                java.lang.String r6 = r8.getAbsolutePath()     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                goto L_0x00ae
            L_0x0093:
                r5 = move-exception
                goto L_0x009c
            L_0x0095:
                r5 = move-exception
                throw r5     // Catch:{ all -> 0x0097 }
            L_0x0097:
                r8 = move-exception
                kotlin.io.b.a(r6, r5)     // Catch:{ all -> 0x0093 }
                throw r8     // Catch:{ all -> 0x0093 }
            L_0x009c:
                throw r5     // Catch:{ all -> 0x009d }
            L_0x009d:
                r6 = move-exception
                kotlin.io.b.a(r7, r5)     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                throw r6     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
            L_0x00a2:
                java.io.FileNotFoundException r5 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                r5.<init>()     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
                throw r5     // Catch:{ FileNotFoundException -> 0x00ab, SecurityException -> 0x00a8 }
            L_0x00a8:
                com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker$Error r5 = com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker.Error.PermissionDenied
                goto L_0x00ad
            L_0x00ab:
                com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker$Error r5 = com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker.Error.FileNotFound
            L_0x00ad:
                r6 = r4
            L_0x00ae:
                if (r6 == 0) goto L_0x0033
                r3.add(r6)
                goto L_0x0033
            L_0x00b5:
                kotlinx.coroutines.flow.c<com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker$a> r13 = r12.f26949b
                if (r5 != 0) goto L_0x00c9
                com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker$a$c r0 = new com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker$a$c
                r0.<init>(r3)
                java.lang.Object r13 = r13.c(r0, r14)
                java.lang.Object r14 = kotlin.coroutines.intrinsics.b.d()
                if (r13 != r14) goto L_0x00d9
                return r13
            L_0x00c9:
                com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker$a$b r0 = new com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker$a$b
                r0.<init>(r3, r5)
                java.lang.Object r13 = r13.c(r0, r14)
                java.lang.Object r14 = kotlin.coroutines.intrinsics.b.d()
                if (r13 != r14) goto L_0x00d9
                return r13
            L_0x00d9:
                kotlin.Unit r13 = kotlin.Unit.f32013a
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker$run$1.a.c(java.util.List, kotlin.coroutines.c):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentsSelectWorker$run$1(DocumentsSelectWorker documentsSelectWorker, kotlin.coroutines.c<? super DocumentsSelectWorker$run$1> cVar) {
        super(2, cVar);
        this.this$0 = documentsSelectWorker;
    }

    public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
        DocumentsSelectWorker$run$1 documentsSelectWorker$run$1 = new DocumentsSelectWorker$run$1(this.this$0, cVar);
        documentsSelectWorker$run$1.L$0 = obj;
        return documentsSelectWorker$run$1;
    }

    /* renamed from: i */
    public final Object invoke(c<? super DocumentsSelectWorker.a> cVar, kotlin.coroutines.c<? super Unit> cVar2) {
        return ((DocumentsSelectWorker$run$1) create(cVar, cVar2)).invokeSuspend(Unit.f32013a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.flow.c} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.b.d()
            int r1 = r7.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 == r4) goto L_0x001b
            if (r1 == r3) goto L_0x0017
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0017:
            gk.g.b(r8)
            goto L_0x0058
        L_0x001b:
            java.lang.Object r1 = r7.L$0
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            gk.g.b(r8)
            goto L_0x0041
        L_0x0023:
            gk.g.b(r8)
            java.lang.Object r8 = r7.L$0
            r1 = r8
            kotlinx.coroutines.flow.c r1 = (kotlinx.coroutines.flow.c) r1
            kotlinx.coroutines.c2 r8 = kotlinx.coroutines.x0.c()
            com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker$run$1$1 r5 = new com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker$run$1$1
            com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker r6 = r7.this$0
            r5.<init>(r6, r2)
            r7.L$0 = r1
            r7.label = r4
            java.lang.Object r8 = kotlinx.coroutines.h.g(r8, r5, r7)
            if (r8 != r0) goto L_0x0041
            return r0
        L_0x0041:
            com.withpersona.sdk2.inquiry.launchers.n r8 = new com.withpersona.sdk2.inquiry.launchers.n
            r8.<init>()
            com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker$run$1$a r4 = new com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker$run$1$a
            com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker r5 = r7.this$0
            r4.<init>(r5, r1)
            r7.L$0 = r2
            r7.label = r3
            java.lang.Object r8 = r8.a(r4, r7)
            if (r8 != r0) goto L_0x0058
            return r0
        L_0x0058:
            kotlin.KotlinNothingValueException r8 = new kotlin.KotlinNothingValueException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.withpersona.sdk2.inquiry.launchers.DocumentsSelectWorker$run$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
