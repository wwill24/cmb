package com.withpersona.sdk2.camera;

import com.withpersona.sdk2.camera.RecordingHelper;
import gk.g;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.functions.Function2;

@d(c = "com.withpersona.sdk2.camera.RecordingHelper$stop$2", f = "RecordingHelper.kt", l = {}, m = "invokeSuspend")
final class RecordingHelper$stop$2 extends SuspendLambda implements Function2<RecordingHelper.RecordingState, c<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    RecordingHelper$stop$2(c<? super RecordingHelper$stop$2> cVar) {
        super(2, cVar);
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        RecordingHelper$stop$2 recordingHelper$stop$2 = new RecordingHelper$stop$2(cVar);
        recordingHelper$stop$2.L$0 = obj;
        return recordingHelper$stop$2;
    }

    /* renamed from: i */
    public final Object invoke(RecordingHelper.RecordingState recordingState, c<? super Boolean> cVar) {
        return ((RecordingHelper$stop$2) create(recordingState, cVar)).invokeSuspend(Unit.f32013a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = b.d();
        if (this.label == 0) {
            g.b(obj);
            return a.a(((RecordingHelper.RecordingState) this.L$0) != RecordingHelper.RecordingState.Finalized);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
