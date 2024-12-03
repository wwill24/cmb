package com.appsflyer.internal;

public class AFc1jSDK {
    public final long values;

    public AFc1jSDK(long j10) {
        this.values = j10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.values == ((AFc1jSDK) obj).values) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.values;
        return (int) (j10 ^ (j10 >>> 32));
    }
}
