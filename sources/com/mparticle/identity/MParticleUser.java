package com.mparticle.identity;

import androidx.annotation.NonNull;
import com.mparticle.MParticle;
import com.mparticle.UserAttributeListenerType;
import com.mparticle.consent.ConsentState;
import java.util.Map;

public interface MParticleUser {
    @NonNull
    ConsentState getConsentState();

    long getFirstSeenTime();

    @NonNull
    long getId();

    long getLastSeenTime();

    @NonNull
    Map<String, Object> getUserAttributes();

    Map<String, Object> getUserAttributes(UserAttributeListenerType userAttributeListenerType);

    @NonNull
    Map<MParticle.IdentityType, String> getUserIdentities();

    boolean incrementUserAttribute(@NonNull String str, Number number);

    boolean isLoggedIn();

    boolean removeUserAttribute(@NonNull String str);

    void setConsentState(ConsentState consentState);

    boolean setUserAttribute(@NonNull String str, @NonNull Object obj);

    boolean setUserAttributeList(@NonNull String str, @NonNull Object obj);

    boolean setUserAttributes(@NonNull Map<String, Object> map);

    boolean setUserTag(@NonNull String str);
}
