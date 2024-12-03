package com.withpersona.sdk2.camera;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

@d(c = "com.withpersona.sdk2.camera.RecordingHelper", f = "RecordingHelper.kt", l = {90}, m = "stop-IoAF18A")
final class RecordingHelper$stop$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecordingHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecordingHelper$stop$1(RecordingHelper recordingHelper, c<? super RecordingHelper$stop$1> cVar) {
        super(cVar);
        this.this$0 = recordingHelper;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object e10 = this.this$0.e(this);
        return e10 == b.d() ? e10 : Result.a(e10);
    }
}
