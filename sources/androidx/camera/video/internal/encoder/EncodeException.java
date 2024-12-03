package androidx.camera.video.internal.encoder;

public class EncodeException extends Exception {
    private final int mErrorType;

    public EncodeException(int i10, String str, Throwable th2) {
        super(str, th2);
        this.mErrorType = i10;
    }
}
