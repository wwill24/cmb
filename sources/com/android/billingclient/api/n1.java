package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzbn;
import com.google.android.gms.internal.play_billing.zzfb;
import com.google.android.gms.internal.play_billing.zzu;
import java.util.List;
import org.json.JSONException;

final class n1 extends BroadcastReceiver {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final s f8953a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final x0 f8954b;

    /* renamed from: c  reason: collision with root package name */
    private final c f8955c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8956d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ o1 f8957e;

    /* renamed from: f  reason: collision with root package name */
    private final y0 f8958f;

    /* synthetic */ n1(o1 o1Var, x0 x0Var, y0 y0Var, m1 m1Var) {
        this.f8957e = o1Var;
        this.f8953a = null;
        this.f8955c = null;
        this.f8954b = null;
        this.f8958f = y0Var;
    }

    private static final void d(Bundle bundle, i iVar, int i10) {
        if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") != null) {
            try {
                zzfb.zzw(bundle.getByteArray("FAILURE_LOGGING_PAYLOAD"), zzbn.zza());
            } catch (Throwable unused) {
                zzb.zzj("BillingBroadcastManager", "Failed parsing Api failure.");
            }
        } else {
            s0.a(23, i10, iVar);
        }
    }

    public final void c(Context context, IntentFilter intentFilter) {
        if (!this.f8956d) {
            context.registerReceiver(this.f8957e.f8993b, intentFilter);
            this.f8956d = true;
        }
    }

    public final void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            zzb.zzj("BillingBroadcastManager", "Bundle is null.");
            i iVar = u0.f9020j;
            s0.a(11, 1, iVar);
            s sVar = this.f8953a;
            if (sVar != null) {
                sVar.a(iVar, (List<Purchase>) null);
                return;
            }
            return;
        }
        i zzd = zzb.zzd(intent, "BillingBroadcastManager");
        String action = intent.getAction();
        String string = extras.getString("INTENT_SOURCE");
        int i10 = 2;
        if (string != "LAUNCH_BILLING_FLOW" && (string == null || !string.equals("LAUNCH_BILLING_FLOW"))) {
            i10 = 1;
        }
        if (action.equals("com.android.vending.billing.PURCHASES_UPDATED")) {
            if (!extras.getBoolean("IS_FIRST_PARTY_PURCHASE", false) && this.f8953a != null) {
                List zzh = zzb.zzh(extras);
                if (zzd.b() == 0) {
                    s0.b(i10);
                } else {
                    d(extras, zzd, i10);
                }
                this.f8953a.a(zzd, zzh);
                return;
            }
            zzb.zzj("BillingBroadcastManager", "Received purchase and no valid listener registered.");
            s0.a(12, i10, u0.f9020j);
        } else if (!action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
        } else {
            if (zzd.b() != 0) {
                d(extras, zzd, i10);
                this.f8953a.a(zzd, zzu.zzk());
            } else if (this.f8955c == null) {
                zzb.zzj("BillingBroadcastManager", "AlternativeBillingListener is null.");
                i iVar2 = u0.f9020j;
                s0.a(15, i10, iVar2);
                this.f8953a.a(iVar2, zzu.zzk());
            } else {
                String string2 = extras.getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                if (string2 == null) {
                    zzb.zzj("BillingBroadcastManager", "Couldn't find alternative billing user choice data in bundle.");
                    i iVar3 = u0.f9020j;
                    s0.a(16, i10, iVar3);
                    this.f8953a.a(iVar3, zzu.zzk());
                    return;
                }
                try {
                    d dVar = new d(string2);
                    s0.b(i10);
                    this.f8955c.a(dVar);
                } catch (JSONException unused) {
                    zzb.zzj("BillingBroadcastManager", String.format("Error when parsing invalid alternative choice data: [%s]", new Object[]{string2}));
                    i iVar4 = u0.f9020j;
                    s0.a(17, i10, iVar4);
                    this.f8953a.a(iVar4, zzu.zzk());
                }
            }
        }
    }

    /* synthetic */ n1(o1 o1Var, s sVar, c cVar, y0 y0Var, m1 m1Var) {
        this.f8957e = o1Var;
        this.f8953a = sVar;
        this.f8958f = y0Var;
        this.f8955c = cVar;
        this.f8954b = null;
    }
}
