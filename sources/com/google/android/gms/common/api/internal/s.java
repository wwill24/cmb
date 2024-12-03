package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.h;

public class s extends h.a {

    /* renamed from: a  reason: collision with root package name */
    private final e<Status> f38737a;

    public s(@NonNull e<Status> eVar) {
        this.f38737a = eVar;
    }

    public void onResult(@NonNull Status status) {
        this.f38737a.setResult(status);
    }
}
