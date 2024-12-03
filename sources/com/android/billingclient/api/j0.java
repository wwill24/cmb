package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzd;
import com.google.android.gms.internal.play_billing.zzfv;

final class j0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final Object f8945a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f8946b = false;

    /* renamed from: c  reason: collision with root package name */
    private g f8947c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ f f8948d;

    /* synthetic */ j0(f fVar, g gVar, i0 i0Var) {
        this.f8948d = fVar;
        this.f8947c = gVar;
    }

    private final void c(i iVar) {
        synchronized (this.f8945a) {
            g gVar = this.f8947c;
            if (gVar != null) {
                gVar.a(iVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0186, code lost:
        c(com.android.billingclient.api.u0.f9011a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x018b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
        r0 = new android.os.Bundle();
        r0.putString("accountName", (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        r1 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r4 = com.android.billingclient.api.f.B(r11.f8948d).getPackageName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0029, code lost:
        r7 = 3;
        r6 = 19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        if (r6 < 3) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        if (r0 != null) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r7 = com.android.billingclient.api.f.I(r11.f8948d).zzr(r6, r4, "subs");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003e, code lost:
        r7 = r11.f8948d.f8890f.zzc(r6, r4, "subs", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004a, code lost:
        if (r7 != 0) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
        r6 = r6 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0050, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0051, code lost:
        r8 = r11.f8948d;
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        if (r6 < 5) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0057, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0059, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005a, code lost:
        r8.f8893i = r9;
        r8 = r11.f8948d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005f, code lost:
        if (r6 < 3) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0061, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0063, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0064, code lost:
        r8.f8892h = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0067, code lost:
        if (r6 >= 3) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0069, code lost:
        com.google.android.gms.internal.play_billing.zzb.zzi("BillingClient", "In-app billing API does not support subscription on this device.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0070, code lost:
        r6 = 19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0071, code lost:
        if (r6 < 3) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0073, code lost:
        if (r0 != null) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0075, code lost:
        r7 = r11.f8948d.f8890f.zzr(r6, r4, "inapp");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0082, code lost:
        r7 = r11.f8948d.f8890f.zzc(r6, r4, "inapp", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008e, code lost:
        if (r7 != 0) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0090, code lost:
        r11.f8948d.f8894j = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0096, code lost:
        r6 = r6 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0099, code lost:
        r0 = r11.f8948d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009f, code lost:
        if (r0.f8894j < 19) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a1, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a3, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a4, code lost:
        r0.f8905u = r4;
        r0 = r11.f8948d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00af, code lost:
        if (r0.f8894j < 18) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b1, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b3, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b4, code lost:
        r0.f8904t = r4;
        r0 = r11.f8948d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00bf, code lost:
        if (r0.f8894j < 17) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00c1, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00c3, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c4, code lost:
        r0.f8903s = r4;
        r0 = r11.f8948d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00cf, code lost:
        if (r0.f8894j < 16) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d1, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d3, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00d4, code lost:
        r0.f8902r = r4;
        r0 = r11.f8948d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00df, code lost:
        if (r0.f8894j < 15) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e1, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e3, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00e4, code lost:
        r0.f8901q = r4;
        r0 = r11.f8948d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00ef, code lost:
        if (r0.f8894j < 14) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00f1, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00f3, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00f4, code lost:
        r0.f8900p = r4;
        r0 = r11.f8948d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00ff, code lost:
        if (r0.f8894j < 12) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0101, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0103, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0104, code lost:
        r0.f8899o = r4;
        r0 = r11.f8948d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x010f, code lost:
        if (r0.f8894j < 10) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0111, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0113, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0114, code lost:
        r0.f8898n = r4;
        r0 = r11.f8948d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x011f, code lost:
        if (r0.f8894j < 9) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0121, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0123, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0124, code lost:
        r0.f8897m = r4;
        r0 = r11.f8948d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x012f, code lost:
        if (r0.f8894j < 8) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0131, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0133, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0134, code lost:
        r0.f8896l = r4;
        r0 = r11.f8948d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x013e, code lost:
        if (r0.f8894j < 6) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0141, code lost:
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0142, code lost:
        r0.f8895k = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x014b, code lost:
        if (r11.f8948d.f8894j >= 3) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x014d, code lost:
        com.google.android.gms.internal.play_billing.zzb.zzj("BillingClient", "In-app billing API version 3 is not supported on this device.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0154, code lost:
        if (r7 != 0) goto L_0x015d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0156, code lost:
        r11.f8948d.f8885a = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x015d, code lost:
        r11.f8948d.f8885a = 0;
        r11.f8948d.f8890f = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0168, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0169, code lost:
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x016b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x016c, code lost:
        com.google.android.gms.internal.play_billing.zzb.zzk("BillingClient", "Exception while checking if billing is supported; try to reconnect", r0);
        r11.f8948d.f8885a = 0;
        r11.f8948d.f8890f = null;
        r7 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x017e, code lost:
        if (r7 != 0) goto L_0x0186;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0180, code lost:
        c(com.android.billingclient.api.u0.f9022l);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        if (android.text.TextUtils.isEmpty((java.lang.CharSequence) null) != false) goto L_0x001c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0180  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object a() throws java.lang.Exception {
        /*
            r11 = this;
            java.lang.Object r0 = r11.f8945a
            monitor-enter(r0)
            boolean r1 = r11.f8946b     // Catch:{ all -> 0x018c }
            r2 = 0
            if (r1 == 0) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x018c }
            return r2
        L_0x000a:
            monitor-exit(r0)     // Catch:{ all -> 0x018c }
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x001c
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r1 = "accountName"
            r0.putString(r1, r2)
            goto L_0x001d
        L_0x001c:
            r0 = r2
        L_0x001d:
            r1 = 3
            r3 = 0
            com.android.billingclient.api.f r4 = r11.f8948d     // Catch:{ Exception -> 0x016b }
            android.content.Context r4 = r4.f8889e     // Catch:{ Exception -> 0x016b }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ Exception -> 0x016b }
            r5 = 19
            r7 = r1
            r6 = r5
        L_0x002d:
            if (r6 < r1) goto L_0x0050
            if (r0 != 0) goto L_0x003e
            com.android.billingclient.api.f r8 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            com.google.android.gms.internal.play_billing.zze r8 = r8.f8890f     // Catch:{ Exception -> 0x0168 }
            java.lang.String r9 = "subs"
            int r7 = r8.zzr(r6, r4, r9)     // Catch:{ Exception -> 0x0168 }
            goto L_0x004a
        L_0x003e:
            com.android.billingclient.api.f r8 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            com.google.android.gms.internal.play_billing.zze r8 = r8.f8890f     // Catch:{ Exception -> 0x0168 }
            java.lang.String r9 = "subs"
            int r7 = r8.zzc(r6, r4, r9, r0)     // Catch:{ Exception -> 0x0168 }
        L_0x004a:
            if (r7 != 0) goto L_0x004d
            goto L_0x0051
        L_0x004d:
            int r6 = r6 + -1
            goto L_0x002d
        L_0x0050:
            r6 = r3
        L_0x0051:
            com.android.billingclient.api.f r8 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            r9 = 5
            r10 = 1
            if (r6 < r9) goto L_0x0059
            r9 = r10
            goto L_0x005a
        L_0x0059:
            r9 = r3
        L_0x005a:
            r8.f8893i = r9     // Catch:{ Exception -> 0x0168 }
            com.android.billingclient.api.f r8 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            if (r6 < r1) goto L_0x0063
            r9 = r10
            goto L_0x0064
        L_0x0063:
            r9 = r3
        L_0x0064:
            r8.f8892h = r9     // Catch:{ Exception -> 0x0168 }
            if (r6 >= r1) goto L_0x0070
            java.lang.String r6 = "BillingClient"
            java.lang.String r8 = "In-app billing API does not support subscription on this device."
            com.google.android.gms.internal.play_billing.zzb.zzi(r6, r8)     // Catch:{ Exception -> 0x0168 }
        L_0x0070:
            r6 = r5
        L_0x0071:
            if (r6 < r1) goto L_0x0099
            if (r0 != 0) goto L_0x0082
            com.android.billingclient.api.f r8 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            com.google.android.gms.internal.play_billing.zze r8 = r8.f8890f     // Catch:{ Exception -> 0x0168 }
            java.lang.String r9 = "inapp"
            int r7 = r8.zzr(r6, r4, r9)     // Catch:{ Exception -> 0x0168 }
            goto L_0x008e
        L_0x0082:
            com.android.billingclient.api.f r8 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            com.google.android.gms.internal.play_billing.zze r8 = r8.f8890f     // Catch:{ Exception -> 0x0168 }
            java.lang.String r9 = "inapp"
            int r7 = r8.zzc(r6, r4, r9, r0)     // Catch:{ Exception -> 0x0168 }
        L_0x008e:
            if (r7 != 0) goto L_0x0096
            com.android.billingclient.api.f r0 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            r0.f8894j = r6     // Catch:{ Exception -> 0x0168 }
            goto L_0x0099
        L_0x0096:
            int r6 = r6 + -1
            goto L_0x0071
        L_0x0099:
            com.android.billingclient.api.f r0 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            int r4 = r0.f8894j     // Catch:{ Exception -> 0x0168 }
            if (r4 < r5) goto L_0x00a3
            r4 = r10
            goto L_0x00a4
        L_0x00a3:
            r4 = r3
        L_0x00a4:
            r0.f8905u = r4     // Catch:{ Exception -> 0x0168 }
            com.android.billingclient.api.f r0 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            int r4 = r0.f8894j     // Catch:{ Exception -> 0x0168 }
            r5 = 18
            if (r4 < r5) goto L_0x00b3
            r4 = r10
            goto L_0x00b4
        L_0x00b3:
            r4 = r3
        L_0x00b4:
            r0.f8904t = r4     // Catch:{ Exception -> 0x0168 }
            com.android.billingclient.api.f r0 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            int r4 = r0.f8894j     // Catch:{ Exception -> 0x0168 }
            r5 = 17
            if (r4 < r5) goto L_0x00c3
            r4 = r10
            goto L_0x00c4
        L_0x00c3:
            r4 = r3
        L_0x00c4:
            r0.f8903s = r4     // Catch:{ Exception -> 0x0168 }
            com.android.billingclient.api.f r0 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            int r4 = r0.f8894j     // Catch:{ Exception -> 0x0168 }
            r5 = 16
            if (r4 < r5) goto L_0x00d3
            r4 = r10
            goto L_0x00d4
        L_0x00d3:
            r4 = r3
        L_0x00d4:
            r0.f8902r = r4     // Catch:{ Exception -> 0x0168 }
            com.android.billingclient.api.f r0 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            int r4 = r0.f8894j     // Catch:{ Exception -> 0x0168 }
            r5 = 15
            if (r4 < r5) goto L_0x00e3
            r4 = r10
            goto L_0x00e4
        L_0x00e3:
            r4 = r3
        L_0x00e4:
            r0.f8901q = r4     // Catch:{ Exception -> 0x0168 }
            com.android.billingclient.api.f r0 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            int r4 = r0.f8894j     // Catch:{ Exception -> 0x0168 }
            r5 = 14
            if (r4 < r5) goto L_0x00f3
            r4 = r10
            goto L_0x00f4
        L_0x00f3:
            r4 = r3
        L_0x00f4:
            r0.f8900p = r4     // Catch:{ Exception -> 0x0168 }
            com.android.billingclient.api.f r0 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            int r4 = r0.f8894j     // Catch:{ Exception -> 0x0168 }
            r5 = 12
            if (r4 < r5) goto L_0x0103
            r4 = r10
            goto L_0x0104
        L_0x0103:
            r4 = r3
        L_0x0104:
            r0.f8899o = r4     // Catch:{ Exception -> 0x0168 }
            com.android.billingclient.api.f r0 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            int r4 = r0.f8894j     // Catch:{ Exception -> 0x0168 }
            r5 = 10
            if (r4 < r5) goto L_0x0113
            r4 = r10
            goto L_0x0114
        L_0x0113:
            r4 = r3
        L_0x0114:
            r0.f8898n = r4     // Catch:{ Exception -> 0x0168 }
            com.android.billingclient.api.f r0 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            int r4 = r0.f8894j     // Catch:{ Exception -> 0x0168 }
            r5 = 9
            if (r4 < r5) goto L_0x0123
            r4 = r10
            goto L_0x0124
        L_0x0123:
            r4 = r3
        L_0x0124:
            r0.f8897m = r4     // Catch:{ Exception -> 0x0168 }
            com.android.billingclient.api.f r0 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            int r4 = r0.f8894j     // Catch:{ Exception -> 0x0168 }
            r5 = 8
            if (r4 < r5) goto L_0x0133
            r4 = r10
            goto L_0x0134
        L_0x0133:
            r4 = r3
        L_0x0134:
            r0.f8896l = r4     // Catch:{ Exception -> 0x0168 }
            com.android.billingclient.api.f r0 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            int r4 = r0.f8894j     // Catch:{ Exception -> 0x0168 }
            r5 = 6
            if (r4 < r5) goto L_0x0141
            goto L_0x0142
        L_0x0141:
            r10 = r3
        L_0x0142:
            r0.f8895k = r10     // Catch:{ Exception -> 0x0168 }
            com.android.billingclient.api.f r0 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            int r0 = r0.f8894j     // Catch:{ Exception -> 0x0168 }
            if (r0 >= r1) goto L_0x0154
            java.lang.String r0 = "BillingClient"
            java.lang.String r1 = "In-app billing API version 3 is not supported on this device."
            com.google.android.gms.internal.play_billing.zzb.zzj(r0, r1)     // Catch:{ Exception -> 0x0168 }
        L_0x0154:
            if (r7 != 0) goto L_0x015d
            com.android.billingclient.api.f r0 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            r1 = 2
            r0.f8885a = r1     // Catch:{ Exception -> 0x0168 }
            goto L_0x017e
        L_0x015d:
            com.android.billingclient.api.f r0 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            r0.f8885a = r3     // Catch:{ Exception -> 0x0168 }
            com.android.billingclient.api.f r0 = r11.f8948d     // Catch:{ Exception -> 0x0168 }
            r0.f8890f = r2     // Catch:{ Exception -> 0x0168 }
            goto L_0x017e
        L_0x0168:
            r0 = move-exception
            r1 = r7
            goto L_0x016c
        L_0x016b:
            r0 = move-exception
        L_0x016c:
            java.lang.String r4 = "BillingClient"
            java.lang.String r5 = "Exception while checking if billing is supported; try to reconnect"
            com.google.android.gms.internal.play_billing.zzb.zzk(r4, r5, r0)
            com.android.billingclient.api.f r0 = r11.f8948d
            r0.f8885a = r3
            com.android.billingclient.api.f r0 = r11.f8948d
            r0.f8890f = r2
            r7 = r1
        L_0x017e:
            if (r7 != 0) goto L_0x0186
            com.android.billingclient.api.i r0 = com.android.billingclient.api.u0.f9022l
            r11.c(r0)
            goto L_0x018b
        L_0x0186:
            com.android.billingclient.api.i r0 = com.android.billingclient.api.u0.f9011a
            r11.c(r0)
        L_0x018b:
            return r2
        L_0x018c:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x018c }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.j0.a():java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void b() {
        this.f8948d.f8885a = 0;
        this.f8948d.f8890f = null;
        c(u0.f9024n);
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzb.zzi("BillingClient", "Billing service connected.");
        this.f8948d.f8890f = zzd.zzo(iBinder);
        f fVar = this.f8948d;
        if (fVar.w(new g0(this), 30000, new h0(this), fVar.s()) == null) {
            c(this.f8948d.u());
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zzb.zzj("BillingClient", "Billing service disconnected.");
        int i10 = zzfv.zzb;
        this.f8948d.f8890f = null;
        this.f8948d.f8885a = 0;
        synchronized (this.f8945a) {
            g gVar = this.f8947c;
            if (gVar != null) {
                gVar.b();
            }
        }
    }
}
