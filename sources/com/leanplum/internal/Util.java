package com.leanplum.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.TypedValue;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.leanplum.Leanplum;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.LeanplumDeviceIdMode;
import com.leanplum.internal.Constants;
import com.leanplum.monitoring.ExceptionHandler;
import com.leanplum.utils.SharedPreferencesUtil;
import com.mparticle.kits.AppsFlyerKit;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.UnsupportedCharsetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import net.bytebuddy.utility.JavaConstant;
import org.jivesoftware.smack.util.StringUtils;

public class Util {
    private static final String ACCESS_WIFI_STATE_PERMISSION = "android.permission.ACCESS_WIFI_STATE";
    private static String appName = null;
    private static boolean hasPlayServices = false;
    private static boolean hasPlayServicesCalled = false;
    private static String versionName;

    private static String capitalize(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        return Character.toUpperCase(charAt) + str.substring(1);
    }

    private static String checkDeviceId(String str, String str2) {
        if (str2 == null || isValidDeviceId(str2)) {
            return str2;
        }
        Log.e("Invalid device id generated (" + str + "): " + str2, new Object[0]);
        return null;
    }

    public static int generateIdFromResourceName(String str) {
        String[] split = str.split(RemoteSettings.FORWARD_SLASH_STRING);
        if (split.length == 2) {
            Resources resources = Leanplum.getContext().getResources();
            String str2 = split[0];
            String str3 = split[1];
            String[] split2 = str3.split("\\.(?=[^\\.]+$)");
            if (split2.length == 2) {
                str3 = split2[0];
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                return resources.getIdentifier(str3, str2, Leanplum.getContext().getPackageName());
            }
        }
        Log.d("Could not extract resource id from provided resource name: ", str);
        return 0;
    }

    private static String generateRandomDeviceId() {
        String str = UUID.randomUUID().toString() + "-LP";
        Log.d("Using generated device id: " + str, new Object[0]);
        return str;
    }

