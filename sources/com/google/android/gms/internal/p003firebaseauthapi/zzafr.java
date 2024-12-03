package com.google.android.gms.internal.p003firebaseauthapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafr  reason: invalid package */
final class zzafr extends BroadcastReceiver {
    final /* synthetic */ zzaft zza;
    private final String zzb;

    public zzafr(zzaft zzaft, String str) {
        this.zza = zzaft;
        this.zzb = str;
    }

    public final void onReceive(Context context, Intent intent) {
        String str;
        if ("com.google.android.gms.auth.api.phone.SMS_RETRIEVED".equals(intent.getAction())) {
            Bundle extras = intent.getExtras();
            if (((Status) extras.get("com.google.android.gms.auth.api.phone.EXTRA_STATUS")).Y() == 0) {
                String str2 = (String) extras.get("com.google.android.gms.auth.api.phone.EXTRA_SMS_MESSAGE");
                zzaft zzaft = this.zza;
                zzafs zzafs = (zzafs) zzaft.zzd.get(this.zzb);
                if (zzafs == null) {
                    zzaft.zza.c("Verification code received with no active retrieval session.", new Object[0]);
                } else {
                    Matcher matcher = Pattern.compile("(?<!\\d)\\d{6}(?!\\d)").matcher(str2);
                    if (matcher.find()) {
                        str = matcher.group();
                    } else {
                        str = null;
                    }
                    zzafs.zze = str;
                    if (str == null) {
                        zzaft.zza.c("Unable to extract verification code.", new Object[0]);
                    } else if (!zzac.zzd(zzafs.zzd)) {
                        zzaft.zzd(this.zza, this.zzb);
                    }
                }
            }
            context.getApplicationContext().unregisterReceiver(this);
        }
    }
}
