package com.mparticle.kits;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.mparticle.BaseEvent;
import com.mparticle.MPEvent;
import com.mparticle.MParticle;
import com.mparticle.commerce.CommerceEvent;
import com.mparticle.consent.ConsentState;
import com.mparticle.identity.MParticleUser;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.b;

public abstract class KitIntegration {
    private static final String KIT_PREFERENCES_FILE = "mp::kit::";
    private KitManagerImpl kitManager;
    private KitConfiguration mKitConfiguration;

    public interface ActivityListener {
        List<ReportingMessage> onActivityCreated(Activity activity, Bundle bundle);

        List<ReportingMessage> onActivityDestroyed(Activity activity);

        List<ReportingMessage> onActivityPaused(Activity activity);

        List<ReportingMessage> onActivityResumed(Activity activity);

        List<ReportingMessage> onActivitySaveInstanceState(Activity activity, Bundle bundle);

        List<ReportingMessage> onActivityStarted(Activity activity);

        List<ReportingMessage> onActivityStopped(Activity activity);
    }

    public interface ApplicationStateListener {
        void onApplicationBackground();

        void onApplicationForeground();
    }

    @Deprecated
    public interface AttributeListener {
        List<ReportingMessage> logout();

        void removeUserAttribute(String str);

        void removeUserIdentity(MParticle.IdentityType identityType);

        void setAllUserAttributes(Map<String, String> map, Map<String, List<String>> map2);

        void setUserAttribute(String str, String str2);

        void setUserAttributeList(String str, List<String> list);

        void setUserIdentity(MParticle.IdentityType identityType, String str);

        boolean supportsAttributeLists();
    }

    public interface BatchListener {
        List<ReportingMessage> logBatch(b bVar);
    }

    public interface CommerceListener {
        List<ReportingMessage> logEvent(CommerceEvent commerceEvent);

        List<ReportingMessage> logLtvIncrease(BigDecimal bigDecimal, BigDecimal bigDecimal2, String str, Map<String, String> map);
    }

    public interface EventListener {
        List<ReportingMessage> leaveBreadcrumb(String str);

        List<ReportingMessage> logError(String str, Map<String, String> map);

        List<ReportingMessage> logEvent(MPEvent mPEvent);

        List<ReportingMessage> logException(Exception exc, Map<String, String> map, String str);

        List<ReportingMessage> logScreen(String str, Map<String, String> map);
    }

    public interface IdentityListener {
        void onIdentifyCompleted(MParticleUser mParticleUser, FilteredIdentityApiRequest filteredIdentityApiRequest);

        void onLoginCompleted(MParticleUser mParticleUser, FilteredIdentityApiRequest filteredIdentityApiRequest);

        void onLogoutCompleted(MParticleUser mParticleUser, FilteredIdentityApiRequest filteredIdentityApiRequest);

        void onModifyCompleted(MParticleUser mParticleUser, FilteredIdentityApiRequest filteredIdentityApiRequest);

        void onUserIdentified(MParticleUser mParticleUser);
    }

    public interface PushListener {
        void onPushMessageReceived(Context context, Intent intent);

        boolean onPushRegistration(String str, String str2);

        boolean willHandlePushMessage(Intent intent);
    }

    public interface SessionListener {
        List<ReportingMessage> onSessionEnd();

        List<ReportingMessage> onSessionStart();
    }

    public interface UserAttributeListener {
        void onConsentStateUpdated(ConsentState consentState, ConsentState consentState2, FilteredMParticleUser filteredMParticleUser);

        void onIncrementUserAttribute(String str, Number number, String str2, FilteredMParticleUser filteredMParticleUser);

        void onRemoveUserAttribute(String str, FilteredMParticleUser filteredMParticleUser);

        void onSetAllUserAttributes(Map<String, String> map, Map<String, List<String>> map2, FilteredMParticleUser filteredMParticleUser);

        void onSetUserAttribute(String str, Object obj, FilteredMParticleUser filteredMParticleUser);

        void onSetUserAttributeList(String str, List<String> list, FilteredMParticleUser filteredMParticleUser);

        void onSetUserTag(String str, FilteredMParticleUser filteredMParticleUser);

        boolean supportsAttributeLists();
    }

    /* access modifiers changed from: protected */
    public final void clearIntegrationAttributes() {
        getKitManager().clearIntegrationAttributes(this);
    }

    public void executeNetworkRequest(Runnable runnable) {
        getKitManager().runOnKitThread(runnable);
    }

    @Deprecated
    public final Map<String, Object> getAllUserAttributes() {
        MParticleUser currentUser;
        MParticle instance = MParticle.getInstance();
        if (instance == null || (currentUser = instance.Identity().getCurrentUser()) == null) {
            return new HashMap();
        }
        Map userAttributes = currentUser.getUserAttributes();
        KitManagerImpl kitManagerImpl = this.kitManager;
        if (kitManagerImpl != null) {
            userAttributes = kitManagerImpl.getDataplanFilter().transformUserAttributes(userAttributes);
        }
        Map<String, ?> filterAttributes = KitConfiguration.filterAttributes(getConfiguration().getUserAttributeFilters(), userAttributes);
        if ((this instanceof AttributeListener) && ((AttributeListener) this).supportsAttributeLists()) {
            return filterAttributes;
        }
        for (Map.Entry next : filterAttributes.entrySet()) {
            if (next.getValue() instanceof List) {
                filterAttributes.put((String) next.getKey(), KitUtils.join((List) next.getValue()));
            }
        }
        return filterAttributes;
    }