    public static String generateResourceNameFromId(int i10) {
        if (i10 <= 0) {
            try {
                Log.d("Provided resource id is invalid.", new Object[0]);
                return null;
            } catch (Exception e10) {
                Log.e("Failed to generate resource name from provided resource id: %s", e10.getMessage());
                Log.exception(e10);
                return null;
            }
        } else {
            Resources resources = Leanplum.getContext().getResources();
            String resourceEntryName = resources.getResourceEntryName(i10);
            String resourceTypeName = resources.getResourceTypeName(i10);
            TypedValue typedValue = new TypedValue();
            resources.getValue(i10, typedValue, true);
            String[] split = typedValue.string.toString().split("\\.(?=[^\\.]+$)");
            String str = "";
            if (split.length == 2) {
                str = "." + split[1];
            }
            return resourceTypeName + RemoteSettings.FORWARD_SLASH_STRING + resourceEntryName + str;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:14|15|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        com.leanplum.internal.Log.i("Couldn't get AdvertisingID using class: " + r5, new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x00a6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.leanplum.internal.Util.DeviceIdInfo getAdvertisingId(android.content.Context r12) {
        /*
            r0 = 0
            java.lang.String r1 = "androidx.ads.identifier.AdvertisingIdClient"
            java.lang.String r2 = "com.google.android.gms.ads.identifier.AdvertisingIdClient"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2}     // Catch:{ all -> 0x00c0 }
            r2 = 0
            r3 = r2
        L_0x000b:
            r4 = 2
            if (r3 >= r4) goto L_0x00c6
            r5 = r1[r3]     // Catch:{ all -> 0x00c0 }
            java.lang.Class r6 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x00a6 }
            java.lang.String r7 = "getAdvertisingIdInfo"
            r8 = 1
            java.lang.Class[] r9 = new java.lang.Class[r8]     // Catch:{ all -> 0x00a6 }
            java.lang.Class<android.content.Context> r10 = android.content.Context.class
            r9[r2] = r10     // Catch:{ all -> 0x00a6 }
            java.lang.reflect.Method r6 = r6.getMethod(r7, r9)     // Catch:{ all -> 0x00a6 }
            java.lang.Object[] r7 = new java.lang.Object[r8]     // Catch:{ all -> 0x00a6 }
            r7[r2] = r12     // Catch:{ all -> 0x00a6 }
            java.lang.Object r6 = r6.invoke(r0, r7)     // Catch:{ all -> 0x00a6 }
            r7 = r1[r2]     // Catch:{ all -> 0x00a6 }
            boolean r7 = r5.equals(r7)     // Catch:{ all -> 0x00a6 }
            if (r7 == 0) goto L_0x0056
            java.lang.Class r7 = r6.getClass()     // Catch:{ all -> 0x00a6 }
            java.lang.String r9 = "get"
            java.lang.Class[] r10 = new java.lang.Class[r4]     // Catch:{ all -> 0x00a6 }
            java.lang.Class r11 = java.lang.Long.TYPE     // Catch:{ all -> 0x00a6 }
            r10[r2] = r11     // Catch:{ all -> 0x00a6 }
            java.lang.Class<java.util.concurrent.TimeUnit> r11 = java.util.concurrent.TimeUnit.class
            r10[r8] = r11     // Catch:{ all -> 0x00a6 }
            java.lang.reflect.Method r7 = r7.getMethod(r9, r10)     // Catch:{ all -> 0x00a6 }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00a6 }
            r9 = 5
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x00a6 }
            r4[r2] = r9     // Catch:{ all -> 0x00a6 }
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ all -> 0x00a6 }
            r4[r8] = r9     // Catch:{ all -> 0x00a6 }
            java.lang.Object r6 = r7.invoke(r6, r4)     // Catch:{ all -> 0x00a6 }
        L_0x0056:
            java.lang.String r4 = "advertising id"
            java.lang.Class r7 = r6.getClass()     // Catch:{ all -> 0x00a6 }
            java.lang.String r8 = "getId"
            java.lang.Class[] r9 = new java.lang.Class[r2]     // Catch:{ all -> 0x00a6 }
            java.lang.reflect.Method r7 = r7.getMethod(r8, r9)     // Catch:{ all -> 0x00a6 }
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ all -> 0x00a6 }
            java.lang.Object r7 = r7.invoke(r6, r8)     // Catch:{ all -> 0x00a6 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x00a6 }
            java.lang.String r4 = checkDeviceId(r4, r7)     // Catch:{ all -> 0x00a6 }
            if (r4 == 0) goto L_0x00bc
            java.lang.Class r7 = r6.getClass()     // Catch:{ all -> 0x00a6 }
            java.lang.String r8 = "isLimitAdTrackingEnabled"
            java.lang.Class[] r9 = new java.lang.Class[r2]     // Catch:{ all -> 0x00a6 }
            java.lang.reflect.Method r7 = r7.getMethod(r8, r9)     // Catch:{ all -> 0x00a6 }
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ all -> 0x00a6 }
            java.lang.Object r6 = r7.invoke(r6, r8)     // Catch:{ all -> 0x00a6 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x00a6 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x00a6 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r7.<init>()     // Catch:{ all -> 0x00a6 }
            java.lang.String r8 = "Using advertising device id: "
            r7.append(r8)     // Catch:{ all -> 0x00a6 }
            r7.append(r4)     // Catch:{ all -> 0x00a6 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00a6 }
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ all -> 0x00a6 }
            com.leanplum.internal.Log.d(r7, r8)     // Catch:{ all -> 0x00a6 }
            com.leanplum.internal.Util$DeviceIdInfo r7 = new com.leanplum.internal.Util$DeviceIdInfo     // Catch:{ all -> 0x00a6 }
            r7.<init>(r4, r6)     // Catch:{ all -> 0x00a6 }
            return r7
        L_0x00a6:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c0 }
            r4.<init>()     // Catch:{ all -> 0x00c0 }
            java.lang.String r6 = "Couldn't get AdvertisingID using class: "
            r4.append(r6)     // Catch:{ all -> 0x00c0 }
            r4.append(r5)     // Catch:{ all -> 0x00c0 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00c0 }
            java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ all -> 0x00c0 }
            com.leanplum.internal.Log.i(r4, r5)     // Catch:{ all -> 0x00c0 }
        L_0x00bc:
            int r3 = r3 + 1
            goto L_0x000b
        L_0x00c0:
            r12 = move-exception
            java.lang.String r1 = "Error getting advertising ID. Google Play Services are not available: "
            com.leanplum.internal.Log.e((java.lang.String) r1, (java.lang.Throwable) r12)
        L_0x00c6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.leanplum.internal.Util.getAdvertisingId(android.content.Context):com.leanplum.internal.Util$DeviceIdInfo");
    }

    private static String getAndroidId(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (string == null || string.isEmpty()) {
            Log.d("Skipping Android device id; no id returned.", new Object[0]);
            return null;
        } else if ("9774d56d682e549c".equals(string)) {
            Log.d("Skipping Android device id; got invalid device id: " + string, new Object[0]);
            return null;
        } else {
            Log.d("Using Android device id: " + string, new Object[0]);
            return checkDeviceId("android id", string);
        }
    }

    public static String getApplicationName(Context context) {
        String str = appName;
        if (str != null) {
            return str;
        }
        int i10 = context.getApplicationInfo().labelRes;
        if (i10 == 0) {
            appName = context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
        } else {
            appName = context.getString(i10);
        }
        return appName;
    }

    public static DeviceIdInfo getDeviceId(LeanplumDeviceIdMode leanplumDeviceIdMode) {
        Context context = Leanplum.getContext();
        if (leanplumDeviceIdMode.equals(LeanplumDeviceIdMode.ADVERTISING_ID)) {
            try {
                DeviceIdInfo advertisingId = getAdvertisingId(context);
                if (advertisingId != null) {
                    return advertisingId;
                }
            } catch (Exception e10) {
                Log.e("Error getting advertising ID: %s", (Throwable) e10);
            }
        }
        if ((isSimulator() || leanplumDeviceIdMode.equals(LeanplumDeviceIdMode.ANDROID_ID)) && getAndroidId(context) != null) {
            return new DeviceIdInfo(getAndroidId(context));
        }
        String wifiMacAddressHash = getWifiMacAddressHash(context);
        if (wifiMacAddressHash != null) {
            return new DeviceIdInfo(wifiMacAddressHash);
        }
        String androidId = getAndroidId(context);
        if (androidId != null) {
            return new DeviceIdInfo(androidId);
        }
        return new DeviceIdInfo(generateRandomDeviceId());
    }

    public static String getDeviceModel() {
        if (isSimulator()) {
            return "Android Emulator";
        }
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return capitalize(str2);
        }
        return capitalize(str) + " " + str2;
    }

    public static String getDeviceName() {
        if (isSimulator()) {
            return "Android Emulator";
        }
        return getDeviceModel();
    }

    public static String getLocale() {
        String language = Locale.getDefault().getLanguage();
        if ("".equals(language)) {
            language = "xx";
        }
        String country = Locale.getDefault().getCountry();
        if ("".equals(country)) {
            country = "XX";
        }
        return language + JavaConstant.Dynamic.DEFAULT_NAME + country;
    }

    public static String getSystemName() {
        return "Android OS";
    }

    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getVersionName() {
        String str = versionName;
        if (str != null) {
            return str;
        }
        Context context = Leanplum.getContext();
        try {
            if (TextUtils.isEmpty(versionName)) {
                versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            }
        } catch (Exception unused) {
            Log.d("Could not extract versionName from Manifest or PackageInfo.", new Object[0]);
        }
        return versionName;
    }

    private static String getWifiMacAddressHash(Context context) {
        if (context.checkCallingOrSelfPermission(ACCESS_WIFI_STATE_PERMISSION) != 0) {
            Log.d("Skipping wifi device id; " + "no wifi state permissions.", new Object[0]);
            return null;
        }
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo == null) {
                Log.d("Skipping wifi device id; " + "null WifiInfo.", new Object[0]);
                return null;
            }
            String macAddress = connectionInfo.getMacAddress();
            if (macAddress != null) {
                if (!macAddress.isEmpty()) {
                    if ("02:00:00:00:00:00".equals(macAddress)) {
                        Log.d("Skipping wifi device id; " + "Marshmallow and later returns a fake MAC address.", new Object[0]);
                        return null;
                    }
                    String md5 = md5(connectionInfo.getMacAddress());
                    Log.d("Using wifi device id: " + md5, new Object[0]);
                    return checkDeviceId("mac address", md5);
                }
            }
            Log.d("Skipping wifi device id; " + "no mac address returned.", new Object[0]);
            return null;
        } catch (Exception unused) {
            Log.d("Error getting wifi MAC address.", new Object[0]);
            return null;
        }
    }

    public static boolean hasPlayServices() {
        if (hasPlayServicesCalled) {
            return hasPlayServices;
        }
        PackageManager packageManager = Leanplum.getContext().getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
            if (packageInfo.versionCode < 4242000) {
                Log.i("Google Play services version is too old: " + packageInfo.versionCode, new Object[0]);
                hasPlayServicesCalled = true;
                hasPlayServices = false;
                return false;
            }
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                hasPlayServicesCalled = true;
                boolean z10 = applicationInfo.enabled;
                hasPlayServices = z10;
                return z10;
            } catch (PackageManager.NameNotFoundException unused) {
                hasPlayServicesCalled = true;
                hasPlayServices = false;
                return false;
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            hasPlayServicesCalled = true;
            hasPlayServices = false;
            return false;
        }
    }

    public static void initExceptionHandling(Context context) {
        ExceptionHandler.getInstance().setContext(context);
    }

    public static void initializePreLeanplumInstall(Map<String, Object> map) {
        Context context = Leanplum.getContext();
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.Defaults.LEANPLUM, 0);
        if (!sharedPreferences.getBoolean(Constants.Keys.INSTALL_TIME_INITIALIZED, false)) {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            setInstallTime(map, packageManager, packageName);
            setUpdateTime(map, packageManager, packageName);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(Constants.Keys.INSTALL_TIME_INITIALIZED, true);
            SharedPreferencesUtil.commitChanges(edit);
        }
    }

    public static boolean isConnected() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) Leanplum.getContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                return false;
            }
            return true;
        } catch (Exception e10) {
            Log.d("Error getting connectivity info", e10);
            return false;
        }
    }

    public static boolean isHuaweiServicesAvailable(Context context) {
        try {
            Class<?> cls = Class.forName("com.huawei.hms.api.HuaweiApiAvailability");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
            if (((Integer) cls.getMethod("isHuaweiMobileServicesAvailable", new Class[]{Context.class}).invoke(invoke, new Object[]{context})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isInBackground() {
        if (LeanplumActivityHelper.getCurrentActivity() == null || LeanplumActivityHelper.isActivityPaused()) {
            return true;
        }
        return false;
    }

    public static boolean isMainThread() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static boolean isSimulator() {
        String lowerCase = Build.MODEL.toLowerCase(Locale.getDefault());
        if (lowerCase.contains("google_sdk") || lowerCase.contains("emulator") || lowerCase.contains("sdk")) {
            return true;
        }
        return false;
    }

    public static boolean isValidDeviceId(String str) {
        if (str == null || str.isEmpty() || "9774d56d682e549c".equals(str) || "0f607264fc6318a92b9e13c65db7cd3c".equals(str) || "f607264fc6318a92b9e13c65db7cd3c".equals(str) || "00000000-0000-0000-0000-000000000000".equals(str)) {
            Log.d("Invalid device id " + "(sentinel): " + str, new Object[0]);
            return false;
        } else if (str.length() > 400) {
            Log.d("Invalid device id " + "(too long): " + str, new Object[0]);
            return false;
        } else if (str.contains("[")) {
            Log.d("Invalid device id " + "(contains brackets): " + str, new Object[0]);
            return false;
        } else if (str.contains("\n")) {
            Log.d("Invalid device id " + "(contains newline): " + str, new Object[0]);
            return false;
        } else if (str.contains(AppsFlyerKit.COMMA)) {
            Log.d("Invalid device id " + "(contains comma): " + str, new Object[0]);
            return false;
        } else if (!str.contains("\"") && !str.contains("'")) {
            return isValidForCharset(str, StringUtils.USASCII);
        } else {
            Log.d("Invalid device id " + "(contains quotes): " + str, new Object[0]);
            return false;
        }
    }

    private static boolean isValidForCharset(String str, String str2) {
        CharsetEncoder charsetEncoder;
        try {
            charsetEncoder = Charset.forName(str2).newEncoder();
        } catch (UnsupportedCharsetException unused) {
            Log.d("Unsupported charset: " + str2, new Object[0]);
            charsetEncoder = null;
        }
        if (charsetEncoder == null || charsetEncoder.canEncode(str)) {
            return true;
        }
        Log.d("Invalid id (contains invalid characters): " + str, new Object[0]);
        return false;
    }

    public static boolean isValidUserId(String str) {
        if (str == null || str.isEmpty()) {
            Log.d("Invalid user id " + "(sentinel): " + str, new Object[0]);
            return false;
        } else if ("00000000-0000-0000-0000-000000000000".equals(str)) {
            Log.d("Invalid user id " + "(zero uuid): " + str, new Object[0]);
            return false;
        } else if (str.length() > 400) {
            Log.d("Invalid user id " + "(too long): " + str, new Object[0]);
            return false;
        } else if (str.contains("\n")) {
            Log.d("Invalid user id " + "(contains newline): " + str, new Object[0]);
            return false;
        } else if (!str.contains("\"") && !str.contains("'")) {
            return isValidForCharset(str, "UTF-8");
        } else {
            Log.d("Invalid user id " + "(contains quotes): " + str, new Object[0]);
            return false;
        }
    }

    public static boolean isXiaomiDevice() {
        String str = Build.MANUFACTURER;
        return str != null && str.toLowerCase().contains("xiaomi");
    }

    private static String md5(String str) throws Exception {
        MessageDigest instance = MessageDigest.getInstance(StringUtils.MD5);
        instance.update(str.getBytes(Charset.forName("UTF-8")));
        byte[] digest = instance.digest();
        StringBuilder sb2 = new StringBuilder();
        int length = digest.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append(String.format("%02x", new Object[]{Byte.valueOf(digest[i10])}));
        }
        return sb2.toString();
    }

    public static <T> T multiIndex(Map<?, ?> map, Object... objArr) {
        if (map == null) {
            return null;
        }
        int length = objArr.length;
        int i10 = 0;
        Object obj = map;
        while (i10 < length) {
            Object obj2 = objArr[i10];
            Map map2 = (Map) obj;
            if (!map2.containsKey(obj2)) {
                return null;
            }
            i10++;
            obj = map2.get(obj2);
        }
        return CollectionUtil.uncheckedCast(obj);
    }

    public static <K, V> Map<K, V> newMap(K k10, V v10, Object... objArr) {
        if (objArr.length % 2 != 1) {
            HashMap hashMap = new HashMap();
            hashMap.put(k10, v10);
            for (int i10 = 0; i10 < objArr.length; i10 += 2) {
                hashMap.put(CollectionUtil.uncheckedCast(objArr[i10]), CollectionUtil.uncheckedCast(objArr[i10 + 1]));
            }
            return hashMap;
        }
        throw new IllegalArgumentException("Must supply an even number of values.");
    }

    private static void setInstallTime(Map<String, Object> map, PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            map.put(Constants.Params.INSTALL_DATE, "" + (((double) packageInfo.firstInstallTime) / 1000.0d));
        } catch (PackageManager.NameNotFoundException e10) {
            Log.d("Failed to find package info: " + e10, new Object[0]);
        }
    }

    private static void setUpdateTime(Map<String, Object> map, PackageManager packageManager, String str) {
        try {
            File file = new File(packageManager.getApplicationInfo(str, 0).sourceDir);
            if (file.exists()) {
                map.put(Constants.Params.UPDATE_DATE, "" + (((double) file.lastModified()) / 1000.0d));
            }
        } catch (Throwable th2) {
            Log.d("Failed to find package info: " + th2, new Object[0]);
        }
    }

    public static String sha256(String str) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance("SHA256");
        instance.update(str.getBytes(Charset.forName("UTF-8")));
        byte[] digest = instance.digest();
        StringBuilder sb2 = new StringBuilder();
        int length = digest.length;
        for (int i10 = 0; i10 < length; i10++) {
            sb2.append(String.format("%02x", new Object[]{Byte.valueOf(digest[i10])}));
        }
        return sb2.toString();
    }

    public static class DeviceIdInfo {

        /* renamed from: id  reason: collision with root package name */
        public final String f22204id;
        public boolean limitAdTracking;

        public DeviceIdInfo(String str) {
            this.f22204id = str;
        }

        public DeviceIdInfo(String str, boolean z10) {
            this.f22204id = str;
            this.limitAdTracking = z10;
        }
    }
}
