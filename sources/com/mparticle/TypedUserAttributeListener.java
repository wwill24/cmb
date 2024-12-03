package com.mparticle;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001JD\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\t0\u00052\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/mparticle/TypedUserAttributeListener;", "Lcom/mparticle/UserAttributeListenerType;", "onUserAttributesReceived", "", "userAttributes", "", "", "", "userAttributeLists", "", "mpid", "", "android-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface TypedUserAttributeListener extends UserAttributeListenerType {
    void onUserAttributesReceived(Map<String, ? extends Object> map, Map<String, ? extends List<String>> map2, long j10);
}
