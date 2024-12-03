package com.withpersona.sdk2.inquiry.document.network;

import com.withpersona.sdk2.inquiry.network.NetworkCallResult;
import com.withpersona.sdk2.inquiry.network.NetworkUtilsKt;
import gk.g;
import java.io.File;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.k0;
import okhttp3.w;
import retrofit2.r;

@d(c = "com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$run$1$result$1", f = "DocumentFileUploadWorker.kt", l = {54}, m = "invokeSuspend")
final class DocumentFileUploadWorker$run$1$result$1 extends SuspendLambda implements Function2<k0, c<? super NetworkCallResult<DocumentFileUploadResponse>>, Object> {
    final /* synthetic */ b $fileReqBody;
    int label;
    final /* synthetic */ DocumentFileUploadWorker this$0;

    @d(c = "com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$run$1$result$1$1", f = "DocumentFileUploadWorker.kt", l = {55}, m = "invokeSuspend")
    /* renamed from: com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$run$1$result$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function1<c<? super r<DocumentFileUploadResponse>>, Object> {
        int label;

        public final c<Unit> create(c<?> cVar) {
            return new AnonymousClass1(documentFileUploadWorker, bVar, cVar);
        }

        /* renamed from: i */
        public final Object invoke(c<? super r<DocumentFileUploadResponse>> cVar) {
            return ((AnonymousClass1) create(cVar)).invokeSuspend(Unit.f32013a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d10 = b.d();
            int i10 = this.label;
            if (i10 == 0) {
                g.b(obj);
                a e10 = documentFileUploadWorker.f25221c;
                String g10 = documentFileUploadWorker.f25220b;
                w.c.a aVar = w.c.f33214c;
                String name = new File(documentFileUploadWorker.f25223e.d()).getName();
                j.f(name, "File(localDocument.absoluteFilePath).name");
                List m10 = q.m(aVar.b("data[type]", "document-file"), aVar.b("data[attributes][document-id]", documentFileUploadWorker.f25222d), aVar.b("data[attributes][capture-method]", documentFileUploadWorker.f25223e.e().c()), aVar.c("data[attributes][originals][]", documentFileUploadWorker.f25223e.d(), bVar), aVar.b("data[attributes][name]", name));
                this.label = 1;
                obj = e10.c(g10, m10, this);
                if (obj == d10) {
                    return d10;
                }
            } else if (i10 == 1) {
                g.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentFileUploadWorker$run$1$result$1(DocumentFileUploadWorker documentFileUploadWorker, b bVar, c<? super DocumentFileUploadWorker$run$1$result$1> cVar) {
        super(2, cVar);
        this.this$0 = documentFileUploadWorker;
        this.$fileReqBody = bVar;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new DocumentFileUploadWorker$run$1$result$1(this.this$0, this.$fileReqBody, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super NetworkCallResult<DocumentFileUploadResponse>> cVar) {
        return ((DocumentFileUploadWorker$run$1$result$1) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d10 = b.d();
        int i10 = this.label;
        if (i10 == 0) {
            g.b(obj);
            final DocumentFileUploadWorker documentFileUploadWorker = this.this$0;
            final b bVar = this.$fileReqBody;
            AnonymousClass1 r62 = new AnonymousClass1((c<? super AnonymousClass1>) null);
            this.label = 1;
            obj = NetworkUtilsKt.enqueueVerificationRequestWithRetry(r62, this);
            if (obj == d10) {
                return d10;
            }
        } else if (i10 == 1) {
            g.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
