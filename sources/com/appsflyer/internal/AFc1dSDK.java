package com.appsflyer.internal;

import androidx.annotation.NonNull;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AFc1dSDK<Body> implements ResponseNetwork<Body> {
    final int AFInAppEventParameterName;
    @NonNull
    public final AFc1jSDK AFInAppEventType;
    @NonNull
    private final Body AFKeystoreWrapper;
    @NonNull
    final Map<String, List<String>> valueOf;
    final boolean values;

    public AFc1dSDK(@NonNull Body body, int i10, boolean z10, Map<String, List<String>> map, @NonNull AFc1jSDK aFc1jSDK) {
        this.AFKeystoreWrapper = body;
        this.AFInAppEventParameterName = i10;
        this.values = z10;
        this.valueOf = new HashMap(map);
        this.AFInAppEventType = aFc1jSDK;
    }

    public final String AFInAppEventType(@NonNull String str) {
        List<String> headerField = getHeaderField(str);
        if (headerField == null || headerField.isEmpty()) {
            return null;
        }
        Iterator<String> it = headerField.iterator();
        StringBuilder sb2 = new StringBuilder(it.next());
        while (it.hasNext()) {
            sb2.append(", ");
            sb2.append(it.next());
        }
        return sb2.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AFc1dSDK aFc1dSDK = (AFc1dSDK) obj;
        if (this.AFInAppEventParameterName == aFc1dSDK.AFInAppEventParameterName && this.values == aFc1dSDK.values && this.AFKeystoreWrapper.equals(aFc1dSDK.AFKeystoreWrapper) && this.valueOf.equals(aFc1dSDK.valueOf)) {
            return this.AFInAppEventType.equals(aFc1dSDK.AFInAppEventType);
        }
        return false;
    }

    @NonNull
    public Body getBody() {
        return this.AFKeystoreWrapper;
    }

    public List<String> getHeaderField(@NonNull String str) {
        for (String next : this.valueOf.keySet()) {
            if (next != null && next.equalsIgnoreCase(str)) {
                return this.valueOf.get(next);
            }
        }
        return null;
    }

    public int getStatusCode() {
        return this.AFInAppEventParameterName;
    }

    public int hashCode() {
        return (((((((this.AFKeystoreWrapper.hashCode() * 31) + this.AFInAppEventParameterName) * 31) + (this.values ? 1 : 0)) * 31) + this.valueOf.hashCode()) * 31) + this.AFInAppEventType.hashCode();
    }

    public boolean isSuccessful() {
        return this.values;
    }
}
