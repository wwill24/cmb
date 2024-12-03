package g0;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.m;
import androidx.camera.core.v1;
import androidx.camera.video.internal.AudioSource;
import androidx.camera.video.internal.encoder.a;
import androidx.core.util.i;

public final class c implements i<a> {

    /* renamed from: a  reason: collision with root package name */
    private final String f14966a;

    /* renamed from: b  reason: collision with root package name */
    private final Timebase f14967b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14968c;

    /* renamed from: d  reason: collision with root package name */
    private final androidx.camera.video.a f14969d;

    /* renamed from: e  reason: collision with root package name */
    private final AudioSource.f f14970e;

    /* renamed from: f  reason: collision with root package name */
    private final m f14971f;

    public c(@NonNull String str, int i10, @NonNull Timebase timebase, @NonNull androidx.camera.video.a aVar, @NonNull AudioSource.f fVar, @NonNull m mVar) {
        this.f14966a = str;
        this.f14968c = i10;
        this.f14967b = timebase;
        this.f14969d = aVar;
        this.f14970e = fVar;
        this.f14971f = mVar;
    }

    @NonNull
    /* renamed from: a */
    public a get() {
        v1.a("AudioEncCmcrdrPrflRslvr", "Using resolved AUDIO bitrate from CamcorderProfile");
        return a.d().f(this.f14966a).g(this.f14968c).e(this.f14967b).d(this.f14970e.d()).h(this.f14970e.e()).c(b.h(this.f14971f.b(), this.f14970e.d(), this.f14971f.c(), this.f14970e.e(), this.f14971f.f(), this.f14969d.b())).b();
    }
}
