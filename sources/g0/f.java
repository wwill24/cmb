package g0;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.camera.core.v1;
import androidx.camera.video.a;
import androidx.camera.video.internal.AudioSource;
import androidx.core.util.i;

public final class f implements i<AudioSource.f> {

    /* renamed from: a  reason: collision with root package name */
    private final a f14979a;

    public f(@NonNull a aVar) {
        this.f14979a = aVar;
    }

    @NonNull
    /* renamed from: a */
    public AudioSource.f get() {
        int i10;
        int e10 = b.e(this.f14979a);
        int f10 = b.f(this.f14979a);
        int c10 = this.f14979a.c();
        if (c10 == -1) {
            c10 = 1;
            v1.a("DefAudioSrcResolver", "Using fallback AUDIO channel count: " + 1);
        } else {
            v1.a("DefAudioSrcResolver", "Using supplied AUDIO channel count: " + c10);
        }
        Range<Integer> d10 = this.f14979a.d();
        if (a.f3076b.equals(d10)) {
            i10 = 44100;
            v1.a("DefAudioSrcResolver", "Using fallback AUDIO sample rate: " + 44100 + "Hz");
        } else {
            i10 = b.i(d10, c10, f10, d10.getUpper().intValue());
            v1.a("DefAudioSrcResolver", "Using AUDIO sample rate resolved from AudioSpec: " + i10 + "Hz");
        }
        return AudioSource.f.a().d(e10).c(f10).e(c10).f(i10).b();
    }
}
