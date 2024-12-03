package com.withpersona.sdk2.camera;

import kotlin.jvm.internal.DefaultConstructorMarker;

public abstract class SelfieCaptureException extends Exception {

    public static final class FaceDetectionUnsupportedError extends SelfieCaptureException {
        public FaceDetectionUnsupportedError() {
            super((DefaultConstructorMarker) null);
        }
    }

    public static final class FaceNotCenteredError extends SelfieCaptureException {
        public FaceNotCenteredError() {
            super((DefaultConstructorMarker) null);
        }
    }

    public static final class FaceTooCloseError extends SelfieCaptureException {
        public FaceTooCloseError() {
            super((DefaultConstructorMarker) null);
        }
    }

    public static final class InvalidPoseError extends SelfieCaptureException {
        public InvalidPoseError() {
            super((DefaultConstructorMarker) null);
        }
    }

    public static final class NoFaceError extends SelfieCaptureException {
        public NoFaceError() {
            super((DefaultConstructorMarker) null);
        }
    }

    public static final class TooManyFacesError extends SelfieCaptureException {
        public TooManyFacesError() {
            super((DefaultConstructorMarker) null);
        }
    }

    private SelfieCaptureException() {
    }

    public /* synthetic */ SelfieCaptureException(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
