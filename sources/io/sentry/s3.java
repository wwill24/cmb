package io.sentry;

import j$.time.Instant;

public final class s3 extends u2 {

    /* renamed from: a  reason: collision with root package name */
    private final Instant f31627a;

    public s3() {
        this(Instant.now());
    }

    public long h() {
        return g.m(this.f31627a.getEpochSecond()) + ((long) this.f31627a.getNano());
    }

    public s3(Instant instant) {
        this.f31627a = instant;
    }
}
