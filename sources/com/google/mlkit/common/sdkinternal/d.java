package com.google.mlkit.common.sdkinternal;

import androidx.annotation.NonNull;
import com.google.firebase.inject.Provider;
import java.util.concurrent.Executor;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final Provider f21397a;

    public d(@NonNull Provider provider) {
        this.f21397a = provider;
    }

    @NonNull
    public Executor a(Executor executor) {
        return executor != null ? executor : (Executor) this.f21397a.get();
    }
}
