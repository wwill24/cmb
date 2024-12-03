package com.coffeemeetsbagel.feature.firebase;

import android.os.Bundle;
import com.coffeemeetsbagel.feature.firebase.FirebaseContract;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.leanplum.internal.Constants;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.text.Regex;
import net.bytebuddy.utility.JavaConstant;

public final class FirebaseAnalyticsImpl implements FirebaseContract.Analytics {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String VIRTUAL_CURRENCY_NAME_VALUE = "beans";
    private final FirebaseAnalytics firebaseAnalytics;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public FirebaseAnalyticsImpl(FirebaseAnalytics firebaseAnalytics2) {
        j.g(firebaseAnalytics2, "firebaseAnalytics");
        this.firebaseAnalytics = firebaseAnalytics2;
    }

    public void logSpendingVirtualCurrency(long j10, String str, long j11) {
        j.g(str, "itemName");
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, str);
        bundle.putString(FirebaseAnalytics.Param.VIRTUAL_CURRENCY_NAME, VIRTUAL_CURRENCY_NAME_VALUE);
        bundle.putLong("value", j11);
        bundle.putLong(FirebaseAnalytics.Param.QUANTITY, j10);
        this.firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SPEND_VIRTUAL_CURRENCY, bundle);
    }

    public void setUserId(String str) {
        j.g(str, Constants.Params.USER_ID);
        this.firebaseAnalytics.setUserId(str);
    }

    public void setUserProperty(String str, String str2) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(str2, "value");
        this.firebaseAnalytics.setUserProperty(str, str2);
    }

    public void trackEvent(String str, Map<String, String> map) {
        j.g(str, "event");
        j.g(map, "attributes");
        Bundle bundle = new Bundle();
        for (String next : map.keySet()) {
            bundle.putString(next, map.get(next));
        }
        String f10 = new Regex("\\s+").f(str, JavaConstant.Dynamic.DEFAULT_NAME);
        FirebaseAnalytics firebaseAnalytics2 = this.firebaseAnalytics;
        String lowerCase = f10.toLowerCase();
        j.f(lowerCase, "this as java.lang.String).toLowerCase()");
        firebaseAnalytics2.logEvent(lowerCase, bundle);
    }
}
