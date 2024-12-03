package androidx.camera.core;

public class CameraUnavailableException extends Exception {
    private final int mReason;

    public CameraUnavailableException(int i10, Throwable th2) {
        super(th2);
        this.mReason = i10;
    }
}
