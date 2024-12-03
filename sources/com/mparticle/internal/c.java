package com.mparticle.internal;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.mparticle.MParticle;
import java.util.Locale;
import java.util.TimeZone;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.json.JSONException;
import org.json.b;

public class c {

    /* renamed from: e  reason: collision with root package name */
    private static volatile String f22433e;

    /* renamed from: a  reason: collision with root package name */
    private b f22434a;

    /* renamed from: b  reason: collision with root package name */
    private b f22435b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f22436c = true;

    /* renamed from: d  reason: collision with root package name */
    private MParticle.OperatingSystem f22437d;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22438a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f22439b;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        static {
            /*
                com.mparticle.MParticle$OperatingSystem[] r0 = com.mparticle.MParticle.OperatingSystem.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22439b = r0
                r1 = 1
                com.mparticle.MParticle$OperatingSystem r2 = com.mparticle.MParticle.OperatingSystem.ANDROID     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f22439b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mparticle.MParticle$OperatingSystem r3 = com.mparticle.MParticle.OperatingSystem.FIRE_OS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                com.mparticle.internal.MPUtility$AdIdInfo$Advertiser[] r2 = com.mparticle.internal.MPUtility.AdIdInfo.Advertiser.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f22438a = r2
                com.mparticle.internal.MPUtility$AdIdInfo$Advertiser r3 = com.mparticle.internal.MPUtility.AdIdInfo.Advertiser.AMAZON     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f22438a     // Catch:{ NoSuchFieldError -> 0x0038 }
                com.mparticle.internal.MPUtility$AdIdInfo$Advertiser r2 = com.mparticle.internal.MPUtility.AdIdInfo.Advertiser.GOOGLE     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mparticle.internal.c.a.<clinit>():void");
        }
    }

    c(MParticle.OperatingSystem operatingSystem) {
        this.f22437d = operatingSystem;
    }

    public static void a(String str) {
        f22433e = str;
    }

    private int c() {
        try {
            int i10 = 0;
            for (Integer intValue : MParticle.getInstance().Internal().c().getSupportedKits()) {
                if (intValue.intValue() >= 1000000) {
                    i10++;
                }
            }
            return i10;
        } catch (Exception unused) {
            Logger.debug("Exception while adding sideloadedKitsCount to Device Attribute");
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Context context, b bVar) {
        try {
            bVar.put("ir", (Object) context.getSharedPreferences("mParticlePrefs", 0).getString("mp::install_referrer", (String) null));
        } catch (JSONException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public b d(Context context) {
        b bVar = new b();
        try {
            bVar.put("bid", (Object) Build.ID);
            bVar.put(NetworkProfile.BISEXUAL, (Object) Build.BRAND);
            bVar.put(XHTMLText.P, (Object) Build.PRODUCT);
            bVar.put("dn", (Object) Build.DEVICE);
            bVar.put("dma", (Object) Build.MANUFACTURER);
            bVar.put("dp", (Object) b());
            bVar.put("dosv", (Object) Build.VERSION.SDK);
            bVar.put("dosvi", Build.VERSION.SDK_INT);
            bVar.put("dmdl", (Object) Build.MODEL);
            bVar.put("vr", (Object) Build.VERSION.RELEASE);
            a(bVar, context);
            bVar.put("dbe", MPUtility.isBluetoothEnabled(context));
            bVar.put("dbv", (Object) MPUtility.getBluetoothVersion(context));
            bVar.put("dsnfc", MPUtility.hasNfc(context));
            bVar.put("dst", MPUtility.hasTelephony(context));
            b bVar2 = new b();
            bVar2.put("cydia", MPUtility.isPhoneRooted());
            bVar.put("jb", (Object) bVar2);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            bVar.put("dsh", displayMetrics.heightPixels);
            bVar.put("dsw", displayMetrics.widthPixels);
            bVar.put("dpi", displayMetrics.densityDpi);
            Locale locale = Locale.getDefault();
            bVar.put("dc", (Object) locale.getDisplayCountry());
            bVar.put("dlc", (Object) locale.getCountry());
            bVar.put("dll", (Object) locale.getLanguage());
            bVar.put("tzn", (Object) MPUtility.getTimeZone());
            bVar.put("tz", TimeZone.getDefault().getRawOffset() / 3600000);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager.getPhoneType() != 0) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (networkOperatorName.length() != 0) {
                    bVar.put("nca", (Object) networkOperatorName);
                }
                String networkCountryIso = telephonyManager.getNetworkCountryIso();
                if (networkCountryIso.length() != 0) {
                    bVar.put("nc", (Object) networkCountryIso);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (6 == networkOperator.length()) {
                    bVar.put("mcc", (Object) networkOperator.substring(0, 3));
                    bVar.put("mnc", (Object) networkOperator.substring(3));
                }
            }
            bVar.put("it", MPUtility.isTablet(context));
            bVar.put("idst", MPUtility.isInDaylightSavings());
            if (!MPUtility.isEmpty((CharSequence) f22433e)) {
                bVar.put("imei", (Object) f22433e);
            }
        } catch (Exception unused) {
        }
        return bVar;
    }

    public static String a() {
        return f22433e;
    }

    public static void a(b bVar, Context context) throws JSONException {
        String androidID = MPUtility.getAndroidID(context);
        if (!MPUtility.isEmpty((CharSequence) androidID)) {
            bVar.put("duid", (Object) androidID);
            bVar.put("anid", (Object) androidID);
            bVar.put("ouid", (Object) MPUtility.getOpenUDID(context));
        }
    }

    public b b(Context context) {
        if (this.f22434a == null) {
            this.f22434a = d(context);
        }
        a(context, this.f22434a);
        return this.f22434a;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|4|5|7|8|(1:10)|11|12|13|15|16|(1:18)|19|20|21|(2:23|(1:25)(8:26|28|29|30|(1:32)|33|34|40))|27|28|29|30|(0)|33|34|40) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00e8 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ee A[Catch:{ Exception -> 0x0124, all -> 0x011f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.b c(android.content.Context r17) {
        /*
            r16 = this;
            java.lang.String r0 = "mp::firstrun::install"
            java.lang.String r1 = "mp::upgrade_date"
            java.lang.String r2 = "mp::version::counter"
            java.lang.String r3 = "mp::ict"
            org.json.b r4 = new org.json.b
            r4.<init>()
            java.lang.String r5 = "mParticlePrefs"
            r6 = 0
            r7 = r17
            android.content.SharedPreferences r5 = r7.getSharedPreferences(r5, r6)
            android.content.SharedPreferences$Editor r8 = r5.edit()
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            android.content.pm.PackageManager r11 = r17.getPackageManager()     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            java.lang.String r12 = r17.getPackageName()     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            java.lang.String r13 = "apn"
            r4.put((java.lang.String) r13, (java.lang.Object) r12)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            java.lang.String r13 = "sideloaded_kits_count"
            int r14 = r16.c()     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            r4.put((java.lang.String) r13, (int) r14)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            java.lang.String r13 = "unknown"
            android.content.pm.PackageManager r14 = r17.getPackageManager()     // Catch:{ NameNotFoundException -> 0x004b }
            android.content.pm.PackageInfo r14 = r14.getPackageInfo(r12, r6)     // Catch:{ NameNotFoundException -> 0x004b }
            int r15 = r14.versionCode     // Catch:{ NameNotFoundException -> 0x004b }
            java.lang.String r13 = java.lang.Integer.toString(r15)     // Catch:{ NameNotFoundException -> 0x004b }
            java.lang.String r15 = "av"
            java.lang.String r14 = r14.versionName     // Catch:{ NameNotFoundException -> 0x004b }
            r4.put((java.lang.String) r15, (java.lang.Object) r14)     // Catch:{ NameNotFoundException -> 0x004b }
        L_0x004b:
            java.lang.String r14 = "abn"
            r4.put((java.lang.String) r14, (java.lang.Object) r13)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            java.lang.String r14 = r11.getInstallerPackageName(r12)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            if (r14 == 0) goto L_0x005b
            java.lang.String r15 = "ain"
            r4.put((java.lang.String) r15, (java.lang.Object) r14)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
        L_0x005b:
            android.content.pm.ApplicationInfo r14 = r11.getApplicationInfo(r12, r6)     // Catch:{ NameNotFoundException -> 0x0068 }
            java.lang.String r15 = "an"
            java.lang.CharSequence r14 = r11.getApplicationLabel(r14)     // Catch:{ NameNotFoundException -> 0x0068 }
            r4.put((java.lang.String) r15, (java.lang.Object) r14)     // Catch:{ NameNotFoundException -> 0x0068 }
        L_0x0068:
            java.lang.String r14 = "bid"
            java.lang.String r13 = com.mparticle.internal.MPUtility.getBuildUUID(r13)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            r4.put((java.lang.String) r14, (java.lang.Object) r13)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            java.lang.String r13 = "dbg"
            boolean r14 = com.mparticle.internal.MPUtility.isAppDebuggable(r17)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            r4.put((java.lang.String) r13, (boolean) r14)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            java.lang.String r13 = "pir"
            java.lang.String r14 = "mp::pirated"
            boolean r14 = r5.getBoolean(r14, r6)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            r4.put((java.lang.String) r13, (boolean) r14)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            java.lang.String r13 = "ict"
            long r14 = r5.getLong(r3, r9)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            r4.put((java.lang.String) r13, (long) r14)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            boolean r13 = r5.contains(r3)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            if (r13 != 0) goto L_0x0097
            r8.putLong(r3, r9)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
        L_0x0097:
            com.mparticle.internal.p r3 = com.mparticle.internal.b.g((android.content.Context) r17)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            int r7 = r3.b((int) r6)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            r13 = 1
            int r7 = r7 + r13
            r3.f((int) r7)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            java.lang.String r14 = "lc"
            r4.put((java.lang.String) r14, (int) r7)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            r14 = 0
            long r14 = r3.b((long) r14)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            java.lang.String r7 = "lud"
            r4.put((java.lang.String) r7, (long) r14)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            r3.f((long) r9)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            android.content.pm.PackageInfo r7 = r11.getPackageInfo(r12, r6)     // Catch:{ NameNotFoundException -> 0x00e8 }
            r11 = -1
            int r11 = r5.getInt(r2, r11)     // Catch:{ NameNotFoundException -> 0x00e8 }
            int r12 = r3.k()     // Catch:{ NameNotFoundException -> 0x00e8 }
            long r14 = r5.getLong(r1, r9)     // Catch:{ NameNotFoundException -> 0x00e8 }
            if (r11 < 0) goto L_0x00d1
            int r6 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x00e8 }
            if (r11 == r6) goto L_0x00cf
            goto L_0x00d1
        L_0x00cf:
            r9 = r14
            goto L_0x00da
        L_0x00d1:
            int r6 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x00e8 }
            r8.putInt(r2, r6)     // Catch:{ NameNotFoundException -> 0x00e8 }
            r8.putLong(r1, r9)     // Catch:{ NameNotFoundException -> 0x00e8 }
            r12 = 0
        L_0x00da:
            int r12 = r12 + r13
            r3.e((int) r12)     // Catch:{ NameNotFoundException -> 0x00e8 }
            java.lang.String r1 = "lcu"
            r4.put((java.lang.String) r1, (int) r12)     // Catch:{ NameNotFoundException -> 0x00e8 }
            java.lang.String r1 = "ud"
            r4.put((java.lang.String) r1, (long) r9)     // Catch:{ NameNotFoundException -> 0x00e8 }
        L_0x00e8:
            com.mparticle.MParticle r1 = com.mparticle.MParticle.getInstance()     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            if (r1 == 0) goto L_0x0102
            java.lang.String r2 = "env"
            com.mparticle.MParticle$e r1 = r1.Internal()     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            r1.b()     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            com.mparticle.MParticle$Environment r1 = com.mparticle.internal.b.u()     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            int r1 = r1.getValue()     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            r4.put((java.lang.String) r2, (int) r1)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
        L_0x0102:
            java.lang.String r1 = "ir"
            java.lang.String r2 = "mp::install_referrer"
            r3 = 0
            java.lang.String r2 = r5.getString(r2, r3)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            r4.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            boolean r1 = r5.getBoolean(r0, r13)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            java.lang.String r2 = "fi"
            r4.put((java.lang.String) r2, (boolean) r1)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            r1 = 0
            r8.putBoolean(r0, r1)     // Catch:{ Exception -> 0x0124, all -> 0x011f }
            r8.apply()
            goto L_0x0127
        L_0x011f:
            r0 = move-exception
            r8.apply()
            throw r0
        L_0x0124:
            r8.apply()
        L_0x0127:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.internal.c.c(android.content.Context):org.json.b");
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return a.f22439b[this.f22437d.ordinal()] != 2 ? "Android" : "FireTV";
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00aa A[Catch:{ JSONException -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r8, org.json.b r9) {
        /*
            r7 = this;
            java.lang.String r0 = "lat"
            r9.remove(r0)
            java.lang.String r1 = "gaid"
            r9.remove(r1)
            com.mparticle.internal.MPUtility$AdIdInfo r8 = com.mparticle.internal.MPUtility.getAdIdInfo(r8)
            java.lang.String r2 = "Failed while building device-customAttributes object: "
            r3 = 2
            r4 = 0
            r5 = 1
            if (r8 == 0) goto L_0x007f
            boolean r6 = r8.isLimitAdTrackingEnabled     // Catch:{ JSONException -> 0x0071 }
            r9.put((java.lang.String) r0, (boolean) r6)     // Catch:{ JSONException -> 0x0071 }
            com.mparticle.MParticle r0 = com.mparticle.MParticle.getInstance()     // Catch:{ JSONException -> 0x0071 }
            if (r0 == 0) goto L_0x007f
            boolean r0 = r8.isLimitAdTrackingEnabled     // Catch:{ JSONException -> 0x0071 }
            if (r0 == 0) goto L_0x003a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0071 }
            r0.<init>()     // Catch:{ JSONException -> 0x0071 }
            com.mparticle.internal.MPUtility$AdIdInfo$Advertiser r8 = r8.advertiser     // Catch:{ JSONException -> 0x0071 }
            java.lang.String r8 = r8.descriptiveName     // Catch:{ JSONException -> 0x0071 }
            r0.append(r8)     // Catch:{ JSONException -> 0x0071 }
            java.lang.String r8 = " Advertising ID tracking is disabled on this device."
            r0.append(r8)     // Catch:{ JSONException -> 0x0071 }
            java.lang.String r8 = r0.toString()     // Catch:{ JSONException -> 0x0071 }
            goto L_0x0081
        L_0x003a:
            int[] r0 = com.mparticle.internal.c.a.f22438a     // Catch:{ JSONException -> 0x0071 }
            com.mparticle.internal.MPUtility$AdIdInfo$Advertiser r6 = r8.advertiser     // Catch:{ JSONException -> 0x0071 }
            int r6 = r6.ordinal()     // Catch:{ JSONException -> 0x0071 }
            r0 = r0[r6]     // Catch:{ JSONException -> 0x0071 }
            if (r0 == r5) goto L_0x004f
            if (r0 == r3) goto L_0x0049
            goto L_0x0056
        L_0x0049:
            java.lang.String r0 = r8.f22362id     // Catch:{ JSONException -> 0x0071 }
            r9.put((java.lang.String) r1, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x0071 }
            goto L_0x0056
        L_0x004f:
            java.lang.String r0 = "faid"
            java.lang.String r1 = r8.f22362id     // Catch:{ JSONException -> 0x0071 }
            r9.put((java.lang.String) r0, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x0071 }
        L_0x0056:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0071 }
            r0.<init>()     // Catch:{ JSONException -> 0x0071 }
            java.lang.String r1 = "Successfully collected "
            r0.append(r1)     // Catch:{ JSONException -> 0x0071 }
            com.mparticle.internal.MPUtility$AdIdInfo$Advertiser r8 = r8.advertiser     // Catch:{ JSONException -> 0x0071 }
            java.lang.String r8 = r8.descriptiveName     // Catch:{ JSONException -> 0x0071 }
            r0.append(r8)     // Catch:{ JSONException -> 0x0071 }
            java.lang.String r8 = " Advertising ID."
            r0.append(r8)     // Catch:{ JSONException -> 0x0071 }
            java.lang.String r8 = r0.toString()     // Catch:{ JSONException -> 0x0071 }
            goto L_0x0081
        L_0x0071:
            r8 = move-exception
            java.lang.String[] r0 = new java.lang.String[r3]
            r0[r4] = r2
            java.lang.String r8 = r8.toString()
            r0[r5] = r8
            com.mparticle.internal.Logger.debug(r0)
        L_0x007f:
            java.lang.String r8 = "Failed to collect Advertising ID, be sure to add Google Play services (com.google.android.gms:play-services-ads) or Amazon Ads (com.amazon.android:mobile-ads) to your app's dependencies."
        L_0x0081:
            boolean r0 = r7.f22436c
            if (r0 == 0) goto L_0x008e
            java.lang.String[] r0 = new java.lang.String[r5]
            r0[r4] = r8
            com.mparticle.internal.Logger.debug(r0)
            r7.f22436c = r4
        L_0x008e:
            com.mparticle.MParticle r8 = com.mparticle.MParticle.getInstance()     // Catch:{ JSONException -> 0x00b9 }
            if (r8 == 0) goto L_0x00c7
            com.mparticle.MParticle$e r8 = r8.Internal()     // Catch:{ JSONException -> 0x00b9 }
            com.mparticle.internal.b r8 = r8.b()     // Catch:{ JSONException -> 0x00b9 }
            com.mparticle.internal.PushRegistrationHelper$PushRegistration r8 = r8.M()     // Catch:{ JSONException -> 0x00b9 }
            if (r8 == 0) goto L_0x00c7
            java.lang.String r0 = r8.instanceId     // Catch:{ JSONException -> 0x00b9 }
            boolean r0 = com.mparticle.internal.MPUtility.isEmpty((java.lang.CharSequence) r0)     // Catch:{ JSONException -> 0x00b9 }
            if (r0 != 0) goto L_0x00c7
            java.lang.String r0 = "to"
            java.lang.String r8 = r8.instanceId     // Catch:{ JSONException -> 0x00b9 }
            r9.put((java.lang.String) r0, (java.lang.Object) r8)     // Catch:{ JSONException -> 0x00b9 }
            java.lang.String r8 = "tot"
            java.lang.String r0 = "google"
            r9.put((java.lang.String) r8, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x00b9 }
            goto L_0x00c7
        L_0x00b9:
            r8 = move-exception
            java.lang.String[] r9 = new java.lang.String[r3]
            r9[r4] = r2
            java.lang.String r8 = r8.toString()
            r9[r5] = r8
            com.mparticle.internal.Logger.debug(r9)
        L_0x00c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.internal.c.a(android.content.Context, org.json.b):void");
    }

    public b a(Context context) {
        return a(context, false);
    }

    /* access modifiers changed from: package-private */
    public b a(Context context, boolean z10) {
        b bVar = this.f22435b;
        if (bVar == null) {
            b c10 = c(context);
            this.f22435b = c10;
            b(context, c10);
        } else if (z10) {
            b(context, bVar);
        }
        return this.f22435b;
    }
}
