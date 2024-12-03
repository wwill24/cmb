package com.mparticle.kits;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.deeplink.DeepLink;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.ServerProtocol;
import com.mparticle.AttributionError;
import com.mparticle.AttributionResult;
import com.mparticle.MPEvent;
import com.mparticle.MParticle;
import com.mparticle.commerce.CommerceEvent;
import com.mparticle.commerce.Product;
import com.mparticle.commerce.TransactionAttributes;
import com.mparticle.identity.IdentityHttpResponse;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;
import com.mparticle.kits.KitIntegration;
import com.mparticle.kits.ReportingMessage;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;
import org.json.JSONException;
import org.json.b;

@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 d2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001dB\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\rH\u0016J*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0017\u001a\u00020\r2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0019H\u0016J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0010\u001a\u00020\u001bH\u0016J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J6\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00192\u0006\u0010\u0017\u001a\u00020\rH\u0016J:\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\r2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0019H\u0016J\u001e\u0010&\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00140)H\u0002JD\u0010*\u001a\u00020'2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010-0,2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010)2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00140)H\u0002J*\u00100\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u00101\u001a\u00020\r2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0019H\u0016J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J \u00104\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u00105\u001a\u000206H\u0016J\u0016\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u00105\u001a\u000206H\u0016J\u0016\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u00105\u001a\u000206H\u0016J \u0010<\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u00105\u001a\u000206H\u0016J\u0016\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u00105\u001a\u000206H\u0016J\u001e\u0010?\u001a\u00020'2\u0014\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010,H\u0016J\u0010\u0010A\u001a\u00020'2\u0006\u0010B\u001a\u00020\rH\u0016J\u0010\u0010C\u001a\u00020'2\u0006\u0010D\u001a\u00020\rH\u0016J\u001e\u0010E\u001a\u00020'2\u0014\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020-\u0018\u00010,H\u0016J0\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0018\u0010H\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\u00192\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u00020'2\u0006\u0010L\u001a\u00020\rH\u0016J\u0010\u0010M\u001a\u00020'2\u0006\u0010N\u001a\u00020OH\u0016J6\u0010P\u001a\u00020'2\u0012\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00192\u0018\u0010R\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00130\u0019H\u0016J\u0010\u0010S\u001a\u00020'2\u0006\u0010T\u001a\u00020UH\u0016J\u0010\u0010V\u001a\u00020'2\u0006\u0010W\u001a\u00020XH\u0016J\u0016\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010Z\u001a\u00020\u000fH\u0016J\u0018\u0010[\u001a\u00020'2\u0006\u0010\\\u001a\u00020\r2\u0006\u0010]\u001a\u00020\rH\u0016J\u001e\u0010^\u001a\u00020'2\u0006\u0010_\u001a\u00020\r2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\r0\u0013H\u0016J\u0018\u0010a\u001a\u00020'2\u0006\u0010N\u001a\u00020O2\u0006\u0010b\u001a\u00020\rH\u0016J\b\u0010c\u001a\u00020\u000fH\u0016¨\u0006e"}, d2 = {"Lcom/mparticle/kits/AppsFlyerKit;", "Lcom/mparticle/kits/KitIntegration;", "Lcom/mparticle/kits/KitIntegration$EventListener;", "Lcom/mparticle/kits/KitIntegration$AttributeListener;", "Lcom/mparticle/kits/KitIntegration$CommerceListener;", "Lcom/appsflyer/AppsFlyerConversionListener;", "Lcom/mparticle/kits/KitIntegration$ActivityListener;", "()V", "deepLinkListener", "Lcom/appsflyer/deeplink/DeepLinkListener;", "getInstance", "Lcom/appsflyer/AppsFlyerLib;", "getName", "", "isSalesEvent", "", "event", "Lcom/mparticle/commerce/CommerceEvent;", "leaveBreadcrumb", "", "Lcom/mparticle/kits/ReportingMessage;", "breadcrumb", "logError", "message", "eventData", "", "logEvent", "Lcom/mparticle/MPEvent;", "logException", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "logLtvIncrease", "valueIncreased", "Ljava/math/BigDecimal;", "valueTotal", "eventName", "contextInfo", "logNotSalesEvent", "", "messages", "", "logSalesEvent", "eventValues", "", "", "productList", "Lcom/mparticle/commerce/Product;", "logScreen", "screenName", "eventAttributes", "logout", "onActivityCreated", "activity", "Landroid/app/Activity;", "bundle", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "onActivityStarted", "onActivityStopped", "onAppOpenAttribution", "attributionDataN", "onAttributionFailure", "attributionFailure", "onConversionDataFail", "conversionFailure", "onConversionDataSuccess", "conversionDataN", "onKitCreate", "setting", "context", "Landroid/content/Context;", "removeUserAttribute", "key", "removeUserIdentity", "identityType", "Lcom/mparticle/MParticle$IdentityType;", "setAllUserAttributes", "map", "map1", "setInstallReferrer", "intent", "Landroid/content/Intent;", "setLocation", "location", "Landroid/location/Location;", "setOptOut", "optOutStatus", "setUserAttribute", "attributeKey", "attributeValue", "setUserAttributeList", "s", "list", "setUserIdentity", "identity", "supportsAttributeLists", "Companion", "android-appsflyer-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AppsFlyerKit extends KitIntegration implements KitIntegration.EventListener, KitIntegration.AttributeListener, KitIntegration.CommerceListener, AppsFlyerConversionListener, KitIntegration.ActivityListener {
    public static final String APPSFLYERID_INTEGRATION_KEY = "appsflyer_id_integration_setting";
    public static final String APP_OPEN_ATTRIBUTION_RESULT = "MPARTICLE_APPSFLYER_APP_OPEN_ATTRIBUTION_RESULT";
    public static final String COMMA = ",";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEV_KEY = "devKey";
    public static final String INSTALL_CONVERSION_RESULT = "MPARTICLE_APPSFLYER_INSTALL_CONVERSION_RESULT";
    public static final String NAME = "AppsFlyer";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/mparticle/kits/AppsFlyerKit$Companion;", "", "()V", "APPSFLYERID_INTEGRATION_KEY", "", "APP_OPEN_ATTRIBUTION_RESULT", "COMMA", "DEV_KEY", "INSTALL_CONVERSION_RESULT", "NAME", "generateProductIdList", "event", "Lcom/mparticle/commerce/CommerceEvent;", "android-appsflyer-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String generateProductIdList(CommerceEvent commerceEvent) {
            boolean z10;
            boolean z11;
            if (commerceEvent == null || commerceEvent.getProducts() == null) {
                return null;
            }
            List<Product> products = commerceEvent.getProducts();
            if (products == null || products.size() != 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                return null;
            }
            StringBuilder sb2 = new StringBuilder();
            List<Product> products2 = commerceEvent.getProducts();
            if (products2 != null) {
                for (Product sku : products2) {
                    String sku2 = sku.getSku();
                    j.f(sku2, "product.sku");
                    if (!KitUtils.isEmpty(sku2)) {
                        sb2.append(r.D(sku2, AppsFlyerKit.COMMA, "%2C", false, 4, (Object) null));
                        sb2.append(AppsFlyerKit.COMMA);
                    }
                }
            }
            if (sb2.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                return sb2.substring(0, sb2.length() - 1);
            }
            return null;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.appsflyer.deeplink.DeepLinkResult$Status[] r0 = com.appsflyer.deeplink.DeepLinkResult.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.appsflyer.deeplink.DeepLinkResult$Status r1 = com.appsflyer.deeplink.DeepLinkResult.Status.FOUND     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.appsflyer.deeplink.DeepLinkResult$Status r1 = com.appsflyer.deeplink.DeepLinkResult.Status.NOT_FOUND     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mparticle.kits.AppsFlyerKit.WhenMappings.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public static final void deepLinkListener$lambda$7(AppsFlyerKit appsFlyerKit, DeepLinkResult deepLinkResult) {
        j.g(appsFlyerKit, "this$0");
        j.g(deepLinkResult, "deepLinkResult");
        DeepLink deepLink = deepLinkResult.getDeepLink();
        int i10 = WhenMappings.$EnumSwitchMapping$0[deepLinkResult.getStatus().ordinal()];
        if (i10 == 1) {
            try {
                deepLink.getClickEvent().put(APP_OPEN_ATTRIBUTION_RESULT, (Object) ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                AttributionResult serviceProviderId = new AttributionResult().setParameters(deepLink.getClickEvent()).setServiceProviderId(appsFlyerKit.getConfiguration().getKitId());
                j.f(serviceProviderId, "AttributionResult()\n    …erId(configuration.kitId)");
                appsFlyerKit.getKitManager().onResult(serviceProviderId);
            } catch (Exception unused) {
            }
        } else if (i10 != 2) {
            DeepLinkResult.Error error = deepLinkResult.getError();
            if (!KitUtils.isEmpty(error.toString())) {
                AttributionError serviceProviderId2 = new AttributionError().setMessage(error.toString()).setServiceProviderId(appsFlyerKit.getConfiguration().getKitId());
                j.f(serviceProviderId2, "AttributionError()\n     …erId(configuration.kitId)");
                appsFlyerKit.getKitManager().onError(serviceProviderId2);
            }
        }
    }

    private final boolean isSalesEvent(CommerceEvent commerceEvent) {
        if (j.b(commerceEvent.getProductAction(), "add_to_cart") || j.b(commerceEvent.getProductAction(), "add_to_wishlist") || j.b(commerceEvent.getProductAction(), Product.CHECKOUT) || j.b(commerceEvent.getProductAction(), "purchase")) {
            return true;
        }
        return false;
    }

    private final void logNotSalesEvent(CommerceEvent commerceEvent, List<ReportingMessage> list) {
        List<MPEvent> expand = CommerceEventUtils.expand(commerceEvent);
        j.f(expand, "eventList");
        if (!expand.isEmpty()) {
            for (MPEvent next : expand) {
                try {
                    j.f(next, ReportingMessage.MessageType.EVENT);
                    logEvent(next);
                    ReportingMessage fromEvent = ReportingMessage.fromEvent(this, commerceEvent);
                    j.f(fromEvent, "fromEvent(this, event)");
                    list.add(fromEvent);
                } catch (Exception e10) {
                    Logger.warning("Failed to call logCustomEvent to AppsFlyer kit: " + e10);
                }
            }
        }
    }

    private final void logSalesEvent(CommerceEvent commerceEvent, Map<String, Object> map, List<Product> list, List<ReportingMessage> list2) {
        String str;
        String str2;
        boolean z10;
        Map<String, Object> customAttributes = commerceEvent.getCustomAttributes();
        if (customAttributes != null) {
            map.putAll(customAttributes);
        }
        if (!KitUtils.isEmpty(commerceEvent.getCurrency())) {
            map.put(AFInAppEventParameterName.CURRENCY, commerceEvent.getCurrency());
        }
        if (j.b(commerceEvent.getProductAction(), "add_to_cart") || j.b(commerceEvent.getProductAction(), "add_to_wishlist")) {
            if (j.b(commerceEvent.getProductAction(), "add_to_cart")) {
                str = AFInAppEventType.ADD_TO_CART;
            } else {
                str = AFInAppEventType.ADD_TO_WISH_LIST;
            }
            if (list != null && (r14 = list.iterator()) != null) {
                for (Product next : list) {
                    HashMap hashMap = new HashMap();
                    hashMap.putAll(map);
                    hashMap.put(AFInAppEventParameterName.PRICE, Double.valueOf(next.getUnitPrice()));
                    hashMap.put(AFInAppEventParameterName.QUANTITY, Double.valueOf(next.getQuantity()));
                    if (!KitUtils.isEmpty(next.getSku())) {
                        hashMap.put(AFInAppEventParameterName.CONTENT_ID, next.getSku());
                    }
                    if (!KitUtils.isEmpty(next.getCategory())) {
                        hashMap.put(AFInAppEventParameterName.CONTENT_TYPE, next.getCategory());
                    }
                    getInstance().logEvent(getContext(), str, hashMap);
                    ReportingMessage fromEvent = ReportingMessage.fromEvent(this, commerceEvent);
                    j.f(fromEvent, "fromEvent(this, event)");
                    list2.add(fromEvent);
                }
                return;
            }
            return;
        }
        if (j.b(commerceEvent.getProductAction(), Product.CHECKOUT)) {
            str2 = AFInAppEventType.INITIATED_CHECKOUT;
        } else {
            str2 = AFInAppEventType.PURCHASE;
        }
        map.put(AFInAppEventParameterName.CONTENT_ID, Companion.generateProductIdList(commerceEvent));
        if (list == null || list.isEmpty()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            double d10 = 0.0d;
            for (Product quantity : list) {
                d10 += quantity.getQuantity();
            }
            map.put(AFInAppEventParameterName.QUANTITY, Double.valueOf(d10));
        }
        TransactionAttributes transactionAttributes = commerceEvent.getTransactionAttributes();
        if (transactionAttributes != null && !j.a(transactionAttributes.getRevenue(), 0.0d)) {
            Double revenue = transactionAttributes.getRevenue();
            if (j.b(commerceEvent.getProductAction(), "purchase")) {
                map.put(AFInAppEventParameterName.REVENUE, revenue);
                if (!MPUtility.isEmpty((CharSequence) transactionAttributes.getId())) {
                    map.put("af_order_id", transactionAttributes.getId());
                }
            } else {
                map.put(AFInAppEventParameterName.PRICE, revenue);
            }
        }
        getInstance().logEvent(getContext(), str2, map);
        ReportingMessage fromEvent2 = ReportingMessage.fromEvent(this, commerceEvent);
        j.f(fromEvent2, "fromEvent(this, event)");
        list2.add(fromEvent2);
    }

    public final DeepLinkListener deepLinkListener() {
        return new a(this);
    }

    public String getName() {
        return NAME;
    }

    public List<ReportingMessage> leaveBreadcrumb(String str) {
        j.g(str, "breadcrumb");
        return q.j();
    }

    public List<ReportingMessage> logError(String str, Map<String, String> map) {
        j.g(str, "message");
        j.g(map, "eventData");
        return q.j();
    }

    public List<ReportingMessage> logEvent(CommerceEvent commerceEvent) {
        j.g(commerceEvent, "event");
        LinkedList linkedList = new LinkedList();
        HashMap hashMap = new HashMap();
        List<Product> products = commerceEvent.getProducts();
        if (isSalesEvent(commerceEvent)) {
            logSalesEvent(commerceEvent, hashMap, products, linkedList);
        } else {
            logNotSalesEvent(commerceEvent, linkedList);
        }
        return linkedList;
    }

    public List<ReportingMessage> logException(Exception exc, Map<String, String> map, String str) {
        j.g(exc, "exception");
        j.g(map, "eventData");
        j.g(str, "message");
        return q.j();
    }

    public List<ReportingMessage> logLtvIncrease(BigDecimal bigDecimal, BigDecimal bigDecimal2, String str, Map<String, String> map) {
        j.g(bigDecimal, "valueIncreased");
        j.g(bigDecimal2, "valueTotal");
        j.g(str, "eventName");
        j.g(map, "contextInfo");
        return q.j();
    }

    public List<ReportingMessage> logScreen(String str, Map<String, String> map) {
        j.g(str, "screenName");
        j.g(map, "eventAttributes");
        return q.j();
    }

    public List<ReportingMessage> logout() {
        return q.j();
    }

    public List<ReportingMessage> onActivityCreated(Activity activity, Bundle bundle) {
        j.g(activity, "activity");
        getInstance().start(activity);
        return q.j();
    }

    public List<ReportingMessage> onActivityDestroyed(Activity activity) {
        j.g(activity, "activity");
        return q.j();
    }

    public List<ReportingMessage> onActivityPaused(Activity activity) {
        j.g(activity, "activity");
        return q.j();
    }

    public List<ReportingMessage> onActivityResumed(Activity activity) {
        j.g(activity, "activity");
        return q.j();
    }

    public List<ReportingMessage> onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        j.g(activity, "activity");
        return q.j();
    }

    public List<ReportingMessage> onActivityStarted(Activity activity) {
        j.g(activity, "activity");
        return q.j();
    }

    public List<ReportingMessage> onActivityStopped(Activity activity) {
        j.g(activity, "activity");
        return q.j();
    }

    public void onAppOpenAttribution(Map<String, String> map) {
    }

    public void onAttributionFailure(String str) {
        j.g(str, "attributionFailure");
    }

    public void onConversionDataFail(String str) {
        j.g(str, "conversionFailure");
        if (!KitUtils.isEmpty(str)) {
            AttributionError serviceProviderId = new AttributionError().setMessage(str).setServiceProviderId(getConfiguration().getKitId());
            j.f(serviceProviderId, "AttributionError()\n     …erId(configuration.kitId)");
            getKitManager().onError(serviceProviderId);
        }
    }

    public void onConversionDataSuccess(Map<String, Object> map) {
        b bVar = new b();
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(INSTALL_CONVERSION_RESULT, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        for (Map.Entry next : map.entrySet()) {
            try {
                bVar.put((String) next.getKey(), next.getValue());
            } catch (JSONException unused) {
            }
        }
        AttributionResult serviceProviderId = new AttributionResult().setParameters(bVar).setServiceProviderId(getConfiguration().getKitId());
        j.f(serviceProviderId, "AttributionResult()\n    …erId(configuration.kitId)");
        getKitManager().onResult(serviceProviderId);
    }

    public List<ReportingMessage> onKitCreate(Map<String, String> map, Context context) {
        MParticle.Environment environment;
        boolean z10;
        j.g(context, IdentityHttpResponse.CONTEXT);
        AppsFlyerLib instance = AppsFlyerLib.getInstance();
        MParticle instance2 = MParticle.getInstance();
        if (instance2 != null) {
            environment = instance2.getEnvironment();
        } else {
            environment = null;
        }
        if (environment == MParticle.Environment.Development) {
            z10 = true;
        } else {
            z10 = false;
        }
        instance.setDebugLog(z10);
        String str = getSettings().get(DEV_KEY);
        if (str != null) {
            AppsFlyerLib.getInstance().init(str, this, context);
        }
        AppsFlyerLib.getInstance().start(context.getApplicationContext());
        AppsFlyerLib.getInstance().setCollectAndroidID(MParticle.isAndroidIdEnabled());
        HashMap hashMap = new HashMap(1);
        hashMap.put(APPSFLYERID_INTEGRATION_KEY, AppsFlyerLib.getInstance().getAppsFlyerUID(context));
        setIntegrationAttributes(hashMap);
        AppsFlyerLib.getInstance().subscribeForDeepLink(deepLinkListener());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ReportingMessage(this, ReportingMessage.MessageType.APP_STATE_TRANSITION, System.currentTimeMillis(), (Map<String, ?>) null));
        return arrayList;
    }

    public void removeUserAttribute(String str) {
        j.g(str, SDKConstants.PARAM_KEY);
    }

    public void removeUserIdentity(MParticle.IdentityType identityType) {
        j.g(identityType, "identityType");
        AppsFlyerLib instance = getInstance();
        if (MParticle.IdentityType.CustomerId == identityType) {
            instance.setCustomerUserId("");
        } else if (MParticle.IdentityType.Email == identityType) {
            instance.setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, "");
        }
    }

    public void setAllUserAttributes(Map<String, String> map, Map<String, ? extends List<String>> map2) {
        j.g(map, "map");
        j.g(map2, "map1");
    }

    public void setInstallReferrer(Intent intent) {
        j.g(intent, SDKConstants.PARAM_INTENT);
    }

    public void setLocation(Location location) {
        j.g(location, "location");
        getInstance().logLocation(getContext(), location.getLatitude(), location.getLongitude());
    }

    public List<ReportingMessage> setOptOut(boolean z10) {
        getInstance().anonymizeUser(z10);
        LinkedList linkedList = new LinkedList();
        ReportingMessage optOut = new ReportingMessage(this, ReportingMessage.MessageType.OPT_OUT, System.currentTimeMillis(), (Map<String, ?>) null).setOptOut(z10);
        j.f(optOut, "ReportingMessage(\n      …).setOptOut(optOutStatus)");
        linkedList.add(optOut);
        return linkedList;
    }

    public void setUserAttribute(String str, String str2) {
        j.g(str, "attributeKey");
        j.g(str2, "attributeValue");
    }

    public void setUserAttributeList(String str, List<String> list) {
        j.g(str, "s");
        j.g(list, "list");
    }

    public void setUserIdentity(MParticle.IdentityType identityType, String str) {
        j.g(identityType, "identityType");
        j.g(str, "identity");
        AppsFlyerLib instance = getInstance();
        if (MParticle.IdentityType.CustomerId == identityType) {
            instance.setCustomerUserId(str);
        } else if (MParticle.IdentityType.Email == identityType) {
            instance.setUserEmails(AppsFlyerProperties.EmailsCryptType.NONE, str);
        }
    }

    public boolean supportsAttributeLists() {
        return true;
    }

    public AppsFlyerLib getInstance() {
        AppsFlyerLib instance = AppsFlyerLib.getInstance();
        j.f(instance, "getInstance()");
        return instance;
    }

    public List<ReportingMessage> logEvent(MPEvent mPEvent) {
        j.g(mPEvent, "event");
        HashMap hashMap = new HashMap();
        Map<String, Object> customAttributes = mPEvent.getCustomAttributes();
        boolean z10 = false;
        if (customAttributes != null && (!customAttributes.isEmpty())) {
            z10 = true;
        }
        if (z10) {
            Map<String, Object> customAttributes2 = mPEvent.getCustomAttributes();
            hashMap = customAttributes2 != null ? new HashMap(customAttributes2) : null;
        }
        getInstance().logEvent(getContext(), mPEvent.getEventName(), hashMap);
        LinkedList linkedList = new LinkedList();
        ReportingMessage fromEvent = ReportingMessage.fromEvent(this, mPEvent);
        j.f(fromEvent, "fromEvent(this, event)");
        linkedList.add(fromEvent);
        return linkedList;
    }
}
