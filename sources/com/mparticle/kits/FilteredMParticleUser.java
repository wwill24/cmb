package com.mparticle.kits;

import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import com.mparticle.MParticle;
import com.mparticle.TypedUserAttributeListener;
import com.mparticle.UserAttributeListener;
import com.mparticle.UserAttributeListenerType;
import com.mparticle.consent.ConsentState;
import com.mparticle.identity.MParticleUser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilteredMParticleUser implements MParticleUser {
    MParticleUser mpUser;
    KitIntegration provider;

    private FilteredMParticleUser(MParticleUser mParticleUser, KitIntegration kitIntegration) {
        this.mpUser = mParticleUser;
        this.provider = kitIntegration;
    }

    static FilteredMParticleUser getInstance(MParticleUser mParticleUser, KitIntegration kitIntegration) {
        if (mParticleUser != null) {
            return new FilteredMParticleUser(mParticleUser, kitIntegration);
        }
        return null;
    }

    public ConsentState getConsentState() {
        return null;
    }

    public long getFirstSeenTime() {
        return this.mpUser.getFirstSeenTime();
    }

    public long getId() {
        return this.mpUser.getId();
    }

    public long getLastSeenTime() {
        return this.mpUser.getLastSeenTime();
    }

    public Map<String, Object> getUserAttributes() {
        Map userAttributes = this.mpUser.getUserAttributes();
        KitManagerImpl kitManager = this.provider.getKitManager();
        if (kitManager != null) {
            userAttributes = kitManager.getDataplanFilter().transformUserAttributes(userAttributes);
        }
        return KitConfiguration.filterAttributes(this.provider.getConfiguration().getUserAttributeFilters(), userAttributes);
    }

    public Map<MParticle.IdentityType, String> getUserIdentities() {
        Map<MParticle.IdentityType, String> userIdentities = this.mpUser.getUserIdentities();
        KitManagerImpl kitManager = this.provider.getKitManager();
        if (kitManager != null) {
            userIdentities = kitManager.getDataplanFilter().transformIdentities(userIdentities);
        }
        HashMap hashMap = new HashMap(userIdentities.size());
        for (Map.Entry next : userIdentities.entrySet()) {
            if (this.provider.getConfiguration().shouldSetIdentity((MParticle.IdentityType) next.getKey())) {
                hashMap.put((MParticle.IdentityType) next.getKey(), (String) next.getValue());
            }
        }
        return hashMap;
    }

    public boolean incrementUserAttribute(String str, Number number) {
        return false;
    }

    public boolean isLoggedIn() {
        return this.mpUser.isLoggedIn();
    }

    public boolean removeUserAttribute(String str) {
        return false;
    }

    public void setConsentState(ConsentState consentState) {
    }

    public boolean setUserAttribute(String str, Object obj) {
        return false;
    }

    public boolean setUserAttributeList(String str, Object obj) {
        return false;
    }

    public boolean setUserAttributes(Map<String, Object> map) {
        return false;
    }

    public boolean setUserTag(String str) {
        return false;
    }

    static FilteredMParticleUser getInstance(long j10, KitIntegration kitIntegration) {
        MParticleUser user;
        MParticle instance = MParticle.getInstance();
        if (instance == null || (user = instance.Identity().getUser(Long.valueOf(j10))) == null) {
            return null;
        }
        return new FilteredMParticleUser(user, kitIntegration);
    }

    public Map<String, Object> getUserAttributes(final UserAttributeListenerType userAttributeListenerType) {
        return this.mpUser.getUserAttributes(new TypedUserAttributeListener() {
            public void onUserAttributesReceived(@NonNull Map<String, ?> map, @NonNull Map<String, ? extends List<String>> map2, long j10) {
                KitManagerImpl kitManager = FilteredMParticleUser.this.provider.getKitManager();
                Map<String, T> map3 = map;
                Map<String, T> map4 = map2;
                if (kitManager != null) {
                    map3 = kitManager.getDataplanFilter().transformUserAttributes(map);
                    map4 = kitManager.getDataplanFilter().transformUserAttributes(map2);
                }
                SparseBooleanArray userAttributeFilters = FilteredMParticleUser.this.provider.getConfiguration().getUserAttributeFilters();
                HashMap hashMap = map3;
                if (map3 == null) {
                    hashMap = new HashMap();
                }
                if (userAttributeListenerType instanceof UserAttributeListener) {
                    HashMap hashMap2 = new HashMap();
                    for (Map.Entry next : hashMap.entrySet()) {
                        if (next.getValue() != null) {
                            hashMap2.put((String) next.getKey(), next.getValue().toString());
                        } else {
                            hashMap2.put((String) next.getKey(), (Object) null);
                        }
                    }
                    ((UserAttributeListener) userAttributeListenerType).onUserAttributesReceived(KitConfiguration.filterAttributes(userAttributeFilters, hashMap2), KitConfiguration.filterAttributes(userAttributeFilters, map4), Long.valueOf(j10));
                }
                UserAttributeListenerType userAttributeListenerType = userAttributeListenerType;
                if (userAttributeListenerType instanceof TypedUserAttributeListener) {
                    ((TypedUserAttributeListener) userAttributeListenerType).onUserAttributesReceived(KitConfiguration.filterAttributes(userAttributeFilters, hashMap), KitConfiguration.filterAttributes(userAttributeFilters, map4), j10);
                }
            }
        });
    }
}
