package com.withpersona.sdk2.inquiry.document.network;

import com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker;
import com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$run$1;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.withpersona.sdk2.inquiry.document.network.DocumentFileUploadWorker$run$1$1", f = "DocumentFileUploadWorker.kt", l = {152}, m = "emit")
final class DocumentFileUploadWorker$run$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DocumentFileUploadWorker$run$1.AnonymousClass1<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DocumentFileUploadWorker$run$1$1$emit$1(DocumentFileUploadWorker$run$1.AnonymousClass1<? super T> r12, c<? super DocumentFileUploadWorker$run$1$1$emit$1> cVar) {
        super(cVar);
        this.this$0 = r12;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c((DocumentFileUploadWorker.b) null, this);
    }
}
