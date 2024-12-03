package vk;

import java.util.NoSuchElementException;
import kotlin.collections.c0;

public final class f extends c0 {

    /* renamed from: a  reason: collision with root package name */
    private final long f33932a;

    /* renamed from: b  reason: collision with root package name */
    private final long f33933b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f33934c;

    /* renamed from: d  reason: collision with root package name */
    private long f33935d;

    public f(long j10, long j11, long j12) {
        this.f33932a = j12;
        this.f33933b = j11;
        boolean z10 = true;
        if (j12 <= 0 ? j10 < j11 : j10 > j11) {
            z10 = false;
        }
        this.f33934c = z10;
        this.f33935d = !z10 ? j11 : j10;
    }

    public boolean hasNext() {
        return this.f33934c;
    }

    public long nextLong() {
        long j10 = this.f33935d;
        if (j10 != this.f33933b) {
            this.f33935d = this.f33932a + j10;
        } else if (this.f33934c) {
            this.f33934c = false;
        } else {
            throw new NoSuchElementException();
        }
        return j10;
    }
}
