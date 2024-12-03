package com.google.android.datatransport.runtime.backends;

public abstract class BackendResponse {

    public enum Status {
        f38132a,
        TRANSIENT_ERROR,
        FATAL_ERROR,
        INVALID_PAYLOAD
    }

    public static BackendResponse a() {
        return new a(Status.FATAL_ERROR, -1);
    }

    public static BackendResponse d() {
        return new a(Status.INVALID_PAYLOAD, -1);
    }

    public static BackendResponse e(long j10) {
        return new a(Status.f38132a, j10);
    }

    public static BackendResponse f() {
        return new a(Status.TRANSIENT_ERROR, -1);
    }

    public abstract long b();

    public abstract Status c();
}
