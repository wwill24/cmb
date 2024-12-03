package g0;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.m;
import androidx.camera.core.v1;
import androidx.camera.video.internal.encoder.h1;
import androidx.camera.video.j0;
import androidx.core.util.i;

public class j implements i<h1> {

    /* renamed from: a  reason: collision with root package name */
    private final String f14986a;

    /* renamed from: b  reason: collision with root package name */
    private final Timebase f14987b;

    /* renamed from: c  reason: collision with root package name */
    private final j0 f14988c;

    /* renamed from: d  reason: collision with root package name */
    private final Size f14989d;

    /* renamed from: e  reason: collision with root package name */
    private final m f14990e;

    /* renamed from: f  reason: collision with root package name */
    private final Range<Integer> f14991f;

    public j(@NonNull String str, @NonNull Timebase timebase, @NonNull j0 j0Var, @NonNull Size size, @NonNull m mVar, Range<Integer> range) {
        this.f14986a = str;
        this.f14987b = timebase;
        this.f14988c = j0Var;
        this.f14989d = size;
        this.f14990e = mVar;
        this.f14991f = range;
    }

    private int b() {
        Range<Integer> d10 = this.f14988c.d();
        int o10 = this.f14990e.o();
        v1.a("VidEncCmcrdrPrflRslvr", String.format("Frame rate from camcorder profile: %dfps. [Requested range: %s, Expected operating range: %s]", new Object[]{Integer.valueOf(o10), d10, this.f14991f}));
        return i.a(d10, o10, this.f14991f);
    }

    @NonNull
    /* renamed from: a */
    public h1 get() {
        int b10 = b();
        v1.a("VidEncCmcrdrPrflRslvr", "Resolved VIDEO frame rate: " + b10 + "fps");
        Range<Integer> c10 = this.f14988c.c();
        v1.a("VidEncCmcrdrPrflRslvr", "Using resolved VIDEO bitrate from CamcorderProfile");
        return h1.d().g(this.f14986a).f(this.f14987b).h(this.f14989d).b(i.d(this.f14990e.k(), b10, this.f14990e.o(), this.f14989d.getWidth(), this.f14990e.p(), this.f14989d.getHeight(), this.f14990e.n(), c10)).d(b10).a();
    }
}
