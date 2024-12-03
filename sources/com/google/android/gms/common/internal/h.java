package com.google.android.gms.common.internal;

import android.util.Log;
import androidx.annotation.NonNull;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final String f39004a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39005b;

    public h(@NonNull String str) {
        this(str, (String) null);
    }

    private final String g(String str) {
        String str2 = this.f39005b;
        return str2 == null ? str : str2.concat(str);
    }

    public boolean a(int i10) {
        return Log.isLoggable(this.f39004a, i10);
    }

    public void b(@NonNull String str, @NonNull String str2) {
        if (a(3)) {
            g(str2);
        }
    }

    public void c(@NonNull String str, @NonNull String str2) {
        if (a(6)) {
            g(str2);
        }
    }

    public void d(@NonNull String str, @NonNull String str2, @NonNull Throwable th2) {
        if (a(6)) {
            g(str2);
        }
    }

    public void e(@NonNull String str, @NonNull String str2) {
        if (a(2)) {
            g(str2);
        }
    }

    public void f(@NonNull String str, @NonNull String str2) {
        if (a(5)) {
            g(str2);
        }
    }

    public h(@NonNull String str, String str2) {
        p.l(str, "log tag cannot be null");
        p.c(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f39004a = str;
        if (str2 == null || str2.length() <= 0) {
            this.f39005b = null;
        } else {
            this.f39005b = str2;
        }
    }
}
