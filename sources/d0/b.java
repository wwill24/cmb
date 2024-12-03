package d0;

import androidx.camera.video.internal.AudioSource;
import androidx.camera.video.internal.BufferProvider;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AudioSource f14386a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BufferProvider f14387b;

    public /* synthetic */ b(AudioSource audioSource, BufferProvider bufferProvider) {
        this.f14386a = audioSource;
        this.f14387b = bufferProvider;
    }

    public final void run() {
        this.f14386a.t(this.f14387b);
    }
}
