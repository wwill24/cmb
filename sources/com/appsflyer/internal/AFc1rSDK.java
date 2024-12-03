package com.appsflyer.internal;

import android.content.Context;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.appsflyer.AFLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.j;

public final class AFc1rSDK {
    private byte[] AFInAppEventParameterName;
    public String AFInAppEventType;
    public String AFKeystoreWrapper;
    public AFd1wSDK valueOf;
    public String values;

    AFc1rSDK() {
    }

    public AFc1rSDK(String str, byte[] bArr, String str2, AFd1wSDK aFd1wSDK) {
        this.AFKeystoreWrapper = str;
        this.AFInAppEventParameterName = bArr;
        this.AFInAppEventType = str2;
        this.valueOf = aFd1wSDK;
    }

    public static final List<StackTraceElement> values(Throwable th2) {
        j.g(th2, "");
        StackTraceElement[] stackTrace = th2.getStackTrace();
        j.f(stackTrace, "");
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            j.f(className, "");
            if (!r.J(className, "com.appsflyer", false, 2, (Object) null)) {
                stackTraceElement = null;
            }
            if (stackTraceElement != null) {
                arrayList.add(stackTraceElement);
            }
        }
        return arrayList;
    }

    public final byte[] AFInAppEventParameterName() {
        return this.AFInAppEventParameterName;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && AFc1rSDK.class == obj.getClass()) {
            AFc1rSDK aFc1rSDK = (AFc1rSDK) obj;
            String str = this.AFInAppEventType;
            if (str == null ? aFc1rSDK.AFInAppEventType != null : !str.equals(aFc1rSDK.AFInAppEventType)) {
                return false;
            }
            if (!Arrays.equals(this.AFInAppEventParameterName, aFc1rSDK.AFInAppEventParameterName)) {
                return false;
            }
            String str2 = this.AFKeystoreWrapper;
            if (str2 == null ? aFc1rSDK.AFKeystoreWrapper != null : !str2.equals(aFc1rSDK.AFKeystoreWrapper)) {
                return false;
            }
            String str3 = this.values;
            if (str3 == null ? aFc1rSDK.values != null : !str3.equals(aFc1rSDK.values)) {
                return false;
            }
            if (this.valueOf == aFc1rSDK.valueOf) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10;
        int i11;
        int i12;
        String str = this.AFInAppEventType;
        int i13 = 0;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        int hashCode = ((i10 * 31) + Arrays.hashCode(this.AFInAppEventParameterName)) * 31;
        String str2 = this.AFKeystoreWrapper;
        if (str2 != null) {
            i11 = str2.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = (hashCode + i11) * 31;
        String str3 = this.values;
        if (str3 != null) {
            i12 = str3.hashCode();
        } else {
            i12 = 0;
        }
        int i15 = (i14 + i12) * 31;
        AFd1wSDK aFd1wSDK = this.valueOf;
        if (aFd1wSDK != null) {
            i13 = aFd1wSDK.hashCode();
        }
        return i15 + i13;
    }

    public AFc1rSDK(char[] cArr) {
        Scanner scanner = new Scanner(new String(cArr));
        int i10 = 0;
        int i11 = 0;
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.startsWith("url=")) {
                this.AFKeystoreWrapper = nextLine.substring(4).trim();
            } else if (nextLine.startsWith("version=")) {
                this.AFInAppEventType = nextLine.substring(8).trim();
                Matcher matcher = Pattern.compile("^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$").matcher(this.AFInAppEventType);
                if (matcher.matches()) {
                    i10 = Integer.parseInt(matcher.group(1));
                    i11 = Integer.parseInt(matcher.group(2));
                }
            } else if (nextLine.startsWith("data=")) {
                String trim = nextLine.substring(5).trim();
                this.AFInAppEventParameterName = (i10 > 4 || i11 >= 11) ? Base64.decode(trim, 2) : trim.getBytes();
            } else if (nextLine.startsWith("type=")) {
                String trim2 = nextLine.substring(5).trim();
                try {
                    this.valueOf = AFd1wSDK.valueOf(trim2);
                } catch (Exception e10) {
                    AFLogger.afErrorLog("CACHE: Unknown task type: ".concat(String.valueOf(trim2)), e10);
                }
            }
        }
        scanner.close();
    }

    public static Map<String, String> values(Context context) {
        HashMap hashMap = new HashMap();
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            hashMap.put("x_px", String.valueOf(displayMetrics.widthPixels));
            hashMap.put("y_px", String.valueOf(displayMetrics.heightPixels));
            hashMap.put("d_dpi", String.valueOf(displayMetrics.densityDpi));
            hashMap.put("size", String.valueOf(context.getResources().getConfiguration().screenLayout & 15));
            hashMap.put("xdp", String.valueOf(displayMetrics.xdpi));
            hashMap.put("ydp", String.valueOf(displayMetrics.ydpi));
        } catch (Throwable th2) {
            AFLogger.afErrorLog("Couldn't aggregate screen stats: ", th2);
        }
        return hashMap;
    }
}
