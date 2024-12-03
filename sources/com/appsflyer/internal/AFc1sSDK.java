package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.AFLogger;
import java.util.HashMap;
import java.util.Map;

public class AFc1sSDK implements AFc1vSDK, AFc1zSDK, AFd1zSDK {
    private static String AFKeystoreWrapper;
    private static String values;
    private final byte[] AFInAppEventParameterName;
    @NonNull
    private final String AFInAppEventType;
    private boolean AFLogger;
    private int AFVersionDeclaration;
    private final boolean afDebugLog;
    private boolean afErrorLog;
    private boolean afInfoLog;
    @NonNull
    private final Map<String, String> afRDLog;
    @NonNull
    private final String valueOf;

    public AFc1sSDK() {
    }

    public AFc1sSDK(String str, byte[] bArr, String str2, Map<String, String> map, boolean z10) {
        this.afInfoLog = true;
        this.afErrorLog = false;
        this.AFLogger = true;
        this.AFVersionDeclaration = -1;
        this.valueOf = str;
        this.AFInAppEventParameterName = bArr;
        this.AFInAppEventType = str2;
        this.afRDLog = map;
        this.afDebugLog = z10;
    }

    public static void valueOf(String str) {
        if (values == null) {
            values(AFb1zSDK.AFInAppEventType().AFInAppEventParameterName().AFVersionDeclaration().AFInAppEventType);
        }
        String str2 = values;
        if (str2 != null) {
            AFLogger.afInfoLog(str.replace(str2, AFKeystoreWrapper));
        }
    }

    public static void values(String str) {
        values = str;
        if (str != null) {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < str.length(); i10++) {
                if (i10 == 0 || i10 == str.length() - 1) {
                    sb2.append(str.charAt(i10));
                } else {
                    sb2.append("*");
                }
            }
            AFKeystoreWrapper = sb2.toString();
        }
    }

    public AFc1sSDK AFInAppEventParameterName(int i10) {
        this.AFVersionDeclaration = i10;
        return this;
    }

    public byte[] AFInAppEventType() {
        return this.AFInAppEventParameterName;
    }

    @NonNull
    public String AFLogger() {
        return this.AFInAppEventType;
    }

    public boolean AFVersionDeclaration() {
        return this.afErrorLog;
    }

    public int afDebugLog() {
        return this.AFVersionDeclaration;
    }

    public boolean afErrorLog() {
        return this.afDebugLog;
    }

    public AFc1sSDK afErrorLogForExcManagerOnly() {
        this.AFLogger = false;
        return this;
    }

    @NonNull
    public Map<String, String> afInfoLog() {
        return this.afRDLog;
    }

    public boolean afRDLog() {
        return this.afInfoLog;
    }

    public boolean getLevel() {
        return this.AFLogger;
    }

    public AFc1sSDK valueOf(boolean z10) {
        this.afErrorLog = z10;
        return this;
    }

    @NonNull
    public String values() {
        return this.valueOf;
    }

    public AFc1sSDK(String str, String str2) {
        this(str, (byte[]) null, str2, new HashMap(), false);
    }
}
