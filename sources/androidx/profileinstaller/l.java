package androidx.profileinstaller;

import android.view.Choreographer;

public final /* synthetic */ class l implements Choreographer.FrameCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f6174a;

    public /* synthetic */ l(Runnable runnable) {
        this.f6174a = runnable;
    }

    public final void doFrame(long j10) {
        this.f6174a.run();
    }
}
