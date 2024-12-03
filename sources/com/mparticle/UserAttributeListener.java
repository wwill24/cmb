package com.mparticle;

import java.util.List;
import java.util.Map;

@Deprecated
public interface UserAttributeListener extends UserAttributeListenerType {
    void onUserAttributesReceived(Map<String, String> map, Map<String, List<String>> map2, Long l10);
}
