package com.mparticle.kits;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.leanplum.internal.Constants;
import com.mparticle.MPEvent;
import com.mparticle.MParticle;
import com.mparticle.commerce.CommerceEvent;
import com.mparticle.commerce.Product;
import com.mparticle.commerce.TransactionAttributes;
import com.mparticle.consent.ConsentState;
import com.mparticle.identity.IdentityHttpResponse;
import com.mparticle.identity.MParticleUser;
import com.mparticle.internal.Logger;
import com.mparticle.kits.KitIntegration;
import com.mparticle.kits.ReportingMessage;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import kotlin.text.Regex;
import net.bytebuddy.utility.JavaConstant;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 \\2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002\\]B\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u001d\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00142\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u000fH\u0016J*\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u000f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0!H\u0016J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010#\u001a\u00020\u0011H\u0016J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\f\u001a\u00020\rH\u0016J6\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\n\u0010%\u001a\u00060&j\u0002`'2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0!2\u0006\u0010\u001e\u001a\u00020\u000fH\u0016J:\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\u000f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0!H\u0016J,\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u000f2\u0014\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010!H\u0016J \u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u000203H\u0016J\u0018\u00104\u001a\u00020.2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016J(\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u000f2\u0006\u00102\u001a\u000203H\u0016J*\u0010>\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0!2\u0006\u0010?\u001a\u00020@H\u0016J\u0018\u0010A\u001a\u00020.2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016J\u0018\u0010B\u001a\u00020.2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016J\u0018\u0010C\u001a\u00020.2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0016J\u0018\u0010D\u001a\u00020.2\u0006\u0010:\u001a\u00020\u000f2\u0006\u00102\u001a\u000203H\u0016JB\u0010E\u001a\u00020.2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0!2\u001a\u0010G\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u001c\u0018\u00010!2\b\u00102\u001a\u0004\u0018\u000103H\u0016J \u0010H\u001a\u00020.2\u0006\u0010:\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020I2\u0006\u00102\u001a\u000203H\u0016J&\u0010J\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020\u000f2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001c2\u0006\u00102\u001a\u000203H\u0016J\u0018\u0010L\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u00102\u001a\u000203H\u0016J\u0010\u0010M\u001a\u00020.2\u0006\u00105\u001a\u000206H\u0016J\u0016\u0010N\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010O\u001a\u00020PH\u0016J\u0012\u0010Q\u001a\u00020.2\b\u0010R\u001a\u0004\u0018\u000106H\u0002J2\u0010S\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010!2\u0014\u0010T\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010!2\u0006\u0010\u0010\u001a\u00020PJ\u001a\u0010U\u001a\u0004\u0018\u00010\u000f2\b\u0010V\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020PJ\u0018\u0010W\u001a\u00020\u000f2\b\u0010X\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020PJ\b\u0010Y\u001a\u00020PH\u0016J\u001e\u0010Z\u001a\u00020\u00152\u0014\u0010[\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010!H\u0002¨\u0006^"}, d2 = {"Lcom/mparticle/kits/GoogleAnalyticsFirebaseKit;", "Lcom/mparticle/kits/KitIntegration;", "Lcom/mparticle/kits/KitIntegration$EventListener;", "Lcom/mparticle/kits/KitIntegration$IdentityListener;", "Lcom/mparticle/kits/KitIntegration$CommerceListener;", "Lcom/mparticle/kits/KitIntegration$UserAttributeListener;", "()V", "getBundle", "Lcom/mparticle/kits/GoogleAnalyticsFirebaseKit$PickyBundle;", "product", "Lcom/mparticle/commerce/Product;", "getCommerceEventBundle", "commerceEvent", "Lcom/mparticle/commerce/CommerceEvent;", "getFirebaseEventName", "", "event", "Lcom/mparticle/MPEvent;", "getName", "getProductBundles", "", "Landroid/os/Bundle;", "(Lcom/mparticle/commerce/CommerceEvent;)[Landroid/os/Bundle;", "getTransactionAttributesBundle", "getValue", "", "(Lcom/mparticle/commerce/CommerceEvent;)Ljava/lang/Double;", "leaveBreadcrumb", "", "Lcom/mparticle/kits/ReportingMessage;", "s", "logError", "map", "", "logEvent", "mpEvent", "logException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "logLtvIncrease", "bigDecimal", "Ljava/math/BigDecimal;", "bigDecimal1", "logScreen", "onConsentStateUpdated", "", "consentState", "Lcom/mparticle/consent/ConsentState;", "consentState1", "filteredMParticleUser", "Lcom/mparticle/kits/FilteredMParticleUser;", "onIdentifyCompleted", "mParticleUser", "Lcom/mparticle/identity/MParticleUser;", "filteredIdentityApiRequest", "Lcom/mparticle/kits/FilteredIdentityApiRequest;", "onIncrementUserAttribute", "key", "incrementedBy", "", "value", "onKitCreate", "context", "Landroid/content/Context;", "onLoginCompleted", "onLogoutCompleted", "onModifyCompleted", "onRemoveUserAttribute", "onSetAllUserAttributes", "userAttributes", "userAttributeLists", "onSetUserAttribute", "", "onSetUserAttributeList", "list", "onSetUserTag", "onUserIdentified", "setOptOut", "b", "", "setUserId", "user", "standardizeAttributes", "attributes", "standardizeName", "nameIn", "standardizeValue", "valueIn", "supportsAttributeLists", "toBundle", "mapIn", "Companion", "PickyBundle", "android-googleanalyticsfirebase-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GoogleAnalyticsFirebaseKit extends KitIntegration implements KitIntegration.EventListener, KitIntegration.IdentityListener, KitIntegration.CommerceListener, KitIntegration.UserAttributeListener {
    private static final String CURRENCY_FIELD_NOT_SET = "Currency field required by Firebase was not set, defaulting to 'USD'";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KIT_NAME = "Google Analytics for Firebase";
    private static final String USD = "USD";
    public static final String USER_ID_CUSTOMER_ID_VALUE = "customerId";
    public static final String USER_ID_EMAIL_VALUE = "email";
    public static final String USER_ID_FIELD_KEY = "userIdField";
    public static final String USER_ID_MPID_VALUE = "mpid";
    private static final int eventMaxLength = 40;
    private static final int eventValMaxLength = 100;
    private static final String[] forbiddenPrefixes = {"google_", "firebase_", "ga_"};
    private static final int userAttributeMaxLength = 24;
    private static final int userAttributeValMaxLength = 36;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/mparticle/kits/GoogleAnalyticsFirebaseKit$Companion;", "", "()V", "CURRENCY_FIELD_NOT_SET", "", "KIT_NAME", "USD", "USER_ID_CUSTOMER_ID_VALUE", "USER_ID_EMAIL_VALUE", "USER_ID_FIELD_KEY", "USER_ID_MPID_VALUE", "eventMaxLength", "", "eventValMaxLength", "forbiddenPrefixes", "", "[Ljava/lang/String;", "userAttributeMaxLength", "userAttributeValMaxLength", "android-googleanalyticsfirebase-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\u0007\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u001f\u0010\r\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/mparticle/kits/GoogleAnalyticsFirebaseKit$PickyBundle;", "", "()V", "bundle", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "putBundleList", "key", "", "value", "", "(Ljava/lang/String;[Landroid/os/Bundle;)Lcom/mparticle/kits/GoogleAnalyticsFirebaseKit$PickyBundle;", "putDouble", "", "(Ljava/lang/String;Ljava/lang/Double;)Lcom/mparticle/kits/GoogleAnalyticsFirebaseKit$PickyBundle;", "putInt", "", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/mparticle/kits/GoogleAnalyticsFirebaseKit$PickyBundle;", "putLong", "", "(Ljava/lang/String;Ljava/lang/Long;)Lcom/mparticle/kits/GoogleAnalyticsFirebaseKit$PickyBundle;", "putString", "android-googleanalyticsfirebase-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PickyBundle {
        private final Bundle bundle = new Bundle();

        public final Bundle getBundle() {
            return this.bundle;
        }

        public final PickyBundle putBundleList(String str, Bundle[] bundleArr) {
            if (bundleArr != null) {
                this.bundle.putParcelableArray(str, (Parcelable[]) bundleArr);
            }
            return this;
        }

        public final PickyBundle putDouble(String str, Double d10) {
            if (d10 != null) {
                this.bundle.putDouble(str, d10.doubleValue());
            }
            return this;
        }

        public final PickyBundle putInt(String str, Integer num) {
            if (num != null) {
                this.bundle.putInt(str, num.intValue());
            }
            return this;
        }

        public final PickyBundle putLong(String str, Long l10) {
            if (l10 != null) {
                this.bundle.putLong(str, l10.longValue());
            }
            return this;
        }

        public final PickyBundle putString(String str, String str2) {
            if (str2 != null) {
                this.bundle.putString(str, str2);
            }
            return this;
        }
    }

    private final PickyBundle getBundle(Product product) {
        return new PickyBundle().putLong(FirebaseAnalytics.Param.QUANTITY, Long.valueOf((long) product.getQuantity())).putString(FirebaseAnalytics.Param.ITEM_ID, product.getSku()).putString(FirebaseAnalytics.Param.ITEM_NAME, product.getName()).putString(FirebaseAnalytics.Param.ITEM_CATEGORY, product.getCategory()).putDouble(FirebaseAnalytics.Param.PRICE, Double.valueOf(product.getUnitPrice()));
    }

    private final PickyBundle getCommerceEventBundle(CommerceEvent commerceEvent) {
        PickyBundle transactionAttributesBundle = getTransactionAttributesBundle(commerceEvent);
        String currency = commerceEvent.getCurrency();
        if (currency == null) {
            Logger.info(CURRENCY_FIELD_NOT_SET);
            currency = "USD";
        }
        Map<String, Object> customAttributes = commerceEvent.getCustomAttributes();
        if (customAttributes != null) {
            for (Map.Entry next : customAttributes.entrySet()) {
                transactionAttributesBundle.putString((String) next.getKey(), next.getValue().toString());
            }
        }
        transactionAttributesBundle.putString(FirebaseAnalytics.Param.CURRENCY, currency).putBundleList(FirebaseAnalytics.Param.ITEMS, getProductBundles(commerceEvent)).putString("set_checkout_option", commerceEvent.getCheckoutOptions()).putInt("checkout_progress", commerceEvent.getCheckoutStep());
        return transactionAttributesBundle;
    }

    private final String getFirebaseEventName(MPEvent mPEvent) {
        if (mPEvent.getEventType() == MParticle.EventType.Search) {
            return FirebaseAnalytics.Event.SEARCH;
        }
        if (mPEvent.isScreenEvent()) {
            return FirebaseAnalytics.Event.VIEW_ITEM;
        }
        return standardizeName(mPEvent.getEventName(), true);
    }

    private final Bundle[] getProductBundles(CommerceEvent commerceEvent) {
        List<Product> products = commerceEvent.getProducts();
        int i10 = 0;
        if (products == null) {
            return new Bundle[0];
        }
        Bundle[] bundleArr = new Bundle[products.size()];
        for (Product next : products) {
            j.f(next, "product");
            bundleArr[i10] = getBundle(next).putString(FirebaseAnalytics.Param.CURRENCY, commerceEvent.getCurrency()).getBundle();
            i10++;
        }
        return bundleArr;
    }

    private final PickyBundle getTransactionAttributesBundle(CommerceEvent commerceEvent) {
        String str;
        Double d10;
        Double d11;
        Double d12;
        PickyBundle pickyBundle = new PickyBundle();
        TransactionAttributes transactionAttributes = commerceEvent.getTransactionAttributes();
        if (commerceEvent.getTransactionAttributes() == null) {
            return pickyBundle;
        }
        String str2 = null;
        if (transactionAttributes != null) {
            str = transactionAttributes.getId();
        } else {
            str = null;
        }
        PickyBundle putString = pickyBundle.putString(FirebaseAnalytics.Param.TRANSACTION_ID, str);
        if (transactionAttributes != null) {
            d10 = transactionAttributes.getRevenue();
        } else {
            d10 = null;
        }
        PickyBundle putDouble = putString.putDouble("value", d10);
        if (transactionAttributes != null) {
            d11 = transactionAttributes.getTax();
        } else {
            d11 = null;
        }
        PickyBundle putDouble2 = putDouble.putDouble(FirebaseAnalytics.Param.TAX, d11);
        if (transactionAttributes != null) {
            d12 = transactionAttributes.getShipping();
        } else {
            d12 = null;
        }
        PickyBundle putDouble3 = putDouble2.putDouble(FirebaseAnalytics.Param.SHIPPING, d12);
        if (transactionAttributes != null) {
            str2 = transactionAttributes.getCouponCode();
        }
        return putDouble3.putString(FirebaseAnalytics.Param.COUPON, str2);
    }

    private final Double getValue(CommerceEvent commerceEvent) {
        List<Product> products = commerceEvent.getProducts();
        if (products == null) {
            return null;
        }
        double d10 = 0.0d;
        for (Product next : products) {
            d10 += next.getQuantity() * next.getUnitPrice();
        }
        return Double.valueOf(d10);
    }

    /* access modifiers changed from: private */
    public static final void onIdentifyCompleted$lambda$1(GoogleAnalyticsFirebaseKit googleAnalyticsFirebaseKit, Map map, Map map2, Long l10) {
        j.g(googleAnalyticsFirebaseKit, "this$0");
        googleAnalyticsFirebaseKit.onSetAllUserAttributes(new HashMap(map), (Map<String, ? extends List<String>>) null, (FilteredMParticleUser) null);
    }

    /* access modifiers changed from: private */
    public static final void onLoginCompleted$lambda$2(GoogleAnalyticsFirebaseKit googleAnalyticsFirebaseKit, Map map, Map map2, Long l10) {
        j.g(googleAnalyticsFirebaseKit, "this$0");
        googleAnalyticsFirebaseKit.onSetAllUserAttributes(new HashMap(map), (Map<String, ? extends List<String>>) null, (FilteredMParticleUser) null);
    }

    /* access modifiers changed from: private */
    public static final void onModifyCompleted$lambda$3(GoogleAnalyticsFirebaseKit googleAnalyticsFirebaseKit, Map map, Map map2, Long l10) {
        j.g(googleAnalyticsFirebaseKit, "this$0");
        googleAnalyticsFirebaseKit.onSetAllUserAttributes(new HashMap(map), (Map<String, ? extends List<String>>) null, (FilteredMParticleUser) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setUserId(com.mparticle.identity.MParticleUser r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x005e
            java.util.Map r0 = r4.getSettings()
            java.lang.String r1 = "userIdField"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "customerId"
            r3 = 1
            boolean r0 = kotlin.text.r.t(r2, r0, r3)
            if (r0 == 0) goto L_0x0024
            java.util.Map r5 = r5.getUserIdentities()
            com.mparticle.MParticle$IdentityType r0 = com.mparticle.MParticle.IdentityType.CustomerId
            java.lang.Object r5 = r5.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x005f
        L_0x0024:
            java.util.Map r0 = r4.getSettings()
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "email"
            boolean r0 = kotlin.text.r.t(r2, r0, r3)
            if (r0 == 0) goto L_0x0043
            java.util.Map r5 = r5.getUserIdentities()
            com.mparticle.MParticle$IdentityType r0 = com.mparticle.MParticle.IdentityType.Email
            java.lang.Object r5 = r5.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x005f
        L_0x0043:
            java.util.Map r0 = r4.getSettings()
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "mpid"
            boolean r0 = kotlin.text.r.t(r1, r0, r3)
            if (r0 == 0) goto L_0x005e
            long r0 = r5.getId()
            java.lang.String r5 = java.lang.String.valueOf(r0)
            goto L_0x005f
        L_0x005e:
            r5 = 0
        L_0x005f:
            boolean r0 = com.mparticle.kits.KitUtils.isEmpty(r5)
            if (r0 != 0) goto L_0x0070
            android.content.Context r0 = r4.getContext()
            com.google.firebase.analytics.FirebaseAnalytics r0 = com.google.firebase.analytics.FirebaseAnalytics.getInstance(r0)
            r0.setUserId(r5)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.kits.GoogleAnalyticsFirebaseKit.setUserId(com.mparticle.identity.MParticleUser):void");
    }

    private final Bundle toBundle(Map<String, String> map) {
        Bundle bundle = new Bundle();
        Map<String, String> standardizeAttributes = standardizeAttributes(map, true);
        if (standardizeAttributes != null) {
            for (Map.Entry next : standardizeAttributes.entrySet()) {
                bundle.putString((String) next.getKey(), (String) next.getValue());
            }
        }
        return bundle;
    }

    public String getName() {
        return KIT_NAME;
    }

    public List<ReportingMessage> leaveBreadcrumb(String str) {
        j.g(str, "s");
        return q.j();
    }

    public List<ReportingMessage> logError(String str, Map<String, String> map) {
        j.g(str, "s");
        j.g(map, "map");
        return q.j();
    }

    public List<ReportingMessage> logEvent(MPEvent mPEvent) {
        j.g(mPEvent, "mpEvent");
        String firebaseEventName = getFirebaseEventName(mPEvent);
        if (firebaseEventName != null) {
            FirebaseAnalytics.getInstance(getContext()).logEvent(firebaseEventName, toBundle(mPEvent.getCustomAttributeStrings()));
        }
        return p.e(ReportingMessage.fromEvent(this, mPEvent));
    }

    public List<ReportingMessage> logException(Exception exc, Map<String, String> map, String str) {
        j.g(exc, ReportingMessage.MessageType.EVENT);
        j.g(map, "map");
        j.g(str, "s");
        return q.j();
    }

    public List<ReportingMessage> logLtvIncrease(BigDecimal bigDecimal, BigDecimal bigDecimal2, String str, Map<String, String> map) {
        j.g(bigDecimal, "bigDecimal");
        j.g(bigDecimal2, "bigDecimal1");
        j.g(str, "s");
        j.g(map, "map");
        return q.j();
    }

    public List<ReportingMessage> logScreen(String str, Map<String, String> map) {
        j.g(str, "s");
        Activity activity = getCurrentActivity().get();
        if (activity == null) {
            return q.j();
        }
        FirebaseAnalytics.getInstance(getContext()).setCurrentScreen(activity, standardizeName(str, true), (String) null);
        return p.e(new ReportingMessage(this, ReportingMessage.MessageType.SCREEN_VIEW, System.currentTimeMillis(), (Map<String, ?>) null));
    }

    public void onConsentStateUpdated(ConsentState consentState, ConsentState consentState2, FilteredMParticleUser filteredMParticleUser) {
        j.g(consentState, "consentState");
        j.g(consentState2, "consentState1");
        j.g(filteredMParticleUser, "filteredMParticleUser");
    }

    public void onIdentifyCompleted(MParticleUser mParticleUser, FilteredIdentityApiRequest filteredIdentityApiRequest) {
        j.g(mParticleUser, "mParticleUser");
        j.g(filteredIdentityApiRequest, "filteredIdentityApiRequest");
        setUserId(mParticleUser);
        try {
            mParticleUser.getUserAttributes(new c(this));
        } catch (Exception e10) {
            Logger.warning(e10, "Unable to fetch User Attributes");
        }
    }

    public void onIncrementUserAttribute(String str, Number number, String str2, FilteredMParticleUser filteredMParticleUser) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(number, "incrementedBy");
        j.g(str2, "value");
        j.g(filteredMParticleUser, "filteredMParticleUser");
        String standardizeName = standardizeName(str, false);
        if (standardizeName != null) {
            FirebaseAnalytics.getInstance(getContext()).setUserProperty(standardizeName, str2);
        }
    }

    public List<ReportingMessage> onKitCreate(Map<String, String> map, Context context) throws IllegalArgumentException {
        j.g(map, "map");
        j.g(context, IdentityHttpResponse.CONTEXT);
        Logger.info(getName() + " Kit relies on a functioning instance of Firebase Analytics. If your Firebase Analytics instance is not configured properly, this Kit will not work");
        return q.j();
    }

    public void onLoginCompleted(MParticleUser mParticleUser, FilteredIdentityApiRequest filteredIdentityApiRequest) {
        j.g(mParticleUser, "mParticleUser");
        j.g(filteredIdentityApiRequest, "filteredIdentityApiRequest");
        setUserId(mParticleUser);
        try {
            mParticleUser.getUserAttributes(new d(this));
        } catch (Exception e10) {
            Logger.warning(e10, "Unable to fetch User Attributes");
        }
    }

    public void onLogoutCompleted(MParticleUser mParticleUser, FilteredIdentityApiRequest filteredIdentityApiRequest) {
        j.g(mParticleUser, "mParticleUser");
        j.g(filteredIdentityApiRequest, "filteredIdentityApiRequest");
        setUserId(mParticleUser);
    }

    public void onModifyCompleted(MParticleUser mParticleUser, FilteredIdentityApiRequest filteredIdentityApiRequest) {
        j.g(mParticleUser, "mParticleUser");
        j.g(filteredIdentityApiRequest, "filteredIdentityApiRequest");
        setUserId(mParticleUser);
        try {
            mParticleUser.getUserAttributes(new b(this));
        } catch (Exception e10) {
            Logger.warning(e10, "Unable to fetch User Attributes");
        }
    }

    public void onRemoveUserAttribute(String str, FilteredMParticleUser filteredMParticleUser) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(filteredMParticleUser, "filteredMParticleUser");
        String standardizeName = standardizeName(str, false);
        if (standardizeName != null) {
            FirebaseAnalytics.getInstance(getContext()).setUserProperty(standardizeName, (String) null);
        }
    }

    public void onSetAllUserAttributes(Map<String, String> map, Map<String, ? extends List<String>> map2, FilteredMParticleUser filteredMParticleUser) {
        j.g(map, Constants.Params.USER_ATTRIBUTES);
        Map<String, String> standardizeAttributes = standardizeAttributes(map, false);
        if (standardizeAttributes != null) {
            for (Map.Entry next : standardizeAttributes.entrySet()) {
                FirebaseAnalytics.getInstance(getContext()).setUserProperty((String) next.getKey(), (String) next.getValue());
            }
        }
    }

    public void onSetUserAttribute(String str, Object obj, FilteredMParticleUser filteredMParticleUser) {
        String standardizeName;
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(obj, "value");
        j.g(filteredMParticleUser, "filteredMParticleUser");
        if ((obj instanceof String) && (standardizeName = standardizeName(str, false)) != null) {
            FirebaseAnalytics.getInstance(getContext()).setUserProperty(standardizeName, standardizeValue((String) obj, false));
        }
    }

    public void onSetUserAttributeList(String str, List<String> list, FilteredMParticleUser filteredMParticleUser) {
        j.g(str, "s");
        j.g(list, "list");
        j.g(filteredMParticleUser, "filteredMParticleUser");
    }

    public void onSetUserTag(String str, FilteredMParticleUser filteredMParticleUser) {
        j.g(str, "s");
        j.g(filteredMParticleUser, "filteredMParticleUser");
    }

    public void onUserIdentified(MParticleUser mParticleUser) {
        j.g(mParticleUser, "mParticleUser");
    }

    public List<ReportingMessage> setOptOut(boolean z10) {
        return q.j();
    }

    public final Map<String, String> standardizeAttributes(Map<String, String> map, boolean z10) {
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            String standardizeName = standardizeName((String) next.getKey(), z10);
            j.d(standardizeName);
            hashMap.put(standardizeName, standardizeValue((String) next.getValue(), z10));
        }
        return hashMap;
    }

    public final String standardizeName(String str, boolean z10) {
        boolean z11;
        if (str == null) {
            return null;
        }
        String f10 = new Regex("[\\s]+").f(new Regex("[^a-zA-Z0-9_\\s]").f(str, " "), JavaConstant.Dynamic.DEFAULT_NAME);
        for (String str2 : forbiddenPrefixes) {
            if (r.J(f10, str2, false, 2, (Object) null)) {
                f10 = new Regex(str2).g(f10, "");
            }
        }
        while (true) {
            if (f10.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                break;
            }
            char[] charArray = f10.toCharArray();
            j.f(charArray, "this as java.lang.String).toCharArray()");
            if (Character.isLetter(charArray[0])) {
                break;
            }
            f10 = f10.substring(1);
            j.f(f10, "this as java.lang.String).substring(startIndex)");
        }
        if (z10) {
            if (f10.length() <= 40) {
                return f10;
            }
            String substring = f10.substring(0, 40);
            j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        } else if (f10.length() <= 24) {
            return f10;
        } else {
            String substring2 = f10.substring(0, 24);
            j.f(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring2;
        }
    }

    public final String standardizeValue(String str, boolean z10) {
        if (str == null) {
            return "";
        }
        if (z10) {
            if (str.length() <= 100) {
                return str;
            }
            String substring = str.substring(0, 100);
            j.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        } else if (str.length() <= 36) {
            return str;
        } else {
            String substring2 = str.substring(0, 36);
            j.f(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring2;
        }
    }

    public boolean supportsAttributeLists() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009a, code lost:
        r0.logEvent(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a5, code lost:
        return kotlin.collections.p.e(com.mparticle.kits.ReportingMessage.fromEvent(r9, r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0042, code lost:
        if (r2.equals(r4) == false) goto L_0x00a6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.mparticle.kits.ReportingMessage> logEvent(com.mparticle.commerce.CommerceEvent r10) {
        /*
            r9 = this;
            java.lang.String r0 = "commerceEvent"
            kotlin.jvm.internal.j.g(r10, r0)
            android.content.Context r0 = r9.getContext()
            com.google.firebase.analytics.FirebaseAnalytics r0 = com.google.firebase.analytics.FirebaseAnalytics.getInstance(r0)
            java.lang.String r1 = "getInstance(context)"
            kotlin.jvm.internal.j.f(r0, r1)
            java.lang.String r1 = r10.getProductAction()
            if (r1 != 0) goto L_0x001d
            java.util.List r10 = kotlin.collections.q.j()
            return r10
        L_0x001d:
            com.mparticle.kits.GoogleAnalyticsFirebaseKit$PickyBundle r1 = r9.getCommerceEventBundle(r10)
            android.os.Bundle r1 = r1.getBundle()
            java.lang.String r2 = r10.getProductAction()
            if (r2 == 0) goto L_0x00a6
            int r3 = r2.hashCode()
            java.lang.String r4 = "add_to_wishlist"
            java.lang.String r5 = "remove_from_cart"
            java.lang.String r6 = "purchase"
            java.lang.String r7 = "add_to_cart"
            java.lang.String r8 = "refund"
            switch(r3) {
                case -934813832: goto L_0x0092;
                case -300972245: goto L_0x0086;
                case -145695346: goto L_0x007a;
                case 94750088: goto L_0x006e;
                case 164161734: goto L_0x0065;
                case 1536904518: goto L_0x0059;
                case 1743324417: goto L_0x0050;
                case 1927902362: goto L_0x0046;
                case 2080563307: goto L_0x003e;
                default: goto L_0x003c;
            }
        L_0x003c:
            goto L_0x00a6
        L_0x003e:
            boolean r2 = r2.equals(r4)
            if (r2 != 0) goto L_0x009a
            goto L_0x00a6
        L_0x0046:
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x004e
            goto L_0x00a6
        L_0x004e:
            r4 = r5
            goto L_0x009a
        L_0x0050:
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x0057
            goto L_0x00a6
        L_0x0057:
            r4 = r6
            goto L_0x009a
        L_0x0059:
            java.lang.String r3 = "checkout"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0062
            goto L_0x00a6
        L_0x0062:
            java.lang.String r4 = "begin_checkout"
            goto L_0x009a
        L_0x0065:
            boolean r2 = r2.equals(r7)
            if (r2 != 0) goto L_0x006c
            goto L_0x00a6
        L_0x006c:
            r4 = r7
            goto L_0x009a
        L_0x006e:
            java.lang.String r3 = "click"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0077
            goto L_0x00a6
        L_0x0077:
            java.lang.String r4 = "select_content"
            goto L_0x009a
        L_0x007a:
            java.lang.String r3 = "checkout_option"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0083
            goto L_0x00a6
        L_0x0083:
            java.lang.String r4 = "set_checkout_option"
            goto L_0x009a
        L_0x0086:
            java.lang.String r3 = "view_detail"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x008f
            goto L_0x00a6
        L_0x008f:
            java.lang.String r4 = "view_item"
            goto L_0x009a
        L_0x0092:
            boolean r2 = r2.equals(r8)
            if (r2 != 0) goto L_0x0099
            goto L_0x00a6
        L_0x0099:
            r4 = r8
        L_0x009a:
            r0.logEvent(r4, r1)
            com.mparticle.kits.ReportingMessage r10 = com.mparticle.kits.ReportingMessage.fromEvent(r9, r10)
            java.util.List r10 = kotlin.collections.p.e(r10)
            return r10
        L_0x00a6:
            java.util.List r10 = kotlin.collections.q.j()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.kits.GoogleAnalyticsFirebaseKit.logEvent(com.mparticle.commerce.CommerceEvent):java.util.List");
    }
}
