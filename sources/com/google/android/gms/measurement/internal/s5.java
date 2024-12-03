package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.measurement.zzcl;

public final class s5 {

    /* renamed from: a  reason: collision with root package name */
    final Context f40249a;

    /* renamed from: b  reason: collision with root package name */
    String f40250b;

    /* renamed from: c  reason: collision with root package name */
    String f40251c;

    /* renamed from: d  reason: collision with root package name */
    String f40252d;

    /* renamed from: e  reason: collision with root package name */
    Boolean f40253e;

    /* renamed from: f  reason: collision with root package name */
    long f40254f;

    /* renamed from: g  reason: collision with root package name */
    zzcl f40255g;

    /* renamed from: h  reason: collision with root package name */
    boolean f40256h = true;

    /* renamed from: i  reason: collision with root package name */
    final Long f40257i;

    /* renamed from: j  reason: collision with root package name */
    String f40258j;

    public s5(Context context, zzcl zzcl, Long l10) {
        p.k(context);
        Context applicationContext = context.getApplicationContext();
        p.k(applicationContext);
        this.f40249a = applicationContext;
        this.f40257i = l10;
        if (zzcl != null) {
            this.f40255g = zzcl;
            this.f40250b = zzcl.zzf;
            this.f40251c = zzcl.zze;
            this.f40252d = zzcl.zzd;
            this.f40256h = zzcl.zzc;
            this.f40254f = zzcl.zzb;
            this.f40258j = zzcl.zzh;
            Bundle bundle = zzcl.zzg;
            if (bundle != null) {
                this.f40253e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
