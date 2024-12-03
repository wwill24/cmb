package androidx.camera.core.impl;

import android.hardware.camera2.CaptureResult;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.utils.ExifData;

public interface p {

    public static final class a implements p {
        @NonNull
        public static p h() {
            return new a();
        }

        @NonNull
        public CameraCaptureMetaData$FlashState a() {
            return CameraCaptureMetaData$FlashState.UNKNOWN;
        }

        @NonNull
        public a2 c() {
            return a2.a();
        }

        @NonNull
        public CameraCaptureMetaData$AfState e() {
            return CameraCaptureMetaData$AfState.UNKNOWN;
        }

        @NonNull
        public CameraCaptureMetaData$AwbState f() {
            return CameraCaptureMetaData$AwbState.UNKNOWN;
        }

        @NonNull
        public CameraCaptureMetaData$AeState g() {
            return CameraCaptureMetaData$AeState.UNKNOWN;
        }

        public long getTimestamp() {
            return -1;
        }
    }

    @NonNull
    CameraCaptureMetaData$FlashState a();

    void b(@NonNull ExifData.b bVar) {
        bVar.g(a());
    }

    @NonNull
    a2 c();

    @NonNull
    CaptureResult d() {
        return a.h().d();
    }

    @NonNull
    CameraCaptureMetaData$AfState e();

    @NonNull
    CameraCaptureMetaData$AwbState f();

    @NonNull
    CameraCaptureMetaData$AeState g();

    long getTimestamp();
}
