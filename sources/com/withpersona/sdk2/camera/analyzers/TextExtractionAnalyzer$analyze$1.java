package com.withpersona.sdk2.camera.analyzers;

import android.graphics.Rect;
import com.withpersona.sdk2.camera.s;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.withpersona.sdk2.camera.analyzers.TextExtractionAnalyzer", f = "TextExtractionAnalyzer.kt", l = {25}, m = "analyze-0E7RQCE")
final class TextExtractionAnalyzer$analyze$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TextExtractionAnalyzer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextExtractionAnalyzer$analyze$1(TextExtractionAnalyzer textExtractionAnalyzer, c<? super TextExtractionAnalyzer$analyze$1> cVar) {
        super(cVar);
        this.this$0 = textExtractionAnalyzer;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object a10 = this.this$0.a((s) null, (Rect) null, this);
        return a10 == b.d() ? a10 : Result.a(a10);
    }
}
