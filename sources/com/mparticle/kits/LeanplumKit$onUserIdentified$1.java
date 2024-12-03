package com.mparticle.kits;

import com.leanplum.internal.Constants;
import com.mparticle.MParticle;
import com.mparticle.TypedUserAttributeListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.j;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t0\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/mparticle/kits/LeanplumKit$onUserIdentified$1", "Lcom/mparticle/TypedUserAttributeListener;", "onUserAttributesReceived", "", "userAttributes", "", "", "", "userAttributeLists", "", "mpid", "", "android-leanplum-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LeanplumKit$onUserIdentified$1 implements TypedUserAttributeListener {
    final /* synthetic */ Map<MParticle.IdentityType, String> $userIdentities;
    final /* synthetic */ LeanplumKit this$0;

    LeanplumKit$onUserIdentified$1(LeanplumKit leanplumKit, Map<MParticle.IdentityType, String> map) {
        this.this$0 = leanplumKit;
        this.$userIdentities = map;
    }

    public void onUserAttributesReceived(Map<String, ? extends Object> map, Map<String, ? extends List<String>> map2, long j10) {
        j.g(map, Constants.Params.USER_ATTRIBUTES);
        j.g(map2, "userAttributeLists");
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.putAll(map2);
        this.this$0.setLeanplumUserAttributes(this.$userIdentities, hashMap);
    }
}
