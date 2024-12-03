package t;

import androidx.camera.core.ImageCaptureException;

public final /* synthetic */ class o0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p0 f17608a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageCaptureException f17609b;

    public /* synthetic */ o0(p0 p0Var, ImageCaptureException imageCaptureException) {
        this.f17608a = p0Var;
        this.f17609b = imageCaptureException;
    }

    public final void run() {
        this.f17608a.n(this.f17609b);
    }
}
