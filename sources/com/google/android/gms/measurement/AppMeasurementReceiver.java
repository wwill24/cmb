package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import k1.a;
import we.h;
import we.i;

public final class AppMeasurementReceiver extends a implements h {

    /* renamed from: c  reason: collision with root package name */
    private i f39618c;

    public void a(@NonNull Context context, @NonNull Intent intent) {
        a.c(context, intent);
    }

    public void onReceive(@NonNull Context context, @NonNull Intent intent) {
        if (this.f39618c == null) {
            this.f39618c = new i(this);
        }
        this.f39618c.a(context, intent);
    }
}
