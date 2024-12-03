package io.sentry;

import org.jetbrains.annotations.ApiStatus;

public interface m0 {
    boolean a();

    void b();

    void c(String str);

    @ApiStatus.Experimental
    p4 f();

    @ApiStatus.Internal
    boolean g(u2 u2Var);

    String getDescription();

    @ApiStatus.Internal
    u2 getStartDate();

    SpanStatus getStatus();

    void h(SpanStatus spanStatus);

    @ApiStatus.Internal
    m0 i(String str, String str2, u2 u2Var, Instrumenter instrumenter);

    void j(String str, Number number, MeasurementUnit measurementUnit);

    j4 m();

    @ApiStatus.Internal
    u2 n();

    void o(SpanStatus spanStatus, u2 u2Var);
}
