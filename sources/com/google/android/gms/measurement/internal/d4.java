package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.p;

public final class d4 {

    /* renamed from: a  reason: collision with root package name */
    private final String f39715a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f39716b;

    /* renamed from: c  reason: collision with root package name */
    private String f39717c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ e4 f39718d;

    public d4(e4 e4Var, String str, String str2) {
        this.f39718d = e4Var;
        p.g(str);
        this.f39715a = str;
    }

    public final String a() {
        if (!this.f39716b) {
            this.f39716b = true;
            this.f39717c = this.f39718d.o().getString(this.f39715a, (String) null);
        }
        return this.f39717c;
    }

    public final void b(String str) {
        SharedPreferences.Editor edit = this.f39718d.o().edit();
        edit.putString(this.f39715a, str);
        edit.apply();
        this.f39717c = str;
    }
}
