package androidx.camera.video.internal.encoder;

import androidx.camera.core.impl.l1;
import androidx.camera.video.internal.BufferProvider;
import java.util.Map;

public final /* synthetic */ class f0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Map.Entry f3307a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BufferProvider.State f3308b;

    public /* synthetic */ f0(Map.Entry entry, BufferProvider.State state) {
        this.f3307a = entry;
        this.f3308b = state;
    }

    public final void run() {
        ((l1.a) this.f3307a.getKey()).a(this.f3308b);
    }
}
