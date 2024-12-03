package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.NonNull;

public interface j {
    Activity g0();

    void p(@NonNull String str, @NonNull LifecycleCallback lifecycleCallback);

    void startActivityForResult(@NonNull Intent intent, int i10);

    <T extends LifecycleCallback> T y(@NonNull String str, @NonNull Class<T> cls);
}
