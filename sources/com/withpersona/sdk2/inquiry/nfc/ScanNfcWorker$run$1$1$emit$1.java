package com.withpersona.sdk2.inquiry.nfc;

import com.withpersona.sdk2.inquiry.nfc.ScanNfcWorker$run$1;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.withpersona.sdk2.inquiry.nfc.ScanNfcWorker$run$1$1", f = "ScanNfcWorker.kt", l = {47, 49}, m = "emit")
final class ScanNfcWorker$run$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ScanNfcWorker$run$1.AnonymousClass1<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScanNfcWorker$run$1$1$emit$1(ScanNfcWorker$run$1.AnonymousClass1<? super T> r12, c<? super ScanNfcWorker$run$1$1$emit$1> cVar) {
        super(cVar);
        this.this$0 = r12;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c((PassportNfcReaderOutput) null, this);
    }
}
