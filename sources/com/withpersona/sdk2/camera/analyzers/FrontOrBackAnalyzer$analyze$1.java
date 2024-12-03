package com.withpersona.sdk2.camera.analyzers;

import android.graphics.Rect;
import com.withpersona.sdk2.camera.s;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.withpersona.sdk2.camera.analyzers.FrontOrBackAnalyzer", f = "FrontOrBackAnalyzer.kt", l = {27}, m = "analyze-0E7RQCE")
final class FrontOrBackAnalyzer$analyze$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FrontOrBackAnalyzer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FrontOrBackAnalyzer$analyze$1(FrontOrBackAnalyzer frontOrBackAnalyzer, c<? super FrontOrBackAnalyzer$analyze$1> cVar) {
        super(cVar);
        this.this$0 = frontOrBackAnalyzer;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object a10 = this.this$0.a((s) null, (Rect) null, this);
        return a10 == b.d() ? a10 : Result.a(a10);
    }
}
