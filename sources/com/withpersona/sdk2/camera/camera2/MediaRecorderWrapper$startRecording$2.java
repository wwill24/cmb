package com.withpersona.sdk2.camera.camera2;

import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.camera.camera2.MediaRecorderWrapper$startRecording$2", f = "MediaRecorderWrapper.kt", l = {}, m = "invokeSuspend")
final class MediaRecorderWrapper$startRecording$2 extends SuspendLambda implements Function2<k0, c<? super Unit>, Object> {
    int label;
    final /* synthetic */ MediaRecorderWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaRecorderWrapper$startRecording$2(MediaRecorderWrapper mediaRecorderWrapper, c<? super MediaRecorderWrapper$startRecording$2> cVar) {
        super(2, cVar);
        this.this$0 = mediaRecorderWrapper;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new MediaRecorderWrapper$startRecording$2(this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super Unit> cVar) {
        return ((MediaRecorderWrapper$startRecording$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            this.this$0.f14324h.start();
            return Unit.f32013a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
