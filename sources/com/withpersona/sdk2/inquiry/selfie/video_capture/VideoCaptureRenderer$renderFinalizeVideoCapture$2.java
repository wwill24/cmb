package com.withpersona.sdk2.inquiry.selfie.video_capture;

import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.inquiry.selfie.Selfie;
import com.withpersona.sdk2.inquiry.selfie.SelfieState;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import java.io.File;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class VideoCaptureRenderer$renderFinalizeVideoCapture$2 extends Lambda implements Function1<File, Unit> {
    final /* synthetic */ h<SelfieWorkflow.b, SelfieState, SelfieWorkflow.c, Object>.a $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoCaptureRenderer$renderFinalizeVideoCapture$2(h<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c, ? extends Object>.a aVar) {
        super(1);
        this.$context = aVar;
    }

    public final void a(File file) {
        j.g(file, "it");
        String absolutePath = file.getAbsolutePath();
        j.f(absolutePath, "it.absolutePath");
        final List e10 = p.e(new Selfie.SelfieVideo(absolutePath, Selfie.CaptureMethod.MANUAL));
        this.$context.c().d(Workflows__WorkflowActionKt.c((String) null, new Function1<l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c, Unit>() {
            public final void a(l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c cVar) {
                SelfieState.FinalizeVideoCapture finalizeVideoCapture;
                j.g(cVar, "$this$action");
                Object c10 = cVar.c();
                if (c10 instanceof SelfieState.FinalizeVideoCapture) {
                    finalizeVideoCapture = (SelfieState.FinalizeVideoCapture) c10;
                } else {
                    finalizeVideoCapture = null;
                }
                SelfieState.FinalizeVideoCapture finalizeVideoCapture2 = finalizeVideoCapture;
                if (finalizeVideoCapture2 != null) {
                    cVar.e(SelfieState.FinalizeVideoCapture.i(finalizeVideoCapture2, CollectionsKt___CollectionsKt.h0(((SelfieState) cVar.c()).g(), e10), 0, false, true, 6, (Object) null));
                }
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((l.c) obj);
                return Unit.f32013a;
            }
        }, 1, (Object) null));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((File) obj);
        return Unit.f32013a;
    }
}
