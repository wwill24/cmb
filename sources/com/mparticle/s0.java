package com.mparticle;

import gk.h;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.j;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012JO\u0010\n\u001a\u00020\t2\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00022\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\n\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/mparticle/s0;", "", "", "", "singles", "", "lists", "", "mpid", "", "a", "(Ljava/util/Map;Ljava/util/Map;Ljava/lang/Long;)V", "Lcom/mparticle/UserAttributeListenerType;", "Lcom/mparticle/UserAttributeListenerType;", "getListener", "()Lcom/mparticle/UserAttributeListenerType;", "listener", "<init>", "(Lcom/mparticle/UserAttributeListenerType;)V", "android-core_release"}, k = 1, mv = {1, 7, 1})
public final class s0 {

    /* renamed from: a  reason: collision with root package name */
    private final UserAttributeListenerType f22634a;

    public s0(UserAttributeListenerType userAttributeListenerType) {
        j.g(userAttributeListenerType, "listener");
        this.f22634a = userAttributeListenerType;
    }

    public final void a(Map<String, ? extends Object> map, Map<String, ? extends List<String>> map2, Long l10) {
        String str;
        UserAttributeListenerType userAttributeListenerType = this.f22634a;
        if (userAttributeListenerType instanceof UserAttributeListener) {
            if (map == null) {
                map = new LinkedHashMap<>();
            }
            Set<Map.Entry<String, ? extends Object>> entrySet = map.entrySet();
            LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(entrySet, 10)), 16));
            for (Map.Entry entry : entrySet) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (value != null) {
                    str = value.toString();
                } else {
                    str = null;
                }
                Pair a10 = h.a(key, str);
                linkedHashMap.put(a10.c(), a10.d());
            }
            ((UserAttributeListener) this.f22634a).onUserAttributesReceived(linkedHashMap, map2, l10);
        } else if ((userAttributeListenerType instanceof TypedUserAttributeListener) && l10 != null) {
            long longValue = l10.longValue();
            TypedUserAttributeListener typedUserAttributeListener = (TypedUserAttributeListener) this.f22634a;
            if (map == null) {
                map = new LinkedHashMap<>();
            }
            if (map2 == null) {
                map2 = new LinkedHashMap<>();
            }
            typedUserAttributeListener.onUserAttributesReceived(map, map2, longValue);
        }
    }
}
