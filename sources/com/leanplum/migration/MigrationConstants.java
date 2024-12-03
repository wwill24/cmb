package com.leanplum.migration;

import com.clevertap.android.sdk.CleverTapAPI;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/leanplum/migration/MigrationConstants;", "", "()V", "ANONYMOUS_DEVICE_PROPERTY", "", "CHARGED_EVENT_PARAM", "CURRENCY_CODE_PARAM", "DEVICES_USER_PROPERTY", "GP_PURCHASE_DATA_PARAM", "GP_PURCHASE_DATA_SIGNATURE_PARAM", "IAP_ITEM_PARAM", "IDENTITY", "INFO_PARAM", "STATE_PREFIX", "VALUE_PARAM", "mapLogLevel", "Lcom/clevertap/android/sdk/CleverTapAPI$LogLevel;", "lpLevel", "", "AndroidSDKCore_release"}, k = 1, mv = {1, 4, 2})
public final class MigrationConstants {
    public static final String ANONYMOUS_DEVICE_PROPERTY = "lp_device";
    public static final String CHARGED_EVENT_PARAM = "event";
    public static final String CURRENCY_CODE_PARAM = "currencyCode";
    public static final String DEVICES_USER_PROPERTY = "lp_devices";
    public static final String GP_PURCHASE_DATA_PARAM = "googlePlayPurchaseData";
    public static final String GP_PURCHASE_DATA_SIGNATURE_PARAM = "googlePlayPurchaseDataSignature";
    public static final String IAP_ITEM_PARAM = "item";
    public static final String IDENTITY = "Identity";
    public static final String INFO_PARAM = "info";
    public static final MigrationConstants INSTANCE = new MigrationConstants();
    public static final String STATE_PREFIX = "state_";
    public static final String VALUE_PARAM = "value";

    private MigrationConstants() {
    }

    public final CleverTapAPI.LogLevel mapLogLevel(int i10) {
        if (i10 == 0) {
            return CleverTapAPI.LogLevel.OFF;
        }
        if (i10 == 1) {
            return CleverTapAPI.LogLevel.INFO;
        }
        if (i10 == 2) {
            return CleverTapAPI.LogLevel.INFO;
        }
        if (i10 != 3) {
            return CleverTapAPI.LogLevel.INFO;
        }
        return CleverTapAPI.LogLevel.VERBOSE;
    }
}
