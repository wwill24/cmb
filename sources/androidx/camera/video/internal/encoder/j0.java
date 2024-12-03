package androidx.camera.video.internal.encoder;

import androidx.camera.core.impl.l1;
import androidx.camera.video.internal.BufferProvider;

public final /* synthetic */ class j0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l1.a f3323a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BufferProvider.State f3324b;

    public /* synthetic */ j0(l1.a aVar, BufferProvider.State state) {
        this.f3323a = aVar;
        this.f3324b = state;
    }

    public final void run() {
        this.f3323a.a(this.f3324b);
    }
}
