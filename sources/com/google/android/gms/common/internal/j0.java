package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.d;

public final class j0 {

    /* renamed from: a  reason: collision with root package name */
    private final SparseIntArray f39016a = new SparseIntArray();

    /* renamed from: b  reason: collision with root package name */
    private d f39017b;

    public j0(@NonNull d dVar) {
        p.k(dVar);
        this.f39017b = dVar;
    }

    public final int a(Context context, int i10) {
        return this.f39016a.get(i10, -1);
    }

    public final int b(@NonNull Context context, @NonNull a.f fVar) {
        p.k(context);
        p.k(fVar);
        int i10 = 0;
        if (!fVar.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = fVar.getMinApkVersion();
        int a10 = a(context, minApkVersion);
        if (a10 == -1) {
            int i11 = 0;
            while (true) {
                if (i11 >= this.f39016a.size()) {
                    i10 = -1;
                    break;
                }
                int keyAt = this.f39016a.keyAt(i11);
                if (keyAt > minApkVersion && this.f39016a.get(keyAt) == 0) {
                    break;
                }
                i11++;
            }
            if (i10 == -1) {
                a10 = this.f39017b.j(context, minApkVersion);
            } else {
                a10 = i10;
            }
            this.f39016a.put(minApkVersion, a10);
        }
        return a10;
    }

    public final void c() {
        this.f39016a.clear();
    }
}
