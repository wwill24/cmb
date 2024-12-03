package com.withpersona.sdk2.camera.camera2;

import gk.g;
import java.io.File;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

@d(c = "com.withpersona.sdk2.camera.camera2.MediaRecorderWrapper$stopRecording$2", f = "MediaRecorderWrapper.kt", l = {}, m = "invokeSuspend")
final class MediaRecorderWrapper$stopRecording$2 extends SuspendLambda implements Function2<k0, c<? super File>, Object> {
    int label;
    final /* synthetic */ MediaRecorderWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaRecorderWrapper$stopRecording$2(MediaRecorderWrapper mediaRecorderWrapper, c<? super MediaRecorderWrapper$stopRecording$2> cVar) {
        super(2, cVar);
        this.this$0 = mediaRecorderWrapper;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new MediaRecorderWrapper$stopRecording$2(this.this$0, cVar);
    }

    public final Object invoke(k0 k0Var, c<? super File> cVar) {
        return ((MediaRecorderWrapper$stopRecording$2) create(k0Var, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            File file = null;
            try {
                this.this$0.f14324h.stop();
                file = this.this$0.f14323g;
            } catch (RuntimeException unused2) {
                this.this$0.f14323g.delete();
            }
            this.this$0.f14324h.release();
            MediaRecorderWrapper mediaRecorderWrapper = this.this$0;
            mediaRecorderWrapper.f14324h = mediaRecorderWrapper.j();
            this.this$0.k(false);
            return file;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
