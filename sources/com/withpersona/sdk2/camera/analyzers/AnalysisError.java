package com.withpersona.sdk2.camera.analyzers;

import kotlin.jvm.internal.DefaultConstructorMarker;

public abstract class AnalysisError extends RuntimeException {

    public static final class DetectorError extends AnalysisError {
        public DetectorError() {
            super((DefaultConstructorMarker) null);
        }
    }

    public static final class GooglePlayError extends AnalysisError {
        public GooglePlayError() {
            super((DefaultConstructorMarker) null);
        }
    }

    public static final class NoAnalyzerError extends AnalysisError {
        public NoAnalyzerError() {
            super((DefaultConstructorMarker) null);
        }
    }

    private AnalysisError() {
    }

    public /* synthetic */ AnalysisError(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
