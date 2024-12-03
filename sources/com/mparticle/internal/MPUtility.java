package com.mparticle.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.instantapps.InstantApps;
import com.google.firebase.messaging.FirebaseMessaging;
import com.mparticle.MParticle;
import com.mparticle.m;
import com.mparticle.u;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.a;
import org.json.b;

public class MPUtility {
    private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();
    static final String NO_BLUETOOTH = "none";
    private static final String TAG = MPUtility.class.toString();
    private static String sOpenUDID;

    public static class AdIdInfo {
        public final Advertiser advertiser;

        /* renamed from: id  reason: collision with root package name */
        public final String f22362id;
        public final boolean isLimitAdTrackingEnabled;

        public enum Advertiser {
            AMAZON("Amazon"),
            GOOGLE("Google Play Store");
            
            public String descriptiveName;

            private Advertiser(String str) {
                this.descriptiveName = str;
            }
        }

        public AdIdInfo(String str, boolean z10, Advertiser advertiser2) {
            this.f22362id = str;
            this.isLimitAdTrackingEnabled = z10;
            this.advertiser = advertiser2;
        }
    }

    private interface SyncRunnable<T> {
        T run();
    }

    public static Number addNumbers(Number number, Number number2) {
        if ((number instanceof Double) || (number2 instanceof Double)) {
            return Double.valueOf(number.doubleValue() + number2.doubleValue());
        }
        if ((number instanceof Float) || (number2 instanceof Float)) {
            return Float.valueOf(number.floatValue() + number2.floatValue());
        }
        if ((number instanceof Long) || (number2 instanceof Long)) {
            return Long.valueOf(number.longValue() + number2.longValue());
        }
        return Integer.valueOf(number.intValue() + number2.intValue());
    }

