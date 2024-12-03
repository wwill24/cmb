package com.google.firebase.perf.v1;

import com.google.protobuf.l0;
import com.google.protobuf.m0;

public interface CpuMetricReadingOrBuilder extends m0 {
    long getClientTimeUs();

    /* synthetic */ l0 getDefaultInstanceForType();

    long getSystemTimeUs();

    long getUserTimeUs();

    boolean hasClientTimeUs();

    boolean hasSystemTimeUs();

    boolean hasUserTimeUs();

    /* synthetic */ boolean isInitialized();
}
