package com.mparticle.kits;

import com.mparticle.BaseEvent;
import com.mparticle.MParticle;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0007H&J#\u0010\b\u001a\u0004\u0018\u0001H\t\"\b\b\u0000\u0010\t*\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u0001H\tH&¢\u0006\u0002\u0010\fJ0\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000e2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u000eH&J2\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\t\u0018\u00010\u000e\"\u0004\b\u0000\u0010\t2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\t\u0018\u00010\u000eH&¨\u0006\u0012"}, d2 = {"Lcom/mparticle/kits/DataplanFilter;", "", "isUserAttributeBlocked", "", "key", "", "isUserIdentityBlocked", "Lcom/mparticle/MParticle$IdentityType;", "transformEventForEvent", "T", "Lcom/mparticle/BaseEvent;", "event", "(Lcom/mparticle/BaseEvent;)Lcom/mparticle/BaseEvent;", "transformIdentities", "", "identities", "transformUserAttributes", "attributes", "android-kit-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface DataplanFilter {
    boolean isUserAttributeBlocked(String str);

    boolean isUserIdentityBlocked(MParticle.IdentityType identityType);

    <T extends BaseEvent> T transformEventForEvent(T t10);

    Map<MParticle.IdentityType, String> transformIdentities(Map<MParticle.IdentityType, String> map);

    <T> Map<String, T> transformUserAttributes(Map<String, ? extends T> map);
}
