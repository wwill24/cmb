package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;

final class h extends NetworkConnectionInfo {

    /* renamed from: a  reason: collision with root package name */
    private final NetworkConnectionInfo.NetworkType f38128a;

    /* renamed from: b  reason: collision with root package name */
    private final NetworkConnectionInfo.MobileSubtype f38129b;

    static final class b extends NetworkConnectionInfo.a {

        /* renamed from: a  reason: collision with root package name */
        private NetworkConnectionInfo.NetworkType f38130a;

        /* renamed from: b  reason: collision with root package name */
        private NetworkConnectionInfo.MobileSubtype f38131b;

        b() {
        }

        public NetworkConnectionInfo a() {
            return new h(this.f38130a, this.f38131b);
        }

        public NetworkConnectionInfo.a b(NetworkConnectionInfo.MobileSubtype mobileSubtype) {
            this.f38131b = mobileSubtype;
            return this;
        }

        public NetworkConnectionInfo.a c(NetworkConnectionInfo.NetworkType networkType) {
            this.f38130a = networkType;
            return this;
        }
    }

    public NetworkConnectionInfo.MobileSubtype b() {
        return this.f38129b;
    }

    public NetworkConnectionInfo.NetworkType c() {
        return this.f38128a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkConnectionInfo)) {
            return false;
        }
        NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
        NetworkConnectionInfo.NetworkType networkType = this.f38128a;
        if (networkType != null ? networkType.equals(networkConnectionInfo.c()) : networkConnectionInfo.c() == null) {
            NetworkConnectionInfo.MobileSubtype mobileSubtype = this.f38129b;
            if (mobileSubtype == null) {
                if (networkConnectionInfo.b() == null) {
                    return true;
                }
            } else if (mobileSubtype.equals(networkConnectionInfo.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10;
        NetworkConnectionInfo.NetworkType networkType = this.f38128a;
        int i11 = 0;
        if (networkType == null) {
            i10 = 0;
        } else {
            i10 = networkType.hashCode();
        }
        int i12 = (i10 ^ 1000003) * 1000003;
        NetworkConnectionInfo.MobileSubtype mobileSubtype = this.f38129b;
        if (mobileSubtype != null) {
            i11 = mobileSubtype.hashCode();
        }
        return i12 ^ i11;
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f38128a + ", mobileSubtype=" + this.f38129b + "}";
    }

    private h(NetworkConnectionInfo.NetworkType networkType, NetworkConnectionInfo.MobileSubtype mobileSubtype) {
        this.f38128a = networkType;
        this.f38129b = mobileSubtype;
    }
}
