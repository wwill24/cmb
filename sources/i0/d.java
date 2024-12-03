package i0;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.v1;
import androidx.camera.video.internal.encoder.g1;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final g1 f15446a;

    /* renamed from: b  reason: collision with root package name */
    private long f15447b = -1;

    /* renamed from: c  reason: collision with root package name */
    private Timebase f15448c;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15449a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.camera.core.impl.Timebase[] r0 = androidx.camera.core.impl.Timebase.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f15449a = r0
                androidx.camera.core.impl.Timebase r1 = androidx.camera.core.impl.Timebase.REALTIME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f15449a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.core.impl.Timebase r1 = androidx.camera.core.impl.Timebase.UPTIME     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: i0.d.a.<clinit>():void");
        }
    }

    public d(@NonNull g1 g1Var, Timebase timebase) {
        this.f15446a = g1Var;
        this.f15448c = timebase;
    }

    private long a() {
        long j10 = Long.MAX_VALUE;
        long j11 = 0;
        for (int i10 = 0; i10 < 3; i10++) {
            long b10 = this.f15446a.b();
            long a10 = this.f15446a.a();
            long b11 = this.f15446a.b();
            long j12 = b11 - b10;
            if (i10 == 0 || j12 < j10) {
                j11 = a10 - ((b10 + b11) >> 1);
                j10 = j12;
            }
        }
        return Math.max(0, j11);
    }

    private boolean c(long j10) {
        if (Math.abs(j10 - this.f15446a.a()) < Math.abs(j10 - this.f15446a.b())) {
            return true;
        }
        return false;
    }

    public long b(long j10) {
        if (this.f15448c == null) {
            if (c(j10)) {
                v1.l("VideoTimebaseConverter", "Detected video buffer timestamp is close to realtime.");
                this.f15448c = Timebase.REALTIME;
            } else {
                this.f15448c = Timebase.UPTIME;
            }
        }
        int i10 = a.f15449a[this.f15448c.ordinal()];
        if (i10 == 1) {
            if (this.f15447b == -1) {
                this.f15447b = a();
            }
            return j10 - this.f15447b;
        } else if (i10 == 2) {
            return j10;
        } else {
            throw new AssertionError("Unknown timebase: " + this.f15448c);
        }
    }
}
