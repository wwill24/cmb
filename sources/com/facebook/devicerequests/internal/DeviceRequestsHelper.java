package com.facebook.devicerequests.internal;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import jh.b;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0003J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u0018\u001a\u00020\u0004H\u0007J\u001e\u0010\u0018\u001a\u00020\u00042\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001aH\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0007J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u001e\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \f*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R.\u0010\r\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u000f0\u000ej\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u000f`\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/facebook/devicerequests/internal/DeviceRequestsHelper;", "", "()V", "DEVICE_INFO_DEVICE", "", "DEVICE_INFO_MODEL", "DEVICE_INFO_PARAM", "DEVICE_TARGET_USER_ID", "SDK_FLAVOR", "SDK_HEADER", "SERVICE_TYPE", "TAG", "kotlin.jvm.PlatformType", "deviceRequestsListeners", "Ljava/util/HashMap;", "Landroid/net/nsd/NsdManager$RegistrationListener;", "Lkotlin/collections/HashMap;", "cleanUpAdvertisementService", "", "userCode", "cleanUpAdvertisementServiceImpl", "generateQRCode", "Landroid/graphics/Bitmap;", "url", "getDeviceInfo", "deviceInfo", "", "isAvailable", "", "startAdvertisementService", "startAdvertisementServiceImpl", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DeviceRequestsHelper {
    public static final String DEVICE_INFO_DEVICE = "device";
    public static final String DEVICE_INFO_MODEL = "model";
    public static final String DEVICE_INFO_PARAM = "device_info";
    public static final String DEVICE_TARGET_USER_ID = "target_user_id";
    public static final DeviceRequestsHelper INSTANCE = new DeviceRequestsHelper();
    public static final String SDK_FLAVOR = "android";
    public static final String SDK_HEADER = "fbsdk";
    public static final String SERVICE_TYPE = "_fb._tcp.";
    private static final String TAG = DeviceRequestsHelper.class.getCanonicalName();
    private static final HashMap<String, NsdManager.RegistrationListener> deviceRequestsListeners = new HashMap<>();

    private DeviceRequestsHelper() {
    }

    public static final void cleanUpAdvertisementService(String str) {
        Class<DeviceRequestsHelper> cls = DeviceRequestsHelper.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                INSTANCE.cleanUpAdvertisementServiceImpl(str);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
            }
        }
    }

    @TargetApi(16)
    private final void cleanUpAdvertisementServiceImpl(String str) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                NsdManager.RegistrationListener registrationListener = deviceRequestsListeners.get(str);
                if (registrationListener != null) {
                    Object systemService = FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
                    if (systemService != null) {
                        ((NsdManager) systemService).unregisterService(registrationListener);
                        deviceRequestsListeners.remove(str);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.net.nsd.NsdManager");
                }
            } catch (IllegalArgumentException e10) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, (Exception) e10);
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, this);
            }
        }
    }

    public static final Bitmap generateQRCode(String str) {
        int i10;
        Class<DeviceRequestsHelper> cls = DeviceRequestsHelper.class;
        Bitmap bitmap = null;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            EnumMap enumMap = new EnumMap(EncodeHintType.class);
            enumMap.put(EncodeHintType.MARGIN, 2);
            try {
                b a10 = new gh.b().a(str, BarcodeFormat.QR_CODE, 200, 200, enumMap);
                int e10 = a10.e();
                int h10 = a10.h();
                int[] iArr = new int[(e10 * h10)];
                if (e10 > 0) {
                    int i11 = 0;
                    while (true) {
                        int i12 = i11 + 1;
                        int i13 = i11 * h10;
                        if (h10 > 0) {
                            int i14 = 0;
                            while (true) {
                                int i15 = i14 + 1;
                                int i16 = i13 + i14;
                                if (a10.d(i14, i11)) {
                                    i10 = -16777216;
                                } else {
                                    i10 = -1;
                                }
                                iArr[i16] = i10;
                                if (i15 >= h10) {
                                    break;
                                }
                                i14 = i15;
                            }
                        }
                        if (i12 >= e10) {
                            break;
                        }
                        i11 = i12;
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap(h10, e10, Bitmap.Config.ARGB_8888);
                try {
                    createBitmap.setPixels(iArr, 0, h10, 0, 0, h10, e10);
                    return createBitmap;
                } catch (WriterException unused) {
                    bitmap = createBitmap;
                }
            } catch (WriterException unused2) {
                return bitmap;
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }

    public static final String getDeviceInfo(Map<String, String> map) {
        Class<DeviceRequestsHelper> cls = DeviceRequestsHelper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        if (map == null) {
            try {
                map = new HashMap<>();
            } catch (Throwable th2) {
                CrashShieldHandler.handleThrowable(th2, cls);
                return null;
            }
        }
        String str = Build.DEVICE;
        j.f(str, "DEVICE");
        map.put(DEVICE_INFO_DEVICE, str);
        String str2 = Build.MODEL;
        j.f(str2, "MODEL");
        map.put(DEVICE_INFO_MODEL, str2);
        String bVar = new org.json.b((Map<?, ?>) map).toString();
        j.f(bVar, "JSONObject(deviceInfo as Map<*, *>).toString()");
        return bVar;
    }

    public static final boolean isAvailable() {
        Class<DeviceRequestsHelper> cls = DeviceRequestsHelper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null || !appSettingsWithoutQuery.getSmartLoginOptions().contains(SmartLoginOption.Enabled)) {
                return false;
            }
            return true;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return false;
        }
    }

    public static final boolean startAdvertisementService(String str) {
        Class<DeviceRequestsHelper> cls = DeviceRequestsHelper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            if (isAvailable()) {
                return INSTANCE.startAdvertisementServiceImpl(str);
            }
            return false;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return false;
        }
    }

    @TargetApi(16)
    private final boolean startAdvertisementServiceImpl(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            HashMap<String, NsdManager.RegistrationListener> hashMap = deviceRequestsListeners;
            if (hashMap.containsKey(str)) {
                return true;
            }
            String str2 = "fbsdk_" + j.p("android-", r.C(FacebookSdk.getSdkVersion(), '.', '|', false, 4, (Object) null)) + '_' + str;
            NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
            nsdServiceInfo.setServiceType(SERVICE_TYPE);
            nsdServiceInfo.setServiceName(str2);
            nsdServiceInfo.setPort(80);
            Object systemService = FacebookSdk.getApplicationContext().getSystemService("servicediscovery");
            if (systemService != null) {
                DeviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$1 deviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$1 = new DeviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$1(str2, str);
                hashMap.put(str, deviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$1);
                ((NsdManager) systemService).registerService(nsdServiceInfo, 1, deviceRequestsHelper$startAdvertisementServiceImpl$nsdRegistrationListener$1);
                return true;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.net.nsd.NsdManager");
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
            return false;
        }
    }

    public static final String getDeviceInfo() {
        Class<DeviceRequestsHelper> cls = DeviceRequestsHelper.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return getDeviceInfo((Map<String, String>) null);
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, cls);
            return null;
        }
    }
}
