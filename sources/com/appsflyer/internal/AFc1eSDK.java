package com.appsflyer.internal;

import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class AFc1eSDK {
    final String AFKeystoreWrapper;
    final String valueOf;

    public AFc1eSDK(String str, String str2) {
        j.g(str, "");
        j.g(str2, "");
        this.valueOf = str;
        this.AFKeystoreWrapper = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFc1eSDK)) {
            return false;
        }
        AFc1eSDK aFc1eSDK = (AFc1eSDK) obj;
        return j.b(this.valueOf, aFc1eSDK.valueOf) && j.b(this.AFKeystoreWrapper, aFc1eSDK.AFKeystoreWrapper);
    }

    public final int hashCode() {
        return (this.valueOf.hashCode() * 31) + this.AFKeystoreWrapper.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("HostConfig(prefix=");
        sb2.append(this.valueOf);
        sb2.append(", host=");
        sb2.append(this.AFKeystoreWrapper);
        sb2.append(PropertyUtils.MAPPED_DELIM2);
        return sb2.toString();
    }
}
