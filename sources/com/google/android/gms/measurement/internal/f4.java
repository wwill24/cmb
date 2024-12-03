package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzra;
import com.google.firebase.messaging.Constants;
import le.b;
import net.bytebuddy.description.type.TypeDescription;

final class f4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzbr f39785a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ServiceConnection f39786b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ g4 f39787c;

    f4(g4 g4Var, zzbr zzbr, ServiceConnection serviceConnection) {
        this.f39787c = g4Var;
        this.f39785a = zzbr;
        this.f39786b = serviceConnection;
    }

    public final void run() {
        Bundle bundle;
        g4 g4Var = this.f39787c;
        h4 h4Var = g4Var.f39858b;
        String a10 = g4Var.f39857a;
        zzbr zzbr = this.f39785a;
        ServiceConnection serviceConnection = this.f39786b;
        h4Var.f39891a.f().h();
        Bundle bundle2 = new Bundle();
        bundle2.putString("package_name", a10);
        try {
            bundle = zzbr.zzd(bundle2);
            if (bundle == null) {
                h4Var.f39891a.d().r().a("Install Referrer Service returned a null response");
                bundle = null;
            }
        } catch (Exception e10) {
            h4Var.f39891a.d().r().b("Exception occurred while retrieving the Install Referrer", e10.getMessage());
        }
        h4Var.f39891a.f().h();
        u4.t();
        if (bundle != null) {
            long j10 = bundle.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j10 == 0) {
                h4Var.f39891a.d().w().a("Service response is missing Install Referrer install timestamp");
            } else {
                String string = bundle.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    h4Var.f39891a.d().r().a("No referrer defined in Install Referrer response");
                } else {
                    h4Var.f39891a.d().v().b("InstallReferrer API result", string);
                    t9 N = h4Var.f39891a.N();
                    Uri parse = Uri.parse(TypeDescription.Generic.OfWildcardType.SYMBOL.concat(string));
                    zzra.zzc();
                    Bundle v02 = N.v0(parse, h4Var.f39891a.z().B((String) null, g3.f39854y0));
                    if (v02 == null) {
                        h4Var.f39891a.d().r().a("No campaign params defined in Install Referrer result");
                    } else {
                        String string2 = v02.getString("medium");
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j11 = bundle.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                            if (j11 == 0) {
                                h4Var.f39891a.d().r().a("Install Referrer is missing click timestamp for ad campaign");
                            } else {
                                v02.putLong("click_timestamp", j11);
                            }
                        }
                        if (j10 == h4Var.f39891a.F().f39741f.a()) {
                            h4Var.f39891a.d().v().a("Logging Install Referrer campaign from module while it may have already been logged.");
                        }
                        if (h4Var.f39891a.o()) {
                            h4Var.f39891a.F().f39741f.b(j10);
                            h4Var.f39891a.d().v().b("Logging Install Referrer campaign from gmscore with ", "referrer API v2");
                            v02.putString("_cis", "referrer API v2");
                            h4Var.f39891a.I().t("auto", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, v02, a10);
                        }
                    }
                }
            }
        }
        b.b().c(h4Var.f39891a.c(), serviceConnection);
    }
}
