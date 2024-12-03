package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendResponse;

final class a extends BackendResponse {

    /* renamed from: a  reason: collision with root package name */
    private final BackendResponse.Status f38137a;

    /* renamed from: b  reason: collision with root package name */
    private final long f38138b;

    a(BackendResponse.Status status, long j10) {
        if (status != null) {
            this.f38137a = status;
            this.f38138b = j10;
            return;
        }
        throw new NullPointerException("Null status");
    }

    public long b() {
        return this.f38138b;
    }

    public BackendResponse.Status c() {
        return this.f38137a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        BackendResponse backendResponse = (BackendResponse) obj;
        if (!this.f38137a.equals(backendResponse.c()) || this.f38138b != backendResponse.b()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j10 = this.f38138b;
        return ((this.f38137a.hashCode() ^ 1000003) * 1000003) ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f38137a + ", nextRequestWaitMillis=" + this.f38138b + "}";
    }
}
