package androidx.camera.core.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.camera.core.InitializationException;

public interface UseCaseConfigFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final UseCaseConfigFactory f2446a = new a();

    public enum CaptureType {
        IMAGE_CAPTURE,
        PREVIEW,
        IMAGE_ANALYSIS,
        VIDEO_CAPTURE
    }

    class a implements UseCaseConfigFactory {
        a() {
        }

        public Config a(@NonNull CaptureType captureType, int i10) {
            return null;
        }
    }

    public interface b {
        @NonNull
        UseCaseConfigFactory a(@NonNull Context context) throws InitializationException;
    }

    Config a(@NonNull CaptureType captureType, int i10);
}
