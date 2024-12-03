package com.clevertap.android.sdk.pushnotification;

import android.content.Context;
import android.os.Bundle;
import androidx.core.app.p;
import com.clevertap.android.sdk.CleverTapInstanceConfig;

public interface e {
    /* JADX WARNING: Can't wrap try/catch for region: R(2:4|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        r8 = java.lang.Class.forName("com.clevertap.android.sdk.pushnotification.CTNotificationIntentService");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        com.clevertap.android.sdk.p.a("No Intent Service found");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x001e */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b9 A[SYNTHETIC, Splitter:B:42:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00ed A[Catch:{ all -> 0x0088, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x010c A[Catch:{ all -> 0x0088, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x012f A[Catch:{ all -> 0x0088, all -> 0x0176 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0153 A[Catch:{ all -> 0x0174 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x015f A[Catch:{ all -> 0x0174 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0164 A[Catch:{ all -> 0x0174 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    androidx.core.app.p.e b(android.content.Context r18, android.os.Bundle r19, int r20, androidx.core.app.p.e r21, org.json.a r22) {
        /*
            r17 = this;
            r1 = r18
            r2 = r19
            r3 = r21
            r4 = r22
            java.lang.String r5 = "dl"
            java.lang.String r0 = "com.clevertap.android.sdk.pushnotification.CTNotificationIntentService"
            com.clevertap.android.sdk.q r6 = com.clevertap.android.sdk.q.h(r18)
            java.lang.String r6 = r6.i()
            java.lang.String r7 = "No Intent Service found"
            r8 = 0
            if (r6 == 0) goto L_0x0027
            java.lang.Class r8 = java.lang.Class.forName(r6)     // Catch:{ ClassNotFoundException -> 0x001e }
            goto L_0x002f
        L_0x001e:
            java.lang.Class r8 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0023 }
            goto L_0x002f
        L_0x0023:
            com.clevertap.android.sdk.p.a(r7)
            goto L_0x002f
        L_0x0027:
            java.lang.Class r8 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x002c }
            goto L_0x002f
        L_0x002c:
            com.clevertap.android.sdk.p.a(r7)
        L_0x002f:
            boolean r6 = i4.x.u(r1, r8)
            if (r4 == 0) goto L_0x0195
            int r0 = r22.o()
            if (r0 <= 0) goto L_0x0195
            r8 = 0
        L_0x003c:
            int r0 = r22.o()
            if (r8 >= r0) goto L_0x0195
            org.json.b r0 = r4.j(r8)     // Catch:{ all -> 0x0176 }
            java.lang.String r9 = "l"
            java.lang.String r9 = r0.optString(r9)     // Catch:{ all -> 0x0176 }
            java.lang.String r10 = r0.optString(r5)     // Catch:{ all -> 0x0176 }
            java.lang.String r11 = r17.d()     // Catch:{ all -> 0x0176 }
            java.lang.String r11 = r0.optString(r11)     // Catch:{ all -> 0x0176 }
            java.lang.String r12 = "id"
            java.lang.String r12 = r0.optString(r12)     // Catch:{ all -> 0x0176 }
            java.lang.String r13 = "ac"
            r14 = 1
            boolean r13 = r0.optBoolean(r13, r14)     // Catch:{ all -> 0x0176 }
            boolean r0 = r9.isEmpty()     // Catch:{ all -> 0x0176 }
            if (r0 != 0) goto L_0x016c
            boolean r0 = r12.isEmpty()     // Catch:{ all -> 0x0176 }
            if (r0 == 0) goto L_0x0073
            goto L_0x016c
        L_0x0073:
            boolean r0 = r11.isEmpty()     // Catch:{ all -> 0x0176 }
            if (r0 != 0) goto L_0x00a1
            android.content.res.Resources r0 = r18.getResources()     // Catch:{ all -> 0x0088 }
            java.lang.String r15 = "drawable"
            java.lang.String r7 = r18.getPackageName()     // Catch:{ all -> 0x0088 }
            int r0 = r0.getIdentifier(r11, r15, r7)     // Catch:{ all -> 0x0088 }
            goto L_0x00a2
        L_0x0088:
            r0 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0176 }
            r7.<init>()     // Catch:{ all -> 0x0176 }
            java.lang.String r11 = "unable to add notification action icon: "
            r7.append(r11)     // Catch:{ all -> 0x0176 }
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ all -> 0x0176 }
            r7.append(r0)     // Catch:{ all -> 0x0176 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x0176 }
            com.clevertap.android.sdk.p.a(r0)     // Catch:{ all -> 0x0176 }
        L_0x00a1:
            r0 = 0
        L_0x00a2:
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0176 }
            r11 = 31
            if (r7 >= r11) goto L_0x00ae
            if (r13 == 0) goto L_0x00ae
            if (r6 == 0) goto L_0x00ae
            r7 = r14
            goto L_0x00af
        L_0x00ae:
            r7 = 0
        L_0x00af:
            java.lang.String r11 = "pt_dismiss_on_click"
            java.lang.String r11 = r2.getString(r11)     // Catch:{ all -> 0x0176 }
            java.lang.String r15 = "true"
            if (r7 != 0) goto L_0x00d4
            boolean r16 = com.clevertap.android.sdk.pushnotification.h.e(r19)     // Catch:{ all -> 0x0176 }
            if (r16 == 0) goto L_0x00d4
            java.lang.String r14 = "remind"
            boolean r14 = r12.contains(r14)     // Catch:{ all -> 0x0176 }
            if (r14 == 0) goto L_0x00d4
            if (r11 == 0) goto L_0x00d4
            boolean r14 = r11.equalsIgnoreCase(r15)     // Catch:{ all -> 0x0176 }
            if (r14 == 0) goto L_0x00d4
            if (r13 == 0) goto L_0x00d4
            if (r6 == 0) goto L_0x00d4
            r7 = 1
        L_0x00d4:
            if (r7 != 0) goto L_0x00ea
            boolean r14 = com.clevertap.android.sdk.pushnotification.h.e(r19)     // Catch:{ all -> 0x0176 }
            if (r14 == 0) goto L_0x00ea
            if (r11 == 0) goto L_0x00ea
            boolean r11 = r11.equalsIgnoreCase(r15)     // Catch:{ all -> 0x0176 }
            if (r11 == 0) goto L_0x00ea
            if (r13 == 0) goto L_0x00ea
            if (r6 == 0) goto L_0x00ea
            r14 = 1
            goto L_0x00eb
        L_0x00ea:
            r14 = r7
        L_0x00eb:
            if (r14 == 0) goto L_0x010c
            android.content.Intent r7 = new android.content.Intent     // Catch:{ all -> 0x0176 }
            java.lang.String r11 = "com.clevertap.PUSH_EVENT"
            r7.<init>(r11)     // Catch:{ all -> 0x0176 }
            java.lang.String r11 = r18.getPackageName()     // Catch:{ all -> 0x0176 }
            r7.setPackage(r11)     // Catch:{ all -> 0x0176 }
            java.lang.String r11 = "ct_type"
            java.lang.String r15 = "com.clevertap.ACTION_BUTTON_CLICK"
            r7.putExtra(r11, r15)     // Catch:{ all -> 0x0176 }
            boolean r11 = r10.isEmpty()     // Catch:{ all -> 0x0176 }
            if (r11 != 0) goto L_0x012d
            r7.putExtra(r5, r10)     // Catch:{ all -> 0x0176 }
            goto L_0x012d
        L_0x010c:
            boolean r7 = r10.isEmpty()     // Catch:{ all -> 0x0176 }
            if (r7 != 0) goto L_0x0121
            android.content.Intent r7 = new android.content.Intent     // Catch:{ all -> 0x0176 }
            java.lang.String r11 = "android.intent.action.VIEW"
            android.net.Uri r10 = android.net.Uri.parse(r10)     // Catch:{ all -> 0x0176 }
            r7.<init>(r11, r10)     // Catch:{ all -> 0x0176 }
            i4.x.w(r1, r7)     // Catch:{ all -> 0x0176 }
            goto L_0x012d
        L_0x0121:
            android.content.pm.PackageManager r7 = r18.getPackageManager()     // Catch:{ all -> 0x0176 }
            java.lang.String r10 = r18.getPackageName()     // Catch:{ all -> 0x0176 }
            android.content.Intent r7 = r7.getLaunchIntentForPackage(r10)     // Catch:{ all -> 0x0176 }
        L_0x012d:
            if (r7 == 0) goto L_0x0153
            r7.putExtras(r2)     // Catch:{ all -> 0x0176 }
            java.lang.String r10 = "wzrk_acts"
            r7.removeExtra(r10)     // Catch:{ all -> 0x0176 }
            java.lang.String r10 = "actionId"
            r7.putExtra(r10, r12)     // Catch:{ all -> 0x0176 }
            java.lang.String r10 = "autoCancel"
            r7.putExtra(r10, r13)     // Catch:{ all -> 0x0176 }
            java.lang.String r10 = "wzrk_c2a"
            r7.putExtra(r10, r12)     // Catch:{ all -> 0x0176 }
            java.lang.String r10 = "notificationId"
            r11 = r20
            r7.putExtra(r10, r11)     // Catch:{ all -> 0x0174 }
            r10 = 603979776(0x24000000, float:2.7755576E-17)
            r7.setFlags(r10)     // Catch:{ all -> 0x0174 }
            goto L_0x0155
        L_0x0153:
            r11 = r20
        L_0x0155:
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0174 }
            int r10 = (int) r12     // Catch:{ all -> 0x0174 }
            int r10 = r10 + r8
            r12 = 201326592(0xc000000, float:9.8607613E-32)
            if (r14 == 0) goto L_0x0164
            android.app.PendingIntent r7 = android.app.PendingIntent.getService(r1, r10, r7, r12)     // Catch:{ all -> 0x0174 }
            goto L_0x0168
        L_0x0164:
            android.app.PendingIntent r7 = android.app.PendingIntent.getActivity(r1, r10, r7, r12)     // Catch:{ all -> 0x0174 }
        L_0x0168:
            r3.a(r0, r9, r7)     // Catch:{ all -> 0x0174 }
            goto L_0x0191
        L_0x016c:
            r11 = r20
            java.lang.String r0 = "not adding push notification action: action label or id missing"
            com.clevertap.android.sdk.p.a(r0)     // Catch:{ all -> 0x0174 }
            goto L_0x0191
        L_0x0174:
            r0 = move-exception
            goto L_0x0179
        L_0x0176:
            r0 = move-exception
            r11 = r20
        L_0x0179:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "error adding notification action : "
            r7.append(r9)
            java.lang.String r0 = r0.getLocalizedMessage()
            r7.append(r0)
            java.lang.String r0 = r7.toString()
            com.clevertap.android.sdk.p.a(r0)
        L_0x0191:
            int r8 = r8 + 1
            goto L_0x003c
        L_0x0195:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.pushnotification.e.b(android.content.Context, android.os.Bundle, int, androidx.core.app.p$e, org.json.a):androidx.core.app.p$e");
    }

    String c(Bundle bundle, Context context);

    String d();

    p.e e(Bundle bundle, Context context, p.e eVar, CleverTapInstanceConfig cleverTapInstanceConfig, int i10);

    void f(int i10, Context context);

    Object g(Bundle bundle);

    String h(Bundle bundle);
}
