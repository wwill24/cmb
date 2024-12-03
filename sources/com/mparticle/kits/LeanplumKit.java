package com.mparticle.kits;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.leanplum.Leanplum;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.LeanplumDeviceIdMode;
import com.leanplum.internal.Constants;
import com.mparticle.MPEvent;
import com.mparticle.MParticle;
import com.mparticle.commerce.CommerceEvent;
import com.mparticle.commerce.Product;
import com.mparticle.consent.ConsentState;
import com.mparticle.identity.IdentityApi;
import com.mparticle.identity.IdentityHttpResponse;
import com.mparticle.identity.MParticleUser;
import com.mparticle.internal.Logger;
import com.mparticle.kits.KitIntegration;
import com.mparticle.kits.ReportingMessage;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\t\u0018\u0000 \\2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001\\B\u0005¢\u0006\u0002\u0010\u0007J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J:\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u000eJ\b\u0010\u0011\u001a\u00020\tH\u0016J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\tH\u0016J*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\t2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000eH\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J6\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\n\u0010\u001e\u001a\u00060\u001fj\u0002` 2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\u0015\u001a\u00020\tH\u0016J:\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\t2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000eH\u0016J*\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010(\u001a\u00020\t2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000eH\u0016J\u0018\u0010)\u001a\u00020*2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,H\u0002J \u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u000202H\u0016J\u0018\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u000206H\u0016J.\u00107\u001a\u00020*2\b\u00108\u001a\u0004\u0018\u00010\t2\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u000102H\u0016J*\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010=\u001a\u00020>H\u0016J\u0018\u0010?\u001a\u00020*2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u000206H\u0016J\u0018\u0010@\u001a\u00020*2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u000206H\u0016J\u0018\u0010A\u001a\u00020*2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u000206H\u0016J\u0018\u0010B\u001a\u00020*2\u0006\u0010=\u001a\u00020>2\u0006\u0010C\u001a\u00020DH\u0016J\u0018\u0010E\u001a\u00020F2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010G\u001a\u00020\tH\u0016J\u0018\u0010H\u001a\u00020*2\u0006\u00108\u001a\u00020\t2\u0006\u0010\u000b\u001a\u000202H\u0016J>\u0010I\u001a\u00020*2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000e2\u0018\u0010J\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00130\u000e2\u0006\u0010\u000b\u001a\u000202H\u0016J \u0010K\u001a\u00020*2\u0006\u00108\u001a\u00020\t2\u0006\u0010L\u001a\u00020M2\u0006\u0010\u000b\u001a\u000202H\u0016J&\u0010N\u001a\u00020*2\u0006\u00108\u001a\u00020\t2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\t0\u00132\u0006\u0010\u000b\u001a\u000202H\u0016J\u0018\u0010P\u001a\u00020*2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u00101\u001a\u000202H\u0016J\u0010\u0010Q\u001a\u00020*2\u0006\u00104\u001a\u00020\fH\u0016J\u001e\u0010R\u001a\u00020*2\u0014\u0010S\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010M0TH\u0002J\u0010\u0010U\u001a\u00020*2\b\u0010V\u001a\u0004\u0018\u00010\tJ2\u0010W\u001a\u00020*2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u000e2\u0014\u0010S\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010M0TH\u0002J\u0016\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010Y\u001a\u00020FH\u0016J\b\u0010Z\u001a\u00020FH\u0016J\u0010\u0010[\u001a\u00020F2\u0006\u0010C\u001a\u00020DH\u0016¨\u0006]"}, d2 = {"Lcom/mparticle/kits/LeanplumKit;", "Lcom/mparticle/kits/KitIntegration;", "Lcom/mparticle/kits/KitIntegration$UserAttributeListener;", "Lcom/mparticle/kits/KitIntegration$EventListener;", "Lcom/mparticle/kits/KitIntegration$CommerceListener;", "Lcom/mparticle/kits/KitIntegration$IdentityListener;", "Lcom/mparticle/kits/KitIntegration$PushListener;", "()V", "generateLeanplumId", "", "generateLeanplumUserId", "user", "Lcom/mparticle/identity/MParticleUser;", "settings", "", "userIdentities", "Lcom/mparticle/MParticle$IdentityType;", "getName", "leaveBreadcrumb", "", "Lcom/mparticle/kits/ReportingMessage;", "s", "logError", "map", "logEvent", "mpEvent", "Lcom/mparticle/MPEvent;", "event", "Lcom/mparticle/commerce/CommerceEvent;", "logException", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "logLtvIncrease", "valueIncreased", "Ljava/math/BigDecimal;", "total", "eventName", "attributes", "logScreen", "screenName", "logTransaction", "", "product", "Lcom/mparticle/commerce/Product;", "onConsentStateUpdated", "consentState", "Lcom/mparticle/consent/ConsentState;", "consentState1", "filteredMParticleUser", "Lcom/mparticle/kits/FilteredMParticleUser;", "onIdentifyCompleted", "mParticleUser", "filteredIdentityApiRequest", "Lcom/mparticle/kits/FilteredIdentityApiRequest;", "onIncrementUserAttribute", "key", "incrementedBy", "", "newValue", "onKitCreate", "context", "Landroid/content/Context;", "onLoginCompleted", "onLogoutCompleted", "onModifyCompleted", "onPushMessageReceived", "intent", "Landroid/content/Intent;", "onPushRegistration", "", "s1", "onRemoveUserAttribute", "onSetAllUserAttributes", "attributeLists", "onSetUserAttribute", "value", "", "onSetUserAttributeList", "list", "onSetUserTag", "onUserIdentified", "setAttributesAndCheckId", "userAttributes", "", "setDeviceIdType", "deviceIdType", "setLeanplumUserAttributes", "setOptOut", "optedOut", "supportsAttributeLists", "willHandlePushMessage", "Companion", "android-leanplum-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LeanplumKit extends KitIntegration implements KitIntegration.UserAttributeListener, KitIntegration.EventListener, KitIntegration.CommerceListener, KitIntegration.IdentityListener, KitIntegration.PushListener {
    private static final String APP_ID_KEY = "appId";
    private static final String CLIENT_KEY_KEY = "clientKey";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEVICE_ID_TYPE = "androidDeviceId";
    public static final String DEVICE_ID_TYPE_ANDROID_ID = "androidId";
    public static final String DEVICE_ID_TYPE_DAS = "das";
    public static final String DEVICE_ID_TYPE_GOOGLE_AD_ID = "gaid";
    public static final String LEANPLUM_EMAIL_USER_ATTRIBUTE = "email";
    public static final String NAME = "Leanplum";
    public static final String USER_ID_CUSTOMER_ID_VALUE = "customerId";
    public static final String USER_ID_EMAIL_VALUE = "email";
    public static final String USER_ID_FIELD_KEY = "userIdField";
    public static final String USER_ID_MPID_VALUE = "mpid";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/mparticle/kits/LeanplumKit$Companion;", "", "()V", "APP_ID_KEY", "", "CLIENT_KEY_KEY", "DEVICE_ID_TYPE", "DEVICE_ID_TYPE_ANDROID_ID", "DEVICE_ID_TYPE_DAS", "DEVICE_ID_TYPE_GOOGLE_AD_ID", "LEANPLUM_EMAIL_USER_ATTRIBUTE", "NAME", "USER_ID_CUSTOMER_ID_VALUE", "USER_ID_EMAIL_VALUE", "USER_ID_FIELD_KEY", "USER_ID_MPID_VALUE", "android-leanplum-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final String generateLeanplumId() {
        IdentityApi Identity;
        MParticleUser currentUser;
        boolean z10;
        MParticle instance = MParticle.getInstance();
        if (instance == null || (Identity = instance.Identity()) == null || (currentUser = Identity.getCurrentUser()) == null) {
            return null;
        }
        Map<String, String> settings = getSettings();
        j.f(settings, ModelDeeplinkData.VALUE_PAGE_SETTINGS);
        Map<MParticle.IdentityType, String> userIdentities = getUserIdentities();
        j.f(userIdentities, "userIdentities");
        String generateLeanplumUserId = generateLeanplumUserId(currentUser, settings, userIdentities);
        if (generateLeanplumUserId == null) {
            return null;
        }
        if (generateLeanplumUserId.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return null;
        }
        return generateLeanplumUserId;
    }

    private final void logTransaction(CommerceEvent commerceEvent, Product product) {
        HashMap hashMap = new HashMap();
        CommerceEventUtils.extractActionAttributes(commerceEvent, (Map<String, String>) hashMap);
        Leanplum.track(Leanplum.PURCHASE_EVENT_NAME, product.getTotalAmount(), product.getName(), hashMap);
    }

    private final void setAttributesAndCheckId(Map<String, Object> map) {
        boolean z10;
        Unit unit;
        String userId = Leanplum.getUserId();
        if (userId == null || userId.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            String generateLeanplumId = generateLeanplumId();
            if (generateLeanplumId != null) {
                Leanplum.setUserAttributes(generateLeanplumId, map);
                unit = Unit.f32013a;
            } else {
                unit = null;
            }
            if (unit == null) {
                Leanplum.setUserAttributes(map);
            }
        } else {
            Leanplum.setUserAttributes(map);
        }
        Leanplum.forceContentUpdate();
    }

    /* access modifiers changed from: private */
    public final void setLeanplumUserAttributes(Map<MParticle.IdentityType, String> map, Map<String, Object> map2) {
        if (!map2.containsKey("email")) {
            KitConfiguration configuration = getConfiguration();
            MParticle.IdentityType identityType = MParticle.IdentityType.Email;
            if (configuration.shouldSetIdentity(identityType)) {
                if (map.containsKey(identityType)) {
                    map2.put("email", map.get(identityType));
                } else {
                    map2.put("email", (Object) null);
                }
            }
        }
        setAttributesAndCheckId(map2);
    }

    public final String generateLeanplumUserId(MParticleUser mParticleUser, Map<String, String> map, Map<MParticle.IdentityType, String> map2) {
        j.g(map, ModelDeeplinkData.VALUE_PAGE_SETTINGS);
        j.g(map2, "userIdentities");
        if (r.t("customerId", map.get("userIdField"), true)) {
            KitConfiguration configuration = getConfiguration();
            MParticle.IdentityType identityType = MParticle.IdentityType.CustomerId;
            if (configuration.shouldSetIdentity(identityType)) {
                return map2.get(identityType);
            }
        }
        if (r.t("email", map.get("userIdField"), true)) {
            KitConfiguration configuration2 = getConfiguration();
            MParticle.IdentityType identityType2 = MParticle.IdentityType.Email;
            if (configuration2.shouldSetIdentity(identityType2)) {
                return map2.get(identityType2);
            }
        }
        if (!r.t("mpid", map.get("userIdField"), true) || mParticleUser == null) {
            return null;
        }
        return String.valueOf(mParticleUser.getId());
    }

    public String getName() {
        return NAME;
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
        Leanplum.track(mPEvent.getEventName(), (Map<String, ?>) mPEvent.getCustomAttributes());
        return p.e(ReportingMessage.fromEvent(this, mPEvent));
    }

    public List<ReportingMessage> logException(Exception exc, Map<String, String> map, String str) {
        j.g(exc, ReportingMessage.MessageType.EVENT);
        j.g(map, "map");
        j.g(str, "s");
        return q.j();
    }

    public List<ReportingMessage> logLtvIncrease(BigDecimal bigDecimal, BigDecimal bigDecimal2, String str, Map<String, String> map) {
        j.g(bigDecimal, "valueIncreased");
        j.g(bigDecimal2, "total");
        j.g(str, "eventName");
        j.g(map, "attributes");
        Leanplum.track(str, bigDecimal.doubleValue(), (Map<String, ?>) map);
        return p.e(ReportingMessage.fromEvent(this, new MPEvent.Builder(str, MParticle.EventType.Transaction).customAttributes(map).build()));
    }

    public List<ReportingMessage> logScreen(String str, Map<String, String> map) {
        j.g(str, "screenName");
        j.g(map, "attributes");
        Leanplum.advanceTo(str, (Map<String, ?>) map);
        return p.e(new ReportingMessage(this, ReportingMessage.MessageType.SCREEN_VIEW, System.currentTimeMillis(), map));
    }

    public void onConsentStateUpdated(ConsentState consentState, ConsentState consentState2, FilteredMParticleUser filteredMParticleUser) {
        j.g(consentState, "consentState");
        j.g(consentState2, "consentState1");
        j.g(filteredMParticleUser, "filteredMParticleUser");
    }

    public void onIdentifyCompleted(MParticleUser mParticleUser, FilteredIdentityApiRequest filteredIdentityApiRequest) {
        j.g(mParticleUser, "mParticleUser");
        j.g(filteredIdentityApiRequest, "filteredIdentityApiRequest");
    }

    public void onIncrementUserAttribute(String str, Number number, String str2, FilteredMParticleUser filteredMParticleUser) {
        j.g(str2, "newValue");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("16843240", str2);
        setAttributesAndCheckId(linkedHashMap);
    }

    public List<ReportingMessage> onKitCreate(Map<String, String> map, Context context) {
        MParticle.Environment environment;
        IdentityApi Identity;
        MParticleUser currentUser;
        j.g(map, ModelDeeplinkData.VALUE_PAGE_SETTINGS);
        j.g(context, IdentityHttpResponse.CONTEXT);
        String str = map.get(DEVICE_ID_TYPE);
        String generateLeanplumId = generateLeanplumId();
        if (str != null) {
            setDeviceIdType(str);
        }
        MParticle instance = MParticle.getInstance();
        if (instance != null) {
            environment = instance.getEnvironment();
        } else {
            environment = null;
        }
        if (environment == MParticle.Environment.Development) {
            Leanplum.setLogLevel(3);
            Leanplum.setAppIdForDevelopmentMode(map.get("appId"), map.get("clientKey"));
        } else {
            Leanplum.setAppIdForProductionMode(map.get("appId"), map.get("clientKey"));
        }
        Leanplum.start(context, generateLeanplumId);
        Context applicationContext = context.getApplicationContext();
        j.e(applicationContext, "null cannot be cast to non-null type android.app.Application");
        LeanplumActivityHelper.enableLifecycleCallbacks((Application) applicationContext);
        MParticle instance2 = MParticle.getInstance();
        if (!(instance2 == null || (Identity = instance2.Identity()) == null || (currentUser = Identity.getCurrentUser()) == null)) {
            currentUser.getUserAttributes();
        }
        return p.e(new ReportingMessage(this, ReportingMessage.MessageType.APP_STATE_TRANSITION, System.currentTimeMillis(), (Map<String, ?>) null));
    }

    public void onLoginCompleted(MParticleUser mParticleUser, FilteredIdentityApiRequest filteredIdentityApiRequest) {
        j.g(mParticleUser, "mParticleUser");
        j.g(filteredIdentityApiRequest, "filteredIdentityApiRequest");
    }

    public void onLogoutCompleted(MParticleUser mParticleUser, FilteredIdentityApiRequest filteredIdentityApiRequest) {
        j.g(mParticleUser, "mParticleUser");
        j.g(filteredIdentityApiRequest, "filteredIdentityApiRequest");
    }

    public void onModifyCompleted(MParticleUser mParticleUser, FilteredIdentityApiRequest filteredIdentityApiRequest) {
        j.g(mParticleUser, "mParticleUser");
        j.g(filteredIdentityApiRequest, "filteredIdentityApiRequest");
    }

    public void onPushMessageReceived(Context context, Intent intent) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        j.g(intent, SDKConstants.PARAM_INTENT);
    }

    public boolean onPushRegistration(String str, String str2) {
        j.g(str, "s");
        j.g(str2, "s1");
        return false;
    }

    public void onRemoveUserAttribute(String str, FilteredMParticleUser filteredMParticleUser) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(filteredMParticleUser, "user");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(str, (Object) null);
        setAttributesAndCheckId(linkedHashMap);
    }

    public void onSetAllUserAttributes(Map<String, String> map, Map<String, ? extends List<String>> map2, FilteredMParticleUser filteredMParticleUser) {
        j.g(map, "attributes");
        j.g(map2, "attributeLists");
        j.g(filteredMParticleUser, "user");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(map);
        linkedHashMap.putAll(map2);
        setAttributesAndCheckId(linkedHashMap);
    }

    public void onSetUserAttribute(String str, Object obj, FilteredMParticleUser filteredMParticleUser) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(obj, "value");
        j.g(filteredMParticleUser, "user");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(str, obj);
        setAttributesAndCheckId(linkedHashMap);
    }

    public void onSetUserAttributeList(String str, List<String> list, FilteredMParticleUser filteredMParticleUser) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(list, "list");
        j.g(filteredMParticleUser, "user");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(str, list);
        setAttributesAndCheckId(linkedHashMap);
    }

    public void onSetUserTag(String str, FilteredMParticleUser filteredMParticleUser) {
        j.g(str, "s");
        j.g(filteredMParticleUser, "filteredMParticleUser");
    }

    public void onUserIdentified(MParticleUser mParticleUser) {
        j.g(mParticleUser, "mParticleUser");
        Map<MParticle.IdentityType, String> userIdentities = mParticleUser.getUserIdentities();
        j.f(userIdentities, "mParticleUser.userIdentities");
        Map<String, String> settings = getSettings();
        j.f(settings, ModelDeeplinkData.VALUE_PAGE_SETTINGS);
        String generateLeanplumUserId = generateLeanplumUserId(mParticleUser, settings, userIdentities);
        if (!KitUtils.isEmpty(generateLeanplumUserId)) {
            Leanplum.setUserId(generateLeanplumUserId);
        }
        try {
            mParticleUser.getUserAttributes(new LeanplumKit$onUserIdentified$1(this, userIdentities));
        } catch (Exception e10) {
            Logger.warning(e10, "Unable to fetch User Attributes");
        }
    }

    public final void setDeviceIdType(String str) {
        String str2;
        IdentityApi Identity;
        if (j.b(DEVICE_ID_TYPE_ANDROID_ID, str) && MParticle.isAndroidIdEnabled()) {
            Leanplum.setDeviceIdMode(LeanplumDeviceIdMode.ANDROID_ID);
        } else if (j.b(DEVICE_ID_TYPE_GOOGLE_AD_ID, str)) {
            Leanplum.setDeviceIdMode(LeanplumDeviceIdMode.ADVERTISING_ID);
        } else if (j.b(DEVICE_ID_TYPE_DAS, str)) {
            MParticle instance = MParticle.getInstance();
            if (instance == null || (Identity = instance.Identity()) == null) {
                str2 = null;
            } else {
                str2 = Identity.getDeviceApplicationStamp();
            }
            Leanplum.setDeviceId(str2);
        }
    }

    public List<ReportingMessage> setOptOut(boolean z10) {
        return q.j();
    }

    public boolean supportsAttributeLists() {
        return true;
    }

    public boolean willHandlePushMessage(Intent intent) {
        j.g(intent, SDKConstants.PARAM_INTENT);
        Bundle extras = intent.getExtras();
        if (extras != null) {
            return extras.containsKey(Constants.Keys.PUSH_VERSION);
        }
        return false;
    }

    public List<ReportingMessage> logEvent(CommerceEvent commerceEvent) {
        j.g(commerceEvent, "event");
        LinkedList linkedList = new LinkedList();
        if (!KitUtils.isEmpty(commerceEvent.getProductAction()) && r.t(commerceEvent.getProductAction(), "purchase", true)) {
            List<Product> products = commerceEvent.getProducts();
            if (!(products == null || products.isEmpty())) {
                List<Product> products2 = commerceEvent.getProducts();
                if (products2 != null) {
                    for (Product next : products2) {
                        j.f(next, "product");
                        logTransaction(commerceEvent, next);
                    }
                }
                linkedList.add(ReportingMessage.fromEvent(this, commerceEvent));
                return linkedList;
            }
        }
        List<MPEvent> expand = CommerceEventUtils.expand(commerceEvent);
        if (expand != null) {
            int size = expand.size();
            for (int i10 = 0; i10 < size; i10++) {
                try {
                    MPEvent mPEvent = expand.get(i10);
                    j.f(mPEvent, "eventList[i]");
                    logEvent(mPEvent);
                    linkedList.add(ReportingMessage.fromEvent(this, commerceEvent));
                } catch (Exception e10) {
                    Logger.warning("Failed to call track to Leanplum kit: " + e10);
                }
            }
        }
        return linkedList;
    }
}
