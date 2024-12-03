package com.facebook.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/facebook/internal/ProfileInformationCache;", "", "", "accessToken", "Lorg/json/b;", "getProfileInformation", "key", "value", "", "putProfileInformation", "Ljava/util/concurrent/ConcurrentHashMap;", "infoCache", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class ProfileInformationCache {
    public static final ProfileInformationCache INSTANCE = new ProfileInformationCache();
    private static final ConcurrentHashMap<String, b> infoCache = new ConcurrentHashMap<>();

    private ProfileInformationCache() {
    }

    public static final b getProfileInformation(String str) {
        j.g(str, SDKConstants.PARAM_ACCESS_TOKEN);
        return infoCache.get(str);
    }

    public static final void putProfileInformation(String str, b bVar) {
        j.g(str, SDKConstants.PARAM_KEY);
        j.g(bVar, "value");
        infoCache.put(str, bVar);
    }
}
