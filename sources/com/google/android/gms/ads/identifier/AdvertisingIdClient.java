package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.a;
import com.google.android.gms.common.d;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import le.b;

public class AdvertisingIdClient {
    a zza;
    zzf zzb;
    boolean zzc;
    final Object zzd;
    zzb zze;
    final long zzf;
    private final Context zzg;

    public static final class Info {
        private final String zza;
        private final boolean zzb;

        @Deprecated
        public Info(String str, boolean z10) {
            this.zza = str;
            this.zzb = z10;
        }

        public String getId() {
            return this.zza;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzb;
        }

        @NonNull
        public String toString() {
            String str = this.zza;
            boolean z10 = this.zzb;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 7);
            sb2.append("{");
            sb2.append(str);
            sb2.append("}");
            sb2.append(z10);
            return sb2.toString();
        }
    }

    public AdvertisingIdClient(@NonNull Context context) {
        this(context, 30000, false, false);
    }

    @NonNull
    public static Info getAdvertisingIdInfo(@NonNull Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, true, false);
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.zzb(false);
            Info zzd2 = advertisingIdClient.zzd(-1);
            advertisingIdClient.zzc(zzd2, true, 0.0f, SystemClock.elapsedRealtime() - elapsedRealtime, "", (Throwable) null);
            advertisingIdClient.zza();
            return zzd2;
        } catch (Throwable th2) {
            advertisingIdClient.zza();
            throw th2;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:42|43|44) */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0068, code lost:
        throw new java.io.IOException("Remote exception");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x0061 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean getIsAdIdFakeForDebugLogging(@androidx.annotation.NonNull android.content.Context r7) throws java.io.IOException, com.google.android.gms.common.GooglePlayServicesNotAvailableException, com.google.android.gms.common.GooglePlayServicesRepairableException {
        /*
            com.google.android.gms.ads.identifier.AdvertisingIdClient r6 = new com.google.android.gms.ads.identifier.AdvertisingIdClient
            r2 = -1
            r4 = 0
            r5 = 0
            r0 = r6
            r1 = r7
            r0.<init>(r1, r2, r4, r5)
            r7 = 0
            r6.zzb(r7)     // Catch:{ all -> 0x006c }
            java.lang.String r0 = "Calling this from your main thread can lead to deadlock"
            com.google.android.gms.common.internal.p.j(r0)     // Catch:{ all -> 0x006c }
            monitor-enter(r6)     // Catch:{ all -> 0x006c }
            boolean r0 = r6.zzc     // Catch:{ all -> 0x0069 }
            if (r0 != 0) goto L_0x0049
            java.lang.Object r0 = r6.zzd     // Catch:{ all -> 0x0069 }
            monitor-enter(r0)     // Catch:{ all -> 0x0069 }
            com.google.android.gms.ads.identifier.zzb r1 = r6.zze     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x003e
            boolean r1 = r1.zzb     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x003e
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            r6.zzb(r7)     // Catch:{ Exception -> 0x0035 }
            boolean r7 = r6.zzc     // Catch:{ all -> 0x0069 }
            if (r7 == 0) goto L_0x002d
            goto L_0x0049
        L_0x002d:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x0069 }
            java.lang.String r0 = "AdvertisingIdClient cannot reconnect."
            r7.<init>(r0)     // Catch:{ all -> 0x0069 }
            throw r7     // Catch:{ all -> 0x0069 }
        L_0x0035:
            r7 = move-exception
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0069 }
            java.lang.String r1 = "AdvertisingIdClient cannot reconnect."
            r0.<init>(r1, r7)     // Catch:{ all -> 0x0069 }
            throw r0     // Catch:{ all -> 0x0069 }
        L_0x003e:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x0046 }
            java.lang.String r1 = "AdvertisingIdClient is not connected."
            r7.<init>(r1)     // Catch:{ all -> 0x0046 }
            throw r7     // Catch:{ all -> 0x0046 }
        L_0x0046:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            throw r7     // Catch:{ all -> 0x0069 }
        L_0x0049:
            com.google.android.gms.common.a r7 = r6.zza     // Catch:{ all -> 0x0069 }
            com.google.android.gms.common.internal.p.k(r7)     // Catch:{ all -> 0x0069 }
            com.google.android.gms.internal.ads_identifier.zzf r7 = r6.zzb     // Catch:{ all -> 0x0069 }
            com.google.android.gms.common.internal.p.k(r7)     // Catch:{ all -> 0x0069 }
            com.google.android.gms.internal.ads_identifier.zzf r7 = r6.zzb     // Catch:{ RemoteException -> 0x0061 }
            boolean r7 = r7.zzd()     // Catch:{ RemoteException -> 0x0061 }
            monitor-exit(r6)     // Catch:{ all -> 0x0069 }
            r6.zze()     // Catch:{ all -> 0x006c }
            r6.zza()
            return r7
        L_0x0061:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x0069 }
            java.lang.String r0 = "Remote exception"
            r7.<init>(r0)     // Catch:{ all -> 0x0069 }
            throw r7     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0069 }
            throw r7     // Catch:{ all -> 0x006c }
        L_0x006c:
            r7 = move-exception
            r6.zza()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.getIsAdIdFakeForDebugLogging(android.content.Context):boolean");
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z10) {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:39|40|41) */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0063, code lost:
        throw new java.io.IOException("Remote exception");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x005c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.ads.identifier.AdvertisingIdClient.Info zzd(int r4) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.String r4 = "Calling this from your main thread can lead to deadlock"
            com.google.android.gms.common.internal.p.j(r4)
            monitor-enter(r3)
            boolean r4 = r3.zzc     // Catch:{ all -> 0x0064 }
            if (r4 != 0) goto L_0x003b
            java.lang.Object r4 = r3.zzd     // Catch:{ all -> 0x0064 }
            monitor-enter(r4)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.ads.identifier.zzb r0 = r3.zze     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x0030
            boolean r0 = r0.zzb     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x0030
            monitor-exit(r4)     // Catch:{ all -> 0x0038 }
            r4 = 0
            r3.zzb(r4)     // Catch:{ Exception -> 0x0027 }
            boolean r4 = r3.zzc     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x001f
            goto L_0x003b
        L_0x001f:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x0064 }
            java.lang.String r0 = "AdvertisingIdClient cannot reconnect."
            r4.<init>(r0)     // Catch:{ all -> 0x0064 }
            throw r4     // Catch:{ all -> 0x0064 }
        L_0x0027:
            r4 = move-exception
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0064 }
            java.lang.String r1 = "AdvertisingIdClient cannot reconnect."
            r0.<init>(r1, r4)     // Catch:{ all -> 0x0064 }
            throw r0     // Catch:{ all -> 0x0064 }
        L_0x0030:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0038 }
            java.lang.String r1 = "AdvertisingIdClient is not connected."
            r0.<init>(r1)     // Catch:{ all -> 0x0038 }
            throw r0     // Catch:{ all -> 0x0038 }
        L_0x0038:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0038 }
            throw r0     // Catch:{ all -> 0x0064 }
        L_0x003b:
            com.google.android.gms.common.a r4 = r3.zza     // Catch:{ all -> 0x0064 }
            com.google.android.gms.common.internal.p.k(r4)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.internal.ads_identifier.zzf r4 = r3.zzb     // Catch:{ all -> 0x0064 }
            com.google.android.gms.common.internal.p.k(r4)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r4 = new com.google.android.gms.ads.identifier.AdvertisingIdClient$Info     // Catch:{ RemoteException -> 0x005c }
            com.google.android.gms.internal.ads_identifier.zzf r0 = r3.zzb     // Catch:{ RemoteException -> 0x005c }
            java.lang.String r0 = r0.zzc()     // Catch:{ RemoteException -> 0x005c }
            com.google.android.gms.internal.ads_identifier.zzf r1 = r3.zzb     // Catch:{ RemoteException -> 0x005c }
            r2 = 1
            boolean r1 = r1.zze(r2)     // Catch:{ RemoteException -> 0x005c }
            r4.<init>(r0, r1)     // Catch:{ RemoteException -> 0x005c }
            monitor-exit(r3)     // Catch:{ all -> 0x0064 }
            r3.zze()
            return r4
        L_0x005c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x0064 }
            java.lang.String r0 = "Remote exception"
            r4.<init>(r0)     // Catch:{ all -> 0x0064 }
            throw r4     // Catch:{ all -> 0x0064 }
        L_0x0064:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0064 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.zzd(int):com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|3|(3:5|6|7)|8|9|(1:11)|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0011 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zze() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.zzd
            monitor-enter(r0)
            com.google.android.gms.ads.identifier.zzb r1 = r5.zze     // Catch:{ all -> 0x0022 }
            if (r1 == 0) goto L_0x0011
            java.util.concurrent.CountDownLatch r1 = r1.zza     // Catch:{ all -> 0x0022 }
            r1.countDown()     // Catch:{ all -> 0x0022 }
            com.google.android.gms.ads.identifier.zzb r1 = r5.zze     // Catch:{ InterruptedException -> 0x0011 }
            r1.join()     // Catch:{ InterruptedException -> 0x0011 }
        L_0x0011:
            long r1 = r5.zzf     // Catch:{ all -> 0x0022 }
            r3 = 0
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0020
            com.google.android.gms.ads.identifier.zzb r3 = new com.google.android.gms.ads.identifier.zzb     // Catch:{ all -> 0x0022 }
            r3.<init>(r5, r1)     // Catch:{ all -> 0x0022 }
            r5.zze = r3     // Catch:{ all -> 0x0022 }
        L_0x0020:
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            return
        L_0x0022:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.zze():void");
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        zza();
        super.finalize();
    }

    @NonNull
    public Info getInfo() throws IOException {
        return zzd(-1);
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza() {
        /*
            r3 = this;
            java.lang.String r0 = "Calling this from your main thread can lead to deadlock"
            com.google.android.gms.common.internal.p.j(r0)
            monitor-enter(r3)
            android.content.Context r0 = r3.zzg     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x0028
            com.google.android.gms.common.a r0 = r3.zza     // Catch:{ all -> 0x002a }
            if (r0 != 0) goto L_0x000f
            goto L_0x0028
        L_0x000f:
            boolean r0 = r3.zzc     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x001e
            le.b r0 = le.b.b()     // Catch:{ all -> 0x001e }
            android.content.Context r1 = r3.zzg     // Catch:{ all -> 0x001e }
            com.google.android.gms.common.a r2 = r3.zza     // Catch:{ all -> 0x001e }
            r0.c(r1, r2)     // Catch:{ all -> 0x001e }
        L_0x001e:
            r0 = 0
            r3.zzc = r0     // Catch:{ all -> 0x002a }
            r0 = 0
            r3.zzb = r0     // Catch:{ all -> 0x002a }
            r3.zza = r0     // Catch:{ all -> 0x002a }
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            return
        L_0x0028:
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            return
        L_0x002a:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.zza():void");
    }

    /* access modifiers changed from: protected */
    public final void zzb(boolean z10) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        p.j("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzc) {
                zza();
            }
            Context context = this.zzg;
            try {
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                int j10 = d.h().j(context, e.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                if (j10 != 0) {
                    if (j10 != 2) {
                        throw new IOException("Google Play services not available");
                    }
                }
                a aVar = new a();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (b.b().a(context, intent, aVar, 1)) {
                    this.zza = aVar;
                    this.zzb = zze.zza(aVar.a(10000, TimeUnit.MILLISECONDS));
                    this.zzc = true;
                    if (z10) {
                        zze();
                    }
                } else {
                    throw new IOException("Connection failure");
                }
            } catch (PackageManager.NameNotFoundException unused) {
                throw new GooglePlayServicesNotAvailableException(9);
            } catch (InterruptedException unused2) {
                throw new IOException("Interrupted exception");
            } catch (Throwable th2) {
                throw new IOException(th2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc(Info info, boolean z10, float f10, long j10, String str, Throwable th2) {
        if (Math.random() > 0.0d) {
            return false;
        }
        HashMap hashMap = new HashMap();
        String str2 = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        hashMap.put("app_context", str2);
        if (info != null) {
            if (true != info.isLimitAdTrackingEnabled()) {
                str2 = "0";
            }
            hashMap.put("limit_ad_tracking", str2);
            String id2 = info.getId();
            if (id2 != null) {
                hashMap.put("ad_id_size", Integer.toString(id2.length()));
            }
        }
        if (th2 != null) {
            hashMap.put("error", th2.getClass().getName());
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j10));
        new zza(this, hashMap).start();
        return true;
    }

    public AdvertisingIdClient(@NonNull Context context, long j10, boolean z10, boolean z11) {
        Context applicationContext;
        this.zzd = new Object();
        p.k(context);
        if (z10 && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.zzg = context;
        this.zzc = false;
        this.zzf = j10;
    }
}
