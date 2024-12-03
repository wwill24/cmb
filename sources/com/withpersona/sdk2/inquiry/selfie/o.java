package com.withpersona.sdk2.inquiry.selfie;

import com.withpersona.sdk2.camera.SelfieCaptureException;
import kotlin.jvm.internal.j;

public final class o {
    public static final SelfieError a(Throwable th2) {
        j.g(th2, "<this>");
        if (th2 instanceof SelfieCaptureException.FaceNotCenteredError) {
            return SelfieError.FaceNotCentered;
        }
        if (th2 instanceof SelfieCaptureException.FaceTooCloseError) {
            return SelfieError.FaceTooClose;
        }
        if (th2 instanceof SelfieCaptureException.NoFaceError) {
            return SelfieError.FaceNotFound;
        }
        if (th2 instanceof SelfieCaptureException.InvalidPoseError) {
            return SelfieError.IncorrectPose;
        }
        if (th2 instanceof SelfieCaptureException.FaceDetectionUnsupportedError) {
            return SelfieError.FaceDetectionUnsupported;
        }
        return SelfieError.Other;
    }
}
