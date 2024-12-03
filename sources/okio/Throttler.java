package okio;

import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014B\t\b\u0016¢\u0006\u0004\b\u0013\u0010\u0015J\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0002H\u0002J\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000e¨\u0006\u0016"}, d2 = {"Lokio/Throttler;", "", "", "c", "b", "nanosToWait", "", "e", "byteCount", "d", "(J)J", "now", "a", "(JJ)J", "J", "allocatedUntil", "bytesPerSecond", "waitByteCount", "maxByteCount", "<init>", "(J)V", "()V", "okio"}, k = 1, mv = {1, 6, 0})
public final class Throttler {

    /* renamed from: a  reason: collision with root package name */
    private long f33423a;

    /* renamed from: b  reason: collision with root package name */
    private long f33424b;

    /* renamed from: c  reason: collision with root package name */
    private long f33425c;

    /* renamed from: d  reason: collision with root package name */
    private long f33426d;

    public Throttler(long j10) {
        this.f33423a = j10;
        this.f33425c = 8192;
        this.f33426d = 262144;
    }

    private final long b(long j10) {
        return (j10 * 1000000000) / this.f33424b;
    }

    private final long c(long j10) {
        return (j10 * this.f33424b) / 1000000000;
    }

    private final void e(long j10) {
        long j11 = j10 / 1000000;
        wait(j11, (int) (j10 - (1000000 * j11)));
    }

    public final long a(long j10, long j11) {
        if (this.f33424b == 0) {
            return j11;
        }
        long max = Math.max(this.f33423a - j10, 0);
        long c10 = this.f33426d - c(max);
        if (c10 >= j11) {
            this.f33423a = j10 + max + b(j11);
            return j11;
        }
        long j12 = this.f33425c;
        if (c10 >= j12) {
            this.f33423a = j10 + b(this.f33426d);
            return c10;
        }
        long min = Math.min(j12, j11);
        long b10 = max + b(min - this.f33426d);
        if (b10 != 0) {
            return -b10;
        }
        this.f33423a = j10 + b(this.f33426d);
        return min;
    }

    public final long d(long j10) {
        boolean z10;
        long a10;
        if (j10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            synchronized (this) {
                while (true) {
                    a10 = a(System.nanoTime(), j10);
                    if (a10 < 0) {
                        e(-a10);
                    }
                }
            }
            return a10;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public Throttler() {
        this(System.nanoTime());
    }
}
