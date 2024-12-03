package androidx.camera.core;

import androidx.annotation.NonNull;

public class ImageCaptureException extends Exception {
    private final int mImageCaptureError;

    public ImageCaptureException(int i10, @NonNull String str, Throwable th2) {
        super(str, th2);
        this.mImageCaptureError = i10;
    }

    public int a() {
        return this.mImageCaptureError;
    }
}
