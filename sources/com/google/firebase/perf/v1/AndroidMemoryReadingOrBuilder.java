package com.google.firebase.perf.v1;

import com.google.protobuf.l0;
import com.google.protobuf.m0;

public interface AndroidMemoryReadingOrBuilder extends m0 {
    long getClientTimeUs();

    /* synthetic */ l0 getDefaultInstanceForType();

    int getUsedAppJavaHeapMemoryKb();

    boolean hasClientTimeUs();

    boolean hasUsedAppJavaHeapMemoryKb();

    /* synthetic */ boolean isInitialized();
}
