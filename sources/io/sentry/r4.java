package io.sentry;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class r4 {

    /* renamed from: a  reason: collision with root package name */
    private final Boolean f31614a;

    /* renamed from: b  reason: collision with root package name */
    private final Double f31615b;

    /* renamed from: c  reason: collision with root package name */
    private final Boolean f31616c;

    /* renamed from: d  reason: collision with root package name */
    private final Double f31617d;

    public r4(Boolean bool) {
        this(bool, (Double) null);
    }

    public Boolean a() {
        return this.f31616c;
    }

    public Double b() {
        return this.f31615b;
    }

    public Boolean c() {
        return this.f31614a;
    }

    public r4(Boolean bool, Double d10) {
        this(bool, d10, Boolean.FALSE, (Double) null);
    }

    public r4(Boolean bool, Double d10, Boolean bool2, Double d11) {
        this.f31614a = bool;
        this.f31615b = d10;
        this.f31616c = Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
        this.f31617d = d11;
    }
}
