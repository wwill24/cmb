package com.withpersona.sdk2.inquiry.governmentid.video_capture;

import com.squareup.workflow1.h;
import com.withpersona.sdk2.inquiry.governmentid.Frame;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentId;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdState;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflow;
import com.withpersona.sdk2.inquiry.governmentid.GovernmentIdWorkflowUtilsKt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class VideoCaptureRenderer$renderFinalizeVideo$8 extends Lambda implements Function1<File, Unit> {
    final /* synthetic */ h<GovernmentIdWorkflow.a, GovernmentIdState, GovernmentIdWorkflow.b, Object>.a $context;
    final /* synthetic */ GovernmentIdWorkflow.a $renderProps;
    final /* synthetic */ GovernmentIdState.FinalizeVideo $renderState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoCaptureRenderer$renderFinalizeVideo$8(GovernmentIdState.FinalizeVideo finalizeVideo, h<? super GovernmentIdWorkflow.a, GovernmentIdState, ? extends GovernmentIdWorkflow.b, ? extends Object>.a aVar, GovernmentIdWorkflow.a aVar2) {
        super(1);
        this.$renderState = finalizeVideo;
        this.$context = aVar;
        this.$renderProps = aVar2;
    }

    public final void a(File file) {
        j.g(file, "it");
        List<GovernmentId> j10 = this.$renderState.j();
        ArrayList arrayList = new ArrayList(r.t(j10, 10));
        for (GovernmentId I0 : j10) {
            arrayList.add(I0.I0());
        }
        GovernmentId.Side side = GovernmentId.Side.FRONT;
        boolean contains = arrayList.contains(side);
        GovernmentId.Side side2 = GovernmentId.Side.BACK;
        boolean contains2 = arrayList.contains(side2);
        String absolutePath = file.getAbsolutePath();
        j.f(absolutePath, "it.absolutePath");
        List e10 = p.e(new Frame(absolutePath, "video/*"));
        if (contains && contains2) {
            side = GovernmentId.Side.FRONT_AND_BACK;
        } else if (!contains && contains2) {
            side = side2;
        }
        GovernmentId.GovernmentIdVideo governmentIdVideo = new GovernmentId.GovernmentIdVideo(e10, side, this.$renderState.o().g1(), GovernmentId.CaptureMethod.f25319b);
        GovernmentIdState.FinalizeVideo finalizeVideo = this.$renderState;
        GovernmentIdWorkflowUtilsKt.i(finalizeVideo, this.$context, this.$renderProps, governmentIdVideo, finalizeVideo.o(), false, (List) null, 0, 192, (Object) null);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((File) obj);
        return Unit.f32013a;
    }
}
