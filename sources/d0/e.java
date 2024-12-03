package d0;

import androidx.camera.video.internal.AudioSource;
import java.util.concurrent.Executor;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AudioSource f14390a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Executor f14391b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AudioSource.e f14392c;

    public /* synthetic */ e(AudioSource audioSource, Executor executor, AudioSource.e eVar) {
        this.f14390a = audioSource;
        this.f14391b = executor;
        this.f14392c = eVar;
    }

    public final void run() {
        this.f14390a.s(this.f14391b, this.f14392c);
    }
}