    private static String asHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int i11 = i10 * 2;
            char[] cArr2 = HEX_CHARS;
            byte b10 = bArr[i10];
            cArr[i11] = cArr2[(b10 & 240) >>> 4];
            cArr[i11 + 1] = cArr2[b10 & 15];
        }
        return new String(cArr);
    }

    public static boolean checkPermission(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static boolean containsNullKey(Map map) {
        try {
            return map.containsKey((Object) null);
        } catch (RuntimeException unused) {
            Iterator it = new ArrayList(map.entrySet()).iterator();
            while (it.hasNext()) {
                if (((Map.Entry) it.next()).getKey() == null) {
                    return true;
                }
            }
            return false;
        }
    }

    public static b enforceAttributeConstraints(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        b bVar = new b();
        for (Map.Entry next : map.entrySet()) {
            setCheckedAttribute(bVar, (String) next.getKey(), (String) next.getValue(), false, false);
        }
        return bVar;
    }

    public static String findCaseInsensitiveKey(b bVar, String str) {
        Iterator<String> keys = bVar.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next.equalsIgnoreCase(str)) {
                return next;
            }
        }
        return str;
    }

    public static AdIdInfo getAdIdInfo(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        if ((installerPackageName == null || !installerPackageName.contains("com.amazon.venezia")) && !"Amazon".equals(Build.MANUFACTURER)) {
            AdIdInfo googleAdIdInfo = getGoogleAdIdInfo(context);
            if (googleAdIdInfo == null) {
                return getAmazonAdIdInfo(context);
            }
            return googleAdIdInfo;
        }
        AdIdInfo amazonAdIdInfo = getAmazonAdIdInfo(context);
        if (amazonAdIdInfo == null) {
            return getGoogleAdIdInfo(context);
        }
        return amazonAdIdInfo;
    }

    private static AdIdInfo getAmazonAdIdInfo(Context context) {
        boolean z10;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (Settings.Secure.getInt(contentResolver, "limit_ad_tracking", 0) == 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            String string = Settings.Secure.getString(contentResolver, "advertising_id");
            if (string != null) {
                return new AdIdInfo(string, z10, AdIdInfo.Advertiser.AMAZON);
            }
            return null;
        } catch (Exception e10) {
            Logger.info(TAG, "Could not locate Amazon ID on device: " + e10.getMessage());
            return null;
        }
    }

    @TargetApi(3)
    public static String getAndroidID(Context context) {
        if (MParticle.isAndroidIdEnabled()) {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
        return null;
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "unknown";
        }
    }

    public static long getAvailableExternalDisk(Context context) {
        File externalFilesDir = context.getExternalFilesDir((String) null);
        if (externalFilesDir == null) {
            return 0;
        }
        return getDiskSpace(context, externalFilesDir);
    }

    public static long getAvailableInternalDisk(Context context) {
        return getDiskSpace(context, Environment.getDataDirectory());
    }

    public static long getAvailableMemory(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static String getBluetoothVersion(Context context) {
        if (context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return "ble";
        }
        if (context.getPackageManager().hasSystemFeature("android.hardware.bluetooth")) {
            return "classic";
        }
        return "none";
    }

    static String getBuildUUID(String str) {
        if (str == null) {
            str = "unknown";
        }
        try {
            return UUID.nameUUIDFromBytes(str.getBytes()).toString();
        } catch (AssertionError unused) {
            return "unknown";
        }
    }

    public static long getDiskSpace(Context context, File file) {
        if (isInstantApp(context)) {
            return 0;
        }
        StatFs statFs = new StatFs(file.getPath());
        long a10 = m.a(statFs);
        if (a10 == 0) {
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        }
        return a10;
    }

    public static String getErrorMessage(HttpURLConnection httpURLConnection) {
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb2.append(readLine + 10);
                } else {
                    bufferedReader.close();
                    return sb2.toString();
                }
            } catch (Exception e10) {
                return e10.getMessage();
            }
        }
    }

    static String getGeneratedUdid() {
        return new BigInteger(64, new SecureRandom()).toString(16);
    }

    private static AdIdInfo getGoogleAdIdInfo(Context context) {
        try {
            Object invoke = AdvertisingIdClient.class.getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
            return new AdIdInfo((String) invoke.getClass().getMethod("getId", new Class[0]).invoke(invoke, new Object[0]), ((Boolean) invoke.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(invoke, new Object[0])).booleanValue(), AdIdInfo.Advertiser.GOOGLE);
        } catch (Exception unused) {
            Logger.info(TAG, "Could not locate Google Play Ads Identifier library");
            return null;
        }
    }

    public static String getGpsEnabled(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
            return Boolean.toString(((LocationManager) context.getSystemService("location")).isProviderEnabled("gps"));
        }
        return null;
    }

    public static b getJsonResponse(u uVar) {
        try {
            return getJsonResponse(uVar.c());
        } catch (IOException unused) {
            return getJsonResponse(uVar.a());
        }
    }

    @SuppressLint({"MissingPermission"})
    public static Integer getNetworkType(Context context, TelephonyManager telephonyManager) {
        if (telephonyManager == null || !checkPermission(context, "android.permission.READ_PHONE_STATE")) {
            return null;
        }
        return Integer.valueOf(telephonyManager.getNetworkType());
    }

    public static String getOpenUDID(Context context) {
        if (sOpenUDID == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("mParticlePrefs", 0);
            String string = sharedPreferences.getString("mp::openudid", (String) null);
            sOpenUDID = string;
            if (string == null) {
                String androidID = getAndroidID(context);
                sOpenUDID = androidID;
                if (androidID == null) {
                    sOpenUDID = getGeneratedUdid();
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("mp::openudid", sOpenUDID);
                edit.apply();
            }
        }
        return sOpenUDID;
    }

    public static int getOrientation(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() == defaultDisplay.getHeight()) {
            return 3;
        }
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            return 1;
        }
        return 2;
    }

    public static String getProp(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str}).toString();
        } catch (ClassNotFoundException e10) {
            e10.printStackTrace();
            return null;
        } catch (NoSuchMethodException e11) {
            e11.printStackTrace();
            return null;
        } catch (IllegalAccessException e12) {
            e12.printStackTrace();
            return null;
        } catch (InvocationTargetException e13) {
            e13.printStackTrace();
            return null;
        }
    }

    public static String getRampUdid(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mParticlePrefs", 0);
        String string = sharedPreferences.getString("mp::rampudid", (String) null);
        if (string != null) {
            return string;
        }
        String generatedUdid = getGeneratedUdid();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("mp::rampudid", generatedUdid);
        edit.apply();
        return generatedUdid;
    }

    public static long getRemainingHeapInBytes() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory());
    }

    public static long getSystemMemoryThreshold(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.threshold;
    }

    public static String getTimeZone() {
        try {
            return TimeZone.getDefault().getDisplayName(false, 0);
        } catch (AssertionError | Exception unused) {
            return null;
        }
    }

    public static long getTotalMemory(Context context) {
        return getTotalMemoryJB(context);
    }

    @TargetApi(16)
    public static long getTotalMemoryJB(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    public static long getTotalMemoryPreJB() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            long intValue = (long) (Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() * 1024);
            bufferedReader.close();
            return intValue;
        } catch (IOException unused) {
            return -1;
        }
    }

    public static boolean hasNfc(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.nfc");
    }

    public static boolean hasTelephony(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.telephony");
    }

    public static BigInteger hashFnv1A(byte[] bArr) {
        BigInteger bigInteger = new BigInteger("cbf29ce484222325", 16);
        BigInteger bigInteger2 = new BigInteger("100000001b3", 16);
        BigInteger pow = new BigInteger("2").pow(64);
        for (byte b10 : bArr) {
            bigInteger = bigInteger.xor(BigInteger.valueOf((long) (b10 & 255))).multiply(bigInteger2).mod(pow);
        }
        return bigInteger;
    }

    public static String hmacSha256Encode(String str, String str2) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Mac instance = Mac.getInstance("HmacSHA256");
        instance.init(new SecretKeySpec(str.getBytes("utf-8"), "HmacSHA256"));
        return asHex(instance.doFinal(str2.getBytes("utf-8")));
    }

    public static boolean isAppDebuggable(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isBluetoothEnabled(Context context) {
        BluetoothAdapter defaultAdapter;
        if (!checkPermission(context, "android.permission.BLUETOOTH") || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null) {
            return false;
        }
        try {
            return defaultAdapter.isEnabled();
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static boolean isDevEnv() {
        return b.u().equals(MParticle.Environment.Development);
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isEqual(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean isFirebaseAvailable() {
        return isFirebaseAvailablePostV21().booleanValue() || isFirebaseAvailablePreV21().booleanValue();
    }

    public static Boolean isFirebaseAvailablePostV21() {
        try {
            String str = FirebaseMessaging.INSTANCE_ID_SCOPE;
            return Boolean.TRUE;
        } catch (ClassNotFoundException unused) {
            return Boolean.FALSE;
        }
    }

    public static Boolean isFirebaseAvailablePreV21() {
        try {
            Class.forName("com.google.firebase.iid.FirebaseInstanceId");
            return Boolean.TRUE;
        } catch (ClassNotFoundException unused) {
            return Boolean.FALSE;
        }
    }

    public static boolean isGmsAdIdAvailable() {
        return true;
    }

    public static boolean isInDaylightSavings() {
        return Boolean.valueOf(TimeZone.getDefault().inDaylightTime(new Date())).booleanValue();
    }

    public static boolean isInstallRefApiAvailable() {
        return true;
    }

    public static boolean isInstantApp(final Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return context.getPackageManager().isInstantApp();
        }
        try {
            Class.forName("com.google.android.instantapps.InstantApps");
            return new SyncRunnable<Boolean>() {
                public Boolean run() {
                    return Boolean.valueOf(InstantApps.isInstantApp(context));
                }
            }.run().booleanValue();
        } catch (ClassNotFoundException unused) {
            try {
                Class.forName("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                return true;
            } catch (ClassNotFoundException unused2) {
                return false;
            }
        }
    }

    public static boolean isPhoneRooted() {
        String str = Build.TAGS;
        if (str != null && str.contains("test-keys")) {
            return true;
        }
        String[] strArr = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
        for (int i10 = 0; i10 < 8; i10++) {
            if (new File(strArr[i10] + "su").exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isServiceAvailable(Context context, Class<?> cls) {
        if (context.getPackageManager().queryIntentServices(new Intent(context, cls), 65536).size() > 0) {
            return true;
        }
        return false;
    }

    public static boolean isSupportLibAvailable() {
        try {
            Class.forName("android.support.v4.app.FragmentActivity");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean isSystemMemoryLow(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static b mapToJson(Map<String, ?> map) {
        if (map == null) {
            return null;
        }
        b bVar = new b();
        for (Map.Entry next : map.entrySet()) {
            try {
                Object value = next.getValue();
                String str = (String) next.getKey();
                if (value instanceof List) {
                    a aVar = new a();
                    for (Object E : (List) value) {
                        aVar.E(E);
                    }
                    bVar.put(str, (Object) aVar);
                } else if (value != null) {
                    bVar.put(str, (Object) value.toString());
                } else {
                    bVar.put(str, value);
                }
            } catch (JSONException unused) {
            }
        }
        return bVar;
    }

    public static long millitime() {
        return TimeUnit.MILLISECONDS.convert(System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public static int mpHash(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int i10 = 0;
        for (char c10 : str.toLowerCase().toCharArray()) {
            i10 = ((i10 << 5) - i10) + c10;
        }
        return i10;
    }

    public static Boolean setCheckedAttribute(b bVar, String str, Object obj, boolean z10, boolean z11) {
        return setCheckedAttribute(bVar, str, obj, Boolean.FALSE, z10, z11);
    }

    public static Object toNumberOrString(String str) {
        if (str == null) {
            return str;
        }
        for (char valueOf : str.toCharArray()) {
            Character valueOf2 = Character.valueOf(valueOf);
            if (!Character.isDigit(valueOf2.charValue()) && valueOf2.charValue() != '.' && valueOf2.charValue() != '-') {
                return str;
            }
        }
        try {
            return NumberFormat.getInstance().parse(str);
        } catch (ParseException unused) {
            return str;
        }
    }

    public static b wrapExtras(Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return null;
        }
        b bVar = new b();
        for (String next : bundle.keySet()) {
            Bundle bundle2 = bundle.getBundle(next);
            if (bundle2 != null) {
                try {
                    bVar.put(next, (Object) wrapExtras(bundle2));
                } catch (JSONException unused) {
                }
            } else {
                Object obj = bundle.get(next);
                if (obj != null) {
                    String obj2 = obj.toString();
                    if (obj2.length() < 500) {
                        bVar.put(next, (Object) obj2);
                    }
                }
            }
        }
        return bVar;
    }

    public static boolean isEmpty(a aVar) {
        return aVar == null || aVar.o() == 0;
    }

    public static Boolean setCheckedAttribute(b bVar, String str, Object obj, Boolean bool, boolean z10, boolean z11) {
        if (bVar == null || str == null) {
            return Boolean.FALSE;
        }
        try {
            if (bool.booleanValue()) {
                str = findCaseInsensitiveKey(bVar, str);
            }
            if (100 == bVar.length() && !bVar.has(str)) {
                Logger.error("Attribute count exceeds limit. Discarding attribute: " + str);
                return Boolean.FALSE;
            } else if (obj != null && obj.toString().length() > 4096) {
                Logger.error("Attribute value length exceeds limit. Discarding attribute: " + str);
                return Boolean.FALSE;
            } else if (str.length() > 256) {
                Logger.error("Attribute name length exceeds limit. Discarding attribute: " + str);
                return Boolean.FALSE;
            } else {
                if (obj == null) {
                    obj = b.NULL;
                }
                if (z10) {
                    obj = Integer.toString(((Integer) obj).intValue() + Integer.parseInt(bVar.optString(str, "0")));
                }
                bVar.put(str, obj);
                return Boolean.TRUE;
            }
        } catch (JSONException unused) {
            Logger.error("JSON error processing attributes. Discarding attribute: " + str);
            return Boolean.FALSE;
        } catch (NumberFormatException unused2) {
            Logger.error("Attempted to increment a key that could not be parsed as an integer: " + str);
            return Boolean.FALSE;
        } catch (Exception e10) {
            Logger.error("Failed to add attribute: " + e10.getMessage());
            return Boolean.FALSE;
        }
    }

    public static b getJsonResponse(HttpURLConnection httpURLConnection) {
        try {
            return getJsonResponse(httpURLConnection.getInputStream());
        } catch (IOException unused) {
            return getJsonResponse(httpURLConnection.getErrorStream());
        }
    }

    public static boolean isEmpty(b bVar) {
        return bVar == null || bVar.length() == 0;
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.size() == 0;
    }

    public static b getJsonResponse(InputStream inputStream) {
        try {
            StringBuilder sb2 = new StringBuilder();
            if (inputStream == null) {
                return null;
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb2.append(readLine + 10);
                } else {
                    bufferedReader.close();
                    return new b(sb2.toString());
                }
            }
        } catch (IOException | JSONException unused) {
            return null;
        }
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.size() == 0;
    }
}
