package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public final class w2 {

    /* renamed from: c  reason: collision with root package name */
    public static final Status f38794c = new Status(8, "The connection to Google Play services was lost");

    /* renamed from: a  reason: collision with root package name */
    final Set f38795a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* renamed from: b  reason: collision with root package name */
    private final v2 f38796b = new v2(this);

    /* access modifiers changed from: package-private */
    public final void a(BasePendingResult basePendingResult) {
        this.f38795a.add(basePendingResult);
        basePendingResult.zan(this.f38796b);
    }

    public final void b() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f38795a.toArray(new BasePendingResult[0])) {
            basePendingResult.zan((v2) null);
            if (basePendingResult.zam()) {
                this.f38795a.remove(basePendingResult);
            }
        }
    }
}
