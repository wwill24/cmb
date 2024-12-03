package com.coffeemeetsbagel.models.enums;

import android.text.TextUtils;
import com.coffeemeetsbagel.util.RequestCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public enum RewardType {
    INVITE(500),
    TWEET(100),
    FOLLOW_TWITTER(100),
    FOLLOW_INSTAGRAM(200),
    BUY_LARGE((String) RequestCode.OVERFLOW_ACTIVITY, (int) "com.coffeemeetsbagel.beanpack.large"),
    BUY_MEDIUM((String) 2000, (int) "com.coffeemeetsbagel.beanpack.medium"),
    BUY_SMALL((String) 100, (int) "com.coffeemeetsbagel.beanpack.small"),
    VARIABLE((String) 0, (int) null),
    MINIMUM_BEAN_PACKAGE_1_50((String) 50, (int) "beans.50.sale.99"),
    MINIMUM_BEAN_PACKAGE_51_200((String) 200, (int) "beans.200.sale.299"),
    MINIMUM_BEAN_PACKAGE_201_400((String) 400, (int) "beans.400.sale.499"),
    MINIMUM_BEAN_PACKAGE_401_800((String) 800, (int) "beans.800.sale.999"),
    BEAN_PACKAGE_4000((String) 4000, (int) "beans.4000.sale.2999"),
    BEAN_PACKAGE_1000((String) 1000, (int) "beans.1000.sale.999"),
    BEAN_PACKAGE_6000((String) 6000, (int) "beans.6000.sale.3999"),
    UNKNOWN("unknown", 0);
    
    private static String sCurrencyCode;
    private static final Map<String, RewardType> sMapSkuToRewardType = null;
    private final String mKey;
    private String mPriceString;
    private final String mProductSku;
    private final int mReward;
    private String micros;

    static {
        int i10;
        sMapSkuToRewardType = new HashMap();
        for (RewardType rewardType : values()) {
            if (!TextUtils.isEmpty(rewardType.getProductSku())) {
                sMapSkuToRewardType.put(rewardType.getProductSku(), rewardType);
            }
        }
    }

    private RewardType(int i10) {
        this(r7, r8, i10, "", "");
    }

    public static RewardType getBeanRewardTypeFromProductSku(String str) {
        Map<String, RewardType> map = sMapSkuToRewardType;
        if (!map.containsKey(str)) {
            return VARIABLE;
        }
        return map.get(str);
    }

    public static String getCurrencyCode() {
        return sCurrencyCode;
    }

    public static ArrayList<String> getProductSkuList() {
        return new ArrayList<>(sMapSkuToRewardType.keySet());
    }

    public static RewardType getTypeFromKey(String str) {
        for (RewardType rewardType : values()) {
            if (rewardType.getKey().equals(str)) {
                return rewardType;
            }
        }
        return UNKNOWN;
    }

    public static void updatePriceAndMicros(String str, String str2, String str3, String str4) {
        Map<String, RewardType> map = sMapSkuToRewardType;
        RewardType rewardType = map.get(str);
        rewardType.setPriceString(str2);
        rewardType.setMicros(str3);
        map.put(str, rewardType);
        sCurrencyCode = str4;
    }

    public String getKey() {
        return this.mKey;
    }

    public String getMicros() {
        return this.micros;
    }

    public double getPriceAsDouble() {
        String replaceAll = this.mPriceString.replaceAll("[^\\d.]", "");
        if (TextUtils.isEmpty(replaceAll)) {
            return -1.0d;
        }
        return Double.valueOf(replaceAll).doubleValue();
    }

    public String getPriceString() {
        return this.mPriceString;
    }

    public String getProductSku() {
        return this.mProductSku;
    }

    public int getRewardAmount() {
        return this.mReward;
    }

    public void setMicros(String str) {
        this.micros = str;
    }

    public void setPriceString(String str) {
        this.mPriceString = str;
    }

    private RewardType(int i10, String str) {
        this(r7, r8, i10, str, "");
    }

    private RewardType(String str, int i10) {
        this(r8, r9, str, i10, "", "");
    }

    private RewardType(int i10, String str, String str2) {
        this(r8, r9, "", i10, str, str2);
    }

    private RewardType(String str, int i10, String str2, String str3) {
        this.mKey = str;
        this.mReward = i10;
        this.mProductSku = str2;
        this.mPriceString = str3;
    }
}
