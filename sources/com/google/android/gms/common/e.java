package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import androidx.annotation.NonNull;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.p;
import com.mparticle.kits.ReportingMessage;
import java.util.concurrent.atomic.AtomicBoolean;
import me.j;
import me.s;
import oe.d;

public class e {
    static final int GMS_AVAILABILITY_NOTIFICATION_ID = 10436;
    static final int GMS_GENERAL_ERROR_NOTIFICATION_ID = 39789;
    @NonNull
    public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";
    @NonNull
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
    @NonNull
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    static final AtomicBoolean sCanceledAvailabilityNotification = new AtomicBoolean();
    static boolean zza = false;
    private static boolean zzb = false;
    private static final AtomicBoolean zzc = new AtomicBoolean();

    e() {
    }

    @Deprecated
    public static void cancelAvailabilityErrorNotifications(@NonNull Context context) {
        if (!sCanceledAvailabilityNotification.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(GMS_AVAILABILITY_NOTIFICATION_ID);
                }
            } catch (SecurityException unused) {
            }
        }
    }

    public static void enableUsingApkIndependentContext() {
        zzc.set(true);
    }

    @Deprecated
    public static void ensurePlayServicesAvailable(@NonNull Context context, int i10) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int j10 = d.h().j(context, i10);
        if (j10 != 0) {
            Intent d10 = d.h().d(context, j10, ReportingMessage.MessageType.EVENT);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("GooglePlayServices not available due to error ");
            sb2.append(j10);
            if (d10 == null) {
                throw new GooglePlayServicesNotAvailableException(j10);
            }
            throw new GooglePlayServicesRepairableException(j10, "Google Play Services not available", d10);
        }
    }

    @Deprecated
    public static int getApkVersion(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    @Deprecated
    public static int getClientVersion(@NonNull Context context) {
        p.o(true);
        return me.e.a(context, context.getPackageName());
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i10, @NonNull Context context, int i11) {
        return d.h().e(context, i10, i11);
    }

    @NonNull
    @Deprecated
    public static String getErrorString(int i10) {
        return ConnectionResult.m0(i10);
    }

    @Deprecated
    public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int i10) {
        return d.h().d((Context) null, i10, (String) null);
    }

    public static Context getRemoteContext(@NonNull Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static Resources getRemoteResource(@NonNull Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean honorsDebugCertificates(@NonNull Context context) {
        if (!zza) {
            try {
                PackageInfo e10 = d.a(context).e("com.google.android.gms", 64);
                f.a(context);
                if (e10 == null || f.e(e10, false) || !f.e(e10, true)) {
                    zzb = false;
                } else {
                    zzb = true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            } finally {
                zza = true;
            }
        }
        if (zzb || !j.c()) {
            return true;
        }
        return false;
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(@NonNull Context context) {
        return isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    @Deprecated
    public static boolean isGooglePlayServicesUid(@NonNull Context context, int i10) {
        return s.a(context, i10);
    }

    @Deprecated
    public static boolean isPlayServicesPossiblyUpdating(@NonNull Context context, int i10) {
        if (i10 == 18) {
            return true;
        }
        if (i10 == 1) {
            return zza(context, "com.google.android.gms");
        }
        return false;
    }

    @Deprecated
    public static boolean isPlayStorePossiblyUpdating(@NonNull Context context, int i10) {
        if (i10 == 9) {
            return zza(context, "com.android.vending");
        }
        return false;
    }

    @TargetApi(18)
    public static boolean isRestrictedUserProfile(@NonNull Context context) {
        if (!me.p.c()) {
            return false;
        }
        Object systemService = context.getSystemService("user");
        p.k(systemService);
        Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
        if (applicationRestrictions == null || !ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(applicationRestrictions.getString("restricted_profile"))) {
            return false;
        }
        return true;
    }

    @Deprecated
    public static boolean isSidewinderDevice(@NonNull Context context) {
        return j.b(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i10) {
        return i10 == 1 || i10 == 2 || i10 == 3 || i10 == 9;
    }

    @TargetApi(19)
    @Deprecated
    public static boolean uidHasPackageName(@NonNull Context context, int i10, @NonNull String str) {
        return s.b(context, i10, str);
    }

    @TargetApi(21)
    static boolean zza(Context context, String str) {
        boolean equals = str.equals("com.google.android.gms");
        if (me.p.f()) {
            try {
                for (PackageInstaller.SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                    if (str.equals(appPackageName.getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            if (equals) {
                return applicationInfo.enabled;
            }
            if (!applicationInfo.enabled || isRestrictedUserProfile(context)) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0089  */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int isGooglePlayServicesAvailable(@androidx.annotation.NonNull android.content.Context r9, int r10) {
        /*
            android.content.res.Resources r0 = r9.getResources()     // Catch:{ all -> 0x0009 }
            int r1 = com.google.android.gms.common.g.common_google_play_services_unknown_issue     // Catch:{ all -> 0x0009 }
            r0.getString(r1)     // Catch:{ all -> 0x0009 }
        L_0x0009:
            java.lang.String r0 = r9.getPackageName()
            java.lang.String r1 = "com.google.android.gms"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0035
            java.util.concurrent.atomic.AtomicBoolean r0 = zzc
            boolean r0 = r0.get()
            if (r0 == 0) goto L_0x001e
            goto L_0x0035
        L_0x001e:
            int r0 = com.google.android.gms.common.internal.y0.a(r9)
            if (r0 == 0) goto L_0x002f
            int r2 = GOOGLE_PLAY_SERVICES_VERSION_CODE
            if (r0 != r2) goto L_0x0029
            goto L_0x0035
        L_0x0029:
            com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException r9 = new com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException
            r9.<init>(r0)
            throw r9
        L_0x002f:
            com.google.android.gms.common.GooglePlayServicesMissingManifestValueException r9 = new com.google.android.gms.common.GooglePlayServicesMissingManifestValueException
            r9.<init>()
            throw r9
        L_0x0035:
            boolean r0 = me.j.e(r9)
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x0045
            boolean r0 = me.j.g(r9)
            if (r0 != 0) goto L_0x0045
            r0 = r2
            goto L_0x0046
        L_0x0045:
            r0 = r3
        L_0x0046:
            if (r10 < 0) goto L_0x004a
            r4 = r2
            goto L_0x004b
        L_0x004a:
            r4 = r3
        L_0x004b:
            com.google.android.gms.common.internal.p.a(r4)
            java.lang.String r4 = r9.getPackageName()
            android.content.pm.PackageManager r5 = r9.getPackageManager()
            r6 = 9
            if (r0 == 0) goto L_0x006f
            java.lang.String r7 = "com.android.vending"
            r8 = 8256(0x2040, float:1.1569E-41)
            android.content.pm.PackageInfo r7 = r5.getPackageInfo(r7, r8)     // Catch:{ NameNotFoundException -> 0x0063 }
            goto L_0x0070
        L_0x0063:
            java.lang.String r9 = java.lang.String.valueOf(r4)
            java.lang.String r10 = " requires the Google Play Store, but it is missing."
            r9.concat(r10)
        L_0x006c:
            r2 = r6
            goto L_0x0111
        L_0x006f:
            r7 = 0
        L_0x0070:
            r8 = 64
            android.content.pm.PackageInfo r8 = r5.getPackageInfo(r1, r8)     // Catch:{ NameNotFoundException -> 0x0108 }
            com.google.android.gms.common.f.a(r9)
            boolean r9 = com.google.android.gms.common.f.e(r8, r2)
            if (r9 != 0) goto L_0x0089
            java.lang.String r9 = java.lang.String.valueOf(r4)
            java.lang.String r10 = " requires Google Play services, but their signature is invalid."
            r9.concat(r10)
            goto L_0x006c
        L_0x0089:
            if (r0 == 0) goto L_0x009e
            com.google.android.gms.common.internal.p.k(r7)
            boolean r9 = com.google.android.gms.common.f.e(r7, r2)
            if (r9 != 0) goto L_0x009e
            java.lang.String r9 = java.lang.String.valueOf(r4)
            java.lang.String r10 = " requires Google Play Store, but its signature is invalid."
            r9.concat(r10)
            goto L_0x006c
        L_0x009e:
            if (r0 == 0) goto L_0x00ba
            if (r7 == 0) goto L_0x00ba
            android.content.pm.Signature[] r9 = r7.signatures
            r9 = r9[r3]
            android.content.pm.Signature[] r0 = r8.signatures
            r0 = r0[r3]
            boolean r9 = r9.equals(r0)
            if (r9 != 0) goto L_0x00ba
            java.lang.String r9 = java.lang.String.valueOf(r4)
            java.lang.String r10 = " requires Google Play Store, but its signature doesn't match that of Google Play services."
            r9.concat(r10)
            goto L_0x006c
        L_0x00ba:
            int r9 = r8.versionCode
            int r9 = me.u.a(r9)
            int r0 = me.u.a(r10)
            if (r9 >= r0) goto L_0x00e7
            int r9 = r8.versionCode
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Google Play services out of date for "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = ".  Requires "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r10 = " but found "
            r0.append(r10)
            r0.append(r9)
            r2 = 2
            goto L_0x0111
        L_0x00e7:
            android.content.pm.ApplicationInfo r9 = r8.applicationInfo
            if (r9 != 0) goto L_0x0101
            android.content.pm.ApplicationInfo r9 = r5.getApplicationInfo(r1, r3)     // Catch:{ NameNotFoundException -> 0x00f0 }
            goto L_0x0101
        L_0x00f0:
            r9 = move-exception
            java.lang.String r10 = java.lang.String.valueOf(r4)
            java.lang.String r0 = " requires Google Play services, but they're missing when getting application info."
            java.lang.String r10 = r10.concat(r0)
            java.lang.String r0 = "GooglePlayServicesUtil"
            android.util.Log.wtf(r0, r10, r9)
            goto L_0x0111
        L_0x0101:
            boolean r9 = r9.enabled
            if (r9 != 0) goto L_0x0107
            r2 = 3
            goto L_0x0111
        L_0x0107:
            return r3
        L_0x0108:
            java.lang.String r9 = java.lang.String.valueOf(r4)
            java.lang.String r10 = " requires Google Play services, but they are missing."
            r9.concat(r10)
        L_0x0111:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.e.isGooglePlayServicesAvailable(android.content.Context, int):int");
    }
}
