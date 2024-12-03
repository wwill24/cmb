package com.google.android.gms.location;

import android.os.WorkSource;
import com.google.android.gms.common.internal.p;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private long f39597a = Long.MIN_VALUE;

    public final n a(long j10) {
        p.b(j10 >= 0, "intervalMillis can't be negative.");
        this.f39597a = j10;
        return this;
    }

    public final zzb b() {
        boolean z10;
        if (this.f39597a != Long.MIN_VALUE) {
            z10 = true;
        } else {
            z10 = false;
        }
        p.p(z10, "Must set intervalMillis.");
        return new zzb(this.f39597a, true, (WorkSource) null, (String) null, (int[]) null, false, (String) null, 0, (String) null);
    }
}
