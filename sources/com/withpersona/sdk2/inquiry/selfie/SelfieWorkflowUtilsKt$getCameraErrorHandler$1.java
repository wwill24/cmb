package com.withpersona.sdk2.inquiry.selfie;

import com.squareup.workflow1.h;
import com.squareup.workflow1.l;
import com.withpersona.sdk2.camera.CameraError;
import com.withpersona.sdk2.camera.FinalizeRecordingError;
import com.withpersona.sdk2.camera.NoActiveRecordingError;
import com.withpersona.sdk2.camera.NoSuitableCameraError;
import com.withpersona.sdk2.camera.RecordingInterrupted;
import com.withpersona.sdk2.camera.RecordingTooLongError;
import com.withpersona.sdk2.camera.UnsupportedDevice;
import com.withpersona.sdk2.inquiry.network.InternalErrorInfo;
import com.withpersona.sdk2.inquiry.selfie.SelfieWorkflow;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class SelfieWorkflowUtilsKt$getCameraErrorHandler$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ h<SelfieWorkflow.b, SelfieState, SelfieWorkflow.c, Object>.a $this_getCameraErrorHandler;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelfieWorkflowUtilsKt$getCameraErrorHandler$1(h<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c, ? extends Object>.a aVar) {
        super(1);
        this.$this_getCameraErrorHandler = aVar;
    }

    public final void a(final Throwable th2) {
        j.g(th2, "cameraError");
        if (!(th2 instanceof CameraError)) {
            this.$this_getCameraErrorHandler.c().d(Workflows__WorkflowActionKt.c((String) null, new Function1<l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c, Unit>() {
                public final void a(l<? super SelfieWorkflow.b, SelfieState, ? extends SelfieWorkflow.c>.c cVar) {
                    j.g(cVar, "$this$action");
                    cVar.d(new SelfieWorkflow.c.C0329c(new InternalErrorInfo.CameraErrorInfo("Unexpected camera error with type " + th2.getClass().getCanonicalName())));
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((l.c) obj);
                    return Unit.f32013a;
                }
            }, 1, (Object) null));
            return;
        }
        CameraError cameraError = (CameraError) th2;
        if (cameraError instanceof NoActiveRecordingError) {
            return;
        }
        if (cameraError instanceof NoSuitableCameraError) {
            this.$this_getCameraErrorHandler.c().d(Workflows__WorkflowActionKt.c((String) null, AnonymousClass2.f27393a, 1, (Object) null));
        } else if (cameraError instanceof RecordingTooLongError) {
            this.$this_getCameraErrorHandler.c().d(Workflows__WorkflowActionKt.c((String) null, AnonymousClass3.f27394a, 1, (Object) null));
        } else if (cameraError instanceof FinalizeRecordingError) {
            this.$this_getCameraErrorHandler.c().d(Workflows__WorkflowActionKt.c((String) null, AnonymousClass4.f27395a, 1, (Object) null));
        } else if (cameraError instanceof UnsupportedDevice) {
            this.$this_getCameraErrorHandler.c().d(Workflows__WorkflowActionKt.c((String) null, AnonymousClass5.f27396a, 1, (Object) null));
        } else if (cameraError instanceof RecordingInterrupted) {
            this.$this_getCameraErrorHandler.c().d(Workflows__WorkflowActionKt.c((String) null, AnonymousClass6.f27397a, 1, (Object) null));
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f32013a;
    }
}
