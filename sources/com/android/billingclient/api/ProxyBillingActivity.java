package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.annotation.NonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.internal.play_billing.zzb;

@UsedByReflection("PlatformActivityProxy")
public class ProxyBillingActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private ResultReceiver f8848a;

    /* renamed from: b  reason: collision with root package name */
    private ResultReceiver f8849b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8850c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8851d;

    private Intent a(String str) {
        Intent intent = new Intent("com.android.vending.billing.ALTERNATIVE_BILLING");
        intent.setPackage(getApplicationContext().getPackageName());
        intent.putExtra("ALTERNATIVE_BILLING_USER_CHOICE_DATA", str);
        return intent;
    }

    private Intent b() {
        Intent intent = new Intent("com.android.vending.billing.PURCHASES_UPDATED");
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r9, int r10, android.content.Intent r11) {
        /*
            r8 = this;
            super.onActivityResult(r9, r10, r11)
            r0 = 0
            r1 = 110(0x6e, float:1.54E-43)
            r2 = 0
            java.lang.String r3 = "ProxyBillingActivity"
            r4 = 100
            if (r9 == r4) goto L_0x0043
            if (r9 != r1) goto L_0x0010
            goto L_0x0043
        L_0x0010:
            r10 = 101(0x65, float:1.42E-43)
            if (r9 != r10) goto L_0x0028
            int r9 = com.google.android.gms.internal.play_billing.zzb.zza(r11, r3)
            android.os.ResultReceiver r10 = r8.f8849b
            if (r10 == 0) goto L_0x0128
            if (r11 != 0) goto L_0x001f
            goto L_0x0023
        L_0x001f:
            android.os.Bundle r0 = r11.getExtras()
        L_0x0023:
            r10.send(r9, r0)
            goto L_0x0128
        L_0x0028:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Got onActivityResult with wrong requestCode: "
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = "; skipping..."
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            com.google.android.gms.internal.play_billing.zzb.zzj(r3, r9)
            goto L_0x0128
        L_0x0043:
            com.android.billingclient.api.i r4 = com.google.android.gms.internal.play_billing.zzb.zzd(r11, r3)
            int r4 = r4.b()
            r5 = -1
            if (r10 != r5) goto L_0x0054
            if (r4 == 0) goto L_0x0052
            r10 = r5
            goto L_0x0054
        L_0x0052:
            r4 = r2
            goto L_0x0070
        L_0x0054:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Activity finished with resultCode "
            r5.append(r6)
            r5.append(r10)
            java.lang.String r10 = " and billing's responseCode: "
            r5.append(r10)
            r5.append(r4)
            java.lang.String r10 = r5.toString()
            com.google.android.gms.internal.play_billing.zzb.zzj(r3, r10)
        L_0x0070:
            android.os.ResultReceiver r10 = r8.f8848a
            if (r10 == 0) goto L_0x0080
            if (r11 != 0) goto L_0x0077
            goto L_0x007b
        L_0x0077:
            android.os.Bundle r0 = r11.getExtras()
        L_0x007b:
            r10.send(r4, r0)
            goto L_0x0128
        L_0x0080:
            if (r11 == 0) goto L_0x0119
            android.os.Bundle r10 = r11.getExtras()
            java.lang.String r0 = "LAUNCH_BILLING_FLOW"
            java.lang.String r4 = "INTENT_SOURCE"
            if (r10 == 0) goto L_0x00b0
            android.os.Bundle r10 = r11.getExtras()
            java.lang.String r3 = "ALTERNATIVE_BILLING_USER_CHOICE_DATA"
            java.lang.String r10 = r10.getString(r3)
            if (r10 == 0) goto L_0x00a1
            android.content.Intent r10 = r8.a(r10)
            r10.putExtra(r4, r0)
            goto L_0x011d
        L_0x00a1:
            android.content.Intent r10 = r8.b()
            android.os.Bundle r11 = r11.getExtras()
            r10.putExtras(r11)
            r10.putExtra(r4, r0)
            goto L_0x011d
        L_0x00b0:
            android.content.Intent r10 = r8.b()
            java.lang.String r11 = "Got null bundle!"
            com.google.android.gms.internal.play_billing.zzb.zzj(r3, r11)
            java.lang.String r11 = "RESPONSE_CODE"
            r3 = 6
            r10.putExtra(r11, r3)
            java.lang.String r11 = "DEBUG_MESSAGE"
            java.lang.String r5 = "An internal error occurred."
            r10.putExtra(r11, r5)
            r11 = 22
            r6 = 2
            com.android.billingclient.api.i$a r7 = com.android.billingclient.api.i.c()
            r7.c(r3)
            r7.b(r5)
            com.android.billingclient.api.i r3 = r7.a()
            com.google.android.gms.internal.play_billing.zzfb r11 = com.android.billingclient.api.s0.a(r11, r6, r3)
            int r3 = r11.zzd()     // Catch:{ IOException -> 0x00f4 }
            byte[] r5 = new byte[r3]     // Catch:{ IOException -> 0x00f4 }
            com.google.android.gms.internal.play_billing.zzbi r3 = com.google.android.gms.internal.play_billing.zzbi.zzz(r5, r2, r3)     // Catch:{ IOException -> 0x00f4 }
            r11.zzq(r3)     // Catch:{ IOException -> 0x00f4 }
            r3.zzA()     // Catch:{ IOException -> 0x00f4 }
            java.lang.String r11 = "FAILURE_LOGGING_PAYLOAD"
            r10.putExtra(r11, r5)
            r10.putExtra(r4, r0)
            goto L_0x011d
        L_0x00f4:
            r9 = move-exception
            java.lang.RuntimeException r10 = new java.lang.RuntimeException
            java.lang.Class r11 = r11.getClass()
            java.lang.String r11 = r11.getName()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Serializing "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r11 = " to a byte array threw an IOException (should never happen)."
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            r10.<init>(r11, r9)
            throw r10
        L_0x0119:
            android.content.Intent r10 = r8.b()
        L_0x011d:
            if (r9 != r1) goto L_0x0125
            r9 = 1
            java.lang.String r11 = "IS_FIRST_PARTY_PURCHASE"
            r10.putExtra(r11, r9)
        L_0x0125:
            r8.sendBroadcast(r10)
        L_0x0128:
            r8.f8850c = r2
            r8.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.ProxyBillingActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        int i10;
        PendingIntent pendingIntent;
        int i11;
        super.onCreate(bundle);
        if (bundle == null) {
            zzb.zzi("ProxyBillingActivity", "Launching Play Store billing flow");
            if (getIntent().hasExtra("BUY_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
                if (getIntent().hasExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT") && getIntent().getBooleanExtra("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false)) {
                    this.f8851d = true;
                    i11 = 110;
                    i10 = i11;
                    this.f8850c = true;
                    startIntentSenderForResult(pendingIntent.getIntentSender(), i10, new Intent(), 0, 0, 0);
                }
            } else if (getIntent().hasExtra("SUBS_MANAGEMENT_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
                this.f8848a = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
            } else if (getIntent().hasExtra("IN_APP_MESSAGE_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("IN_APP_MESSAGE_INTENT");
                this.f8849b = (ResultReceiver) getIntent().getParcelableExtra("in_app_message_result_receiver");
                i11 = 101;
                i10 = i11;
                this.f8850c = true;
                startIntentSenderForResult(pendingIntent.getIntentSender(), i10, new Intent(), 0, 0, 0);
            } else {
                i10 = 100;
                pendingIntent = null;
                this.f8850c = true;
                startIntentSenderForResult(pendingIntent.getIntentSender(), i10, new Intent(), 0, 0, 0);
            }
            i10 = 100;
            try {
                this.f8850c = true;
                startIntentSenderForResult(pendingIntent.getIntentSender(), i10, new Intent(), 0, 0, 0);
            } catch (IntentSender.SendIntentException e10) {
                zzb.zzk("ProxyBillingActivity", "Got exception while trying to start a purchase flow.", e10);
                ResultReceiver resultReceiver = this.f8848a;
                if (resultReceiver != null) {
                    resultReceiver.send(6, (Bundle) null);
                } else {
                    ResultReceiver resultReceiver2 = this.f8849b;
                    if (resultReceiver2 != null) {
                        resultReceiver2.send(0, (Bundle) null);
                    } else {
                        Intent b10 = b();
                        if (this.f8851d) {
                            b10.putExtra("IS_FIRST_PARTY_PURCHASE", true);
                        }
                        b10.putExtra("RESPONSE_CODE", 6);
                        b10.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                        sendBroadcast(b10);
                    }
                }
                this.f8850c = false;
                finish();
            }
        } else {
            zzb.zzi("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
            this.f8850c = bundle.getBoolean("send_cancelled_broadcast_if_finished", false);
            if (bundle.containsKey("result_receiver")) {
                this.f8848a = (ResultReceiver) bundle.getParcelable("result_receiver");
            } else if (bundle.containsKey("in_app_message_result_receiver")) {
                this.f8849b = (ResultReceiver) bundle.getParcelable("in_app_message_result_receiver");
            }
            this.f8851d = bundle.getBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", false);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.f8850c) {
            Intent b10 = b();
            b10.putExtra("RESPONSE_CODE", 1);
            b10.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            sendBroadcast(b10);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        ResultReceiver resultReceiver = this.f8848a;
        if (resultReceiver != null) {
            bundle.putParcelable("result_receiver", resultReceiver);
        }
        ResultReceiver resultReceiver2 = this.f8849b;
        if (resultReceiver2 != null) {
            bundle.putParcelable("in_app_message_result_receiver", resultReceiver2);
        }
        bundle.putBoolean("send_cancelled_broadcast_if_finished", this.f8850c);
        bundle.putBoolean("IS_FLOW_FROM_FIRST_PARTY_CLIENT", this.f8851d);
    }
}
