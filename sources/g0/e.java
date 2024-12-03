package g0;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.m;
import androidx.camera.core.v1;
import androidx.camera.video.a;
import androidx.camera.video.internal.AudioSource;
import androidx.core.util.i;

public final class e implements i<AudioSource.f> {

    /* renamed from: a  reason: collision with root package name */
    private final a f14977a;

    /* renamed from: b  reason: collision with root package name */
    private final m f14978b;

    public e(@NonNull a aVar, @NonNull m mVar) {
        this.f14977a = aVar;
        this.f14978b = mVar;
    }

    @NonNull
    /* renamed from: a */
    public AudioSource.f get() {
        int e10 = b.e(this.f14977a);
        int f10 = b.f(this.f14977a);
        int c10 = this.f14977a.c();
        Range<Integer> d10 = this.f14977a.d();
        int c11 = this.f14978b.c();
        if (c10 == -1) {
            v1.a("AudioSrcCmcrdrPrflRslvr", "Resolved AUDIO channel count from CamcorderProfile: " + c11);
            c10 = c11;
        } else {
            v1.a("AudioSrcCmcrdrPrflRslvr", "Media spec AUDIO channel count overrides CamcorderProfile [CamcorderProfile channel count: " + c11 + ", Resolved Channel Count: " + c10 + "]");
        }
        int f11 = this.f14978b.f();
        int i10 = b.i(d10, c10, f10, f11);
        v1.a("AudioSrcCmcrdrPrflRslvr", "Using resolved AUDIO sample rate or nearest supported from CamcorderProfile: " + i10 + "Hz. [CamcorderProfile sample rate: " + f11 + "Hz]");
        return AudioSource.f.a().d(e10).c(f10).e(c10).f(i10).b();
    }
}
