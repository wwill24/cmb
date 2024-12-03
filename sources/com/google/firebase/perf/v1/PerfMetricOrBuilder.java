package com.google.firebase.perf.v1;

import com.google.protobuf.l0;
import com.google.protobuf.m0;

public interface PerfMetricOrBuilder extends m0 {
    ApplicationInfo getApplicationInfo();

    /* synthetic */ l0 getDefaultInstanceForType();

    GaugeMetric getGaugeMetric();

    NetworkRequestMetric getNetworkRequestMetric();

    TraceMetric getTraceMetric();

    TransportInfo getTransportInfo();

    boolean hasApplicationInfo();

    boolean hasGaugeMetric();

    boolean hasNetworkRequestMetric();

    boolean hasTraceMetric();

    boolean hasTransportInfo();

    /* synthetic */ boolean isInitialized();
}
