package com.mparticle.kits;

import com.mparticle.MParticle;
import com.mparticle.identity.IdentityApiRequest;
import java.util.HashMap;
import java.util.Map;

public class FilteredIdentityApiRequest {
    KitIntegration provider;
    Map<MParticle.IdentityType, String> userIdentities = new HashMap();

    FilteredIdentityApiRequest(IdentityApiRequest identityApiRequest, KitIntegration kitIntegration) {
        if (identityApiRequest != null) {
            this.userIdentities = new HashMap(identityApiRequest.getUserIdentities());
            if (kitIntegration.getKitManager() != null) {
                this.userIdentities = kitIntegration.getKitManager().getDataplanFilter().transformIdentities(this.userIdentities);
            }
        }
        this.provider = kitIntegration;
    }

    @Deprecated
    public Map<MParticle.IdentityType, String> getNewIdentities() {
        return getUserIdentities();
    }

    public Map<MParticle.IdentityType, String> getUserIdentities() {
        Map<MParticle.IdentityType, String> map = this.userIdentities;
        HashMap hashMap = new HashMap(map.size());
        for (Map.Entry next : map.entrySet()) {
            if (this.provider.getConfiguration().shouldSetIdentity((MParticle.IdentityType) next.getKey())) {
                hashMap.put((MParticle.IdentityType) next.getKey(), (String) next.getValue());
            }
        }
        return hashMap;
    }
}
