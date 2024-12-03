package com.mparticle.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.mparticle.AttributionResult;
import com.mparticle.BaseEvent;
import com.mparticle.MPEvent;
import com.mparticle.MParticle;
import com.mparticle.MParticleOptions;
import com.mparticle.consent.ConsentState;
import com.mparticle.identity.IdentityApiRequest;
import com.mparticle.identity.MParticleUser;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.a;

public interface KitManager {

    public enum KitStatus {
        NOT_CONFIGURED,
        STOPPED,
        ACTIVE
    }

    Map<Integer, AttributionResult> getAttributionResults();

    WeakReference<Activity> getCurrentActivity();

    Object getKitInstance(int i10);

    @NonNull
    Map<Integer, KitStatus> getKitStatus();

    Set<Integer> getSupportedKits();

    Uri getSurveyUrl(int i10, Map<String, String> map, Map<String, List<String>> map2);

    void incrementUserAttribute(String str, Number number, String str2, long j10);

    void installReferrerUpdated();

    boolean isKitActive(int i10);

    void leaveBreadcrumb(String str);

    void logBatch(String str);

    void logError(String str, Map<String, String> map);

    void logEvent(BaseEvent baseEvent);

    void logException(Exception exc, Map<String, String> map, String str);

    void logNetworkPerformance(String str, long j10, String str2, long j11, long j12, long j13, String str3, int i10);

    void logScreen(MPEvent mPEvent);

    void logout();

    void onActivityCreated(Activity activity, Bundle bundle);

    void onActivityDestroyed(Activity activity);

    void onActivityPaused(Activity activity);

    void onActivityResumed(Activity activity);

    void onActivitySaveInstanceState(Activity activity, Bundle bundle);

    void onActivityStarted(Activity activity);

    void onActivityStopped(Activity activity);

    void onApplicationBackground();

    void onApplicationForeground();

    void onConsentStateUpdated(ConsentState consentState, ConsentState consentState2, long j10);

    void onIdentifyCompleted(MParticleUser mParticleUser, IdentityApiRequest identityApiRequest);

    void onLoginCompleted(MParticleUser mParticleUser, IdentityApiRequest identityApiRequest);

    void onLogoutCompleted(MParticleUser mParticleUser, IdentityApiRequest identityApiRequest);

    boolean onMessageReceived(Context context, Intent intent);

    void onModifyCompleted(MParticleUser mParticleUser, IdentityApiRequest identityApiRequest);

    boolean onPushRegistration(String str, String str2);

    void onSessionEnd();

    void onSessionStart();

    void removeUserAttribute(String str, long j10);

    void removeUserIdentity(MParticle.IdentityType identityType);

    void reset();

    void setLocation(Location location);

    void setOptOut(boolean z10);

    void setUserAttribute(String str, String str2, long j10);

    void setUserAttributeList(String str, List<String> list, long j10);

    void setUserIdentity(String str, MParticle.IdentityType identityType);

    void setUserTag(String str, long j10);

    void updateDataplan(@NonNull MParticleOptions.DataplanOptions dataplanOptions);

    KitsLoadedCallback updateKits(a aVar);
}
