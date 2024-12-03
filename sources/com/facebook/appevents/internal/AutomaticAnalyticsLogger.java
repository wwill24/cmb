package com.facebook.appevents.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.appevents.iap.InAppPurchaseEventManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.json.JSONException;
import org.json.b;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J.\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0007J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J \u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/facebook/appevents/internal/AutomaticAnalyticsLogger;", "", "()V", "APP_EVENTS_IF_AUTO_LOG_SUBS", "", "TAG", "kotlin.jvm.PlatformType", "internalAppEventsLogger", "Lcom/facebook/appevents/InternalAppEventsLogger;", "getPurchaseLoggingParameters", "Lcom/facebook/appevents/internal/AutomaticAnalyticsLogger$PurchaseLoggingParameters;", "purchase", "skuDetails", "extraParameter", "", "isImplicitPurchaseLoggingEnabled", "", "logActivateAppEvent", "", "logActivityTimeSpentEvent", "activityName", "timeSpentInSeconds", "", "logPurchase", "isSubscription", "PurchaseLoggingParameters", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AutomaticAnalyticsLogger {
    private static final String APP_EVENTS_IF_AUTO_LOG_SUBS = "app_events_if_auto_log_subs";
    public static final AutomaticAnalyticsLogger INSTANCE = new AutomaticAnalyticsLogger();
    private static final String TAG = AutomaticAnalyticsLogger.class.getCanonicalName();
    private static final InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(FacebookSdk.getApplicationContext());

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/internal/AutomaticAnalyticsLogger$PurchaseLoggingParameters;", "", "purchaseAmount", "Ljava/math/BigDecimal;", "currency", "Ljava/util/Currency;", "param", "Landroid/os/Bundle;", "(Ljava/math/BigDecimal;Ljava/util/Currency;Landroid/os/Bundle;)V", "getCurrency", "()Ljava/util/Currency;", "setCurrency", "(Ljava/util/Currency;)V", "getParam", "()Landroid/os/Bundle;", "setParam", "(Landroid/os/Bundle;)V", "getPurchaseAmount", "()Ljava/math/BigDecimal;", "setPurchaseAmount", "(Ljava/math/BigDecimal;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class PurchaseLoggingParameters {
        private Currency currency;
        private Bundle param;
        private BigDecimal purchaseAmount;

        public PurchaseLoggingParameters(BigDecimal bigDecimal, Currency currency2, Bundle bundle) {
            j.g(bigDecimal, "purchaseAmount");
            j.g(currency2, FirebaseAnalytics.Param.CURRENCY);
            j.g(bundle, "param");
            this.purchaseAmount = bigDecimal;
            this.currency = currency2;
            this.param = bundle;
        }

        public final Currency getCurrency() {
            return this.currency;
        }

        public final Bundle getParam() {
            return this.param;
        }

        public final BigDecimal getPurchaseAmount() {
            return this.purchaseAmount;
        }

        public final void setCurrency(Currency currency2) {
            j.g(currency2, "<set-?>");
            this.currency = currency2;
        }

        public final void setParam(Bundle bundle) {
            j.g(bundle, "<set-?>");
            this.param = bundle;
        }

        public final void setPurchaseAmount(BigDecimal bigDecimal) {
            j.g(bigDecimal, "<set-?>");
            this.purchaseAmount = bigDecimal;
        }
    }

    private AutomaticAnalyticsLogger() {
    }

    private final PurchaseLoggingParameters getPurchaseLoggingParameters(String str, String str2) {
        return getPurchaseLoggingParameters(str, str2, new HashMap());
    }

    public static final boolean isImplicitPurchaseLoggingEnabled() {
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery == null || !FacebookSdk.getAutoLogAppEventsEnabled() || !appSettingsWithoutQuery.getIAPAutomaticLoggingEnabled()) {
            return false;
        }
        return true;
    }

    public static final void logActivateAppEvent() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        String applicationId = FacebookSdk.getApplicationId();
        if (FacebookSdk.getAutoLogAppEventsEnabled() && (applicationContext instanceof Application)) {
            AppEventsLogger.Companion.activateApp((Application) applicationContext, applicationId);
        }
    }

    public static final void logActivityTimeSpentEvent(String str, long j10) {
        Context applicationContext = FacebookSdk.getApplicationContext();
        FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
        if (queryAppSettings != null && queryAppSettings.getAutomaticLoggingEnabled() && j10 > 0) {
            InternalAppEventsLogger internalAppEventsLogger2 = new InternalAppEventsLogger(applicationContext);
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence(Constants.AA_TIME_SPENT_SCREEN_PARAMETER_NAME, str);
            internalAppEventsLogger2.logEvent(Constants.AA_TIME_SPENT_EVENT_NAME, (double) j10, bundle);
        }
    }

    public static final void logPurchase(String str, String str2, boolean z10) {
        PurchaseLoggingParameters purchaseLoggingParameters;
        String str3;
        j.g(str, "purchase");
        j.g(str2, "skuDetails");
        if (isImplicitPurchaseLoggingEnabled() && (purchaseLoggingParameters = INSTANCE.getPurchaseLoggingParameters(str, str2)) != null) {
            boolean z11 = false;
            if (z10) {
                FetchedAppGateKeepersManager fetchedAppGateKeepersManager = FetchedAppGateKeepersManager.INSTANCE;
                if (FetchedAppGateKeepersManager.getGateKeeperForKey(APP_EVENTS_IF_AUTO_LOG_SUBS, FacebookSdk.getApplicationId(), false)) {
                    z11 = true;
                }
            }
            if (z11) {
                if (InAppPurchaseEventManager.INSTANCE.hasFreeTrialPeirod(str2)) {
                    str3 = AppEventsConstants.EVENT_NAME_START_TRIAL;
                } else {
                    str3 = AppEventsConstants.EVENT_NAME_SUBSCRIBE;
                }
                internalAppEventsLogger.logEventImplicitly(str3, purchaseLoggingParameters.getPurchaseAmount(), purchaseLoggingParameters.getCurrency(), purchaseLoggingParameters.getParam());
                return;
            }
            internalAppEventsLogger.logPurchaseImplicitly(purchaseLoggingParameters.getPurchaseAmount(), purchaseLoggingParameters.getCurrency(), purchaseLoggingParameters.getParam());
        }
    }

    private final PurchaseLoggingParameters getPurchaseLoggingParameters(String str, String str2, Map<String, String> map) {
        try {
            b bVar = new b(str);
            b bVar2 = new b(str2);
            boolean z10 = true;
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence(Constants.IAP_PRODUCT_ID, bVar.getString("productId"));
            bundle.putCharSequence(Constants.IAP_PURCHASE_TIME, bVar.getString("purchaseTime"));
            bundle.putCharSequence(Constants.IAP_PURCHASE_TOKEN, bVar.getString(SDKConstants.PARAM_PURCHASE_TOKEN));
            bundle.putCharSequence(Constants.IAP_PACKAGE_NAME, bVar.optString(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME));
            bundle.putCharSequence(Constants.IAP_PRODUCT_TITLE, bVar2.optString("title"));
            bundle.putCharSequence(Constants.IAP_PRODUCT_DESCRIPTION, bVar2.optString("description"));
            String optString = bVar2.optString("type");
            bundle.putCharSequence(Constants.IAP_PRODUCT_TYPE, optString);
            if (j.b(optString, "subs")) {
                bundle.putCharSequence(Constants.IAP_SUBSCRIPTION_AUTORENEWING, Boolean.toString(bVar.optBoolean("autoRenewing", false)));
                bundle.putCharSequence(Constants.IAP_SUBSCRIPTION_PERIOD, bVar2.optString("subscriptionPeriod"));
                bundle.putCharSequence(Constants.IAP_FREE_TRIAL_PERIOD, bVar2.optString("freeTrialPeriod"));
                String optString2 = bVar2.optString("introductoryPriceCycles");
                j.f(optString2, "introductoryPriceCycles");
                if (optString2.length() != 0) {
                    z10 = false;
                }
                if (!z10) {
                    bundle.putCharSequence(Constants.IAP_INTRO_PRICE_AMOUNT_MICROS, bVar2.optString("introductoryPriceAmountMicros"));
                    bundle.putCharSequence(Constants.IAP_INTRO_PRICE_CYCLES, optString2);
                }
            }
            for (Map.Entry next : map.entrySet()) {
                bundle.putCharSequence((String) next.getKey(), (String) next.getValue());
            }
            BigDecimal bigDecimal = new BigDecimal(((double) bVar2.getLong("price_amount_micros")) / 1000000.0d);
            Currency instance = Currency.getInstance(bVar2.getString("price_currency_code"));
            j.f(instance, "getInstance(skuDetailsJSON.getString(\"price_currency_code\"))");
            return new PurchaseLoggingParameters(bigDecimal, instance, bundle);
        } catch (JSONException unused) {
            return null;
        }
    }
}
