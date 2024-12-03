package t;

import androidx.camera.core.ImageCaptureException;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b0 f17617a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageCaptureException f17618b;

    public /* synthetic */ v(b0 b0Var, ImageCaptureException imageCaptureException) {
        this.f17617a = b0Var;
        this.f17618b = imageCaptureException;
    }

    public final void run() {
        this.f17617a.m(this.f17618b);
    }
}
