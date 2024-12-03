package g0;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.v1;
import androidx.camera.video.internal.AudioSource;
import androidx.camera.video.internal.encoder.a;
import androidx.core.util.i;

public final class d implements i<a> {

    /* renamed from: a  reason: collision with root package name */
    private final String f14972a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14973b;

    /* renamed from: c  reason: collision with root package name */
    private final androidx.camera.video.a f14974c;

    /* renamed from: d  reason: collision with root package name */
    private final AudioSource.f f14975d;

    /* renamed from: e  reason: collision with root package name */
    private final Timebase f14976e;

    public d(@NonNull String str, int i10, @NonNull Timebase timebase, @NonNull androidx.camera.video.a aVar, @NonNull AudioSource.f fVar) {
        this.f14972a = str;
        this.f14973b = i10;
        this.f14976e = timebase;
        this.f14974c = aVar;
        this.f14975d = fVar;
    }

    @NonNull
    /* renamed from: a */
    public a get() {
        Range<Integer> b10 = this.f14974c.b();
        v1.a("AudioEncCfgDefaultRslvr", "Using fallback AUDIO bitrate");
        return a.d().f(this.f14972a).g(this.f14973b).e(this.f14976e).d(this.f14975d.d()).h(this.f14975d.e()).c(b.h(156000, this.f14975d.d(), 2, this.f14975d.e(), 48000, b10)).b();
    }
}