    public KitConfiguration getConfiguration() {
        return this.mKitConfiguration;
    }

    public final Context getContext() {
        return this.kitManager.getContext();
    }

    public final WeakReference<Activity> getCurrentActivity() {
        return this.kitManager.getCurrentActivity();
    }

    public final MParticleUser getCurrentUser() {
        MParticle instance = MParticle.getInstance();
        if (instance != null) {
            return FilteredMParticleUser.getInstance(instance.Identity().getCurrentUser(), this);
        }
        return FilteredMParticleUser.getInstance((MParticleUser) null, this);
    }

    public Object getInstance() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final Map<String, String> getIntegrationAttributes() {
        return getKitManager().getIntegrationAttributes(this);
    }

    public b getJsonConfig() {
        KitConfiguration kitConfiguration = this.mKitConfiguration;
        if (kitConfiguration != null) {
            return kitConfiguration.convertToJsonObject();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final KitManagerImpl getKitManager() {
        return this.kitManager;
    }

    /* access modifiers changed from: protected */
    public final SharedPreferences getKitPreferences() {
        Context context = getContext();
        return context.getSharedPreferences(KIT_PREFERENCES_FILE + getConfiguration().getKitId(), 0);
    }

    public abstract String getName();

    public final Map<String, String> getSettings() {
        return getConfiguration().getSettings();
    }

    public Uri getSurveyUrl(Map<String, String> map, Map<String, List<String>> map2) {
        return null;
    }

    public final MParticleUser getUser(Long l10) {
        MParticle instance = MParticle.getInstance();
        if (instance != null) {
            return FilteredMParticleUser.getInstance(instance.Identity().getUser(l10), this);
        }
        return FilteredMParticleUser.getInstance((MParticleUser) null, this);
    }

    @Deprecated
    public final Map<MParticle.IdentityType, String> getUserIdentities() {
        MParticleUser currentUser;
        MParticle instance = MParticle.getInstance();
        if (instance == null || (currentUser = instance.Identity().getCurrentUser()) == null) {
            return new HashMap();
        }
        Map<MParticle.IdentityType, String> transformIdentities = getKitManager().getDataplanFilter().transformIdentities(currentUser.getUserIdentities());
        HashMap hashMap = new HashMap(transformIdentities.size());
        for (Map.Entry next : transformIdentities.entrySet()) {
            if (getConfiguration().shouldSetIdentity((MParticle.IdentityType) next.getKey())) {
                hashMap.put((MParticle.IdentityType) next.getKey(), (String) next.getValue());
            }
        }
        return transformIdentities;
    }

    /* access modifiers changed from: protected */
    public final boolean isBackgrounded() {
        return this.kitManager.isBackgrounded();
    }

    public boolean isDisabled() {
        return isDisabled(false);
    }

    public List<ReportingMessage> logBaseEvent(@NonNull BaseEvent baseEvent) {
        return Collections.emptyList();
    }

    public List<ReportingMessage> logEvent(@NonNull MPEvent mPEvent) {
        return Collections.emptyList();
    }

    /* access modifiers changed from: package-private */
    public List<ReportingMessage> logNetworkPerformance(String str, long j10, String str2, long j11, long j12, long j13, String str3, int i10) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void onKitCleanup() {
        try {
            Map<String, ?> all = getKitPreferences().getAll();
            if (all != null && all.size() > 0) {
                getKitPreferences().edit().clear().apply();
            }
        } catch (NullPointerException unused) {
        }
    }

    /* access modifiers changed from: protected */
    public abstract List<ReportingMessage> onKitCreate(Map<String, String> map, Context context) throws IllegalArgumentException;

    /* access modifiers changed from: protected */
    public void onKitDestroy() {
    }

    public void onSettingsUpdated(Map<String, String> map) {
    }

    /* access modifiers changed from: protected */
    public void reset() {
    }

    public final KitIntegration setConfiguration(KitConfiguration kitConfiguration) {
        this.mKitConfiguration = kitConfiguration;
        return this;
    }

    public void setInstallReferrer(Intent intent) {
    }

    /* access modifiers changed from: protected */
    public final void setIntegrationAttributes(Map<String, String> map) {
        getKitManager().setIntegrationAttributes(this, map);
    }

    public final KitIntegration setKitManager(KitManagerImpl kitManagerImpl) {
        this.kitManager = kitManagerImpl;
        return this;
    }

    public void setLocation(Location location) {
    }

    public abstract List<ReportingMessage> setOptOut(boolean z10);

    public boolean isDisabled(boolean z10) {
        return !getConfiguration().passesBracketing(this.kitManager.getUserBucket()) || (getConfiguration().shouldHonorOptOut() && this.kitManager.isOptedOut() && !z10);
    }
}
