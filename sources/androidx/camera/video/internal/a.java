package androidx.camera.video.internal;

import androidx.camera.video.internal.AudioSource;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AudioSource.d f3182a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f3183b;

    public /* synthetic */ a(AudioSource.d dVar, boolean z10) {
        this.f3182a = dVar;
        this.f3183b = z10;
    }

    public final void run() {
        this.f3182a.b(this.f3183b);
    }
}
