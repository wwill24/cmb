package com.google.android.gms.internal.gtm;

import android.content.SharedPreferences;
import android.text.TextUtils;
import rd.u;

public final class zzfh extends zzbs {
    /* access modifiers changed from: private */
    public SharedPreferences zza;
    private long zzb;
    private long zzc = -1;
    private final zzfg zzd;

    protected zzfh(zzbv zzbv) {
        super(zzbv);
        zzw();
        this.zzd = new zzfg(this, "monitoring", zzeu.zzP.zzb().longValue(), (zzff) null);
    }

    public final long zza() {
        u.h();
        zzW();
        long j10 = this.zzb;
        if (j10 != 0) {
            return j10;
        }
        long j11 = this.zza.getLong("first_run", 0);
        if (j11 != 0) {
            this.zzb = j11;
            return j11;
        }
        long currentTimeMillis = zzC().currentTimeMillis();
        SharedPreferences.Editor edit = this.zza.edit();
        edit.putLong("first_run", currentTimeMillis);
        if (!edit.commit()) {
            zzR("Failed to commit first run time");
        }
        this.zzb = currentTimeMillis;
        return currentTimeMillis;
    }

    public final long zzb() {
        u.h();
        zzW();
        long j10 = this.zzc;
        if (j10 != -1) {
            return j10;
        }
        long j11 = this.zza.getLong("last_dispatch", 0);
        this.zzc = j11;
        return j11;
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
        this.zza = zzo().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public final zzfg zze() {
        return this.zzd;
    }

    public final zzfo zzf() {
        return new zzfo(zzC(), zza());
    }

    public final String zzg() {
        u.h();
        zzW();
        String string = this.zza.getString("installation_campaign", (String) null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    public final void zzh(String str) {
        u.h();
        zzW();
        SharedPreferences.Editor edit = this.zza.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove("installation_campaign");
        } else {
            edit.putString("installation_campaign", str);
        }
        if (!edit.commit()) {
            zzR("Failed to commit campaign data");
        }
    }

    public final void zzi() {
        u.h();
        zzW();
        long currentTimeMillis = zzC().currentTimeMillis();
        SharedPreferences.Editor edit = this.zza.edit();
        edit.putLong("last_dispatch", currentTimeMillis);
        edit.apply();
        this.zzc = currentTimeMillis;
    }
}
