package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ClientInfo;

final class e extends ClientInfo {

    /* renamed from: a  reason: collision with root package name */
    private final ClientInfo.ClientType f38096a;

    /* renamed from: b  reason: collision with root package name */
    private final a f38097b;

    static final class b extends ClientInfo.a {

        /* renamed from: a  reason: collision with root package name */
        private ClientInfo.ClientType f38098a;

        /* renamed from: b  reason: collision with root package name */
        private a f38099b;

        b() {
        }

        public ClientInfo a() {
            return new e(this.f38098a, this.f38099b);
        }

        public ClientInfo.a b(a aVar) {
            this.f38099b = aVar;
            return this;
        }

        public ClientInfo.a c(ClientInfo.ClientType clientType) {
            this.f38098a = clientType;
            return this;
        }
    }

    public a b() {
        return this.f38097b;
    }

    public ClientInfo.ClientType c() {
        return this.f38096a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) obj;
        ClientInfo.ClientType clientType = this.f38096a;
        if (clientType != null ? clientType.equals(clientInfo.c()) : clientInfo.c() == null) {
            a aVar = this.f38097b;
            if (aVar == null) {
                if (clientInfo.b() == null) {
                    return true;
                }
            } else if (aVar.equals(clientInfo.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i10;
        ClientInfo.ClientType clientType = this.f38096a;
        int i11 = 0;
        if (clientType == null) {
            i10 = 0;
        } else {
            i10 = clientType.hashCode();
        }
        int i12 = (i10 ^ 1000003) * 1000003;
        a aVar = this.f38097b;
        if (aVar != null) {
            i11 = aVar.hashCode();
        }
        return i12 ^ i11;
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f38096a + ", androidClientInfo=" + this.f38097b + "}";
    }

    private e(ClientInfo.ClientType clientType, a aVar) {
        this.f38096a = clientType;
        this.f38097b = aVar;
    }
}
