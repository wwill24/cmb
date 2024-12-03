package g0;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.v1;
import androidx.camera.video.internal.encoder.h1;
import androidx.camera.video.j0;
import androidx.core.util.i;

public class k implements i<h1> {

    /* renamed from: f  reason: collision with root package name */
    private static final Size f14992f = new Size(1280, 720);

    /* renamed from: g  reason: collision with root package name */
    private static final Range<Integer> f14993g = new Range<>(1, 60);

    /* renamed from: a  reason: collision with root package name */
    private final String f14994a;

    /* renamed from: b  reason: collision with root package name */
    private final Timebase f14995b;

    /* renamed from: c  reason: collision with root package name */
    private final j0 f14996c;

    /* renamed from: d  reason: collision with root package name */
    private final Size f14997d;

    /* renamed from: e  reason: collision with root package name */
    private final Range<Integer> f14998e;

    public k(@NonNull String str, @NonNull Timebase timebase, @NonNull j0 j0Var, @NonNull Size size, Range<Integer> range) {
        this.f14994a = str;
        this.f14995b = timebase;
        this.f14996c = j0Var;
        this.f14997d = size;
        this.f14998e = range;
    }

    private int b() {
        int i10;
        Range<Integer> d10 = this.f14996c.d();
        if (!j0.f3383a.equals(d10)) {
            i10 = f14993g.clamp(d10.getUpper()).intValue();
        } else {
            i10 = 30;
        }
        v1.a("VidEncCfgDefaultRslvr", String.format("Frame rate default: %dfps. [Requested range: %s, Expected operating range: %s]", new Object[]{Integer.valueOf(i10), d10, this.f14998e}));
        return i.a(d10, i10, this.f14998e);
    }

    @NonNull
    /* renamed from: a */
    public h1 get() {
        int b10 = b();
        v1.a("VidEncCfgDefaultRslvr", "Resolved VIDEO frame rate: " + b10 + "fps");
        Range<Integer> c10 = this.f14996c.c();
        v1.a("VidEncCfgDefaultRslvr", "Using fallback VIDEO bitrate");
        int width = this.f14997d.getWidth();
        Size size = f14992f;
        return h1.d().g(this.f14994a).f(this.f14995b).h(this.f14997d).b(i.d(14000000, b10, 30, width, size.getWidth(), this.f14997d.getHeight(), size.getHeight(), c10)).d(b10).a();
    }
}
