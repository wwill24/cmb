package we;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f42125a = {"ad_activeview", "ad_click", "ad_exposure", "ad_query", "ad_reward", "adunit_exposure", "app_clear_data", "app_exception", "app_remove", "app_store_refund", "app_store_subscription_cancel", "app_store_subscription_convert", "app_store_subscription_renew", "app_upgrade", "app_update", "ga_campaign", "error", "first_open", "first_visit", "in_app_purchase", "notification_dismiss", "notification_foreground", "notification_open", "notification_receive", "os_update", "session_start", "session_start_with_rollout", "user_engagement", FirebaseAnalytics.Event.AD_IMPRESSION, "screen_view", "ga_extra_parameter", "app_background", "firebase_campaign"};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f42126b = {FirebaseAnalytics.Event.AD_IMPRESSION};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f42127c = {"_aa", "_ac", "_xa", "_aq", "_ar", "_xu", "_cd", "_ae", "_ui", "app_store_refund", "app_store_subscription_cancel", "app_store_subscription_convert", "app_store_subscription_renew", "_ug", "_au", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, "_err", "_f", "_v", "_iap", Constants.ScionAnalytics.EVENT_NOTIFICATION_DISMISS, Constants.ScionAnalytics.EVENT_NOTIFICATION_FOREGROUND, Constants.ScionAnalytics.EVENT_NOTIFICATION_OPEN, Constants.ScionAnalytics.EVENT_NOTIFICATION_RECEIVE, "_ou", "_s", "_ssr", "_e", "_ai", "_vs", "_ep", "_ab", Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f42128d = {"purchase", "refund", FirebaseAnalytics.Event.ADD_PAYMENT_INFO, FirebaseAnalytics.Event.ADD_SHIPPING_INFO, "add_to_cart", "add_to_wishlist", FirebaseAnalytics.Event.BEGIN_CHECKOUT, "remove_from_cart", FirebaseAnalytics.Event.SELECT_ITEM, FirebaseAnalytics.Event.SELECT_PROMOTION, FirebaseAnalytics.Event.VIEW_CART, FirebaseAnalytics.Event.VIEW_ITEM, FirebaseAnalytics.Event.VIEW_ITEM_LIST, FirebaseAnalytics.Event.VIEW_PROMOTION, "ecommerce_purchase", "purchase_refund", "set_checkout_option", "checkout_progress", FirebaseAnalytics.Event.SELECT_CONTENT, FirebaseAnalytics.Event.VIEW_SEARCH_RESULTS};

    public static String a(String str) {
        return v.b(str, f42127c, f42125a);
    }

    public static String b(String str) {
        return v.b(str, f42125a, f42127c);
    }
}
