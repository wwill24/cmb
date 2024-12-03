package siftscience.android;

import android.content.Context;
import android.content.pm.PackageManager;
import com.mparticle.kits.AppsFlyerKit;
import com.sift.api.representations.AndroidDevicePropertiesJson;
import com.sift.api.representations.MobileEventJson;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DevicePropertiesCollector {
    private static final Map<String, String> DANGEROUS_PROPERTIES = new HashMap<String, String>() {
        {
            put("[ro.debuggable]", "[1]");
            put("[ro.secure]", "[0]");
        }
    };
    private static final String[] KNOWN_DANGEROUS_APPS_PACKAGES = {"com.koushikdutta.rommanager", "com.dimonvideo.luckypatcher", "com.chelpus.lackypatch", "com.ramdroid.appquarantine"};
    private static final String[] KNOWN_ROOT_APPS_PACKAGES = {"com.noshufou.android.su", "com.noshufou.android.su.elite", "eu.chainfire.supersu", "com.koushikdutta.superuser", "com.thirdparty.superuser", "com.yellowes.su"};
    private static final String[] KNOWN_ROOT_CLOAKING_PACKAGES = {"com.devadvance.rootcloak", "de.robv.android.xposed.installer", "com.saurik.substrate", "com.devadvance.rootcloakplus", "com.zachspong.temprootremovejb", "com.amphoras.hidemyroot", "com.formyhm.hideroot"};
    private static final String[] PATHS_THAT_SHOULD_NOT_BE_WRITABLE = {"/system", "/system/bin", "/system/sbin", "/system/xbin", "/vendor/bin", "/sbin", "/etc"};
    private static final String[] SU_PATHS = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
    private static final String TAG = "siftscience.android.DevicePropertiesCollector";
    private final Context context;
    private final SiftImpl sift;

    public DevicePropertiesCollector(SiftImpl siftImpl, Context context2) {
        this.sift = siftImpl;
        this.context = context2.getApplicationContext();
    }

    private List<String> existingDangerousProperties() {
        String[] propertiesReader = propertiesReader();
        ArrayList arrayList = new ArrayList();
        for (String str : propertiesReader) {
            for (String next : DANGEROUS_PROPERTIES.keySet()) {
                if (str.contains(next) && str.contains(DANGEROUS_PROPERTIES.get(next))) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    private List<String> existingRWPaths() {
        String[] mountReader = mountReader();
        ArrayList arrayList = new ArrayList();
        for (String str : mountReader) {
            String[] split = str.split(" ");
            if (split.length < 4) {
                String.format("Error formatting mount: %s", new Object[]{str});
            } else {
                String str2 = split[1];
                String str3 = split[3];
                for (String str4 : PATHS_THAT_SHOULD_NOT_BE_WRITABLE) {
                    if (str2.equalsIgnoreCase(str4)) {
                        String[] split2 = str3.split(AppsFlyerKit.COMMA);
                        int length = split2.length;
                        int i10 = 0;
                        while (true) {
                            if (i10 >= length) {
                                break;
                            } else if (split2[i10].equalsIgnoreCase("rw")) {
                                arrayList.add(str4);
                                break;
                            } else {
                                i10++;
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private List<String> existingRootFiles() {
        ArrayList arrayList = new ArrayList();
        for (String str : SU_PATHS) {
            if (new File(str).exists()) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private List<String> existingRootPackages() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(KNOWN_ROOT_APPS_PACKAGES));
        arrayList.addAll(Arrays.asList(KNOWN_DANGEROUS_APPS_PACKAGES));
        arrayList.addAll(Arrays.asList(KNOWN_ROOT_CLOAKING_PACKAGES));
        PackageManager packageManager = this.context.getPackageManager();
        ArrayList arrayList2 = new ArrayList();
        if (packageManager != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                try {
                    packageManager.getPackageInfo(str, 0);
                    arrayList2.add(str);
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
        }
        return arrayList2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0046  */
    @android.annotation.SuppressLint({"HardwareIds"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.sift.api.representations.AndroidDevicePropertiesJson get() {
        /*
            r11 = this;
            android.content.Context r0 = r11.context
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x0017
            android.content.Context r3 = r11.context     // Catch:{ NameNotFoundException -> 0x0015 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ NameNotFoundException -> 0x0015 }
            android.content.pm.ApplicationInfo r3 = r0.getApplicationInfo(r3, r1)     // Catch:{ NameNotFoundException -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r3 = r2
            goto L_0x0031
        L_0x0017:
            r3 = r2
        L_0x0018:
            if (r0 == 0) goto L_0x0021
            java.lang.CharSequence r3 = r0.getApplicationLabel(r3)     // Catch:{ NameNotFoundException -> 0x0015 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ NameNotFoundException -> 0x0015 }
            goto L_0x0022
        L_0x0021:
            r3 = r2
        L_0x0022:
            if (r0 == 0) goto L_0x0031
            android.content.Context r4 = r11.context     // Catch:{ NameNotFoundException -> 0x0031 }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ NameNotFoundException -> 0x0031 }
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r4, r1)     // Catch:{ NameNotFoundException -> 0x0031 }
            java.lang.String r0 = r0.versionName     // Catch:{ NameNotFoundException -> 0x0031 }
            goto L_0x0032
        L_0x0031:
            r0 = r2
        L_0x0032:
            android.content.Context r1 = r11.context
            java.lang.String r4 = "phone"
            java.lang.Object r1 = r1.getSystemService(r4)
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1
            if (r1 == 0) goto L_0x0043
            java.lang.String r4 = r1.getNetworkOperatorName()
            goto L_0x0044
        L_0x0043:
            r4 = r2
        L_0x0044:
            if (r1 == 0) goto L_0x004a
            java.lang.String r2 = r1.getSimCountryIso()
        L_0x004a:
            android.content.Context r1 = r11.context
            android.content.ContentResolver r1 = r1.getContentResolver()
            java.lang.String r5 = "android_id"
            java.lang.String r1 = android.provider.Settings.Secure.getString(r1, r5)
            java.lang.String r5 = android.os.Build.VERSION.RELEASE
            java.util.List r6 = r11.existingRootFiles()
            java.util.List r7 = r11.existingRootPackages()
            java.util.List r8 = r11.existingDangerousProperties()
            java.util.List r9 = r11.existingRWPaths()
            com.sift.api.representations.AndroidDevicePropertiesJson r10 = new com.sift.api.representations.AndroidDevicePropertiesJson
            r10.<init>()
            com.sift.api.representations.AndroidDevicePropertiesJson r3 = r10.withAppName(r3)
            com.sift.api.representations.AndroidDevicePropertiesJson r0 = r3.withAppVersion(r0)
            java.lang.String r3 = "1.3.0"
            com.sift.api.representations.AndroidDevicePropertiesJson r0 = r0.withSdkVersion(r3)
            com.sift.api.representations.AndroidDevicePropertiesJson r0 = r0.withAndroidId(r1)
            java.lang.String r1 = android.os.Build.MANUFACTURER
            com.sift.api.representations.AndroidDevicePropertiesJson r0 = r0.withDeviceManufacturer(r1)
            java.lang.String r1 = android.os.Build.MODEL
            com.sift.api.representations.AndroidDevicePropertiesJson r0 = r0.withDeviceModel(r1)
            com.sift.api.representations.AndroidDevicePropertiesJson r0 = r0.withMobileCarrierName(r4)
            com.sift.api.representations.AndroidDevicePropertiesJson r0 = r0.withMobileIsoCountryCode(r2)
            com.sift.api.representations.AndroidDevicePropertiesJson r0 = r0.withDeviceSystemVersion(r5)
            java.lang.String r1 = android.os.Build.TAGS
            com.sift.api.representations.AndroidDevicePropertiesJson r0 = r0.withBuildTags(r1)
            com.sift.api.representations.AndroidDevicePropertiesJson r0 = r0.withEvidenceFilesPresent(r6)
            com.sift.api.representations.AndroidDevicePropertiesJson r0 = r0.withEvidencePackagesPresent(r7)
            com.sift.api.representations.AndroidDevicePropertiesJson r0 = r0.withEvidenceProperties(r8)
            com.sift.api.representations.AndroidDevicePropertiesJson r0 = r0.withEvidenceDirectoriesWritable(r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: siftscience.android.DevicePropertiesCollector.get():com.sift.api.representations.AndroidDevicePropertiesJson");
    }

    private String[] mountReader() {
        InputStream inputStream;
        String str;
        try {
            inputStream = Runtime.getRuntime().exec("mount").getInputStream();
        } catch (IOException unused) {
            inputStream = null;
        }
        if (inputStream == null) {
            return new String[0];
        }
        try {
            str = new Scanner(inputStream).useDelimiter("\\A").next();
        } catch (NoSuchElementException unused2) {
            str = "";
        }
        return str.split("\n");
    }

    private String[] propertiesReader() {
        InputStream inputStream;
        String str;
        try {
            inputStream = Runtime.getRuntime().exec("getprop").getInputStream();
        } catch (IOException unused) {
            inputStream = null;
        }
        if (inputStream == null) {
            return new String[0];
        }
        try {
            str = new Scanner(inputStream).useDelimiter("\\A").next();
        } catch (NoSuchElementException unused2) {
            str = "";
        }
        return str.split("\n");
    }

    public void collect() {
        AndroidDevicePropertiesJson androidDevicePropertiesJson = get();
        this.sift.appendDevicePropertiesEvent(new MobileEventJson().withAndroidDeviceProperties(androidDevicePropertiesJson).withInstallationId(androidDevicePropertiesJson.androidId).withTime(Long.valueOf(Time.now())));
    }
}
