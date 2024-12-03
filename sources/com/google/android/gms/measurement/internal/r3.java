package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;

public final class r3 {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final String f40213a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final String f40214b;

    /* renamed from: c  reason: collision with root package name */
    public final long f40215c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final Bundle f40216d;

    public r3(@NonNull String str, @NonNull String str2, Bundle bundle, long j10) {
        this.f40213a = str;
        this.f40214b = str2;
        this.f40216d = bundle;
        this.f40215c = j10;
    }

    public static r3 b(zzau zzau) {
        return new r3(zzau.f40491a, zzau.f40493c, zzau.f40492b.Y(), zzau.f40494d);
    }

    public final zzau a() {
        return new zzau(this.f40213a, new zzas(new Bundle(this.f40216d)), this.f40214b, this.f40215c);
    }

    public final String toString() {
        String str = this.f40214b;
        String str2 = this.f40213a;
        String obj = this.f40216d.toString();
        return "origin=" + str + ",name=" + str2 + ",params=" + obj;
    }
}
