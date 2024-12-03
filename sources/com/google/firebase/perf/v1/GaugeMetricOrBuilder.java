package com.google.firebase.perf.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.l0;
import com.google.protobuf.m0;
import java.util.List;

public interface GaugeMetricOrBuilder extends m0 {
    AndroidMemoryReading getAndroidMemoryReadings(int i10);

    int getAndroidMemoryReadingsCount();

    List<AndroidMemoryReading> getAndroidMemoryReadingsList();

    CpuMetricReading getCpuMetricReadings(int i10);

    int getCpuMetricReadingsCount();

    List<CpuMetricReading> getCpuMetricReadingsList();

    /* synthetic */ l0 getDefaultInstanceForType();

    GaugeMetadata getGaugeMetadata();

    String getSessionId();

    ByteString getSessionIdBytes();

    boolean hasGaugeMetadata();

    boolean hasSessionId();

    /* synthetic */ boolean isInitialized();
}
