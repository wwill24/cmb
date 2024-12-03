package d0;

import androidx.camera.video.internal.AudioSource;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AudioSource f14393a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Throwable f14394b;

    public /* synthetic */ f(AudioSource audioSource, Throwable th2) {
        this.f14393a = audioSource;
        this.f14394b = th2;
    }

    public final void run() {
        this.f14393a.p(this.f14394b);
    }
}
