package androidx.camera.view;

import android.graphics.SurfaceTexture;
import androidx.camera.view.PreviewView;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreviewView.d f3525a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceTexture f3526b;

    public /* synthetic */ y(PreviewView.d dVar, SurfaceTexture surfaceTexture) {
        this.f3525a = dVar;
        this.f3526b = surfaceTexture;
    }

    public final void run() {
        this.f3525a.a(this.f3526b.getTimestamp());
    }
}
