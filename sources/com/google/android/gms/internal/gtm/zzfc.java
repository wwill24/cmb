package com.google.android.gms.internal.gtm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.p;

final class zzfc extends BroadcastReceiver {
    static final String zza = zzfc.class.getName();
    private final zzbv zzb;
    private boolean zzc;
    private boolean zzd;

    zzfc(zzbv zzbv) {
        p.k(zzbv);
        this.zzb = zzbv;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zzb.zzm();
        this.zzb.zzf();
        String action = intent.getAction();
        this.zzb.zzm().zzP("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zze = zze();
            if (this.zzd != zze) {
                this.zzd = zze;
                zzbq zzf = this.zzb.zzf();
                zzf.zzP("Network connectivity status changed", Boolean.valueOf(zze));
                zzf.zzq().i(new zzbj(zzf, zze));
            }
        } else if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.zzb.zzm().zzS("NetworkBroadcastReceiver received unknown action", action);
        } else if (!intent.hasExtra(zza)) {
            zzbq zzf2 = this.zzb.zzf();
            zzf2.zzO("Radio powered up");
            zzf2.zzc();
        }
    }

    public final void zza() {
        this.zzb.zzm();
        this.zzb.zzf();
        if (!this.zzc) {
            Context zza2 = this.zzb.zza();
            zza2.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            IntentFilter intentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
            intentFilter.addCategory(zza2.getPackageName());
            zza2.registerReceiver(this, intentFilter);
            this.zzd = zze();
            this.zzb.zzm().zzP("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzd));
            this.zzc = true;
        }
    }

    public final void zzb() {
        Context zza2 = this.zzb.zza();
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(zza2.getPackageName());
        intent.putExtra(zza, true);
        zza2.sendOrderedBroadcast(intent, (String) null);
    }

    public final void zzc() {
        if (this.zzc) {
            this.zzb.zzm().zzO("Unregistering connectivity change receiver");
            this.zzc = false;
            this.zzd = false;
            try {
                this.zzb.zza().unregisterReceiver(this);
            } catch (IllegalArgumentException e10) {
                this.zzb.zzm().zzK("Failed to unregister the network broadcast receiver", e10);
            }
        }
    }

    public final boolean zzd() {
        if (!this.zzc) {
            this.zzb.zzm().zzR("Connectivity unknown. Receiver not registered");
        }
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.zzb.zza().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (SecurityException unused) {
        }
    }
}
